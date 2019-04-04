package com.example.experiment3;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class ProgressDialogTest extends AppCompatActivity {
    ProgressBar progressBar;
    Button start;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_dialog_test);
        progressBar=(ProgressBar) this.findViewById(R.id.progressBar);
        start=(Button) this.findViewById(R.id.start);
        start.setOnClickListener(new StartClick());
    }
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            progressBar.setProgress(msg.arg1);
            handler.postDelayed(updateProgress,1000);
        }};
    class StartClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            progressBar.setVisibility(View.VISIBLE);
            handler.post(updateProgress);
        }
    }

    Runnable updateProgress = new Runnable() {
        int i=0;
        @Override
        public void run() {
            i+=10;
            Message msg = handler.obtainMessage();
            msg.arg1=i;
            handler.sendMessage(msg);
            if(i==100){
                handler.removeCallbacks(updateProgress);
            }
        }
    };

}


