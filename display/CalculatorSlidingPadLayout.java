package com.android.calculator2.display;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: PG */
public class CalculatorSlidingPadLayout extends aas {

    /* renamed from: j */
    public final aex f5925j;

    /* renamed from: k */
    public ArrowIndicator f5926k;

    /* renamed from: l */
    public int f5927l;

    /* renamed from: m */
    public final OnClickListener f5928m;

    /* renamed from: n */
    private final ColorDrawable f5929n;

    /* renamed from: o */
    private final GestureDetector f5930o;

    /* renamed from: p */
    private final aaz f5931p;

    /* renamed from: q */
    private boolean f5932q;

    public CalculatorSlidingPadLayout(Context context) {
        this(context, null);
    }

    public CalculatorSlidingPadLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CalculatorSlidingPadLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5929n = new ColorDrawable();
        this.f5928m = new agr(this);
        this.f5925j = aex.m325a(context);
        this.f5931p = new aaz(this, null);
        super.mo23a(this.f5931p);
        this.f37a = 0;
        getViewTreeObserver().addOnGlobalLayoutListener(new agq(this));
        this.f5930o = new GestureDetector(context, new agt(this));
        this.f5930o.setIsLongpressEnabled(false);
    }

    /* renamed from: a */
    public final void mo23a(aaz aaz) {
        this.f5931p.mo63a(aaz);
    }

    /* renamed from: a */
    public final void mo22a(int i) {
        this.f5927l = i >>> 24;
        this.f5929n.setColor(i | -16777216);
        this.f5929n.setAlpha(mo4858e() ? this.f5927l : 0);
        getChildAt(0).setForeground(this.f5929n);
    }

    /* renamed from: a */
    public final void mo4857a(boolean z) {
        if (this.f5932q != z) {
            this.f5932q = z;
            invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!mo4858e() || m7557a(motionEvent, getChildAt(1))) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            if (mo4858e() && !m7557a(motionEvent, getChildAt(1))) {
                this.f5930o.onTouchEvent(motionEvent);
            }
            return super.onTouchEvent(motionEvent);
        } catch (IllegalArgumentException e) {
            Log.e("Calculator", "Error processing touch event", e);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (C0499sj.m9354e()) {
            if (this.f5932q || mo4858e()) {
                setSystemGestureExclusionRects(bwu.m4622g());
            } else {
                View childAt = getChildAt(1);
                setSystemGestureExclusionRects(bwu.m4618a((Object) new Rect(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom())));
            }
        }
    }

    /* renamed from: a */
    private static boolean m7557a(MotionEvent motionEvent, View view) {
        return motionEvent.getX() >= ((float) view.getLeft()) && motionEvent.getX() < ((float) view.getRight()) && motionEvent.getY() >= ((float) view.getTop()) && motionEvent.getY() < ((float) view.getBottom());
    }

    /* renamed from: e */
    public final boolean mo4858e() {
        return !mo29c();
    }
}
