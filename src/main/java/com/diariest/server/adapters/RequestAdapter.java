package com.diariest.server.adapters;

import com.diariest.server.database.Redis;
import com.diariest.server.request.providers.Login;
import com.diariest.server.request.providers.Register;
import com.diariest.server.request.modules.RequestModule;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class RequestAdapter {

    public static List<RequestModule> moduleList = Arrays.asList(
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

    public static boolean requestLimitor(String ipAddress) {
        String dataKey = "request_limitor/" + ipAddress;
        int limitSecond = 30;
        int maxLimit = 5;

        Object data = Redis.getData(dataKey);
        if(data == null) {
            Redis.setData(dataKey, 1, limitSecond);
            return true;
        };

        int count = Integer.parseInt(data.toString());
        if(count != maxLimit) {
            Redis.setData(dataKey, count + 1, limitSecond);
            return true;
        }

        return false;
    }

}
