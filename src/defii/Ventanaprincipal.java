package defii;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class Ventanaprincipal extends JFrame {
	Bar mib = new Bar();

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventanaprincipal frame = new Ventanaprincipal();
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
	public Ventanaprincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("ADMINISTRACI\u00D3N");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton.setForeground(new Color(25, 25, 112));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Administracion admin = new Administracion();
				admin.setVisible(true);
				Ventanaprincipal miven = new Ventanaprincipal();
				miven.setVisible(false);
				
			}
		});
		btnNewButton.setBounds(10, 74, 191, 115);
		contentPane.add(btnNewButton);
		
		JButton btnBar = new JButton("BAR");
		btnBar.setFont(new Font("Arial", Font.BOLD, 18));
		btnBar.setForeground(new Color(0, 0, 139));
		btnBar.setBackground(Color.WHITE);
		btnBar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Bar mi = new Bar();
			
				
				mi.setVisible(true);
				
				
			}
		});
		btnBar.setBounds(233, 74, 191, 115);
		contentPane.add(btnBar);
	}public void visible (Bar ne) {
		ne.setVisible(false);
		
	}
}
