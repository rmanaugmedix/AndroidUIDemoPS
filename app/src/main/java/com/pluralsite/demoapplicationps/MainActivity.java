package com.pluralsite.demoapplicationps;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TextAppearanceSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static android.text.Spanned.SPAN_EXCLUSIVE_EXCLUSIVE;

public class MainActivity extends Activity {

    Button button1;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = getApplicationContext();
        button1 = (Button) findViewById(R.id.button);
        TextView tv1 = (TextView)findViewById(R.id.header);
        TextView tv2 = (TextView)findViewById(R.id.textView2);

        String[] a = new String[2];
        a[0] = "test1";
        a[1] = "test2";

        Spannable wordtoSpan1 = new SpannableString(getResources().getString(R.string.retain_talent));
        Spannable wordtoSpan2 = new SpannableString(getResources().getString(R.string.do_not_have_an_account));

        wordtoSpan1.setSpan(new StyleSpan(Typeface.BOLD),7,12, SPAN_EXCLUSIVE_EXCLUSIVE);
        wordtoSpan1.setSpan(new ForegroundColorSpan(Color.GRAY), 0, 6, SPAN_EXCLUSIVE_EXCLUSIVE);
        wordtoSpan1.setSpan(new RelativeSizeSpan(0.75f), 7,13, 0);
        wordtoSpan1.setSpan(new StrikethroughSpan(), 0,6, 0);
        wordtoSpan1.setSpan(new UnderlineSpan(), 7,13, 0);

        wordtoSpan2.setSpan(new TextAppearanceSpan(context, R.style.CustomTextStyle),0,wordtoSpan2.length(), SPAN_EXCLUSIVE_EXCLUSIVE);

        //wordtoSpan.setSpan(new SuggestionSpan(context, a, SuggestionSpan.FLAG_AUTO_CORRECTION),7,12,0);
        wordtoSpan2.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show();
            }
        },wordtoSpan2.length()-11,wordtoSpan2.length(),0);

        tv1.setText(wordtoSpan1);

        tv2.setText(wordtoSpan2);
        tv2.setMovementMethod(LinkMovementMethod.getInstance());

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1.setText("Success");
                button1.setTextColor(context.getResources().getColor(R.color.white));
                button1.setBackgroundColor(getResources().getColor(R.color.successColor));
            }
        });
    }
}
