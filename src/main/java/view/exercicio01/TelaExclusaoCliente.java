package view.exercicio01;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import controller.exercicio01.ClienteController;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;

public class TelaExclusaoCliente extends JFrame {

	private JPanel contentPane;
	private JFormattedTextField txtCpf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaExclusaoCliente frame = new TelaExclusaoCliente();
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
	public TelaExclusaoCliente() {
		setTitle("Exlusão de Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 270, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCpf = new JLabel("CPF: ");
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCpf.setBounds(30, 45, 45, 15);
		contentPane.add(lblCpf);
		
		JButton btnExluir = new JButton("Excluir");
		btnExluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClienteController controller = new ClienteController();
				String mensagem = controller.excluirPorCpf(txtCpf.getText());
				
				JOptionPane.showMessageDialog(null, mensagem);
			}
		});
		btnExluir.setBounds(53, 106, 150, 35);
		contentPane.add(btnExluir);
		
//		try {		
//			MaskFormatter mascaraCpf = new MaskFormatter("###.###.###-##");
//			
//			txtCpf = new JFormattedTextField(mascaraCpf);
//			txtCpf.setBounds(80, 45, 130, 20);
//			contentPane.add(txtCpf);
//			
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
		txtCpf = new JFormattedTextField();
		txtCpf.setBounds(80, 45, 130, 20);
		contentPane.add(txtCpf);
	}
}
