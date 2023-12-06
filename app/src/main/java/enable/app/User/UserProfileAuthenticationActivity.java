package enable.app.User;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import enable.app.R;
import enable.app.User.HealthCare.HealthCareProfessionalCreateActivity;
import enable.app.User.HealthCare.HealthCareProfessionalPatientDetailActivity;

public class UserProfileAuthenticationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile_authentication);

        Button button_UserProfileAuthentication_Enter = findViewById(R.id.button_UserProfileAuthentication_Enter);
        button_UserProfileAuthentication_Enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserProfileAuthenticationActivity.this, HealthCareProfessionalPatientDetailActivity.class);
                startActivity(intent);
                //Toast.makeText(getApplicationContext(), "Funcionalidade em desenvolvimento", Toast.LENGTH_SHORT).show();
            }
        });

        Button button_UserProfileAuthentication_Create = findViewById(R.id.button_UserProfileAuthentication_Create);
        button_UserProfileAuthentication_Create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserProfileAuthenticationActivity.this, HealthCareProfessionalCreateActivity.class);
                startActivity(intent);
            }
        });
    }
}
