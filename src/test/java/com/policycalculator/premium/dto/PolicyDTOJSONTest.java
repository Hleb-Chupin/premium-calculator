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
class PolicyDTOJSONTest {

    @Autowired
    private JacksonTester<PolicyDTO> json;

    @Test
    public void serializePolicy() throws IOException {
        PolicyDTO testPolicy = createTestPolicy(1, Constants.riskType.FIRE);
        JsonContent<PolicyDTO> value = this.json.write(testPolicy);
        assertThat(this.json.parseObject(value.getJson())).isEqualTo(testPolicy);
    }

    private PolicyDTO createTestPolicy(int id, Enum riskType) {
        PolicyDTO policyDTO = new PolicyDTO();
        policyDTO.setId(new Long(id));
        policyDTO.setNumber("INSURANCE-330000-BALTICS-2021");
        policyDTO.setPolicyObjects(createtestPolicys(riskType));
        policyDTO.setStatus(Constants.REGISTERED);
        return policyDTO;
    }

    private List<PolicyObjectDTO> createtestPolicys(Enum riskType) {
        List<PolicyObjectDTO> policyObjectDTOS = new ArrayList<>();

        PolicyObjectDTO policyObjectDTO1 = new PolicyObjectDTO();
        policyObjectDTO1.setId(new Long(1));
        policyObjectDTO1.setName("NEW NAME1");
        policyObjectDTO1.setSubObjects(createSubObjects(riskType));
        policyObjectDTOS.add(policyObjectDTO1);

        PolicyObjectDTO policyObjectDTO2 = new PolicyObjectDTO();
        policyObjectDTO2.setId(new Long(2));
        policyObjectDTO2.setName("NEW NAME2");
        policyObjectDTO2.setSubObjects(createSubObjects(riskType));
        policyObjectDTOS.add(policyObjectDTO1);

        return policyObjectDTOS;
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
