package test.java.com.myproject;

import org.junit.Test;

import main.java.com.myproject.App;

import org.junit.Assert;

public class sumTest {

    //testing getSize
    @Test
    public void test1() {
        sum object = new sum();
        Assert.assertEquals(5, object.add(2,3));
    }
}
