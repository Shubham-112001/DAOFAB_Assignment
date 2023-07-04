package com.daofab.service;

import com.daofab.model.TransactionData;
import com.daofab.model.UserData;
import com.daofab.repository.TransactionDataRepository;
import com.daofab.repository.UserDataRepository;
import com.daofab.response.UserDataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/*
Author : shubham
*/
@Service
public class UserDataService {
    @Autowired
    UserDataRepository userDataRepository;
    @Autowired
    TransactionDataRepository transactionDataRepository;
    public UserData addUserData(UserDataResponse userDataResponse){
        UserData userData=new UserData();
        userData.setId(userDataResponse.getId());
        userData.setReceiverName(userDataResponse.getReceiverName());
        userData.setSenderName(userData.getSenderName());
        userData.setTotalAmount(userData.getTotalAmount());
       return userDataRepository.save(userData);
    }
    public List<UserDataResponse> getAllUserData(Pageable pageable){
            List<UserDataResponse> userDataResponses =  new ArrayList<>();
        Page<UserData> userDataPage = userDataRepository.findAll(pageable);
        List<UserData> userDataList = userDataPage.getContent();
        if (Objects.nonNull(userDataList)){
            for (UserData userData:userDataList) {
                userDataResponses.add(response(userData));
            }
        }
        return userDataResponses;
    }
    public UserDataResponse response(UserData userData) {
        UserDataResponse userDataResponse = new UserDataResponse();
        userDataResponse.setId(userData.getId());
        userDataResponse.setReceiverName(userData.getReceiverName());
        userDataResponse.setSenderName(userData.getSenderName());
        userDataResponse.setTotalAmount(userData.getTotalAmount());
        List<TransactionData> allTransactionByUserDataId =
                transactionDataRepository.findAllByUserDataId(userData.getId());
        if (!CollectionUtils.isEmpty(allTransactionByUserDataId)) {
            long paidAmount =0;
            for (TransactionData transactionData:allTransactionByUserDataId) {
                paidAmount+= transactionData.getPaidAmount();
            }
            userDataResponse.setTotalPaidAmount(paidAmount);
        }
        return userDataResponse;
    }
}
