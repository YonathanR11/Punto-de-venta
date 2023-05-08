package com.yonathan.roman.puntodeventa;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.yonathan.roman.puntodeventa.config.DatabaseApp;
import com.yonathan.roman.puntodeventa.view.Login;
import javax.swing.JOptionPane;

/**
 *
 * @author Yonathan
 */
public class App {

    public static void main(String[] args) {
        System.out.println("Iniciando aplicacion...");
        try {
            FlatLightLaf.setup();
            FlatLaf.updateUI();

            DatabaseApp.init();

            Login login = new Login();
            login.setVisible(true);
            System.out.println("Aplicacion iniciada.");
        } catch (Exception e) {
            System.err.println("ERROR: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al iniciar la aplicacion.\n" + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
}
