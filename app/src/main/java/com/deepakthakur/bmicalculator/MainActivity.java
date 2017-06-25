package com.deepakthakur.bmicalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //here define your txtboxes and labels

        final EditText etxtheight = (EditText) findViewById(R.id.etxtheight);
        final EditText etxtweight = (EditText) findViewById(R.id.etxtweight);
        final TextView result = (TextView) findViewById(R.id.result );

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                String str1 = etxtheight.getText().toString();
                String str2 = etxtweight.getText().toString();


                if (TextUtils.isEmpty(str1))
                {
                    etxtheight.setError("please enter your height");
                    etxtheight.requestFocus();
                    return;

                }

                if (TextUtils.isEmpty((str2)))
                {
                    etxtweight.setError("please enter weight");
                    etxtweight.requestFocus();
                    return;
                }
                //Get the user values from the widget reference
                float weight = Float.parseFloat(str1);
                float height = Float.parseFloat(str2)/100;

//Calculate BMI value
                float bmiValue = calculateBMI(weight, height);

//Define the meaning of the bmi value
                String bmiInterpretation = interpretBMI(bmiValue);

                result.setText(String.valueOf(bmiValue + "-" + bmiInterpretation));

            }
        });

    }

    //Calculate BMI
    private float calculateBMI (float weight, float height) {
        return  (weight / (height * height));
    }

    // Interpret what BMI means
    private String interpretBMI(float bmiValue) {

        if (bmiValue < 16) {
            return "Severely underweight";
        } else if (bmiValue < 18.5) {

            return "Underweight";
        } else if (bmiValue < 25) {

            return "Normal";
        } else if (bmiValue < 30) {

            return "Overweight";
        } else {
            return "Obese";
        }
    }
}