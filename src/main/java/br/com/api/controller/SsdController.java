
package br.com.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import br.com.api.entity.File;
import br.com.api.enume.CategoryEnum;
import br.com.api.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.api.entity.Category;
import br.com.api.entity.Ssd;
import br.com.api.service.SsdService;

import static org.springframework.http.ResponseEntity.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/ssd")
public class SsdController {

    @Autowired
    private SsdService ssdService;
    @Autowired
    private CategoryRepository categoryRepository;


    //TODO FAZER O METODO DE ZERAR O FORM DEPOIS DE SALVAR. O OUTRO ESTAVA DANDO ERRADO, ZERAVA ANTES DE SALVAR.
    //TODO FAZER UM MODAL PARA ALGUM TELA
    //TODO BOOTSTRAP OFFCANVAS PARA MENU LATERAL
    //TODO COLOCAR QUANTIDADES NAS ENTITY
    @ExceptionHandler
    @PostMapping
    public ResponseEntity<String> ssdSave(@RequestParam("file") MultipartFile file,
                                          Ssd ssd, Category category) {
        try {
            category.setProductCategory(CategoryEnum.SSD.name());
            ssdService.saveProductFileCategory(ssd, file, category);
            return status(HttpStatus.OK)
                    .body(String.format("sucesso no cadastro: %s", file.getOriginalFilename()));
        } catch (Exception e) {
            return status(HttpStatus.OK)
                    .body(String.format("Falha no cadastro: %s", file.getOriginalFilename()));
        }
    }

    @GetMapping
    public List<Ssd> list() {
        return ssdService.listAllSsd().stream().map(this::linkImgSsd).collect(Collectors.toList());
    }

    private Ssd linkImgSsd(Ssd ssd) {
        long l1 = ssd.getId();
        String download = ServletUriComponentsBuilder.fromCurrentContextPath().path("/files/").path(Long.toString(l1))
                .toUriString();
        ssd.setId(ssd.getId());
        ssd.setUrl(download);
        return ssd;

    }

    @PutMapping("/{id}")
    public ResponseEntity<Ssd> updateSsd(@RequestParam("file") MultipartFile file,
                                         @PathVariable Long id, Ssd ssd, Category category) throws Exception {
        ssd.getId();

        return ResponseEntity.ok().body(this.ssdService.update(ssd, file, category));
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteProduct(@PathVariable Long id) throws Exception {
        try {
            ssdService.deleteProduct(id);
            File img = new File();
            return HttpStatus.OK;
        } catch (Exception e) {
            return HttpStatus.BAD_REQUEST;
        }
    }

    @GetMapping("/{id}")
    public Ssd searchForId(@PathVariable Long id) throws Exception {
        Ssd ssd = new Ssd();
        ssd.getId();
        return ssdService.searchId(id);
    }

}