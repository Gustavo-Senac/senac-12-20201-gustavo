package executavel.exercicio01;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.bo.ClienteBO;
import model.bo.TelefoneBO;
import model.dao.exercicio01.EnderecoDAO;
import model.vo.exercicio01.Cliente;
import model.vo.exercicio01.Telefone;
import model.vo.exercicio01.Endereco;

public class ExecutavelExercicio1 {

	public static void main(String[] argumentosLinhaDeComando) {
		
		//Buscar e mostrar o endereco 1
		/*EnderecoDAO endDAO = new EnderecoDAO();
		Endereco enderecoConsultado = endDAO.consultarPorId(3);
		System.out.println("Endereço 3: " + enderecoConsultado.toString());*/
		
		
		//TODO exercício 2
		Cliente cliente1 = obterClienteDaTela();
		Telefone telefone1 = obterTelefoneDaTela();
		
		//- Salvar no banco
		
		ClienteBO clienteBO = new ClienteBO();
		String mensagem = clienteBO.salvar(cliente1);
		
		JOptionPane.showMessageDialog(null, mensagem);
		
		TelefoneBO telefoneBO = new TelefoneBO();
		mensagem = telefoneBO.salvar(telefone1);
		
		ArrayList<Telefone> telefones = new ArrayList<Telefone>(); 
		
	}


	private static Cliente obterClienteDaTela() {
		String nome = JOptionPane.showInputDialog("Informe o nome");
		String sobrenome = JOptionPane.showInputDialog("Informe o sobrenome");
		String cpf = JOptionPane.showInputDialog("Informe o CPF");

		EnderecoDAO endDAO = new EnderecoDAO();
		ArrayList<Endereco> listaEnderecos = endDAO.consultarTodos();
		
		Object[] enderecos = listaEnderecos.toArray();
		Endereco enderecoSelecionado = (Endereco) JOptionPane.showInputDialog(null, 
				"Selecione um endereço", "Endereço", 
				JOptionPane.QUESTION_MESSAGE, 
				null, enderecos, null);

		Cliente novoCliente = new Cliente(nome, sobrenome, cpf, 
				new ArrayList<Telefone>(), enderecoSelecionado);

		return novoCliente;
	}
	
	private static Telefone obterTelefoneDaTela() {
		String codigoDoPais = JOptionPane.showInputDialog("Informe o código do país");
		String ddd = JOptionPane.showInputDialog("Informe o DDD");
		String numero = JOptionPane.showInputDialog("Informe o número do telefone");
		int movel = JOptionPane.showConfirmDialog(null, "É um telefone móvel", "Escolha uma opção", JOptionPane.YES_NO_OPTION);
		int ativo = JOptionPane.showConfirmDialog(null, "Está ativo", "Escolha uma opção", JOptionPane.YES_NO_OPTION);
		return null;
	}
	
}
