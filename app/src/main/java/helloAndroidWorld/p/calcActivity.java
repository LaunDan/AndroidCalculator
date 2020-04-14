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

    private boolean passed = false;
    private boolean n1Entered = false;

    private double n1;
    private double n2;
    private double res;
    private int method = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);

        picture = findViewById(R.id.resultText);
        picture.setText("0");

        number1 = findViewById(R.id.firstNumber);
        number1.setText("NaN");

        number2 = findViewById(R.id.secondNumber);
        number2.setText("NaN");

        operation = findViewById(R.id.symbol);
        operation.setText("...");
    }
}
