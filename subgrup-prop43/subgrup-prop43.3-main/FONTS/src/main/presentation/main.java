package FONTS.src.main.presentation;


import FONTS.src.main.presentation.views.menuInicio;

import javax.swing.*;

public class main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame menuInicio = new menuInicio();
                menuInicio.setSize(600, 600);
                menuInicio.setVisible(true);
            }
        });
    }
}
