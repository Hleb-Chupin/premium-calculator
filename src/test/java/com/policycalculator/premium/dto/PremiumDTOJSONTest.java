package com.policycalculator.premium.dto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@JsonTest
class PremiumDTOJSONTest {

    @Autowired
    private JacksonTester<PremiumDTO> json;

    @Test
    public void serializePolicy() throws IOException {
        PremiumDTO testPremium = createTestPremium(1);
        JsonContent<PremiumDTO> value = this.json.write(testPremium);
        assertThat(this.json.parseObject(value.getJson())).isEqualTo(testPremium);
    }

    private PremiumDTO createTestPremium(int id) {
        PremiumDTO premiumDTO = new PremiumDTO();
        premiumDTO.setId(new Long(id));
        premiumDTO.setPremiumSum(200.00);
        return premiumDTO;
    }
}
