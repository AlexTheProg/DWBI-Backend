package com.dwbi.dwbibackendv2.controller;

import com.dwbi.dwbibackendv2.controller.requests.InvoiceRequest;
import com.dwbi.dwbibackendv2.model.Invoice;
import com.dwbi.dwbibackendv2.service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/oltp")
@RequiredArgsConstructor
public class InvoiceController {
    private final InvoiceService invoiceService;

    @GetMapping("/invoices")
    public ResponseEntity<List<Invoice>> getAllInvoices() {
        return ResponseEntity.ok(invoiceService.getAllInvoices());
    }

    @GetMapping("/invoices/{id}")
    public ResponseEntity<Invoice> getInvoiceById(@PathVariable("id")Integer id) {
        return ResponseEntity.ok(invoiceService.getInvoiceById(id));
    }

    @PutMapping("/invoices/{id}")
    public ResponseEntity<Invoice> updateInvoice(@PathVariable("id")Integer id,
                                                 @RequestBody InvoiceRequest request) {
        return ResponseEntity.ok(invoiceService.updateInvoice(id, request));
    }

    @PostMapping("/invoices")
    public ResponseEntity<Invoice> addInvoice(@RequestBody InvoiceRequest request) {
        return ResponseEntity.ok(invoiceService.addInvoice(request));
    }

    @DeleteMapping("/invoices/{id}")
    public ResponseEntity<Invoice> deleteInvoice(@PathVariable("id")Integer id) {
        return ResponseEntity.ok(invoiceService.deleteInvoice(id));
    }
}
