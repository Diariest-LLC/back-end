package com.diariest.server.task;

import com.diariest.server.utils.UtilConsole;

import java.util.concurrent.RunnableFuture;

public class SolucionTask implements SolucionCallable {
    private final int id;
    volatile boolean cancelled;

    volatile FutureTaskWrapper<Boolean> wrapper;
    public Runnable runnable;

    public SolucionTask(int id, Runnable runnable) {
        this.id = id;
        newTask();
        this.runnable = runnable;
    }

    @Override
    public synchronized int getId() {
        return id;
    }

    public RunnableFuture<Boolean> newTask() {
        UtilConsole.log("Yeni task oluşturuluyor");
        wrapper = new FutureTaskWrapper<Boolean>(this) {
            @Override
            public boolean cancel(boolean isCanceled) {
                SolucionTask.this.cancelTask();
                return super.cancel(cancelled);
            }

            @Override
            public int getTaskId() {
                return getId();
            }
        };

        return wrapper;
    }

    @Override
    public synchronized void cancelTask() {
        cancelled = true;
    }

    @Override
    public void loop() {}

    @Override
    public Boolean call() {

        UtilConsole.log("Runnable başaldı");

        while (!cancelled) {
            runnable.run();
        }

        System.out.println("Runnable canceled");

        return true;
    }
}
