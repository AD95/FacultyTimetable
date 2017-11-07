package edu.msrit.facultytimetable;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import static android.content.pm.PackageManager.PERMISSION_GRANTED;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class SplashScreenActivity extends AppCompatActivity {
    /// Splash screen timer
    private static int SPLASH_TIME_OUT = 500;
    String PERMISSIONS_STORAGE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        PERMISSIONS_STORAGE = Manifest.permission.WRITE_EXTERNAL_STORAGE;
        String[] PERMISSIONS_STORAGE1 = {
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        };
        if(ActivityCompat.checkSelfPermission(getApplicationContext(), PERMISSIONS_STORAGE)!=PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(SplashScreenActivity.this,PERMISSIONS_STORAGE1,12);
        }
        else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i);
                    finish();
                }
            }, SPLASH_TIME_OUT);
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String permissions[], @NonNull int[] grantResults) {
        switch (requestCode) {
            case 12: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i);
                    finish();
                } else {
                    Toast.makeText(this, "Please grant permission!", Toast.LENGTH_SHORT).show();
                    finish();
                }
                return;
            }
        }
    }
}