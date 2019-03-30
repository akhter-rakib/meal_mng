package com.vaibrothers.meal_mng.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private User member;

    private Double quantity;

    private Date meal_date;

    private Date createOn;

    @ManyToOne
    @JoinColumn(name = "created_by", nullable = false)
    private User cratedBy;
}
