package com.jd.permission.util;

import android.content.Context;
import android.os.Build;

import com.jd.permission.interfaces.ISetting;
import com.jd.permission.support.Default;
import com.jd.permission.support.OPPO;
import com.jd.permission.support.ViVo;


public class SettingUtil {

    private static final String MANUFACTURER_OPPO = "OPPO";
    private static final String MANUFACTURER_VIVO = "vivo";

    /**
     * 跳设置界面
     *
     * @param context context
     */
    public static void go2Setting(Context context) {
        ISetting iSetting;

        switch (Build.MANUFACTURER) {
            case MANUFACTURER_VIVO:
                iSetting = new ViVo(context);
                break;
            case MANUFACTURER_OPPO:
                iSetting = new OPPO(context);
                break;
            default:
                iSetting = new Default(context);
                break;
        }
        if (iSetting.getSetting() == null) return;
        context.startActivity(iSetting.getSetting());
    }


}
