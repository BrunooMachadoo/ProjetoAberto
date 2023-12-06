package enable.app.Menu;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import enable.app.R;

public class SendMsgActivity extends AppCompatActivity {
    public enum Opt {
        Data,
        Url
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_msg);
        Intent urlParameter = getIntent();
        final String Data = urlParameter.getStringExtra(Opt.Data.toString());
        final String Url = urlParameter.getStringExtra(Opt.Url.toString());

        new Thread(new Runnable() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void run() {
                try {
                    //URL url = new URL("http://192.168.0.103:5000/" + Url);
                    URL url = new URL("http://enable.solucoeslb.com.br/" + Url);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setReadTimeout(10000 /* milliseconds */);
                    conn.setConnectTimeout(15000 /* milliseconds */);
                    conn.setRequestMethod("POST");
                    conn.setRequestProperty("Content-type", "application/json");
                    conn.setRequestProperty("Accept", "application/json");
                    conn.setDoOutput(true);
                    String jsonInputString = "{" + Data + "}";
                    try (OutputStream os = conn.getOutputStream()) {
                        byte[] input = jsonInputString.getBytes("utf-8");
                        os.write(input, 0, input.length);
                    }
                    int responseCode = conn.getResponseCode();
                    Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
                    StringBuilder data = new StringBuilder();
                    for (int c; (c = in.read()) >= 0; ) {
                        data.append((char) c);
                    }
                    in.close();
                    String dataReturn = data.toString().replaceAll("\"", "");
                    if (dataReturn.equals("1") && responseCode == 200) {
                        setResult(1, null);
                    } else if (dataReturn.startsWith("-3") && responseCode == 200) {
                        Intent r = new Intent();
                        r.putExtra("r", dataReturn);
                        setResult(-3, r);
                    } else {
                        int code = -4;
                        Intent r = new Intent();
                        if (dataReturn.contains("=")){
                            code = Integer.parseInt((dataReturn.split("=")[0]));
                            int total = dataReturn.split("=").length;
                            if (total > 1){
                                r.putExtra("r", dataReturn.split("=")[1]);
                            }
                        }
                        setResult(code, r);
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                    setResult(-1, null);
                } catch (IOException e) {
                    e.printStackTrace();
                    setResult(-2, null);
                }
                finish();
            }
        }).start();

    }
}
