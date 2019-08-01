package com.android.calculator2.display;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.HorizontalScrollView;

/* compiled from: PG */
public class CalculatorScrollView extends HorizontalScrollView {

    /* renamed from: a */
    public afp f5924a;

    public CalculatorScrollView(Context context) {
        this(context, null);
    }

    public CalculatorScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CalculatorScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* renamed from: a */
    private static int m7556a(int i, int i2, int i3) {
        if (MeasureSpec.getMode(i) == 0 && (i3 == -1 || i3 == -2)) {
            return MeasureSpec.makeMeasureSpec(Math.max(0, MeasureSpec.getSize(i) - i2), 0);
        }
        return ViewGroup.getChildMeasureSpec(i, i2, i3);
    }

    /* access modifiers changed from: protected */
    public void measureChild(View view, int i, int i2) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i), 0);
        LayoutParams layoutParams = view.getLayoutParams();
        view.measure(m7556a(makeMeasureSpec, 0, layoutParams.width), m7556a(i2, getPaddingTop() + getPaddingBottom(), layoutParams.height));
    }

    /* access modifiers changed from: protected */
    public void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        view.measure(m7556a(MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i), 0), marginLayoutParams.leftMargin + marginLayoutParams.rightMargin, marginLayoutParams.width), m7556a(i3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height));
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        afp afp = this.f5924a;
        if (afp != null) {
            afp.mo400a(i, C0027ay.f2392N);
        }
    }
}
