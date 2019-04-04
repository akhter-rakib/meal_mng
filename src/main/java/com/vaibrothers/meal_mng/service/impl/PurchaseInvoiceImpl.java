package com.vaibrothers.meal_mng.service.impl;

import com.vaibrothers.meal_mng.entity.PurchaseInvoice;
import com.vaibrothers.meal_mng.repository.PurchaseInvoiceRepository;
import com.vaibrothers.meal_mng.service.interfaces.PurchaseInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PurchaseInvoiceImpl implements PurchaseInvoiceService {

    @Autowired
    PurchaseInvoiceRepository purchaseInvoiceRepository;

    @Override
    public PurchaseInvoice savePurchase(PurchaseInvoice purchaseInvoice) {
        return purchaseInvoiceRepository.save(purchaseInvoice);
    }

    @Override
    public List<PurchaseInvoice> list() {
        return purchaseInvoiceRepository.findAll();
    }

    @Override
    public List<PurchaseInvoice> getDateWisePurchaseList(Date startDate, Date endDate) {
        return purchaseInvoiceRepository.getDateWisePurchaseList(startDate, endDate);
    }

    @Override
    public PurchaseInvoice update(PurchaseInvoice purchaseInvoice) {
        return null;
    }

    @Override
    public List<PurchaseInvoice> getPaymentListByMonth() {
        return purchaseInvoiceRepository.getPurchasListByMonth();
    }
}
