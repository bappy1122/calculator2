package com.android.calculator2.display;

import android.content.Context;
import android.support.p002v7.widget.Toolbar;
import android.transition.Fade;
import android.transition.Transition;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import com.google.android.calculator.R;

/* compiled from: PG */
public class CalculatorDisplay extends LinearLayout {

    /* renamed from: a */
    public Toolbar f5875a;

    /* renamed from: b */
    public Transition f5876b;

    /* renamed from: c */
    public CalculatorFormula f5877c;

    /* renamed from: d */
    public CalculatorResult f5878d;

    /* renamed from: e */
    public CalculatorResult f5879e;

    /* renamed from: f */
    public final Runnable f5880f;

    /* renamed from: g */
    private final GestureDetector f5881g;

    public CalculatorDisplay(Context context) {
        this(context, null);
    }

    public CalculatorDisplay(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CalculatorDisplay(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5880f = new agh(this);
        this.f5881g = new GestureDetector(context, new agi(this));
        setChildrenDrawingOrderEnabled(true);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f5875a = (Toolbar) findViewById(R.id.toolbar);
        this.f5877c = (CalculatorFormula) findViewById(R.id.formula);
        this.f5878d = (CalculatorResult) findViewById(R.id.result_final);
        this.f5879e = (CalculatorResult) findViewById(R.id.result_preview);
        this.f5876b = new Fade().setDuration(200).addTarget(this.f5875a);
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i, int i2) {
        return (i - 1) - i2;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.f5881g.onTouchEvent(motionEvent);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.f5881g.onTouchEvent(motionEvent) || super.onTouchEvent(motionEvent);
    }
}
