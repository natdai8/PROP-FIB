package FONTS.src.main.presentation.views;
import FONTS.src.main.presentation.controllers.PresentationController;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menuInicio extends JFrame {

    private JPanel panel1;
    private JButton iniciarSesionButton;
    private JButton crearNuevaCuentaButton;
    private JButton salirDelJuegoButton;
    private JLabel titulo;
    private final PresentationController ctrl = new PresentationController();


    public menuInicio() {
        if(!ctrl.IsRankingCharged()) ctrl.cargarRanking();
        setContentPane(panel1);

        salirDelJuegoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        iniciarSesionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ctrl.changeWindowToLogin();
                dispose();
            }
        });

        crearNuevaCuentaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ctrl.changeWindowToSignin();
                dispose();
            }
        });
    }
}

