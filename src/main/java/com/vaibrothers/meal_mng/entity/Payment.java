package com.vaibrothers.meal_mng.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date paymentDate;

    @ManyToOne
    @JoinColumn(name = "payment_by", nullable = false)
    private User paymentBy;

    private Double paymentMoney;

    @ManyToOne
    @JoinColumn(name = "created_by", nullable = false)
    private User cratedBy;


}
