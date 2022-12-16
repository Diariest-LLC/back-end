package com.diariest.providers.adapter;

import com.diariest.providers.Login;
import com.diariest.providers.Register;
import com.diariest.providers.enums.RequestType;
import com.diariest.providers.module.RequestModule;

import java.util.LinkedList;

public class RequestAdapter {

    public static LinkedList<RequestModule> modules = new LinkedList<>();

    public static void registerModules() {
        modules.add(new Login());
        modules.add(new Register());
    }

    public static RequestModule getModule(RequestType requestType) {
        return modules.stream().filter(module -> module.getRequestType() == requestType).findFirst().orElse(null);
    }

}
