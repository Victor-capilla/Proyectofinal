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

public class BEBIDAS extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BEBIDAS frame = new BEBIDAS();
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
	public BEBIDAS() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 682, 418);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(125, 258, 445, 82);
		
		JPanel panel = new JPanel();
		panel.setBounds(33, 11, 602, 128);
		
		JButton btnAadir = new JButton("POSTRE");
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Postres mi = new Postres();
				mi.setVisible(true);
			}
		});
		btnAadir.setBackground(new Color(255, 255, 255));
		btnAadir.setFont(new Font("Arial", Font.BOLD, 14));
		btnAadir.setBounds(33, 189, 93, 40);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnOk.setBackground(new Color(255, 255, 255));
		btnOk.setFont(new Font("Arial", Font.BOLD, 14));
		btnOk.setBounds(168, 189, 84, 40);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancelar.setBackground(new Color(255, 255, 255));
		btnCancelar.setFont(new Font("Arial", Font.BOLD, 13));
		btnCancelar.setBounds(289, 189, 103, 40);
		
		JButton btnAtras = new JButton("ATRAS");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Bar mi = new Bar();
				mi.setVisible(true);
			}
		});
		btnAtras.setBackground(new Color(255, 255, 255));
		btnAtras.setFont(new Font("Arial", Font.BOLD, 14));
		btnAtras.setBounds(424, 189, 86, 40);
		
		JButton btnComida = new JButton("COMIDA");
		btnComida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Comidas mi = new Comidas();
				mi.setVisible(true);
			}
		});
		btnComida.setBackground(new Color(255, 255, 255));
		btnComida.setFont(new Font("Arial", Font.BOLD, 14));
		btnComida.setBounds(542, 189, 93, 40);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnNewButton_1 = new JButton("CERVERZA");
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 15));
		btnNewButton_1.setBackground(new Color(255, 215, 0));
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("COCACOLA");
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 15));
		btnNewButton_2.setBackground(new Color(220, 20, 60));
		btnNewButton_2.setForeground(new Color(0, 0, 0));
		panel.add(btnNewButton_2);
		
		JButton btnFanta = new JButton("FANTA");
		btnFanta.setFont(new Font("Arial", Font.BOLD, 15));
		btnFanta.setBackground(new Color(255, 165, 0));
		panel.add(btnFanta);
		
		JButton btnNewButton = new JButton("AGUA");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 15));
		btnNewButton.setBackground(new Color(135, 206, 250));
		panel.add(btnNewButton);
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
		contentPane.add(btnAadir);
		contentPane.add(btnOk);
		contentPane.add(btnCancelar);
		contentPane.add(btnAtras);
		contentPane.add(btnComida);
		contentPane.add(panel);
	}
}
