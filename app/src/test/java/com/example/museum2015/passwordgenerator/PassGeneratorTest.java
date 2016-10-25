package com.example.museum2015.passwordgenerator;

import android.content.ClipboardManager;
import android.content.Context;

import org.junit.Test;

import static android.content.Context.CLIPBOARD_SERVICE;
import static org.junit.Assert.*;

/**
 * Created by Museum2015 on 24/10/2016.
 */
public class PassGeneratorTest {
    /*
     * Test to see if the generatePassword() function works correctly with a certain input
     * @return true since if the number of numbers and symbols are both 0, the generated password
     * should be of length 0
     */
    @Test
    public void generatePassword() throws Exception {
        String result = PassGenerator.generatePassword(0,0);
        assertTrue(result.length()==0);
    }

    /*
     * Test to see if the generatePassword() function works correctly with a certain input
     * @return true since if the number of numbers and symbols are both 4, the generated password
     * should be of length 8
     */
    @Test
    public void generatePassword1() throws Exception {
        String result = PassGenerator.generatePassword(4,4);
        assertTrue(result.length()==8);
    }

}