package com.dwbi.dwbibackendv2.controller;

import com.dwbi.dwbibackendv2.controller.requests.ClientRequest;
import com.dwbi.dwbibackendv2.model.Client;
import com.dwbi.dwbibackendv2.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/oltp")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @GetMapping("/clients")
    public ResponseEntity<List<Client>> getAllClients() {
        return ResponseEntity.ok(clientService.getAllClients());
    }

    @GetMapping("/clients/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable("id")Integer id) {
        return ResponseEntity.ok(clientService.getClientById(id));
    }

    @PostMapping("/clients")
    public ResponseEntity<Client> addClient(@RequestBody ClientRequest request) {
        return ResponseEntity.ok(clientService.addClient(request));
    }

    @PutMapping("/clients/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable("id")Integer id,
                                               @RequestBody ClientRequest request) {
        return ResponseEntity.ok(clientService.updateClient(id, request));
    }

    @DeleteMapping("/clients/{id}")
    public ResponseEntity<Client> deleteClient(@PathVariable("id")Integer id) {
        return ResponseEntity.ok(clientService.deleteClientById(id));
    }

}
