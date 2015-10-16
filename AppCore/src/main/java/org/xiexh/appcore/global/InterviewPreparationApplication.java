package org.xiexh.appcore.global;

import android.app.Application;
import android.content.Context;

/**
 * Created by Administrator on 2015/10/16.
 */
public class InterviewPreparationApplication extends Application {


    private static InterviewPreparationApplication mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static Context getContext() {
        return mContext;
    }
}
