package com.dwbi.dwbibackendv2.repo;

import com.dwbi.dwbibackendv2.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
}
