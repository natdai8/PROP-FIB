package FONTS.src.main.presentation.views;

import FONTS.src.main.presentation.controllers.PresentationController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menuPrincipal extends JFrame {

    private JButton cerrarSesionButton;
    private JButton crearNuevaPartidaButton;
    private JButton gestionarTusPartidasButton;
    private JButton consultarRankingGlobalButton;
    private JButton consultarRecordsPersonalesButton;
    private JPanel panel1;
    private JLabel bienvenido;
    private final PresentationController ctrl = new PresentationController();


    public menuPrincipal() {

        setContentPane(panel1);

        cerrarSesionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ctrl.changeWindowToStartMenu();
                ctrl.logOut();
                dispose();
            }
        });
        gestionarTusPartidasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = ctrl.getUsername();
                ctrl.changeWindowToPersonalGames(user);
                dispose();
            }
        });
        consultarRankingGlobalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ctrl.changeWindowToRanking();
                dispose();
            }
        });

        consultarRecordsPersonalesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = ctrl.getUsername();
                ctrl.changeWindowToPersonalRecords(user);
                dispose();
            }
        });
        crearNuevaPartidaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ctrl.changeWindowToCrearPartida();
                dispose();
            }
        });
    }
}
