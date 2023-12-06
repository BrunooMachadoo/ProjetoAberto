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

public class QueroImprimirConfirmarDoacaoActivity extends AppCompatActivity {
    String id;
    String endereco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quero_imprimir_confirmar_doacao);
        Intent data = getIntent();
        id = data.getStringExtra("id");
        String name = data.getStringExtra("name");
        endereco = data.getStringExtra("endereco");
        TextView textView_QueroImprimirConfirmarDoacaoActivity_Qtd = findViewById(R.id.textView_QueroImprimirConfirmarDoacaoActivity_Qtd);
        textView_QueroImprimirConfirmarDoacaoActivity_Qtd.setText("Quantas unidades você doou para '" + name + "' ?");

        TextView textView_QueroImprimirConfirmarDoacaoActivity_Endereco = findViewById(R.id.textView_QueroImprimirConfirmarDoacaoActivity_Endereco);
        textView_QueroImprimirConfirmarDoacaoActivity_Endereco.setText("Ederecço: " + endereco);

        Button button_QueroImprimirConfirmarDoacaoActivity_Confirmed = findViewById(R.id.button_QueroImprimirConfirmarDoacaoActivity_Confirmed);
        button_QueroImprimirConfirmarDoacaoActivity_Confirmed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText_QueroImprimirConfirmarDoacaoActivity_Qtd = findViewById(R.id.editText_QueroImprimirConfirmarDoacaoActivity_Qtd);
                String androidId = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
                String dataSend = "";
                dataSend += "'SmartPhoneId':'" + androidId + "',";
                dataSend += "'Qtd':'" + editText_QueroImprimirConfirmarDoacaoActivity_Qtd.getText().toString() + "',";
                dataSend += "'InstituteId':'" + id + "'";

                Intent intent = new Intent(QueroImprimirConfirmarDoacaoActivity.this, SendMsgActivity.class);
                intent.putExtra(SendMsgActivity.Opt.Data.toString(), dataSend);
                intent.putExtra(SendMsgActivity.Opt.Url.toString(), "QueroImprimirRegistred/SetDoacao");
                startActivityForResult(intent, 1);
            }
        });
        Button button_QueroImprimirConfirmarDoacaoActivity_Map = findViewById(R.id.button_QueroImprimirConfirmarDoacaoActivity_Map);
        button_QueroImprimirConfirmarDoacaoActivity_Map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uri = "http://maps.google.com/maps?q=" + endereco;
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == 1) {
            Intent intent = new Intent(QueroImprimirConfirmarDoacaoActivity.this, MsgActivity.class);
            intent.putExtra(MsgActivity.Opt.Msg.toString(), "Confirmação enviada com sucesso!");
            startActivity(intent);
            finish();
        } else {
            Intent intent = new Intent(QueroImprimirConfirmarDoacaoActivity.this, MsgActivity.class);
            intent.putExtra(MsgActivity.Opt.Msg.toString(), "Erro ao tentar confirmar, por favor tente novamente.");
            startActivity(intent);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
