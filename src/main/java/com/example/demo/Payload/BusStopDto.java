package com.example.demo.Payload;

import com.example.demo.entity.Bus;
import com.example.demo.entity.Stop;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

public class BusStopDto {

    private Long id;


    private Stop stop;


    private Bus bus;

    private Integer stopOrder;

}