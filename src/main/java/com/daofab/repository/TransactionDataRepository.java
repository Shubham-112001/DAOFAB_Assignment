package com.daofab.repository;
/*
Author : shubham
*/


import com.daofab.model.TransactionData;

import java.util.List;

public interface TransactionDataRepository extends DaodabRepository<TransactionData, Long> {
    public List<TransactionData> findAllByUserDataId(long userDataId);
}
