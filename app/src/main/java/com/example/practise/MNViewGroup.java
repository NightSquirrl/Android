package com.example.practise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.ViewGroup;

public class MNViewGroup extends ViewGroup {

    private int mWidth;
    private int mHeight;
    public MNViewGroup(Context context) {
        this(context,null);
    }

    public MNViewGroup(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MNViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        // 没有子view的情况
        int childCount = getChildCount();
        if(childCount == 0) {
            mWidth = measureWidthAndHeight(widthMeasureSpec);
            mHeight = measureWidthAndHeight(heightMeasureSpec);
            setMeasuredDimension(mWidth,mHeight);
        } else {
        int childViewWidth = 0;
        int childViewHeight = 0; //子view的宽高
        }
    }

    private int measureWidthAndHeight(int measureSpec) {
        int  result = 0;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        if(specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        } else {
            result = 0;
        }
        return result;
    }

    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {

    }
}