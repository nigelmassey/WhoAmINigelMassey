package com.example.WhoAmI;

import com.example.WhoAmI.models.GenderizeModel;
import com.example.WhoAmI.services.GenderizeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GenderizeServiceTests {

    private final String UrlWithName = "https://api.genderize.io/?name={first_name}";
    private final String UrlWithNameAndCountryCode = "https://api.genderize.io/?name={first_name}&country_id={country_code}";

    @InjectMocks
    GenderizeService genderizeService;

    @Mock
    RestTemplate restTemplate;

    @Test
    public void givenGetGenderFromNameWhenCorrectParameterPassedThenReturnGender() {

        String name = "Nigel";
        when(restTemplate.getForObject(UrlWithName, GenderizeModel.class, name)).thenReturn(new GenderizeModel(name, "Male", 0.99, 1, "GB"));
        assertEquals("Male", genderizeService.getGenderFromName(name));

    }

    @Test
    public void givenGetGenderFromNameWhenAnInvalidNameValueSentThenReturnNA() {

        String name = "Nigel";
        //when(restTemplate.getForObject(agifyUrlWithName, AgifyModel.class, name)).thenReturn(new AgifyModel(name, 30, 1, ""));
        assertEquals("n/a", genderizeService.getGenderFromName(""));

    }

    @Test
    public void givenGetGenderFromNameAndLocationWhenAnInvalidCountryCodeSentThenReturnNA() {

        String name = "Nigel";
        assertEquals("n/a", genderizeService.getGenderFromNameAndLocation(name, ""));

    }

}
