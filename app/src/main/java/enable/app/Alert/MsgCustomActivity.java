package enable.app.Alert;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import enable.app.PutExtra;
import enable.app.R;

public class MsgCustomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_msg_custom);

        Intent intent = getIntent();
        String msg = intent.getStringExtra(PutExtra.Value.Msg.toString());

        TextView textView_MsgCustomActivity_Mag = findViewById(R.id.textView_MsgCustomActivity_Mag);
        textView_MsgCustomActivity_Mag.setText(msg);

        Button button_MsgCustomActivity_Close = findViewById(R.id.button_MsgCustomActivity_Close);
        button_MsgCustomActivity_Close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
