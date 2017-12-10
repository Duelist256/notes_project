package com.epam.enote.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class PasswordUtilTest {
    @Test
    public void hashPassword() throws Exception {
        String hashedPassword = PasswordUtil.hashPassword("asdasd");
        assertEquals("5fd924625f6ab16a19cc9807c7c506ae1813490e4ba675f843d5a10e0baacdb8",hashedPassword);
    }
}