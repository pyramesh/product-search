package com.example.productsearch.helper;

import com.example.productsearch.dto.MobileHandSet;
import com.example.productsearch.dto.SearchCriteriaMobileHandset;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.function.Predicate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * @author Ramesh.Yaleru on 6/25/2021
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PredicateSearchResolverTest {
    @Autowired
    private PredicateSearchResolver predicateSearchResolver;

    @Test
    @DisplayName("get predicate by priceEur")
    void getPredicates_priceEur() {
        SearchCriteriaMobileHandset searchCriteriaMobileHandset = prepareSearchCriteria();
        searchCriteriaMobileHandset.setPriceEur(200);
        List<Predicate<MobileHandSet>> predicates = predicateSearchResolver.resolve(searchCriteriaMobileHandset);
        assertThat(predicates.size(), equalTo(1));
    }

    @Test
    @DisplayName("get predicate by announce date and priceEur")
    void getPredicates_AnnounceDate_priceEur() {
        SearchCriteriaMobileHandset searchCriteriaMobileHandset = prepareSearchCriteria();
        searchCriteriaMobileHandset.setAnnounceDate("1999");
        searchCriteriaMobileHandset.setPriceEur(200);
        List<Predicate<MobileHandSet>> predicates = predicateSearchResolver.resolve(searchCriteriaMobileHandset);
        assertThat(predicates.size(), equalTo(2));
    }

    @Test
    @DisplayName("get predicate by sim")
    void getPredicates_sim() {
        SearchCriteriaMobileHandset searchCriteriaMobileHandset = prepareSearchCriteria();
        searchCriteriaMobileHandset.setSim("eSim");
        List<Predicate<MobileHandSet>> predicates = predicateSearchResolver.resolve(searchCriteriaMobileHandset);
        assertThat(predicates.size(), equalTo(1));
    }

    @Test
    @DisplayName("get predicate by sim which doesnot exists")
    void getPredicates_sim_NotExists() {
        SearchCriteriaMobileHandset searchCriteriaMobileHandset = prepareSearchCriteria();
        searchCriteriaMobileHandset.setSim(null);
        List<Predicate<MobileHandSet>> predicates = predicateSearchResolver.resolve(searchCriteriaMobileHandset);
        assertThat(predicates.size(), equalTo(0));
    }

    @Test
    @DisplayName("get predicate by sim which no criteria passed")
    void getPredicates_No_Criteria() {
        SearchCriteriaMobileHandset searchCriteriaMobileHandset = prepareSearchCriteria();
        List<Predicate<MobileHandSet>> predicates = predicateSearchResolver.resolve(searchCriteriaMobileHandset);
        assertThat(predicates.size(), equalTo(0));
    }
    private SearchCriteriaMobileHandset prepareSearchCriteria() {
        return SearchCriteriaMobileHandset.builder().build();
    }
}
