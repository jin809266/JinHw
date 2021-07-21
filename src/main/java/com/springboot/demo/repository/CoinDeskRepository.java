package com.springboot.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.demo.entity.CoinDesk;

@Repository
public interface CoinDeskRepository extends JpaRepository<CoinDesk, Integer> {
	Optional<CoinDesk> findByCoinCode(String coinCode);
}
