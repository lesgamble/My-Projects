package com.techelevator.crm;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class PetTest {


    @Test

    public void listVaccinations(){
        ArrayList<String> testList = new ArrayList<>();
        testList.add("Rabies");
        testList.add("Distemper");
        testList.add("Parvo");

        Pet test = new Pet("Fido", "Dog");
        test.setVaccinations(testList);

        Assert.assertEquals(test.listVaccinations(), "Rabies, Distemper, Parvo");

    }



}
