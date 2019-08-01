package com.android.calculator2.display;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.TypedArray;
import android.net.Uri;
import android.text.Editable;
import android.text.Layout;
import android.text.Selection;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View.MeasureSpec;
import android.view.textclassifier.TextClassifier;
import android.widget.Toast;
import com.google.android.calculator.R;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* compiled from: PG */
public class CalculatorFormula extends agv {

    /* renamed from: h */
    private static final Set f5882h = new HashSet(Arrays.asList(new Integer[]{Integer.valueOf(16908319), Integer.valueOf(R.id.memory_recall), Integer.valueOf(R.id.memory_store), Integer.valueOf(R.id.memory_add), Integer.valueOf(R.id.memory_subtract), Integer.valueOf(R.id.menu_paste), Integer.valueOf(16908321), Integer.valueOf(16908320)}));

    /* renamed from: b */
    public final float f5883b;

    /* renamed from: c */
    public agl f5884c;

    /* renamed from: d */
    public agj f5885d;

    /* renamed from: e */
    public agk f5886e;

    /* renamed from: f */
    public boolean f5887f;

    /* renamed from: i */
    private final TextPaint f5888i;

    /* renamed from: j */
    private final ClipboardManager f5889j;

    /* renamed from: k */
    private final float f5890k;

    /* renamed from: l */
    private final float f5891l;

    /* renamed from: m */
    private int f5892m;

    public CalculatorFormula(Context context) {
        this(context, null);
    }

    public CalculatorFormula(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CalculatorFormula(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5888i = new TextPaint();
        this.f5892m = -1;
        this.f5887f = true;
        this.f5889j = (ClipboardManager) context.getSystemService("clipboard");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, agf.f435a, i, 0);
        this.f5890k = obtainStyledAttributes.getDimension(agf.f436b, getTextSize());
        this.f5883b = obtainStyledAttributes.getDimension(agf.f437c, getTextSize());
        this.f5891l = obtainStyledAttributes.getDimension(agf.f438d, (this.f5890k - this.f5883b) / 3.0f);
        obtainStyledAttributes.recycle();
        setShowSoftInputOnFocus(false);
        setHorizontallyScrolling(false);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (!isLaidOut()) {
            m7521a(0, this.f5890k, false);
            setMinimumHeight(getLineHeight() + getCompoundPaddingBottom() + getCompoundPaddingTop());
        }
        int size = MeasureSpec.getSize(i);
        if (getMinimumWidth() != size) {
            setMinimumWidth(size);
        }
        this.f5892m = (MeasureSpec.getSize(i) - getPaddingLeft()) - getPaddingRight();
        float a = mo4831a((CharSequence) (Editable) getText());
        if (getTextSize() != a) {
            m7521a(0, a, true);
        }
        super.onMeasure(i, i2);
    }

    /* renamed from: a */
    private final void m7521a(int i, float f, boolean z) {
        float textSize = getTextSize();
        super.setTextSize(i, f);
        if (z && this.f5884c != null && getTextSize() != textSize) {
            this.f5884c.mo455a(this, textSize);
        }
    }

    public void setTextSize(int i, float f) {
        m7521a(i, f, true);
    }

    /* renamed from: a */
    public final float mo4831a(CharSequence charSequence) {
        if (this.f5892m < 0 || this.f5890k <= this.f5883b) {
            return getTextSize();
        }
        this.f5888i.set(getPaint());
        float f = this.f5883b;
        while (true) {
            float f2 = this.f5890k;
            if (f >= f2) {
                break;
            }
            this.f5888i.setTextSize(Math.min(this.f5891l + f, f2));
            if (Layout.getDesiredWidth(charSequence, this.f5888i) > ((float) this.f5892m)) {
                break;
            }
            f = this.f5888i.getTextSize();
        }
        return f;
    }

    /* renamed from: a */
    public final void mo4832a(int i) {
        Selection.setSelection((Editable) getText(), i);
    }

    /* renamed from: a */
    public final void mo4833a(int i, int i2) {
        Selection.setSelection((Editable) getText(), i, i2);
    }

    public int getSelectionStart() {
        return Math.min(Selection.getSelectionStart((Editable) getText()), Selection.getSelectionEnd((Editable) getText()));
    }

    public int getSelectionEnd() {
        return Math.max(Selection.getSelectionStart((Editable) getText()), Selection.getSelectionEnd((Editable) getText()));
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final Set mo480c() {
        return f5882h;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo479a(MenuInflater menuInflater, Menu menu) {
        super.mo479a(menuInflater, menu);
        menuInflater.inflate(R.menu.menu_formula, menu);
        C0499sj.m9331a(getContext(), menu.findItem(R.id.memory_recall), (int) R.string.desc_memory_recall);
        C0499sj.m9331a(getContext(), menu.findItem(R.id.memory_store), (int) R.string.desc_memory_store);
        C0499sj.m9331a(getContext(), menu.findItem(R.id.memory_add), (int) R.string.desc_memory_add);
        C0499sj.m9331a(getContext(), menu.findItem(R.id.memory_subtract), (int) R.string.desc_memory_subtract);
        return mo478a(menu);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo478a(Menu menu) {
        boolean f = m7524f();
        agk agk = this.f5886e;
        boolean z = false;
        boolean z2 = (agk != null && agk.mo451a()) && this.f5887f;
        if (isFocusableInTouchMode()) {
            z2 &= !hasSelection() && getSelectionStart() == length();
        }
        boolean z3 = isFocusableInTouchMode() && hasSelection() && this.f5886e.mo454d(0);
        if (z3 && this.f5886e.mo451a()) {
            z = true;
        }
        menu.findItem(R.id.menu_paste).setEnabled(f);
        menu.findItem(R.id.memory_recall).setEnabled(z2);
        menu.findItem(R.id.memory_store).setEnabled(z3);
        menu.findItem(R.id.memory_add).setEnabled(z);
        menu.findItem(R.id.memory_subtract).setEnabled(z);
        return true;
    }

    /* renamed from: b */
    public final boolean mo404b() {
        if (!hasSelection() || this.f5885d == null) {
            return false;
        }
        m7522a("calculator copy");
        Toast.makeText(getContext(), R.string.text_copied_toast, 0).show();
        return true;
    }

    /* renamed from: a */
    public final void mo403a() {
        if (hasSelection() && this.f5885d != null) {
            m7522a("calculator cut");
            this.f5885d.mo447C();
        }
    }

    /* renamed from: a */
    private final void m7522a(String str) {
        Uri B = this.f5885d.mo446B();
        String[] strArr = {"text/plain"};
        String a = C0499sj.m9325a((CharSequence) getEditableText(), getSelectionStart(), getSelectionEnd(), false);
        this.f5889j.setPrimaryClip(new ClipData(str, strArr, B == null ? new Item(a) : new Item(a, null, B)));
    }

    /* renamed from: e */
    private final void m7523e() {
        ClipData primaryClip = this.f5889j.getPrimaryClip();
        if (primaryClip != null) {
            agj agj = this.f5885d;
            if (agj != null) {
                agj.mo449a(primaryClip);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean getDefaultEditable() {
        return true;
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.memory_add) {
            this.f5886e.mo452b(0);
            return true;
        } else if (itemId == R.id.memory_subtract) {
            this.f5886e.mo453c(0);
            return true;
        } else if (itemId == R.id.memory_store) {
            this.f5886e.mo450a(0);
            return true;
        } else if (itemId == R.id.memory_recall) {
            this.f5885d.mo448D();
            return true;
        } else if (itemId == R.id.menu_paste) {
            m7523e();
            return true;
        } else if (itemId == 16908321) {
            return mo404b();
        } else {
            if (itemId != 16908320) {
                return false;
            }
            mo403a();
            return true;
        }
    }

    public boolean onTextContextMenuItem(int i) {
        switch (i) {
            case 16908320:
                mo403a();
                return true;
            case 16908321:
                return mo404b();
            case 16908322:
                m7523e();
                return true;
            default:
                return super.onTextContextMenuItem(i);
        }
    }

    /* renamed from: f */
    private final boolean m7524f() {
        ClipData primaryClip = this.f5889j.getPrimaryClip();
        if (primaryClip == null || primaryClip.getItemCount() == 0) {
            return false;
        }
        CharSequence charSequence = null;
        try {
            charSequence = primaryClip.getItemAt(0).coerceToText(getContext());
        } catch (Exception e) {
        }
        if (!TextUtils.isEmpty(charSequence)) {
            return true;
        }
        return false;
    }

    public TextClassifier getTextClassifier() {
        return TextClassifier.NO_OP;
    }
}
