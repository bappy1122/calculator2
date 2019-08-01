package com.android.calculator2.display;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/* compiled from: PG */
public class PadImageButton extends C0511sv {
    public PadImageButton(Context context) {
        super(context);
    }

    public PadImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PadImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        C0499sj.m9334a((View) this, motionEvent);
        return super.onTouchEvent(motionEvent);
    }
}
