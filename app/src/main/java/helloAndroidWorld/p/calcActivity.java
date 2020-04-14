package helloAndroidWorld.p;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class calcActivity extends AppCompatActivity {
    private TextView picture;
    private TextView number1;
    private TextView number2;
    private TextView operation;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);

        picture = findViewById(R.id.resultText);
        picture.setText("0");

        
    }
}
