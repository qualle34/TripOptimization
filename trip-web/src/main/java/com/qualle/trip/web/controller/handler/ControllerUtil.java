package com.qualle.trip.web.controller.handler;

public class ControllerUtil {

    public static int clarifyPage(Integer page) {
        if (page == null) {
            return 0;
        }
        if (page <= 0) {
            return 0;
        }
        return page;
    }
}
