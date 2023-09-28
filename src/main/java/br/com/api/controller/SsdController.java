package br.com.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import br.com.api.auth.JWTTokenHelper;
import br.com.api.controller.extension.SsdControllerExtension;
import br.com.api.enume.CategoryEnum;
import br.com.api.persistence.SsdPersistenceService;
import br.com.api.search.SearchSsd;
import br.com.api.storage.BuildFileLinkSsd;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import br.com.api.entity.Category;
import br.com.api.entity.Ssd;
import br.com.api.service.SsdService;


import static org.springframework.http.ResponseEntity.*;


//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/ssd")
public class SsdController {

    private final JWTTokenHelper jwtTokenHelper;

    private final SsdService ssdService;

    private final BuildFileLinkSsd buildFileLink;

    private final SsdPersistenceService ssdPersistenceService;

    private final SearchSsd searchSsd;

    public SsdController(JWTTokenHelper jwtTokenHelper, SearchSsd searchSsd, SsdService ssdService, BuildFileLinkSsd buildFileLink, SsdPersistenceService ssdPersistenceService) {
        this.jwtTokenHelper = jwtTokenHelper;
        this.ssdService = ssdService;
        this.buildFileLink = buildFileLink;
        this.ssdPersistenceService = ssdPersistenceService;
        this.searchSsd = searchSsd;
    }

    @PostMapping
    public ResponseEntity<String> saveSsd(MultipartFile file, Ssd ssd, Category category) {

        try {
            ssdPersistenceService.SsdPersistence(file, ssd, category);
            return status(HttpStatus.OK)
                    .body(String.format("Cadastro realizado com sucesso.: %s", file.getOriginalFilename()));
        } catch (Exception e) {
            return status(HttpStatus.OK)
                    .body(String.format("Falha no cadastro: %s", file.getOriginalFilename()));
        }
    }

    @GetMapping
    public List<Ssd> listSsd() {
        return ssdService.listAllSsd().stream().map(buildFileLink::linkFile).collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateSsd(String id, MultipartFile file, Ssd ssd, Category category) throws Exception {

        try {
            Long convertStringToLong = Long.parseLong(id);
            ssd.setId(convertStringToLong);
        } catch (NumberFormatException e) {
            System.out.println("Alguns dados ainda podem conter Strings." + e.getMessage());
        }
        try {
            category.setProductCategory(CategoryEnum.SSD.name());
            this.ssdService.update(ssd, file, category);
            return ResponseEntity.status(HttpStatus.OK).body(String.format("Atualizado com sucesso!"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(String.format("Erro durante a atualização."));
        }
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteSsd(@PathVariable Long id) throws Exception {
        try {
            ssdService.deleteProduct(id);
            return HttpStatus.OK;
        } catch (Exception e) {
            return HttpStatus.BAD_REQUEST;
        }
    }

    @GetMapping("/redirect/{param}")
    public ResponseEntity<?> newResources(@PathVariable String param) throws Exception {
        SsdControllerExtension sec = new SsdControllerExtension(jwtTokenHelper);

        if ("list".equals(param)) {
            List<String> list = sec.listDayOfSale();
            return ResponseEntity.status(HttpStatus.OK).body(list);
        } else {
            try {
                Long id = Long.parseLong(param);
                Ssd ssd = sec.searchForId(id);
                if (ssd != null) {
                    return ResponseEntity.status(HttpStatus.OK).body(ssd);
                } else {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nada encontrado para o ID: " + id);
                }
            } catch (NumberFormatException ex) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Parâmetro inválido: " + param);
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao processar a solicitação");
            }
        }
    }

}