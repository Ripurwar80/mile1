package test.java.com.myproject;

import org.junit.Test;

import main.java.com.myproject.sum;

import org.junit.Assert;

public class SumTest {

    //testing getSize
    @Test
    public void test1() {
        Sum object = new Sum();
        Assert.assertEquals(5, object.add(2,3));
        Assert.assertEquals(9, object.add(6,3));
        Assert.assertEquals(11, object.add(7,4));
        Assert.assertEquals(15, object.add(6,9));
    }
}
