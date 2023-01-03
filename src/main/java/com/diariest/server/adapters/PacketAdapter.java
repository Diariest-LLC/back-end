package com.diariest.server.adapters;

import com.diariest.server.Configuration;
import com.diariest.server.utils.UtilConsole;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class PacketAdapter {

    private static ConcurrentLinkedQueue<Runnable> requestQueue;
    private static HashMap<Integer, LinkedList<Callable>> orderQueue = new HashMap<>();

    public static ScheduledExecutorService executorService;

    public static void enable(){
        executorService = Executors.newSingleThreadScheduledExecutor();
        requestQueue = new ConcurrentLinkedQueue<Runnable>();

        executorService.execute(() -> {
            try {
                while(true) {
                    Thread.sleep(1L);
                    if(Configuration.STOP_SYNC) continue;

                    try {
                        manageOrderQueue();
                        tickRequestQueue();

                    }catch(Exception e) {
                        UtilConsole.log("(SYNC) Error => " + e);
                        e.printStackTrace();
                    }
                }
            }catch(Exception e) {
                UtilConsole.log("(SYNC) Error => " + e);
                e.printStackTrace();
            }
        });
    }

    private static void manageOrderQueue(){
        orderQueue.forEach((integer, callables) -> tickOrderQueue(integer));
    }

    private static void tickOrderQueue(int orderID) {
        try{
            Iterator<Callable> iterator = orderQueue.get(orderID).iterator();
            while(iterator.hasNext()){
                iterator.next().call();
            }
        }
        catch(Exception e){
            UtilConsole.log("Tick Order Queue Error => " + e);
            e.printStackTrace();
        } finally {
            orderQueue.get(orderID).clear();
        }
    }

    private static void tickRequestQueue() {
        Iterator<Runnable> iterator = requestQueue.iterator();

        while(iterator.hasNext()) {
            Runnable runnable = iterator.next();
            try {
                runnable.run();
            } catch(Exception e) {
                UtilConsole.log("(SYNC - PacketQueue) Error => " + e);
            } finally {
                requestQueue.remove(runnable);
            }
        }
    }

    public static void addRequestQueue(Runnable runnable) {
        requestQueue.add(runnable);
    }

    public static <T> void addOrderQueue(int id, Callable<T> response){
        if(!orderQueue.containsKey(id)) orderQueue.put(id, new LinkedList<Callable>());

        orderQueue.get(id).add(response);
    }
}
