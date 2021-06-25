package com.example.productsearch;

import com.example.productsearch.dto.MobileHandSet;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
 * @author Ramesh.Yaleru on 6/24/2021
 */
@ExtendWith(SpringExtension.class)
@AutoConfigureJsonTesters
@SpringBootTest
@AutoConfigureMockMvc
public class ProductQueryControllerTest {

    @Autowired
    private MockMvc mockMvc;
    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void search_priceEur() throws Exception {
        String searchCriteria="200";
        // when
        MockHttpServletResponse response = mockMvc.perform(
                get("/mobile/search?priceEur="+searchCriteria)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        List<MobileHandSet> handSets = objectMapper.readValue(response.getContentAsString(), new TypeReference<>() {});
        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(10).isEqualTo(handSets.size());
    }

    @Test
    public void search_sim() throws Exception {
        String searchCriteria="eSim";
        // when
        MockHttpServletResponse response = mockMvc.perform(
                get("/mobile/search?sim="+searchCriteria)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        List<MobileHandSet> handSets = objectMapper.readValue(response.getContentAsString(), new TypeReference<>() {});
        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(18).isEqualTo(handSets.size());
    }

    @Test
    public void search_AnnounceDate_AND_Price() throws Exception {
        String searchCriteria1="1999";
        Long searchCriteria2=200l;
        // when
        MockHttpServletResponse response = mockMvc.perform(
                get("/mobile/search?announceDate="+searchCriteria1+"&price="+searchCriteria2)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        List<MobileHandSet> handSets = objectMapper.readValue(response.getContentAsString(), new TypeReference<>() {});
        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(2).isEqualTo(handSets.size());
    }

    @Test
    public void search_By_brand() throws Exception {
        String searchCriteria="Apple";
        // when
        MockHttpServletResponse response = mockMvc.perform(
                get("/mobile/search?brand="+searchCriteria)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        List<MobileHandSet> handSets = objectMapper.readValue(response.getContentAsString(), new TypeReference<>() {});
        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(65).isEqualTo(handSets.size());
    }

    @Test
    public void search_By_phone() throws Exception {
        String searchCriteria="Apple Watch";
        // when
        MockHttpServletResponse response = mockMvc.perform(
                get("/mobile/search?phone="+searchCriteria)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        List<MobileHandSet> handSets = objectMapper.readValue(response.getContentAsString(), new TypeReference<>() {});
        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(19).isEqualTo(handSets.size());
    }

    @Test
    public void search_By_audioJack_Yes() throws Exception {
        String searchCriteria="Yes";
        // when
        MockHttpServletResponse response = mockMvc.perform(
                get("/mobile/search?audioJack="+searchCriteria)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        List<MobileHandSet> handSets = objectMapper.readValue(response.getContentAsString(), new TypeReference<>() {});
        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(36).isEqualTo(handSets.size());
    }

    @Test
    public void search_By_audioJack_No() throws Exception {
        String searchCriteria="No";
        // when
        MockHttpServletResponse response = mockMvc.perform(
                get("/mobile/search?audioJack="+searchCriteria)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        List<MobileHandSet> handSets = objectMapper.readValue(response.getContentAsString(), new TypeReference<>() {});
        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(69).isEqualTo(handSets.size());
    }

    @Test
    public void search_By_gps_Not_Exists() throws Exception {
        String searchCriteria="A-GPR";
        // when
        MockHttpServletResponse response = mockMvc.perform(
                get("/mobile/search?gps="+searchCriteria)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        List<MobileHandSet> handSets = objectMapper.readValue(response.getContentAsString(), new TypeReference<>() {});
        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(0).isEqualTo(handSets.size());
    }

    @Test
    public void search_By_id() throws Exception {
        Long searchCriteria=29646l;
        // when
        MockHttpServletResponse response = mockMvc.perform(
                get("/mobile/search?id="+searchCriteria)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        List<MobileHandSet> handSets = objectMapper.readValue(response.getContentAsString(), new TypeReference<>() {});
        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(1).isEqualTo(handSets.size());
    }

    @Test
    public void search_By_id_Not_Exists() throws Exception {
        Long searchCriteria=11111l;
        // when
        MockHttpServletResponse response = mockMvc.perform(
                get("/mobile/search?id="+searchCriteria)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        List<MobileHandSet> handSets = objectMapper.readValue(response.getContentAsString(), new TypeReference<>() {});
        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(0).isEqualTo(handSets.size());
    }

    @Test
    public void search_By_battery() throws Exception {
        String searchCriteria="205 mAh";
        // when
        MockHttpServletResponse response = mockMvc.perform(
                get("/mobile/search?battery="+searchCriteria)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        List<MobileHandSet> handSets = objectMapper.readValue(response.getContentAsString(), new TypeReference<>() {});
        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(4).isEqualTo(handSets.size());
    }

    @Test
    public void search_By_battery_Not_Exists() throws Exception {
        String searchCriteria="111 mAh";
        // when
        MockHttpServletResponse response = mockMvc.perform(
                get("/mobile/search?battery="+searchCriteria)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        List<MobileHandSet> handSets = objectMapper.readValue(response.getContentAsString(), new TypeReference<>() {});
        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(0).isEqualTo(handSets.size());
    }

    @Test
    public void search_By_resolution_10801920_pixels() throws Exception {
        String searchCriteria="1080 x 1920 pixels";
        // when
        MockHttpServletResponse response = mockMvc.perform(
                get("/mobile/search?resolution="+searchCriteria)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        List<MobileHandSet> handSets = objectMapper.readValue(response.getContentAsString(), new TypeReference<>() {});
        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(4).isEqualTo(handSets.size());
    }

    @Test
    public void search_By_picture_apple_iphone() throws Exception {
        String searchCriteria="apple-iphone";
        // when
        MockHttpServletResponse response = mockMvc.perform(
                get("/mobile/search?picture="+searchCriteria)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        List<MobileHandSet> handSets = objectMapper.readValue(response.getContentAsString(), new TypeReference<>() {});
        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(22).isEqualTo(handSets.size());
    }

    @Test
    public void search_By_picture_apple_ipad_97_2017_jpg() throws Exception {
        String searchCriteria="apple-ipad-97-2017.jpg";
        // when
        MockHttpServletResponse response = mockMvc.perform(
                get("/mobile/search?picture="+searchCriteria)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        List<MobileHandSet> handSets = objectMapper.readValue(response.getContentAsString(), new TypeReference<>() {});
        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(1).isEqualTo(handSets.size());
    }

    @Test
    public void search_By_announceDate_2016() throws Exception {
        String searchCriteria="2016";
        // when
        MockHttpServletResponse response = mockMvc.perform(
                get("/mobile/search?announceDate="+searchCriteria)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        List<MobileHandSet> handSets = objectMapper.readValue(response.getContentAsString(), new TypeReference<>() {});
        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(12).isEqualTo(handSets.size());
    }

    @Test
    public void search_By_announceDate_2021_Not_Exists() throws Exception {
        String searchCriteria="2021";
        // when
        MockHttpServletResponse response = mockMvc.perform(
                get("/mobile/search?announceDate="+searchCriteria)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        List<MobileHandSet> handSets = objectMapper.readValue(response.getContentAsString(), new TypeReference<>() {});
        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(0).isEqualTo(handSets.size());
    }
}
