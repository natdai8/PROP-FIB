package FONTS.src.main.presentation.views;
import FONTS.src.main.presentation.controllers.PresentationController;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FinPartida extends JFrame {
    private JLabel TituloLabel;
    private JLabel PuntuacionFinalLabel;
    private JLabel NewRecordLabel;
    private JButton menuButton;
    private JButton NewGameButton;
    private JPanel principalPanel;
    private JPanel tituloPanel;
    private JPanel bodyPanel;
    private JPanel inferiorPanel;
    private JLabel puntuacionNumber;
    private final PresentationController ctrl = new PresentationController();


    public FinPartida() {
        inicar();
        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ctrl.changeWindowToPrincipalMenu(ctrl.getUsername());
                dispose();
            }
        });

        NewGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ctrl.changeWindowToCrearPartida();
                dispose();
            }
        });
    }

    void inicar(){
        setContentPane(principalPanel);
        puntuacionNumber.setText(Integer.toString(ctrl.getPuntuacion()));
        if (ctrl.consultPR(ctrl.getUsername()).size() < 5 || ctrl.getPuntuacion() > ctrl.consultPR(ctrl.getUsername()).get(4).getPoints())
            NewRecordLabel.setVisible(true);
        ctrl.finPartida();
    }

}
