package com.vaibrothers.meal_mng.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class PurchaseInvoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "market_by", nullable = false)
    private User marketBy;

    private Date markedDate;

    private Date createdOn;

    private Double totalCost;

    @ManyToOne
    @JoinColumn(name = "created_by", nullable = false)
    private User createdBy;


}
