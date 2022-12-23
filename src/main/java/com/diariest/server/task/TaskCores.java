package com.diariest.server.task;

import com.diariest.server.Main;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class TaskCores {

    public static HashMap<Integer, DiariestCallable> TASK_LIST = new HashMap<Integer, DiariestCallable>();

    public static void create(long initialDelay, DiariestCallable callable) {
        Main.getExecutorService().schedule(callable, initialDelay, TimeUnit.MICROSECONDS);
        addTask(callable.getId(), callable);
    }

    public static void stopTask(int key){
        DiariestCallable task = getTask(key);

        if(task == null) return;
        task.cancelTask();
        removeTask(key);
    }

    public static DiariestCallable getTask(int key){
        return TASK_LIST.getOrDefault(key, null);
    }

    private static void addTask(int key, DiariestCallable task){
        TASK_LIST.put(key, task);
    }

    private static void removeTask(int key){
        TASK_LIST.remove(key);
    }
}
