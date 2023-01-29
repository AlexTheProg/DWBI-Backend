package com.dwbi.dwbibackendv2.service;

import com.dwbi.dwbibackendv2.controller.requests.InvoiceRequest;
import com.dwbi.dwbibackendv2.model.Invoice;
import com.dwbi.dwbibackendv2.repo.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InvoiceService {
    private final InvoiceRepository invoiceRepository;

    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    public Invoice getInvoiceById(Integer id) {
        return invoiceRepository.findById(id).orElse(null);
    }

    public Invoice addInvoice(InvoiceRequest request) {
        Invoice invoice = Invoice.builder()
                .status(request.getStatus())
                .tips(request.getTips())
                .trip(request.getTrip())
                .paymentType(request.getPaymentType())
                .amountToPay(request.getAmountToPay())
                .build();
        invoiceRepository.save(invoice);
        return invoice;
    }

    public Invoice updateInvoice(Integer id, InvoiceRequest request) {
        Invoice invoice = invoiceRepository.findById(id).orElse(null);

        if (invoice != null) {
            invoice = Invoice.builder()
                    .status(request.getStatus())
                    .tips(request.getTips())
                    .trip(request.getTrip())
                    .paymentType(request.getPaymentType())
                    .amountToPay(request.getAmountToPay())
                    .build();
            invoiceRepository.save(invoice);
            return invoice;
        }
        return null;
    }

    public Invoice deleteInvoice(Integer id) {
        Invoice invoice = invoiceRepository.findById(id).orElse(null);

        if (invoice != null) {
            invoiceRepository.deleteById(id);
            return invoice;
        }
        return null;
    }
}
