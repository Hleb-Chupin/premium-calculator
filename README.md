# REST Service for calculating premium insurance price 

Calculations are made according to provided in request body policy.

**POST method URL on localhost:**
localhost:8080/api/v1.0/premium/calculate

**TEST JSON data for API testing:**
_{
    "id":10,
    "number":"INSURANCE-330000-BALTICS-2021",
    "status":"REGISTERED",
    "policyObjects":[{
            "id":1,
            "name":"NEW NAME",
            "subObjects":[{
                "id":1,
                "name":"NEW NAME",
                "sumInsured":200,
                "riskType":"FIRE"
            }]
        }]
}_
