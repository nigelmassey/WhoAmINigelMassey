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
import static org.junit.jupiter.api.Assertions.assertNull;
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
    public void givenGetGenderFromNameAndLocationWhenCorrectParameterPassedThenReturnGender() {

        String name = "Nigel";
        String country_code = "GB";
        when(restTemplate.getForObject(UrlWithNameAndCountryCode, GenderizeModel.class, name, country_code)).thenReturn(new GenderizeModel(name, "male", 0.99, 1, country_code));
        assertEquals("male", genderizeService.getGenderFromNameAndLocation(name, country_code));

    }

    @Test
    public void givenGetGenderFromNameWhenAnInvalidNameValueSentThenReturnNull() {

        assertNull(genderizeService.getGenderFromName(""));

    }

    @Test
    public void givenGetGenderFromNameAndLocationWhenAnInvalidCountryCodeSentThenReturnNull() {

        String name = "Nigel";
        assertNull(genderizeService.getGenderFromNameAndLocation(name, ""));

    }

}
