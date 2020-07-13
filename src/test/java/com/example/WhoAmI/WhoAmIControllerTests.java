package com.example.WhoAmI;

import com.example.WhoAmI.controllers.WhoAmIController;
import com.example.WhoAmI.models.WhoAmIRequestModel;
import com.example.WhoAmI.services.AgifyService;
import com.example.WhoAmI.services.GenderizeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(value = WhoAmIController.class)
public class WhoAmIControllerTests {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private AgifyService agifyService;
    @MockBean
    private GenderizeService genderizeService;

    @Test
    public void givenPostWhoAmIWhenGivenCorrectParametersThenReturnFullObjectInJson() throws Exception {

        String name = "Nigel";
        String country_code = "GB";

        when(agifyService.getAgeFromNameAndLocation(name, country_code)).thenReturn(12);
        when(genderizeService.getGenderFromNameAndLocation(name, country_code)).thenReturn("male");

        this.mockMvc.perform(post("/whoami")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(new WhoAmIRequestModel(name, country_code))))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().json("{\"first_name\":\"Nigel\",\"country_code\":\"GB\",\"age\":12,\"gender\":\"male\"}"));

    }

    @Test
    public void givenPostWhoAmIWhenServicesReturnNullThenAgeEqualsZeroAndGenderEqualsNull() throws Exception {

        String name = "Nigel";
        String country_code = "GB";

        this.mockMvc.perform(post("/whoami")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(new WhoAmIRequestModel(name, country_code))))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().json("{\"first_name\":\"Nigel\",\"country_code\":\"GB\",\"age\":0,\"gender\":null}"));

    }

}
