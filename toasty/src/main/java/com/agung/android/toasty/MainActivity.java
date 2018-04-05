package com.agung.android.toasty;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

import static android.graphics.Typeface.BOLD;
import static android.graphics.Typeface.BOLD_ITALIC;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onClickListenerToast();
    }

    private void onClickListenerToast() {
        findViewById(R.id.btn_just_toast).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Just Toast", Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.btn_error_toast).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toasty.error(MainActivity.this, "Upss!!! Sorry"
                        , Toast.LENGTH_SHORT, true).show();
            }
        });

        findViewById(R.id.btn_success_toast).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toasty.success(MainActivity.this, "Success!!!"
                        , Toast.LENGTH_SHORT, true).show();
            }
        });

        findViewById(R.id.btn_info_toast).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toasty.info(MainActivity.this, "Information For You"
                        , Toast.LENGTH_SHORT, true).show();
            }
        });

        findViewById(R.id.btn_info_toast_with_formating).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toasty.info(MainActivity.this, getFormattedToast(), Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.btn_warning_toast).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toasty.warning(MainActivity.this, "dangerous!!!"
                        , Toast.LENGTH_SHORT, true).show();
            }
        });

        findViewById(R.id.btn_normal_toast_without_icon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toasty.normal(MainActivity.this, "Haiii", Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.btn_normal_toast_with_icon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Drawable icon = getResources().getDrawable(R.drawable.ic_mood);
                Toasty.normal(MainActivity.this, "Haiii", Toast.LENGTH_SHORT, icon).show();
            }
        });

        findViewById(R.id.btn_custom_configuration).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toasty.Config.getInstance()
                        .setTextColor(Color.GREEN)
                        .setToastTypeface(Typeface.createFromAsset(getAssets()
                                , "PCap Terminal.otf"))
                        .apply();
                Toasty.custom(MainActivity.this, "I KILL YOU"
                        , getResources().getDrawable(R.drawable.ic_mood_bad), Color.RED
                        , Toast.LENGTH_SHORT, true, true).show();
                Toasty.Config.reset();
            }
        });


    }

    private CharSequence getFormattedToast(){
        final String prefix="Formatted";
        final String highlight=" bold italic";
        final String suffix=" Text";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(prefix)
                .append(highlight).append(suffix);
        int prefixLen = prefix.length();
        spannableStringBuilder.setSpan(new StyleSpan(BOLD_ITALIC),
                prefixLen, prefixLen+highlight.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannableStringBuilder;
    }
}
