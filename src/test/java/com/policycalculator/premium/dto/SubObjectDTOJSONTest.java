package com.policycalculator.premium.dto;

import com.policycalculator.premium.common.utils.Constants;
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
class SubObjectDTOJSONTest {

    @Autowired
    private JacksonTester<SubObjectDTO> json;

    @Test
    public void serializePolicy() throws IOException {
        SubObjectDTO testSubObject = createTestSubObject(1);
        JsonContent<SubObjectDTO> value = this.json.write(testSubObject);
        assertThat(this.json.parseObject(value.getJson())).isEqualTo(testSubObject);
    }

    private SubObjectDTO createTestSubObject(int id) {
        SubObjectDTO subObjectDTO = new SubObjectDTO();
        subObjectDTO.setId(new Long(id));
        subObjectDTO.setName("NEW NAME");
        subObjectDTO.setRiskType(Constants.riskType.FIRE.toString());
        subObjectDTO.setSumInsured(200.00);
        return subObjectDTO;
    }
}
