package com.diariest.server.adapters;

import com.diariest.server.providers.Login;
import com.diariest.server.providers.Register;
import com.diariest.server.response.enums.RequestType;
import com.diariest.server.response.modules.RequestModule;
import com.diariest.server.utils.UtilConsole;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class RequestAdapter {

    public static List<RequestModule> moduleList= Arrays.asList(
            new Login(),
            new Register()
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
