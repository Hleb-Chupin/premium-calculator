package com.policycalculator.premium.http;

import com.policycalculator.premium.common.utils.Constants;
import com.policycalculator.premium.dto.PolicyDTO;
import com.policycalculator.premium.dto.PolicyObjectDTO;
import com.policycalculator.premium.dto.PremiumDTO;
import com.policycalculator.premium.dto.SubObjectDTO;
import com.policycalculator.premium.service.PremiumCalculatorService;
import com.policycalculator.premium.service.PremiumCalculatorServiceException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(PremiumCalculatorController.class)
class PremiumCalculatorControllerTest {

    private static final Logger LOG = LoggerFactory.getLogger(PremiumCalculatorControllerTest.class);

    private static final String JSONBody = "{\"id\":1,\"number\":\"INSURANCE-330000-BALTICS-2021\",\"status\":\"REGISTERED\"," +
            "\"policyObjects\":[{\"id\":1,\"name\":\"NEW NAME\",\"subObjects\":[{\"id\":1,\"name\":\"NEW NAME1\",\"sumInsured\":100," +
            "\"riskType\":\"FIRE\"},{\"id\":2,\"name\":\"NEW NAME2\",\"sumInsured\":8,\"riskType\":\"THEFT\"}]}]}";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PremiumCalculatorService premiumCalculatorService;

    @BeforeEach
    public void setup() throws PremiumCalculatorServiceException {

        PolicyDTO policyDTO = createTestPolicy();
        PremiumDTO premiumDTO = new PremiumDTO();
        premiumDTO.setId(null);
        premiumDTO.setPremiumSum(2.28);

        BDDMockito.given(this.premiumCalculatorService.calculate(policyDTO)).willReturn(premiumDTO);

        LOG.debug("@BeforeEach done");
    }

    @Test
    public void calculateActionReturnSuccess() throws Exception {
        this.mockMvc.perform(post("/api/v1.0/premium/calculate").contentType(MediaType.APPLICATION_JSON).content(JSONBody))
                .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void calculateActionReturnBadRequestWithXML() throws Exception {
        this.mockMvc.perform(post("/api/v1.0/premium/calculate").contentType(MediaType.APPLICATION_XML).content(JSONBody))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void calculateActionReturnBadRequestWithEmptyRequest() throws Exception {
        this.mockMvc.perform(post("/api/v1.0/premium/calculate").contentType(MediaType.APPLICATION_JSON).content(""))
                .andExpect(status().isBadRequest());
    }

    private PolicyDTO createTestPolicy() {
        PolicyDTO policyDTO = new PolicyDTO();
        policyDTO.setId(1L);
        policyDTO.setNumber("INSURANCE-330000-BALTICS-2021");
        policyDTO.setPolicyObjects(createtestPolicys());
        policyDTO.setStatus(Constants.REGISTERED);

        LOG.debug("createTestPolicy() {}", policyDTO);

        return policyDTO;
    }

    private List<PolicyObjectDTO> createtestPolicys() {
        List<PolicyObjectDTO> policyObjectDTOS = new ArrayList<>();

        PolicyObjectDTO policyObjectDTO1 = new PolicyObjectDTO();
        policyObjectDTO1.setId(new Long(1));
        policyObjectDTO1.setName("NEW NAME");
        policyObjectDTO1.setSubObjects(createSubObjects());
        policyObjectDTOS.add(policyObjectDTO1);

        return policyObjectDTOS;
    }

    private List<SubObjectDTO> createSubObjects() {
        List<SubObjectDTO> subObjectDTOS = new ArrayList<>();

        SubObjectDTO subObjectDTO1 = new SubObjectDTO();
        subObjectDTO1.setId(1L);
        subObjectDTO1.setName("NEW NAME1");
        subObjectDTO1.setSumInsured(100.0);
        subObjectDTO1.setRiskType(Constants.RiskType.FIRE.toString());
        subObjectDTOS.add(subObjectDTO1);

        SubObjectDTO subObjectDTO2 = new SubObjectDTO();
        subObjectDTO2.setId(2L);
        subObjectDTO2.setName("NEW NAME2");
        subObjectDTO2.setSumInsured(8.0);
        subObjectDTO2.setRiskType(Constants.RiskType.THEFT.toString());
        subObjectDTOS.add(subObjectDTO2);

        return subObjectDTOS;
    }
}
