package gradle.udacity.com.displaylibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    public static final String JOKE_KEY = "joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        Intent intent = getIntent();
        String joke = intent.getStringExtra(JOKE_KEY);
        TextView textView = (TextView) findViewById(R.id.joke_text_view);
        textView.setText(joke);
    }
}
