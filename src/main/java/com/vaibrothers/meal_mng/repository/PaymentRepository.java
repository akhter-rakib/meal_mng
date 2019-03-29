package com.vaibrothers.meal_mng.repository;

import com.vaibrothers.meal_mng.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

    @Query(value = "SELECT payment FROM Payment payment where payment.paymentDate between :startDate and :endDate")
    public List<Payment> getDateWisePaymetnList(@Param("startDate") Date startDate,
                                                @Param("endDate") Date endDate);
}
