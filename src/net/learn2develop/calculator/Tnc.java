package net.learn2develop.calculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Tnc extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tnc);

        TextView tc = (TextView) findViewById(R.id.tx);
        tc.setText("Please read these Terms of Service completely using this app which is owned and operated by Riya Dashoriya." +
                " This Agreement documents the legally binding terms and conditions attached to the use of the android application, Health Visitor." +
                "By using or accessing the app in any way, viewing or browsing the app, or adding your own content to the app," +
                " you are agreeing to be bound by these Terms of Service." + "\n" +
                "Intellectual Property" + "\n" +
                "The App and all of its original content are the sole property of Riya Dashoriya and are, as such,"
                + "fully protected by the appropriate international copyright and other intellectual property rights laws."
                + "\n" +
                "Termination" + "\n" +
                "Health Visitor reserves the right to terminate your access to the App, without any advance notice." +
                "\n" +
                "Links to Other Websites" + "\n" +
                "App does contain a number of links to other websites and online resources that are not owned or " +
                "controlled by Health Visitor. It has no control over, and therefore cannot assume responsibility " +
                "for, the content or general practices of any of these third party sites and/or services. " +
                "Therefore, strongly advise you to read the entire terms and conditions and privacy policy of " +
                "any site that you visit as a result of following a link that is posted on app." + "\n" +
                "Governing Law" + "\n" +
                "This Agreement is governed in accordance with the developer.android.com." + "\n" +
                "Changes to This Agreement" + "\n" +
                "Health Visitor reserves the right to modify these Terms of Service at any time." +
                " Health Visitor do so by posting and drawing attention to the updated terms on the App." +
                " Your decision to continue to visit and make use of the App after such changes have" +
                " been made constitutes your formal acceptance of the new Terms of Service."
                + "\n" +
                "Therefore, Health Visitor ask that you check and review this Agreement for such changes" +
                " on an occasional basis. Should you not agree to any provision of this Agreement or any " +
                "changes we make to this Agreement, Health Visitor ask and advise that you do not use or" +
                " continue to access the Health Visitor immediately." + "\n" +
                "Contact Us" + "\n" +
                "If you have any questions about this Agreement, please feel free to contact us at healthvisitorr@gmail.com.");

    }

    public void onClick18(View view) {
        Intent i = new Intent(Tnc.this, Login.class);  //Login.class
        startActivity(i);

    }
}
