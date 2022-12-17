package com.diariest.server.adapters;

import com.diariest.server.providers.Login;
import com.diariest.server.providers.Register;
import com.diariest.server.response.enums.RequestType;
import com.diariest.server.response.modules.RequestModule;

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
