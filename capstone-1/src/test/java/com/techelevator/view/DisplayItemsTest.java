package com.techelevator.view;

import org.junit.Test;
import org.junit.Assert;
import java.util.Map;

public class DisplayItemsTest {

    @Test
    public void Display_Items() {

        Map<String, String> tests = GatherItems.gatherItems();
        String testString = tests.get("A4");
        String[] values = testString.split("[|]");

        Assert.assertTrue(tests.containsKey("A4"));
        Assert.assertTrue(values[0].equals("Cloud Popcorn"));
        Assert.assertTrue(values[1].equals("3.65"));
        Assert.assertTrue(values[2].equals("Chip"));
        Assert.assertTrue(values[3].equals("5"));
    }

    @Test
    public void Display_Items_Null() {

        Map<String, String> tests = GatherItems.gatherItems();
        String testString = tests.get("");

        Assert.assertFalse(tests.containsKey(""));
        Assert.assertTrue(testString == null);
    }
}
