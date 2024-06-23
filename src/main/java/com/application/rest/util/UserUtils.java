package com.application.rest.util;

import com.application.rest.model.TipoDocumento;
import com.application.rest.model.User;

public class UserUtils {
    private static final User user = new User(
            TipoDocumento.C,
            "23445322",
            "Luis",
            "Fernando",
            "González",
            "Parra",
            "3105459800",
            "Calle 100 # 69 - 23",
            "Bogotá");

    public static User getUser() {
        return user;
    }
}
