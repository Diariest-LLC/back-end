package com.diariest.server.task;

import com.diariest.server.utils.UtilConsole;

import java.util.concurrent.RunnableFuture;

public class DiariestTask implements DiariestCallable {
    private final int id;
    private long yield;
    private int targetOverCount;
    private int overCount = 0;
    volatile boolean cancelled;

    volatile FutureTaskWrapper<Boolean> wrapper;
    public Runnable runnable;

    public DiariestTask(int id, long yield, Runnable runnable) {
        this(id, yield, -1, runnable);
    }

    public DiariestTask(int id, long yield, int targetOverCount, Runnable runnable) {
        this.id = id;
        this.runnable = runnable;
        this.yield = yield;
        this.targetOverCount = targetOverCount;

        newTask();
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
                DiariestTask.this.cancelTask();
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
    public Boolean call() throws InterruptedException {

        UtilConsole.log("Runnable started");

        while (!cancelled) {
            Thread.sleep(yield);
            runnable.run();
            if(targetOverCount != -1) overCount++;
            if(overCount == targetOverCount) TaskCores.stopTask(getId());
        }

        System.out.println("Runnable canceled");

        return true;
    }
}
