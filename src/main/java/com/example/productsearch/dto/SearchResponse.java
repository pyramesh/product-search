package com.example.productsearch.dto;

import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * @author Ramesh.Yaleru on 6/25/2021
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchResponse implements Serializable {
    private String message;
    private List<MobileHandSet> mobileHandSets;
}
