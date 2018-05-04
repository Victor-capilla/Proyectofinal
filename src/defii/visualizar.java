package defii;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class visualizar extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	ConexionBBDD Prueba = new ConexionBBDD();
	int pedido ;
	JComboBox comboBox = new JComboBox();
	JComboBox comboBox_1 = new JComboBox();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					visualizar frame = new visualizar();
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
	public visualizar() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		
		
		JButton btnReducir = new JButton("REDUCIR");
		btnReducir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Prueba.reducir(String.valueOf(comboBox.getSelectedItem()), pedido);
				tprecio(pedido);
				dificil(pedido);
				cate(pedido);
				eee();
			}
		});
		btnReducir.setBackground(new Color(255, 255, 255));
		btnReducir.setFont(new Font("Arial", Font.BOLD, 13));
		
		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Prueba.eliminar(String.valueOf(comboBox.getSelectedItem()), pedido);
				tprecio(pedido);
				dificil(pedido);
				cate(pedido);
				eee();
				
				
			}
		});
		btnEliminar.setBackground(new Color(255, 255, 255));
		btnEliminar.setFont(new Font("Arial", Font.BOLD, 14));
		
		JLabel lblProducto = new JLabel("PRODUCTO");
		lblProducto.setFont(new Font("Arial", Font.BOLD, 12));
		
		JLabel lblPrecioActual = new JLabel("Precio actual");
		lblPrecioActual.setFont(new Font("Arial", Font.BOLD, 12));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblCategoria = new JLabel("CATEGORIA");
		lblCategoria.setFont(new Font("Arial", Font.BOLD, 12));
		
		
		
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
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(20)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblProducto)
											.addGap(18)
											.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblCategoria, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
								.addComponent(btnAtras, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnReducir, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnEliminar)
							.addGap(13)
							.addComponent(lblPrecioActual)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(34, Short.MAX_VALUE))
		);
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ("bebidas".equals(String.valueOf(comboBox_1.getSelectedItem()))) {
					comboBox.setModel(new DefaultComboBoxModel(Prueba.catpropedidos(pedido, "bebidas")));
					
					
					
				}else if ("comida".equals(String.valueOf(comboBox_1.getSelectedItem()))) {
					comboBox.setModel(new DefaultComboBoxModel(Prueba.catpropedidos(pedido, "comida")));
				}else if ("postres".equals(String.valueOf(comboBox_1.getSelectedItem()))) {
					comboBox.setModel(new DefaultComboBoxModel(Prueba.catpropedidos(pedido, "comida")));
				}else {
					comboBox.setModel(new DefaultComboBoxModel(new String [3]));
				}
			}
		});
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(22)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblProducto))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCategoria))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnAtras, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnReducir, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnEliminar, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPrecioActual)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(22))
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"PRODUCTO", "CANTIDAD", "PRECIO"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, Integer.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
		if ("bebidas".equals(String.valueOf(comboBox_1.getSelectedItem()))) {
			comboBox.setModel(new DefaultComboBoxModel(Prueba.catpropedidos(pedido, "bebidas")));
			
			
			
		}else if ("comida".equals(String.valueOf(comboBox_1.getSelectedItem()))) {
			comboBox.setModel(new DefaultComboBoxModel(Prueba.catpropedidos(pedido, "comida")));
		}else if ("postres".equals(String.valueOf(comboBox_1.getSelectedItem()))) {
			comboBox.setModel(new DefaultComboBoxModel(Prueba.catpropedidos(pedido, "postres")));
		}else {
			comboBox.setModel(new DefaultComboBoxModel(new String [3]));
		}
	}public void tprecio(int cas) {
		
		textField.setText(String.valueOf(Prueba.precio(cas))+ " €");
		pedido = cas;
	
	


}public void dificil(int cas) {
	
	table.setModel(Prueba.propedidosdis(cas));




}public void cate(int cas) {
	
	comboBox_1.setModel(new DefaultComboBoxModel(Prueba.catpedidos(cas)));
	pedido = cas;




}public void eee()  {
	if ("bebidas".equals(String.valueOf(comboBox_1.getSelectedItem()))) {
		comboBox.setModel(new DefaultComboBoxModel(Prueba.catpropedidos(pedido, "bebidas")));
		
		
		
	}else if ("comida".equals(String.valueOf(comboBox_1.getSelectedItem()))) {
		comboBox.setModel(new DefaultComboBoxModel(Prueba.catpropedidos(pedido, "comida")));
	}else if ("postres".equals(String.valueOf(comboBox_1.getSelectedItem()))) {
		comboBox.setModel(new DefaultComboBoxModel(Prueba.catpropedidos(pedido, "postres")));
	}else {
		comboBox.setModel(new DefaultComboBoxModel(new String [3]));
	}
}
}
