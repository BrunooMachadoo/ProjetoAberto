package enable.app.Menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import enable.app.R;
import enable.app.User.UserBenefitedQuestion;

public class QueroImprimirActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quero_imprimir);

        Button button_QueroImprimirActivity_Cadastro = findViewById(R.id.button_QueroImprimirActivity_Cadastro);
        button_QueroImprimirActivity_Cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(QueroImprimirActivity.this, QueroImprimirTermActivity.class);
                startActivity(intent);
                finish();
            }
        });

        Button button_QueroImprimirActivity_ConfirmarDoacao = findViewById(R.id.button_QueroImprimirActivity_ConfirmarDoacao);
        button_QueroImprimirActivity_ConfirmarDoacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(QueroImprimirActivity.this, QueroImprimirConfirmarDoacaoListActivity.class);
                startActivity(intent);
            }
        });


        Button button_QueroImprimirActivity_AreaPrint = findViewById(R.id.button_QueroImprimirActivity_AreaPrint);
        button_QueroImprimirActivity_AreaPrint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://e-nablebrasil.org/wp/impressaomontagem/"));
                startActivity(browserIntent);
            }
        });

        String androidId = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
        String dataSend = "";
        dataSend += "'SmartPhoneId':'" + androidId + "'";
        Intent intent = new Intent(QueroImprimirActivity.this, SendMsgActivity.class);
        intent.putExtra(SendMsgActivity.Opt.Data.toString(), dataSend);
        intent.putExtra(SendMsgActivity.Opt.Url.toString(), "QueroImprimirRegistred/ImpressionArea");
        startActivityForResult(intent, 1);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == 2) {
            String r = data.getStringExtra("r");
            TextView textView_QueroImprimirActivity_Name = findViewById(R.id.textView_QueroImprimirActivity_Name);
            textView_QueroImprimirActivity_Name.setText("Olá " + r + ", obrigado por nos ajudar.");
            textView_QueroImprimirActivity_Name.setVisibility(View.VISIBLE);

            Button button_QueroImprimirActivity_AreaPrint = findViewById(R.id.button_QueroImprimirActivity_AreaPrint);
            button_QueroImprimirActivity_AreaPrint.setVisibility(View.VISIBLE);

            Button button_QueroImprimirActivity_ConfirmarDoacao = findViewById(R.id.button_QueroImprimirActivity_ConfirmarDoacao);
            button_QueroImprimirActivity_ConfirmarDoacao.setVisibility(View.VISIBLE);

        } else if (resultCode == -4) {
            Button button_QueroImprimirActivity_Cadastro = findViewById(R.id.button_QueroImprimirActivity_Cadastro);
            button_QueroImprimirActivity_Cadastro.setVisibility(View.VISIBLE);
        } else {
            finish();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
