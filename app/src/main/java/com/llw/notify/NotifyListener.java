package com.llw.notify;

import android.service.notification.StatusBarNotification;

/**
 * @author llw
 * @description NotifyListener
 * @date 2021/8/12 10:30
 */
public interface NotifyListener {

    /**
     * 接收到通知栏消息
     * @param type
     */
    void onReceiveMessage(int type);

    /**
     * 移除掉通知栏消息
     * @param type
     */
    void onRemovedMessage(int type);

    /**
     * 接收到通知栏消息
     * @param sbn
     */
    void onReceiveMessage(StatusBarNotification sbn);

    /**
     * 移除掉通知栏消息
     * @param sbn
     */
    void onRemovedMessage(StatusBarNotification sbn);
}
