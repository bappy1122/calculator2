package com.android.calculator2.display;

import android.content.Context;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.google.android.calculator.R;

/* compiled from: PG */
public class ArrowIndicator extends ImageView {

    /* renamed from: a */
    private boolean f5874a;

    public ArrowIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("ArrowIndicator_super_state", super.onSaveInstanceState());
        bundle.putBoolean("ArrowIndicator_expanded", this.f5874a);
        return bundle;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.f5874a = bundle.getBoolean("ArrowIndicator_expanded");
            m7518a();
            parcelable = bundle.getParcelable("ArrowIndicator_super_state");
        }
        super.onRestoreInstanceState(parcelable);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        m7518a();
    }

    /* renamed from: a */
    public final void mo4823a(boolean z) {
        if (z != this.f5874a) {
            this.f5874a = z;
            AnimatedVectorDrawable animatedVectorDrawable = (AnimatedVectorDrawable) getContext().getDrawable(m7519b(!this.f5874a)).getConstantState().newDrawable();
            setImageDrawable(animatedVectorDrawable);
            animatedVectorDrawable.start();
        }
    }

    /* renamed from: b */
    private static int m7519b(boolean z) {
        if (z) {
            return R.drawable.ic_horiz_caret_collapse_24px_animation;
        }
        return R.drawable.ic_horiz_caret_expand_24px_animation;
    }

    /* renamed from: a */
    private final void m7518a() {
        setImageResource(m7519b(this.f5874a));
    }
}
