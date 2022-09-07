package br.com.api.controller;

import java.util.List;

import br.com.api.entity.Address;
import br.com.api.exceptions.ErrorHandling;
import io.restassured.mapper.ObjectMapper;
import io.restassured.mapper.ObjectMapperDeserializationContext;
import io.restassured.mapper.ObjectMapperSerializationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.api.entity.Client;
import br.com.api.service.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @ExceptionHandler
    @PostMapping
    public ResponseEntity<String> clientSave(@RequestBody Client client, Address address) {
        try {
            clientService.clientSave(client,address);
            return ResponseEntity.status(HttpStatus.OK).body(String.format("Cliente: " + client.getName() + " cadastrado com sucesso!"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.OK).body(String.format("Não foi possível cadastrar o cliente: " + client.getName() + "."));
        }
    }

    @ExceptionHandler
    @GetMapping
    public ResponseEntity<List<Client>> clientList() {
        return ResponseEntity.ok().body(this.clientService.clientList());

    }

    @ExceptionHandler
    @PutMapping("/{id}")
    public ResponseEntity<Client> clientUpdate(@PathVariable Long id, @RequestBody Client client)
            throws Exception {
        client.setId(id);
        return ResponseEntity.ok().body(this.clientService.clientUpdate(client));
    }

    @ExceptionHandler
    @DeleteMapping("/{id}")
    public HttpStatus clientDelete(@PathVariable Long id) throws Exception {
        this.clientService.clientDelete(id);
        return HttpStatus.OK;
    }
}
