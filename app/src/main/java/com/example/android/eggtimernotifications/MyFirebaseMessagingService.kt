package com.example.android.eggtimernotifications

import android.app.NotificationManager
import android.content.ContentValues.TAG
import android.util.Log
import androidx.core.content.ContextCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService: FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage?) {
        Log.d(TAG, "From: ${remoteMessage?.from}")

        // TODO Step 3.5 check messages for data
        //check if message contains a data payload.
        remoteMessage?.data?.let {
            Log.d(TAG, "Message data payload: " + remoteMessage.data)
        }

        // TODO Step 3.6 check messages for notification and call sendNotification
        // Check if message contains a notification payload.
        remoteMessage?.notification?.let {
            Log.d(TAG, "Message Notification Body: ${it.body}")
            sendNotification(it.body)
        }

    }
    // [END receive_message]

    // TODO Step 3.2 log registration token
    //  [Start on_new_token]

    // [END on_new_token]

    override fun onNewToken(token: String?) {
        Log.d(TAG, "Refreshed token: $token")

        // if you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server
        sendRegistrationToServer(token)
    }

    private fun sendRegistrationToServer(token: String?) {

    }

    //Create and show a simple notification containing the received FCM message
    private fun sendNotification(messageBody: String?) {

    }

}