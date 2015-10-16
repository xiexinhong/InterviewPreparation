package org.xiexh.appcore.xmlparser;

import android.util.Log;

import java.util.List;

/**
 * Created by Administrator on 2015/10/16.
 */
public class PrintRivers {

    private static final String TAG = "PrintRivers";

    public static void print(List<River> rivers) {
        if(rivers == null) {
            Log.i(TAG,"rivers is null");
            return;
        }
        Log.i(TAG,"print begin");
        for(River r : rivers) {
            Log.i("TAG",r.toString());
        }
        Log.i(TAG,"print end");
    }
}
