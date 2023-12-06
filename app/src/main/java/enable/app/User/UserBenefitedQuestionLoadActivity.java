package enable.app.User;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;

import enable.app.Alert.AlertErrorActivity;
import enable.app.Alert.MsgActivity;
import enable.app.PutExtra;
import enable.app.R;

public class UserBenefitedQuestionLoadActivity extends AppCompatActivity {

    private String command;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_benefited_question_load);

        Intent intent = getIntent();
        command = intent.getStringExtra(PutExtra.Value.Command.toString());

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(UserAuthenticationActivity.URI + "/PatientQuestionnaire/Insert");
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setReadTimeout(10000 /* milliseconds */);
                    conn.setConnectTimeout(15000 /* milliseconds */);
                    conn.setRequestMethod("GET");
                    conn.setDoOutput(true);
                    Map<String, Object> params = new LinkedHashMap<>();
                    params.put("command", command);
                    StringBuilder postData = new StringBuilder();
                    for (Map.Entry<String, Object> param : params.entrySet()) {
                        if (postData.length() != 0) postData.append('&');
                        postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                        postData.append('=');
                        postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
                    }
                    byte[] postDataBytes = postData.toString().getBytes("UTF-8");
                    conn.setDoInput(true);
                    conn.getOutputStream().write(postDataBytes);
                    int responseCode = conn.getResponseCode();

                    Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
                    StringBuilder data = new StringBuilder();
                    for (int c; (c = in.read()) >= 0; ) {
                        data.append((char) c);
                    }
                    in.close();
                    if (data.toString().equals("1") && responseCode == 200) {
                        setResult(1, null);
                    } else if (data.toString().equals("2") && responseCode == 200) {
                        setResult(2, null);
                    } else {

                        UserBenefitedQuestion.Question questions = null;
                        for (int i = 0; i < UserBenefitedQuestion.Questions.size(); i++) {
                            String de = UserBenefitedQuestion.Questions.get(i).Column.toLowerCase();
                            String para = data.toString().toLowerCase();
                            para = para.replace("\"", "");
                            if (de.equals(para)) {
                                questions = UserBenefitedQuestion.Questions.get(i);
                                break;
                            }
                        }
                        if (questions != null) {
                            Intent intent = new Intent();
                            intent.putExtra(PutExtra.Value.QuestionIndex.toString(), questions.Id);
                            setResult(1, intent);
                        } else {
                            setResult(-1, null);
                        }

                    }
                } catch (Exception e) {
                    setResult(-1, null);
                }
                finish();
            }
        }).start();
    }
}
