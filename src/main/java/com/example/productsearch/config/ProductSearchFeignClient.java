package com.example.productsearch.config;

import com.example.productsearch.dto.MobileHandSet;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author Ramesh.Yaleru on 6/24/2021
 */

@FeignClient(value = "product-search", url = "${mobile.handset.service.endpoint.base.url}")
@Component
public interface ProductSearchFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/v3/b755c334-9627-4b09-84f2-548cb1918184",
            produces = MediaType.APPLICATION_JSON_VALUE)
    List<MobileHandSet> fetchMobileHandset();
}
