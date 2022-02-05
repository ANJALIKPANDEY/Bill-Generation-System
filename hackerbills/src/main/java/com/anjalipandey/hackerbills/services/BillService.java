package com.anjalipandey.hackerbills.services;

import com.anjalipandey.hackerbills.dto.BillDetailsDTO;

import java.util.Date;

/**
 * Billing service interface
 */
public interface BillService {

    public BillDetailsDTO createBills(BillDetailsDTO billDetailsDTO);
    public BillDetailsDTO getBills(int billNumber);
    public BillDetailsDTO getBillsByDueDate(String dueDate);
}
