package com.demo.i18n.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.demo.i18n.model.CoffeeJson;

@Repository
public interface CoffeeJsonRepository   extends PagingAndSortingRepository<CoffeeJson, Long>{

}
