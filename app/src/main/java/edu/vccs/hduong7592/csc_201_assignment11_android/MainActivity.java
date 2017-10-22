/**
 * Hieu Duong
 * CSC 201
 * Assignment 11
 * Problem 11.12:
 *
 * (Sum ArrayList) Write the following method that returns the sum of all numbers
 * in an ArrayList:
 * public static double sum(ArrayList<Double> list)
 * Write a test program that prompts the user to enter 5 numbers, stores them in an
 * array list, and displays their sum.
 *
 * 10/21/2017
 */

package edu.vccs.hduong7592.csc_201_assignment11_android;

import android.content.DialogInterface;
import android.support.constraint.solver.ArrayLinkedVariables;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText Value1,Value2,Value3,Value4,Value5;
    Button SubmitBtn;
    TextView ResultLb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Value1 = (EditText) findViewById(R.id.Value1Txt);
        Value2 = (EditText) findViewById(R.id.Value2Txt);
        Value3 = (EditText) findViewById(R.id.Value3Txt);
        Value4 = (EditText) findViewById(R.id.Value4Txt);
        Value5 = (EditText) findViewById(R.id.Value5Txt);
        SubmitBtn = (Button) findViewById(R.id.SubmitBtn);
        ResultLb = (TextView) findViewById(R.id.ResultLb);

        final ArrayList<Double> list = new ArrayList<Double>();
        SubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double val1 = 0.0;
                try{
                    val1 = Double.parseDouble(Value1.getText().toString());
                    list.add(val1);
                }
                catch (Exception e){
                    showSimpleDialog("Value 1 is required!", 1);
                }

                double val2 = 0.0;
                try{
                    val2 = Double.parseDouble(Value2.getText().toString());
                    list.add(val2);
                }
                catch (Exception e){
                    showSimpleDialog("Value 2 is required!", 1);
                }

                double val3 = 0.0;
                try{
                    val3 = Double.parseDouble(Value3.getText().toString());
                    list.add(val3);
                }
                catch (Exception e){
                    showSimpleDialog("Value 3 is required!", 1);
                }

                double val4 = 0.0;
                try{
                    val4 = Double.parseDouble(Value4.getText().toString());
                    list.add(val4);
                }
                catch (Exception e){
                    showSimpleDialog("Value 4 is required!", 1);
                }

                double val5 = 0.0;
                try{
                    val5 = Double.parseDouble(Value5.getText().toString());
                    list.add(val5);
                }
                catch (Exception e){
                    showSimpleDialog("Value 5 is required!", 1);
                }

                ResultLb.setText("Total: "+sum(list));
            }
        });


    }

    /**
     * Calculate sum of array list method
     * @param list
     * @return
     */
    public double sum(ArrayList<Double> list){
        double sum = 0.0;
        for(double i: list){
            sum+=i;
        }
        return sum;
    }

    /**
     * Alert box
     * @param Message
     */

    public void showSimpleDialog(String Message, final int WhichValue) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setCancelable(false);
        builder.setTitle("Error!!!");
        builder.setMessage(Message);
        builder.setPositiveButton("Got it!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //
                switch (WhichValue){
                    case 1: Value1.requestFocus();
                        break;
                    case 2: Value2.requestFocus();
                        break;
                    case 3: Value3.requestFocus();
                        break;
                    case 4: Value4.requestFocus();
                        break;
                    case 5: Value5.requestFocus();
                        break;
                }
            }
        });
        builder.create().show();
    }
}
