package com.yonathan.roman.puntodeventa.controller;

import com.yonathan.roman.puntodeventa.model.Usuario;
import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Yonathan
 */
public class LoginController {

    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    public boolean login(String usuario, String password) {

        try {
            Usuario user = new Usuario().db().find(Usuario.class).where().eq("usuario", usuario).findOne();
            if (ObjectUtils.isNotEmpty(user)) {
                if (password.equals(user.getPassword())) {
                    return true;
                }
            }
        } catch (Exception e) {
            log.error("ERROR: " + e.getMessage());
        }
        return false;
    }
}
