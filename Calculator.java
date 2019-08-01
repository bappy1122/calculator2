package com.android.calculator2;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.support.p002v7.widget.LinearLayoutManager;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.util.Pair;
import android.util.Property;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.android.calculator2.display.CalculatorDisplay;
import com.android.calculator2.display.CalculatorFormula;
import com.android.calculator2.display.CalculatorResult;
import com.android.calculator2.display.CalculatorScrollView;
import com.android.calculator2.display.CalculatorSlidingPadLayout;
import com.google.android.calculator.R;
import com.google.android.gms.feedback.ErrorReport;
import com.google.android.gms.googlehelp.GoogleHelp;
import java.io.File;
import java.util.ArrayList;

/* compiled from: PG */
public class Calculator extends C0368nn implements aey, aft, afz, aga, agc, agj, agl, ahq, ahu, ahv, OnLongClickListener {

    /* renamed from: f */
    public static final bxg f5824f;

    /* renamed from: v */
    private static final Property f5825v = new aez(Integer.class, "textColor");
    /* access modifiers changed from: private */

    /* renamed from: A */
    public ahe f5826A;

    /* renamed from: B */
    private Button f5827B;

    /* renamed from: C */
    private TextView f5828C;

    /* renamed from: D */
    private ViewGroup f5829D;

    /* renamed from: E */
    private ViewGroup f5830E;

    /* renamed from: F */
    private View f5831F;

    /* renamed from: G */
    private View f5832G;

    /* renamed from: H */
    private View f5833H;

    /* renamed from: I */
    private TextView f5834I;

    /* renamed from: J */
    private TextView f5835J;

    /* renamed from: K */
    private View[] f5836K;

    /* renamed from: L */
    private View[] f5837L;

    /* renamed from: M */
    private View f5838M;

    /* renamed from: N */
    private String f5839N;

    /* renamed from: O */
    private int f5840O;

    /* renamed from: P */
    private ForegroundColorSpan f5841P;

    /* renamed from: Q */
    private aex f5842Q;

    /* renamed from: g */
    public final OnPreDrawListener f5843g;

    /* renamed from: h */
    public final Handler f5844h;

    /* renamed from: i */
    public CalculatorDisplay f5845i;

    /* renamed from: j */
    public CalculatorFormula f5846j;

    /* renamed from: k */
    public CalculatorResult f5847k;

    /* renamed from: l */
    public CalculatorResult f5848l;

    /* renamed from: m */
    public CalculatorScrollView f5849m;

    /* renamed from: n */
    public DragLayout f5850n;

    /* renamed from: o */
    public CalculatorSlidingPadLayout f5851o;

    /* renamed from: p */
    public View f5852p;

    /* renamed from: q */
    public Animator f5853q;

    /* renamed from: r */
    public int f5854r;

    /* renamed from: s */
    public int f5855s;

    /* renamed from: t */
    public boolean f5856t;

    /* renamed from: u */
    public Runnable f5857u;

    /* renamed from: w */
    private OnPreDrawListener f5858w;

    /* renamed from: x */
    private final agk f5859x;

    /* renamed from: y */
    private final TextWatcher f5860y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public int f5861z;

    public Calculator() {
        bps bps = bps.f3874c;
        if (bzl.m4818a() && bps.f3876e > 0 && bps.f3878g == 0 && bps.f3879h == 0) {
            bps.f3878g = SystemClock.elapsedRealtime();
            bps.mo3022a();
        }
        this.f5843g = new afe(this);
        this.f5859x = new agk(this);
        this.f5860y = new afh(this);
        this.f5844h = new Handler();
        this.f5854r = 0;
        this.f5855s = C0027ay.f2388J;
        this.f5839N = "";
        this.f5840O = 0;
    }

    /* renamed from: E */
    private final void m7430E() {
        this.f5840O = 0;
        this.f5854r = 0;
        this.f5839N = "";
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0294, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x029d, code lost:
        throw r9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r12) {
        /*
            r11 = this;
            super.onCreate(r12)
            r0 = 2131034141(0x7f05001d, float:1.7678791E38)
            r11.setContentView(r0)
            r0 = 2131624297(0x7f0e0169, float:1.887577E38)
            android.view.View r0 = r11.findViewById(r0)
            android.support.v7.widget.Toolbar r0 = (android.support.p002v7.widget.Toolbar) r0
            np r1 = r11.mo5774j()
            r1.mo5791a(r0)
            android.view.Window r0 = r11.getWindow()
            android.view.View r0 = r0.getDecorView()
            int r0 = r0.getSystemUiVisibility()
            android.view.Window r1 = r11.getWindow()
            android.view.View r1 = r1.getDecorView()
            boolean r2 = p000.C0499sj.m9354e()
            r3 = 0
            if (r2 == 0) goto L_0x0037
            r2 = 512(0x200, float:7.175E-43)
            goto L_0x0038
        L_0x0037:
            r2 = 0
        L_0x0038:
            r0 = r0 | r2
            r0 = r0 | 1024(0x400, float:1.435E-42)
            r0 = r0 | 256(0x100, float:3.59E-43)
            r1.setSystemUiVisibility(r0)
            android.content.res.Resources r0 = r11.getResources()
            r1 = 2131427332(0x7f0b0004, float:1.8476277E38)
            boolean r0 = r0.getBoolean(r1)
            r11.m7474f(r0)
            np r0 = r11.mo5774j()
            nd r0 = r0.mo5788a()
            r0.mo5738a(r3)
            r0 = 2131624165(0x7f0e00e5, float:1.8875502E38)
            android.view.View r0 = r11.findViewById(r0)
            r11.f5852p = r0
            r0 = 2131624182(0x7f0e00f6, float:1.8875536E38)
            android.view.View r0 = r11.findViewById(r0)
            com.android.calculator2.display.CalculatorDisplay r0 = (com.android.calculator2.display.CalculatorDisplay) r0
            r11.f5845i = r0
            android.view.View r0 = r11.f5852p
            afg r1 = new afg
            r1.<init>(r11)
            r0.setOnApplyWindowInsetsListener(r1)
            r0 = 2131624298(0x7f0e016a, float:1.8875772E38)
            android.view.View r0 = r11.findViewById(r0)
            android.widget.Button r0 = (android.widget.Button) r0
            r11.f5827B = r0
            r0 = 2131624184(0x7f0e00f8, float:1.887554E38)
            android.view.View r0 = r11.findViewById(r0)
            com.android.calculator2.display.CalculatorFormula r0 = (com.android.calculator2.display.CalculatorFormula) r0
            r11.f5846j = r0
            r0 = 2131624190(0x7f0e00fe, float:1.8875553E38)
            android.view.View r0 = r11.findViewById(r0)
            com.android.calculator2.display.CalculatorResult r0 = (com.android.calculator2.display.CalculatorResult) r0
            r11.f5848l = r0
            r0 = 2131624185(0x7f0e00f9, float:1.8875543E38)
            android.view.View r0 = r11.findViewById(r0)
            com.android.calculator2.display.CalculatorResult r0 = (com.android.calculator2.display.CalculatorResult) r0
            r11.f5847k = r0
            r0 = 2131624189(0x7f0e00fd, float:1.887555E38)
            android.view.View r0 = r11.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r11.f5828C = r0
            r0 = 2131624188(0x7f0e00fc, float:1.8875549E38)
            android.view.View r0 = r11.findViewById(r0)
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            r11.f5830E = r0
            r0 = 2131624183(0x7f0e00f7, float:1.8875539E38)
            android.view.View r0 = r11.findViewById(r0)
            com.android.calculator2.display.CalculatorScrollView r0 = (com.android.calculator2.display.CalculatorScrollView) r0
            r11.f5849m = r0
            ahe r0 = p000.ahe.m482a(r11)
            r11.f5826A = r0
            ahe r0 = r11.f5826A
            r1 = 1
            r0.mo556a(r1)
            ahe r0 = r11.f5826A
            r0.mo553a(r11, r11)
            com.android.calculator2.display.CalculatorResult r0 = r11.f5848l
            r4 = 0
            if (r0 == 0) goto L_0x00e5
            com.android.calculator2.display.CalculatorResult r2 = r11.f5847k
            r0.f5901d = r2
            ahe r2 = r11.f5826A
            r0.mo4842a(r2, r4)
        L_0x00e5:
            com.android.calculator2.display.CalculatorResult r0 = r11.f5847k
            ahe r2 = r11.f5826A
            r0.mo4842a(r2, r4)
            com.android.calculator2.display.CalculatorFormula r0 = r11.f5846j
            agk r2 = r11.f5859x
            r0.f5886e = r2
            p000.agd.f429b = r11
            r0 = 2131624291(0x7f0e0163, float:1.8875758E38)
            android.view.View r0 = r11.findViewById(r0)
            r11.f5831F = r0
            r0 = 2131624292(0x7f0e0164, float:1.887576E38)
            android.view.View r0 = r11.findViewById(r0)
            r11.f5832G = r0
            r0 = 2131624275(0x7f0e0153, float:1.8875725E38)
            android.view.View r0 = r11.findViewById(r0)
            r2 = 2131624289(0x7f0e0161, float:1.8875754E38)
            android.view.View r6 = r0.findViewById(r2)
            r11.f5833H = r6
            android.view.View r6 = r11.f5833H
            if (r6 == 0) goto L_0x0121
            int r6 = r6.getVisibility()
            if (r6 == 0) goto L_0x012e
        L_0x0121:
            r6 = 2131624290(0x7f0e0162, float:1.8875756E38)
            android.view.View r6 = r11.findViewById(r6)
            android.view.View r2 = r6.findViewById(r2)
            r11.f5833H = r2
        L_0x012e:
            r2 = 2131624288(0x7f0e0160, float:1.8875751E38)
            android.view.View r0 = r0.findViewById(r2)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r2 = p000.C0499sj.m9322a()
            r0.setText(r2)
            java.lang.String r2 = p000.C0499sj.m9324a(r11)
            r0.setContentDescription(r2)
            r0 = 2131624252(0x7f0e013c, float:1.8875678E38)
            android.view.View r0 = r11.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r11.f5834I = r0
            r0 = 2131624253(0x7f0e013d, float:1.887568E38)
            android.view.View r0 = r11.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r11.f5835J = r0
            com.android.calculator2.display.CalculatorResult r0 = r11.f5848l
            if (r0 != 0) goto L_0x0161
            r0 = 1
            goto L_0x0162
        L_0x0161:
            r0 = 0
        L_0x0162:
            r11.f5856t = r0
            boolean r0 = r11.f5856t
            if (r0 == 0) goto L_0x016b
            com.android.calculator2.display.CalculatorScrollView r0 = r11.f5849m
            goto L_0x0174
        L_0x016b:
            r0 = 2131624187(0x7f0e00fb, float:1.8875547E38)
            android.view.View r0 = r11.findViewById(r0)
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
        L_0x0174:
            r11.f5829D = r0
            r0 = 6
            android.view.View[] r2 = new android.view.View[r0]
            r6 = 2131624255(0x7f0e013f, float:1.8875685E38)
            android.view.View r6 = r11.findViewById(r6)
            r2[r3] = r6
            r6 = 2131624257(0x7f0e0141, float:1.8875689E38)
            android.view.View r6 = r11.findViewById(r6)
            r2[r1] = r6
            r6 = 2131624259(0x7f0e0143, float:1.8875693E38)
            android.view.View r6 = r11.findViewById(r6)
            r7 = 2
            r2[r7] = r6
            r6 = 2131624261(0x7f0e0145, float:1.8875697E38)
            android.view.View r6 = r11.findViewById(r6)
            r8 = 3
            r2[r8] = r6
            r6 = 2131624263(0x7f0e0147, float:1.88757E38)
            android.view.View r6 = r11.findViewById(r6)
            r9 = 4
            r2[r9] = r6
            r6 = 2131624265(0x7f0e0149, float:1.8875705E38)
            android.view.View r6 = r11.findViewById(r6)
            r10 = 5
            r2[r10] = r6
            r11.f5836K = r2
            android.view.View[] r2 = new android.view.View[r0]
            r6 = 2131624256(0x7f0e0140, float:1.8875687E38)
            android.view.View r6 = r11.findViewById(r6)
            r2[r3] = r6
            r6 = 2131624258(0x7f0e0142, float:1.887569E38)
            android.view.View r6 = r11.findViewById(r6)
            r2[r1] = r6
            r6 = 2131624260(0x7f0e0144, float:1.8875695E38)
            android.view.View r6 = r11.findViewById(r6)
            r2[r7] = r6
            r6 = 2131624262(0x7f0e0146, float:1.8875699E38)
            android.view.View r6 = r11.findViewById(r6)
            r2[r8] = r6
            r6 = 2131624264(0x7f0e0148, float:1.8875703E38)
            android.view.View r6 = r11.findViewById(r6)
            r2[r9] = r6
            r6 = 2131624266(0x7f0e014a, float:1.8875707E38)
            android.view.View r6 = r11.findViewById(r6)
            r2[r10] = r6
            r11.f5837L = r2
            r2 = 2131624164(0x7f0e00e4, float:1.88755E38)
            android.view.View r2 = r11.findViewById(r2)
            com.android.calculator2.DragLayout r2 = (com.android.calculator2.DragLayout) r2
            r11.f5850n = r2
            com.android.calculator2.DragLayout r2 = r11.f5850n
            r2.mo4809b(r11)
            com.android.calculator2.DragLayout r2 = r11.f5850n
            r2.mo4808a(r11)
            com.android.calculator2.DragLayout r2 = r11.f5850n
            r2.f5867f = r11
            r2.f5868g = r11
            com.android.calculator2.display.CalculatorFormula r2 = r11.f5846j
            r2.setFocusableInTouchMode(r1)
            com.android.calculator2.display.CalculatorFormula r2 = r11.f5846j
            r2.setCursorVisible(r1)
            com.android.calculator2.display.CalculatorFormula r2 = r11.f5846j
            r2.f5885d = r11
            r2.f5884c = r11
            android.text.TextWatcher r6 = r11.f5860y
            r2.addTextChangedListener(r6)
            android.view.View r2 = r11.f5831F
            r2.setOnLongClickListener(r11)
            android.view.View r2 = r11.f5831F
            android.widget.ImageView r2 = (android.widget.ImageView) r2
            android.graphics.drawable.Drawable r2 = r2.getDrawable()
            r2.setLevel(r1)
            android.text.style.ForegroundColorSpan r2 = new android.text.style.ForegroundColorSpan
            r6 = 2131492887(0x7f0c0017, float:1.8609239E38)
            int r6 = p000.C0220ia.m8142b(r11, r6)
            r2.<init>(r6)
            r11.f5841P = r2
            if (r12 == 0) goto L_0x02b5
            int[] r2 = p000.C0027ay.m2354a()
            int r6 = p000.C0027ay.f2380B
            int r6 = r6 - r1
            java.lang.String r9 = "Calculator_display_state"
            int r6 = r12.getInt(r9, r6)
            r2 = r2[r6]
            r11.m7467c(r2)
            java.lang.String r2 = "Calculator_unprocessed_chars"
            java.lang.CharSequence r2 = r12.getCharSequence(r2)
            boolean r6 = android.text.TextUtils.isEmpty(r2)
            if (r6 != 0) goto L_0x0266
            java.lang.String r2 = r2.toString()
            r11.f5839N = r2
        L_0x0266:
            java.lang.String r2 = "Calculator_unprocessed_chars_loc"
            int r2 = r12.getInt(r2, r3)
            r11.f5840O = r2
            java.lang.String r2 = "Calculator_cursor_position_start"
            int r2 = r12.getInt(r2, r3)
            r11.f5854r = r2
            java.lang.String r2 = "Calculator_eval_state"
            byte[] r2 = r12.getByteArray(r2)
            if (r2 == 0) goto L_0x02ab
            java.io.ObjectInputStream r6 = new java.io.ObjectInputStream     // Catch:{ all -> 0x029e }
            java.io.ByteArrayInputStream r9 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x029e }
            r9.<init>(r2)     // Catch:{ all -> 0x029e }
            r6.<init>(r9)     // Catch:{ all -> 0x029e }
            ahe r2 = r11.f5826A     // Catch:{ all -> 0x0292 }
            r2.mo554a(r6)     // Catch:{ all -> 0x0292 }
            r6.close()     // Catch:{ all -> 0x029e }
            goto L_0x02ab
        L_0x0292:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x0294 }
        L_0x0294:
            r9 = move-exception
            r6.close()     // Catch:{ all -> 0x0299 }
            goto L_0x029d
        L_0x0299:
            r6 = move-exception
            p000.byt.m4756a(r2, r6)     // Catch:{ all -> 0x029e }
        L_0x029d:
            throw r9     // Catch:{ all -> 0x029e }
        L_0x029e:
            r2 = move-exception
            int r2 = p000.C0027ay.f2380B
            r11.f5861z = r2
            r11.m7430E()
            ahe r2 = r11.f5826A
            r2.mo579f()
        L_0x02ab:
            java.lang.String r2 = "Calculator_inverse_mode"
            boolean r12 = r12.getBoolean(r2)
            r11.m7468c(r12)
            goto L_0x02c4
        L_0x02b5:
            int r12 = p000.C0027ay.f2380B
            r11.f5861z = r12
            r11.m7430E()
            ahe r12 = r11.f5826A
            r12.mo579f()
            r11.m7468c(r3)
        L_0x02c4:
            ahe r12 = r11.f5826A
            boolean r12 = r12.mo565b(r4)
            r11.m7470d(r12)
            int r12 = r11.f5861z
            int r2 = p000.C0027ay.f2385G
            if (r12 == r2) goto L_0x02dd
            int r12 = r11.f5861z
            int r2 = p000.C0027ay.f2383E
            if (r12 == r2) goto L_0x02dd
            r11.m7437L()
        L_0x02dd:
            int r12 = r11.f5861z
            int r2 = p000.C0027ay.f2380B
            if (r12 != r2) goto L_0x0300
            com.android.calculator2.display.CalculatorResult r12 = r11.mo4781k()
            ahe r0 = r11.f5826A
            aha r0 = r0.mo537a(r4)
            boolean r0 = r0.mo510c()
            if (r0 == 0) goto L_0x02fb
            boolean r0 = r11.m7440O()
            if (r0 != 0) goto L_0x02fb
            r0 = 1
            goto L_0x02fc
        L_0x02fb:
            r0 = 0
        L_0x02fc:
            r12.mo4841a(r0, r11)
            goto L_0x0334
        L_0x0300:
            java.lang.String r12 = r11.f5839N
            boolean r12 = android.text.TextUtils.isEmpty(r12)
            r12 = r12 ^ r1
            int r2 = r11.f5861z
            int r4 = r2 + -1
            if (r4 == 0) goto L_0x0326
            if (r4 == r1) goto L_0x0326
            if (r4 == r7) goto L_0x0323
            if (r4 == r8) goto L_0x0320
            if (r4 == r10) goto L_0x0320
            if (r4 != r0) goto L_0x0318
            goto L_0x0323
        L_0x0318:
            java.lang.AssertionError r12 = new java.lang.AssertionError
            java.lang.String r0 = "Impossible saved state"
            r12.<init>(r0)
            throw r12
        L_0x0320:
            int r2 = p000.C0027ay.f2383E
            goto L_0x0327
        L_0x0323:
            int r2 = p000.C0027ay.f2382D
            goto L_0x0327
        L_0x0326:
        L_0x0327:
            r11.m7467c(r2)
            com.android.calculator2.display.CalculatorResult r0 = r11.mo4781k()
            if (r12 == 0) goto L_0x0331
            r7 = 3
        L_0x0331:
            r0.mo4841a(r7, r11)
        L_0x0334:
            com.android.calculator2.display.CalculatorFormula r12 = r11.f5846j
            r12.requestFocus()
            aex r12 = p000.aex.m325a(r11)
            r11.f5842Q = r12
            r12 = -1
            android.content.pm.PackageManager r0 = r11.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0350 }
            java.lang.String r2 = r11.getPackageName()     // Catch:{ NameNotFoundException -> 0x0350 }
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r2, r3)     // Catch:{ NameNotFoundException -> 0x0350 }
            int r0 = r0.versionCode     // Catch:{ NameNotFoundException -> 0x0350 }
            goto L_0x0359
        L_0x0350:
            r0 = move-exception
            java.lang.String r2 = "Calculator"
            java.lang.String r4 = "PackageManager could not find our own package"
            android.util.Log.e(r2, r4, r0)
            r0 = -1
        L_0x0359:
            android.content.SharedPreferences r2 = android.preference.PreferenceManager.getDefaultSharedPreferences(r11)
            java.lang.String r4 = "last_app_version"
            int r5 = r2.getInt(r4, r12)
            r6 = 2131624162(0x7f0e00e2, float:1.8875496E38)
            android.view.View r6 = r11.findViewById(r6)
            com.android.calculator2.display.CalculatorSlidingPadLayout r6 = (com.android.calculator2.display.CalculatorSlidingPadLayout) r6
            r11.f5851o = r6
            com.android.calculator2.display.CalculatorSlidingPadLayout r6 = r11.f5851o
            if (r6 == 0) goto L_0x03e0
            r7 = 2131624249(0x7f0e0139, float:1.8875672E38)
            android.view.View r7 = r11.findViewById(r7)
            com.android.calculator2.display.ArrowIndicator r7 = (com.android.calculator2.display.ArrowIndicator) r7
            r6.f5926k = r7
            com.android.calculator2.display.ArrowIndicator r7 = r6.f5926k
            if (r7 == 0) goto L_0x038b
            com.android.calculator2.display.ArrowIndicator r7 = r6.f5926k
            ags r8 = new ags
            r8.<init>(r6)
            r7.setOnClickListener(r8)
        L_0x038b:
            com.android.calculator2.display.CalculatorSlidingPadLayout r6 = r11.f5851o
            r7 = 2131493156(0x7f0c0124, float:1.8609784E38)
            int r7 = r11.getColor(r7)
            r6.mo22a(r7)
            android.graphics.Point r6 = new android.graphics.Point
            r6.<init>()
            android.view.WindowManager r7 = r11.getWindowManager()
            android.view.Display r7 = r7.getDefaultDisplay()
            r7.getSize(r6)
            com.android.calculator2.display.CalculatorSlidingPadLayout r7 = r11.f5851o
            int r6 = r6.x
            float r6 = (float) r6
            r8 = 1048576000(0x3e800000, float:0.25)
            float r6 = r6 * r8
            int r6 = (int) r6
            android.view.View r1 = r7.getChildAt(r1)
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            android.view.ViewGroup$MarginLayoutParams r1 = (android.view.ViewGroup.MarginLayoutParams) r1
            r1.setMargins(r6, r3, r3, r3)
            if (r5 != r12) goto L_0x03d6
            com.android.calculator2.display.CalculatorSlidingPadLayout r12 = r11.f5851o
            r12.mo28b(r3)
            android.os.Handler r12 = r11.f5844h
            afj r1 = new afj
            r1.<init>(r11)
            r11.f5857u = r1
            r6 = 1500(0x5dc, double:7.41E-321)
            r12.postDelayed(r1, r6)
            goto L_0x03e3
        L_0x03d6:
            com.android.calculator2.display.CalculatorSlidingPadLayout r12 = r11.f5851o
            r12.mo27b()
            r11.m7454a(r2)
            goto L_0x03e3
        L_0x03e0:
            r11.m7454a(r2)
        L_0x03e3:
            if (r5 == r0) goto L_0x03f0
            android.content.SharedPreferences$Editor r12 = r2.edit()
            android.content.SharedPreferences$Editor r12 = r12.putInt(r4, r0)
            r12.apply()
        L_0x03f0:
            android.view.View r12 = r11.f5852p
            android.view.ViewTreeObserver r12 = r12.getViewTreeObserver()
            afi r0 = new afi
            r0.<init>(r11, r12)
            r12.addOnPreDrawListener(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.calculator2.Calculator.onCreate(android.os.Bundle):void");
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        int i;
        super.onResume();
        m7455a((Pair) f5824f.get(Integer.valueOf(PreferenceManager.getDefaultSharedPreferences(this).getInt("last_dark_mode", 2))));
        if (!mo4782l()) {
            m7437L();
            this.f5846j.mo4832a(this.f5854r);
        }
        View view = this.f5852p;
        if (this.f5850n.f5872k) {
            i = 4;
        } else {
            i = 0;
        }
        view.setImportantForAccessibility(i);
        CalculatorSlidingPadLayout calculatorSlidingPadLayout = this.f5851o;
        if (calculatorSlidingPadLayout != null) {
            calculatorSlidingPadLayout.mo4857a(this.f5850n.f5872k);
        }
    }

    /* renamed from: k */
    public final CalculatorResult mo4781k() {
        return this.f5856t ? this.f5847k : this.f5848l;
    }

    /* renamed from: a */
    public static void m7456a(View view, int i) {
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), Math.max(view.getPaddingBottom(), i));
    }

    /* renamed from: a */
    private final void m7454a(SharedPreferences sharedPreferences) {
        if (!sharedPreferences.getBoolean("dark_tooltip_shown", false)) {
            Handler handler = this.f5844h;
            afk afk = new afk(this, sharedPreferences);
            this.f5857u = afk;
            handler.postDelayed(afk, 500);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0068, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSaveInstanceState(android.os.Bundle r4) {
        /*
            r3 = this;
            ahe r0 = r3.f5826A
            r1 = 1
            r0.mo556a(r1)
            android.animation.Animator r0 = r3.f5853q
            if (r0 == 0) goto L_0x000d
            r0.cancel()
        L_0x000d:
            super.onSaveInstanceState(r4)
            int r0 = r3.f5861z
            int r0 = r0 - r1
            java.lang.String r1 = "Calculator_display_state"
            r4.putInt(r1, r0)
            java.lang.String r0 = r3.f5839N
            java.lang.String r1 = "Calculator_unprocessed_chars"
            r4.putCharSequence(r1, r0)
            int r0 = r3.f5840O
            java.lang.String r1 = "Calculator_unprocessed_chars_loc"
            r4.putInt(r1, r0)
            int r0 = r3.m7445T()
            java.lang.String r1 = "Calculator_cursor_position_start"
            r4.putInt(r1, r0)
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            java.io.ObjectOutputStream r1 = new java.io.ObjectOutputStream     // Catch:{ IOException -> 0x0069 }
            r1.<init>(r0)     // Catch:{ IOException -> 0x0069 }
            ahe r2 = r3.f5826A     // Catch:{ all -> 0x005d }
            r2.mo555a(r1)     // Catch:{ all -> 0x005d }
            r1.close()     // Catch:{ IOException -> 0x0069 }
            byte[] r0 = r0.toByteArray()
            java.lang.String r1 = "Calculator_eval_state"
            r4.putByteArray(r1, r0)
            android.widget.TextView r0 = r3.f5834I
            boolean r0 = r0.isSelected()
            java.lang.String r1 = "Calculator_inverse_mode"
            r4.putBoolean(r1, r0)
            ahe r4 = r3.f5826A
            r4.mo602r()
            return
        L_0x005d:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x005f }
        L_0x005f:
            r0 = move-exception
            r1.close()     // Catch:{ all -> 0x0064 }
            goto L_0x0068
        L_0x0064:
            r1 = move-exception
            p000.byt.m4756a(r4, r1)     // Catch:{ IOException -> 0x0069 }
        L_0x0068:
            throw r0     // Catch:{ IOException -> 0x0069 }
        L_0x0069:
            r4 = move-exception
            java.lang.AssertionError r0 = new java.lang.AssertionError
            java.lang.String r1 = "Impossible IO exception"
            r0.<init>(r1, r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.calculator2.Calculator.onSaveInstanceState(android.os.Bundle):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public final void m7467c(int i) {
        if (this.f5861z != i) {
            this.f5861z = i;
            if (this.f5861z == C0027ay.f2380B) {
                mo4781k().mo4841a(0, (ahq) null);
                String str = "";
                this.f5847k.setText(str);
                if (!this.f5856t) {
                    this.f5848l.setText(str);
                    this.f5848l.setVisibility(0);
                    this.f5847k.setScaleX(1.0f);
                    this.f5847k.setScaleY(1.0f);
                    this.f5847k.setTranslationY(0.0f);
                    this.f5847k.setVisibility(4);
                    this.f5849m.setVisibility(0);
                }
                mo4781k().setScaleX(1.0f);
                mo4781k().setScaleY(1.0f);
                mo4781k().setTranslationY(0.0f);
                this.f5849m.setTranslationY(0.0f);
                this.f5846j.requestFocus();
                if (!this.f5856t) {
                    this.f5828C.setText(str);
                    this.f5828C.setVisibility(8);
                }
            }
            if (this.f5861z == C0027ay.f2385G) {
                this.f5831F.setVisibility(4);
                this.f5832G.setVisibility(0);
            } else {
                this.f5831F.setVisibility(0);
                this.f5832G.setVisibility(4);
            }
            if (this.f5856t) {
                if (this.f5861z == C0027ay.f2385G || this.f5861z == C0027ay.f2381C || this.f5861z == C0027ay.f2384F) {
                    this.f5846j.setVisibility(0);
                    this.f5847k.setVisibility(0);
                } else if (this.f5861z == C0027ay.f2386H) {
                    this.f5846j.setVisibility(4);
                    this.f5847k.setVisibility(0);
                } else {
                    this.f5846j.setVisibility(0);
                    this.f5847k.setVisibility(4);
                }
            }
            if (this.f5861z == C0027ay.f2386H) {
                int b = C0220ia.m8142b(this, R.color.calculator_error_text_color);
                this.f5846j.setTextColor(b);
                if (!this.f5856t) {
                    this.f5848l.setTextColor(b);
                }
                this.f5847k.setTextColor(b);
            } else if (this.f5861z != C0027ay.f2385G) {
                this.f5846j.setTextColor(C0220ia.m8142b(this, R.color.formula_text_color));
                if (!this.f5856t) {
                    this.f5848l.setTextColor(C0220ia.m8142b(this, R.color.result_text_color));
                }
                this.f5847k.setTextColor(C0220ia.m8142b(this, R.color.formula_text_color));
            }
            invalidateOptionsMenu();
        }
    }

    /* renamed from: l */
    public final boolean mo4782l() {
        return this.f5861z == C0027ay.f2383E || this.f5861z == C0027ay.f2385G;
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        this.f5854r = m7445T();
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.f5850n.mo4809b(this);
        ViewTreeObserver viewTreeObserver = this.f5849m.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnPreDrawListener(this.f5843g);
            OnPreDrawListener onPreDrawListener = this.f5858w;
            if (onPreDrawListener != null) {
                viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
            }
        }
        if (isFinishing()) {
            this.f5826A.mo605s();
        }
        super.onDestroy();
    }

    /* renamed from: d */
    private final void m7469d(int i) {
        ArrayList arrayList = (ArrayList) this.f5826A.mo542a(i, false);
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            int intValue = ((Integer) arrayList.get(size)).intValue() + i;
            int i2 = this.f5854r;
            if (intValue < i2) {
                this.f5854r = i2 - 1;
            }
        }
    }

    /* renamed from: a */
    public final boolean mo4778a(String str) {
        if (m7440O()) {
            if (m7438M()) {
                m7458a((CharSequence) str);
                return true;
            }
            int i = this.f5854r;
            if (i > this.f5840O) {
                this.f5854r = i - this.f5839N.length();
            }
            this.f5839N = "";
            m7469d(this.f5840O);
            m7437L();
        }
        return false;
    }

    /* renamed from: F */
    private final boolean m7431F() {
        return this.f5847k.mo4847i() || this.f5846j.mo481d() || (!this.f5856t && this.f5848l.mo4847i());
    }

    /* renamed from: G */
    private final boolean m7432G() {
        aiy aa = m7460aa();
        return this.f5850n.f5872k && aa != null && aa.mo698O();
    }

    public void onUserInteraction() {
        super.onUserInteraction();
        Animator animator = this.f5853q;
        if (animator != null) {
            animator.end();
        }
        Runnable runnable = this.f5857u;
        if (runnable != null) {
            this.f5844h.removeCallbacks(runnable);
            this.f5857u = null;
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        int i = keyEvent.getKeyCharacterMap().get(keyCode, keyEvent.getMetaState());
        int action = keyEvent.getAction();
        if (this.f5850n.f5872k && !keyEvent.isCtrlPressed()) {
            Window window = getWindow();
            if (window == null) {
                return super.dispatchKeyEvent(keyEvent);
            }
            View decorView = window.getDecorView();
            return keyEvent.dispatch(this, decorView != null ? decorView.getKeyDispatcherState() : null, this);
        } else if (keyEvent.isCtrlPressed()) {
            if (action == 1) {
                if (keyCode != 50 || this.f5850n.f5872k) {
                    View currentFocus = getCurrentFocus();
                    if (!(currentFocus instanceof afr)) {
                        return true;
                    }
                    afr afr = (afr) currentFocus;
                    if (this.f5850n.f5872k && (afr == this.f5846j || afr == this.f5847k || (!this.f5856t && afr == this.f5848l))) {
                        return true;
                    }
                    if (keyCode == 31) {
                        afr.mo404b();
                    } else if (keyCode == 52) {
                        afr.mo403a();
                    }
                    m7431F();
                    m7432G();
                } else {
                    ClipboardManager clipboardManager = (ClipboardManager) getSystemService("clipboard");
                    if (clipboardManager != null) {
                        ClipData primaryClip = clipboardManager.getPrimaryClip();
                        if (primaryClip != null) {
                            mo449a(primaryClip);
                            this.f5846j.requestFocus();
                        }
                    }
                    m7431F();
                    return true;
                }
            }
            return true;
        } else if (action == 1) {
            this.f5854r = m7445T();
            m7439N();
            m7431F();
            if (keyCode != 23) {
                if (keyCode != 28) {
                    if (!(keyCode == 61 || keyCode == 112)) {
                        if (!(keyCode == 160 || keyCode == 66)) {
                            if (keyCode != 67) {
                                mo4784n();
                                if ((Integer.MIN_VALUE & i) != 0) {
                                    return true;
                                }
                                if (Character.isIdentifierIgnorable(i)) {
                                    return super.dispatchKeyEvent(keyEvent);
                                }
                                char c = (char) i;
                                if (c == '=') {
                                    this.f5838M = this.f5833H;
                                    m7441P();
                                    return true;
                                } else if (mo4778a(String.valueOf(c))) {
                                    return true;
                                } else {
                                    this.f5854r = m7445T();
                                    this.f5840O = this.f5854r;
                                    m7459a(String.valueOf(c), true);
                                    mo4783m();
                                    return true;
                                }
                            }
                        }
                    }
                    return true;
                }
                this.f5838M = this.f5832G;
                m7449X();
                return true;
            }
            if (!this.f5845i.hasFocus()) {
                return super.dispatchKeyEvent(keyEvent);
            }
            this.f5838M = this.f5833H;
            m7441P();
            return true;
        } else {
            if (action == 0) {
                m7439N();
                this.f5854r = m7445T();
                if (keyCode == 28) {
                    return true;
                }
                if (keyCode == 61) {
                    return super.dispatchKeyEvent(keyEvent);
                }
                if (keyCode != 70) {
                    if (keyCode != 112) {
                        if (keyCode != 66) {
                            if (keyCode == 67) {
                                if (this.f5861z == C0027ay.f2385G) {
                                    this.f5838M = this.f5832G;
                                    m7449X();
                                    return true;
                                }
                                this.f5838M = this.f5831F;
                                m7471e(true);
                                return true;
                            }
                        } else if (!this.f5845i.hasFocus()) {
                            return super.dispatchKeyEvent(keyEvent);
                        } else {
                            return true;
                        }
                    } else if (this.f5861z == C0027ay.f2385G) {
                        this.f5838M = this.f5832G;
                        m7449X();
                        return true;
                    } else {
                        if (!this.f5846j.hasSelection() && this.f5854r < this.f5846j.length()) {
                            CalculatorFormula calculatorFormula = this.f5846j;
                            int i2 = this.f5854r;
                            calculatorFormula.mo4833a(i2, i2 + 1);
                            m7471e(true);
                        }
                        return true;
                    }
                } else if (!keyEvent.isShiftPressed()) {
                    return true;
                }
                if (Character.isIdentifierIgnorable(i)) {
                    return super.dispatchKeyEvent(keyEvent);
                }
                if (this.f5846j.hasSelection()) {
                    m7471e(false);
                }
                this.f5845i.requestFocus();
            }
            return true;
        }
    }

    public void onBackPressed() {
        if (!m7431F()) {
            aiy aa = m7460aa();
            if (!this.f5850n.f5872k || aa == null) {
                CalculatorSlidingPadLayout calculatorSlidingPadLayout = this.f5851o;
                if (calculatorSlidingPadLayout == null || !calculatorSlidingPadLayout.mo4858e()) {
                    super.onBackPressed();
                } else {
                    this.f5851o.mo27b();
                }
            } else {
                if (!aa.mo698O()) {
                    this.f5850n.mo4807a();
                    m7433H();
                }
            }
        }
    }

    /* renamed from: c */
    private final void m7468c(boolean z) {
        this.f5834I.setSelected(z);
        if (z) {
            this.f5834I.setContentDescription(getString(R.string.desc_inv_on));
            for (View visibility : this.f5836K) {
                visibility.setVisibility(8);
            }
            for (View visibility2 : this.f5837L) {
                visibility2.setVisibility(0);
            }
            return;
        }
        this.f5834I.setContentDescription(getString(R.string.desc_inv_off));
        for (View visibility3 : this.f5836K) {
            visibility3.setVisibility(0);
        }
        for (View visibility4 : this.f5837L) {
            visibility4.setVisibility(8);
        }
    }

    /* renamed from: d */
    private final void m7470d(boolean z) {
        if (z) {
            this.f5827B.setText(R.string.mode_deg);
            this.f5827B.setContentDescription(getString(R.string.desc_mode_deg));
            this.f5835J.setText(R.string.mode_rad);
            this.f5835J.setContentDescription(getString(R.string.desc_switch_rad));
            return;
        }
        this.f5827B.setText(R.string.mode_rad);
        this.f5827B.setContentDescription(getString(R.string.desc_mode_rad));
        this.f5835J.setText(R.string.mode_deg);
        this.f5835J.setContentDescription(getString(R.string.desc_switch_deg));
    }

    /* renamed from: H */
    private final void m7433H() {
        C0164fz e = mo5238e();
        if (e != null) {
            try {
                if (!e.mo5296e()) {
                    aiy aa = m7460aa();
                    if (aa != null) {
                        aji aji = new aji(this);
                        aa.f671aa = aji;
                        if (aa.f670a == null || !aa.f670a.canScrollVertically(1)) {
                            aji.mo713a(aa.f673ac, aa.f674ad);
                        } else {
                            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) aa.f670a.getLayoutManager();
                            if (linearLayoutManager == null || linearLayoutManager.mo1230g() != 0) {
                                aa.f670a.addOnScrollListener(new aja(aa, aji));
                                aa.f670a.scrollToPosition(0);
                            } else {
                                linearLayoutManager.f1204b = 0;
                                linearLayoutManager.f1205c = 0;
                                if (linearLayoutManager.f1206d != null) {
                                    linearLayoutManager.f1206d.f8140a = -1;
                                }
                                linearLayoutManager.mo6869i();
                                aji.mo713a(aa.f673ac, aa.f674ad);
                            }
                        }
                    }
                }
            } catch (IllegalStateException e2) {
                Log.e("Calculator", "Error removing history fragment:", e2);
                return;
            }
        }
        this.f5846j.setCursorVisible(true);
        this.f5846j.requestFocus();
        this.f5852p.setImportantForAccessibility(0);
        m7474f(getResources().getBoolean(R.bool.theme_light));
    }

    /* renamed from: e */
    private static boolean m7472e(int i) {
        return agd.m399b(i) || agd.m401d(i);
    }

    /* renamed from: a */
    public final void mo4776a(boolean z) {
        m7430E();
        if (z) {
            this.f5826A.mo572d(this.f5826A.mo558b(), true);
        } else {
            m7448W();
            this.f5826A.mo579f();
        }
        m7467c(C0027ay.f2380B);
        m7437L();
        mo4779b(this.f5846j.length());
    }

    /* renamed from: b */
    public static void m7465b(String str) {
        Log.e("Calculator", str);
    }

    /* renamed from: I */
    private final void m7434I() {
        int i = this.f5826A.mo584i() + this.f5839N.length();
        int i2 = this.f5854r;
        if (i2 < 0 || i2 > i) {
            int i3 = this.f5854r;
            StringBuilder sb = new StringBuilder(60);
            sb.append("cursorPosition ");
            sb.append(i3);
            sb.append(" outside of range [0, ");
            sb.append(i);
            sb.append("]");
            Log.e("Calculator", sb.toString());
            if (this.f5854r < 0) {
                this.f5854r = 0;
                return;
            }
            this.f5854r = i;
        }
    }

    /* renamed from: b */
    public final void mo4779b(int i) {
        this.f5854r = i;
        m7434I();
    }

    /* renamed from: f */
    private final int m7473f(int i) {
        if (m7440O()) {
            Log.e("Calculator", "Unprocessed characters while inserting");
        }
        if (this.f5861z == C0027ay.f2386H) {
            m7467c(C0027ay.f2380B);
        } else if (this.f5861z == C0027ay.f2385G) {
            mo4776a(m7472e(i));
        }
        m7434I();
        int a = this.f5826A.mo532a(this.f5854r, i);
        if (a != -1) {
            this.f5854r += a;
            this.f5840O = this.f5854r;
        }
        return a;
    }

    /* renamed from: J */
    private final void m7435J() {
        if (this.f5861z == C0027ay.f2380B && this.f5826A.mo537a(0).mo510c()) {
            this.f5826A.mo547a(0, (ahq) this, (aho) mo4781k());
        }
    }

    /* renamed from: m */
    public final void mo4783m() {
        m7437L();
        m7467c(C0027ay.f2380B);
        this.f5847k.mo4845g();
        if (!this.f5856t) {
            this.f5848l.mo4845g();
        }
        if (m7440O()) {
            this.f5826A.mo590l();
        } else {
            m7435J();
        }
    }

    /* renamed from: a */
    private final void m7458a(CharSequence charSequence) {
        StringBuilder sb = new StringBuilder(this.f5839N);
        sb.insert(this.f5854r - this.f5840O, charSequence);
        this.f5839N = sb.toString();
        m7436K();
    }

    /* renamed from: K */
    private final void m7436K() {
        if (!TextUtils.isEmpty(this.f5839N)) {
            String str = this.f5839N;
            this.f5839N = "";
            mo4779b(this.f5840O);
            m7437L();
            m7459a(str, false);
        }
    }

    public void onButtonClick(View view) {
        this.f5842Q.mo377a("pad", "click", view.getId());
        this.f5838M = view;
        m7439N();
        if (!this.f5846j.hasSelection()) {
            m7431F();
        }
        int id = view.getId();
        mo4779b(m7445T());
        if (id == R.id.eq) {
            m7441P();
        } else if (id == R.id.del) {
            m7471e(true);
        } else if (id == R.id.clr) {
            m7449X();
        } else if (id == R.id.toggle_inv) {
            boolean z = !this.f5834I.isSelected();
            this.f5834I.setSelected(z);
            m7468c(z);
            if (this.f5861z == C0027ay.f2385G) {
                this.f5847k.mo4846h();
                if (!this.f5856t) {
                    this.f5848l.mo4846h();
                }
            }
        } else if (id == R.id.toggle_mode || id == R.id.mode) {
            mo4784n();
            boolean z2 = !this.f5826A.mo565b(0);
            if (this.f5861z == C0027ay.f2385G && this.f5826A.mo537a(0).mo512d()) {
                m7430E();
                ahe ahe = this.f5826A;
                ahe.mo572d(ahe.mo558b(), false);
                m7437L();
            }
            this.f5826A.mo564b(z2);
            m7470d(z2);
            if (this.f5861z == C0027ay.f2385G) {
                mo4802s();
            } else {
                m7467c(C0027ay.f2380B);
                this.f5847k.mo4845g();
                if (!this.f5856t) {
                    this.f5848l.mo4845g();
                }
            }
            if (!m7440O()) {
                m7435J();
            }
        } else {
            mo4784n();
            m7442Q();
            mo4779b(m7445T());
            if (m7440O()) {
                if (m7438M()) {
                    m7458a((CharSequence) agd.m395a((Context) this, id));
                    mo4783m();
                    return;
                }
                int i = this.f5854r;
                if (i > this.f5840O) {
                    this.f5854r = i - this.f5839N.length();
                }
                this.f5839N = "";
            }
            if (m7473f(id) != -1) {
                this.f5839N = (String) this.f5826A.mo542a(this.f5854r, true);
                this.f5840O = this.f5854r - this.f5839N.length();
            }
            mo4783m();
        }
    }

    /* renamed from: L */
    private final void m7437L() {
        SpannableStringBuilder a = this.f5826A.mo537a(0).mo501a((Context) this);
        if (m7440O()) {
            a.insert(this.f5840O, this.f5839N);
            ForegroundColorSpan foregroundColorSpan = this.f5841P;
            int i = this.f5840O;
            a.setSpan(foregroundColorSpan, i, this.f5839N.length() + i, 33);
        }
        if (a.length() != this.f5826A.mo584i() + this.f5839N.length()) {
            int length = a.length();
            int i2 = this.f5826A.mo584i();
            int length2 = this.f5839N.length();
            StringBuilder sb = new StringBuilder(C0409pa.f7288ay);
            sb.append("Formula length ");
            sb.append(length);
            sb.append(" differs from internal expression length = ");
            sb.append(i2);
            sb.append(" + unprocessedChars.length() = ");
            sb.append(length2);
            Log.e("Calculator", sb.toString());
        }
        CalculatorFormula calculatorFormula = this.f5846j;
        CharSequence a2 = C0499sj.m9321a((CharSequence) a, (CharSequence) (Editable) calculatorFormula.getText());
        if (a2 != null) {
            calculatorFormula.announceForAccessibility(a2);
        } else {
            calculatorFormula.announceForAccessibility(a);
        }
        calculatorFormula.setText(a, BufferType.SPANNABLE);
        this.f5846j.setContentDescription(TextUtils.isEmpty(a) ? getString(R.string.desc_formula) : null);
        this.f5846j.f5887f = !m7440O();
    }

    public boolean onLongClick(View view) {
        this.f5838M = view;
        if (view.getId() != R.id.del) {
            return false;
        }
        m7449X();
        this.f5842Q.mo377a("pad", "long_click", view.getId());
        return true;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 82) {
            aiy aa = m7460aa();
            if (aa != null) {
                return aa.f668Y.mo1444b();
            }
        }
        return super.onKeyUp(i, keyEvent);
    }

    /* renamed from: a */
    public final void mo626a(long j, int i, int i2, int i3, String str) {
        float f;
        if (j == 0) {
            invalidateOptionsMenu();
            mo4781k().mo626a(j, i, i2, i3, str);
            if (this.f5861z != C0027ay.f2380B) {
                boolean z = this.f5861z == C0027ay.f2381C;
                boolean z2 = this.f5861z == C0027ay.f2383E || this.f5861z == C0027ay.f2385G;
                m7431F();
                mo4802s();
                if (!mo4781k().f5906i) {
                    f = this.f5846j.mo4831a(mo4781k().mo4839a(true));
                } else {
                    f = this.f5846j.f5883b;
                }
                float textSize = f / mo4781k().getTextSize();
                CalculatorResult calculatorResult = this.f5847k;
                calculatorResult.setPivotX((float) (calculatorResult.getWidth() - this.f5847k.getPaddingRight()));
                CalculatorResult calculatorResult2 = this.f5847k;
                calculatorResult2.setPivotY((float) (calculatorResult2.getHeight() - this.f5847k.getPaddingBottom()));
                if (!this.f5856t) {
                    CalculatorResult calculatorResult3 = this.f5848l;
                    calculatorResult3.setPivotX((float) (calculatorResult3.getWidth() - this.f5848l.getPaddingRight()));
                    CalculatorResult calculatorResult4 = this.f5848l;
                    calculatorResult4.setPivotY((float) (calculatorResult4.getHeight() - this.f5848l.getPaddingBottom()));
                }
                float bottom = (float) ((this.f5829D.getBottom() - (this.f5856t ? mo4781k().getBottom() : this.f5830E.getBottom())) - (this.f5846j.getPaddingBottom() - mo4781k().getPaddingBottom()));
                float f2 = (float) (-this.f5829D.getBottom());
                if (this.f5856t) {
                    CalculatorResult calculatorResult5 = this.f5847k;
                    calculatorResult5.setY((float) calculatorResult5.getBottom());
                    f2 = (float) (-(findViewById(R.id.toolbar).getBottom() + this.f5829D.getBottom()));
                } else {
                    this.f5847k.setTranslationY((float) (((this.f5849m.getBottom() - this.f5847k.getBottom()) - this.f5846j.getPaddingBottom()) + this.f5847k.getPaddingBottom()));
                }
                int currentTextColor = this.f5846j.getCurrentTextColor();
                if (z2) {
                    this.f5826A.mo586j();
                } else {
                    this.f5826A.mo567c(0, true);
                }
                if (z) {
                    mo4781k().announceForAccessibility(getResources().getString(R.string.desc_eq));
                    mo4781k().announceForAccessibility((Editable) mo4781k().getText());
                    BackgroundColorSpan backgroundColorSpan = new BackgroundColorSpan(getColor(R.color.display_background_color));
                    ((Editable) mo4781k().getText()).setSpan(backgroundColorSpan, 0, mo4781k().length(), 18);
                    m7467c(C0027ay.f2384F);
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.playTogether(new Animator[]{ObjectAnimator.ofPropertyValuesHolder(mo4781k(), new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{textSize}), PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{textSize}), PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{bottom})}), ObjectAnimator.ofArgb(mo4781k(), f5825v, new int[]{currentTextColor}), ObjectAnimator.ofFloat(this.f5849m, View.TRANSLATION_Y, new float[]{f2})});
                    animatorSet.setDuration((long) getResources().getInteger(17694720));
                    animatorSet.addListener(new aff(this, backgroundColorSpan, textSize, currentTextColor));
                    this.f5853q = animatorSet;
                    animatorSet.start();
                } else {
                    mo4781k().setScaleX(textSize);
                    mo4781k().setScaleY(textSize);
                    mo4781k().setTranslationY(bottom);
                    mo4781k().setTextColor(currentTextColor);
                    this.f5849m.setTranslationY(f2);
                    m7467c(C0027ay.f2385G);
                    mo4802s();
                    if (!this.f5856t) {
                        this.f5847k.setScaleX(textSize);
                        this.f5847k.setScaleY(textSize);
                        this.f5847k.setTextColor(currentTextColor);
                        this.f5847k.setVisibility(0);
                        this.f5848l.setVisibility(4);
                        this.f5849m.setVisibility(4);
                    }
                }
                this.f5854r = 0;
                return;
            }
            return;
        }
        throw new AssertionError("Unexpected evaluation result index\n");
    }

    /* renamed from: a */
    public final void mo624a(long j) {
        m7467c(C0027ay.f2380B);
        mo4781k().mo624a(j);
    }

    /* renamed from: b */
    public final void mo627b(long j) {
        mo4781k().mo627b(j);
    }

    /* renamed from: a */
    public final void mo455a(TextView textView, float f) {
        if (this.f5861z == C0027ay.f2380B) {
            float textSize = f / textView.getTextSize();
            float f2 = 1.0f - textSize;
            float width = ((((float) textView.getWidth()) / 2.0f) - ((float) textView.getPaddingEnd())) * f2;
            float height = f2 * ((((float) textView.getHeight()) / 2.0f) - ((float) textView.getPaddingBottom()));
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(new Animator[]{ObjectAnimator.ofFloat(textView, View.SCALE_X, new float[]{textSize, 1.0f}), ObjectAnimator.ofFloat(textView, View.SCALE_Y, new float[]{textSize, 1.0f}), ObjectAnimator.ofFloat(textView, View.TRANSLATION_X, new float[]{width, 0.0f}), ObjectAnimator.ofFloat(textView, View.TRANSLATION_Y, new float[]{height, 0.0f})});
            animatorSet.setDuration((long) getResources().getInteger(17694720));
            animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
            animatorSet.start();
        }
    }

    /* renamed from: n */
    public final void mo4784n() {
        this.f5826A.mo550a(0, true);
    }

    /* renamed from: M */
    private final boolean m7438M() {
        if (m7440O()) {
            int i = this.f5854r;
            int i2 = this.f5840O;
            if (i >= i2 && i <= i2 + this.f5839N.length()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: N */
    private final void m7439N() {
        if (this.f5861z == C0027ay.f2380B) {
            this.f5826A.mo550a(0, true);
        }
    }

    /* renamed from: O */
    private final boolean m7440O() {
        return !this.f5839N.isEmpty();
    }

    /* renamed from: P */
    private final void m7441P() {
        if (this.f5861z == C0027ay.f2380B) {
            if (m7440O()) {
                m7467c(C0027ay.f2381C);
                mo625a(0, (int) R.string.error_syntax);
            } else if (this.f5826A.mo537a(0).mo510c()) {
                m7467c(C0027ay.f2381C);
                this.f5826A.mo563b(0, (ahq) this, (aho) mo4781k());
            }
        }
    }

    /* renamed from: Q */
    private final void m7442Q() {
        if (this.f5846j.hasSelection()) {
            m7447V();
        }
    }

    /* renamed from: o */
    public final boolean mo4785o() {
        return m7440O() && m7445T() < this.f5840O + this.f5839N.length() && m7446U() > this.f5840O;
    }

    /* renamed from: R */
    private final int m7443R() {
        int i = this.f5826A.mo584i();
        this.f5846j.mo4832a(i);
        return i;
    }

    /* renamed from: S */
    private final void m7444S() {
        this.f5858w = new afb(this, this.f5846j.getWidth() - this.f5849m.getScrollX());
        this.f5849m.getViewTreeObserver().addOnPreDrawListener(this.f5858w);
    }

    /* renamed from: T */
    private final int m7445T() {
        int selectionStart = this.f5846j.getSelectionStart();
        if (selectionStart == -1) {
            return m7443R();
        }
        return selectionStart;
    }

    /* renamed from: U */
    private final int m7446U() {
        int selectionEnd = this.f5846j.getSelectionEnd();
        if (selectionEnd == -1) {
            return m7443R();
        }
        return selectionEnd;
    }

    /* renamed from: p */
    public final int mo4799p() {
        int T = m7445T();
        if (!m7440O() || T <= this.f5840O) {
            return T;
        }
        return T - this.f5839N.length();
    }

    /* renamed from: q */
    public final int mo4800q() {
        int U = m7446U();
        if (m7440O()) {
            int length = this.f5839N.length();
            if (U > this.f5840O + length) {
                return U - length;
            }
        }
        return U;
    }

    /* renamed from: V */
    private final void m7447V() {
        while (true) {
            boolean z = this.f5861z == C0027ay.f2381C;
            this.f5826A.mo550a(0, !z);
            m7467c(C0027ay.f2380B);
            if (!z) {
                int T = m7445T();
                int U = m7446U();
                if (!this.f5846j.hasSelection()) {
                    int i = this.f5854r;
                    if (i > 0) {
                        this.f5846j.mo4833a(i - 1, i);
                    } else {
                        return;
                    }
                } else if (!m7440O()) {
                    this.f5839N = this.f5826A.mo562b(T, U);
                    mo4779b(T);
                    if (m7440O()) {
                        this.f5840O = Math.max(0, T - this.f5839N.length());
                        return;
                    } else {
                        this.f5840O = this.f5854r;
                        return;
                    }
                } else if (!mo4785o()) {
                    mo4779b(mo4799p());
                    this.f5846j.mo4833a(this.f5854r, mo4800q());
                    this.f5839N = "";
                    m7469d(this.f5840O);
                    m7447V();
                    return;
                } else {
                    int length = this.f5839N.length();
                    int max = Math.max(T - this.f5840O, 0);
                    int min = Math.min(U - this.f5840O, length);
                    String valueOf = String.valueOf(this.f5839N.substring(0, max));
                    String valueOf2 = String.valueOf(this.f5839N.substring(min, length));
                    this.f5839N = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
                    mo4779b(Math.max(T, 0));
                    int min2 = Math.min(T, this.f5840O);
                    int i2 = this.f5840O;
                    if (U > i2 + length) {
                        i2 = U - length;
                    }
                    if (min2 != i2) {
                        String b = this.f5826A.mo562b(min2, i2);
                        this.f5840O = Math.min(this.f5840O, min2);
                        if (!TextUtils.isEmpty(b)) {
                            String valueOf3 = String.valueOf(b);
                            String valueOf4 = String.valueOf(this.f5839N);
                            this.f5839N = valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3);
                            this.f5840O = Math.min(this.f5840O, min2);
                        }
                    }
                    return;
                }
            } else {
                return;
            }
        }
    }

    /* renamed from: e */
    private final void m7471e(boolean z) {
        m7447V();
        if (this.f5826A.mo537a(0).f490b.isEmpty() && !m7440O()) {
            m7448W();
        }
        if (z) {
            m7436K();
        }
        mo4783m();
    }

    /* renamed from: a */
    private final void m7457a(View view, int i, AnimatorListener animatorListener) {
        ViewGroupOverlay overlay = this.f5845i.getOverlay();
        Rect rect = new Rect();
        this.f5845i.getGlobalVisibleRect(rect);
        View view2 = new View(this);
        view2.setBottom(rect.bottom);
        view2.setRight(rect.right - rect.left);
        view2.setBackgroundColor(C0220ia.m8142b(this, i));
        overlay.add(view2);
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        iArr[0] = iArr[0] + (view.getWidth() / 2);
        iArr[1] = iArr[1] + (view.getHeight() / 2);
        int i2 = iArr[0] - rect.left;
        int i3 = iArr[1] - rect.top;
        double pow = Math.pow((double) (view2.getLeft() - i2), 2.0d);
        double pow2 = Math.pow((double) (view2.getRight() - i2), 2.0d);
        double pow3 = Math.pow((double) (view2.getTop() - i3), 2.0d);
        Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view2, i2, i3, 0.0f, (float) Math.max(Math.sqrt(pow + pow3), Math.sqrt(pow2 + pow3)));
        createCircularReveal.setDuration((long) getResources().getInteger(17694721));
        createCircularReveal.addListener(animatorListener);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, View.ALPHA, new float[]{0.0f});
        ofFloat.setDuration((long) getResources().getInteger(17694720));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(createCircularReveal).before(ofFloat);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.addListener(new afa(this, overlay, view2));
        this.f5853q = animatorSet;
        animatorSet.start();
    }

    /* renamed from: W */
    private final void m7448W() {
        this.f5847k.announceForAccessibility(getResources().getString(R.string.cleared));
    }

    /* renamed from: r */
    public final void mo4801r() {
        mo4784n();
        m7430E();
        this.f5847k.mo4845g();
        if (!this.f5856t) {
            this.f5848l.mo4845g();
        }
        this.f5826A.mo579f();
        m7467c(C0027ay.f2380B);
        m7437L();
        this.f5846j.setCursorVisible(true);
    }

    /* renamed from: X */
    private final void m7449X() {
        if (!this.f5826A.mo537a(0).f490b.isEmpty() || m7440O()) {
            mo4784n();
            m7448W();
            m7457a(this.f5838M, (int) R.color.calculator_clear_flood, (AnimatorListener) new afd(this));
        }
    }

    /* renamed from: a */
    public final void mo625a(long j, int i) {
        if (j != 0) {
            throw new AssertionError("Unexpected error source");
        } else if (this.f5861z == C0027ay.f2381C) {
            m7467c(C0027ay.f2384F);
            this.f5847k.announceForAccessibility(getResources().getString(i));
            m7457a(this.f5838M, (int) R.color.calculator_error_flood, (AnimatorListener) new afc(this, j, i));
        } else if (this.f5861z == C0027ay.f2382D || this.f5861z == C0027ay.f2383E || this.f5861z == C0027ay.f2386H) {
            m7467c(C0027ay.f2386H);
            mo4781k().mo625a(j, i);
        } else {
            this.f5847k.mo4845g();
            if (!this.f5856t) {
                this.f5848l.mo4845g();
            }
        }
    }

    /* renamed from: s */
    public final void mo4802s() {
        if (!this.f5856t) {
            String a = this.f5826A.mo543a(0, 200);
            if (!a.isEmpty() && !this.f5826A.mo581g(0) && this.f5828C.getPaint().measureText(a) >= ((float) ((this.f5830E.getWidth() - this.f5828C.getTotalPaddingLeft()) - this.f5828C.getTotalPaddingRight()))) {
                a = "";
            }
            this.f5828C.setText(a);
            this.f5828C.setVisibility(a.isEmpty() ? 8 : 0);
        }
    }

    /* renamed from: a */
    public final void mo378a(aev aev, int i) {
        String str = "clear";
        char c = 65535;
        if (i == -1 && str.equals(aev.f6393A)) {
            this.f5842Q.mo377a("history", "clear_history", R.id.history_frame);
        }
        if (i == -1) {
            String str2 = aev.f6393A;
            if (str2.hashCode() == 94746189 && str2.equals(str)) {
                c = 0;
            }
            if (c != 0) {
                String str3 = "Unknown AlertDialogFragment click:";
                String valueOf = String.valueOf(aev.f6393A);
                Log.e("Calculator", valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            } else {
                this.f5850n.f5873l = true;
                onBackPressed();
            }
        }
    }

    /* renamed from: a */
    public final void mo406a(afq afq, int i) {
        String str = "dark_mode";
        if (str.equals(afq.f6393A)) {
            this.f5842Q.mo377a(str, "set_dark_mode", ((Integer) ((Pair) f5824f.get(Integer.valueOf(i))).first).intValue());
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
            String str2 = "last_dark_mode";
            if (defaultSharedPreferences.getInt(str2, -1) != i) {
                defaultSharedPreferences.edit().putInt(str2, i).apply();
            }
            m7455a((Pair) f5824f.get(Integer.valueOf(i)));
        }
    }

    /* renamed from: a */
    private final void m7455a(Pair pair) {
        C0370np.m8751e(((Integer) pair.second).intValue());
        mo5774j().mo5810m();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_overflow, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        this.f5842Q.mo377a("menu", "click", itemId);
        if (itemId == R.id.menu_feedback) {
            ast.m1773a(this).mo1600a(m7451Z());
            return true;
        } else if (itemId == R.id.menu_dark_mode) {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
            defaultSharedPreferences.edit().putBoolean("dark_tooltip_shown", true).apply();
            afq.m330a(this, defaultSharedPreferences.getInt("last_dark_mode", 2), "dark_mode");
            return true;
        } else if (itemId == R.id.menu_help) {
            GoogleHelp googleHelp = new GoogleHelp("main_help");
            atf atf = new atf();
            atf.f1902a = m7450Y();
            googleHelp.f6088t = atf;
            googleHelp.f6086r.add(new auw(R.id.menu_licenses, getString(R.string.menu_licenses), new Intent(this, Licenses.class)));
            asw Z = m7451Z();
            File cacheDir = getCacheDir();
            if (Z != null) {
                googleHelp.f6068H = Z.f1763q;
            }
            googleHelp.f6091w = new ErrorReport(Z, cacheDir);
            googleHelp.f6091w.f6025X = "GoogleHelp";
            String str = "com.google.android.gms.googlehelp.HELP";
            String str2 = "EXTRA_GOOGLE_HELP";
            Intent putExtra = new Intent(str).setPackage("com.google.android.gms").putExtra(str2, googleHelp);
            atp atp = new atp(this);
            if (!putExtra.getAction().equals(str) || !putExtra.hasExtra(str2)) {
                throw new IllegalArgumentException("The intent you are trying to launch is not GoogleHelp intent! This class only supports GoogleHelp intents.");
            }
            int c = alt.m870c(atp.f1918a, auq.m1843w());
            if (c == 0) {
                aun a = ats.m1811a(atp.f1918a);
                amz.m1005b((Object) a.f1982m);
                aqu.m1702a(aun.f1981l.mo1773a(a.mo1604c(), a.f1982m, putExtra));
            } else {
                Intent data = new Intent("android.intent.action.VIEW").setData(((GoogleHelp) putExtra.getParcelableExtra(str2)).f6085q);
                if (c != 7) {
                    if (atp.f1918a.getPackageManager().queryIntentActivities(data, 0).size() > 0) {
                        atp.f1918a.startActivity(data);
                    }
                }
                alt.m869a(c, atp.f1918a, 0);
            }
            return true;
        } else if (itemId != R.id.menu_history) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            m7461ab();
            return true;
        }
    }

    /* renamed from: Y */
    private final int m7450Y() {
        int i = PreferenceManager.getDefaultSharedPreferences(this).getInt("last_dark_mode", 2);
        if (i == 0) {
            return 0;
        }
        if (i != 1) {
            return 3;
        }
        return 2;
    }

    /* renamed from: Z */
    private final asw m7451Z() {
        asz asz = new asz((Context) this);
        Bitmap a = GoogleHelp.m7607a(this);
        if (!asz.f1768b || !((cgr) cgo.f5146a.mo3163a()).mo4420a()) {
            asz.f1767a = a;
            atf atf = new atf();
            atf.f1902a = m7450Y();
            asz.f1769c = atf;
            return asz.mo1752a();
        }
        throw new IllegalStateException("Can't call setScreenshotBitmap after report is already certified pii free.");
    }

    /* renamed from: t */
    public final void mo425t() {
        this.f5842Q.mo377a("history", "drag_closed", R.id.history_frame);
        CalculatorSlidingPadLayout calculatorSlidingPadLayout = this.f5851o;
        if (calculatorSlidingPadLayout != null) {
            calculatorSlidingPadLayout.mo4857a(false);
        }
        m7433H();
    }

    /* renamed from: u */
    public final void mo427u() {
        this.f5826A.mo580g();
        mo4801r();
    }

    /* renamed from: f_ */
    public final void mo432f_() {
        this.f5842Q.mo377a("history", "drag_open", R.id.history_frame);
        m7461ab();
        CalculatorSlidingPadLayout calculatorSlidingPadLayout = this.f5851o;
        if (calculatorSlidingPadLayout != null) {
            calculatorSlidingPadLayout.mo4857a(true);
        }
    }

    /* renamed from: b */
    public final void mo431b(boolean z) {
    }

    /* renamed from: g_ */
    public final void mo433g_() {
    }

    /* renamed from: a */
    public final void mo429a(float f) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0029, code lost:
        if (r0.f5864c.contains(r4, r5) != false) goto L_0x002b;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean mo430a(android.view.View r3, int r4, int r5) {
        /*
            r2 = this;
            int r0 = r3.getId()
            r1 = 2131624166(0x7f0e00e6, float:1.8875504E38)
            if (r0 != r1) goto L_0x002d
            com.android.calculator2.DragLayout r0 = r2.f5850n
            boolean r0 = r0.mo4810b()
            if (r0 != 0) goto L_0x002b
            com.android.calculator2.DragLayout r0 = r2.f5850n
            android.graphics.Rect r1 = r0.f5864c
            r3.getHitRect(r1)
            android.view.ViewParent r3 = r3.getParent()
            android.view.View r3 = (android.view.View) r3
            android.graphics.Rect r1 = r0.f5864c
            r0.offsetDescendantRectToMyCoords(r3, r1)
            android.graphics.Rect r3 = r0.f5864c
            boolean r3 = r3.contains(r4, r5)
            if (r3 == 0) goto L_0x002d
        L_0x002b:
            r3 = 1
            return r3
        L_0x002d:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.calculator2.Calculator.mo430a(android.view.View, int, int):boolean");
    }

    /* renamed from: x */
    public final int mo434x() {
        return this.f5845i.getMeasuredHeight();
    }

    /* renamed from: a */
    public final void mo628a(int i, int i2, int i3, String str) {
        aev.m323a(this, i, i2, 0, null);
    }

    /* renamed from: y */
    public final void mo630y() {
        this.f5842Q.mo377a("memory", "store_memory", R.id.memory_store);
    }

    /* renamed from: z */
    public final void mo631z() {
        this.f5842Q.mo377a("memory", "add_memory", R.id.memory_add);
    }

    /* renamed from: A */
    public final void mo629A() {
        this.f5842Q.mo377a("memory", "subtract_memory", R.id.memory_subtract);
    }

    /* renamed from: B */
    public final Uri mo446B() {
        if (!this.f5846j.hasSelection() || mo4785o()) {
            return null;
        }
        ahe ahe = this.f5826A;
        return ahe.mo604s(ahe.mo536a(0, mo4799p(), mo4800q(), true));
    }

    /* renamed from: C */
    public final void mo447C() {
        mo4784n();
        if (this.f5846j.hasSelection()) {
            m7471e(true);
        }
    }

    /* renamed from: a */
    public final void mo449a(ClipData clipData) {
        Item itemAt = clipData.getItemCount() == 0 ? null : clipData.getItemAt(0);
        if (itemAt != null) {
            m7444S();
            mo4784n();
            m7442Q();
            mo4779b(m7445T());
            String charSequence = itemAt.coerceToText(this).toString();
            if (this.f5861z == C0027ay.f2385G) {
                mo4776a(m7472e(agd.m394a(charSequence.charAt(0))));
            }
            if (!mo4778a(charSequence)) {
                Uri uri = itemAt.getUri();
                if (uri == null || !this.f5826A.mo557a(uri)) {
                    mo4779b(m7445T());
                    this.f5840O = this.f5854r;
                    m7459a(charSequence, false);
                } else {
                    m7462ac();
                    ahe ahe = this.f5826A;
                    mo4777a(ahe.mo608v(ahe.mo592m()), this.f5826A.mo592m());
                }
                mo4783m();
            }
        }
    }

    /* renamed from: a */
    public final void mo4777a(boolean z, long j) {
        int i;
        if (z) {
            i = this.f5826A.mo533a(this.f5854r, j);
        } else {
            i = this.f5826A.mo534a(this.f5854r, j, false);
        }
        int i2 = this.f5854r;
        this.f5840O = i2;
        if (i != -1) {
            this.f5854r = i2 + i;
        }
    }

    /* renamed from: D */
    public final void mo448D() {
        this.f5842Q.mo377a("memory", "recall_memory", R.id.memory_recall);
        m7444S();
        mo4784n();
        m7462ac();
        if (this.f5826A.mo594n() != 0) {
            mo4779b(mo4799p());
            ahe ahe = this.f5826A;
            int a = ahe.mo534a(this.f5854r, ahe.mo594n(), true);
            if (a != -1) {
                mo4779b(this.f5854r + a);
            }
            mo4783m();
        }
    }

    /* renamed from: a */
    public final void mo4775a(int i, int i2) {
        if (i2 == C0027ay.f2392N) {
            CalculatorScrollView calculatorScrollView = this.f5849m;
            if (i == Integer.MAX_VALUE) {
                i = 0;
            }
            calculatorScrollView.setScrollX(i);
            return;
        }
        if (i2 == C0027ay.f2393O && i != 10010000 && this.f5826A.mo585i(0)) {
            (mo4782l() ? this.f5847k : mo4781k()).mo4840a(i);
        }
    }

    /* renamed from: aa */
    private final aiy m7460aa() {
        C0164fz e = mo5238e();
        if (e == null || e.mo5296e()) {
            return null;
        }
        C0149fk a = e.mo5265a("HistoryFragment");
        if (a == null || a.f6428o) {
            return null;
        }
        return (aiy) a;
    }

    /* renamed from: ab */
    private final void m7461ab() {
        boolean z;
        int i;
        String str = "HistoryFragment";
        if (m7460aa() == null) {
            C0164fz e = mo5238e();
            if (e != null && !e.mo5296e()) {
                if (this.f5861z == C0027ay.f2384F) {
                    Animator animator = this.f5853q;
                    if (animator != null) {
                        animator.end();
                    }
                    z = false;
                } else {
                    if (this.f5861z == C0027ay.f2381C) {
                        mo4784n();
                    } else if (this.f5861z == C0027ay.f2382D || this.f5861z == C0027ay.f2383E) {
                        z = false;
                    }
                    z = true;
                }
                if (z) {
                    m7431F();
                    mo4779b(m7445T());
                    this.f5846j.setCursorVisible(false);
                    CalculatorDisplay calculatorDisplay = this.f5845i;
                    calculatorDisplay.removeCallbacks(calculatorDisplay.f5880f);
                    calculatorDisplay.f5875a.setVisibility(4);
                    try {
                        aiy aiy = new aiy();
                        Bundle bundle = new Bundle();
                        String str2 = "KEY_FORMULA_SCROLL_POS";
                        if (mo4782l()) {
                            i = Integer.MAX_VALUE;
                        } else {
                            i = this.f5849m.getScrollX();
                        }
                        bundle.putInt(str2, i);
                        String str3 = "KEY_RESULT_SCROLL_POS";
                        CalculatorResult k = mo4782l() ? this.f5847k : mo4781k();
                        int i2 = (!k.f5907j || !k.f5906i) ? 10010000 : k.f5899b.isFinished() ? k.f5908k : k.f5899b.getFinalX();
                        bundle.putInt(str3, i2);
                        aiy.mo5201f(bundle);
                        C0185gt a = e.mo5266a();
                        a.mo5159a(R.id.history_frame, aiy, str, 2);
                        a.f6587i = 0;
                        if (a.f6590l) {
                            a.f6589k = true;
                            a.f6591m = str;
                            a.mo5156a();
                            this.f5852p.setImportantForAccessibility(4);
                            this.f5852p.announceForAccessibility(getString(R.string.title_history));
                            m7474f(getResources().getBoolean(R.bool.theme_light));
                            return;
                        }
                        throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
                    } catch (IllegalStateException e2) {
                        Log.e("Calculator", "Error showing history fragment:", e2);
                        return;
                    }
                }
            }
            this.f5850n.mo4811c();
        }
    }

    /* renamed from: f */
    private final void m7474f(boolean z) {
        int i;
        int systemUiVisibility = getWindow().getDecorView().getSystemUiVisibility();
        if (z) {
            i = systemUiVisibility | 8192;
        } else {
            i = systemUiVisibility & -8193;
        }
        getWindow().getDecorView().setSystemUiVisibility(i);
    }

    /* JADX WARNING: Removed duplicated region for block: B:63:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0149 A[SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m7459a(java.lang.String r11, boolean r12) {
        /*
            r10 = this;
            int r0 = r11.length()
            int r1 = r10.f5861z
            int r2 = p000.C0027ay.f2385G
            r3 = 0
            if (r1 != r2) goto L_0x0026
            if (r0 == 0) goto L_0x0026
            char r1 = r11.charAt(r3)
            int r1 = p000.agd.m394a(r1)
            boolean r1 = m7472e(r1)
            r10.mo4776a(r1)
            ahe r1 = r10.f5826A
            int r1 = r1.mo584i()
            r10.f5854r = r1
        L_0x0026:
            boolean r1 = r10.m7440O()
            if (r1 == 0) goto L_0x0068
            boolean r1 = r10.m7438M()
            if (r1 == 0) goto L_0x004f
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = r10.f5839N
            r1.<init>(r2)
            int r2 = r10.f5854r
            int r4 = r10.f5840O
            int r2 = r2 - r4
            r1.insert(r2, r11)
            java.lang.String r11 = r1.toString()
            int r1 = r10.f5854r
            int r2 = r11.length()
            int r1 = r1 + r2
            r10.f5854r = r1
            goto L_0x006c
        L_0x004f:
            java.lang.String r1 = r10.f5839N
            int r1 = r1.length()
            java.lang.String r2 = ""
            r10.f5839N = r2
            int r2 = r10.f5854r
            int r4 = r10.f5840O
            if (r2 <= r4) goto L_0x0063
            int r2 = r2 - r1
            r10.mo4779b(r2)
        L_0x0063:
            int r1 = r10.f5854r
            r10.f5840O = r1
            goto L_0x006c
        L_0x0068:
            int r1 = r10.f5854r
            r10.f5840O = r1
        L_0x006c:
            java.lang.String r1 = ","
            java.lang.String r1 = p000.agd.m397a(r1)
            char r1 = r1.charAt(r3)
            r2 = 0
            r4 = 0
        L_0x0078:
            r5 = 1
            if (r2 >= r0) goto L_0x0162
            char r6 = r11.charAt(r2)
            if (r12 != 0) goto L_0x00ae
            r7 = 32
            if (r6 != r7) goto L_0x00ae
            if (r4 == 0) goto L_0x00ae
            r7 = r2
        L_0x0088:
            if (r7 >= r0) goto L_0x0097
            char r8 = r11.charAt(r7)
            boolean r8 = java.lang.Character.isSpaceChar(r8)
            if (r8 == 0) goto L_0x0097
            int r7 = r7 + 1
            goto L_0x0088
        L_0x0097:
            if (r7 >= r0) goto L_0x00ae
            char r8 = r11.charAt(r7)
            boolean r8 = java.lang.Character.isDigit(r8)
            if (r8 == 0) goto L_0x00ae
            r2 = 2131624296(0x7f0e0168, float:1.8875768E38)
            r10.m7473f(r2)
            r2 = r7
            r4 = 0
            goto L_0x0078
        L_0x00ae:
            boolean r7 = java.lang.Character.isSpaceChar(r6)
            if (r7 != 0) goto L_0x015e
            if (r6 != r1) goto L_0x00b8
            goto L_0x015e
        L_0x00b8:
            int r7 = p000.agd.m394a(r6)
            if (r12 != 0) goto L_0x00f1
            if (r4 == 0) goto L_0x00d9
            int r8 = p000.ahe.m480a(r11, r2)
            if (r2 == r8) goto L_0x00d9
            int r4 = r8 - r2
            ahe r5 = r10.f5826A
            int r6 = r10.f5854r
            r5.mo545a(r6, r11, r2, r8)
            int r2 = r10.f5854r
            int r2 = r2 + r4
            r10.f5854r = r2
            r2 = r8
            r4 = 0
            goto L_0x0078
        L_0x00d9:
            int r8 = p000.agd.m402e(r7)
            r9 = 10
            if (r8 == r9) goto L_0x00e3
            r8 = 1
            goto L_0x00e4
        L_0x00e3:
            r8 = 0
        L_0x00e4:
            if (r8 != 0) goto L_0x00f0
            if (r4 == 0) goto L_0x00ee
            r4 = 2131624288(0x7f0e0160, float:1.8875751E38)
            if (r7 != r4) goto L_0x00ee
            goto L_0x00f0
        L_0x00ee:
            r4 = 0
            goto L_0x00f1
        L_0x00f0:
            r4 = 1
        L_0x00f1:
            r8 = -1
            if (r7 == r8) goto L_0x010b
            android.view.View r5 = r10.findViewById(r7)
            r10.f5838M = r5
            r10.m7473f(r7)
            boolean r5 = java.lang.Character.isSurrogate(r6)
            if (r5 == 0) goto L_0x0107
            int r2 = r2 + 2
            goto L_0x0078
        L_0x0107:
            int r2 = r2 + 1
            goto L_0x0078
        L_0x010b:
            p000.agd.m398a()
            r6 = 40
            int r7 = r11.indexOf(r6, r2)
            if (r7 == r8) goto L_0x012a
            java.lang.String r7 = r11.substring(r2, r7)
            java.util.HashMap r9 = p000.agd.f428a
            java.lang.Object r7 = r9.get(r7)
            java.lang.Integer r7 = (java.lang.Integer) r7
            if (r7 == 0) goto L_0x012a
            int r7 = r7.intValue()
            goto L_0x012b
        L_0x012a:
            r7 = -1
        L_0x012b:
            if (r7 == r8) goto L_0x0149
            android.view.View r8 = r10.findViewById(r7)
            r10.f5838M = r8
            r10.m7473f(r7)
            r8 = 2131624265(0x7f0e0149, float:1.8875705E38)
            if (r7 != r8) goto L_0x0142
            r7 = 2131624270(0x7f0e014e, float:1.8875715E38)
            r10.m7473f(r7)
        L_0x0142:
            int r2 = r11.indexOf(r6, r2)
            int r2 = r2 + r5
            goto L_0x0078
        L_0x0149:
            java.lang.String r11 = r11.substring(r2)
            r10.f5839N = r11
            int r11 = r10.f5854r
            java.lang.String r12 = r10.f5839N
            int r12 = r12.length()
            int r11 = r11 + r12
            r10.f5854r = r11
            r10.mo4783m()
            return
        L_0x015e:
            int r2 = r2 + 1
            goto L_0x0078
        L_0x0162:
            ahe r11 = r10.f5826A
            int r12 = r10.f5854r
            java.lang.Object r11 = r11.mo542a(r12, r5)
            java.lang.String r11 = (java.lang.String) r11
            r10.f5839N = r11
            int r11 = r10.f5854r
            java.lang.String r12 = r10.f5839N
            int r12 = r12.length()
            int r11 = r11 - r12
            r10.f5840O = r11
            r10.mo4783m()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.calculator2.Calculator.m7459a(java.lang.String, boolean):void");
    }

    /* renamed from: ac */
    private final void m7462ac() {
        if (this.f5861z == C0027ay.f2386H || this.f5861z == C0027ay.f2385G) {
            m7467c(C0027ay.f2380B);
            m7430E();
            this.f5826A.mo579f();
        }
    }

    public void onContextMenuClosed(Menu menu) {
        m7431F();
        m7432G();
    }

    static {
        int i;
        bxh g = bxg.m4660g();
        Integer valueOf = Integer.valueOf(0);
        Integer valueOf2 = Integer.valueOf(R.string.choice_light_mode);
        Integer valueOf3 = Integer.valueOf(1);
        bxh bxh = (bxh) g.mo3294a(valueOf, new Pair(valueOf2, valueOf3));
        Integer valueOf4 = Integer.valueOf(R.string.choice_dark_mode);
        Integer valueOf5 = Integer.valueOf(2);
        bxh bxh2 = (bxh) g.mo3294a(valueOf3, new Pair(valueOf4, valueOf5));
        Integer valueOf6 = Integer.valueOf(R.string.choice_system_mode);
        if (C0499sj.m9352d()) {
            i = 3;
        } else {
            i = -1;
        }
        bxh bxh3 = (bxh) g.mo3294a(valueOf5, new Pair(valueOf6, Integer.valueOf(i)));
        f5824f = (bxg) g.mo3295a();
    }
}
