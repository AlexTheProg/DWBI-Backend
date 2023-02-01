package com.dwbi.dwbibackendv2.service;

import com.dwbi.dwbibackendv2.controller.requests.ClientRequest;
import com.dwbi.dwbibackendv2.model.Client;
import com.dwbi.dwbibackendv2.repo.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }

    public Client getClientById(Integer id){
        return clientRepository.findById(id).orElse(null);
    }

    public Client deleteClientById(Integer id){
        Optional<Client> clientOptional = clientRepository.findById(id);
        if (clientOptional.isPresent()) {
            clientRepository.deleteById(id);
            return clientOptional.get();
        }
        return null;
    }

    public Client addClient(ClientRequest addRequest){
        Client client = Client.builder()
                .firstName(addRequest.getFirstName())
                .lastName(addRequest.getLastName())
                .rating(addRequest.getRating())
                .phoneNumber(addRequest.getPhoneNumber())
                .username(addRequest.getUsername())
                .password(addRequest.getPassword())
                .email(addRequest.getEmail())
                .build();
        clientRepository.save(client);
        return client;
    }

    public Client updateClient(Integer id, ClientRequest updateRequest){
        Client client = clientRepository.findById(id).orElse(null);

        if (client != null) {
             client = Client.builder()
                    .firstName(updateRequest.getFirstName())
                    .lastName(updateRequest.getLastName())
                    .rating(updateRequest.getRating())
                    .phoneNumber(updateRequest.getPhoneNumber())
                    .username(updateRequest.getUsername())
                    .password(updateRequest.getPassword())
                    .email(updateRequest.getEmail())
                    .build();
             client.setId(id);
            clientRepository.save(client);
            return client;
        }
        return null;
    }
}
