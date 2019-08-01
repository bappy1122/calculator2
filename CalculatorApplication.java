package com.android.calculator2;

import android.app.Application;
import android.os.SystemClock;

/* compiled from: PG */
public class CalculatorApplication extends Application {
    public void onCreate() {
        super.onCreate();
        bps bps = bps.f3874c;
        if (bzl.m4818a() && bps.f3876e > 0 && bps.f3877f == 0) {
            bps.f3877f = SystemClock.elapsedRealtime();
            bzl.m4812a((Runnable) new bpr(bps));
            registerActivityLifecycleCallbacks(new bpt(bps, this));
        }
        bnt a = bnt.m4056a(bob.m4077a(this, new bol(this)));
        a.f3710a.mo2901c();
        a.f3710a.mo2902d();
    }

    static {
        bps bps = bps.f3874c;
        if (bps.f3876e == 0) {
            bps.f3876e = SystemClock.elapsedRealtime();
        }
    }
}
