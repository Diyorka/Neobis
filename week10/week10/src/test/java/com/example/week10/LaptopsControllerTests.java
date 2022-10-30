package com.example.week10;

import com.example.week9.dto.LaptopDTO;
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
public class LaptopsControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getLaptopsTest() throws  Exception{
        mockMvc.perform(get("/laptops"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getLaptopByIdTest() throws Exception{
        mockMvc.perform(get("/laptops/2"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void addLaptopTest() throws  Exception{
        LaptopDTO laptopDTO = new LaptopDTO("Apple", "Macbook Pro 14", 1500);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter objectWriter = objectMapper.writer().withDefaultPrettyPrinter();
        String req = objectWriter.writeValueAsString(laptopDTO);
        mockMvc.perform(post("/laptops/new")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(req))
                .andExpect(status().isOk());
    }

    @Test
    public void updateLaptopTest() throws Exception{
        LaptopDTO laptopDTO = new LaptopDTO("Apple", "Macbook Air M1",
                999);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter objectWriter = objectMapper.writer().withDefaultPrettyPrinter();
        String req = objectWriter.writeValueAsString(laptopDTO);
        mockMvc.perform(put("/laptops/4")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(req))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteLaptopTest() throws Exception{
        mockMvc.perform(delete("/laptops/2"))
                .andDo(print())
                .andExpect(status().isOk());
    }

}
