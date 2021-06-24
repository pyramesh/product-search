package com.example.productsearch.controller;

import com.example.productsearch.dto.MobileHandSet;
import com.example.productsearch.dto.SearchCriteriaMobileHandset;
import com.example.productsearch.helper.PredicateSearchResolver;
import com.example.productsearch.service.ProductSearchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author Ramesh.Yaleru on 6/24/2021
 */
@RestController
@RequestMapping("/mobile")
@Slf4j
@RequiredArgsConstructor
public class ProductQueryController {


    private ProductSearchService productSearchService;

    @GetMapping("/search")
    public ResponseEntity<List<MobileHandSet>> search(@RequestParam(required = false) Integer priceEur,
                                                             @RequestParam(required = false) String sim,
                                                             @RequestParam(required = false) String announceDate,
                                                             @RequestParam(required = false) Integer price,
                                                             @RequestParam(required = false) String audioJack,
                                                             @RequestParam(required = false) String gps,
                                                             @RequestParam(required = false) String battery) {
        log.info("start :: ProductQueryController : search criteria  priceEur ={}", priceEur);

        //#1. Construct search criteria using Builder pattern
        SearchCriteriaMobileHandset searchCriteria = SearchCriteriaMobileHandset.builder()
                .priceEur(priceEur != null ? priceEur: price)
                .announceDate(announceDate)
                .sim(sim)
                .battery(battery)
                .audioJack(audioJack)
                .gps(gps)
                .price(price)
                .build();

        //#2. invoke service
        List<MobileHandSet> mobileHandSets = productSearchService.search(searchCriteria);

        //#3. prepare a response
        return new ResponseEntity<>(mobileHandSets, HttpStatus.OK);



    }
}
