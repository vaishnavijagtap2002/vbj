package com.example.demo.repository;

import com.example.demo.Payload.BusStopDto;
import com.example.demo.entity.BusStop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusStopRepository extends JpaRepository<BusStop, Long> {
 
}