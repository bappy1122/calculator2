package com.android.calculator2.history;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.Toast;
import com.google.android.calculator.R;

/* compiled from: PG */
public class CopyableTextView extends C0538tv implements afr {
    public CopyableTextView(Context context) {
        this(context, null);
    }

    public CopyableTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public CopyableTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* renamed from: a */
    public final void mo403a() {
    }

    /* renamed from: b */
    public final boolean mo404b() {
        ((ClipboardManager) getContext().getSystemService("clipboard")).setPrimaryClip(new ClipData("calculator copy", new String[]{"text/plain"}, new Item(getText())));
        Toast.makeText(getContext(), R.string.text_copied_toast, 0).show();
        return true;
    }
}
