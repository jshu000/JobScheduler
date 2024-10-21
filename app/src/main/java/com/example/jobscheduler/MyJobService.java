package com.example.jobscheduler;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;

public class MyJobService extends JobService {

    private static final String TAG = "JashwantScheduler";

    @Override
    public boolean onStartJob(final JobParameters params) {

        HandlerThread handlerThread = new HandlerThread("SomeOtherThread");
        handlerThread.start();

        Handler handler = new Handler(handlerThread.getLooper());
        handler.post(new Runnable() {
            @Override
            public void run() {
                Log.e(TAG, "Running!!!!!!!!!!!!!");
                jobFinished(params, true);
            }
        });

        return true;
    }

    @Override
    public boolean onStopJob(final JobParameters params) {
        Log.d(TAG, "onStopJob() was called");
        return true;
    }
}