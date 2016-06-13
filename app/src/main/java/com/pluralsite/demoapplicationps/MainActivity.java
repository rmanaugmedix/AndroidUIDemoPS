package com.pluralsite.demoapplicationps;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button1;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = getApplicationContext();
        button1 = (Button) findViewById(R.id.button);
        TextView TV = (TextView)findViewById(R.id.header);

        Spannable wordtoSpan = new SpannableString(getString(R.string.retain_talent));

        wordtoSpan.setSpan(new StyleSpan(Typeface.BOLD),7,12, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        wordtoSpan.setSpan(new ForegroundColorSpan(Color.GRAY), 0, 6, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        TV.setText(wordtoSpan);

/*        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //button1.setTextColor(context.getResources().getColor(R.color.white));
            }
        });*/
    }
}
