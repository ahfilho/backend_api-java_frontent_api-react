package br.com.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.entity.Contact;
import br.com.api.service.SacService;

@RestController
@RequestMapping("/sac")
public class SacController {

    @Autowired
    private SacService service;

    @PostMapping
    public ResponseEntity<Contact> sacSave(@RequestBody Contact contact) {
        return ResponseEntity.ok().body(this.service.saveSac(contact));
    }

    @GetMapping
    public ResponseEntity<List<Contact>> sacList() {
        return ResponseEntity.ok().body(this.service.sacList());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contact> sacUpdate(@PathVariable Long id, @RequestBody Contact sac) throws Exception {
        sac.setId(id);
        return ResponseEntity.ok().body(this.service.sacUpdate(sac));

    }

    @DeleteMapping("/{id}")
    public HttpStatus sacDelete(@PathVariable Long id) throws Exception {
        this.service.delete(id);
        return HttpStatus.OK;
    }
}
