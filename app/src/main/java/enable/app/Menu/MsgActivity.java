package enable.app.Menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import enable.app.R;

public class MsgActivity extends AppCompatActivity {

    public enum Opt {
        Msg
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_msg2);
        Intent urlParameter = getIntent();
        final String Data = urlParameter.getStringExtra(MsgActivity.Opt.Msg.toString());
        TextView textView_MsgActivity_Title = findViewById(R.id.textView_MsgActivity_Title);
        textView_MsgActivity_Title.setText(Data);

        Button button_MsgActivity = findViewById(R.id.button_MsgActivity);
        button_MsgActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
