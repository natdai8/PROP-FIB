package FONTS.src.main.presentation.views;

import FONTS.src.main.domain.classes.enums.Colour;
import FONTS.src.main.presentation.controllers.PresentationController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class CB_tablero extends JFrame {
    private JPanel panel1;
    private JButton codigo11;
    private JButton codigo14;
    private JButton codigo12;
    private JButton codigo13;
    private JButton peg11;
    private JButton peg12;
    private JButton peg13;
    private JButton peg14;
    private JButton colorLila;
    private JButton colorNaranja;
    private JButton colorTurquesa;
    private JButton colorMagenta;
    private JButton enterSolutionButton;
    private JButton normasButton;
    private JButton pistaButton;
    private JButton codigo21;
    private JButton codigo22;
    private JButton codigo23;
    private JButton codigo24;
    private JButton codigo31;
    private JButton codigo32;
    private JButton codigo33;
    private JButton codigo34;
    private JButton codigo41;
    private JButton codigo42;
    private JButton codigo43;
    private JButton codigo44;
    private JButton codigo51;
    private JButton codigo52;
    private JButton codigo53;
    private JButton codigo54;
    private JButton codigo61;
    private JButton codigo62;
    private JButton codigo63;
    private JButton codigo64;
    private JButton codigo71;
    private JButton codigo72;
    private JButton codigo73;
    private JButton codigo74;
    private JButton codigo81;
    private JButton codigo82;
    private JButton codigo83;
    private JButton codigo84;
    private JButton codigo91;
    private JButton codigo92;
    private JButton codigo93;
    private JPanel intento9;
    private JButton codigo101;
    private JButton codigo102;
    private JButton codigo103;
    private JButton codigo104;
    private JButton codigo111;
    private JButton codigo112;
    private JButton codigo113;
    private JButton codigo114;
    private JButton codigo121;
    private JButton codigo122;
    private JButton codigo123;
    private JButton codigo124;
    private JButton colorVerde;
    private JButton colorRojo;
    private JButton colorAzul;
    private JButton colorAmarillo;
    private JButton colorCyan;
    private JLabel valorPuntuacion;
    private JButton codigo94;
    private JPanel intento10;
    private JPanel intento8;
    private JPanel intento7;
    private JPanel intento6;
    private JPanel intento5;
    private JPanel intento4;
    private JPanel intento3;
    private JPanel intento2;
    private JPanel intento11;
    private JPanel intento12;
    private JPanel intento1;
    private JButton code1;
    private JButton code2;
    private JButton code3;
    private JButton code4;
    private JButton resetButton;
    private JLabel labelIntento1;
    private JLabel labelIntento2;
    private JLabel labelIntento3;
    private JLabel labelIntento4;
    private JLabel labelIntento5;
    private JLabel labelIntento6;
    private JLabel labelIntento7;
    private JLabel labelIntento8;
    private JLabel labelIntento9;
    private JLabel labelIntento10;
    private JLabel labelIntento11;
    private JLabel labelIntento12;
    private JButton guardarButton;
    private JButton salirButton;
    private JButton peg21;
    private JButton peg22;
    private JButton peg23;
    private JButton peg24;
    private JButton peg31;
    private JButton peg32;
    private JButton peg33;
    private JButton peg34;
    private JButton peg41;
    private JButton peg42;
    private JButton peg43;
    private JButton peg44;
    private JButton peg51;
    private JButton peg52;
    private JButton peg53;
    private JButton peg54;
    private JButton peg61;
    private JButton peg62;
    private JButton peg63;
    private JButton peg64;
    private JButton peg71;
    private JButton peg72;
    private JButton peg73;
    private JButton peg74;
    private JButton peg81;
    private JButton peg82;
    private JButton peg83;
    private JButton peg84;
    private JButton peg91;
    private JButton peg92;
    private JButton peg93;
    private JButton peg94;
    private JButton peg101;
    private JButton peg102;
    private JButton peg103;
    private JButton peg104;
    private JButton peg121;
    private JButton peg122;
    private JButton peg123;
    private JButton peg124;
    private JButton peg111;
    private JButton peg112;
    private JButton peg113;
    private JButton peg114;
    private JSeparator separator1;
    private JSeparator separator2;
    private JSeparator separator3;
    private JSeparator separator4;
    private JSeparator separator5;
    private JSeparator separator6;
    private JSeparator separator7;
    private JSeparator separator8;
    private JSeparator separator9;
    private JSeparator separator10;
    private JSeparator separator11;

    private final PresentationController pc = new PresentationController();

    List<Colour> code = new ArrayList<>(4);
    List<List<Colour>> codigosCB = new Vector<>();
    List<List<Integer>> respuestasCM = new Vector<List<Integer>>();
    int maxSteps, actualSteps;

    private int botonPulsado = 0;

    private final List<List<JButton>> pegsList = new ArrayList<>();
    private final List<JPanel> panelsList = new ArrayList<>();

    private final List<List<JButton>> codesCB = new ArrayList<>();

    private final List<JLabel> labelList = new ArrayList<>();

    private final List<JSeparator> separatorsList = new ArrayList<>();

    private void fillcodeCBLists() {
        List<JButton> tmp = new ArrayList<>();
        tmp.add(codigo11);
        tmp.add(codigo12);
        tmp.add(codigo13);
        tmp.add(codigo14);
        codesCB.add(tmp);
        tmp = new ArrayList<>();
        tmp.add(codigo21);
        tmp.add(codigo22);
        tmp.add(codigo23);
        tmp.add(codigo24);
        codesCB.add(tmp);
        tmp = new ArrayList<>();
        tmp.add(codigo31);
        tmp.add(codigo32);
        tmp.add(codigo33);
        tmp.add(codigo34);
        codesCB.add(tmp);
        tmp = new ArrayList<>();
        tmp.add(codigo41);
        tmp.add(codigo42);
        tmp.add(codigo43);
        tmp.add(codigo44);
        codesCB.add(tmp);
        tmp = new ArrayList<>();
        tmp.add(codigo51);
        tmp.add(codigo52);
        tmp.add(codigo53);
        tmp.add(codigo54);
        codesCB.add(tmp);
        tmp = new ArrayList<>();
        tmp.add(codigo61);
        tmp.add(codigo62);
        tmp.add(codigo63);
        tmp.add(codigo64);
        codesCB.add(tmp);
        tmp = new ArrayList<>();
        tmp.add(codigo71);
        tmp.add(codigo72);
        tmp.add(codigo73);
        tmp.add(codigo74);
        codesCB.add(tmp);
        tmp = new ArrayList<>();
        tmp.add(codigo81);
        tmp.add(codigo82);
        tmp.add(codigo83);
        tmp.add(codigo84);
        codesCB.add(tmp);
        tmp = new ArrayList<>();
        tmp.add(codigo91);
        tmp.add(codigo92);
        tmp.add(codigo93);
        tmp.add(codigo94);
        codesCB.add(tmp);
        tmp = new ArrayList<>();
        tmp.add(codigo101);
        tmp.add(codigo102);
        tmp.add(codigo103);
        tmp.add(codigo104);
        codesCB.add(tmp);
        tmp = new ArrayList<>();
        tmp.add(codigo111);
        tmp.add(codigo112);
        tmp.add(codigo113);
        tmp.add(codigo114);
        codesCB.add(tmp);
        tmp = new ArrayList<>();
        tmp.add(codigo121);
        tmp.add(codigo122);
        tmp.add(codigo123);
        tmp.add(codigo124);
        codesCB.add(tmp);
    }

    private void fillpegsLists() {
        List<JButton> tmp = new ArrayList<>();
        tmp.add(peg11);
        tmp.add(peg12);
        tmp.add(peg13);
        tmp.add(peg14);
        pegsList.add(tmp);
        tmp = new ArrayList<>();
        tmp.add(peg21);
        tmp.add(peg22);
        tmp.add(peg23);
        tmp.add(peg24);
        pegsList.add(tmp);
        tmp = new ArrayList<>();
        tmp.add(peg31);
        tmp.add(peg32);
        tmp.add(peg33);
        tmp.add(peg34);
        pegsList.add(tmp);
        tmp = new ArrayList<>();
        tmp.add(peg41);
        tmp.add(peg42);
        tmp.add(peg43);
        tmp.add(peg44);
        pegsList.add(tmp);
        tmp = new ArrayList<>();
        tmp.add(peg51);
        tmp.add(peg52);
        tmp.add(peg53);
        tmp.add(peg54);
        pegsList.add(tmp);
        tmp = new ArrayList<>();
        tmp.add(peg61);
        tmp.add(peg62);
        tmp.add(peg63);
        tmp.add(peg64);
        pegsList.add(tmp);
        tmp = new ArrayList<>();
        tmp.add(peg71);
        tmp.add(peg72);
        tmp.add(peg73);
        tmp.add(peg74);
        pegsList.add(tmp);
        tmp = new ArrayList<>();
        tmp.add(peg81);
        tmp.add(peg82);
        tmp.add(peg83);
        tmp.add(peg84);
        pegsList.add(tmp);
        tmp = new ArrayList<>();
        tmp.add(peg91);
        tmp.add(peg92);
        tmp.add(peg93);
        tmp.add(peg94);
        pegsList.add(tmp);
        tmp = new ArrayList<>();
        tmp.add(peg101);
        tmp.add(peg102);
        tmp.add(peg103);
        tmp.add(peg104);
        pegsList.add(tmp);
        tmp = new ArrayList<>();
        tmp.add(peg111);
        tmp.add(peg112);
        tmp.add(peg113);
        tmp.add(peg114);
        pegsList.add(tmp);
        tmp = new ArrayList<>();
        tmp.add(peg121);
        tmp.add(peg122);
        tmp.add(peg123);
        tmp.add(peg124);
        pegsList.add(tmp);
    }

    private void fillJpanelList() {
        panelsList.add(intento1);
        panelsList.add(intento2);
        panelsList.add(intento3);
        panelsList.add(intento4);
        panelsList.add(intento5);
        panelsList.add(intento6);
        panelsList.add(intento7);
        panelsList.add(intento8);
        panelsList.add(intento9);
        panelsList.add(intento10);
        panelsList.add(intento11);
        panelsList.add(intento12);
    }

    private void fillJlabelList() {
        labelList.add(labelIntento1);
        labelList.add(labelIntento2);
        labelList.add(labelIntento3);
        labelList.add(labelIntento4);
        labelList.add(labelIntento5);
        labelList.add(labelIntento6);
        labelList.add(labelIntento7);
        labelList.add(labelIntento8);
        labelList.add(labelIntento9);
        labelList.add(labelIntento10);
        labelList.add(labelIntento11);
        labelList.add(labelIntento12);
    }

    private void fillJSeparatorlList() {
        separatorsList.add(separator1);
        separatorsList.add(separator2);
        separatorsList.add(separator3);
        separatorsList.add(separator4);
        separatorsList.add(separator5);
        separatorsList.add(separator6);
        separatorsList.add(separator7);
        separatorsList.add(separator8);
        separatorsList.add(separator9);
        separatorsList.add(separator10);
        separatorsList.add(separator11);
    }

    public CB_tablero(int numColores) throws Exception {
        setContentPane(panel1);
        code.add(Colour.VACIO);
        code.add(Colour.VACIO);
        code.add(Colour.VACIO);
        code.add(Colour.VACIO);

        if (numColores == 6) {
            colorCyan.setVisible(false);
            colorTurquesa.setVisible(false);
            colorMagenta.setVisible(false);
        } else if (numColores == 7) {
            colorTurquesa.setVisible(false);
            colorMagenta.setVisible(false);
        } else if (numColores == 8) {
            colorMagenta.setVisible(false);
        }

        actualSteps = pc.getTurno_actualStep();
        maxSteps = pc.getIntentos();

        fillcodeCBLists();
        fillJpanelList();
        fillpegsLists();
        fillJlabelList();
        fillJSeparatorlList();

        if (actualSteps != 0)
        {
            for (int i = 0; i < actualSteps; ++i) {
                updateaTablero(pc.getIntentoCM(i), i, pc.getIntentoCB(i));
            }
        }

        valorPuntuacion.setText(String.valueOf(pc.getPossiblePuntuationCB()));

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
                    code4.setBackground(Color.WHITE);
                ;
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
                } else if (botonPulsado == 2) {
                    code2.setBackground(colorVerde.getBackground());
                    code.set(1, Colour.VERDE);
                } else if (botonPulsado == 3) {
                    code3.setBackground(colorVerde.getBackground());
                    code.set(2, Colour.VERDE);
                } else if (botonPulsado == 4) {
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
                } else if (botonPulsado == 2) {
                    code2.setBackground(colorNaranja.getBackground());
                    code.set(1, Colour.NARANJA);
                } else if (botonPulsado == 3) {
                    code3.setBackground(colorNaranja.getBackground());
                    code.set(2, Colour.NARANJA);
                } else if (botonPulsado == 4) {
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
                } else if (botonPulsado == 2) {
                    code2.setBackground(colorAzul.getBackground());
                    code.set(1, Colour.AZUL);
                } else if (botonPulsado == 3) {
                    code3.setBackground(colorAzul.getBackground());
                    code.set(2, Colour.AZUL);
                } else if (botonPulsado == 4) {
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
                } else if (botonPulsado == 2) {
                    code2.setBackground(colorRojo.getBackground());
                    code.set(1, Colour.ROJO);
                } else if (botonPulsado == 3) {
                    code3.setBackground(colorRojo.getBackground());
                    code.set(2, Colour.ROJO);
                } else if (botonPulsado == 4) {
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
                } else if (botonPulsado == 2) {
                    code2.setBackground(colorLila.getBackground());
                    code.set(1, Colour.LILA);
                } else if (botonPulsado == 3) {
                    code3.setBackground(colorLila.getBackground());
                    code.set(2, Colour.LILA);
                } else if (botonPulsado == 4) {
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
                } else if (botonPulsado == 2) {
                    code2.setBackground(colorAmarillo.getBackground());
                    code.set(1, Colour.AMARILLO);
                } else if (botonPulsado == 3) {
                    code3.setBackground(colorAmarillo.getBackground());
                    code.set(2, Colour.AMARILLO);
                } else if (botonPulsado == 4) {
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
                } else if (botonPulsado == 2) {
                    code2.setBackground(colorCyan.getBackground());
                    code.set(1, Colour.CYAN);
                } else if (botonPulsado == 3) {
                    code3.setBackground(colorCyan.getBackground());
                    code.set(2, Colour.CYAN);
                } else if (botonPulsado == 4) {
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
                } else if (botonPulsado == 2) {
                    code2.setBackground(colorTurquesa.getBackground());
                    code.set(1, Colour.TURQUESA);
                } else if (botonPulsado == 3) {
                    code3.setBackground(colorTurquesa.getBackground());
                    code.set(2, Colour.TURQUESA);
                } else if (botonPulsado == 4) {
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
                } else if (botonPulsado == 2) {
                    code2.setBackground(colorMagenta.getBackground());
                    code.set(1, Colour.MAGENTA);
                } else if (botonPulsado == 3) {
                    code3.setBackground(colorMagenta.getBackground());
                    code.set(2, Colour.MAGENTA);
                } else if (botonPulsado == 4) {
                    code4.setBackground(colorMagenta.getBackground());
                    code.set(3, Colour.MAGENTA);
                }
                botonPulsado = 0;
            }
        });

        enterSolutionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (pc.checkIntento(code)) {
                    List<Integer> resp_calc = pc.askForAnswer(code);

                    codigosCB.add(code);
                    respuestasCM.add(resp_calc);

                    List<Colour> cloneCode = new ArrayList<>(code);
                    pc.updateTurno(cloneCode, resp_calc);

                    if (resp_calc.get(0) == 4 || actualSteps + 1 == maxSteps) {
                        pc.addPuntuacio();
                        pc.finTurno();
                        if (resp_calc.get(0) == 4) pc.changeWindowToStartPlay(1);
                        else{ pc.changeWindowToStartPlay(-1);}
                        dispose();
                    } else {
                        updateaTablero(resp_calc, actualSteps, code);
                        ++actualSteps;
                        code.set(0, Colour.VACIO);
                        code.set(1, Colour.VACIO);
                        code.set(2, Colour.VACIO);
                        code.set(3, Colour.VACIO);
                        code1.setBackground(Color.WHITE);
                        code2.setBackground(Color.WHITE);
                        code3.setBackground(Color.WHITE);
                        code4.setBackground(Color.WHITE);
                        valorPuntuacion.setText(String.valueOf(pc.getPossiblePuntuationCB()));
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "ERROR: Respuesta incorrecto, comprueba las normas");
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

        pistaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Colour> pista = pc.getPista();
                if (pista != null) {
                    code1.setBackground(pc.EnumtoColor(pista.get(0)));
                    code2.setBackground(pc.EnumtoColor(pista.get(1)));
                    code3.setBackground(pc.EnumtoColor(pista.get(2)));
                    code4.setBackground(pc.EnumtoColor(pista.get(3)));
                    code = pista;
                }
                else{
                    JOptionPane.showMessageDialog(null, "Ya pediste una pista en este intento");
                }
            }
        });

        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pc.save_game();
                JOptionPane.showMessageDialog(null, "Partida Guardada");
            }
        });


        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
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

    void updateaTablero(List<Integer> resp_calc, int step, List<Colour> code)
    {
        Integer pegsNegras = resp_calc.get(0);
        Integer pegsBlancas = resp_calc.get(1);

        if (step >= 1)
            separatorsList.get(step - 1).setVisible(true);

        panelsList.get(step).setVisible(true);
        labelList.get(step).setVisible(true);

        for (JButton pegs : pegsList.get(step)) {
            if (pegsNegras != 0) {
                pegs.setBackground(Color.BLACK);
                pegs.setVisible(true);
                --pegsNegras;
            } else if (pegsBlancas != 0) {
                pegs.setBackground(Color.WHITE);
                pegs.setVisible(true);
                --pegsBlancas;
            }
        }

        int i = 0;
        for (JButton pegsCB : codesCB.get(step)) {
            pegsCB.setVisible(true);
            pegsCB.setBackground(pc.EnumtoColor(code.get(i)));
            ++i;
        }
    }

}
