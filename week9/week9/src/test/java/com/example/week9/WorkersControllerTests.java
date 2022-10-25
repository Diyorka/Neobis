package com.example.week9;

import com.example.week9.dto.OrderDTO;
import com.example.week9.dto.WorkerDTO;
import com.example.week9.models.Buyer;
import com.example.week9.models.Laptop;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser(roles = "ADMIN")
public class WorkersControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getWorkersTest() throws  Exception{
        mockMvc.perform(get("/workers"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getWorkerByIdTest() throws Exception{
        mockMvc.perform(get("/workers/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void addOrderTest() throws  Exception{
        WorkerDTO workerDTO = new WorkerDTO("Aziz", "Solibaev", "555888777", "Seller", "azik", "1234");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter objectWriter = objectMapper.writer().withDefaultPrettyPrinter();
        String req = objectWriter.writeValueAsString(workerDTO);
        mockMvc.perform(post("/workers/new")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(req))
                .andExpect(status().isOk());
    }

    @Test
    public void updateWorkerTest() throws Exception{
        WorkerDTO workerDTO = new WorkerDTO("Azizik", "Solibaev", "555888777", "Seller", "azik", "1234");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter objectWriter = objectMapper.writer().withDefaultPrettyPrinter();
        String req = objectWriter.writeValueAsString(workerDTO);
        mockMvc.perform(put("/workers/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(req))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteOrderTest() throws Exception{
        mockMvc.perform(delete("/workers/2"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
