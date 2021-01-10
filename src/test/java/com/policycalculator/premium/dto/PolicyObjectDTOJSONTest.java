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
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@JsonTest
class PolicyObjectDTOJSONTest {

    @Autowired
    private JacksonTester<PolicyObjectDTO> json;

    @Test
    public void serializePolicy() throws IOException {
        PolicyObjectDTO testPolicyObject = createTestPolicyObject(1, Constants.riskType.FIRE);
        JsonContent<PolicyObjectDTO> value = this.json.write(testPolicyObject);
        assertThat(this.json.parseObject(value.getJson())).isEqualTo(testPolicyObject);
    }

    private PolicyObjectDTO createTestPolicyObject(int id, Enum riskType) {
        PolicyObjectDTO policyObjectDTO = new PolicyObjectDTO();
        policyObjectDTO.setId(new Long(id));
        policyObjectDTO.setName("NEW NAME");
        policyObjectDTO.setSubObjects(createSubObjects(riskType));

        return policyObjectDTO;
    }

    private List<SubObjectDTO> createSubObjects(Enum riskType) {
        List<SubObjectDTO> subObjectDTOS = new ArrayList<>();

        SubObjectDTO subObjectDTO1 = new SubObjectDTO();
        subObjectDTO1.setId(1L);
        subObjectDTO1.setName("NEW NAME1");
        subObjectDTO1.setSumInsured(200.00);
        subObjectDTO1.setRiskType(riskType.toString());
        subObjectDTOS.add(subObjectDTO1);

        SubObjectDTO subObjectDTO2 = new SubObjectDTO();
        subObjectDTO2.setId(2L);
        subObjectDTO2.setName("NEW NAME2");
        subObjectDTO2.setSumInsured(200.00);
        subObjectDTO2.setRiskType(riskType.toString());
        subObjectDTOS.add(subObjectDTO2);

        return subObjectDTOS;
    }
}
