package executavel.exercicio01;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.bo.ClienteBO;
import model.bo.TelefoneBO;
import model.dao.exercicio01.ClienteDAO;
import model.dao.exercicio01.EnderecoDAO;
import model.vo.exercicio01.Cliente;
import model.vo.exercicio01.Telefone;
import model.vo.exercicio01.Endereco;

public class ExecutavelExercicio1 {

	public static void main(String[] argumentosLinhaDeComando) {
		
		//Buscar e mostrar o endereco 1
		/*EnderecoDAO endDAO = new EnderecoDAO();
		Endereco enderecoConsultado = endDAO.consultarPorId(3);
		System.out.println("Endereï¿½o 3: " + enderecoConsultado.toString());*/
		
		
		//TODO exercicio 2
		
		/*Cliente cliente1 = obterClienteDaTela();
		
		ClienteBO clienteBO = new ClienteBO();
		String mensagem = clienteBO.salvar(cliente1);
		
		JOptionPane.showMessageDialog(null, mensagem);*/
		
		
		/*Telefone telefone1 = obterTelefoneDaTela();
		
		TelefoneBO telefoneBO = new TelefoneBO();
		String mensagem = telefoneBO.salvar(telefone1);
		
		JOptionPane.showMessageDialog(null, mensagem);*/
		
		
		Telefone telefone1 = obterTelefoneDaTelaComCliente();
		
		TelefoneBO telefoneBO = new TelefoneBO();
		String mensagem = telefoneBO.salvar(telefone1);
		
		JOptionPane.showMessageDialog(null, mensagem);
		
	}
	
	private static Telefone obterTelefoneDaTelaComCliente() {
		Telefone novoTelefone = ExecutavelExercicio1.obterTelefoneDaTela();
		
		ClienteDAO clienteDAO = new ClienteDAO();
		ArrayList<Cliente> listaClientes = clienteDAO.consultarTodos();
		
		Object[] clientes = listaClientes.toArray();
		Cliente clienteSelecionado = (Cliente) JOptionPane.showInputDialog(null,
				"Selecione um cliente", "Lista Clientes",
				JOptionPane.QUESTION_MESSAGE, null, clientes, null);
		
		novoTelefone.setDono(clienteSelecionado);
		
		return novoTelefone;
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
		int respostaMovel = JOptionPane.showConfirmDialog(null, "É um telefone móvel", "Escolha uma opção", JOptionPane.YES_NO_OPTION);
		int respostaAtivo = JOptionPane.showConfirmDialog(null, "Está ativo", "Escolha uma opção", JOptionPane.YES_NO_OPTION);
		
		boolean ativo = true;
		boolean movel = true;
		if(respostaMovel == JOptionPane.YES_OPTION) {
			movel = true; 
		} else if(respostaMovel == JOptionPane.NO_OPTION) {
			movel = false;
		}
		
		if(respostaAtivo == JOptionPane.YES_OPTION) {
			ativo = true;
		} else if(respostaAtivo == JOptionPane.NO_OPTION) {
			ativo = false;
		}
		
		Telefone novoTelefone = new Telefone(codigoDoPais, ddd, numero, movel, ativo);
		
		return novoTelefone;
	}
		
}
