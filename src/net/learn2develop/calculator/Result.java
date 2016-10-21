package net.learn2develop.calculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
//import android.widget.TextView;

public class Result extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);


    }

    public void onClickr(View view) {
        Intent i = new Intent(Result.this, Checkedoptions.class);
        startActivity(i);
    }
}
