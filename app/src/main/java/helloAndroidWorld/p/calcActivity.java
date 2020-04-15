package helloAndroidWorld.p;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class calcActivity extends AppCompatActivity {
    private TextView screen;
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

        screen = findViewById(R.id.resultText);
        screen.setText("0");

        number1 = findViewById(R.id.firstNumber);
        number1.setText("NaN");

        number2 = findViewById(R.id.secondNumber);
        number2.setText("NaN");

        operation = findViewById(R.id.symbol);
        operation.setText("...");
    }

    public void registerNumber(View sender) {
        Button push = (Button) sender;
        float number = Float.parseFloat(push.getText().toString());

        int pom = screen.length();
        if (pom >= 9) {

            if (!passed) {
                if (number == 0) {
                    screen.setText("0");
                    return;
                } else {
                    screen.setText(push.getText());
                    passed = true;
                }
            }
            return;
        }
        if (!passed) {
            if (number != 0) {
                screen.setText(push.getText());
                passed = true;
            }
        } else {
            screen.append(push.getText());
        }
    }

    public void registerPoint(View v) {
        if (screen.getText().length() >= 8) {
            return;
        }
        String test = screen.getText().toString();
        String point = ".";
        if (!test.contains(point)) {
            screen.append(".");
            passed = true;
        }
    }

    public void daleteAll(View v) {
        passed = false;
        n1 = 0;
        n2 = 0;
        res = 0;
        method = 5;

        screen.setText("0");
        number1.setText("NaN");
        number2.setText("NaN");
        operation.setText("...");
    }
}
