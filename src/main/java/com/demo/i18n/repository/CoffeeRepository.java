package com.demo.i18n.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.i18n.model.Coffee;

@Repository
public interface CoffeeRepository  extends JpaRepository<Coffee, Long> {

}
