package com.app.mysmslistener;

import android.content.Context;

import org.jetbrains.annotations.NotNull;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class MyWorker extends Worker {

    public MyWorker(@NonNull @NotNull Context context, @NonNull @NotNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @NotNull
    @Override
    public Result doWork() {
        System.out.println("cuongnb");
        return Result.success();
    }
}
