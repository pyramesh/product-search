package com.example.productsearch.service;

import com.example.productsearch.dto.MobileHandSet;
import com.example.productsearch.dto.SearchCriteriaMobileHandset;

import java.util.List;

/**
 * @author Ramesh.Yaleru on 6/24/2021
 */
public interface ProductSearchService {

    List<MobileHandSet> search(SearchCriteriaMobileHandset searchCriteria);
}
