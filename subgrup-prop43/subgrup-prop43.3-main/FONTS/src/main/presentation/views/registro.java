package FONTS.src.main.presentation.views;

import FONTS.src.main.presentation.controllers.PresentationController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class registro extends JFrame {

    private JButton volverButton;
    private JTextField textField1;
    private JLabel contrasenaLabel;
    private JButton enviarButton;
    private JLabel registroLabel;
    private JPanel panel1;
    private JPasswordField passwordField1;
    private JLabel nombre;
    private final PresentationController ctrl = new PresentationController();


    public registro() {

        setContentPane(panel1);

        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ctrl.changeWindowToStartMenu();
                dispose();
            }
        });

        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = textField1.getText();
                String password = new String(passwordField1.getPassword());
                boolean correcto = ctrl.signIn(username, password);
                if (correcto)
                {
                    ctrl.changeWindowToStartMenu();
                    dispose();
                }
                else JOptionPane.showMessageDialog(null, "Ya existe un usuario con ese nombre, prueba otra vez");
            }
        });
    }
}
