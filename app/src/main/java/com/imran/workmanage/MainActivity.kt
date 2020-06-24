package com.imran.workmanage

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkRequest
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val notificationWorkRequest: WorkRequest =
            OneTimeWorkRequestBuilder<NotificationWorker>()
                .build()


        btn_notificaton.setOnClickListener(View.OnClickListener {
            WorkManager
                .getInstance(applicationContext)
                .enqueue(notificationWorkRequest)
        })

        // To get result back from worker
        WorkManager.getInstance(applicationContext).getWorkInfoByIdLiveData(notificationWorkRequest.id).observe(this,
            Observer {
                textView.append(it.state.name)
            })

    }
}
