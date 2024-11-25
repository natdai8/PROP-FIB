package FONTS.src.main.presentation.views;

import FONTS.src.main.domain.classes.Record;
import FONTS.src.main.presentation.controllers.PresentationController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ConsultarRecords extends JFrame {
    private JPanel Titulo;
    private JTable table1;
    private JButton volverButton;
    private JPanel panelglobal;
    private static PresentationController ctrl = new PresentationController();

    public ConsultarRecords(String username){

        DefaultTableModel records = new DefaultTableModel();
        records.addColumn("Puntuación");

        ArrayList<Record> rank = ctrl.consultPR(username);
        for (Record record : rank) {
            Object[] rowData = {record.getPoints()};
            records.addRow(rowData);
        }
        table1.setModel(records);
        setContentPane(panelglobal);
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ctrl.changeWindowToPrincipalMenu (username);
                dispose();
            }
        });
    }
}
