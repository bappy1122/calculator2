package com.android.calculator2.history;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import com.google.android.calculator.R;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* compiled from: PG */
public class HistoryFormula extends agv {

    /* renamed from: c */
    private static final Set f5935c = new HashSet(Arrays.asList(new Integer[]{Integer.valueOf(16908319), Integer.valueOf(16908321)}));

    /* renamed from: b */
    public aiz f5936b;

    public HistoryFormula(Context context) {
        this(context, null);
    }

    public HistoryFormula(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HistoryFormula(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setOnTouchListener(new aiw(new GestureDetector(context, new aix(this))));
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

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final Set mo480c() {
        return f5935c;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo478a(Menu menu) {
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo479a(MenuInflater menuInflater, Menu menu) {
        super.mo479a(menuInflater, menu);
        menuInflater.inflate(R.menu.menu_historyformula, menu);
        return true;
    }

    /* renamed from: b */
    public final boolean mo404b() {
        int i;
        int i2;
        Item item;
        ClipboardManager clipboardManager = (ClipboardManager) getContext().getSystemService("clipboard");
        aiz aiz = this.f5936b;
        Uri a = aiz != null ? aiz.mo705a() : null;
        String[] strArr = {"text/plain"};
        if (hasSelection()) {
            i2 = getSelectionStart();
            i = getSelectionEnd();
        } else {
            i = length();
            i2 = 0;
        }
        String a2 = C0499sj.m9325a((CharSequence) getEditableText(), i2, i, false);
        if (a == null) {
            item = new Item(a2);
        } else {
            item = new Item(a2, null, a);
        }
        clipboardManager.setPrimaryClip(new ClipData("calculator copy", strArr, item));
        Toast.makeText(getContext(), R.string.text_copied_toast, 0).show();
        return true;
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId != R.id.menu_copy && itemId != 16908321) {
            return false;
        }
        mo404b();
        return true;
    }

    public boolean onTextContextMenuItem(int i) {
        switch (i) {
            case 16908320:
            case 16908322:
                String resourceEntryName = getResources().getResourceEntryName(i);
                StringBuilder sb = new StringBuilder(String.valueOf(resourceEntryName).length() + 32);
                sb.append("Called ");
                sb.append(resourceEntryName);
                sb.append(" on a read-only TextView!");
                throw new UnsupportedOperationException(sb.toString());
            case 16908321:
                return mo404b();
            default:
                return super.onTextContextMenuItem(i);
        }
    }
}
