package io.github.ziginsider.epam_lection_6;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.squareup.leakcanary.RefWatcher;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text_view);

        new Task().execute(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        RefWatcher refWatcher = App.getRefWatcher(getApplicationContext());
        refWatcher.watch(this);
    }

    public class Task extends AsyncTask<Object, String, String> {

        private Context context;

        @Override
        protected void onPostExecute(String string) {
            super.onPostExecute(string);

            Intent intent = new Intent(context, AnotherActivity.class);
            startActivity(intent);
        }

        @Override
        protected String doInBackground(Object... params) {
            context = (Context) params[0];

            SingletonSaveContext.getInstance().setContext(context);

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return "Smth";
        }
    }
}

