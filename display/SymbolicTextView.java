package com.android.calculator2.display;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode.Callback;

/* compiled from: PG */
public class SymbolicTextView extends agg {

    /* renamed from: b */
    public static final bxb f5933b = bxb.m4644a(2, Integer.valueOf(16908321), Integer.valueOf(16908341));

    /* renamed from: c */
    private final Callback f5934c = new agw(this);

    public SymbolicTextView(Context context) {
        super(context);
        setCustomSelectionActionModeCallback(this.f5934c);
    }

    public SymbolicTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setCustomSelectionActionModeCallback(this.f5934c);
    }

    public SymbolicTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setCustomSelectionActionModeCallback(this.f5934c);
    }
}
