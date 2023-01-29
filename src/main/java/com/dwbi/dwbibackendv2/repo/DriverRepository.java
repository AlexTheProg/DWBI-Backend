package com.dwbi.dwbibackendv2.repo;

import com.dwbi.dwbibackendv2.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.Set;

public interface DriverRepository extends JpaRepository<Driver, Integer> {
}
