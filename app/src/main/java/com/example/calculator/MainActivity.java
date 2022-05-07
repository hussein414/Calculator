package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String input, output, newOutput;
    private TextView inputTextview, outputTextview;

    /*private Button button0, button1, button2, button3, button4, button5, button6,
            button7, button8, button9, buttonMultiply, buttonSum, buttonDivision,
            buttonClear, buttonPower, buttonPercent, buttonMinus, buttonEquals, buttonPoint;*/


    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        outputTextview = findViewById(R.id.outputType);
        inputTextview = findViewById(R.id.inputType);

    }

 /*   private void bindViews() {
    /*    button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        buttonMultiply = findViewById(R.id.buttonMulti);
        buttonSum = findViewById(R.id.buttonSum);
        buttonDivision = findViewById(R.id.buttonDivision);
        buttonClear = findViewById(R.id.buttonClear);
        buttonPower = findViewById(R.id.buttonPower);
        buttonPercent = findViewById(R.id.buttonPercent);
        buttonMinus = findViewById(R.id.buttonMinus);
        buttonEquals = findViewById(R.id.buttonEquals);
        buttonPoint = findViewById(R.id.buttonPoint);         */



    public void onButtonClicked( View view ) {
        Button button = (Button) view;
        String data = button.getText().toString();
        switch (data) {
            case "C":
                input = null;
                output = null;
                newOutput = null;
                outputTextview.setText("");
                break;
            case "^":
                solve();
                input += "^";
                break;
            case "*":
                solve();
                input += "*";
                break;
            case "%":
                input += "%";
                double d = Double.parseDouble(inputTextview.getText().toString()) / 100;
                outputTextview.setText(String.valueOf(d));
                break;
            case "=":
                solve();
                break;
            default:
                if (input == null) {
                    input = "";
                }
                if (data.equals("+") || data.equals("/") || data.equals("-")) {
                    solve();
                }
                input += data;
        }
        inputTextview.setText(input);
    }

    private void solve() {
        if (input.split("\\+").length == 2) {
            String[] numbers = input.split("\\+");
            try {
                double d = Double.parseDouble(numbers[0]) + Double.parseDouble(numbers[1]);
                output = Double.toString(d);
                newOutput = cutDecimal(output);
                outputTextview.setText(output);
                input = d + "";

            } catch (Exception e) {
                outputTextview.setError(e.getMessage());

            }
        }

        if (input.split("\\*").length == 2) {
            String[] numbers = input.split("\\*");
            try {
                double d = Double.parseDouble(numbers[0]) * Double.parseDouble(numbers[1]);
                output = Double.toString(d);
                newOutput = cutDecimal(output);
                outputTextview.setText(output);
                input = d + "";

            } catch (Exception e) {
                outputTextview.setError(e.getMessage());

            }
        }

        if (input.split("-").length == 2) {
            String[] numbers = input.split("-");
            try {
                if(Double.parseDouble(numbers[0]) < Double.parseDouble(numbers[1])){
                    double d = Double.parseDouble(numbers[1]) - Double.parseDouble(numbers[0]);
                    output = Double.toString(d);
                    newOutput = cutDecimal(output);
                    outputTextview.setText(output);
                    input = d + "";
                }else {
                    double d = Double.parseDouble(numbers[0]) - Double.parseDouble(numbers[1]);
                    output = Double.toString(d);
                    newOutput = cutDecimal(output);
                    outputTextview.setText(output);
                    input = d + "";

                }


            } catch (Exception e) {
                outputTextview.setError(e.getMessage());

            }
        }

        if (input.split("/").length == 2) {
            String[] numbers = input.split("/");
            try {
                double d = Double.parseDouble(numbers[0]) / Double.parseDouble(numbers[1]);
                output = Double.toString(d);
                newOutput = cutDecimal(output);
                outputTextview.setText(output);
                input = d + "";

            } catch (Exception e) {
                outputTextview.setError(e.getMessage());

            }
        }

        if (input.split("\\^").length == 2) {
            String[] numbers = input.split("\\^");
            try {
                double d = Math.pow(Double.parseDouble(numbers[0]), Double.parseDouble(numbers[1]));
                output = Double.toString(d);
                newOutput = cutDecimal(output);
                outputTextview.setText(output);
                input = d + "";

            } catch (Exception e) {
                outputTextview.setError(e.getMessage());

            }
        }
    }

    private String cutDecimal( String number ) {
        String[] n = number.split("\\.");
        if (n.length >1){
            if (n[1].equals("0")){
                number = n[0];
            }
        }
        return number;
    }
}