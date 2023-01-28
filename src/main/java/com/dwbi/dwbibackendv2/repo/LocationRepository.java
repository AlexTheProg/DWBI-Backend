package com.dwbi.dwbibackendv2.repo;

import com.dwbi.dwbibackendv2.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Integer> {
}
