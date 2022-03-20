package com.techelevator;

import org.junit.*;

import java.io.File;
import java.math.BigDecimal;
import java.util.Map;

import static org.junit.Assert.*;

public class MoneyManagerTest {

    private MoneyManager moneyTest;

    @BeforeClass
    public static void launchTests() {
        System.out.println("Starting Test Suite");
    }

    @AfterClass
    public static void shutDownTests() {
        System.out.println("Closing Test Suite");
    }

    @Before
    public void setup() {
        System.out.println("Instantiating MoneyManager");
        moneyTest = new MoneyManager();
    }

    @After
    public void teardown() {
        System.out.println("Reassigning MoneyManager to Null");
        moneyTest = null;
    }

    @Test
    public void FeedMoney_User_Input_Feed_$1_Test_Expect_Balance_$1() {
        //Arrange
        String input = "Feed $1";
        //Act
        BigDecimal expected = new BigDecimal("1.00");
        //Assert
        assertEquals(expected, moneyTest.feedMoney(input));
    }

    @Test
    public void FeedMoney_User_Input_Feed_$1_Test_Expect_Balance_$2() {
        //Arrange
        String input = "Feed $2";
        //Act
        BigDecimal expected = new BigDecimal("2.00");
        //Assert
        assertEquals(expected, moneyTest.feedMoney(input));
    }

    @Test
    public void FeedMoney_User_Input_Feed_$1_Test_Expect_Balance_$5() {
        //Arrange
        String input = "Feed $5";
        //Act
        BigDecimal expected = new BigDecimal("5.00");
        //Assert
        assertEquals(expected, moneyTest.feedMoney(input));
    }

    @Test
    public void FeedMoney_User_Input_Feed_$10_Test_Expect_Balance_$10() {
        //Arrange
        String input = "Feed $10";
        //Act
        BigDecimal expected = new BigDecimal("10.00");
        //Assert
        assertEquals(expected, moneyTest.feedMoney(input));
    }

    @Test
    public void FeedMoney_User_Input_Empty_String_Test_Expect_Balance_Unchanged() {
        //Arrange
        String input = "";
        //Act
        BigDecimal expected = new BigDecimal("0.00");
        //Assert
        assertEquals(expected, moneyTest.feedMoney(input));
    }
}
