package com.llw.notify;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.util.Log;

import androidx.annotation.Nullable;

import static com.llw.notify.NotifyHelper.*;

/**
 * @author llw
 * @description NotifyService
 * @date 2021/8/5 19:14
 */
public class NotifyService extends NotificationListenerService {

    public static final String TAG = "NotifyService";

    public static final String QQ = "com.tencent.mobileqq";//qq信息
    public static final String WX = "com.tencent.mm";//微信信息
    public static final String MMS = "com.android.mms";//短信
    public static final String HONOR_MMS = "com.hihonor.mms";//荣耀短信
    public static final String MESSAGES = "com.google.android.apps.messaging";//信息
    public static final String IN_CALL = "com.android.incallui";//来电

    /**
     * 发布通知
     *
     * @param sbn 状态栏通知
     */
    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {
        NotifyHelper.getInstance().onReceive(sbn);
        /*switch (sbn.getPackageName()) {
            case MESSAGES:
            case MMS:
            case HONOR_MMS:
                Log.d(TAG, "收到短信");
                NotifyHelper.getInstance().onReceive(N_MESSAGE);
                break;
            case QQ:
                Log.d(TAG, "收到QQ消息");
                NotifyHelper.getInstance().onReceive(N_QQ);
                break;
            case WX:
                Log.d(TAG, "收到微信消息");
                NotifyHelper.getInstance().onReceive(N_WX);
                break;
            case IN_CALL:
                Log.d(TAG, "收到来电");
                NotifyHelper.getInstance().onReceive(N_CALL);
                break;
            default:
                break;
        }*/
    }

    /**
     * 通知已删除
     *
     * @param sbn 状态栏通知
     */
    @Override
    public void onNotificationRemoved(StatusBarNotification sbn) {
        NotifyHelper.getInstance().onRemoved(sbn);
        /*switch (sbn.getPackageName()) {
            case MESSAGES:
            case MMS:
            case HONOR_MMS:
                Log.d(TAG, "移除短信");
                NotifyHelper.getInstance().onRemoved(N_MESSAGE);
                break;
            case QQ:
                Log.d(TAG, "移除QQ消息");
                NotifyHelper.getInstance().onRemoved(N_QQ);
                break;
            case WX:
                Log.d(TAG, "移除微信消息");
                NotifyHelper.getInstance().onRemoved(N_WX);
                break;
            case IN_CALL:
                Log.d(TAG, "移除来电");
                NotifyHelper.getInstance().onRemoved(N_CALL);
                break;
            default:
                break;
        }*/
    }

    /**
     * 监听断开
     */
    @Override
    public void onListenerDisconnected() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            // 通知侦听器断开连接 - 请求重新绑定
            requestRebind(new ComponentName(this, NotificationListenerService.class));
        }
    }
}
