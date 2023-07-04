package com.daofab.service;

import com.daofab.model.TransactionData;
import com.daofab.model.UserData;
import com.daofab.repository.TransactionDataRepository;
import com.daofab.repository.UserDataRepository;
import com.daofab.response.TransactionDataResponse;
import com.daofab.response.UserDataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/*
Author : shubham
*/
@Service
public class TransactionDataService {
    @Autowired
    TransactionDataRepository transactionDataRepository;
    @Autowired
    UserDataRepository userDataRepository;

    public TransactionData addUserData(TransactionDataResponse transactionDataResponse) {
        TransactionData transactionData =  new TransactionData();
        transactionData.setUserDataId(transactionData.getUserDataId());
        transactionData.setPaidAmount(transactionData.getPaidAmount());
        return transactionDataRepository.save(transactionData);
    }

    public TransactionDataResponse response(TransactionData transactionData) {
        TransactionDataResponse transactionDataResponse = new TransactionDataResponse();
        transactionDataResponse.setId(transactionData.getId());
        transactionDataResponse.setPaidAmount(transactionData.getPaidAmount());
        transactionDataResponse.setUserDataId(transactionData.getUserDataId());
        UserData userData = userDataRepository.findById(transactionData.getUserDataId()).get();
        if (Objects.nonNull(userData)){
            transactionDataResponse.setReceiverName(userData.getReceiverName());
            transactionDataResponse.setSenderName(userData.getSenderName());
            transactionDataResponse.setTotalAmount(userData.getTotalAmount());
        }
        return transactionDataResponse;
    }

    public List<TransactionDataResponse> getAllUserData(long id) {
        List<TransactionDataResponse> transactionDataResponses = new ArrayList<>();
        List<TransactionData> transactionDataList = transactionDataRepository.findAllByUserDataId(id);
        for (TransactionData transactionData: transactionDataList) {
            transactionDataResponses.add(response(transactionData));
        }
        return transactionDataResponses;
    }
}
