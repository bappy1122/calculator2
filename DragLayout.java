package com.android.calculator2;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import com.google.android.calculator.R;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: PG */
public class DragLayout extends ViewGroup {

    /* renamed from: a */
    public final List f5862a = new CopyOnWriteArrayList();

    /* renamed from: b */
    public final Map f5863b = new HashMap();

    /* renamed from: c */
    public final Rect f5864c = new Rect();

    /* renamed from: d */
    public FrameLayout f5865d;

    /* renamed from: e */
    public C0353mz f5866e;

    /* renamed from: f */
    public afz f5867f;

    /* renamed from: g */
    public aga f5868g;

    /* renamed from: h */
    public WindowInsets f5869h;

    /* renamed from: i */
    public int f5870i;

    /* renamed from: j */
    public int f5871j;

    /* renamed from: k */
    public boolean f5872k;

    /* renamed from: l */
    public boolean f5873l;

    public DragLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        this.f5866e = C0353mz.m8674a((ViewGroup) this, 1.0f, (C0359ne) new agb(this));
        this.f5865d = (FrameLayout) findViewById(R.id.history_frame);
        this.f5865d.setOnHierarchyChangeListener(new afy(this));
        super.onFinishInflate();
    }

    public WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        if (!windowInsets.isConsumed()) {
            this.f5869h = windowInsets;
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                getChildAt(childCount).dispatchApplyWindowInsets(windowInsets);
            }
        }
        return windowInsets;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        measureChildren(i, i2);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = 0;
        for (agc x : this.f5862a) {
            i5 = Math.max(i5, x.mo434x());
        }
        this.f5871j = getHeight() - (i5 + this.f5870i);
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            int i7 = childAt == this.f5865d ? (this.f5866e.f6988f != this.f5865d || this.f5866e.f6983a == 0) ? this.f5872k ? 0 : -this.f5871j : childAt.getTop() : 0;
            childAt.layout(0, i7, childAt.getMeasuredWidth(), childAt.getMeasuredHeight() + i7);
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("SUPER_STATE", super.onSaveInstanceState());
        bundle.putBoolean("IS_VISIBLE", this.f5872k);
        return bundle;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.f5872k = bundle.getBoolean("IS_VISIBLE");
            this.f5865d.setVisibility(this.f5872k ? 0 : 4);
            for (agc b : this.f5862a) {
                b.mo431b(this.f5872k);
            }
            parcelable = bundle.getParcelable("SUPER_STATE");
        }
        super.onRestoreInstanceState(parcelable);
    }

    /* renamed from: a */
    private final void m7512a(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0 || actionMasked == 5) {
            int actionIndex = motionEvent.getActionIndex();
            int pointerId = motionEvent.getPointerId(actionIndex);
            this.f5863b.put(Integer.valueOf(pointerId), new PointF(motionEvent.getX(actionIndex), motionEvent.getY(actionIndex)));
        } else if (actionMasked == 2) {
            for (int pointerCount = motionEvent.getPointerCount() - 1; pointerCount >= 0; pointerCount--) {
                PointF pointF = (PointF) this.f5863b.get(Integer.valueOf(motionEvent.getPointerId(pointerCount)));
                if (pointF != null) {
                    pointF.set(motionEvent.getX(pointerCount), motionEvent.getY(pointerCount));
                }
            }
        } else if (actionMasked == 6) {
            this.f5863b.remove(Integer.valueOf(motionEvent.getPointerId(motionEvent.getActionIndex())));
        } else {
            if (actionMasked == 1 || actionMasked == 3) {
                this.f5863b.clear();
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        m7512a(motionEvent);
        return this.f5866e.mo5722a(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 2 && this.f5866e.f6983a == 1 && this.f5866e.f6985c != -1 && motionEvent.findPointerIndex(this.f5866e.f6985c) == -1) {
            this.f5866e.mo5718a();
            return false;
        }
        m7512a(motionEvent);
        this.f5866e.mo5726b(motionEvent);
        return true;
    }

    public void computeScroll() {
        if (this.f5866e.mo5724a(true)) {
            C0309li.m8416d(this);
        }
    }

    /* renamed from: a */
    public final void mo4807a() {
        for (agc g_ : this.f5862a) {
            g_.mo433g_();
        }
    }

    /* renamed from: b */
    public final boolean mo4810b() {
        int i = this.f5866e.f6983a;
        return i == 1 || i == 2;
    }

    /* renamed from: c */
    public final void mo4811c() {
        this.f5872k = false;
        this.f5865d.setVisibility(4);
        afz afz = this.f5867f;
        if (afz != null) {
            afz.mo425t();
        }
        if (this.f5873l) {
            this.f5873l = false;
            aga aga = this.f5868g;
            if (aga != null) {
                aga.mo427u();
            }
        }
    }

    /* renamed from: a */
    public final void mo4808a(agc agc) {
        this.f5862a.add(agc);
    }

    /* renamed from: b */
    public final void mo4809b(agc agc) {
        this.f5862a.remove(agc);
    }
}
