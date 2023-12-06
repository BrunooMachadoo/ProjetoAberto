package enable.app.Menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import enable.app.Initial.COVID19Activity;
import enable.app.R;
import enable.app.User.UserBenefitedQuestion;

public class QueroReceberActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quero_receber);

        Button button_QueroReceberActivity_Cadastro = findViewById(R.id.button_QueroReceberActivity_Cadastro);
        button_QueroReceberActivity_Cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QueroReceberActivity.this, QueroReceberRegistredActivity.class);
                startActivity(intent);
                finish();
            }
        });

        Button button_QueroReceberActivity_ConfirmarRecebimento = findViewById(R.id.button_QueroReceberActivity_ConfirmarRecebimento);
        button_QueroReceberActivity_ConfirmarRecebimento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QueroReceberActivity.this, QueroReceberConfimedActivity.class);
                intent.putExtra("InstituteId", InstituteId);
                startActivity(intent);
                finish();
            }
        });

        String androidId = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
        String dataSend = "";
        dataSend += "'SmartPhoneId':'" + androidId + "'";
        Intent intent = new Intent(QueroReceberActivity.this, SendMsgActivity.class);
        intent.putExtra(SendMsgActivity.Opt.Data.toString(), dataSend);
        intent.putExtra(SendMsgActivity.Opt.Url.toString(), "QueroReceberRegistred/GetSmartphone");
        startActivityForResult(intent, 1);

        Button button_QueroReceberActivity_Solicitar = findViewById(R.id.button_QueroReceberActivity_Solicitar);
        button_QueroReceberActivity_Solicitar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QueroReceberActivity.this, QueroReceberSolicitationActivity.class);
                intent.putExtra("InstituteId", InstituteId);
                startActivity(intent);
                finish();
            }
        });
    }
    String InstituteId;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == 2) {
            String r = data.getStringExtra("r");
            String name = r.split("\\*")[0];
            InstituteId = r.split("\\*")[1];

            Button button_QueroReceberActivity_Solicitar = findViewById(R.id.button_QueroReceberActivity_Solicitar);
            button_QueroReceberActivity_Solicitar.setVisibility(View.VISIBLE);

            TextView textView_QueroReceberActivity_InstituteName = findViewById(R.id.textView_QueroReceberActivity_InstituteName);
            textView_QueroReceberActivity_InstituteName.setText("Você faz solicitações para " + "'" + name + "'");
            textView_QueroReceberActivity_InstituteName.setVisibility(View.VISIBLE);

            Button button_QueroReceberActivity_ConfirmarRecebimento = findViewById(R.id.button_QueroReceberActivity_ConfirmarRecebimento);
            button_QueroReceberActivity_ConfirmarRecebimento.setVisibility(View.VISIBLE);

        } else if (resultCode == -4) {

            Button button_QueroReceberActivity_Cadastro = findViewById(R.id.button_QueroReceberActivity_Cadastro);
            button_QueroReceberActivity_Cadastro.setVisibility(View.VISIBLE);

            Button button_QueroReceberActivity_ConfirmarRecebimento = findViewById(R.id.button_QueroReceberActivity_ConfirmarRecebimento);
            button_QueroReceberActivity_ConfirmarRecebimento.setVisibility(View.GONE);

        } else {
            finish();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
