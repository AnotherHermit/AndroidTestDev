package io.anotherhermit.utillib;

import android.app.ActivityManager;

public class RunningServiceWrapper {

    private ActivityManager.RunningServiceInfo mInfo;

    public RunningServiceWrapper(ActivityManager.RunningServiceInfo info) {
        mInfo = info;
    }

    public ActivityManager.RunningServiceInfo getInfo() {
        return mInfo;
    }

    public String toString() {
        return mInfo.service.flattenToShortString();
    }
}
