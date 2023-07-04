package com.daofab.repository;
/*
Author : shubham
*/

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@NoRepositoryBean
public interface DaodabRepository<T, ID> extends JpaSpecificationExecutor<T>,JpaRepository<T, ID>, PagingAndSortingRepository<T, ID> {
}
