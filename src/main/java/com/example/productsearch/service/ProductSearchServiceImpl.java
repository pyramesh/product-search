package com.example.productsearch.service;

import com.example.productsearch.dto.MobileHandSet;
import com.example.productsearch.dto.SearchCriteriaMobileHandset;
import com.example.productsearch.external.ExternalServiceFacade;
import com.example.productsearch.helper.PredicateSearchResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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

        //Resolve predicate based on the search criteria
        List<Predicate<MobileHandSet>> predicates = predicateSearchResolver.resolve(searchCriteria);

        //Call external service and load the data Since it is static data, loaded only once
        List<MobileHandSet> mobileHandSets = externalServiceFacade.loadServiceResponseStaticData();

        //#3. Filter the response according to matched predicates
        List<MobileHandSet> filteredList= mobileHandSets.stream()
                                .filter(predicates.stream()
                                .reduce(x -> true, Predicate::and))
                                .collect(Collectors.toList());
        log.info("filtered response Size={}", filteredList.size());
        log.info("filtered response ={}", filteredList);
        log.info("end :: ProductSearchServiceImpl : search with response ={} ", filteredList.size());
         return  filteredList;
    }
}
