package net.learn2develop.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class Exsugg extends Activity {
    /** Called when the activity is first created. */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exsugg);
    }

 
    public void calculateClickHandler(View view) {
     // make sure we handle the click of the calculator button

     if (view.getId() == R.id.calculate2Button) {

      // get the references to the widgets
      EditText caloText = (EditText)findViewById(R.id.caloText);
      EditText bmiText = (EditText)findViewById(R.id.bmiText);
      TextView resultText = (TextView)findViewById(R.id.result4Label);
 
      // get the users values from the widget references

      float weight = Float.parseFloat(caloText.getText().toString());
      float height = Float.parseFloat(bmiText.getText().toString());
 
      // calculate the bmi value

     // float bmiValue = calculateBMI(weight, height);
 
      // interpret the meaning of the bmi value
      String bmiInterpretation = interpretBMI(weight,height);
 
      // now set the value in the result text

      resultText.setText("Your exercise and workout planning should be" + "-" + bmiInterpretation);
     }
    }
 
    // the formula to calculate the BMI index

    // check for http://en.wikipedia.org/wiki/Body_mass_index
   /* private float calculateBMI (float weight, float height) {

     return (float) (weight * 4.88 / (height * height));
    }

 */
    // interpret what BMI means
    private String interpretBMI(float calo, float bmi) {

     if (calo < 1800 && bmi <18.5) {
      return "\n"+"Walking 15 Min. " +
    		  	"\n"+
      		"Yoga. " +"\n"+
      		"Dancing 10 min." +"\n"+
      		"Swimming.";
      
     } else if (calo < 1800 && bmi<25) {

      return "\n"+"Walking 30 Min. " +
    		  "\n"+"Yoga. " +
    		  "\n"+"Dancing 20 min." +
    		  "\n"+"Swimming." +
    		  "\n"+"Aerobics.";
     } else if (calo < 1800 && bmi>25) {

      return "\n"+"Walking and Joging. " +"\n"+
      		"Light yard work. " +"\n"+
      		"\n"+"Dancing 20 min. " +
      		"\n"+"Swimming. " +
      		"\n"+"Pushups and situps (10 Each).";
     } else if (calo < 2800 && bmi <18.5) {

      return "\n"+"Walking 30 Min. " +
    		  "\n"+"Yoga. " +
    		  "\n"+"Dancing 20 min." +
    		  "\n"+	"Swimming." +
    		  "\n"+	"Aerobics.";
     } 
     else if (calo<2800 && bmi <25){
      return "\n"+"Walking and Joging. " +
    		  "\n"+"Light yard work. " +
    		  "\n"+"Dancing 20 min. " +
    		  "\n"+"Swimming. " +
    		  "\n"+"Pushups and situps (10 Each).";
     }
     else if (calo<2800 && bmi >25)
     {
    	 return "\n"+"Jogging and Running. " +
    			 "\n"+"Swimming. " +
    			 "\n"+"Playing outdoor games. " +
    			 "\n"+"Pushups and Situps (25-30Each)." +
    			 "\n"+"Streching." +
    			 "\n"+"Riding Bicycle.";
     }
     else if (calo>2800 && bmi<18.5)
     {
    	 return "\n"+"Walking and Joging. " +
    			 "\n"+"Light yard work. " +
    			 "\n"+"Dancing 20 min. " +
    			 "\n"+"Swimming.";
     }
     else if (calo>2800 && bmi<25)
     {
    	 return "\n"+"Jogging and Running. " +
    			 "\n"+"Swimming. " +
    			 "\n"+"Playing outdoor games. " +
    			 "\n"+"Pushups and Situps (25-30Each)." +
    			 "\n"+"Streching.";
     }
     else {
    	 return "\n"+"Running." +
    			 "\n"+"Swimming. " +
    			 "\n"+"Aerobics. " +
    			 "\n"+"Gyming. " +
    			 "\n"+"Playing Outdoor Games. " +
    			 "\n"+"Yoga. ";
     }

    }
}