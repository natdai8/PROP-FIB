package FONTS.src.main.presentation.views;

import FONTS.src.main.presentation.controllers.PresentationController;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestionarPartidas extends JFrame {
    private JLabel Text;
    private JPanel TextPanel;
    private JTable PartidasTable;
    private JButton cargarButton;
    private JButton volverButton;
    private JButton borrarButton;
    private JPanel panelglobal;
    private JScrollPane scroll;
    private static final PresentationController ctrl = new PresentationController();

    public GestionarPartidas(String username) {
        DefaultTableModel partidas = new DefaultTableModel();
        partidas.addColumn("Nombre partida");
        partidas.addColumn("Puntuación");
        partidas.addColumn("Turno actual");
        partidas.addColumn("Turnos totales");
        partidas.addColumn("Rol actual");

        int size = ctrl.getPartidas_size();
        int puntuacion, turno_act, turnos;
        String rol, nombre;
        for (int i = 0; i < size; ++i){
            if (ctrl.getUsername(i).equals(username)){
                nombre = ctrl.getNombre(i);
                puntuacion = ctrl.getPuntuacion(i);
                turno_act = ctrl.getTurno_act(i);
                turnos = ctrl.getTurnos(i);
                rol = ctrl.getHumanRol(i);
                Object[]rowData = {nombre, puntuacion, turno_act, turnos, rol};
                partidas.addRow(rowData);
            }
        }
        PartidasTable.setModel(partidas);
        PartidasTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        PartidasTable.getRowSelectionAllowed();
        setContentPane(panelglobal);
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ctrl.changeWindowToPrincipalMenu(username);
                dispose();
            }
        });

        cargarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = PartidasTable.getSelectedRow();
                if(row != -1){
                    String name = (String) PartidasTable.getValueAt(row, 0);
                    int idPartida = ctrl.checkPartidas(name);
                    ctrl.load_game(idPartida);
                    ctrl.changeWindowToStartPlay(0);
                    dispose();
                }
                else {
                    JOptionPane.showMessageDialog(null,"Selecciona una partida");
                }

            }
        });

        borrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = PartidasTable.getSelectedRow();
                if(row != -1) {
                    String name = (String) PartidasTable.getValueAt(row, 0);
                    ctrl.delete_game(name);
                    partidas.removeRow(row);
                    PartidasTable.setModel(partidas);
                }
                else {
                    JOptionPane.showMessageDialog(null,"Selecciona una partida");
                }

            }
        });


    }


}
