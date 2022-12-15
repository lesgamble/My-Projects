package com.techelevator.crm;

import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.*;

public class CustomerTest {


    @Test

    public void getBalanceDue(){
        Map<String, Double> serviceMap = new HashMap<>();
        serviceMap.put("Grooming", 20.00);
        serviceMap.put("Walking", 10.00);
        serviceMap.put("Sitting", 3.00);

        Customer test = new Customer("Testerson", "Test");
        test.getBalanceDue(serviceMap);

        Assert.assertEquals(test.getBalanceDue(serviceMap), 33.00);

    }
}
