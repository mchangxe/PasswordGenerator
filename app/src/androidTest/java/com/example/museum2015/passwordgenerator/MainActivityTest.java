package com.example.museum2015.passwordgenerator;



import android.support.test.espresso.*;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static com.example.museum2015.passwordgenerator.R.id.button1;
import static com.example.museum2015.passwordgenerator.R.id.button2;
import static com.example.museum2015.passwordgenerator.R.id.textView1;
import static com.example.museum2015.passwordgenerator.R.id.textView2;
import static com.example.museum2015.passwordgenerator.R.id.textView3;


/**
 * Created by Museum2015 on 24/10/2016.
 */
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);


    @Test
    public void invalidCopyToClip() throws Exception {

    }

    @Test
    public void copyToClipboardTest() throws Exception {

    }

    @Test
    public void invalidNumberAndSymbols() throws Exception {

    }

    @Test
    public void conditionsNotModified() throws Exception {

    }

}