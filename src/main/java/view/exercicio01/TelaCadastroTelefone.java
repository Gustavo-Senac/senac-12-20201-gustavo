package view.exercicio01;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.exercicio01.TelefoneController;
import model.vo.exercicio01.TelefoneVO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroTelefone extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodigoPais;
	private JTextField txtDdd;
	private JTextField txtNumero;
	private JComboBox cbMovel;
	private JComboBox cbAtivo;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroTelefone frame = new TelaCadastroTelefone();
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
	public TelaCadastroTelefone() {
		setTitle("Cadastro de telefone");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCodigoPais = new JLabel("Código do país (*): ");
		lblCodigoPais.setBounds(25, 30, 95, 15);
		contentPane.add(lblCodigoPais);
		
		JLabel lblDdd = new JLabel("DDD (*): ");
		lblDdd.setBounds(25, 65, 46, 15);
		contentPane.add(lblDdd);
		
		JLabel lblNumero = new JLabel("Número (*): ");
		lblNumero.setBounds(25, 100, 65, 15);
		contentPane.add(lblNumero);
		
		JLabel lblMovel = new JLabel("Móvel (*): ");
		lblMovel.setBounds(25, 150, 55, 15);
		contentPane.add(lblMovel);
		
		JLabel lblAtivo = new JLabel("Ativo (*): ");
		lblAtivo.setBounds(130, 150, 50, 15);
		contentPane.add(lblAtivo);
		
		txtCodigoPais = new JTextField();
		txtCodigoPais.setBounds(130, 28, 100, 20);
		contentPane.add(txtCodigoPais);
		txtCodigoPais.setColumns(10);
		
		txtDdd = new JTextField();
		txtDdd.setBounds(130, 63, 100, 20);
		contentPane.add(txtDdd);
		txtDdd.setColumns(10);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(130, 95, 100, 20);
		contentPane.add(txtNumero);
		txtNumero.setColumns(10);
		
		cbMovel = new JComboBox();
		cbMovel.setModel(new DefaultComboBoxModel(new String[] {"", "Sim", "Não"}));
		cbMovel.setBounds(25, 165, 55, 20);
		contentPane.add(cbMovel);
		
		cbAtivo = new JComboBox();
		cbAtivo.setModel(new DefaultComboBoxModel(new String[] {"", "Sim", "Não"}));
		cbAtivo.setBounds(130, 165, 55, 20);
		contentPane.add(cbAtivo);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelefoneController controller = new TelefoneController();
				String mensagem = controller.salvar(construirTelefone(txtCodigoPais.getText(), txtDdd.getText(),
						 txtNumero.getText(), cbMovel.getSelectedItem(), cbAtivo.getSelectedItem()));
				
				JOptionPane.showMessageDialog(null, mensagem);
			}

		});
		btnSalvar.setBounds(25, 246, 89, 23);
		contentPane.add(btnSalvar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limparCampos();
			}
		});
		btnLimpar.setBounds(169, 246, 89, 23);
		contentPane.add(btnLimpar);
		
	}
	
	private void limparCampos() {
		this.txtCodigoPais.setText("");
		this.txtDdd.setText("");
		this.txtNumero.setText("");		
		this.cbMovel.setSelectedIndex(0);
		this.cbAtivo.setSelectedIndex(0);
	}
	
	private TelefoneVO construirTelefone(String codigoPais, String ddd, String numero, Object movel, Object ativo) {
		TelefoneVO novoTelefone = new TelefoneVO();
		
		novoTelefone.setCodigoPais(codigoPais);
		novoTelefone.setDdd(ddd);
		novoTelefone.setNumero(numero);
		
		if(cbMovel.getSelectedItem().equals("Sim")) {
			novoTelefone.setMovel(true);
		} else {
			novoTelefone.setMovel(false);
		}

		if(cbAtivo.getSelectedItem().equals("Sim")) {
			novoTelefone.setAtivo(true);
		} else {
			novoTelefone.setAtivo(false);
		}
		
		return novoTelefone;
	}
	
}
