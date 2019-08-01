package com.android.calculator2;

import android.app.backup.BackupAgent;
import android.app.backup.BackupDataInput;
import android.app.backup.BackupDataOutput;
import android.os.ParcelFileDescriptor;
import java.io.File;

/* compiled from: PG */
public class CalculatorBackupAgent extends BackupAgent {
    public void onBackup(ParcelFileDescriptor parcelFileDescriptor, BackupDataOutput backupDataOutput, ParcelFileDescriptor parcelFileDescriptor2) {
    }

    public void onRestore(BackupDataInput backupDataInput, int i, ParcelFileDescriptor parcelFileDescriptor) {
    }

    public void onRestoreFile(ParcelFileDescriptor parcelFileDescriptor, long j, File file, int i, long j2, long j3) {
        File file2;
        String str = "_preferences.xml";
        if (file.getName().endsWith(str)) {
            file2 = new File(file.getParentFile(), String.valueOf(getPackageName()).concat(str));
        } else {
            file2 = file;
        }
        super.onRestoreFile(parcelFileDescriptor, j, file2, i, j2, j3);
    }
}
