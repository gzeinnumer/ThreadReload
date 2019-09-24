package com.gzeinnumer.threadreload;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    //for status if screen not in activity
    public static boolean isOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        isOpen =true;
        reloadOtomatis();
    }

    private void reloadOtomatis() {
        Thread t = new Thread(){
            @Override
            public void run() {
                try{//1000 = 1dtik
                    Thread.sleep(5000);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            refreshData();
                        }
                    });
                }catch (InterruptedException e){

                }
            }
        };
        t.start();
    }

    private void refreshData() {
        Toast.makeText(this, "Refresh Data", Toast.LENGTH_SHORT).show();
    }

    //Harus ada
    @Override
    protected void onStop() {
        super.onStop();
        isOpen = false;
    }

    //Harus ada
    @Override
    protected void onStart() {
        super.onStart();
        isOpen = true;
    }

    //Harus ada
    @Override
    protected void onRestart() {
        super.onRestart();
        isOpen =true;
    }

    //Harus ada
    @Override
    protected void onResume() {
        super.onResume();
        isOpen = true;
    }
}
