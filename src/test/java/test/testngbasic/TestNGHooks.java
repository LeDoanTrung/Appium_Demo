package test.testngbasic;

import org.testng.annotations.*;

public class TestNGHooks {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite 1");
    }

    @BeforeSuite
    public void beforeSuite2() {
        System.out.println("Before Suite 2");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test 1");
    }

    @BeforeTest
    public void beforeTest2() {
        System.out.println("Before Test 2");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class 1");
    }

    @BeforeClass
    public void beforeClass2() {
        System.out.println("Before Class 2");
    }

    @BeforeGroups
    public void beforeGroups() {
        System.out.println("Before Groups 1");
    }

    @BeforeGroups
    public void beforeGroups2() {
        System.out.println("Before Groups 2");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method 1");
    }

    @BeforeMethod
    public void beforeMethod2() {
        System.out.println("Before Method 2");
    }

    @Test
    public void test() {
        System.out.println("Test 1");
    }

    @Test
    public void test2() {
        System.out.println("Test 2");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method 1");
    }

    @AfterMethod
    public void afterMethod2() {
        System.out.println("After Method 2");
    }

    @AfterGroups
    public void afterGroups() {
        System.out.println("After Groups 1");
    }

    @AfterGroups
    public void afterGroups2() {
        System.out.println("After Groups 2");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After Class 1");
    }

    @AfterClass
    public void afterClass2() {
        System.out.println("After Class 2");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("After Test 1");
    }

    @AfterTest
    public void afterTest2() {
        System.out.println("After Test 2");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite 1");
    }

    @AfterSuite
    public void afterSuite2() {
        System.out.println("After Suite 2");
    }
}
