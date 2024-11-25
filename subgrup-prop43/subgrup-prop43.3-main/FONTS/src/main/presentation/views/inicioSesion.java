package FONTS.src.main.presentation.views;
import FONTS.src.main.presentation.controllers.PresentationController;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class inicioSesion extends JFrame {

    private JPanel panel1;
    private JButton volverButton;
    private JTextField textField1;
    private JButton enviarButton;
    private JLabel iniciarSesionLabel;
    private JLabel contrasenaLabel;
    private JPasswordField passwordField1;
    private JLabel nombreLabel;
    private final PresentationController ctrl = new PresentationController();


    public inicioSesion() {

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
                boolean correcto = ctrl.logIn(username, password);
                if (correcto)
                {
                    ctrl.changeWindowToPrincipalMenu(ctrl.getUsername());
                    dispose();
                }
                else JOptionPane.showMessageDialog(null, "Nombre y/o contraseña incorrectos, vuelve a probar");
            }
        });
    }
}

