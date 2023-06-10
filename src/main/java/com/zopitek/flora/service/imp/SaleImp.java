package com.zopitek.flora.service.imp;


import com.zopitek.flora.entity.Client;
import com.zopitek.flora.entity.Product;
import com.zopitek.flora.entity.Sale;
import com.zopitek.flora.entity.SaleLine;
import com.zopitek.flora.model.forms.SaleForm;
import com.zopitek.flora.model.forms.SaleLineForm;
import com.zopitek.flora.model.projection.SaleLineResponse;
import com.zopitek.flora.model.projection.SaleResponse;
import com.zopitek.flora.repository.SaleRepository;
import com.zopitek.flora.service.SaleService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class SaleImp implements SaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private CodInvoiceImp codInvoiceImp;


    @Override
    public List<SaleLineResponse> getSaleLines(Integer id) throws Exception {
        try {
            return saleRepository.findSalesLine(id);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public int save(SaleForm saleForm) throws Exception {
        try {
            Sale sale = new Sale();
            Client client = new Client();
            client.setId(saleForm.getId());
            sale.setClient(client);
            BigDecimal totalmainAmount = BigDecimal.valueOf(0);
            BigDecimal totalAmount = BigDecimal.valueOf(0);
            BigDecimal totaltaxAmount = BigDecimal.valueOf(0);
            ArrayList<SaleLine> saleLines = new ArrayList<>();
            for (SaleLineForm line : saleForm.getLines()) {
                SaleLine saleLine = new SaleLine();
                Product product = new Product();
                product.setId(line.getId());
                saleLine.setProduct(product);
                saleLine.setQuantity(line.getQuantity());
                saleLine.setPrize(line.getPrize());
                saleLine.setIva(line.getIva());
                saleLine.setDiscount(line.getDiscount());
                BigDecimal taxAmount = (BigDecimal.valueOf(line.getQuantity()).multiply(line.getPrize()).multiply(BigDecimal.valueOf(line.getIva()))).divide(BigDecimal.valueOf(100));
                totaltaxAmount = totaltaxAmount.add(taxAmount);
                BigDecimal mainAmount = (BigDecimal.valueOf(line.getQuantity()).multiply(line.getPrize()));
                totalmainAmount = totalmainAmount.add(mainAmount);
                BigDecimal amount = mainAmount.add(taxAmount);
                totalAmount = totalAmount.add(amount);
                saleLine.setTotalAmount(amount);
                saleLines.add(saleLine);
            }
            sale.setLines(saleLines);
            sale.setMainAmount(totalmainAmount);
            sale.setTaxAmount(totaltaxAmount);
            sale.setTotalAmount(totalAmount);
            sale.setCodInvoice(codInvoiceImp.findCodByYear());
            sale.setPaid(false);
            saleRepository.save(sale);
           return 1;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    @Override
    public List<SaleResponse> getSaleList(Integer id) throws Exception {
        try {
            return saleRepository.findSalesClient(id);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<SaleResponse> getSales() throws Exception {
        try {
            return saleRepository.findSales();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void setPaid(Integer id) throws Exception {
        saleRepository.setPaid(id);
    }
}
