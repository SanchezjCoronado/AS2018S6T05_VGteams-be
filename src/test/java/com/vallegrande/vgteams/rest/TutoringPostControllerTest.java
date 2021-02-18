package com.vallegrande.vgteams.rest;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static com.vallegrande.vgteams.prototype.prototypeTutoring.uTutoring;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TutoringPostControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void save() throws Exception {

        String tutoringSessionId = "2200457d-ad2e-45ce-b7b7-810802b31073";

        mockMvc.perform(MockMvcRequestBuilders
                .post("/")
                .content(
                        asJsonString(
                                uTutoring()
                        )
                )

                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().string(""));

    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
