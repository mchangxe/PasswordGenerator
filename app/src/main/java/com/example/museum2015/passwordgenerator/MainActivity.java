package com.example.museum2015.passwordgenerator;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import org.apache.commons.lang3.RandomStringUtils;
import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView passDisplay = (TextView) findViewById(R.id.textView1);
        passDisplay.setKeyListener(null);
        final TextView numbersText = (TextView) findViewById(R.id.textView2);
        final TextView symbolsText = (TextView) findViewById(R.id.textView3);
        Button create = (Button) findViewById(R.id.button1);
        Button copy = (Button) findViewById(R.id.button2);
        final PassGenerator pass = new PassGenerator();

        create.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick (View v){
                //check if the criteria for generating a password is provided by user
                if (numbersText.getText().toString().trim().length() != 0 &&
                        symbolsText.getText().toString().trim().length() != 0) {
                    int numberOfNumbers = Integer.parseInt((String) numbersText.getText().toString());
                    int numberOfSymbols = Integer.parseInt(symbolsText.getText().toString());

                    if (numberOfNumbers <= 0 || numberOfSymbols <= 0 ) {
                        invalidNumberAndSymbols();
                    } else {
                        passDisplay.setText(pass.generatePassword(numberOfNumbers, numberOfSymbols));
                    }
                }else{
                    conditionsNotModified();
                }
            }

        });

        copy.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick (View v){
                //check if the display is empty
                if (passDisplay.getText().toString().trim().length() != 0){
                    copyToClipboard(passDisplay.getText().toString());
                }else{
                    invalidCopyToClip();
                }
            }
        });

    }

    /*
     * Function for printing error message to the screen when the user clicks on the copy button
     * when a password hasn't been generated yet
     */
    public void invalidCopyToClip(){
        AlertDialog dialog1 = new AlertDialog.Builder(MainActivity.this).create();
        dialog1.setTitle("Cannot copy to clipboard");
        dialog1.setMessage("Please generate a password first");
        dialog1.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        dialog1.show();
    }

    /*
     * Copies the param string to the clipboard
     * @param input
     */
    public void copyToClipboard(String input){
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        String label = "password";
        ClipData clip = ClipData.newPlainText(label,input);
        clipboard.setPrimaryClip(clip);
    }

    public String getClipboardText(){
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        return clipboard.getPrimaryClip().toString();
    }

    /*
     * Function for printing error message to the screen when the user inputs 0 for either the
     * number of numbers or the number of symbols.
     */
    public void invalidNumberAndSymbols(){
        AlertDialog dialog1 = new AlertDialog.Builder(MainActivity.this).create();
        dialog1.setTitle("Your password cannot be generated");
        dialog1.setMessage("Your password must have both numbers and symbols");
        dialog1.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        dialog1.show();
    }

    /*
     * Function for printing error message to the screen when the user prompts to generate a
     * password without entering the length of the password
     */
    public void conditionsNotModified(){
        AlertDialog dialog1 = new AlertDialog.Builder(MainActivity.this).create();
        dialog1.setTitle("Cannot create password");
        dialog1.setMessage("Please input some criteria before generating");
        dialog1.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        dialog1.show();
    }


}
