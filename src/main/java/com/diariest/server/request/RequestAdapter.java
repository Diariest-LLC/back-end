package com.diariest.server.request;

import com.diariest.server.request.providers.Login;
import com.diariest.server.request.providers.Test;
import com.diariest.server.request.modules.RequestModule;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class RequestAdapter {

    public static List<RequestModule> moduleList = Arrays.asList(
            new Login(),
            new Test()
    );

    public static ConcurrentHashMap<String, RequestModule> moduleAdapter = new ConcurrentHashMap<>();

    public static void registerModules() {
        for(RequestModule module : moduleList) {
            moduleAdapter.put(module.getClass().getSimpleName().toLowerCase(), module);
        }
    }

    public static RequestModule getModule(Class<RequestModule> module) {
        return moduleAdapter.getOrDefault(module.getSimpleName().toLowerCase(), null);
    }
    public static RequestModule getModule(String moduleName) {
        return moduleAdapter.getOrDefault(moduleName.toLowerCase(), null);
    }

}
