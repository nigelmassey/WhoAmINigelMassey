package com.example.WhoAmI;

import com.example.WhoAmI.services.AgifyService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class AgifyServiceTests {

    private final String UrlWithName = "https://api.agify.io/?name={first_name}";
    private final String UrlWithNameAndCountryCode = "https://api.agify.io/?name={first_name}&country_id={country_code}";

    @InjectMocks
    AgifyService agifyService;

    @Mock
    RestTemplate restTemplate;

    @Test
    public void givenGetAgeFromNameWhenAnInvalidNameValueSentThenReturnZero() {

        String name = "Nigel";
        //when(restTemplate.getForObject(agifyUrlWithName, AgifyModel.class, name)).thenReturn(new AgifyModel(name, 30, 1, ""));
        assertEquals(0, agifyService.getAgeFromName(""));

    }

    @Test
    public void givenGetAgeFromNameAndLocationWhenAnInvalidCountryCodeSentThenReturnZero() {

        String name = "Nigel";
        assertEquals(0, agifyService.getAgeFromNameAndLocation(name, ""));

    }

}
