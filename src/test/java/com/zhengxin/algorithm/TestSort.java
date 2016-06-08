package com.zhengxin.algorithm;

import org.junit.*;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhengxin
 */
public class TestSort {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {}

    @AfterClass
    public static void tearDownAfterClass() throws Exception {}

    @Before
    public void setUp() throws Exception {}

    @After
    public void tearDown() throws Exception {}

    @Test
    public void testInsertSort(){

        List<Integer> numbers = Arrays.asList(5, 8, 62, 57, 19, 57, 9);
        List<Integer> expectNumbers = Arrays.asList(5, 8, 9, 19, 57, 57, 62);
        Assert.assertEquals(expectNumbers, Sort.insertSort(numbers));

    }

    @Test
    public void testQuickSort(){

        List<Integer> numbers = Arrays.asList(5, 8, 62, 57, 19, 57, 9);
        List<Integer> expectNumbers = Arrays.asList(5, 8, 9, 19, 57, 57, 62);
        Assert.assertEquals(expectNumbers, Sort.quickSort(numbers));

    }

    @Test
    public void testMergeSort(){

        List<Integer> numbers = Arrays.asList(5, 8, 62, 57, 19, 57, 9);
        List<Integer> expectNumbers = Arrays.asList(5, 8, 9, 19, 57, 57, 62);
        Assert.assertEquals(expectNumbers, Sort.mergeSort(numbers));

    }




}
