package com.zopitek.flora.service;

import com.zopitek.flora.entity.params.CodInvoice;
import com.zopitek.flora.model.projection.CodInvoiceResponse;
import com.zopitek.flora.repository.CodInvoiceRepository;

public interface CodInvoiceService {

    public String findCodByYear() throws Exception;
}
