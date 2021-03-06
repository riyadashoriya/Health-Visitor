package net.learn2develop.calculator;

//import com.parse.LogInCallback;
//import com.parse.Parse;
//import java.util.Arrays;
//import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import java.util.regex.Pattern;

//import com.parse.ParseFacebookUtils;
//import com.parse.ParseObject;
//import com.parse.SignUpCallback;
//import com.parse.ParseUser;
//import android.app.ProgressDialog;
//import android.text.Html;
//import android.text.method.LinkMovementMethod;
//import android.util.Log;
//import android.widget.TextView;

public class Login extends Activity {


    final Pattern EMAIL_ADDRESS_PATTERN = Pattern.compile(
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"

    );
    final Pattern USERNAME_PATTERN = Pattern.compile(
            "^[A-Za-z0-9_-]{3,15}$"
    );
    final Pattern NAME_PATTERN = Pattern.compile(
            "[a-zA-Z ]{3,25}"

    );
    private EditText aEdit;
    private EditText bEdit;
    private EditText cEdit;
    private EditText dEdit;
    private EditText eEdit;
    private EditText fEdit;
    private EditText gEdit;
    private CheckBox chk;
    //private ProgressDialog progressDialog;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //ParseFacebookUtils.initialize("yQriQzUQTcWwnuWQGF7SnRej410=");
        Parse.initialize(this, "3Cv42hAPqCrXkh6IkeN3S4WYp15cGfDWlofSJxrs", "KngCrNQYqFSMO2Mpaj9FqHZLfl8rzSiPAqKmF82P");

        setContentView(R.layout.login);
        int colorBlue = getResources().getColor(R.color.blue);
        String text = getString(R.string.clkheretosee);
        SpannableString spannable = new SpannableString(text);
        // here we set the color
        spannable.setSpan(new ForegroundColorSpan(colorBlue), 0, text.length(), 0);

    }

    public void onClick15(View v) throws ParseException {


        chk = (CheckBox) findViewById(R.id.signup_agree);


        aEdit = (EditText) findViewById(R.id.signup_name_value);
        final String a = aEdit.getText().toString();
        bEdit = (EditText) findViewById(R.id.signup_email);
        final String b = bEdit.getText().toString();
        cEdit = (EditText) findViewById(R.id.signup_username_value);
        final String c = cEdit.getText().toString();
        dEdit = (EditText) findViewById(R.id.signup_password_value);
        final String d = dEdit.getText().toString();
        eEdit = (EditText) findViewById(R.id.signup_address_value);
        final String e = eEdit.getText().toString();
        fEdit = (EditText) findViewById(R.id.signup_phonenumber_value);
        final String f = fEdit.getText().toString();
        gEdit = (EditText) findViewById(R.id.signup_retype_password_value);
        final String g = gEdit.getText().toString();
        final int fl = f.length();
        final int a1 = a.length();
        final int c1 = c.length();
        //final boolean emailVerifie;


        if (a.equals("") || b.equals("") || c.equals("") || d.equals("")
                || e.equals("") || f.equals("")) {
            Toast.makeText(getApplicationContext(),
                    "Please complete the sign up form",
                    Toast.LENGTH_LONG).show();
        } else {
            if (d.equals(g)) {
                if (checkName(a) && (a1 > 3) && (a1 < 26)) {
                    if (checkEmail(b)) {
                        if (checkUsername(c) && (c1 > 3) && (c1 < 16)) {
                            if (fl >= 10 && fl < 12) {
                                if (chk.isChecked()) {
                                    final ParseObject testObj1 = new ParseObject("TesOb1");
                                    testObj1.put("name", a);
                                    testObj1.put("EmailAddress", b);
                                    testObj1.put("Username", c);
                                    testObj1.put("Password", d);
                                    testObj1.put("Address", e);
                                    testObj1.put("PhoneNumber", f);

								/*	try {
										testObj1.save();
										//finish();
									}catch (ParseException e1) {
										e1.printStackTrace();		
									}
								*/
                                    final ParseUser user = new ParseUser();
                                    user.setUsername(c);
                                    user.setPassword(d);
                                    user.setEmail(b);
                                    //Toast.makeText(getApplicationContext(),
                                    //      "Please verify your email id.",
                                    //             Toast.LENGTH_LONG).show();
                                    //	boolean emailVerifie = user.getBoolean("emailVerified");
                                    // if(emailVerifie){

                                    user.signUpInBackground(new SignUpCallback() {

                                        public void done(ParseException e1) {
                                            if (e1 == null) {


                                                try {
                                                    testObj1.save();

                                                    //finish();
                                                } catch (ParseException e2) {
                                                    e2.printStackTrace();
                                                }

                                                // Show a simple Toast message upon successful registration
                                                Intent i = new Intent(Login.this, MainActivity.class);  //Login.class
                                                startActivity(i);
                                                //finish();
                                                Toast.makeText(getApplicationContext(),
                                                        "Successfully Signed Up. Welcome. A mail has been sent to your email address. Please verify it.",
                                                        Toast.LENGTH_LONG).show();
                                                Toast.makeText(getApplicationContext(), "Else your account will be removed within 24 hours.", Toast.LENGTH_LONG).show();
                                            } else {

                                                // Intent i=new Intent(Signup.this, Signup.class);

                                                switch (e1.getCode()) {

                                                    case ParseException.ACCOUNT_ALREADY_LINKED:
                                                        Toast.makeText(getApplicationContext(), "Account is already taken", Toast.LENGTH_LONG).show();
                                                        break;


                                                    case ParseException.EMAIL_TAKEN:
                                                        Toast.makeText(getApplicationContext(), "Account is already taken", Toast.LENGTH_LONG).show();

                                                        break;

                                                    case ParseException.INVALID_EMAIL_ADDRESS:

                                                        Toast.makeText(getApplicationContext(), "Invalid email address", Toast.LENGTH_LONG).show();
                                                        break;


                                                    case ParseException.DUPLICATE_VALUE:

                                                        Toast.makeText(getApplicationContext(), "Already Taken", Toast.LENGTH_LONG).show();

                                                        break;

                                                    case ParseException.EMAIL_NOT_FOUND:

                                                        Toast.makeText(getApplicationContext(), "Email is not found", Toast.LENGTH_LONG).show();

                                                        break;

                                                    case ParseException.VALIDATION_ERROR:
                                                        Toast.makeText(getApplicationContext(), "eMAIL ID IS NOT VALIDATED", Toast.LENGTH_LONG).show();


                                                    case ParseException.LINKED_ID_MISSING:
                                                        Toast.makeText(getApplicationContext(), "Account id is not found", Toast.LENGTH_LONG).show();

                                                        break;

                                                    case ParseException.USERNAME_TAKEN:
                                                        Toast.makeText(getApplicationContext(), "Username is already Taken", Toast.LENGTH_LONG).show();

                                                        break;

                                                }


                                            }
                                        }

                                    });

                                } else {

                                    Toast.makeText(getApplicationContext(),
                                            "Select checkbox and agree for terms and conditions",
                                            Toast.LENGTH_LONG).show();
                                }

                            } else {
                                Toast.makeText(getApplicationContext(),
                                        "Phone number is not valid",
                                        Toast.LENGTH_LONG).show();
                            }
                        } else {
                            Toast.makeText(getApplicationContext(),
                                    "Username is not valid. It can contain 4-" +
                                            "15 characters ranging from A-Z, a-z, 0-9 and special characters like - and _",
                                    Toast.LENGTH_LONG).show();

                        }

                    } else {
                        Toast.makeText(getApplicationContext(),
                                "Email address is not valid. It should be in the form my@example.com",
                                Toast.LENGTH_LONG).show();

                    }
                } else {
                    Toast.makeText(getApplicationContext(),
                            "Your name is not valid. It must contain only character from " +
                                    "A-Z, a-z or white space and can be 4 to 25 character long ",
                            Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(getApplicationContext(),
                        "Both Passwords dont match",
                        Toast.LENGTH_LONG).show();

            }
        }
    }


    private boolean checkEmail(String b) {
        return EMAIL_ADDRESS_PATTERN.matcher(b).matches();

    }

    private boolean checkUsername(String d) {
        return USERNAME_PATTERN.matcher(d).matches();

    }

    private boolean checkName(String d) {
        return NAME_PATTERN.matcher(d).matches();
    }

    public void onClick17(View view) {
        Intent i = new Intent(Login.this, Tnc.class);  //Login.class
        startActivity(i);

    }

}	
