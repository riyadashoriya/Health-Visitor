package net.learn2develop.calculator;

//import net.example.pro.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;

public class Checkedoptions extends Activity {
    //	private CheckBox cb;
    private CheckBox c;
    private CheckBox d;
    private CheckBox e;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkedoptions);
    }

    public void onClickm(View view) throws ParseException {
        c = (CheckBox) findViewById(R.id.tea);
        d = (CheckBox) findViewById(R.id.rice);
        e = (CheckBox) findViewById(R.id.dal);
        ParseObject tesOb;
        tesOb = new ParseObject("tesOb");

        if (c.isChecked() && d.isChecked() && !e.isChecked()) {
            tesOb.put("Tea", 16);
            tesOb.put("Rice", 300);
            tesOb.save();
            Intent i = new Intent(Checkedoptions.this, Result.class);
            Toast.makeText(getApplicationContext(),
                    "Your total calorie intake is 316!" + "\n" + "And vitamin intake is 18",
                    Toast.LENGTH_LONG).show();

            startActivity(i);
        } else if (d.isChecked() && !c.isChecked() && !e.isChecked()) {
            tesOb.put("Rice", 300);

            tesOb.save();
            Intent i = new Intent(Checkedoptions.this, Result.class);
            Toast.makeText(getApplicationContext(),
                    "Your calorie intake is 300 per plate!" + "\n" + "And vitamin intake is 18",
                    Toast.LENGTH_LONG).show();

            startActivity(i);

        } else if (c.isChecked() && !d.isChecked() && !e.isChecked()) {
            tesOb.put("Tea", 16);


            tesOb.save();
            Intent i = new Intent(Checkedoptions.this, Result.class);
            Toast.makeText(getApplicationContext(),
                    "Your calorie intake is 16 per cup!" + "\n" + "And vitamin intake is 00",
                    Toast.LENGTH_LONG).show();

            startActivity(i);

        } else if (!c.isChecked() && !d.isChecked() && !e.isChecked()) {

            tesOb.save();
            Intent i = new Intent(Checkedoptions.this, Result.class);
            Toast.makeText(getApplicationContext(),
                    "Your total calorie intake is 00!" + "\n" + "And vitamin intake is 00",
                    Toast.LENGTH_LONG).show();

            startActivity(i);

        } else if (!c.isChecked() && !d.isChecked() && e.isChecked()) {
            tesOb.put("Dal", 212);

            tesOb.save();
            Intent i = new Intent(Checkedoptions.this, Result.class);
            Toast.makeText(getApplicationContext(),
                    "Your calorie intake is 212 per plate!" + "\n" + "And vitamin intake is 24",
                    Toast.LENGTH_LONG).show();

            startActivity(i);


        } else if (!c.isChecked() && d.isChecked() && e.isChecked()) {
            tesOb.put("Dal", 212);
            tesOb.put("Rice", 300);
            tesOb.save();
            Intent i = new Intent(Checkedoptions.this, Result.class);
            Toast.makeText(getApplicationContext(),
                    "Your total calorie intake is 512!" + "\n" + "And vitamin intake is 42",
                    Toast.LENGTH_LONG).show();

            startActivity(i);


        } else if (c.isChecked() && !d.isChecked() && e.isChecked()) {
            tesOb.put("Dal", 212);
            tesOb.put("Tea", 16);
            tesOb.save();
            Intent i = new Intent(Checkedoptions.this, Result.class);
            Toast.makeText(getApplicationContext(),
                    "Your total calorie intake is 228!" + "\n" + "And vitamin intake is 24",
                    Toast.LENGTH_LONG).show();

            startActivity(i);


        } else {
            tesOb.put("Dal", 212);
            tesOb.put("Rice", 300);
            tesOb.put("Tea", 16);
            tesOb.save();
            Intent i = new Intent(Checkedoptions.this, Result.class);
            Toast.makeText(getApplicationContext(),
                    "Your total calorie intake is 528!" + "\n" + "And vitamin intake is 42",
                    Toast.LENGTH_LONG).show();

            startActivity(i);


        }


    }

}
