package com.android.calculator2.history;

import android.content.Context;
import android.util.AttributeSet;
import com.android.calculator2.display.CalculatorResult;
import java.util.Arrays;

/* compiled from: PG */
public class HistoryResult extends CalculatorResult {
    public HistoryResult(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i);
        boolean z = false;
        for (int i2 = 0; i2 < onCreateDrawableState.length; i2++) {
            if (onCreateDrawableState[i2] == 16842908) {
                if (isPressed()) {
                    onCreateDrawableState[i2] = 16842919;
                }
                z = true;
            }
            if (z && !isPressed()) {
                int i3 = i2 + 1;
                if (i3 < onCreateDrawableState.length) {
                    onCreateDrawableState[i2] = onCreateDrawableState[i3];
                }
            }
        }
        if (!z || isPressed()) {
            return onCreateDrawableState;
        }
        return Arrays.copyOf(onCreateDrawableState, onCreateDrawableState.length - 1);
    }
}
