package enable.app.Menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import enable.app.R;
import enable.app.User.UserBenefitedQuestion;

public class QueroReceberRegistredActivity extends AppCompatActivity {
    TextView textView_QueroReceberRegistredActivity_Email_Alert;
    TextView textView_QueroReceberRegistredActivity_InstituteName_Alert;
    TextView textView_QueroReceberRegistredActivity_Alert;
    TextView textView_QueroReceberRegistredActivity_Utilizacao_Alert;
    TextView textView_QueroReceberRegistredActivity_Resume_Alert;
    TextView textView_QueroReceberRegistredActivity_Endereco_Alert;
    TextView textView_QueroReceberRegistredActivity_CEP_Alert;
    TextView textView_QueroReceberRegistredActivity_Possibilidade_Alert;
    TextView textView_QueroReceberRegistredActivity_Horario_Alert;
    TextView textView_QueroReceberRegistredActivity_Phone_Alert;
    TextView textView_QueroReceberRegistredActivity_Cidade_Alert;
    TextView textView_QueroReceberRegistredActivity_UF_Alert;
    TextView textView_QueroReceberRegistredActivity_Name_Alert;
    TextView textView_QueroReceberRegistredActivity_Qtd_Alert;
    TextView textView_QueroReceberRegistredActivity_Licence_Alert;
    TextView textView_QueroReceberRegistredActivity_Term_Alert;
    private void  hidden(){
        textView_QueroReceberRegistredActivity_Email_Alert = findViewById(R.id.textView_QueroReceberRegistredActivity_Email_Alert);
        textView_QueroReceberRegistredActivity_Email_Alert.setVisibility(View.GONE);
        textView_QueroReceberRegistredActivity_InstituteName_Alert = findViewById(R.id.textView_QueroReceberRegistredActivity_InstituteName_Alert);
        textView_QueroReceberRegistredActivity_InstituteName_Alert.setVisibility(View.GONE);
        textView_QueroReceberRegistredActivity_Alert = findViewById(R.id.textView_QueroReceberRegistredActivity_Alert);
        textView_QueroReceberRegistredActivity_Alert.setVisibility(View.GONE);
        textView_QueroReceberRegistredActivity_Utilizacao_Alert = findViewById(R.id.textView_QueroReceberRegistredActivity_Utilizacao_Alert);
        textView_QueroReceberRegistredActivity_Utilizacao_Alert.setVisibility(View.GONE);
        textView_QueroReceberRegistredActivity_Resume_Alert = findViewById(R.id.textView_QueroReceberRegistredActivity_Resume_Alert);
        textView_QueroReceberRegistredActivity_Resume_Alert.setVisibility(View.GONE);
        textView_QueroReceberRegistredActivity_Endereco_Alert = findViewById(R.id.textView_QueroReceberRegistredActivity_Endereco_Alert);
        textView_QueroReceberRegistredActivity_Endereco_Alert.setVisibility(View.GONE);
        textView_QueroReceberRegistredActivity_CEP_Alert = findViewById(R.id.textView_QueroReceberRegistredActivity_CEP_Alert);
        textView_QueroReceberRegistredActivity_CEP_Alert.setVisibility(View.GONE);
        textView_QueroReceberRegistredActivity_Possibilidade_Alert = findViewById(R.id.textView_QueroReceberRegistredActivity_Possibilidade_Alert);
        textView_QueroReceberRegistredActivity_Possibilidade_Alert.setVisibility(View.GONE);
        textView_QueroReceberRegistredActivity_Horario_Alert = findViewById(R.id.textView_QueroReceberRegistredActivity_Horario_Alert);
        textView_QueroReceberRegistredActivity_Horario_Alert.setVisibility(View.GONE);
        textView_QueroReceberRegistredActivity_Phone_Alert = findViewById(R.id.textView_QueroReceberRegistredActivity_Phone_Alert);
        textView_QueroReceberRegistredActivity_Phone_Alert.setVisibility(View.GONE);
        textView_QueroReceberRegistredActivity_Cidade_Alert = findViewById(R.id.textView_QueroReceberRegistredActivity_Cidade_Alert);
        textView_QueroReceberRegistredActivity_Cidade_Alert.setVisibility(View.GONE);
        textView_QueroReceberRegistredActivity_UF_Alert = findViewById(R.id.textView_QueroReceberRegistredActivity_UF_Alert);
        textView_QueroReceberRegistredActivity_UF_Alert.setVisibility(View.GONE);
        textView_QueroReceberRegistredActivity_Name_Alert = findViewById(R.id.textView_QueroReceberRegistredActivity_Name_Alert);
        textView_QueroReceberRegistredActivity_Name_Alert.setVisibility(View.GONE);
        textView_QueroReceberRegistredActivity_Qtd_Alert = findViewById(R.id.textView_QueroReceberRegistredActivity_Qtd_Alert);
        textView_QueroReceberRegistredActivity_Qtd_Alert.setVisibility(View.GONE);
        textView_QueroReceberRegistredActivity_Licence_Alert = findViewById(R.id.textView_QueroReceberRegistredActivity_Licence_Alert);
        textView_QueroReceberRegistredActivity_Licence_Alert.setVisibility(View.GONE);
        textView_QueroReceberRegistredActivity_Term_Alert = findViewById(R.id.textView_QueroReceberRegistredActivity_Term_Alert);
        textView_QueroReceberRegistredActivity_Term_Alert.setVisibility(View.GONE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quero_receber_registred);
        Button button_QueroReceberRegistredActivity_Send = findViewById(R.id.button_QueroReceberRegistredActivity_Send);
        button_QueroReceberRegistredActivity_Send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                hidden();
                String androidId = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);

                EditText editText_QueroReceberRegistredActivity_Email = findViewById(R.id.editText_QueroReceberRegistredActivity_Email);

                EditText editText_QueroReceberRegistredActivity_InstituteName = findViewById(R.id.editText_QueroReceberRegistredActivity_InstituteName);

                RadioGroup radioGroup_QueroReceberRegistredActivity = findViewById(R.id.radioGroup_QueroReceberRegistredActivity);
                int radioGroup_QueroReceberRegistredActivityId = radioGroup_QueroReceberRegistredActivity.getCheckedRadioButtonId();
                RadioButton radioGroup_QueroReceberRegistredActivityButton = (RadioButton) findViewById(radioGroup_QueroReceberRegistredActivityId);
                String radioGroup_QueroReceberRegistredActivityText = null;
                if (radioGroup_QueroReceberRegistredActivityButton != null) {
                    radioGroup_QueroReceberRegistredActivityText = radioGroup_QueroReceberRegistredActivityButton.getText().toString();
                }

                RadioGroup radioGroup_QueroReceberRegistredActivity_Utilizacao = findViewById(R.id.radioGroup_QueroReceberRegistredActivity_Utilizacao);
                int radioGroup_QueroReceberRegistredActivity_UtilizacaoId = radioGroup_QueroReceberRegistredActivity_Utilizacao.getCheckedRadioButtonId();
                RadioButton radioGroup_QueroReceberRegistredActivity_UtilizacaoButton = (RadioButton) findViewById(radioGroup_QueroReceberRegistredActivity_UtilizacaoId);
                String radioGroup_QueroReceberRegistredActivity_UtilizacaoText = null;
                if (radioGroup_QueroReceberRegistredActivity_UtilizacaoButton != null) {
                    radioGroup_QueroReceberRegistredActivity_UtilizacaoText = radioGroup_QueroReceberRegistredActivity_UtilizacaoButton.getText().toString();
                }

                EditText editText_QueroReceberRegistredActivity_Resume = findViewById(R.id.editText_QueroReceberRegistredActivity_Resume);

                EditText editText_QueroReceberRegistredActivity_Endereco = findViewById(R.id.editText_QueroReceberRegistredActivity_Endereco);

                EditText editText_QueroReceberRegistredActivity_CEP = findViewById(R.id.editText_QueroReceberRegistredActivity_CEP);

                RadioGroup radioGroup_QueroReceberRegistredActivity_Possibilidade = findViewById(R.id.radioGroup_QueroReceberRegistredActivity_Possibilidade);
                int radioGroup_QueroReceberRegistredActivity_PossibilidadeId = radioGroup_QueroReceberRegistredActivity_Possibilidade.getCheckedRadioButtonId();
                RadioButton radioGroup_QueroReceberRegistredActivity_PossibilidadeButton = (RadioButton) findViewById(radioGroup_QueroReceberRegistredActivity_PossibilidadeId);
                String radioGroup_QueroReceberRegistredActivity_PossibilidadeText = null;
                if (radioGroup_QueroReceberRegistredActivity_PossibilidadeButton != null) {
                    radioGroup_QueroReceberRegistredActivity_PossibilidadeText = radioGroup_QueroReceberRegistredActivity_PossibilidadeButton.getText().toString();
                }

                RadioGroup radioGroup_QueroReceberRegistredActivity_Horario = findViewById(R.id.radioGroup_QueroReceberRegistredActivity_Horario);
                int radioGroup_QueroReceberRegistredActivity_HorarioId = radioGroup_QueroReceberRegistredActivity_Horario.getCheckedRadioButtonId();
                RadioButton radioGroup_QueroReceberRegistredActivity_HorarioButton = (RadioButton) findViewById(radioGroup_QueroReceberRegistredActivity_HorarioId);
                String radioGroup_QueroReceberRegistredActivity_HorarioText = null;
                if (radioGroup_QueroReceberRegistredActivity_HorarioButton != null) {
                    radioGroup_QueroReceberRegistredActivity_HorarioText = radioGroup_QueroReceberRegistredActivity_HorarioButton.getText().toString();
                }

                EditText editText_QueroReceberRegistredActivity_Phone = findViewById(R.id.editText_QueroReceberRegistredActivity_Phone);

                EditText editText_QueroReceberRegistredActivity_Cidade = findViewById(R.id.editText_QueroReceberRegistredActivity_Cidade);

                EditText editText_QueroReceberRegistredActivity_UF = findViewById(R.id.editText_QueroReceberRegistredActivity_UF);

                EditText editText_QueroReceberRegistredActivity_Name = findViewById(R.id.editText_QueroReceberRegistredActivity_Name);

                EditText editText_QueroReceberRegistredActivity_Qtd = findViewById(R.id.editText_QueroReceberRegistredActivity_Qtd);

                CheckBox checkBox_QueroReceberRegistredActivity_Licence = findViewById(R.id.checkBox_QueroReceberRegistredActivity_Licence);

                CheckBox checkBox_QueroReceberRegistredActivity_Term = findViewById(R.id.checkBox_QueroReceberRegistredActivity_Term);
                String checkBox_QueroReceberRegistredActivity_TermText = checkBox_QueroReceberRegistredActivity_Term.getText().toString();
                Test = false;
                if (Test) {
                    editText_QueroReceberRegistredActivity_Email.setText("Email");
                    editText_QueroReceberRegistredActivity_InstituteName.setText("InstituteName");
                    radioGroup_QueroReceberRegistredActivityText = "Privada";
                    radioGroup_QueroReceberRegistredActivity_UtilizacaoText = "Utilizacao";
                    editText_QueroReceberRegistredActivity_Resume.setText("Resume");
                    editText_QueroReceberRegistredActivity_Endereco.setText("Endereco");
                    editText_QueroReceberRegistredActivity_CEP.setText("CEP");
                    radioGroup_QueroReceberRegistredActivity_PossibilidadeText = "Possibilidade";
                    radioGroup_QueroReceberRegistredActivity_HorarioText = "24";
                    editText_QueroReceberRegistredActivity_Phone.setText("81999999999");
                    editText_QueroReceberRegistredActivity_Cidade.setText("Cidade");
                    editText_QueroReceberRegistredActivity_UF.setText("UF");
                    editText_QueroReceberRegistredActivity_Name.setText("Name");
                    editText_QueroReceberRegistredActivity_Qtd.setText("99");
                    checkBox_QueroReceberRegistredActivity_Licence.setText("Licence");
                    checkBox_QueroReceberRegistredActivity_TermText = "Term";
                }

                String dataSend = "";
                dataSend += "'SmartPhoneId':'" + androidId + "',";
                dataSend += "'Email':'" + editText_QueroReceberRegistredActivity_Email.getText().toString() + "',";
                dataSend += "'NomedaInstituicao':'" + editText_QueroReceberRegistredActivity_InstituteName.getText().toString() + "',";
                dataSend += "'InstituicaoPublicaoOuPrivada':'" + radioGroup_QueroReceberRegistredActivityText + "',";
                dataSend += "'DistribuicaoOuUsoProprio':'" + radioGroup_QueroReceberRegistredActivity_UtilizacaoText + "',";
                dataSend += "'Resumo':'" + editText_QueroReceberRegistredActivity_Resume.getText().toString() + "',";
                dataSend += "'Endereco':'" + editText_QueroReceberRegistredActivity_Endereco.getText().toString() + "',";
                dataSend += "'CEP':'" + editText_QueroReceberRegistredActivity_CEP.getText().toString() + "',";
                dataSend += "'Recolher':'" + radioGroup_QueroReceberRegistredActivity_PossibilidadeText + "',";
                dataSend += "'Horario':'" + radioGroup_QueroReceberRegistredActivity_HorarioText + "',";
                dataSend += "'Telefone':'" + editText_QueroReceberRegistredActivity_Phone.getText().toString() + "',";
                dataSend += "'Cidade':'" + editText_QueroReceberRegistredActivity_Cidade.getText().toString() + "',";
                dataSend += "'Estado':'" + editText_QueroReceberRegistredActivity_UF.getText().toString() + "',";
                dataSend += "'PessoaOuSetorResponsavel':'" + editText_QueroReceberRegistredActivity_Name.getText().toString() + "',";
                dataSend += "'Quantidade':'" + editText_QueroReceberRegistredActivity_Qtd.getText().toString() + "',";
                if (checkBox_QueroReceberRegistredActivity_Licence.isChecked() || Test) {
                    dataSend += "'Licenca':'" + checkBox_QueroReceberRegistredActivity_Licence.getText().toString() + "',";
                }
                if (checkBox_QueroReceberRegistredActivity_Term.isChecked() || Test) {
                    dataSend += "'Acordo':'" + checkBox_QueroReceberRegistredActivity_TermText + "'";
                }
                Intent intent = new Intent(QueroReceberRegistredActivity.this, SendMsgActivity.class);
                intent.putExtra(SendMsgActivity.Opt.Data.toString(), dataSend);
                intent.putExtra(SendMsgActivity.Opt.Url.toString(), "QueroReceberRegistred/Create");
                startActivityForResult(intent, 1);
            }
        });
    }

    public boolean Test;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == 1) {
            Intent intent = new Intent(QueroReceberRegistredActivity.this, MsgActivity.class);
            intent.putExtra(MsgActivity.Opt.Msg.toString(), "Dados enviados com sucesso!");
            startActivity(intent);
            finish();
        } else if (resultCode == -1) {
            Intent intent = new Intent(QueroReceberRegistredActivity.this, MsgActivity.class);
            intent.putExtra(MsgActivity.Opt.Msg.toString(), "Erro ao acessar o servidor, por favor tente novamente.");
            startActivity(intent);
        } else if (resultCode == -2) {
            Intent intent = new Intent(QueroReceberRegistredActivity.this, MsgActivity.class);
            intent.putExtra(MsgActivity.Opt.Msg.toString(), "Erro ao realizar a comunicação com o servidor, por favor tente novamente.");
            startActivity(intent);
        } else if (resultCode == -3) {
            Intent intent = new Intent(QueroReceberRegistredActivity.this, MsgActivity.class);
            intent.putExtra(MsgActivity.Opt.Msg.toString(), "Preencha os campos obrigatórios em amarelo.");
            startActivity(intent);
            String r = data.getStringExtra("r");
            String[] rList = r.split("\\|");
            for (int i = 0; i < rList.length; i++) {
                String id = rList[i].split("\\*")[0];
                id = id.split("=")[1];
                if (id.toLowerCase().equals("email")) {
                    TextView textView_QueroReceberRegistredActivity_Email_Alert = findViewById(R.id.textView_QueroReceberRegistredActivity_Email_Alert);
                    textView_QueroReceberRegistredActivity_Email_Alert.setVisibility(View.VISIBLE);
                } else if (id.toLowerCase().equals("nomedainstituicao")) {
                    TextView textView_QueroReceberRegistredActivity_InstituteName_Alert = findViewById(R.id.textView_QueroReceberRegistredActivity_InstituteName_Alert);
                    textView_QueroReceberRegistredActivity_InstituteName_Alert.setVisibility(View.VISIBLE);
                } else if (id.toLowerCase().equals("instituicaopublicaoouprivada")) {
                    TextView textView_QueroReceberRegistredActivity_Alert = findViewById(R.id.textView_QueroReceberRegistredActivity_Alert);
                    textView_QueroReceberRegistredActivity_Alert.setVisibility(View.VISIBLE);
                } else if (id.toLowerCase().equals("distribuicaoouusoproprio")) {
                    TextView textView_QueroReceberRegistredActivity_Utilizacao_Alert = findViewById(R.id.textView_QueroReceberRegistredActivity_Utilizacao_Alert);
                    textView_QueroReceberRegistredActivity_Utilizacao_Alert.setVisibility(View.VISIBLE);
                } else if (id.toLowerCase().equals("resumo")) {
                    TextView textView_QueroReceberRegistredActivity_Resume_Alert = findViewById(R.id.textView_QueroReceberRegistredActivity_Resume_Alert);
                    textView_QueroReceberRegistredActivity_Resume_Alert.setVisibility(View.VISIBLE);
                } else if (id.toLowerCase().equals("endereco")) {
                    TextView textView_QueroReceberRegistredActivity_Endereco_Alert = findViewById(R.id.textView_QueroReceberRegistredActivity_Endereco_Alert);
                    textView_QueroReceberRegistredActivity_Endereco_Alert.setVisibility(View.VISIBLE);
                } else if (id.toLowerCase().equals("cep")) {
                    TextView textView_QueroReceberRegistredActivity_CEP_Alert = findViewById(R.id.textView_QueroReceberRegistredActivity_CEP_Alert);
                    textView_QueroReceberRegistredActivity_CEP_Alert.setVisibility(View.VISIBLE);
                } else if (id.toLowerCase().equals("recolher")) {
                    TextView textView_QueroReceberRegistredActivity_Possibilidade_Alert = findViewById(R.id.textView_QueroReceberRegistredActivity_Possibilidade_Alert);
                    textView_QueroReceberRegistredActivity_Possibilidade_Alert.setVisibility(View.VISIBLE);
                } else if (id.toLowerCase().equals("horario")) {
                    TextView textView_QueroReceberRegistredActivity_Horario_Alert = findViewById(R.id.textView_QueroReceberRegistredActivity_Horario_Alert);
                    textView_QueroReceberRegistredActivity_Horario_Alert.setVisibility(View.VISIBLE);
                } else if (id.toLowerCase().equals("telefone")) {
                    TextView textView_QueroReceberRegistredActivity_Phone_Alert = findViewById(R.id.textView_QueroReceberRegistredActivity_Phone_Alert);
                    textView_QueroReceberRegistredActivity_Phone_Alert.setVisibility(View.VISIBLE);
                } else if (id.toLowerCase().equals("cidade")) {
                    TextView textView_QueroReceberRegistredActivity_Cidade_Alert = findViewById(R.id.textView_QueroReceberRegistredActivity_Cidade_Alert);
                    textView_QueroReceberRegistredActivity_Cidade_Alert.setVisibility(View.VISIBLE);
                } else if (id.toLowerCase().equals("estado")) {
                    TextView textView_QueroReceberRegistredActivity_UF_Alert = findViewById(R.id.textView_QueroReceberRegistredActivity_UF_Alert);
                    textView_QueroReceberRegistredActivity_UF_Alert.setVisibility(View.VISIBLE);
                } else if (id.toLowerCase().equals("pessoaousetorresponsavel")) {
                    TextView textView_QueroReceberRegistredActivity_Name_Alert = findViewById(R.id.textView_QueroReceberRegistredActivity_Name_Alert);
                    textView_QueroReceberRegistredActivity_Name_Alert.setVisibility(View.VISIBLE);
                } else if (id.toLowerCase().equals("quantidade")) {
                    TextView textView_QueroReceberRegistredActivity_Qtd_Alert = findViewById(R.id.textView_QueroReceberRegistredActivity_Qtd_Alert);
                    textView_QueroReceberRegistredActivity_Qtd_Alert.setVisibility(View.VISIBLE);
                } else if (id.toLowerCase().equals("licenca")) {
                    TextView textView_QueroReceberRegistredActivity_Licence_Alert = findViewById(R.id.textView_QueroReceberRegistredActivity_Licence_Alert);
                    textView_QueroReceberRegistredActivity_Licence_Alert.setVisibility(View.VISIBLE);
                } else if (id.toLowerCase().equals("acordo")) {
                    TextView textView_QueroReceberRegistredActivity_Term_Alert = findViewById(R.id.textView_QueroReceberRegistredActivity_Term_Alert);
                    textView_QueroReceberRegistredActivity_Term_Alert.setVisibility(View.VISIBLE);
                }
            }
        } else {
            Intent intent = new Intent(QueroReceberRegistredActivity.this, MsgActivity.class);
            intent.putExtra(MsgActivity.Opt.Msg.toString(), "Erro ao realizar a comunicação com o servidor, por favor tente novamente.");
            startActivity(intent);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
