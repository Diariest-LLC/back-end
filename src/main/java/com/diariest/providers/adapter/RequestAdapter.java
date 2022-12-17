package com.diariest.providers.adapter;

import com.diariest.providers.Login;
import com.diariest.providers.Register;
import com.diariest.providers.enums.RequestType;
import com.diariest.providers.module.RequestModule;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class RequestAdapter {

    public static List<RequestModule> moduleList= Arrays.asList(
            new Login(),
            new Register()
    );

    public static ConcurrentHashMap<RequestType, RequestModule> moduleAdapter = new ConcurrentHashMap<>();

    public static void registerModules() {
        for(RequestModule module : moduleList) {
            moduleAdapter.put(module.getRequestType(), module);
        }
    }

    public static RequestModule getModule(RequestType requestType) {
        return moduleAdapter.getOrDefault(requestType, null);
    }

}
