package com.anjalipandey.hackerbills.services;

import com.anjalipandey.hackerbills.dto.BillDetailsDTO;
import com.anjalipandey.hackerbills.entity.BillDetailsEntity;
import com.anjalipandey.hackerbills.exception.RecordNotFoundException;
import com.anjalipandey.hackerbills.repository.BillRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service class that implements all the required functions
 */
@Service
public class BillServiceImpl implements BillService {

    @Autowired
    BillRepository billRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public BillDetailsDTO createBills(BillDetailsDTO billDetailsDTO) throws RuntimeException{

        BillDetailsEntity billDetails = modelMapper.map(billDetailsDTO, BillDetailsEntity.class);
        billDetails.setTotalAmount(billDetails.getBilledAmount() + billDetails.getBillTax());
        billDetails = billRepository.save(billDetails);
        BillDetailsDTO billDetailsDTOResponse = modelMapper.map(billDetails, BillDetailsDTO.class);
        System.out.println(billDetailsDTOResponse.getBillNumber());
        return billDetailsDTOResponse;
    }

    @Override
    public BillDetailsDTO getBills(int billNumber) {

        Optional<BillDetailsEntity> billInfo = Optional.ofNullable(billRepository.findById(billNumber)
                .orElseThrow(() -> new RecordNotFoundException("Invalid Bill Number")));

        if (billInfo == null) throw new RuntimeException("Unable to locate the booking Id : " + billNumber);
        BillDetailsDTO billDetailsDTO = modelMapper.map(billInfo.get(), BillDetailsDTO.class);
        return billDetailsDTO;
    }

    @Override
    public BillDetailsDTO getBillsByDueDate(String dueDate) throws IllegalArgumentException {
        BillDetailsEntity billDetailsEntity = billRepository.findByBilledDate(dueDate);

        return modelMapper.map(billDetailsEntity, BillDetailsDTO.class);
    }
}
