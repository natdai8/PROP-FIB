package FONTS.src.main.presentation.views;

import FONTS.src.main.domain.classes.enums.Colour;
import FONTS.src.main.presentation.controllers.PresentationController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CM_tablero extends JFrame {
    private JPanel panel1;
    private JButton normasButton;
    private JButton guardarButton;
    private JButton salirButton;
    private JLabel valorPuntuacion;
    private JButton codeS1;
    private JButton codeS4;
    private JButton codeS2;
    private JButton codeS3;
    private JButton codeB1;
    private JButton codeB2;
    private JButton codeB3;
    private JButton codeB4;
    private JButton code1;
    private JButton code2;
    private JButton code3;
    private JButton code4;
    private JButton enterSolutionButton;
    private JButton resetButton;
    private JPanel intento1;
    private JButton codigo11;
    private JButton codigo14;
    private JButton codigo12;
    private JButton codigo13;
    private JButton peg11;
    private JButton peg12;
    private JButton peg13;
    private JButton peg14;
    private JPanel intento11;
    private JButton codigo111;
    private JButton codigo114;
    private JButton codigo112;
    private JButton codigo113;
    private JButton peg111;
    private JButton peg112;
    private JButton peg113;
    private JButton peg114;
    private JPanel intento12;
    private JButton codigo121;
    private JButton codigo124;
    private JButton codigo122;
    private JButton codigo123;
    private JButton peg121;
    private JButton peg122;
    private JButton peg123;
    private JButton peg124;
    private JPanel intento10;
    private JButton codigo101;
    private JButton codigo104;
    private JButton codigo102;
    private JButton codigo103;
    private JButton peg101;
    private JButton peg102;
    private JButton peg103;
    private JButton peg104;
    private JPanel intento9;
    private JButton codigo91;
    private JButton codigo94;
    private JButton codigo92;
    private JButton codigo93;
    private JButton peg91;
    private JButton peg92;
    private JButton peg93;
    private JButton peg94;
    private JPanel intento8;
    private JButton codigo81;
    private JButton codigo84;
    private JButton codigo82;
    private JButton codigo83;
    private JButton peg81;
    private JButton peg82;
    private JButton peg83;
    private JButton peg84;
    private JPanel intento7;
    private JButton codigo71;
    private JButton codigo74;
    private JButton codigo72;
    private JButton codigo73;
    private JButton peg71;
    private JButton peg72;
    private JButton peg73;
    private JButton peg74;
    private JPanel intento6;
    private JButton codigo61;
    private JButton codigo64;
    private JButton codigo62;
    private JButton codigo63;
    private JButton peg61;
    private JButton peg62;
    private JButton peg63;
    private JButton peg64;
    private JPanel intento5;
    private JButton codigo51;
    private JButton codigo54;
    private JButton codigo52;
    private JButton codigo53;
    private JButton peg51;
    private JButton peg52;
    private JButton peg53;
    private JButton peg54;
    private JPanel intento4;
    private JButton codigo41;
    private JButton codigo44;
    private JButton codigo42;
    private JButton codigo43;
    private JButton peg41;
    private JButton peg42;
    private JButton peg43;
    private JButton peg44;
    private JPanel intento3;
    private JButton codigo31;
    private JButton codigo34;
    private JButton codigo32;
    private JButton codigo33;
    private JButton peg31;
    private JButton peg32;
    private JButton peg33;
    private JButton peg34;
    private JPanel intento2;
    private JButton codigo21;
    private JButton codigo24;
    private JButton codigo22;
    private JButton codigo23;
    private JButton peg21;
    private JButton peg22;
    private JButton peg23;
    private JButton peg24;
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

    int maxSteps, actualSteps;

    List<Colour> cbCode;

    PresentationController pc;

    List<Colour> code = new ArrayList<>(4);

    private final Color grey = new Color(163, 163, 163);

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

    public CM_tablero(int numColores) {

        setContentPane(panel1);
        fillcodeCBLists();
        fillJpanelList();
        fillpegsLists();
        fillJlabelList();
        fillJSeparatorlList();
        pc = new PresentationController();
        actualSteps = pc.getTurno_actualStep();
        maxSteps = pc.getIntentos();

        if (actualSteps != 0)
        {
            for (int i = 0; i < actualSteps; ++i)
            {
                updateaTablero(pc.getIntentoCM(i), i, pc.getIntentoCB(i));
            }
        }

        List<Colour> secretCode = pc.getCodigoSecreto();

        codeS1.setBackground(pc.EnumtoColor(secretCode.get(0)));
        codeS2.setBackground(pc.EnumtoColor(secretCode.get(1)));
        codeS3.setBackground(pc.EnumtoColor(secretCode.get(2)));
        codeS4.setBackground(pc.EnumtoColor(secretCode.get(3)));

        cbCode = pc.getPista();

        codeB1.setBackground(pc.EnumtoColor(cbCode.get(0)));
        codeB2.setBackground(pc.EnumtoColor(cbCode.get(1)));
        codeB3.setBackground(pc.EnumtoColor(cbCode.get(2)));
        codeB4.setBackground(pc.EnumtoColor(cbCode.get(3)));

        code1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (code1.getBackground().getRGB() == grey.getRGB())
                    code1.setBackground(Color.WHITE);
                else if (code1.getBackground() == Color.WHITE)
                    code1.setBackground(Color.BLACK);
                else if (code1.getBackground() == Color.BLACK)
                    code1.setBackground(grey);
            }
        });

        code2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (code2.getBackground().getRGB() == grey.getRGB())
                    code2.setBackground(Color.WHITE);
                else if (code2.getBackground() == Color.WHITE)
                    code2.setBackground(Color.BLACK);
                else if (code2.getBackground() == Color.BLACK)
                    code2.setBackground(grey);
            }
        });

        code3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (code3.getBackground().getRGB() == grey.getRGB())
                    code3.setBackground(Color.WHITE);
                else if (code3.getBackground() == Color.WHITE)
                    code3.setBackground(Color.BLACK);
                else if (code3.getBackground() == Color.BLACK)
                    code3.setBackground(grey);
            }
        });

        code4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (code4.getBackground().getRGB() == grey.getRGB())
                    code4.setBackground(Color.WHITE);
                else if (code4.getBackground() == Color.WHITE)
                    code4.setBackground(Color.BLACK);
                else if (code4.getBackground() == Color.BLACK)
                    code4.setBackground(grey);
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                code.set(0, Colour.VACIO);
                code.set(1, Colour.VACIO);
                code.set(2, Colour.VACIO);
                code.set(3, Colour.VACIO);
                code1.setBackground(grey);
                code2.setBackground(grey);
                code3.setBackground(grey);
                code4.setBackground(grey);
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
            public void actionPerformed(ActionEvent e) {
                pc.changeWindowToPrincipalMenu(pc.getUsername());
                dispose();
            }
        });

        enterSolutionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Integer> codeCMM = pc.askForAnswer(cbCode);
                int blackPegs = 0, whitePegs = 0;

                if (code1.getBackground() == Color.WHITE) ++whitePegs;
                else if (code1.getBackground() == Color.BLACK) ++blackPegs;

                if (code2.getBackground() == Color.WHITE) ++whitePegs;
                else if (code2.getBackground() == Color.BLACK) ++blackPegs;

                if (code3.getBackground() == Color.WHITE) ++whitePegs;
                else if (code3.getBackground() == Color.BLACK) ++blackPegs;

                if (code4.getBackground() == Color.WHITE) ++whitePegs;
                else if (code4.getBackground() == Color.BLACK) ++blackPegs;

                if (codeCMM.get(0) == blackPegs && codeCMM.get(1) == whitePegs) {
                    if (codeCMM.get(0) == 4 || actualSteps + 1 == maxSteps) {
                        pc.finTurno();
                        if (codeCMM.get(0) == 4) pc.changeWindowToStartPlay(2);
                        else pc.changeWindowToStartPlay(-2);
                        dispose();
                    } else {
                        if (actualSteps >= 1)
                            separatorsList.get(actualSteps - 1).setVisible(true);

                        panelsList.get(actualSteps).setVisible(true);
                        labelList.get(actualSteps).setVisible(true);

                        for (JButton pegs : pegsList.get(actualSteps)) {
                            if (blackPegs != 0) {
                                pegs.setBackground(Color.BLACK);
                                pegs.setVisible(true);
                                --blackPegs;
                            } else if (whitePegs != 0) {
                                pegs.setBackground(Color.WHITE);
                                pegs.setVisible(true);
                                --whitePegs;
                            }
                        }

                        int i = 0;
                        for (JButton pegsCB : codesCB.get(actualSteps)) {
                            pegsCB.setVisible(true);
                            pegsCB.setBackground(pc.EnumtoColor(cbCode.get(i)));
                            ++i;
                        }
                        pc.updateTurno(cbCode, codeCMM);
                        pc.addPuntuacio();
                        ++actualSteps;
                        code1.setBackground(grey);
                        code2.setBackground(grey);
                        code3.setBackground(grey);
                        code4.setBackground(grey);
                        valorPuntuacion.setText(String.valueOf(pc.getPuntuacion()));

                        cbCode = pc.getPista();

                        codeB1.setBackground(pc.EnumtoColor(cbCode.get(0)));
                        codeB2.setBackground(pc.EnumtoColor(cbCode.get(1)));
                        codeB3.setBackground(pc.EnumtoColor(cbCode.get(2)));
                        codeB4.setBackground(pc.EnumtoColor(cbCode.get(3)));
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "ERROR: Respuesta incorrecto, comprueba las normas");
                }

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
