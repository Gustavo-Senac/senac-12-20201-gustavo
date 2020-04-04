package view.exercicio01;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.exercicio01.TelefoneController;
import model.vo.exercicio01.TelefoneVO;

public class TelaListagemTelefones extends JFrame {

	private JPanel contentPane;
	private JTable tblTelefones;
	private ArrayList<TelefoneVO> telefones;
	private String[] nomesColunas = { "Código do País", "DDD", "Número", "Móvel", "Ativo"};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListagemTelefones frame = new TelaListagemTelefones();
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
	public TelaListagemTelefones() {
		setTitle("Listagem de Telefones");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelefoneController controller = new TelefoneController();
				telefones = controller.listarTodosOsTelefones();
				
				atualizarTabelaTelefones();
			}


		});
		btnListar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnListar.setBounds(220, 25, 130, 35);
		contentPane.add(btnListar);
		
		tblTelefones = new JTable();
		tblTelefones.setBounds(10, 80, 565, 390);
		contentPane.add(tblTelefones);
	}
	
	private void atualizarTabelaTelefones() {
		limparTabelaTelefones();
		DefaultTableModel model = (DefaultTableModel) tblTelefones.getModel();
		
		for(TelefoneVO tel : telefones) {
			Object[] novaLinhaDaTabela = new Object[5];
			novaLinhaDaTabela[0] = tel.getCodigoPais();
			novaLinhaDaTabela[1] = tel.getDdd();
			novaLinhaDaTabela[2] = tel.getNumero();
			novaLinhaDaTabela[3] = tel.isMovel();
			novaLinhaDaTabela[4] = tel.isAtivo();

			model.addRow(novaLinhaDaTabela);
		}
		
	}

	private void limparTabelaTelefones() {
		tblTelefones.setModel(new DefaultTableModel(new Object[][] { nomesColunas, }, nomesColunas));		
	}
	
}
