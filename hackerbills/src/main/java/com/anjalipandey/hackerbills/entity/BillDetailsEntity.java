package com.anjalipandey.hackerbills.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Billing details entity class that contains the metadata of the bill
 */
@SuppressWarnings("ALL")
@Entity()
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bill")
public class BillDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "billNumber")
    private int billNumber;
    @Column(name = "billedTo")
    private String billedTo;
    @Column(name = "billedDate", nullable = false)
    private String billedDate;
    @Column(name = "billedAmount")
    private int billedAmount;
    @Column(name = "billTax")
    private int billTax;
    @Column(name = "totalAmount")
    private int totalAmount;

}
