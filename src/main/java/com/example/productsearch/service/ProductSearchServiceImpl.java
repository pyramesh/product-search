package com.example.productsearch.service;

import com.example.exception.ProductSearchException;
import com.example.productsearch.dto.MobileHandSet;
import com.example.productsearch.dto.SearchCriteriaMobileHandset;
import com.example.productsearch.external.ExternalServiceFacade;
import com.example.productsearch.helper.PredicateSearchResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author Ramesh.Yaleru on 6/24/2021
 */
@Service
@Slf4j
public class ProductSearchServiceImpl  implements ProductSearchService{

    private final PredicateSearchResolver predicateSearchResolver;
    private final ExternalServiceFacade externalServiceFacade;

    ProductSearchServiceImpl(PredicateSearchResolver predicateSearchResolver, ExternalServiceFacade externalServiceFacade){
        this.predicateSearchResolver = predicateSearchResolver;
        this.externalServiceFacade = externalServiceFacade;
    }

    @Override
    public List<MobileHandSet> search(SearchCriteriaMobileHandset searchCriteria) {
        log.info("start :: ProductSearchServiceImpl : search  with criteria ={}", searchCriteria);
        List<MobileHandSet> filteredList = new ArrayList<>();
        try {
            //Resolve predicate based on the search criteria
            List<Predicate<MobileHandSet>> predicates = predicateSearchResolver.resolve(searchCriteria);

            //Call external service and load the data Since it is static data, loaded only once
            List<MobileHandSet> mobileHandSets = externalServiceFacade.loadServiceResponseStaticData();

            //#3. Filter the response according to matched predicates
            filteredList = mobileHandSets.stream()
                    .filter(predicates.stream()
                            .reduce(x -> true, Predicate::and))
                    .collect(Collectors.toList());
        }catch (Exception exp){
            log.error("exception occurred while searching product  error ={}", exp);
            throw new ProductSearchException("something went wrong. Please try again.");
        }
        log.info("filtered response Size={}", filteredList.size());
        log.debug("filtered response ={}", filteredList);
        log.info("end :: ProductSearchServiceImpl : search with response ={} ", filteredList.size());
         return  filteredList;
    }
}
