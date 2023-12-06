package enable.app.Alert;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import enable.app.PutExtra;
import enable.app.R;

public class MsgActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_msg);

        Intent intent = getIntent();
        String msg = intent.getStringExtra(PutExtra.Value.Msg.toString());
        TextView textView_MsgActivity_Mag = findViewById(R.id.textView_MsgActivity_Mag);
        textView_MsgActivity_Mag.setText("Parabéns!, salvamos os seus dados com sucesso, logo mais iremos contatar você, será enviado um alerta para o aplicativo, fique ligado.");

        Button button_MsgActivity_Close = findViewById(R.id.button_MsgActivity_Close);
        button_MsgActivity_Close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
