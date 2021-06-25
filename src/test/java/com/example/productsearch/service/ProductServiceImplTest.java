package com.example.productsearch.service;

import com.example.productsearch.dto.MobileHandSet;
import com.example.productsearch.dto.SearchCriteriaMobileHandset;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * @author Ramesh.Yaleru on 6/25/2021
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductSearchService productSearchService;

    @Test
    @DisplayName("Search mobile handset records by priceEur")
    void search_priceEur() {
        SearchCriteriaMobileHandset searchCriteriaMobileHandset = prepareSearchCriteria();
        searchCriteriaMobileHandset.setPriceEur(200);
        List<MobileHandSet> mobileHandSets = productSearchService.search(searchCriteriaMobileHandset);
        assertThat(mobileHandSets.size(), equalTo(10));
    }

    @Test
    @DisplayName("Search mobile handset records by announce date and priceEur")
    void search_announceDateAndPriceEur() {
        SearchCriteriaMobileHandset searchCriteriaMobileHandset = prepareSearchCriteria();
        searchCriteriaMobileHandset.setAnnounceDate("1999");
        searchCriteriaMobileHandset.setPriceEur(200);
        List<MobileHandSet> mobileHandSets = productSearchService.search(searchCriteriaMobileHandset);
        assertThat(mobileHandSets.size(), equalTo(2));
    }

    @Test
    @DisplayName("Search mobile handset records by sim")
    void search_sim() {
        SearchCriteriaMobileHandset searchCriteriaMobileHandset = prepareSearchCriteria();
        searchCriteriaMobileHandset.setSim("eSim");
        List<MobileHandSet> mobileHandSets = productSearchService.search(searchCriteriaMobileHandset);
        assertThat(mobileHandSets.size(), equalTo(18));
    }

    @Test
    @DisplayName("Search mobile handset records by id")
    void search_id() {
        SearchCriteriaMobileHandset searchCriteriaMobileHandset = prepareSearchCriteria();
        searchCriteriaMobileHandset.setId(29646l);
        List<MobileHandSet> mobileHandSets = productSearchService.search(searchCriteriaMobileHandset);
        assertThat(mobileHandSets.size(), equalTo(1));
    }

    @Test
    @DisplayName("Search mobile handset records by battery")
    void search_battery() {
        SearchCriteriaMobileHandset searchCriteriaMobileHandset = prepareSearchCriteria();
        searchCriteriaMobileHandset.setBattery("205 mAh");
        List<MobileHandSet> mobileHandSets = productSearchService.search(searchCriteriaMobileHandset);
        assertThat(mobileHandSets.size(), equalTo(4));
    }

    @Test
    @DisplayName("Search mobile handset records by resolution")
    void search_resolution() {
        SearchCriteriaMobileHandset searchCriteriaMobileHandset = prepareSearchCriteria();
        searchCriteriaMobileHandset.setResolution("1080 x 1920 pixels");
        List<MobileHandSet> mobileHandSets = productSearchService.search(searchCriteriaMobileHandset);
        assertThat(mobileHandSets.size(), equalTo(4));
    }

    @Test
    @DisplayName("Search mobile handset records by picture name")
    void search_pictureName() {
        SearchCriteriaMobileHandset searchCriteriaMobileHandset = prepareSearchCriteria();
        searchCriteriaMobileHandset.setPicture("apple-ipad-97-2017.jpg");
        List<MobileHandSet> mobileHandSets = productSearchService.search(searchCriteriaMobileHandset);
        assertThat(mobileHandSets.size(), equalTo(1));
    }

    @Test
    @DisplayName("Search mobile handset records by gps")
    void search_gps() {
        SearchCriteriaMobileHandset searchCriteriaMobileHandset = prepareSearchCriteria();
        searchCriteriaMobileHandset.setGps("A-GPS");
        List<MobileHandSet> mobileHandSets = productSearchService.search(searchCriteriaMobileHandset);
        assertThat(mobileHandSets.size(), equalTo(45));
    }



    private SearchCriteriaMobileHandset prepareSearchCriteria() {
        return SearchCriteriaMobileHandset.builder().build();
    }

}
