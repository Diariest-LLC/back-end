package com.diariest.server.task;

import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;

public interface SolucionCallable extends Callable {
    int getId();
    void cancelTask(); // Method for supporting non-standard cancellation
    void loop();
}
