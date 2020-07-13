package com.example.WhoAmI;

import com.example.WhoAmI.models.AgifyModel;
import com.example.WhoAmI.models.GenderizeModel;
import com.example.WhoAmI.services.AgifyService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AgifyServiceTests {

    private final String UrlWithName = "https://api.agify.io/?name={first_name}";
    private final String UrlWithNameAndCountryCode = "https://api.agify.io/?name={first_name}&country_id={country_code}";

    @InjectMocks
    AgifyService agifyService;

    @Mock
    RestTemplate restTemplate;

    @Test
    public void givenGetAgeFromNameAndLocationWhenCorrectParameterPassedThenReturnAge() {

        String name = "Nigel";
        String country_code = "GB";
        when(restTemplate.getForObject(UrlWithNameAndCountryCode, AgifyModel.class, name, country_code)).thenReturn(new AgifyModel(name, 30, 1, country_code));
        assertEquals(30, agifyService.getAgeFromNameAndLocation(name, country_code));

    }

    @Test
    public void givenGetAgeFromNameWhenAnInvalidNameValueSentThenReturnZero() {

        assertEquals(0, agifyService.getAgeFromName(""));

    }

    @Test
    public void givenGetAgeFromNameAndLocationWhenAnInvalidCountryCodeSentThenReturnZero() {

        String name = "Nigel";
        assertEquals(0, agifyService.getAgeFromNameAndLocation(name, ""));

    }

}
