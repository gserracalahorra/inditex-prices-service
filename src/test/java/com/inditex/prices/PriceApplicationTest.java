package com.inditex.prices;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PriceApplicationTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void testRequestAt10n14DayForProductId35455AndBrandId1() throws Exception {
    mockMvc.perform(
            MockMvcRequestBuilders.get("/prices").param("brandId", "1").param("productId", "35455")
                .param("applicationDate", "2020-06-14T10:00:00.000Z")).andExpect(status().isOk())
        .andExpect(jsonPath("$.price").value(35.5));
  }

  @Test
  public void testRequestAt16n14DayForProductId35455AndBrandId1() throws Exception {
    mockMvc.perform(
            MockMvcRequestBuilders.get("/prices").param("brandId", "1").param("productId", "35455")
                .param("applicationDate", "2020-06-14T16:00:00.000Z")).andExpect(status().isOk())
        .andExpect(jsonPath("$.price").value(25.45));
  }

  @Test
  public void testRequestAt21n14DayForProductId35455AndBrandId1() throws Exception {
    mockMvc.perform(
            MockMvcRequestBuilders.get("/prices").param("brandId", "1").param("productId", "35455")
                .param("applicationDate", "2020-06-14T21:00:00.000Z")).andExpect(status().isOk())
        .andExpect(jsonPath("$.price").value(35.5));
  }

  @Test
  public void testRequestAt10n15DayForProductId35455AndBrandId1() throws Exception {
    mockMvc.perform(
            MockMvcRequestBuilders.get("/prices").param("brandId", "1").param("productId", "35455")
                .param("applicationDate", "2020-06-15T10:00:00.000Z")).andExpect(status().isOk())
        .andExpect(jsonPath("$.price").value(30.50));
  }

  @Test
  public void testRequestAt21n16DayForProductId35455AndBrandId1() throws Exception {
    mockMvc.perform(
            MockMvcRequestBuilders.get("/prices").param("brandId", "1").param("productId", "35455")
                .param("applicationDate", "2020-06-16T21:00:00.000Z")).andExpect(status().isOk())
        .andExpect(jsonPath("$.price").value(38.95));
  }

  @Test
  public void testRequestWhenProductIdNotExistsThenReturn404() throws Exception {
    mockMvc.perform(
            MockMvcRequestBuilders.get("/prices").param("brandId", "1").param("productId", "11111")
                .param("applicationDate", "2020-06-16T21:00:00.000Z")).andExpect(status().isNotFound())
        .andExpect(jsonPath("$.message").value(
            "Price not found for product 11111 and brand 1 at 2020-06-16T21:00"));
  }

}
