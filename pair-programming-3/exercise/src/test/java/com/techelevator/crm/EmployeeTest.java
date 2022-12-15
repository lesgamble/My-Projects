package com.techelevator.crm;

import com.techelevator.hr.Employee;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class EmployeeTest {

    @Test

    public void getBalanceDue(){
        Map<String, Double> serviceMap = new HashMap<>();
        serviceMap.put("Grooming", 20.00);
        serviceMap.put("Walking", 10.00);
        serviceMap.put("Sitting", 3.00);

        Employee test = new Employee("Employee", "Test");
        test.getBalanceDue(serviceMap);

        Assert.assertEquals(test.getBalanceDue(serviceMap), 28.00);

    }

}
