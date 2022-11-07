package com.example.week11;

import com.example.week11.dto.OrderDTO;
import com.example.week11.models.Buyer;
import com.example.week11.models.Laptop;
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

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser(roles = "ADMIN")
public class OrdersControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getOrdersTest() throws  Exception{
        mockMvc.perform(get("/orders"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getOrderByIdTest() throws Exception{
        mockMvc.perform(get("/orders/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void addOrderTest() throws  Exception{
        OrderDTO orderDTO = new OrderDTO(new Laptop(3, "Apple", "Macbook Pro M2", 1400),
                new Buyer(16, "Aziz", "Solibaev", "555000999", "azik", "1234", "ROLE_USER"));

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter objectWriter = objectMapper.writer().withDefaultPrettyPrinter();
        String req = objectWriter.writeValueAsString(orderDTO);
        mockMvc.perform(post("/orders/new")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(req))
                .andExpect(status().isOk());
    }

    @Test
    public void updateOrderTest() throws Exception{
        OrderDTO orderDTO = new OrderDTO(new Laptop(3, "Apple", "Macbook Pro M2", 1400),
                new Buyer(16, "Aziz", "Solibaev", "555000999", "azik", "1234", "ROLE_USER"));

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter objectWriter = objectMapper.writer().withDefaultPrettyPrinter();
        String req = objectWriter.writeValueAsString(orderDTO);
        mockMvc.perform(put("/orders/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(req))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteOrderTest() throws Exception{
        mockMvc.perform(delete("/orders/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
