package com.db;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Main {
	DBConnector conn = new DBConnector();
	JFrame jFrame = new JFrame("Jtable ");
	JTable table;
	public Main()
	{
		Vector col = new Vector();
        col.add("이름");
        col.add("이메일");
        col.add("별명");
        DefaultTableModel model = new DefaultTableModel
        		(conn.getUserData(), col) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table = new JTable(model);
        JScrollPane scroll = new JScrollPane(table);
        jFrame.add(scroll);
        Dimension screenSize = 
        		Toolkit.getDefaultToolkit().getScreenSize();
        jFrame.setLocation((screenSize.width - 1200) / 2, 
        		(screenSize.height - 300) / 2);
        jFrame.setSize(1200, 300);
        jFrame.setTitle("DB 연습");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame. setVisible(true);
	}
	
	public static void main(String[] args)
	{
		new Main();
	}
}
