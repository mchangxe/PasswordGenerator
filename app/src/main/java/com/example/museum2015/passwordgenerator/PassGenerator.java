package com.example.museum2015.passwordgenerator;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * Created by Museum2015 on 24/10/2016.
 */

public class PassGenerator {

    /*
     * Generates a random string password that has a certain number of numbers and symbols
     * @param numberOfNum
     * @param numberOfSym
     * @retrun A string that is the newly generated password
     */
    public static String generatePassword(int numberOfNum, int numberOfSym){
        String result = RandomStringUtils.random(numberOfNum, false, true)
                + RandomStringUtils.randomAscii(numberOfSym);
        return result;
    }


}
