package com.zhengxin.algorithm;

import org.junit.*;

import java.util.Arrays;
import java.util.List;


/**
 * @author zhengxin
 */
public class TestSearch {
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {}

    @AfterClass
    public static void tearDownAfterClass() throws Exception {}

    @Before
    public void setUp() throws Exception {}

    @After
    public void tearDown() throws Exception {}

    @Test
    public void testBinarySearch(){

        List<Integer> numbers = Arrays.asList(1, 5, 7, 7, 8);

        Assert.assertFalse(Search.binarySearch(numbers, 0));
        Assert.assertTrue(Search.binarySearch(numbers, 1));
        Assert.assertFalse(Search.binarySearch(numbers, 3));
        Assert.assertTrue(Search.binarySearch(numbers, 5));
        Assert.assertTrue(Search.binarySearch(numbers, 7));
        Assert.assertTrue(Search.binarySearch(numbers, 8));
        Assert.assertFalse(Search.binarySearch(numbers, 10));

    }
}
