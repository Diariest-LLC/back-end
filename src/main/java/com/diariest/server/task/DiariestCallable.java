package com.diariest.server.task;

import java.util.concurrent.Callable;

public interface DiariestCallable extends Callable {
    int getId();
    void cancelTask(); // Method for supporting non-standard cancellation
    void loop();
}
