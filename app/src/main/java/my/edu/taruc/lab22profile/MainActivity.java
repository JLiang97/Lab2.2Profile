package my.edu.taruc.lab22profile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_PROFILE_UPDATE = 1;
    public static final String PROFILE_NAME = "my.edu.taruc.lab22profile.name";
    public static final String PROFILE_EMAIL = "my.edu.taruc.lab22profile.email";
    private TextView textViewName, textViewEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Linking UI to program
        textViewName =(TextView)findViewById(R.id.textViewName);
        textViewEmail =(TextView)findViewById(R.id.textViewEmail);
    }

    public void updateProfile(View view){
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivityForResult(intent, REQUEST_PROFILE_UPDATE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        //requestCode = the unique code which identify an intent
        //resultCode = the result returns by an intent; either OK or Cancel
        //date = the actual data returned by an intent
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_PROFILE_UPDATE && resultCode == RESULT_OK){
            String name, email;
            name = data.getStringExtra(PROFILE_NAME);
            email = data.getStringExtra(PROFILE_EMAIL);
            textViewName.setText(getString(R.string.name)+name);
            textViewEmail.setText(getString(R.string.email)+email);
        }
    }
}
