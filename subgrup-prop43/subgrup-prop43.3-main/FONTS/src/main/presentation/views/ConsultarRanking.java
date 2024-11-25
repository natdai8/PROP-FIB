package FONTS.src.main.presentation.views;



import FONTS.src.main.presentation.controllers.PresentationController;
import FONTS.src.main.domain.classes.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ConsultarRanking extends JFrame {

    private JPanel Titulo;
    private JTable TablaRanking;
    private JButton volverButton;
    private JPanel panelglobal;
    private JScrollPane scroll;
    private static PresentationController ctrl = new PresentationController();

    public ConsultarRanking(){

        DefaultTableModel ranking = new DefaultTableModel();
        ranking.addColumn("Nombre Usuario");
        ranking.addColumn("Puntuación");

        ArrayList<Record> rank = ctrl.getRanking();
        for (Record record : rank) {
            Object[] rowData = {record.getRecordName(), record.getPoints()};
            ranking.addRow(rowData);
        }
        TablaRanking.setModel(ranking);
        setContentPane(panelglobal);
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user =ctrl.getUsername();
                ctrl.changeWindowToPrincipalMenu(user);
                dispose();
            }
        });


    }

}
