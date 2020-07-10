package com.example.WhoAmI;

import com.example.WhoAmI.models.AgifyModel;
import com.example.WhoAmI.services.WhoAmIService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class WhoAmIServiceTests {

    @InjectMocks
    WhoAmIService whoAmIService;

    @Mock
    RestTemplate restTemplate;

    @Test
    public void getAgeTest(){

        String name = "Nigel";
        String url = String.format("https://api.agify.io/?name=%s", name);
        when(restTemplate.getForObject(url, AgifyModel.class)).thenReturn(new AgifyModel(name, 30, 1, ""));
        whoAmIService.getAgeFromName("Nigel");

    }

}
