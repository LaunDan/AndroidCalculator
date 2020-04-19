package helloAndroidWorld.p;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

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

    public void deleteAll(View v) {
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

    public void deleteOne(View v) {
        int length = screen.length();

        if (length > 1) {
            String originString = screen.getText().toString();
            String substring = originString.substring(0, length - 1);
            screen.setText(substring);
        } else if (length > 0) {
            screen.setText("0");
            passed = false;
        }
    }

    public void negative(View v) {
        float k = Float.parseFloat(screen.getText().toString());
        if (k == 0) {
            return;
        }
        String test = screen.getText().toString();
        String point = "-";

        if (test.contains(point)) {
            test = test.replace("-", "");
            screen.setText(test);
        } else {
            if (test.length() <= 8) {
                test = "-" + test;
                screen.setText(test);
            }
        }
    }

    public void sqrt(View v) {
        double number = Math.sqrt(Double.parseDouble(screen.getText().toString()));
        deleteAll(v);

        if (number >= 0) {
            String result = (String.valueOf(number));

            if (result.length() >= 9) {
                String substring = result.substring(0, 9);
                if (substring.equals("1.0000000") || substring.equals("0.9999998") || substring.equals("0.9999999")) {
                    screen.setText("1");
                    return;
                } else {
                    screen.setText(substring);
                    return;
                }
            }
            if (number != 0) {
                Double getRidOf = Double.parseDouble(result);
                int getRidOf2 = (int) Math.round(getRidOf);
                screen.setText(String.valueOf(getRidOf2));
            } else {
                screen.setText("0");
            }
        } else {
            Toast.makeText(this, "It can't be sqrt", Toast.LENGTH_LONG).show();
            deleteAll(v);
        }
    }

    public void addUp(View v){
        n1 = Double.parseDouble(screen.getText().toString());

        method = 1;
        screen.setText("0");
        passed = false;
        n1Entered = true;

        number1.setText(String.valueOf(n1));
        operation.setText("+");
    }

    public void subtract(View v) {
        n1 = Double.parseDouble(screen.getText().toString());

        method = 2;
        screen.setText("0");
        passed = false;
        n1Entered = true;

        number1.setText(String.valueOf(n1));
        operation.setText("-");
    }

    public void multiple(View V){
        n1 = Double.parseDouble(screen.getText().toString());

        method = 3;
        screen.setText("0");
        passed = false;
        n1Entered = true;

        number1.setText(String.valueOf(n1));
        operation.setText("*");
    }

    public void divide(View V){
        n1 = Double.parseDouble(screen.getText().toString());

        method = 4;
        screen.setText("0");
        passed = false;
        n1Entered = true;

        number1.setText(String.valueOf(n1));
        operation.setText("/");
    }

    public void count(View v){
        if (n1Entered) {
            if (method != 5){
                n2 = Double.parseDouble(screen.getText().toString());
                number2.setText(String.valueOf(n2));
            }
            switch (method){
                case 1: {
                    res = n1 + n2;
                    method = 5;
                    break;
                }
                case 2: {
                    res = n1 - n2;
                    method = 5;
                    break;
                }
                case 3: {
                    res = n1 * n2;
                    method = 5;
                    break;
                }
                case 4: {
                    if (n2 != 0) {
                        res = n1 / n2;
                        method = 5;
                        break;
                    } else {
                        Toast.makeText(this, "You can't devide with zero!", Toast.LENGTH_LONG).show();
                        deleteAll(v);
                        break;
                    }
                }
                case 5: {
                    break;
                }
            }

            if (res == 0) {
                screen.setText("0");
            } else {
                DecimalFormat df = new DecimalFormat("#.########");
                String result = df.format(res);
                result = result.replace(",", ".");

                int poz = result.indexOf(".");
                if (poz >= 8) {
                    Toast.makeText(this, " Nine-digit limit was exceeded!", Toast.LENGTH_LONG).show();
                    deleteAll(v);
                    return;
                }

                if (result.length() >= 10) {
                    String substring = result.substring(0, 9);
                    screen.setText(substring);
                    return;
                } else {
                    screen.setText(result);
                }

                n1Entered = false;
                passed = false;
            }
        }
    }
}
