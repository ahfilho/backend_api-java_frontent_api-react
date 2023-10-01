package br.com.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import br.com.api.entity.CpuCategory;
import br.com.api.enume.CategoryEnum;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.api.entity.Ram;
import br.com.api.service.RamService;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/ram")
public class RamController {

    @Autowired
    private RamService ramService;

    @PostMapping("/new")
    public ResponseEntity<String> ramSave(@RequestParam("file") MultipartFile file, Ram ram, CpuCategory cpuCategory) {

        try {
//            cpuCategory.setProductCategory(CategoryEnum.RAM.name());
            ramService.ramSave(ram, file, cpuCategory);

            return ResponseEntity.status(HttpStatus.OK)
                    .body(String.format("Produto %s", file.getOriginalFilename() + "cadastrado com sucesso!"));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(String.format("Falha no cadastro: %s", file.getOriginalFilename()));
        }
    }

    @GetMapping("/list")
    public List<Ram> ramList() {
        return this.ramService.ramList().stream().map(this::linkImgRam).collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ram> ramUpdate(@PathVariable Long id, @NotNull @RequestBody Ram ram) throws Exception {
        ram.setId(id);
        return ResponseEntity.ok().body(this.ramService.ramUpdate(ram));
    }

    @DeleteMapping("/{id}")
    public HttpStatus ramDelete(@PathVariable Long id) throws Exception {
        this.ramService.delete(id);
        return HttpStatus.OK;
    }

    private Ram linkImgRam(Ram ram) {
        long r1 = ram.getId();
        String linkRam = ServletUriComponentsBuilder.fromCurrentContextPath().path("/files/").path(Long.toString(r1)).toUriString();
        ram.setId(ram.getId());
        ram.setUrl(linkRam);
        return ram;
    }

}
