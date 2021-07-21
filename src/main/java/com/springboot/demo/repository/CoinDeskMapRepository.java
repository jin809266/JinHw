package com.springboot.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.demo.entity.CoinDeskMap;

@Repository
public interface CoinDeskMapRepository extends JpaRepository<CoinDeskMap, Integer> {
	Optional<CoinDeskMap> findByCoinCode(String coinCode);
}
