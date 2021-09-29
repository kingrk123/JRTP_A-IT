package com.ashokit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.entity.CountryMasterEntity;

public interface CountryMasterRepository extends JpaRepository<CountryMasterEntity, Integer> {

}
