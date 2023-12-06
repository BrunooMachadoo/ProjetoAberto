package enable.app.Menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import enable.app.R;
import enable.app.User.UserBenefitedQuestion;

public class QueroImprimirTermActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quero_imprimir_term);

        Button button_UserProfileAuthentication_Accept = findViewById(R.id.button_UserProfileAuthentication_Accept);
        button_UserProfileAuthentication_Accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserBenefitedQuestion.Questions = null;
                Intent intent = new Intent(QueroImprimirTermActivity.this, QueroImprimirTermInputDataActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
