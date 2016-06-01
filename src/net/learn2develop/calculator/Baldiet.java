package net.learn2develop.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Baldiet extends Activity{

    /** Called when the activity is first created. */
	private RadioGroup rg1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.baldiet);
    }
    public void calculateClickHandler(View view) {
    	rg1=(RadioGroup)findViewById(R.id.rdbGp1);
        // make sure we handle the click of the calculator button
        if (view.getId() == R.id.calculate1Button) {
   
         // get the users values from the widget references
          if(rg1.getCheckedRadioButtonId() == R.id.rdb1)
          {
        	  EditText calText = (EditText)findViewById(R.id.calText);
        	  TextView resultText = (TextView)findViewById(R.id.result1Label);
        	  float calo = Float.parseFloat(calText.getText().toString());
            
         // interpret the meaning of the bmi value
         String bmiInterpretation = interpretBMI(calo);
    
         // now set the value in the result text

         resultText.setText(calo + "calories is your total intake. So the balanced diet suggested is -" + bmiInterpretation);
        }        else {
        	EditText calText1 = (EditText)findViewById(R.id.calText);
        	  TextView resultText1 = (TextView)findViewById(R.id.result1Label);
                   
        	float calof = Float.parseFloat(calText1.getText().toString());
        	String calInterpretation = interpret(calof);
        resultText1.setText(calof + " Calories is your total intake. So the balanced diet suggested is -"+"\n" + calInterpretation);
        }}
        }
    
    
       // the formula to calculate the BMI index

       // check for http://en.wikipedia.org/wiki/Body_mass_index
      // private float calculateBMI (float weight, float height) {

        //return (float) (weight * 4.88 / (height * height));
       //}

    private String interpret(float calof)
    {
    	  if (calof < 1800) {
    	         return "Consume more healthy fats."
    	  +"\n"+"Eat more protiens."
    	        		 +"\n"+"Cook food using butter instead of oil."+"\n"+
    	        		 "Eat more snacks."+"\n"
    	        		 +"Quit smoking.";
    	        } else if (calof < 2200) {

    	         return
"Hydration."+"\n"+
"Take Vitamins and Supplements."+"\n"+ 
"Quit Smoking."+"\n"+
"Add B12 to your daily supplements."+"\n"+
"Really cut back on salt. "+"\n"+
"Check your multivitamin for Iron — and toss it if it has it."+"\n"+
"Exercise Daily."+"\n"+
"Avoid Stress";
    	        }
    	       
    	        else {
    	         return "Get rid of unhealthy foods."
    	        +"\n"+"Write out a plan."
    	        		 +"\n"+"Dont starve yourself."+
    	        "\n"+"Stock up on healthy foods."
    	        +"\n"+"Order something healthy when eating out."
    	        +"\n"+"Drink more water."
    	        +"\n"+"Chew slowly.";
    	        }
    }
       // interpret what BMI means
       private String interpretBMI(float calo) {

        if (calo < 2200) {
         return "Keep a food diary or use an online calorie tracker to help make sure you are meeting your calorie needs."+"\n"
        +"Add nonfat dried milk powder to your milk, soup, yogurt, mashed potatoes and hot cereal."+"\n"+"" +
        		"A 1/4-cup serving of the powder adds 109 calories and 11 grams of protein."+"\n"+
        "To help make sure you gain muscle and not fat, add strength training to your exercise routine."+"\n"+
         "Snack on high-calorie foods."+"\n"+"Fruit and nut mixes," +
         		" peanut butter on whole-wheat toast, cheese and crackers are all nutrient-rich, high-calorie snack.";

                 } else if (calo < 2800) {

         return "Exercise"+"\n"+"Watch out for portion distortion."+
         "\n"+"Eat 5 servings of fruits and veggies a day."
         +"\n"+"Don't skip breakfast."+"\n"+
         "Get extra energy from fruit or vegetable snacks.";
         
        } 
        else {
         return "Eat healthy."+"\n"+
"Stay at a healthy weight."+"\n"+
        		 "Regular exercise."+"\n"+ 
"Be smoke-free."+"\n"+
"Take any medications you need."+"\n"+ 
"Avoid heavy drinking.";
        }
       }
}