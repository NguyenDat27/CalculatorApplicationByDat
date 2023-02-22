package com.example.calculatorapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
public class MainActivity extends AppCompatActivity {

    TextView resultTv, solutionTv;
    MaterialButton buttonExponential, buttonBack, buttonPercent;
    MaterialButton buttonDivide, buttonMultiply, buttonAdd, buttonMinus, buttonEquals;
    MaterialButton button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;
    MaterialButton buttonAC, buttonDot;
    String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        solutionTv = findViewById(R.id.id_solution);
        resultTv = findViewById(R.id.id_result);

        button0 = findViewById(R.id.bt_0);
        button1 = findViewById(R.id.bt_1);
        button2 = findViewById(R.id.bt_2);
        button3 = findViewById(R.id.bt_3);
        button4 = findViewById(R.id.bt_4);
        button5 = findViewById(R.id.bt_5);
        button6 = findViewById(R.id.bt_6);
        button7 = findViewById(R.id.bt_7);
        button8 = findViewById(R.id.bt_8);
        button9 = findViewById(R.id.bt_9);

        buttonDot = findViewById(R.id.bt_dot);
        buttonEquals = findViewById(R.id.bt_equals);
        buttonAC = findViewById(R.id.bt_ac);
        buttonPercent = findViewById(R.id.bt_percent);
        buttonAdd = findViewById(R.id.bt_add);
        buttonMinus = findViewById(R.id.bt_minus);
        buttonMultiply = findViewById(R.id.bt_multiply);
        buttonDivide = findViewById(R.id.bt_divide);
        buttonExponential = findViewById(R.id.bt_exponential);
        buttonBack = findViewById(R.id.bt_back);

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = solutionTv.getText().toString();
                solutionTv.setText(data + "0");
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = solutionTv.getText().toString();
                solutionTv.setText(data + "1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = solutionTv.getText().toString();
                solutionTv.setText(data + "2");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = solutionTv.getText().toString();
                solutionTv.setText(data + "3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = solutionTv.getText().toString();
                solutionTv.setText(data + "4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = solutionTv.getText().toString();
                solutionTv.setText(data + "5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = solutionTv.getText().toString();
                solutionTv.setText(data + "6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = solutionTv.getText().toString();
                solutionTv.setText(data + "7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = solutionTv.getText().toString();
                solutionTv.setText(data + "8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = solutionTv.getText().toString();
                solutionTv.setText(data + "9");
            }
        });

        buttonAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                solutionTv.setText("");
                resultTv.setText("0");
            }
        });

        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = solutionTv.getText().toString();
                solutionTv.setText(data + ".");
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = solutionTv.getText().toString();
                solutionTv.setText(data + "+");
            }
        });

        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = solutionTv.getText().toString();
                solutionTv.setText(data + "-");
            }
        });

        buttonPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = solutionTv.getText().toString();
                solutionTv.setText(data + "%");
            }
        });

        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = solutionTv.getText().toString();
                solutionTv.setText(data + "×");
            }
        });
        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = solutionTv.getText().toString();
                solutionTv.setText(data + "÷");
            }
        });
        buttonExponential.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = solutionTv.getText().toString();
                solutionTv.setText(data + "^");
            }
        });
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = solutionTv.getText().toString();
                if(data.length() > 1)
                {
                    data = data.substring(0,data.length()-1);
                }
                else
                {
                    data="";
                }
                solutionTv.setText(data);
            }
        });
        buttonEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = solutionTv.getText().toString();

                data = data.replaceAll("×", "*");
                data = data.replaceAll("%", "/100");
                data = data.replaceAll("÷", "/");
                String data_temp = data.replaceAll("(\\d+)\\^(\\d+)", "Math.pow($1, $2)"); //covert into pow(a,b)
                try {
                    Context rhino = Context.enter();
                    rhino.setOptimizationLevel(-1);

                    String tempfinalResult = "";

                    Scriptable scriptable = rhino.initStandardObjects();
                    tempfinalResult = rhino.evaluateString(scriptable, data_temp, "Javsscript", 1, null).toString();
                    float tempResult = Float.parseFloat(tempfinalResult);
                    Math.round((tempResult*10000000)/10000000);
                    String finalResult = String.valueOf(tempResult);
                    resultTv.setText(finalResult);

                } catch (Exception e) {
                    solutionTv.setText("");
                    resultTv.setText("0");
                }
            }
        });
    }
}
