package com.imran.workmanage

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters

/**
 * Created by imran on 2020-06-24.
 */
class NotificationWorker(context: Context, workerParams: WorkerParameters) :
    Worker(context, workerParams) {

    override fun doWork(): Result {
        val recivieText:String = inputData.getString("SEND_KEY")!!
        showNotification(recivieText)
        val data = Data.Builder()
            .putString("WORKER_SEND", "I am worker and assuring you your work has finished")
            .build()

        return Result.success(data)
    }

    private fun showNotification(desText: String) {
        val notificationManager: NotificationManager =
            applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                "CHANNEL_ID",
                "name",
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                description = "Channel description"
            }
            // Register the channel with the system

            notificationManager.createNotificationChannel(channel)
        }
        val builder = NotificationCompat.Builder(applicationContext, "CHANNEL_ID")
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle("Test notification from title")
//            .setContentText("Test notification from description")
            .setContentText(desText)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        // Set the intent that will
        with(notificationManager) {
            // notificationId is a unique int for each notification that you must define
            notify(12, builder.build())
        }
    }


}
