package com.anjalipandey.hackerbills.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Billing details DTO class that contains the metadata of the bill
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BillDetailsDTO {

    private int billNumber;
    private String billedTo;
    private String billedDate;
    private int billedAmount;
    private int billTax;
    private int totalAmount;

}
