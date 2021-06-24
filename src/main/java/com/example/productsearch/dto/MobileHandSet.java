package com.example.productsearch.dto;

import lombok.*;

import java.io.Serializable;

/**
 * @author Ramesh.Yaleru on 6/24/2021
 */
@Data
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class MobileHandSet implements Serializable {
    private Long id;
    private String brand;
    private String phone;
    private String picture;
    private String sim;
    private String resolution;
    private Hardware hardware;
    private Release release;

}

