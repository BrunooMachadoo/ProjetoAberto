package enable.app.Initial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import enable.app.Menu.QueroImprimirActivity;
import enable.app.Menu.QueroReceberActivity;
import enable.app.Menu.QueroReceberRegistredActivity;
import enable.app.R;
import enable.app.User.UserAuthenticationActivity;
import enable.app.User.UserBenefitedQuestion;
import enable.app.User.UserBenefitedQuestionActivity;

public class COVID19Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covid19);

        Button button_COVID19Activity_QueroImprimir = findViewById(R.id.button_COVID19Activity_QueroImprimir);
        button_COVID19Activity_QueroImprimir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserBenefitedQuestion.Questions = null;
                Intent intent = new Intent(COVID19Activity.this, QueroImprimirActivity.class);
                startActivity(intent);
            }
        });

        Button button_COVID19Activity_QueroReceber = findViewById(R.id.button_COVID19Activity_QueroReceber);
        button_COVID19Activity_QueroReceber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(COVID19Activity.this, QueroReceberActivity.class);
                startActivity(intent);
            }
        });
    }
}
