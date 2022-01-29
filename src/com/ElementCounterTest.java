package com;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ElementCounterTest {
    private String input;
    private String[] actual;
    private String elementFile;
    private String elementFolder;

    @Before
    public void setUp() {
        input = "root/folder1/file.txt";
        actual = new String[]{"root", "folder1", "file.txt"};
        elementFile = "file.txt";
        elementFolder = "folder";
    }

    @After
    public void tearDown() {
        input = null;
        actual = null;
        elementFile = null;
        elementFolder = null;
    }

    @Test
    public void testCount() {
        String[] expected = ElementCounter.count(input);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void testIsFileTrue() {
        boolean expected = ElementCounter.isFile(elementFile);
        Assert.assertTrue(expected);
    }

    @Test
    public void testIsFileFalse() {
        boolean expected = ElementCounter.isFile(elementFolder);
        Assert.assertFalse(expected);
    }
}