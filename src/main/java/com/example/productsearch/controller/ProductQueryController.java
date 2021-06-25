package com.example.productsearch.controller;

import com.example.productsearch.dto.MobileHandSet;
import com.example.productsearch.dto.SearchCriteriaMobileHandset;
import com.example.productsearch.dto.SearchResponse;
import com.example.productsearch.service.ProductSearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

/**
 * @author Ramesh.Yaleru on 6/24/2021
 */
@RestController
@RequestMapping("/mobile")
@Slf4j
public class ProductQueryController {

    private final ProductSearchService productSearchService;

    ProductQueryController(ProductSearchService productSearchService){
        this.productSearchService = productSearchService;
    }

    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam(required = false) Integer priceEur,
                                                             @RequestParam(required = false) String sim,
                                                             @RequestParam(required = false) String announceDate,
                                                             @RequestParam(required = false) Integer price,
                                                             @RequestParam(required = false) String audioJack,
                                                             @RequestParam(required = false) String gps,
                                                             @RequestParam(required = false) String battery,
                                                             @RequestParam(required = false) String brand,
                                                             @RequestParam(required = false) String phone,
                                                             @RequestParam(required = false) String picture,
                                                             @RequestParam(required = false) String resolution,
                                                             @RequestParam(required = false) Long id) {
        log.info("start :: ProductQueryController : search criteria  priceEur ={}", priceEur);

        //#1. Construct search criteria using Builder pattern
        SearchCriteriaMobileHandset searchCriteria = SearchCriteriaMobileHandset.builder()
                                                    .priceEur(priceEur != null ? priceEur: price)
                                                    .announceDate(announceDate).sim(sim)
                                                    .battery(battery).audioJack(audioJack)
                                                    .gps(gps).price(price)
                                                    .brand(brand)
                                                    .resolution(resolution)
                                                    .picture(picture)
                                                    .phone(phone)
                                                    .id(id)
                                                    .build();

        //#2. invoke service
        List<MobileHandSet> mobileHandSets = productSearchService.search(searchCriteria);

        SearchResponse response=  SearchResponse.builder()
                .message(null != mobileHandSets && mobileHandSets.size()>0 ? null : "No data found the provided search criteria.")
                .mobileHandSets(mobileHandSets)
                .build();
        if(null != mobileHandSets && mobileHandSets .size() >0)
            return new ResponseEntity<>(response, HttpStatus.OK);
        //#3. prepare a response
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
