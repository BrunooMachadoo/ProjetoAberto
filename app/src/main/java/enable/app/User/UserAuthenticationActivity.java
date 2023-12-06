package enable.app.User;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;

import enable.app.R;

public class UserAuthenticationActivity extends AppCompatActivity {

    public static String Name;
    public static String URI = "http://192.168.43.44:5000";
    //public static String URI = "http://51.143.93.158:82";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_authentication);

        Button button_UserAuthenticationActivity_User_Create = findViewById(R.id.button_UserAuthenticationActivity_User_Create);
        button_UserAuthenticationActivity_User_Create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserBenefitedQuestion.Questions = null;
                Intent intent = new Intent(UserAuthenticationActivity.this, UserBenefitedQuestionActivity.class);
                startActivity(intent);
            }
        });

        Button button_UserAuthenticationActivity_User_Attendance = findViewById(R.id.button_UserAuthenticationActivity_User_Attendance);
        button_UserAuthenticationActivity_User_Attendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserBenefitedQuestion.Questions = null;
                Intent intent = new Intent(UserAuthenticationActivity.this, UserProfileAuthenticationActivity.class);
                startActivity(intent);
            }
        });
    }
}
