package FONTS.src.main.presentation.views;

import FONTS.src.main.presentation.controllers.PresentationController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmpezarTurno  extends JFrame {
    private JButton empezarTurnoButton;
    private JButton salirDelJuegoButton;
    private JLabel puntuacion;
    private JLabel rol;
    private JPanel panel1;
    private JLabel status;

    private final PresentationController ctrl = new PresentationController();

    public EmpezarTurno(int statusPrev)
    {
        setContentPane(panel1);
        if (ctrl.isCMhuman()) rol.setText("Vas a jugar como Codemaker");
        else rol.setText("Vas a jugar como Codebreaker");

        if (statusPrev == -1) {
            status.setText("Vaya... Parece que no conseguiste adivinar el codigo secreto de antes.");
            rol.setText("Ahora vas a jugar como Codemaker");
        }
        else if (statusPrev == -2)
        {
            status.setText("Muy bien!! El Codebreaker no pudo acertar el codigo secreto.");
            rol.setText("Ahora vas a jugar como Codemaker");
        }else if (statusPrev == 1)
        {
            status.setText("Muy bien!! Conseguiste acertar el codigo secreto.");
            rol.setText("Ahora vas a jugar como Codemaker");
        }else if (statusPrev == 2)
        {
            status.setText("Vaya... Parece que el Codebreaker pudo adivinar tu codigo.");
            rol.setText("Ahora vas a jugar como Codebreaker");
        }


        puntuacion.setText(String.valueOf(ctrl.getPuntuacion(ctrl.checkPartidas(ctrl.getNombre()))));
        empezarTurnoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ctrl.changeWindowToPlay();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                dispose();
            }
        });
        salirDelJuegoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ctrl.changeWindowToPrincipalMenu(ctrl.getUsername());
                dispose();
            }
        });
    }
}
