package enable.app.User.HealthCare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import enable.app.R;
import enable.app.User.UserProfileAuthenticationActivity;

public class HealthCareProfessionalPatientDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_care_professional_patient_detail);

        Button button_HealthCareProfessionalPatientDetailActivity_Detail = findViewById(R.id.button_HealthCareProfessionalPatientDetailActivity_Detail);
        button_HealthCareProfessionalPatientDetailActivity_Detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Funcionalidade em desenvolvimento", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
