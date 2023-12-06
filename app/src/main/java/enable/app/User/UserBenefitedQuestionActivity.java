package enable.app.User;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.provider.MediaStore;
import android.provider.Settings;
import android.text.InputType;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Map;

import enable.app.Alert.AlertErrorActivity;
import enable.app.Alert.AlertPopup;
import enable.app.Alert.MsgActivity;
import enable.app.PutExtra;
import enable.app.R;


public class UserBenefitedQuestionActivity extends AppCompatActivity {

    private int questionIndex = 0;
    EditText editText_UserBenefitedQuestionActivity_Question;
    TextView TextView_UserBenefitedQuestionActivity_Question_Date;
    ImageView imageView_UserBenefitedQuestionActivity;

    Spinner spinner_UserBenefitedQuestionActivity_Question;
    UserBenefitedQuestion.Question question;

    final UserBenefitedQuestion userBenefitedQuestion = new UserBenefitedQuestion();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_benefited_question);

        spinner_UserBenefitedQuestionActivity_Question = (Spinner) findViewById(R.id.spinner_UserBenefitedQuestionActivity_Question);
        TextView_UserBenefitedQuestionActivity_Question_Date = findViewById(R.id.TextView_UserBenefitedQuestionActivity_Question_Date);
        TextView_UserBenefitedQuestionActivity_Question_Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DATE_DIALOG_ID);
            }
        });

        imageView_UserBenefitedQuestionActivity = findViewById(R.id.imageView_UserBenefitedQuestionActivity);

        Intent IntentGet = getIntent();
        int questionIndexIntent = IntentGet.getIntExtra(PutExtra.Value.QuestionIndex.toString(), -1);
        if (questionIndexIntent > -1) {
            questionIndex = questionIndexIntent;
        }
        question = userBenefitedQuestion.getQuestion(questionIndex);
        if (question == null) {
            Intent intent = new Intent(this,
                    MsgActivity.class);
            startActivity(intent);
            finish();
        } else {
            if (question.Photo) {
                dispatchTakePictureIntent();
            } else {
                TextView textView_UserBenefitedQuestionActivity_Question = findViewById(R.id.textView_UserBenefitedQuestionActivity_Question);
                textView_UserBenefitedQuestionActivity_Question.setText(question.Text);

                editText_UserBenefitedQuestionActivity_Question = findViewById(R.id.editText_UserBenefitedQuestionActivity_Question);
                editText_UserBenefitedQuestionActivity_Question.setHint(question.Hint);
            }

            if (question.InputType == UserBenefitedQuestion.InputType.EditText) {
                editText_UserBenefitedQuestionActivity_Question.setVisibility(View.VISIBLE);
            } else if (question.InputType == UserBenefitedQuestion.InputType.Date) {
                TextView_UserBenefitedQuestionActivity_Question_Date.setVisibility(View.VISIBLE);
            } else if (question.InputType == UserBenefitedQuestion.InputType.Number) {
                editText_UserBenefitedQuestionActivity_Question.setVisibility(View.VISIBLE);
                editText_UserBenefitedQuestionActivity_Question.setInputType(InputType.TYPE_CLASS_NUMBER);
            } else if (question.InputType == UserBenefitedQuestion.InputType.Img) {
                Context c = getApplicationContext();
                int id = c.getResources().getIdentifier("drawable/image" + question.Id, null, c.getPackageName());
                imageView_UserBenefitedQuestionActivity.setImageResource(id);
                imageView_UserBenefitedQuestionActivity.setVisibility(View.VISIBLE);
                spinner_UserBenefitedQuestionActivity_Question.setVisibility(View.VISIBLE);
                ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, question.Options);
                spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down vieww
                spinner_UserBenefitedQuestionActivity_Question.setAdapter(spinnerArrayAdapter);
            } else if (question.InputType == UserBenefitedQuestion.InputType.Radio) {
                RadioGroup RadioGroup_UserBenefitedQuestionActivity = findViewById(R.id.RadioGroup_UserBenefitedQuestionActivity);
                for (int i = 0; i < question.Options.size(); i++) {
                    String op = question.Options.get(i);
                    RadioButton btn = new RadioButton(this);
                    RadioGroup.LayoutParams params = new RadioGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    params.setMargins(0, 15, 0, 0);
                    btn.setLayoutParams(params);
                    btn.setText(op);
                    RadioGroup_UserBenefitedQuestionActivity.addView(btn);
                }
            } else {
                spinner_UserBenefitedQuestionActivity_Question.setVisibility(View.VISIBLE);
                ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, question.Options);
                spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down vieww
                spinner_UserBenefitedQuestionActivity_Question.setAdapter(spinnerArrayAdapter);
            }
        }

        Button button_UserBenefitedQuestionActivity_Save = findViewById(R.id.button_UserBenefitedQuestionActivity_Save);
        button_UserBenefitedQuestionActivity_Save.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                if (question.InputType == UserBenefitedQuestion.InputType.EditText ||
                        question.InputType == UserBenefitedQuestion.InputType.Number) {
                    question.Value = editText_UserBenefitedQuestionActivity_Question.getText().toString();
                } else if (question.InputType == UserBenefitedQuestion.InputType.Date) {
                    question.Value = TextView_UserBenefitedQuestionActivity_Question_Date.getText().toString();
                } else if (question.InputType == UserBenefitedQuestion.InputType.Radio) {
                    RadioGroup rg = (RadioGroup) findViewById(R.id.RadioGroup_UserBenefitedQuestionActivity);
                    if (rg.getCheckedRadioButtonId() != -1) {
                        question.Value =
                                ((RadioButton) findViewById(rg.getCheckedRadioButtonId()))
                                        .getText().toString();
                    }
                } else {
                    question.Value = spinner_UserBenefitedQuestionActivity_Question.getSelectedItem().toString();
                }

                if (question.Value == null && question.Photo == false) {
                    AlertPopup.Show(UserBenefitedQuestionActivity.this, question.Hint);
                } else if (question.Value.length() == 0 ||
                        question.Value.equals("Selecione o estado...") ||
                        question.Value.equals("Selecione a data") ||
                        question.Value.equals("Selecione a opção...")) {
                    AlertPopup.Show(UserBenefitedQuestionActivity.this, question.Hint);
                } else {
                    UserBenefitedQuestion.Question questionName = userBenefitedQuestion.getQuestion(0);
                    Intent intent = new Intent(UserBenefitedQuestionActivity.this, UserBenefitedQuestionLoadActivity.class);
                    String command = questionName.Column + "-" + questionName.Value + "|" + question.Column + "-" + question.Value;
                    intent.putExtra(PutExtra.Value.Command.toString(), command);
                    startActivityForResult(intent, 1);
                }
            }
        });
    }

    private void ThreadRun() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(5000);
                        if (UserAuthenticationActivity.Name == null) {
                            continue;
                        }
                        URL url = new URL(UserAuthenticationActivity.URI + "/Notification/Smartphone");
                        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                        conn.setReadTimeout(10000 /* milliseconds */);
                        conn.setConnectTimeout(15000 /* milliseconds */);
                        conn.setRequestMethod("GET");
                        conn.setDoOutput(true);
                        Map<String, Object> params = new LinkedHashMap<>();
                        params.put("name", UserAuthenticationActivity.Name);
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
                            createNotificationChannel(UserAuthenticationActivity.Name);
                            finish();
                            break;
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (ProtocolException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    private void _alert() {
        Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        vibrator.vibrate(1000);
        Uri alert = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        MediaPlayer mp = MediaPlayer.create(getBaseContext(), alert);
        mp.setVolume(100, 100);
        mp.start();
    }


    private void createNotificationChannel(String name) {
        String NOTIFICATION_CHANNEL_ID = "10001";
        String msg = "Você ganhou uma mãozinha, clique aqui e veja os detalhes.";
        String title = "Parabéns " + name;
        Context  mContext = this;
        if (Build.VERSION.SDK_INT < 16) {
            _alert();
            Notification n = new Notification.Builder(this)
                    .setContentTitle(title)
                    .setContentText(msg)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setAutoCancel(true).getNotification();
            NotificationManager notificationManager =
                    (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.notify(0, n);
        } else {
            Intent resultIntent = new Intent(mContext , UserAuthenticationActivity.class);
            resultIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            PendingIntent resultPendingIntent = PendingIntent.getActivity(mContext,
                    0 /* Request code */, resultIntent,
                    PendingIntent.FLAG_UPDATE_CURRENT);

            NotificationCompat.Builder   mBuilder = new NotificationCompat.Builder(mContext);
            mBuilder.setSmallIcon(R.mipmap.ic_launcher);
            mBuilder.setContentTitle(title)
                    .setContentText(msg)
                    .setAutoCancel(false)
                    .setSound(Settings.System.DEFAULT_NOTIFICATION_URI)
                    .setContentIntent(resultPendingIntent);

            NotificationManager  mNotificationManager = (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O)
            {
                int importance = NotificationManager.IMPORTANCE_HIGH;
                NotificationChannel notificationChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, "NOTIFICATION_CHANNEL_NAME", importance);
                notificationChannel.enableLights(true);
                notificationChannel.setLightColor(Color.RED);
                notificationChannel.enableVibration(true);
                notificationChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
                assert mNotificationManager != null;
                mBuilder.setChannelId(NOTIFICATION_CHANNEL_ID);
                mNotificationManager.createNotificationChannel(notificationChannel);
            }
            assert mNotificationManager != null;
            mNotificationManager.notify(0 /* Request Code */, mBuilder.build());
        }
    }


    static final int DATE_DIALOG_ID = 0;

    @Override
    protected Dialog onCreateDialog(int id) {
        Calendar calendario = Calendar.getInstance();
        int ano = calendario.get(Calendar.YEAR);
        int mes = calendario.get(Calendar.MONTH);
        int dia = calendario.get(Calendar.DAY_OF_MONTH);

        switch (id) {
            case DATE_DIALOG_ID:
                return new DatePickerDialog(this, mDateSetListener, ano, mes,
                        dia);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener mDateSetListener =
            new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker view, int year, int monthOfYear,
                                      int dayOfMonth) {
                    String data = String.valueOf(dayOfMonth) + "/"
                            + String.valueOf(monthOfYear + 1) + "/" + String.valueOf(year);
                    TextView_UserBenefitedQuestionActivity_Question_Date.setText(data);
                }
            };

    static final int REQUEST_IMAGE_CAPTURE = 1;

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == 1) {
            if (data != null) {
                int questionIndexResume = data.getIntExtra(PutExtra.Value.QuestionIndex.toString(), -1);
                if (questionIndexResume != -1) {
                    questionIndex = questionIndexResume;
                } else {
                    questionIndex++;
                }
            } else {
                questionIndex++;
            }
            Intent intent = new Intent(UserBenefitedQuestionActivity.this, UserBenefitedQuestionActivity.class);
            intent.putExtra(PutExtra.Value.QuestionIndex.toString(), questionIndex);
            startActivity(intent);
            finish();
        } else if (resultCode == 2) {
            Intent intent = new Intent(this,
                    AlertErrorActivity.class);
            intent.putExtra(PutExtra.Value.Msg.toString(), "Cadastro já realizado, aguarde o nosso contato.");
            startActivity(intent);
            if (questionIndex == 0) {
                UserAuthenticationActivity.Name = question.Value;
            }
            ThreadRun();
            finish();
        } else {
            Intent intent = new Intent(this,
                    AlertErrorActivity.class);
            intent.putExtra(PutExtra.Value.Msg.toString(), "Ocorreu um erro, por favor tente novamente.");
            startActivity(intent);
        }
    }
}
