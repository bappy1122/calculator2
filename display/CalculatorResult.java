package com.android.calculator2.display;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.Editable;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.ScrollingMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.GestureDetector;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.textclassifier.TextClassifier;
import android.widget.OverScroller;
import android.widget.Toast;
import com.google.android.calculator.R;

/* compiled from: PG */
public class CalculatorResult extends agg implements afr, aho, ahq, OnMenuItemClickListener {

    /* renamed from: A */
    private float f5893A;

    /* renamed from: B */
    private int f5894B = 0;

    /* renamed from: C */
    private float f5895C = 1.0f;

    /* renamed from: D */
    private float f5896D;

    /* renamed from: E */
    private int f5897E = 2;

    /* renamed from: F */
    private boolean f5898F = false;

    /* renamed from: b */
    public final OverScroller f5899b;

    /* renamed from: c */
    public final GestureDetector f5900c;

    /* renamed from: d */
    public ahq f5901d;

    /* renamed from: e */
    public ahe f5902e;

    /* renamed from: f */
    public ActionMode f5903f;

    /* renamed from: g */
    public Callback f5904g;

    /* renamed from: h */
    public afp f5905h;

    /* renamed from: i */
    public boolean f5906i = false;

    /* renamed from: j */
    public boolean f5907j = false;

    /* renamed from: k */
    public int f5908k;

    /* renamed from: l */
    public int f5909l;

    /* renamed from: m */
    public int f5910m;

    /* renamed from: n */
    private final ForegroundColorSpan f5911n;

    /* renamed from: o */
    private ahq f5912o = this;

    /* renamed from: p */
    private long f5913p;

    /* renamed from: q */
    private int f5914q;

    /* renamed from: r */
    private int f5915r;

    /* renamed from: s */
    private int f5916s;

    /* renamed from: t */
    private int f5917t;

    /* renamed from: u */
    private int f5918u;

    /* renamed from: v */
    private boolean f5919v;

    /* renamed from: w */
    private float f5920w;

    /* renamed from: x */
    private boolean f5921x;

    /* renamed from: y */
    private final Object f5922y = new Object();

    /* renamed from: z */
    private float f5923z;

    public CalculatorResult(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setFontFeatureSettings("tnum");
        setLetterSpacing(-0.05f);
        setMovementMethod(ScrollingMovementMethod.getInstance());
        this.f5899b = new OverScroller(context);
        this.f5911n = new ForegroundColorSpan(C0220ia.m8142b(context, R.color.result_exponent_text_color));
        this.f5900c = new GestureDetector(context, new agn(this));
        setOnTouchListener(new agm(this, ViewConfiguration.get(context).getScaledTouchSlop()));
        this.f5904g = new agp(this);
        setOnLongClickListener(new ago(this));
        setCursorVisible(false);
        setClickable(false);
        setLongClickable(false);
        setContentDescription(context.getString(R.string.desc_result));
    }

    /* renamed from: a */
    public final void mo4840a(int i) {
        int i2 = this.f5908k;
        if (i - i2 != 0) {
            this.f5899b.startScroll(i2, 0, i - i2, 0, 0);
            mo4846h();
            postInvalidateOnAnimation();
        }
    }

    /* renamed from: a */
    public final void mo4842a(ahe ahe, long j) {
        this.f5902e = ahe;
        this.f5913p = j;
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (!isLaidOut()) {
            super.onMeasure(i, i2);
            setMinimumHeight(getLineHeight() + getCompoundPaddingBottom() + getCompoundPaddingTop());
        }
        TextPaint paint = getPaint();
        Context context = getContext();
        float[] fArr = new float[10];
        paint.setFontFeatureSettings("tnum");
        paint.setLetterSpacing(-0.05f);
        paint.getTextWidths("0123456789", fArr);
        float f = 1.0f;
        for (float max : fArr) {
            f = Math.max(max, f);
        }
        float desiredWidth = Layout.getDesiredWidth(C0499sj.m9322a(), paint);
        float max2 = Math.max(Layout.getDesiredWidth(context.getString(R.string.op_sub), paint) - f, 0.0f);
        float max3 = Math.max(Layout.getDesiredWidth("…", paint) - f, 0.0f);
        float max4 = Math.max(Layout.getDesiredWidth(agd.m397a("e"), paint) - f, 0.0f);
        float max5 = Math.max((2.0f * max2) + max4 + desiredWidth, max4 + max3 + max2);
        int size = (MeasureSpec.getSize(i) - (getPaddingLeft() + getPaddingRight())) - (((int) Math.ceil((double) max5)) + 1);
        float desiredWidth2 = Layout.getDesiredWidth(agd.m397a(","), paint);
        float max6 = max5 - Math.max(max3, max2);
        float f2 = max5 - max2;
        float max7 = Math.max(f - desiredWidth, 0.0f);
        this.f5920w = max6 / f;
        synchronized (this.f5922y) {
            this.f5894B = size;
            this.f5895C = f;
            this.f5893A = f2 / f;
            this.f5923z = max7 / f;
            this.f5896D = desiredWidth2 / f;
        }
        super.onMeasure(i, i2);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        ahe ahe = this.f5902e;
        if (ahe != null) {
            int i5 = this.f5897E;
            if (i5 != 0) {
                if (i5 == 2) {
                    ahe.mo563b(this.f5913p, this.f5912o, (aho) this);
                } else if (i5 == 3) {
                    this.f5912o.mo625a(this.f5913p, R.string.error_syntax);
                } else {
                    ahe.mo547a(this.f5913p, this.f5912o, (aho) this);
                }
            }
        }
    }

    /* renamed from: a */
    public final void mo4841a(int i, ahq ahq) {
        this.f5912o = ahq;
        this.f5897E = i;
    }

    /* renamed from: a */
    public final float mo617a(String str, int i) {
        float f;
        int i2 = 0;
        while (i2 < i && !Character.isDigit(str.charAt(i2))) {
            i2++;
        }
        int i3 = ((i - i2) - 1) / 3;
        synchronized (this.f5922y) {
            f = ((float) i3) * this.f5896D;
        }
        return f;
    }

    /* renamed from: c */
    public final float mo618c() {
        float f;
        synchronized (this.f5922y) {
            f = this.f5893A;
        }
        return f;
    }

    /* renamed from: d */
    public final float mo619d() {
        float f;
        synchronized (this.f5922y) {
            f = this.f5923z;
        }
        return f;
    }

    /* renamed from: b */
    private static int m7535b(int i) {
        if (i == 0) {
            return 0;
        }
        return ((int) Math.ceil(Math.log10(Math.abs((double) i)) + 1.0E-10d)) + (i >= 0 ? 1 : 2);
    }

    /* renamed from: a */
    public final void mo626a(long j, int i, int i2, int i3, String str) {
        int i4;
        int i5;
        int i6;
        int i7 = i2;
        int i8 = i3;
        String str2 = str;
        int f = mo620f();
        this.f5915r = str.length();
        int ceil = (int) Math.ceil((double) ((mo617a(str2, str.length()) - mo618c()) - 1.0E-4f));
        this.f5919v = this.f5915r + ceil <= f;
        this.f5914q = 10010000;
        this.f5917t = i8;
        this.f5921x = false;
        int round = Math.round(((float) i) * this.f5895C);
        this.f5909l = round;
        this.f5908k = round;
        if (i7 != Integer.MAX_VALUE) {
            int i9 = str2.charAt(0) == '-' ? 1 : 0;
            int i10 = this.f5915r;
            if (i7 <= i10 || i7 > i10 + 3) {
                i4 = i7;
            } else {
                i4 = i10 - 1;
            }
            int i11 = i4 - this.f5915r;
            if (i11 >= 0 && i11 < 8) {
                i11 = -1;
            }
            if (i8 < 10000000) {
                this.f5916s = i8;
                int i12 = this.f5916s;
                if (i12 < -1 && i12 > -11) {
                    this.f5916s = -1;
                }
                int i13 = this.f5916s;
                if (i13 < -1) {
                    i5 = m7535b((-i11) - 1);
                } else if (i11 >= 0 || i13 >= f) {
                    i5 = m7535b(-i11);
                } else {
                    i5 = 0;
                }
                if (!this.f5919v || i11 >= -3) {
                    ceil = 0;
                }
                this.f5906i = (((this.f5916s + i5) + ceil) - i11) + i9 >= f;
                if (i5 > 0) {
                    if (this.f5906i) {
                        i6 = this.f5916s + m7535b(-i8);
                    } else {
                        i6 = this.f5916s + i5;
                    }
                    if (this.f5916s >= 0 || i6 < 0) {
                        this.f5916s = Math.min(i6, 10000000);
                    } else {
                        this.f5916s = -1;
                    }
                    this.f5910m = Math.min(Math.round(((float) this.f5916s) * this.f5895C), 10000000);
                } else if (this.f5919v || this.f5906i) {
                    this.f5910m = Math.min(Math.round(((float) this.f5916s) * this.f5895C), 10000000);
                } else {
                    this.f5906i = ((this.f5916s + m7535b((-i11) - 1)) - i11) + i9 >= f;
                    if (this.f5906i) {
                        this.f5910m = (int) Math.ceil((double) (((float) this.f5909l) + this.f5895C));
                    } else {
                        this.f5910m = this.f5909l;
                        this.f5921x = true;
                    }
                }
                if (!this.f5906i) {
                    this.f5908k = this.f5910m;
                }
            } else {
                this.f5916s = 10000000;
                this.f5910m = 10000000;
                this.f5906i = true;
            }
        } else if (i8 == Integer.MIN_VALUE) {
            this.f5910m = this.f5909l;
            this.f5916s = Math.round(((float) this.f5910m) / this.f5895C);
            this.f5906i = false;
        } else {
            this.f5916s = 10000000;
            this.f5910m = 10000000;
            this.f5909l = (int) (((float) this.f5909l) - this.f5895C);
            this.f5906i = true;
        }
        if (this.f5898F) {
            this.f5902e.mo599p(j);
            this.f5898F = false;
        } else {
            long j2 = j;
        }
        mo4846h();
        ahq ahq = this.f5901d;
        if (ahq != null) {
            ahq.mo626a(j, i, i2, i3, str);
        }
    }

    /* renamed from: a */
    public final void mo625a(long j, int i) {
        this.f5898F = false;
        this.f5907j = false;
        setLongClickable(false);
        this.f5906i = false;
        String string = getContext().getString(i);
        float desiredWidth = Layout.getDesiredWidth(string, getPaint());
        int i2 = this.f5894B;
        if (desiredWidth > ((float) i2)) {
            RelativeSizeSpan relativeSizeSpan = new RelativeSizeSpan((((float) i2) * 0.99f) / desiredWidth);
            SpannableString spannableString = new SpannableString(string);
            spannableString.setSpan(relativeSizeSpan, 0, string.length(), 33);
            setText(spannableString);
        } else {
            setText(string);
        }
        ahq ahq = this.f5901d;
        if (ahq != null) {
            ahq.mo625a(j, i);
        }
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=boolean, code=int, for r17v0, types: [int, boolean] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.CharSequence m7534a(java.lang.String r13, int r14, int r15, boolean r16, int r17, int[] r18, boolean r19, boolean r20, boolean r21) {
        /*
            r12 = this;
            r0 = r12
            r1 = r13
            r2 = r14
            r3 = 46
            r4 = 45
            r5 = 2147483647(0x7fffffff, float:NaN)
            r6 = -1
            r7 = 0
            if (r16 == 0) goto L_0x0010
            r9 = -1
            goto L_0x002a
        L_0x0010:
            int r8 = r13.length()
            r9 = 0
        L_0x0015:
            if (r9 >= r8) goto L_0x0027
            char r10 = r13.charAt(r9)
            if (r10 == r4) goto L_0x0024
            if (r10 == r3) goto L_0x0024
            r11 = 48
            if (r10 == r11) goto L_0x0024
            goto L_0x002a
        L_0x0024:
            int r9 = r9 + 1
            goto L_0x0015
        L_0x0027:
            r9 = 2147483647(0x7fffffff, float:NaN)
        L_0x002a:
            java.lang.String r8 = "…"
            r10 = 1
            if (r16 != 0) goto L_0x003d
            if (r17 == 0) goto L_0x003b
            char r11 = r13.charAt(r7)
            if (r11 == r4) goto L_0x003b
            goto L_0x003d
        L_0x003b:
            r4 = 0
            goto L_0x005f
        L_0x003d:
            java.lang.String r4 = java.lang.String.valueOf(r8)
            int r11 = r13.length()
            java.lang.String r1 = r13.substring(r10, r11)
            java.lang.String r1 = java.lang.String.valueOf(r1)
            int r11 = r1.length()
            if (r11 == 0) goto L_0x0059
            java.lang.String r1 = r4.concat(r1)
            goto L_0x005e
        L_0x0059:
            java.lang.String r1 = new java.lang.String
            r1.<init>(r4)
        L_0x005e:
            r4 = 1
        L_0x005f:
            int r3 = r1.indexOf(r3)
            if (r18 == 0) goto L_0x0067
            r18[r7] = r2
        L_0x0067:
            if (r20 != 0) goto L_0x0126
            if (r3 == r6) goto L_0x0072
            if (r9 == r5) goto L_0x0076
            int r5 = r9 - r3
            r11 = 7
            if (r5 <= r11) goto L_0x0076
        L_0x0072:
            if (r2 == r6) goto L_0x0076
            goto L_0x0126
        L_0x0076:
            if (r21 == 0) goto L_0x0124
            int r2 = r1.length()
            if (r3 == r6) goto L_0x009e
            float r5 = r12.mo617a(r1, r3)
            android.text.SpannableStringBuilder r9 = new android.text.SpannableStringBuilder
            java.lang.String r11 = p000.agd.m397a(r1)
            java.lang.CharSequence r11 = p000.C0499sj.m9349c(r11, r4, r3)
            r9.<init>(r11)
            java.lang.String r1 = r1.substring(r3, r2)
            java.lang.String r1 = p000.agd.m397a(r1)
            android.text.SpannableStringBuilder r1 = r9.append(r1)
            r9 = r1
            goto L_0x00af
        L_0x009e:
            float r5 = r12.mo617a(r1, r2)
            android.text.SpannableStringBuilder r9 = new android.text.SpannableStringBuilder
            java.lang.String r1 = p000.agd.m397a(r1)
            java.lang.CharSequence r1 = p000.C0499sj.m9349c(r1, r4, r2)
            r9.<init>(r1)
        L_0x00af:
            if (r4 == 0) goto L_0x00b3
            int r2 = r2 + -1
        L_0x00b3:
            float r1 = (float) r2
            float r1 = r1 + r5
            r2 = 0
            if (r3 != r6) goto L_0x00bb
            r3 = 0
            goto L_0x00bf
        L_0x00bb:
            float r3 = r12.mo619d()
        L_0x00bf:
            float r1 = r1 - r3
            if (r4 == 0) goto L_0x00c5
            float r3 = r0.f5920w
            goto L_0x00c9
        L_0x00c5:
            float r3 = r12.mo618c()
        L_0x00c9:
            float r3 = r1 - r3
            int r5 = r15 - r4
            float r5 = (float) r5
            r6 = 953267991(0x38d1b717, float:1.0E-4)
            float r5 = r5 + r6
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 <= 0) goto L_0x00fc
            if (r19 != 0) goto L_0x00fc
        L_0x00d9:
            float r3 = r0.f5920w
            float r3 = r1 - r3
            float r3 = r3 - r2
            int r5 = r15 + -1
            float r5 = (float) r5
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 <= 0) goto L_0x00fc
            int r3 = r7 + 1
            java.lang.Class<age> r5 = p000.age.class
            java.lang.Object[] r5 = r9.getSpans(r7, r3, r5)
            age[] r5 = (p000.age[]) r5
            int r5 = r5.length
            r6 = 1065353216(0x3f800000, float:1.0)
            if (r5 != r10) goto L_0x00f9
            float r5 = r0.f5896D
            float r5 = r5 + r6
            float r2 = r2 + r5
            goto L_0x00fa
        L_0x00f9:
            float r2 = r2 + r6
        L_0x00fa:
            r7 = r3
            goto L_0x00d9
        L_0x00fc:
            if (r7 <= 0) goto L_0x0114
            java.lang.String r1 = p000.agd.m397a(r8)
            android.text.SpannableStringBuilder r1 = android.text.SpannableStringBuilder.valueOf(r1)
            int r2 = r9.length()
            java.lang.CharSequence r2 = r9.subSequence(r7, r2)
            android.text.SpannableStringBuilder r9 = r1.append(r2)
            goto L_0x0123
        L_0x0114:
            if (r4 == 0) goto L_0x0123
            java.lang.String r1 = p000.agd.m397a(r8)
            android.text.SpannableStringBuilder r1 = android.text.SpannableStringBuilder.valueOf(r1)
            android.text.SpannableStringBuilder r9 = r1.append(r9)
        L_0x0123:
            return r9
        L_0x0124:
            goto L_0x022c
        L_0x0126:
            int r4 = -r2
            if (r2 < 0) goto L_0x012a
            goto L_0x012b
        L_0x012a:
            int r4 = r4 - r10
        L_0x012b:
            if (r16 != 0) goto L_0x01b3
            int r5 = r15 + -1
            if (r9 >= r5) goto L_0x01b3
            int r5 = r1.length()
            int r5 = r5 - r9
            int r5 = r5 + r10
            int r5 = r5 + r17
            int r6 = r15 + 1
            if (r5 > r6) goto L_0x01b3
            if (r3 <= r9) goto L_0x0166
            java.lang.String r5 = r1.substring(r7, r3)
            java.lang.String r5 = java.lang.String.valueOf(r5)
            int r3 = r3 + r10
            int r6 = r1.length()
            java.lang.String r1 = r1.substring(r3, r6)
            java.lang.String r1 = java.lang.String.valueOf(r1)
            int r3 = r1.length()
            if (r3 == 0) goto L_0x0161
            java.lang.String r1 = r5.concat(r1)
            goto L_0x0166
        L_0x0161:
            java.lang.String r1 = new java.lang.String
            r1.<init>(r5)
        L_0x0166:
            int r3 = r1.length()
            int r5 = r9 + 1
            java.lang.String r6 = r1.substring(r5, r3)
            if (r17 == 0) goto L_0x0175
            java.lang.String r8 = "-"
            goto L_0x0177
        L_0x0175:
            java.lang.String r8 = ""
        L_0x0177:
            java.lang.String r1 = r1.substring(r9, r5)
            java.lang.String r5 = java.lang.String.valueOf(r8)
            int r5 = r5.length()
            int r5 = r5 + r10
            java.lang.String r11 = java.lang.String.valueOf(r1)
            int r11 = r11.length()
            int r5 = r5 + r11
            java.lang.String r11 = java.lang.String.valueOf(r6)
            int r11 = r11.length()
            int r5 = r5 + r11
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>(r5)
            r11.append(r8)
            r11.append(r1)
            java.lang.String r1 = "."
            r11.append(r1)
            r11.append(r6)
            java.lang.String r1 = r11.toString()
            int r3 = r3 + r4
            int r3 = r3 - r9
            int r3 = r3 - r10
            r5 = r1
            r1 = 1
            goto L_0x01b6
        L_0x01b3:
            r5 = r1
            r3 = r4
            r1 = 0
        L_0x01b6:
            if (r19 != 0) goto L_0x0200
            r6 = 2
            if (r1 == 0) goto L_0x01d0
            int r1 = m7535b(r3)
            int r2 = r5.length()
            int r2 = r2 - r10
            if (r1 < r2) goto L_0x01e6
            int r1 = r5.length()
            int r1 = r1 - r6
            int r1 = java.lang.Math.max(r1, r7)
            goto L_0x01e6
        L_0x01d0:
            r1 = 2
        L_0x01d1:
            int r3 = r4 + r1
            int r6 = m7535b(r3)
            if (r6 <= r1) goto L_0x01dc
            int r1 = r1 + 1
            goto L_0x01d1
        L_0x01dc:
            int r2 = r2 - r1
            int r4 = r0.f5917t
            if (r2 <= r4) goto L_0x01e6
            int r1 = r1 + 1
            int r3 = r3 + 1
        L_0x01e6:
            int r2 = r5.length()
            int r2 = r2 - r10
            if (r1 < r2) goto L_0x01f0
            java.lang.String r1 = "…E…"
            return r1
        L_0x01f0:
            int r2 = r5.length()
            int r2 = r2 - r1
            java.lang.String r5 = r5.substring(r7, r2)
            if (r18 == 0) goto L_0x0200
            r2 = r18[r7]
            int r2 = r2 - r1
            r18[r7] = r2
        L_0x0200:
            java.lang.String r1 = java.lang.Integer.toString(r3)
            java.lang.String r2 = java.lang.String.valueOf(r5)
            int r2 = r2.length()
            int r2 = r2 + r10
            java.lang.String r3 = java.lang.String.valueOf(r1)
            int r3 = r3.length()
            int r2 = r2 + r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            r3.append(r5)
            java.lang.String r2 = "E"
            r3.append(r2)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            goto L_0x0124
        L_0x022c:
            java.lang.String r1 = p000.agd.m397a(r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.calculator2.display.CalculatorResult.m7534a(java.lang.String, int, int, boolean, boolean, int[], boolean, boolean, boolean):java.lang.CharSequence");
    }

    /* renamed from: a */
    private final CharSequence m7533a(int i, int i2, int[] iArr, boolean z, boolean z2, boolean z3) {
        boolean[] zArr = new boolean[1];
        boolean[] zArr2 = new boolean[1];
        int[] iArr2 = {i};
        return m7534a(this.f5902e.mo544a(this.f5913p, iArr2, this.f5916s, i2, zArr, zArr2, this), iArr2[0], i2, zArr[0], zArr2[0], iArr, z, z2, z3);
    }

    /* renamed from: a */
    public final CharSequence mo4839a(boolean z) {
        if (!this.f5907j) {
            return "";
        }
        if (!this.f5906i) {
            Editable editable = (Editable) getText();
            return C0499sj.m9325a((CharSequence) editable, 0, editable.length(), z);
        }
        return m7533a(this.f5918u, 1000000, null, true, false, z);
    }

    /* renamed from: e */
    public final CharSequence mo4844e() {
        int i;
        String str;
        if (this.f5907j && this.f5917t != Integer.MAX_VALUE) {
            if (!(!this.f5906i || (m7536c(this.f5910m) == m7536c(this.f5908k) && this.f5916s != 10000000))) {
                int i2 = this.f5915r;
                if (i2 <= 2000) {
                    int i3 = this.f5917t;
                    if (i2 + i3 <= 2000 && i3 - this.f5918u <= 100) {
                        int max = Math.max(0, i3);
                        String a = this.f5902e.mo568c(this.f5913p).mo655a(max);
                        if (this.f5917t < 0) {
                            str = a.substring(0, a.length() - 1);
                            i = -1;
                        } else {
                            i = max;
                            str = a;
                        }
                        return m7534a(str, i, 1000000, false, str.charAt(0) == '-', null, true, false, false);
                    }
                }
            }
        }
        return mo4839a(false);
    }

    /* renamed from: f */
    public final int mo620f() {
        int floor;
        synchronized (this.f5922y) {
            floor = (int) Math.floor((double) (((float) this.f5894B) / this.f5895C));
        }
        return floor;
    }

    /* renamed from: c */
    private final int m7536c(int i) {
        return Math.round(((float) i) / this.f5895C);
    }

    /* renamed from: g */
    public final void mo4845g() {
        this.f5907j = false;
        this.f5906i = false;
        setText("");
        setLongClickable(false);
    }

    /* renamed from: a */
    public final void mo624a(long j) {
        mo4845g();
        this.f5898F = false;
        ahq ahq = this.f5901d;
        if (ahq != null) {
            ahq.mo624a(j);
        }
    }

    /* renamed from: b */
    public final void mo627b(long j) {
        mo4846h();
        ahq ahq = this.f5901d;
        if (ahq != null) {
            ahq.mo627b(j);
        }
    }

    /* renamed from: h */
    public final void mo4846h() {
        int f = mo620f();
        if (f >= 4) {
            if (this.f5899b.isFinished() && length() > 0) {
                setAccessibilityLiveRegion(1);
            }
            int c = m7536c(this.f5908k);
            int[] iArr = new int[1];
            CharSequence a = m7533a(c, f, iArr, this.f5921x, !this.f5919v && c == m7536c(this.f5909l), this.f5919v);
            String charSequence = a.toString();
            int indexOf = charSequence.indexOf(agd.m397a("E").charAt(0));
            if (charSequence.contains(agd.m397a("."))) {
                SpannableString spannableString = new SpannableString(a);
                C0499sj.m9333a((Spannable) spannableString, getContext());
                setText(spannableString);
            } else if (indexOf > 0) {
                SpannableString spannableString2 = new SpannableString(a);
                spannableString2.setSpan(this.f5911n, indexOf, a.length(), 33);
                setText(spannableString2);
            } else {
                setText(a);
            }
            this.f5918u = iArr[0];
            this.f5907j = true;
            setLongClickable(true);
        }
    }

    /* access modifiers changed from: protected */
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (!this.f5906i || this.f5899b.isFinished()) {
            if (i3 == 0) {
                setAccessibilityLiveRegion(0);
                setContentDescription(getContext().getString(R.string.desc_result));
                return;
            }
            setAccessibilityLiveRegion(1);
            setContentDescription(null);
        }
    }

    public void computeScroll() {
        if (this.f5906i && this.f5907j) {
            if (this.f5899b.computeScrollOffset()) {
                this.f5908k = this.f5899b.getCurrX();
                if (m7536c(this.f5908k) != m7536c(this.f5914q)) {
                    this.f5914q = this.f5908k;
                    mo4846h();
                }
            }
            if (!this.f5899b.isFinished()) {
                postInvalidateOnAnimation();
                setAccessibilityLiveRegion(0);
                return;
            }
            if (length() > 0) {
                setAccessibilityLiveRegion(1);
            }
        }
    }

    /* renamed from: i */
    public final boolean mo4847i() {
        ActionMode actionMode = this.f5903f;
        if (actionMode == null) {
            return false;
        }
        actionMode.finish();
        return true;
    }

    /* renamed from: j */
    public final void mo4848j() {
        Selection.removeSelection((Editable) getText());
    }

    /* renamed from: a */
    public final void mo403a() {
    }

    /* renamed from: b */
    public final boolean mo404b() {
        CharSequence e = mo4844e();
        if (e == null || this.f5902e.mo587j(this.f5913p)) {
            return false;
        }
        String[] strArr = {"text/plain"};
        ((ClipboardManager) getContext().getSystemService("clipboard")).setPrimaryClip(new ClipData("calculator result", strArr, new Item(e, null, this.f5902e.mo604s(this.f5913p))));
        Toast.makeText(getContext(), R.string.text_copied_toast, 0).show();
        mo4848j();
        return true;
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.memory_add) {
            this.f5902e.mo600q(this.f5913p);
            return true;
        } else if (itemId == R.id.memory_subtract) {
            this.f5902e.mo603r(this.f5913p);
            return true;
        } else if (itemId == R.id.memory_store) {
            if (this.f5902e.mo583h(this.f5913p)) {
                this.f5902e.mo599p(this.f5913p);
            } else {
                this.f5898F = true;
                this.f5902e.mo563b(this.f5913p, (ahq) this, (aho) this);
            }
            return true;
        } else if (itemId == R.id.menu_copy) {
            return mo404b();
        } else {
            return false;
        }
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

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        mo4847i();
        super.onDetachedFromWindow();
    }

    public TextClassifier getTextClassifier() {
        return TextClassifier.NO_OP;
    }
}
