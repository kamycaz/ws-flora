package com.zopitek.flora.service.imp;

import com.zopitek.flora.entity.params.CodInvoice;
import com.zopitek.flora.model.projection.CodInvoiceResponse;
import com.zopitek.flora.repository.CodInvoiceRepository;
import com.zopitek.flora.service.CodInvoiceService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CodInvoiceImp implements CodInvoiceService {

    @Autowired
    private CodInvoiceRepository codInvoiceRepository;

    @Override
    @Transactional
    public String findCodByYear() throws Exception {
        try {
            String code = "";
            Date dt=new Date();
            int currentYear=dt.getYear() + 1900;
            System.out.println("antes del finfd");
           CodInvoiceResponse codInvoiceResponse = codInvoiceRepository.findByYear(currentYear);
           if(codInvoiceResponse != null) {
               System.out.println("despues del find");
               int newCount = codInvoiceResponse.getCount()+1;
               code = currentYear + "-" + newCount;
               codInvoiceRepository.sumCount(currentYear, codInvoiceResponse.getCount()+1);
               System.out.println("despues del sum");
               return code;
           } else {
            CodInvoice codInvoice = new CodInvoice(null, currentYear, 1);
            code = currentYear + "-" + "1";
            codInvoiceRepository.save(codInvoice);
            return code;
           }

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
