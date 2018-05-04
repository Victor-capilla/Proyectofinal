package defii;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.Font;

public class Bar extends JFrame {

	private JPanel contentPane;
	private JTable table;
	public JComboBox comboBox_1 = new JComboBox();
	public JComboBox comboBox = new JComboBox();
	public JComboBox comboBox_2 = new JComboBox();
	public JComboBox comboBox_3 = new JComboBox();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bar frame = new Bar();
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
	public Bar() {ConexionBBDD Prueba = new ConexionBBDD();
	setBounds(100, 100, 499, 319);
	contentPane = new JPanel();
	contentPane.setBackground(new Color(30, 144, 255));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	
	comboBox.setBounds(85, 118, 72, 20);
	comboBox.setModel(new DefaultComboBoxModel(Prueba.categorias()));
	
	
	JButton btnNewButton = new JButton("NUEVO");
	btnNewButton.setFont(new Font("Arial", Font.BOLD, 15));
	btnNewButton.setBackground(new Color(255, 255, 255));
	btnNewButton.setBounds(15, 16, 97, 45);
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			Añadirpedido aña =new Añadirpedido();
			aña.setVisible(true);
			
		}
	});
	
	JButton btnAadir = new JButton("A\u00D1ADIR");
	btnAadir.setBackground(new Color(255, 255, 255));
	btnAadir.setFont(new Font("Arial", Font.BOLD, 15));
	btnAadir.setBounds(15, 67, 97, 45);
	btnAadir.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			if (comboBox.getSelectedIndex() == 0) {
				BEBIDAS bebi = new BEBIDAS();
				bebi.setVisible(true);
			}else if (comboBox.getSelectedIndex() == 1) {
				Comidas comi = new Comidas();
				comi.setVisible(true);
			}else {
				Postres pos = new Postres();
				pos.setVisible(true);
						
			}
			
		}
	});
	
		JButton btnCobrar = new JButton("COBRAR");
		btnCobrar.setBackground(new Color(255, 255, 255));
		btnCobrar.setFont(new Font("Arial", Font.BOLD, 15));
		btnCobrar.setBounds(15, 219, 97, 45);
	btnCobrar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			Cobrar ticket = new Cobrar();
			ticket.setVisible(true);
			ticket.dificil(select1());
			ticket.tprecio(select1());
			
		}
	});
	
	
	comboBox_1.setBounds(202, 231, 28, 20);
	comboBox_1.setModel(new DefaultComboBoxModel(Prueba.pedidos()));
	
	JButton btnModificar = new JButton("MODIFICAR ");
	btnModificar.setFont(new Font("Arial", Font.BOLD, 15));
	btnModificar.setBackground(new Color(255, 255, 255));
	btnModificar.setBounds(15, 163, 97, 45);
	btnModificar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			visualizar modifi = new visualizar();
			modifi.setVisible(true);
			modifi.tprecio(Integer.parseInt(String.valueOf(comboBox_2.getSelectedItem())));
			modifi.dificil(Integer.parseInt(String.valueOf(comboBox_2.getSelectedItem())));
			modifi.cate(select2());
		}
	});
	
	
	comboBox_2.setBounds(202, 175, 28, 20);
	comboBox_2.setModel(new DefaultComboBoxModel(Prueba.pedidos()));
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(262, 16, 211, 248);
	
	JLabel lblCategorias = new JLabel("categorias");
	lblCategorias.setFont(new Font("Arial", Font.BOLD, 12));
	lblCategorias.setBounds(10, 121, 65, 14);
	
	
	comboBox_3.setBounds(226, 118, 28, 20);
	comboBox_3.setModel(new DefaultComboBoxModel(Prueba.pedidos()));
	
	table = new JTable();
	table.setModel(new DefaultTableModel(
		new Object[][] {
			{null, null},
			{null, null},
		},
		new String[] {
			"MESA", "PEDIDO"
		}
	) {
		Class[] columnTypes = new Class[] {
			Integer.class, Integer.class
		};
		public Class getColumnClass(int columnIndex) {
			return columnTypes[columnIndex];
		}
	});
	
	table.setModel(Prueba.pedidosdis());
	scrollPane.setViewportView(table);
	contentPane.setLayout(null);
	contentPane.add(btnAadir);
	contentPane.add(btnCobrar);
	contentPane.add(btnModificar);
	contentPane.add(comboBox_1);
	contentPane.add(comboBox_2);
	contentPane.add(comboBox_3);
	contentPane.add(lblCategorias);
	contentPane.add(comboBox);
	contentPane.add(btnNewButton);
	contentPane.add(scrollPane);
	
	JButton btnAtras = new JButton("ATRAS");
	btnAtras.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			
		}
	});
	btnAtras.setBackground(new Color(255, 255, 255));
	btnAtras.setFont(new Font("Arial", Font.BOLD, 15));
	btnAtras.setBounds(133, 16, 97, 45);
	contentPane.add(btnAtras);
	
	JLabel lblPedido_1 = new JLabel("pedido");
	lblPedido_1.setFont(new Font("Arial", Font.BOLD, 12));
	lblPedido_1.setBounds(167, 120, 50, 14);
	contentPane.add(lblPedido_1);
	
	JLabel label_1 = new JLabel("pedido");
	label_1.setFont(new Font("Arial", Font.BOLD, 12));
	label_1.setBounds(116, 179, 50, 14);
	contentPane.add(label_1);
	
	JLabel label = new JLabel("pedido");
	label.setFont(new Font("Arial", Font.BOLD, 12));
	label.setBounds(116, 235, 50, 14);
	contentPane.add(label);
}
	
	public int select () {
		String g= String.valueOf(comboBox.getSelectedItem());
		int c = Integer.parseInt(g);
		return c; }
	public int select1 () {
		String g= String.valueOf(comboBox_1.getSelectedItem());
		int c = Integer.parseInt(g);
		return c; }
	public int select2() {
		String g= String.valueOf(comboBox_2.getSelectedItem());
		int c = Integer.parseInt(g);
		return c; }
	public int select3() {
		String g= String.valueOf(comboBox_3.getSelectedItem());
		int c = Integer.parseInt(g);
		return c; }
	
	
	
	
}
