package FONTS.src.main.presentation.views;

import FONTS.src.main.presentation.controllers.PresentationController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class normas extends JFrame{
    private JButton volverButton;
    private JTextArea textArea;
    private JPanel principalPanel;
    private JPanel tituloPanel;
    private JLabel tituloLabel;
    private JPanel inferiorPanel;
    private JPanel bodyPanel;
    private JScrollPane scrollPane;
    private JPanel normasPanel;
    private JPanel parametrosPanel;
    private JPanel staticPanel;
    private JButton parametrosButton;
    private JButton normasButton;
    private JLabel numTurnosLabel;
    private JLabel numIntentosLabel;
    private JLabel rolLabel;
    private JLabel repLabel;
    private JLabel blkLabel;
    private JButton recargarButton;

    private final PresentationController ctrl = new PresentationController();

    public normas() {
        iniciar();
        recargarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cargar_valores();
            }
        });
        normasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parametrosButton.setBackground(normasButton.getBackground());
                normasButton.setBackground(Color.LIGHT_GRAY);
                normasPanel.setVisible(true);
                parametrosPanel.setVisible(false);
            }
        });

        parametrosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                normasButton.setBackground(parametrosButton.getBackground());
                parametrosButton.setBackground(Color.LIGHT_GRAY);
                parametrosPanel.setVisible(true);
                normasPanel.setVisible(false);
            }
        });

        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ctrl.closeWindowNormas();
            }
        });
    }

    private void iniciar(){
        setContentPane(principalPanel);
        normasPanel.setVisible(true);
        parametrosPanel.setVisible(false);
        cargar_valores();
        normasButton.setBackground(Color.LIGHT_GRAY);
    }

    public void cargar_valores() {
        if (!ctrl.partida_ended()) {
            numTurnosLabel.setText(Integer.toString(ctrl.getTurnos()));
            numIntentosLabel.setText(Integer.toString(ctrl.getIntentos()));
            rolLabel.setText(ctrl.getHumanRol());
            if (ctrl.getRepeticiones()) repLabel.setText("SI");
            else repLabel.setText("NO");
            if (ctrl.getBlanks()) blkLabel.setText("SI");
            else blkLabel.setText("NO");
            String text = "En  Mastermind  compiten  2  jugadores,  uno  de  ellos  creará  un  código oculto  con  " +
                    "4  clavijas  de  colores,  pudiendo  hacer  las  combinaciones  con  los  " + ctrl.getColores().size()+
                    " colores disponibles";
            if (ctrl.getRepeticiones() || ctrl.getBlanks()){
                text += "e incluso ";
                if (ctrl.getRepeticiones()) {
                    text += "repitiendo color ";
                    if (ctrl.getBlanks()) text += "y ";
                }
                if (ctrl.getBlanks()) text += "pudiendo dejar espacios en blanco ";
            }
            text += " si lo desea.  El  oponente  deberá  acertar  en  el  menor  número  posible  de jugadas  la  clave  para  obtener  una  buena  puntuación.   Para  descifrar  el  código secreto de  colores  el  jugador  deberá  ir  probando  combinaciones  aleatorias  de  colores, y en cada combinación, el jugador contrario debe darle pistas mediante las espigas blancas y negras.  Por cada clavija acertada en color y posición, colocará una espiga negra, y  por  cada  color  acertado  pero  en  un  lugar  equivocado  colocara  una  espiga blanca. \n \n   PUNTUACIÓN  La forma de puntuación es bastante sencilla: Cada  jugador  ganarà puntos segun su rol. Si es CodeMaker, el jugador obtendrà un número fijo de puntos según los parametros de la partida por cada fallo que tenga el CodeBreaker. Si el jugador es CodeBreaker, empezará con la máxima puntuación y se le irán reduciendo esa misma cantidad de puntos por intento que falle.   Al final de cada turno, el jugador se le añadirà los puntos de ese turno a la puntuación global de la partida. Los  jugadores  se alternarán  para  crear  el  código  secreto  e  irán  sumando  sus  puntuaciones  hasta terminar la partida. ";
            textArea.setText(text);
        }
    }
}
