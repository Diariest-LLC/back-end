package com.diariest.server.task;

import com.diariest.server.Main;
import com.diariest.server.utils.UtilUUID;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class TaskCores {

    public static HashMap<Integer, SolucionCallable> TASK_LIST = new HashMap<Integer, SolucionCallable>();

    public static void create(long initialDelay, SolucionCallable callable) {
        Main.getExecutorService().schedule(callable, initialDelay, TimeUnit.MICROSECONDS);
        addTask(callable.getId(), callable);
    }

    public static void stopTask(int key){
        SolucionCallable task = getTask(key);

        if(task == null) return;
        task.cancelTask();
        removeTask(key);
    }

    public static SolucionCallable getTask(int key){
        return TASK_LIST.getOrDefault(key, null);
    }

    private static void addTask(int key, SolucionCallable task){
        TASK_LIST.put(key, task);
    }

    private static void removeTask(int key){
        TASK_LIST.remove(key);
    }
}
