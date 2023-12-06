package enable.app.Menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import enable.app.R;

public class QueroReceberConfimedActivity extends AppCompatActivity {

    String InstituteId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quero_receber_confimed);

        Button button_QueroReceberConfimedActivity_Confirmed = findViewById(R.id.button_QueroReceberConfimedActivity_Confirmed);
        button_QueroReceberConfimedActivity_Confirmed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent r = getIntent();
                InstituteId = r.getStringExtra("InstituteId");
                EditText editText_QueroReceberConfimedActivity_Qtd = findViewById(R.id.editText_QueroReceberConfimedActivity_Qtd);
                String androidId = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
                String dataSend = "";
                dataSend += "'SmartPhoneId':'" + androidId + "',";
                dataSend += "'InstituteId':'" + InstituteId + "',";
                dataSend += "'Qtd':'" + editText_QueroReceberConfimedActivity_Qtd.getText().toString() + "'";

                Intent intent = new Intent(QueroReceberConfimedActivity.this, SendMsgActivity.class);
                intent.putExtra(SendMsgActivity.Opt.Data.toString(), dataSend);
                intent.putExtra(SendMsgActivity.Opt.Url.toString(), "QueroReceberRegistredDoacao/Create");
                startActivityForResult(intent, 1);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == 1) {
            Intent intent = new Intent(QueroReceberConfimedActivity.this, MsgActivity.class);
            intent.putExtra(MsgActivity.Opt.Msg.toString(), "Confirmação enviada com sucesso!");
            startActivity(intent);
            finish();
        } else {
            Intent intent = new Intent(QueroReceberConfimedActivity.this, MsgActivity.class);
            intent.putExtra(MsgActivity.Opt.Msg.toString(), "Erro ao tentar confirmar, por favor tente novamente.");
            startActivity(intent);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
