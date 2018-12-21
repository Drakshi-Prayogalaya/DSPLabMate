package com.grape.matlab.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.widget.TextView;

import com.grape.matlab.R;
import com.purplebrain.adbuddiz.sdk.AdBuddiz;

public class Code_View extends Activity
{


        TextView tv,tvh;

        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_code__view);

            tv = (TextView)findViewById(R.id.textView3);
            tvh = (TextView)findViewById(R.id.textView1);
            tvh.setSelected(true);

            String fontpath = "fonts/Slabo27px-Regular.ttf";

            Typeface tf = Typeface.createFromAsset(getAssets(), fontpath);
            tv.setTypeface(tf);
            tvh.setTypeface(tf);

            Intent i = getIntent();

            if(i.hasExtra("a1"))
            {
                    tv = (TextView)findViewById(R.id.textView3);
                    tvh = (TextView)findViewById(R.id.textView1);
                    tv.setText(Html.fromHtml(i.getStringExtra("a1")));
                    tvh.setText("Verification of Sampling Theorem"); mymarquee(tvh);
            }

            if(i.hasExtra("a2"))
            {
                    tv = (TextView)findViewById(R.id.textView3);
                    tvh = (TextView)findViewById(R.id.textView1);
                    tv.setText(Html.fromHtml(i.getStringExtra("a2")));
                    tvh.setText("Calculation of Impulse Response"); mymarquee(tvh);
            }

            if(i.hasExtra("a3"))
            {
                    tv = (TextView)findViewById(R.id.textView3);
                    tvh = (TextView)findViewById(R.id.textView1);
                    tv.setText(Html.fromHtml(i.getStringExtra("a3")));
                    tvh.setText("Verification of Linear Convolution"); mymarquee(tvh);
            }

            if(i.hasExtra("a4"))
            {
                    tv = (TextView)findViewById(R.id.textView3);
                    tvh = (TextView)findViewById(R.id.textView1);
                    tv.setText(Html.fromHtml(i.getStringExtra("a4")));
                    tvh.setText("Verification of Circular Convolution"); mymarquee(tvh);
            }

            if(i.hasExtra("a5"))
            {
                    tv = (TextView)findViewById(R.id.textView3);
                    tvh = (TextView)findViewById(R.id.textView1);
                    tv.setText(Html.fromHtml(i.getStringExtra("a5")));
                    tvh.setText("Solving the Difference Equations"); mymarquee(tvh);
            }

            if(i.hasExtra("a6"))
            {
                    tv = (TextView)findViewById(R.id.textView3);
                    tvh = (TextView)findViewById(R.id.textView1);
                    tv.setText(Html.fromHtml(i.getStringExtra("a6")));
                    tvh.setText("Verification of Cross Correlation"); mymarquee(tvh);
            }

            if(i.hasExtra("a7"))
            {
                    tv = (TextView)findViewById(R.id.textView3);
                    tvh = (TextView)findViewById(R.id.textView1);
                    tv.setText(Html.fromHtml(i.getStringExtra("a7")));
                    tvh.setText("Discrete Fourier Transfrom"); mymarquee(tvh);
            }

            if(i.hasExtra("a8"))
            {
                    tv = (TextView)findViewById(R.id.textView3);
                    tvh = (TextView)findViewById(R.id.textView1);
                    tv.setText(Html.fromHtml(i.getStringExtra("a8")));
                    tvh.setText("Parallel and Lattice Realization"); mymarquee(tvh);
            }

            if(i.hasExtra("a9"))
            {
                    tv = (TextView)findViewById(R.id.textView3);
                    tvh = (TextView)findViewById(R.id.textView1);
                    tv.setText(Html.fromHtml(i.getStringExtra("a9")));
                    tvh.setText("Low Pass FIR Filter Design"); mymarquee(tvh);
            }

            if(i.hasExtra("a10"))
            {
                    tv = (TextView)findViewById(R.id.textView3);
                    tvh = (TextView)findViewById(R.id.textView1);
                    tv.setText(Html.fromHtml(i.getStringExtra("a10")));
                    tvh.setText("IIR Butterworth Filter Design"); mymarquee(tvh);
            }

            if(i.hasExtra("a11"))
            {
                    tv = (TextView)findViewById(R.id.textView3);
                    tvh = (TextView)findViewById(R.id.textView1);
                    tv.setText(Html.fromHtml(i.getStringExtra("a11")));
                    tvh.setText("Symmetric Properties of DFT"); mymarquee(tvh);
            }

            if(i.hasExtra("a12"))
            {
                    tv = (TextView)findViewById(R.id.textView3);
                    tvh = (TextView)findViewById(R.id.textView1);
                    tv.setText(Html.fromHtml(i.getStringExtra("a12")));
                    tvh.setText("Chebyshev Type-2 Filter Design"); mymarquee(tvh);
            }

            AdBuddiz.showAd(this);



        }


        public void mymarquee(TextView t)
        {
                t.setSelected(true);
                t.setEllipsize(TextUtils.TruncateAt.MARQUEE);
                t.setSingleLine(true);
                t.setMarqueeRepeatLimit(999999999);
        }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        AdBuddiz.showAd(this);
    }
}
