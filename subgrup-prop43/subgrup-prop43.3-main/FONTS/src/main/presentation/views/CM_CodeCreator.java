package FONTS.src.main.presentation.views;

import FONTS.src.main.domain.classes.enums.Colour;
import FONTS.src.main.presentation.controllers.PresentationController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class CM_CodeCreator extends JFrame {
    private JPanel panel1;
    private JButton code1;
    private JButton code4;
    private JButton code2;
    private JButton code3;
    private JButton colorVerde;
    private JButton colorNaranja;
    private JButton colorAzul;
    private JButton colorRojo;
    private JButton colorLila;
    private JButton colorAmarillo;
    private JButton crearCodigoButton;
    private JButton normasButton;
    private JButton resetButton;
    private JButton colorCyan;
    private JButton colorTurquesa;
    private JButton colorMagenta;
    private JButton cancelarButton;

    private PresentationController pc = new PresentationController();

    private int botonPulsado = 0;
    List<Colour> code = new ArrayList<>(4);

    public CM_CodeCreator(int numColores) {

        setContentPane(panel1);
        code.add(Colour.VACIO);
        code.add(Colour.VACIO);
        code.add(Colour.VACIO);
        code.add(Colour.VACIO);
        colorCyan.setVisible(false);
        colorTurquesa.setVisible(false);
        colorMagenta.setVisible(false);

        List<Colour> coloresDisp = pc.getColoresExtra();

        for (Colour c : coloresDisp)
        {
            if (c == Colour.CYAN)
                colorCyan.setVisible(true);
            if (c == Colour.TURQUESA)
                colorTurquesa.setVisible(true);
            if (c == Colour.MAGENTA)
                colorMagenta.setVisible(true);
        }


        code1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                code1.setBackground(Color.LIGHT_GRAY);
                if (code2.getBackground() == Color.LIGHT_GRAY)
                    code2.setBackground(Color.WHITE);
                if (code3.getBackground() == Color.LIGHT_GRAY)
                    code3.setBackground(Color.WHITE);
                if (code4.getBackground() == Color.LIGHT_GRAY)
                    code4.setBackground(Color.WHITE);
                botonPulsado = 1;
                code.set(0, Colour.VACIO);

            }
        });

        code2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                code2.setBackground(Color.LIGHT_GRAY);
                if (code1.getBackground() == Color.LIGHT_GRAY)
                    code1.setBackground(Color.WHITE);
                if (code3.getBackground() == Color.LIGHT_GRAY)
                    code3.setBackground(Color.WHITE);
                if (code4.getBackground() == Color.LIGHT_GRAY)
                    code4.setBackground(Color.WHITE);
                botonPulsado = 2;
                code.set(1, Colour.VACIO);
            }
        });

        code3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                code3.setBackground(Color.LIGHT_GRAY);
                if (code1.getBackground() == Color.LIGHT_GRAY)
                    code1.setBackground(Color.WHITE);
                if (code2.getBackground() == Color.LIGHT_GRAY)
                    code2.setBackground(Color.WHITE);
                if (code4.getBackground() == Color.LIGHT_GRAY)
                    code4.setBackground(Color.WHITE);;
                botonPulsado = 3;
                code.set(2, Colour.VACIO);
            }
        });

        code4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                code4.setBackground(Color.LIGHT_GRAY);
                if (code1.getBackground() == Color.LIGHT_GRAY)
                    code1.setBackground(Color.WHITE);
                if (code3.getBackground() == Color.LIGHT_GRAY)
                    code3.setBackground(Color.WHITE);
                if (code2.getBackground() == Color.LIGHT_GRAY)
                    code2.setBackground(Color.WHITE);
                botonPulsado = 4;
                code.set(3, Colour.VACIO);
            }
        });

        colorVerde.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (botonPulsado == 1) {
                    code1.setBackground(colorVerde.getBackground());
                    code.set(0, Colour.VERDE);
                }
                else if (botonPulsado == 2) {
                    code2.setBackground(colorVerde.getBackground());
                    code.set(1, Colour.VERDE);
                }
                else if (botonPulsado == 3) {
                    code3.setBackground(colorVerde.getBackground());
                    code.set(2, Colour.VERDE);
                }
                else if (botonPulsado == 4) {
                    code4.setBackground(colorVerde.getBackground());
                    code.set(3, Colour.VERDE);
                }
                botonPulsado = 0;
            }
        });

        colorNaranja.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (botonPulsado == 1) {
                    code1.setBackground(colorNaranja.getBackground());
                    code.set(0, Colour.NARANJA);
                }
                else if (botonPulsado == 2) {
                    code2.setBackground(colorNaranja.getBackground());
                    code.set(1, Colour.NARANJA);
                }
                else if (botonPulsado == 3) {
                    code3.setBackground(colorNaranja.getBackground());
                    code.set(2, Colour.NARANJA);
                }
                else if (botonPulsado == 4) {
                    code4.setBackground(colorNaranja.getBackground());
                    code.set(3, Colour.NARANJA);
                }
                botonPulsado = 0;
            }
        });

        colorAzul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (botonPulsado == 1) {
                    code1.setBackground(colorAzul.getBackground());
                    code.set(0, Colour.AZUL);
                }
                else if (botonPulsado == 2) {
                    code2.setBackground(colorAzul.getBackground());
                    code.set(1, Colour.AZUL);
                }
                else if (botonPulsado == 3) {
                    code3.setBackground(colorAzul.getBackground());
                    code.set(2, Colour.AZUL);
                }
                else if (botonPulsado == 4) {
                    code4.setBackground(colorAzul.getBackground());
                    code.set(3, Colour.AZUL);
                }
                botonPulsado = 0;
            }
        });

        colorRojo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (botonPulsado == 1) {
                    code1.setBackground(colorRojo.getBackground());
                    code.set(0, Colour.ROJO);
                }
                else if (botonPulsado == 2) {
                    code2.setBackground(colorRojo.getBackground());
                    code.set(1, Colour.ROJO);
                }
                else if (botonPulsado == 3) {
                    code3.setBackground(colorRojo.getBackground());
                    code.set(2, Colour.ROJO);
                }
                else if (botonPulsado == 4) {
                    code4.setBackground(colorRojo.getBackground());
                    code.set(3, Colour.ROJO);
                }
                botonPulsado = 0;
            }
        });

        colorLila.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (botonPulsado == 1) {
                    code1.setBackground(colorLila.getBackground());
                    code.set(0, Colour.LILA);
                }
                else if (botonPulsado == 2) {
                    code2.setBackground(colorLila.getBackground());
                    code.set(1, Colour.LILA);
                }
                else if (botonPulsado == 3) {
                    code3.setBackground(colorLila.getBackground());
                    code.set(2, Colour.LILA);
                }
                else if (botonPulsado == 4) {
                    code4.setBackground(colorLila.getBackground());
                    code.set(3, Colour.LILA);
                }
                botonPulsado = 0;
            }
        });

        colorAmarillo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (botonPulsado == 1) {
                    code1.setBackground(colorAmarillo.getBackground());
                    code.set(0, Colour.AMARILLO);
                }
                else if (botonPulsado == 2) {
                    code2.setBackground(colorAmarillo.getBackground());
                    code.set(1, Colour.AMARILLO);
                }
                else if (botonPulsado == 3) {
                    code3.setBackground(colorAmarillo.getBackground());
                    code.set(2, Colour.AMARILLO);
                }
                else if (botonPulsado == 4) {
                    code4.setBackground(colorAmarillo.getBackground());
                    code.set(3, Colour.AMARILLO);
                }
                botonPulsado = 0;
            }
        });

        colorCyan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (botonPulsado == 1) {
                    code1.setBackground(colorCyan.getBackground());
                    code.set(0, Colour.CYAN);
                }
                else if (botonPulsado == 2) {
                    code2.setBackground(colorCyan.getBackground());
                    code.set(1, Colour.CYAN);
                }
                else if (botonPulsado == 3) {
                    code3.setBackground(colorCyan.getBackground());
                    code.set(2, Colour.CYAN);
                }
                else if (botonPulsado == 4) {
                    code4.setBackground(colorCyan.getBackground());
                    code.set(3, Colour.CYAN);
                }
                botonPulsado = 0;
            }
        });

        colorTurquesa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (botonPulsado == 1) {
                    code1.setBackground(colorTurquesa.getBackground());
                    code.set(0, Colour.TURQUESA);
                }
                else if (botonPulsado == 2) {
                    code2.setBackground(colorTurquesa.getBackground());
                    code.set(1, Colour.TURQUESA);
                }
                else if (botonPulsado == 3) {
                    code3.setBackground(colorTurquesa.getBackground());
                    code.set(2, Colour.TURQUESA);
                }
                else if (botonPulsado == 4) {
                    code4.setBackground(colorTurquesa.getBackground());
                    code.set(3, Colour.TURQUESA);
                }
                botonPulsado = 0;
            }
        });

        colorMagenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (botonPulsado == 1) {
                    code1.setBackground(colorMagenta.getBackground());
                    code.set(0, Colour.MAGENTA);
                }
                else if (botonPulsado == 2) {
                    code2.setBackground(colorMagenta.getBackground());
                    code.set(1, Colour.MAGENTA);
                }
                else if (botonPulsado == 3) {
                    code3.setBackground(colorMagenta.getBackground());
                    code.set(2, Colour.MAGENTA);
                }
                else if (botonPulsado == 4) {
                    code4.setBackground(colorMagenta.getBackground());
                    code.set(3, Colour.MAGENTA);
                }
                botonPulsado = 0;
            }
        });

        crearCodigoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (pc.checkIntento(code)) {
                    pc.iniciar_CMHuman(code);
                    try {
                        pc.changeWindowToPlayCM();
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    dispose();
                }
                else {
                    JOptionPane.showMessageDialog(null, "ERROR: Codigo incorrecto, comprueba las normas");
                }
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                code.set(0, Colour.VACIO);
                code.set(1, Colour.VACIO);
                code.set(2, Colour.VACIO);
                code.set(3, Colour.VACIO);
                code1.setBackground(Color.WHITE);
                code2.setBackground(Color.WHITE);
                code3.setBackground(Color.WHITE);
                code4.setBackground(Color.WHITE);
                botonPulsado = 0;
            }
        });


        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pc.changeWindowToPrincipalMenu(pc.getUsername());
                dispose();
            }
        });
        normasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pc.openWindowNormas();
            }
        });
    }
}
