package com.example.productsearch.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author Ramesh.Yaleru on 6/24/2021
 */
@Setter
@Getter
@Builder
@ToString
public class SearchCriteriaMobileHandset implements Serializable {
    private long id;
    private String brand;
    private String phone;
    private String picture;
    private String sim;
    private String resolution;
    private String announceDate;
    private Integer priceEur;
    private String audioJack;
    private String gps;
    private String battery;
    private Integer price;
}
