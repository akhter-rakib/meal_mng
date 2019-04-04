package com.vaibrothers.meal_mng.service.interfaces;

import com.vaibrothers.meal_mng.entity.PurchaseInvoice;

import java.util.Date;
import java.util.List;

public interface PurchaseInvoiceService {
    public PurchaseInvoice savePurchase(PurchaseInvoice purchaseInvoice);

    public List<PurchaseInvoice> list();

    public List<PurchaseInvoice> getDateWisePurchaseList(Date startDate, Date endDate);

    public PurchaseInvoice update(PurchaseInvoice purchaseInvoice);

    public List<PurchaseInvoice> getPaymentListByMonth();
}
