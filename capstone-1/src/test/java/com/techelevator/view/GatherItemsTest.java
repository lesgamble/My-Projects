package com.techelevator.view;

import org.junit.Assert;
import org.junit.Test;
import java.util.Map;

public class GatherItemsTest {

    @Test
    public void Gather_Items(){

        Map<String,String> tests = GatherItems.gatherItems();

        Assert.assertTrue(tests.containsKey("A1"));
        Assert.assertTrue(tests.containsValue("Potato Crisps|3.05|Chip|5"));
        Assert.assertTrue(tests.containsKey("D4"));
        Assert.assertTrue(tests.containsValue("Triplemint|0.75|Gum|5"));
    }

    @Test
    public void Gather_Items_Null(){

        Map<String,String> tests = GatherItems.gatherItems();

        Assert.assertFalse(tests.containsKey(""));
        Assert.assertFalse(tests.containsValue(""));
        Assert.assertFalse(tests.containsKey(null));
        Assert.assertFalse(tests.containsValue(null));
    }
}
