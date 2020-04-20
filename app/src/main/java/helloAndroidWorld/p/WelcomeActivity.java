package helloAndroidWorld.p;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);

        ImageView imgvwSpsoa = findViewById(R.id.imageView2);
        Animation animSpsoaLogo = AnimationUtils.loadAnimation(this, R.anim.weclome_sc);

        imgvwSpsoa.startAnimation(animSpsoaLogo);
        Thread thrdWlcmscrnDelay = new Thread() {
            public void run() {
                try {
                    sleep(3500);
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    finish();
                }
            }
        };
        thrdWlcmscrnDelay.start();
    }
}
