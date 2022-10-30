package com.example.week10;

import com.example.week9.dto.BuyerDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser(roles = "ADMIN")
public class BuyersControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getBuyersTest() throws  Exception{
        mockMvc.perform(get("/buyers"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getBuyerByIdTest() throws Exception{
        mockMvc.perform(get("/buyers/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void addBuyerTest() throws  Exception{
        BuyerDTO buyerDTO = new BuyerDTO();
        buyerDTO.setFirstName("Aziz");
        buyerDTO.setLastName("Solibaev");
        buyerDTO.setPhoneNumber("555000999");
        buyerDTO.setUsername("azik");
        buyerDTO.setPassword("1234");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter objectWriter = objectMapper.writer().withDefaultPrettyPrinter();
        String req = objectWriter.writeValueAsString(buyerDTO);
        mockMvc.perform(post("/buyers/new")
                .contentType(MediaType.APPLICATION_JSON)
                .content(req))
                .andExpect(status().isOk());
    }

    @Test
    public void updateBuyerTest() throws Exception{
        BuyerDTO buyerDTO = new BuyerDTO("Aziz", "Solibaev",
                "555555000", "azizik", "1234");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter objectWriter = objectMapper.writer().withDefaultPrettyPrinter();
        String req = objectWriter.writeValueAsString(buyerDTO);
        mockMvc.perform(put("/buyers/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(req))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteBuyerTest() throws Exception{
        mockMvc.perform(delete("/buyers/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

}
