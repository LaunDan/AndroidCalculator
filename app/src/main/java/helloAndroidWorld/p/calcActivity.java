package helloAndroidWorld.p;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

    public void registerNumber(View sender) {
        Button pull = (Button) sender;
        float number = Float.parseFloat(tlac.getText().toString());

        int pom = obraz.length();
        if (pom >= 9) {

            if (!prosel) {
                if (number == 0) {
                    obraz.setText("0");
                    return;
                } else {
                    obraz.setText(tlac.getText());
                    prosel = true;
                }
            }
            return;
        }
        if (!prosel) {
            if (number != 0) {
                obraz.setText(tlac.getText());
                prosel = true;
            }
        } else {
            obraz.append(tlac.getText());
        }
    }
}
