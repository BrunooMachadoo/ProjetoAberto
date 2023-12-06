package enable.app.Alert;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import enable.app.PutExtra;
import enable.app.R;
import enable.app.User.UserBenefitedQuestionActivity;
import enable.app.User.UserBenefitedQuestionLoadActivity;

public class AlertErrorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_error);

        Intent intent = getIntent();
        String msg = intent.getStringExtra(PutExtra.Value.Msg.toString());

        TextView textView_AlertErrorActivity_Msg = findViewById(R.id.textView_AlertErrorActivity_Msg);
        textView_AlertErrorActivity_Msg.setText(msg);

        Button button_AlertErrorActivity_Close = findViewById(R.id.button_AlertErrorActivity_Close);
        button_AlertErrorActivity_Close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
