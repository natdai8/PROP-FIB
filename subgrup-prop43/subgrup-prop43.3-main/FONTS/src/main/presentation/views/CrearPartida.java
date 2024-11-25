package FONTS.src.main.presentation.views;

import FONTS.src.main.domain.classes.enums.Colour;
import FONTS.src.main.presentation.controllers.PresentationController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CrearPartida extends JFrame{
    private JLabel instruccionesLabel;
    private JPanel tituloPanel;
    private JButton VolverButton;
    private JButton CrearButton;
    private JPanel principalPanel;
    private JTextField nombreTextField;
    private JComboBox dificultadComboBox;
    private JButton OpcionesButton;
    private JPanel opcionesPredeterminadasPanel;
    private JPanel opcionesAvanzadasPanel;
    private JCheckBox repeticionesCheckbox;
    private JCheckBox blanksCheckbox;
    private JComboBox rolComboBox;
    private JSpinner spinnerTurnos;
    private JSpinner spinnerIntentos;
    private JCheckBox cyanCheckBox;
    private JCheckBox magentaCheckBox;
    private JCheckBox turquesaCheckBox;
    private JButton predeterminadasButton;
    private JButton geneticButton;
    private JButton fiveGuessButton;
    private JLabel errorNombreVacio;
    private JLabel errorNombreRepetido;
    private JLabel tituloLabel;
    private JPanel inferiorPanel;
    private JPanel bodyPanel;
    private JPanel staticPanel;
    private JPanel dynamicPanel;
    private JLabel nombreLabel;
    private JLabel iaLabel;
    private JLabel repeticionesLabel;
    private JLabel blanksLabel;
    private JLabel rolLabel;
    private JLabel turnosLabel;
    private JLabel tryLabel;
    private JLabel coloresLabel;
    private JLabel dificultadLabel;

    private final PresentationController ctrl = new PresentationController();
    private boolean pred = true;
    private boolean ia = true; //true is fiveguess, false is generic

    public CrearPartida() {
        iniciar();
        VolverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ctrl.changeWindowToPrincipalMenu(ctrl.getUsername());
                dispose();
            }
        });

        CrearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Objects.equals(nombreTextField.getText(), "")) {
                    errorNombreVacio.setVisible(true);
                    errorNombreRepetido.setVisible(false);
                } else if (ctrl.checkPartidas(nombreTextField.getText()) > -1) {
                    errorNombreRepetido.setVisible(true);
                    errorNombreVacio.setVisible(false);
                } else {
                    errorNombreVacio.setVisible(false);
                    errorNombreRepetido.setVisible(false);
                    ctrl.new_game(ctrl.getUsername(), nombreTextField.getText());
                    if(pred) {
                        config_game(dificultadComboBox.getSelectedItem().toString().toUpperCase());
                    } else {
                        config_game();
                    }
                    ctrl.setIA(ia);

                    ctrl.save_game();
                    ctrl.changeWindowToStartPlay(0);
                    dispose();
                }
            }

        });
        OpcionesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                opcionesPredeterminadasPanel.setVisible(false);
                opcionesAvanzadasPanel.setVisible(true);
                pred = false;
            }
        });
        predeterminadasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                opcionesPredeterminadasPanel.setVisible(true);
                opcionesAvanzadasPanel.setVisible(false);
                pred = true;
            }
        });

        geneticButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ia) {
                    ia = false;
                    fiveGuessButton.setBackground(geneticButton.getBackground());
                    fiveGuessButton.enable();
                    geneticButton.setBackground(Color.LIGHT_GRAY);
                    geneticButton.disable();
                }
            }
        });

        fiveGuessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!ia) {
                    ia = true;
                    geneticButton.setBackground(fiveGuessButton.getBackground());
                    geneticButton.enable();
                    fiveGuessButton.setBackground(Color.LIGHT_GRAY);
                    fiveGuessButton.disable();
                }

            }
        });


    }
    private void iniciar() {
        setContentPane(principalPanel);
        dificultadComboBox.addItem("Facil");
        dificultadComboBox.addItem("Medio");
        dificultadComboBox.addItem("Dificil");
        ((JSpinner.DefaultEditor) spinnerTurnos.getEditor()).getTextField().setEditable(false);
        ((JSpinner.DefaultEditor) spinnerIntentos.getEditor()).getTextField().setEditable(false);
        rolComboBox.addItem("CodeMaker");
        rolComboBox.addItem("CodeBreaker");
        opcionesPredeterminadasPanel.setVisible(true);
        opcionesAvanzadasPanel.setVisible(false);
        fiveGuessButton.setBackground(Color.LIGHT_GRAY);
        fiveGuessButton.disable();
        errorNombreRepetido.setVisible(false);
        errorNombreVacio.setVisible(false);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        spinnerIntentos = new JSpinner(new SpinnerNumberModel(1, 1, 12, 1));
        spinnerTurnos = new JSpinner(new SpinnerNumberModel(2, 2, 10, 2));
    }

    private void config_game(String dif) {
        List<Colour> Extra = new ArrayList<>();
        switch (dif){
            case "MEDIO":
                ctrl.setIntentos(10);
                Extra.add(Colour.TURQUESA);
                ctrl.setColoresExtra(Extra);
                ctrl.setRepFalse();
                ctrl.setBlkTrue();
                if(ia) ctrl.iniciar_FiveG();
                else ctrl.iniciar_Genetic();
                return;
            case "DIFICIL":
                ctrl.setIntentos(8);
                Extra.add(Colour.TURQUESA);
                Extra.add(Colour.CYAN);
                ctrl.setColoresExtra(Extra);
                ctrl.setRepTrue();
                ctrl.setBlkTrue();
                if(ia) ctrl.iniciar_FiveG();
                else ctrl.iniciar_Genetic();
                return;
        }
    }
    private void config_game() {
        if (repeticionesCheckbox.isSelected()) ctrl.setRepTrue();
        else ctrl.setRepFalse();
        if (blanksCheckbox.isSelected()) ctrl.setBlkTrue();
        else ctrl.setBlkFalse();
        ctrl.setHuman(rolComboBox.getSelectedItem().toString().toUpperCase().equals("CODEMAKER"));
        ctrl.setTurnos((Integer) spinnerTurnos.getValue());
        ctrl.setIntentos((Integer) spinnerIntentos.getValue());
        List<Colour> Extra = new ArrayList<>();
        if (cyanCheckBox.isSelected()) Extra.add(Colour.CYAN);
        if (magentaCheckBox.isSelected()) Extra.add(Colour.MAGENTA);
        if (turquesaCheckBox.isSelected()) Extra.add(Colour.TURQUESA);
        ctrl.setColoresExtra(Extra);

    }

}
