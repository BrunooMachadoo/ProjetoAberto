package enable.app.Menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import enable.app.R;
import enable.app.User.UserBenefitedQuestion;

public class QueroImprimirTermInputDataActivity extends AppCompatActivity {
    TextView textView_QueroImprimirTermInputDataActivity_Name_Alert;
    TextView textView_QueroImprimirTermInputDataActivity_CPF_Alert;
    TextView textView_QueroImprimirTermInputDataActivity_Phone_Alert;

    private void hidden() {
        textView_QueroImprimirTermInputDataActivity_Name_Alert = findViewById(R.id.textView_QueroImprimirTermInputDataActivity_Name_Alert);
        textView_QueroImprimirTermInputDataActivity_Name_Alert.setVisibility(View.GONE);
        textView_QueroImprimirTermInputDataActivity_CPF_Alert = findViewById(R.id.textView_QueroImprimirTermInputDataActivity_CPF_Alert);
        textView_QueroImprimirTermInputDataActivity_CPF_Alert.setVisibility(View.GONE);
        textView_QueroImprimirTermInputDataActivity_Phone_Alert = findViewById(R.id.textView_QueroImprimirTermInputDataActivity_Phone_Alert);
        textView_QueroImprimirTermInputDataActivity_Phone_Alert.setVisibility(View.GONE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quero_imprimir_term_input_data);

        Button button_QueroImprimirTermInputDataActivity_Accept = findViewById(R.id.button_QueroImprimirTermInputDataActivity_Accept);
        button_QueroImprimirTermInputDataActivity_Accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hidden();

                EditText editText_QueroImprimirTermInputDataActivity_Name = findViewById(R.id.editText_QueroImprimirTermInputDataActivity_Name);
                EditText editText_QueroImprimirTermInputDataActivity_CPF = findViewById(R.id.editText_QueroImprimirTermInputDataActivity_CPF);
                EditText editText_QueroImprimirTermInputDataActivity_Phone = findViewById(R.id.editText_QueroImprimirTermInputDataActivity_Phone);


                String androidId = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
                String dataSend = "";
                dataSend += "'SmartPhoneId':'" + androidId + "',";
                dataSend += "'Nome':'" + editText_QueroImprimirTermInputDataActivity_Name.getText().toString() + "',";
                dataSend += "'CPF':'" + editText_QueroImprimirTermInputDataActivity_CPF.getText().toString() + "',";
                dataSend += "'Telefone':'" + editText_QueroImprimirTermInputDataActivity_Phone.getText().toString() + "'";

                Intent intent = new Intent(QueroImprimirTermInputDataActivity.this, SendMsgActivity.class);
                intent.putExtra(SendMsgActivity.Opt.Data.toString(), dataSend);
                intent.putExtra(SendMsgActivity.Opt.Url.toString(), "QueroImprimirRegistred/Create");
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == 1) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://e-nablebrasil.org/wp/impressaomontagem/"));
            startActivity(browserIntent);
            finish();
        } else if (resultCode == -3) {
            Intent intent = new Intent(QueroImprimirTermInputDataActivity.this, MsgActivity.class);
            intent.putExtra(MsgActivity.Opt.Msg.toString(), "Preencha os campos obrigatórios em amarelo.");
            startActivity(intent);
            String r = data.getStringExtra("r");
            String[] rList = r.split("\\|");
            for (int i = 0; i < rList.length; i++) {
                String id = rList[i].split("\\*")[0];
                id = id.split("=")[1];
                if (id.toLowerCase().equals("nome")) {
                    textView_QueroImprimirTermInputDataActivity_Name_Alert.setVisibility(View.VISIBLE);
                } else if (id.toLowerCase().equals("cpf")) {
                    textView_QueroImprimirTermInputDataActivity_CPF_Alert.setVisibility(View.VISIBLE);
                } else if (id.toLowerCase().equals("telefone")) {
                    textView_QueroImprimirTermInputDataActivity_Phone_Alert.setVisibility(View.VISIBLE);
                }
            }
        }
        else {
            Intent intent = new Intent(QueroImprimirTermInputDataActivity.this, MsgActivity.class);
            intent.putExtra(MsgActivity.Opt.Msg.toString(), "Erro ao tentar criar o cadastro, por favor tente novamente.");
            startActivity(intent);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
