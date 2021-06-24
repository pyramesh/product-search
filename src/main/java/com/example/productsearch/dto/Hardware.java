package com.example.productsearch.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author Ramesh.Yaleru on 6/24/2021
 */
@Data
@ToString
@EqualsAndHashCode
public class Hardware implements Serializable {
    private String audioJack;
    private String gps;
    private String battery;
}
