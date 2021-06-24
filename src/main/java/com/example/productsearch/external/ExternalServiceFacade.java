package com.example.productsearch.external;

import com.example.productsearch.config.ProductSearchFeignClient;
import com.example.productsearch.dto.MobileHandSet;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author Ramesh.Yaleru on 6/24/2021
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class ExternalServiceFacade {

    private ProductSearchFeignClient productSearchFeignClient;

    @PostConstruct
    public List<MobileHandSet> loadServiceResponseStaticData(){
        return productSearchFeignClient.searchProfiles();
    }

}
