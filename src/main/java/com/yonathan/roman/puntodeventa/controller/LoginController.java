package com.yonathan.roman.puntodeventa.controller;

/**
 *
 * @author Yonathan
 */
public class LoginController {

    public boolean login(String usuario, String password) {
        if (usuario.equals("a")) {
            return true;
        }else{
            return false;
        }
    }
}
