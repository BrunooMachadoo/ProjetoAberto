package enable.app.User.HealthCare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import enable.app.Alert.MsgCustomActivity;
import enable.app.PutExtra;
import enable.app.R;
import enable.app.User.UserAuthenticationActivity;
import enable.app.User.UserBenefitedQuestion;
import enable.app.User.UserBenefitedQuestionActivity;

public class HealthCareProfessionalCreateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_care_professional_create);

        Button button_HealthCareProfessionalCreateActivity_Create = findViewById(R.id.button_HealthCareProfessionalCreateActivity_Create);
        button_HealthCareProfessionalCreateActivity_Create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HealthCareProfessionalCreateActivity.this, MsgCustomActivity.class);
                intent.putExtra(PutExtra.Value.Msg.toString(), "Profissional de saúde cadastrado com sucesso.");
                startActivity(intent);
                finish();
            }
        });
    }
}
