package com.app.backgroundthread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.lang.ref.WeakReference;

public class MainActivity extends AppCompatActivity implements MyAsyncCallback {

    private TextView tvStatus, tvDescription;
    private static final String INPUT_STRING = "halo ini demo AsyncTask!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvStatus = findViewById(R.id.tv_status);
        tvDescription = findViewById(R.id.tv_description);

        DemoAsync demoAsync = new DemoAsync(this);
        demoAsync.execute(INPUT_STRING);

    }

    @Override
    public void onPreExecute() {
        tvStatus.setText(R.string.status_pre);
        tvDescription.setText(INPUT_STRING);
    }

    @Override
    public void onPostExecute(String txt) {
        tvStatus.setText(R.string.status_post);
        if (txt != null) {
            tvDescription.setText(txt);
        }
    }





    private static class DemoAsync extends AsyncTask<String, Void, String> {
        static final String LOG_ASYNC  = "DemoAsync";
        WeakReference<MyAsyncCallback> myListener;

        DemoAsync(MyAsyncCallback myListener) {
            this.myListener = new WeakReference<>(myListener);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            Log.d(LOG_ASYNC, "status : onPreExecute");
            MyAsyncCallback myListener = this.myListener.get();
            if (myListener != null) {
                myListener.onPreExecute();
            }
        }
        

        @Override
        protected String doInBackground(String... params) {
            Log.d(LOG_ASYNC, "status : doInBackground: ");

            String output = null;
            try {
                String input = params[0];
                output = input + " Selamat belajar!";
                Thread.sleep(2000);

            } catch (Exception e) {
                Log.d(LOG_ASYNC, e.getMessage());
            }
            
            return output;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            Log.d(LOG_ASYNC, "status : onPostExecute ");
            MyAsyncCallback myListener = this.myListener.get();
            if (myListener != null) {
                myListener.onPostExecute(s);
            }
        }
    }



}

interface MyAsyncCallback {
    void onPreExecute();
    void onPostExecute(String txt);
}
