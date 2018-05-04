package defii;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Postres extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Postres frame = new Postres();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Postres() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 425);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(40, 250, 584, 109);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
			},
			new String[] {
				"CANTIDAD", "NOMBRE"
			}
		));
		scrollPane_1.setViewportView(table);
		contentPane.add(scrollPane_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 646, 128);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnTiramisu = new JButton("TIRAMISU");
		btnTiramisu.setFont(new Font("Arial", Font.BOLD, 15));
		btnTiramisu.setBackground(new Color(139, 69, 19));
		panel.add(btnTiramisu);
		
		JButton btnFlan = new JButton("FLAN");
		btnFlan.setFont(new Font("Arial", Font.BOLD, 15));
		btnFlan.setBackground(new Color(255, 250, 205));
		panel.add(btnFlan);
		
		JButton btnCafe = new JButton("CAFE");
		btnCafe.setFont(new Font("Arial", Font.BOLD, 15));
		btnCafe.setBackground(new Color(160, 82, 45));
		panel.add(btnCafe);
		
		JButton btnTarta = new JButton("TARTA");
		btnTarta.setFont(new Font("Arial", Font.BOLD, 15));
		btnTarta.setBackground(new Color(255, 182, 193));
		panel.add(btnTarta);
		
		JButton button_4 = new JButton("COMIDA");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Comidas mi = new Comidas();
				mi.setVisible(true);
			}
		});
		button_4.setBackground(new Color(255, 255, 255));
		button_4.setFont(new Font("Arial", Font.BOLD, 13));
		button_4.setBounds(25, 189, 88, 40);
		contentPane.add(button_4);
		
		JButton button_5 = new JButton("OK");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_5.setBackground(new Color(255, 255, 255));
		button_5.setFont(new Font("Arial", Font.BOLD, 13));
		button_5.setBounds(140, 189, 88, 40);
		contentPane.add(button_5);
		
		JButton button_6 = new JButton("CANCELAR");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_6.setBackground(new Color(255, 255, 255));
		button_6.setFont(new Font("Arial", Font.BOLD, 13));
		button_6.setBounds(272, 189, 103, 40);
		contentPane.add(button_6);
		
		JButton button_7 = new JButton("ATRAS");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Bar mi = new Bar();
				mi.setVisible(true);
			}
		});
		button_7.setBackground(new Color(255, 255, 255));
		button_7.setFont(new Font("Arial", Font.BOLD, 13));
		button_7.setBounds(419, 189, 88, 40);
		contentPane.add(button_7);
		
		JButton button_8 = new JButton("BEBIDA");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				BEBIDAS mi = new BEBIDAS();
				mi.setVisible(true);
			}
		});
		button_8.setBackground(new Color(255, 255, 255));
		button_8.setFont(new Font("Arial", Font.BOLD, 13));
		button_8.setBounds(547, 189, 86, 40);
		contentPane.add(button_8);
	}
}
