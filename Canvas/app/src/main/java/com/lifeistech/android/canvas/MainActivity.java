package com.lifeistech.android.canvas;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Canvas mCanvas;
    Bitmap mBitmap;
    Paint mPaint;
    ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView = (ImageView)findViewById(R.id.imageView);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus){
        super.onWindowFocusChanged(hasFocus);
        int width = mImageView.getWidth();
        int height = mImageView.getHeight();
        mBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);

        mCanvas = new Canvas(mBitmap);
        mCanvas.drawColor(Color.WHITE);
        mPaint = new Paint();
        mPaint.setStrokeWidth(10.0f);
        mPaint.setColor(Color.RED);

        mCanvas.drawPoint(50,50,mPaint);
        mCanvas.drawPoint(50,100,mPaint);
        mCanvas.drawPoint(100,100,mPaint);
        mCanvas.drawPoint(100,50,mPaint);

        mPaint.setStrokeWidth(5.0f);
        mPaint.setColor(Color.BLUE);
        mCanvas.drawLine(50,50,100,100,mPaint);
        mCanvas.drawLine(100,50,50,100,mPaint);

        mPaint.setAntiAlias(true);
        mCanvas.drawCircle(200,200,50,mPaint);
        mPaint.setColor(Color.YELLOW);
        mCanvas.drawCircle(300,400,100,mPaint);

        Path mPath = new Path();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.argb(255,255,0,0));
        mPath.moveTo(155+0,5+0);
        mPath.lineTo(155+130,5+30);
        mPath.lineTo(155+10,5+50);
        mPath.lineTo(155+140,5+70);
        mPath.lineTo(155+0,5+110);
        mCanvas.drawPath(mPath,mPaint);

        mImageView.setImageBitmap(mBitmap);
    }

}
