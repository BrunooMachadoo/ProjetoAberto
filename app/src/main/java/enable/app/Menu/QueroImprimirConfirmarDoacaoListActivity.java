package enable.app.Menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import enable.app.R;
import enable.app.User.UserBenefitedQuestion;

public class QueroImprimirConfirmarDoacaoListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quero_imprimir_confirmar_doacao_list);
        Intent intent = new Intent(QueroImprimirConfirmarDoacaoListActivity.this, SendMsgActivity.class);
        intent.putExtra(SendMsgActivity.Opt.Data.toString(), "");
        intent.putExtra(SendMsgActivity.Opt.Url.toString(), "QueroImprimirRegistred/GetInstituteAll");
        startActivityForResult(intent, 1);

        Button button_QueroImprimirConfirmarDoacaoListActivity_Pesquisar = findViewById(R.id.button_QueroImprimirConfirmarDoacaoListActivity_Pesquisar);
        button_QueroImprimirConfirmarDoacaoListActivity_Pesquisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText editText_QueroImprimirConfirmarDoacaoListActivity_FIlter = findViewById(R.id.editText_QueroImprimirConfirmarDoacaoListActivity_FIlter);
                _filter(editText_QueroImprimirConfirmarDoacaoListActivity_FIlter.getText().toString());
            }
        });
    }

    private void _filter(String value) {
        LinearLayout LinearLayout_QueroImprimirConfirmarDoacaoListActivity_opts = findViewById(R.id.LinearLayout_QueroImprimirConfirmarDoacaoListActivity_opts);
        for (int y = 0; y < LinearLayout_QueroImprimirConfirmarDoacaoListActivity_opts.getChildCount(); y++) {
            Button btn = (Button) LinearLayout_QueroImprimirConfirmarDoacaoListActivity_opts.getChildAt(y);
            btn.setVisibility(View.VISIBLE);
        }

        if (value.length() == 0) {
            return;
        }

        for (int i = 0; i < Institutes.size(); i++) {
            for (int y = 0; y < LinearLayout_QueroImprimirConfirmarDoacaoListActivity_opts.getChildCount(); y++) {
                Button btn = (Button) LinearLayout_QueroImprimirConfirmarDoacaoListActivity_opts.getChildAt(y);
                Institute institute = null;
                for (int j = 0; j < Institutes.size(); j++) {
                    Institute inst = Institutes.get(j);
                    if (inst.Text.equals(btn.getText())) {
                        institute = inst;
                        break;
                    }
                }

                if (institute.Value.toLowerCase().contains(value.toLowerCase())) {
                    btn.setVisibility(View.VISIBLE);
                } else {
                    btn.setVisibility(View.GONE);
                }
            }
        }
    }

    public class Institute {
        public String Value;
        public String Id;
        public String Text;
    }

    List<Institute> Institutes = new ArrayList<Institute>();

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == 3) {
            String r = data.getStringExtra("r");
            if (r != null) {
                String[] list = r.split("\\|");
                LinearLayout LinearLayout_QueroImprimirConfirmarDoacaoListActivity_opts = findViewById(R.id.LinearLayout_QueroImprimirConfirmarDoacaoListActivity_opts);
                for (int i = 0; i < list.length; i++) {
                    final String id = list[i].split("\\*")[0];
                    final String textName = list[i].split("\\*")[1];
                    final String qtd = list[i].split("\\*")[2];
                    final String endereco = list[i].split("\\*")[3];
                    final String cidade = list[i].split("\\*")[4];
                    final String estado = list[i].split("\\*")[5];
                    final String cep = list[i].split("\\*")[5];
                    final String enderecoTemp = endereco + "," + cep + "," + cidade + "," + estado;
                    final String filter = textName + " " + endereco + " " + cidade + " " + estado + " " + cep;

                    String text = textName + " - necessita de " + qtd + "Un";
                    Institute institute = new Institute();
                    institute.Value = filter;
                    institute.Id = id;
                    institute.Text = text;
                    Institutes.add(institute);

                    Button btn = new Button(this);
                    LinearLayout.LayoutParams buttonLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                    buttonLayoutParams.setMargins(16, 5, 16, 5);
                    btn.setLayoutParams(buttonLayoutParams);
                    btn.setText(textName + " - necessita de " + qtd + "Un");
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(QueroImprimirConfirmarDoacaoListActivity.this, QueroImprimirConfirmarDoacaoActivity.class);
                            intent.putExtra("id", id);
                            intent.putExtra("qtd", qtd);
                            intent.putExtra("name", textName);
                            intent.putExtra("endereco", enderecoTemp);
                            startActivity(intent);
                            finish();
                        }
                    });
                    btn.setLayoutParams(buttonLayoutParams);
                    LinearLayout_QueroImprimirConfirmarDoacaoListActivity_opts.addView(btn);
                }
            } else {
                TextView textView_QueroImprimirConfirmarDoacaoListActivity = findViewById(R.id.textView_QueroImprimirConfirmarDoacaoListActivity);
                textView_QueroImprimirConfirmarDoacaoListActivity.setText("Ainda não existem solicitações.");
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
