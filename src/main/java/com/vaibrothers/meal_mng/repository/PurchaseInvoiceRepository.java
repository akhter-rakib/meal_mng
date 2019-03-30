package com.vaibrothers.meal_mng.repository;

import com.vaibrothers.meal_mng.entity.PurchaseInvoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PurchaseInvoiceRepository extends JpaRepository<PurchaseInvoice, Integer> {

    @Query("select purchase from PurchaseInvoice purchase where purchase.markedDate between :startDate and :endDate")
    public List<PurchaseInvoice> getDateWisePurchaseList(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
}
