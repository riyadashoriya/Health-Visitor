package net.learn2develop.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
//import android.widget.Toast;


public class Bmi extends Activity {
    /**
     * Called when the activity is first created.
     */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi);
    }


    public void calculateClickHandler(View view) {
        // make sure we handle the click of the calculator button

        if (view.getId() == R.id.calculateButton) {

            // get the references to the widgets
            EditText weightText = (EditText) findViewById(R.id.weightText);
            EditText heightText = (EditText) findViewById(R.id.heightText);
            TextView resultText = (TextView) findViewById(R.id.resultLabel);

            // get the users values from the widget references


            float weight = Float.parseFloat(weightText.getText().toString());
            float height = Float.parseFloat(heightText.getText().toString());

            // calculate the bmi value

            float bmiValue = calculateBMI(weight, height);

            // interpret the meaning of the bmi value
            String bmiInterpretation = interpretBMI(bmiValue);

            // now set the value in the result text

            resultText.setText("Your BMI is: " + bmiValue + "\n" + bmiInterpretation);
        }
    }

    // the formula to calculate the BMI index

    // check for http://en.wikipedia.org/wiki/Body_mass_index
    private float calculateBMI(float weight, float height) {

        return (float) (weight * 4.88 / (height * height));
    }


    // interpret what BMI means
    private String interpretBMI(float bmiValue) {

        if (bmiValue < 16) {
            return "You are Severely underweight";
        } else if (bmiValue < 18.5) {

            return "You are Underweight";
        } else if (bmiValue < 25) {

            return "You are Normal";
        } else if (bmiValue < 30) {

            return "You are Overweight";
        } else {
            return "You are Obese";
        }

    }
}