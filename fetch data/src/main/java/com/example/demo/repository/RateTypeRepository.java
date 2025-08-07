package com.example.demo.repository;

import com.example.demo.model.RateType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RateTypeRepository extends JpaRepository<RateType, Integer> {
}
