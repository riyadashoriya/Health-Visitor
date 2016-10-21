package net.learn2develop.calculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.CalendarView.OnDateChangeListener;
import android.widget.Toast;

//    import android.view.View;


public class Nut extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nut);
        CalendarView calendarView = (CalendarView) findViewById(R.id.calendarView1);
        calendarView.setOnDateChangeListener(new OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month,
                                            int dayOfMonth) {
                Toast.makeText(getApplicationContext(), "" + dayOfMonth + "/" + (month + 1) + "/" + year, Toast.LENGTH_LONG).show();// TODO Auto-generated method stub
                Intent i = new Intent(Nut.this, Result.class);
                startActivity(i);
            }
        });
    }
}