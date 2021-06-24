package com.example.productsearch.external;

import com.example.productsearch.config.ProductSearchFeignClient;
import com.example.productsearch.dto.MobileHandSet;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author Ramesh.Yaleru on 6/24/2021
 */
@Component
public class ExternalServiceFacade {

    private final ProductSearchFeignClient productSearchFeignClient;

    ExternalServiceFacade(ProductSearchFeignClient productSearchFeignClient){
        this.productSearchFeignClient = productSearchFeignClient;
    }

    @PostConstruct
    public List<MobileHandSet> loadServiceResponseStaticData(){
        return productSearchFeignClient.fetchMobileHandset();
    }

}
