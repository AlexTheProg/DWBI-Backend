package com.dwbi.dwbibackendv2.repo;

import com.dwbi.dwbibackendv2.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
