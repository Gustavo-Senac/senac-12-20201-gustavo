package executavel.exercicio01;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.bo.exercicio01.ClienteBO;
import model.bo.exercicio01.TelefoneBO;
import model.dao.exercicio01.ClienteDAO;
import model.dao.exercicio01.EnderecoDAO;
import model.vo.exercicio01.ClienteVO;
import model.vo.exercicio01.TelefoneVO;
import model.vo.exercicio01.EnderecoVO;

public class ExecutavelExercicio1 {

	public static void main(String[] argumentosLinhaDeComando) {
		
		//Buscar e mostrar o endereco 1
		/*EnderecoDAO endDAO = new EnderecoDAO();
		Endereco enderecoConsultado = endDAO.consultarPorId(3);
		System.out.println("Endere�o 3: " + enderecoConsultado.toString());*/
		
		
		//TODO exercicio 2
		
		/*Cliente cliente1 = obterClienteDaTela();
		
		ClienteBO clienteBO = new ClienteBO();
		String mensagem = clienteBO.salvar(cliente1);
		
		JOptionPane.showMessageDialog(null, mensagem);*/
		
		
		/*Telefone telefone1 = obterTelefoneDaTela();
		
		TelefoneBO telefoneBO = new TelefoneBO();
		String mensagem = telefoneBO.salvar(telefone1);
		
		JOptionPane.showMessageDialog(null, mensagem);*/
		
		
		TelefoneVO telefone1 = obterTelefoneDaTelaComCliente();
		
		TelefoneBO telefoneBO = new TelefoneBO();
		String mensagem = telefoneBO.salvar(telefone1);
		
		JOptionPane.showMessageDialog(null, mensagem);
		
	}
	
	private static TelefoneVO obterTelefoneDaTelaComCliente() {
		TelefoneVO novoTelefone = ExecutavelExercicio1.obterTelefoneDaTela();
		
		ClienteDAO clienteDAO = new ClienteDAO();
		ArrayList<ClienteVO> listaClientes = clienteDAO.consultarTodos();
		
		Object[] clientes = listaClientes.toArray();
		ClienteVO clienteSelecionado = (ClienteVO) JOptionPane.showInputDialog(null,
				"Selecione um cliente", "Lista Clientes",
				JOptionPane.QUESTION_MESSAGE, null, clientes, null);
		
		novoTelefone.setDono(clienteSelecionado);
		
		return novoTelefone;
	}

	private static ClienteVO obterClienteDaTela() {
		String nome = JOptionPane.showInputDialog("Informe o nome");
		String sobrenome = JOptionPane.showInputDialog("Informe o sobrenome");
		String cpf = JOptionPane.showInputDialog("Informe o CPF");

		EnderecoDAO endDAO = new EnderecoDAO();
		ArrayList<EnderecoVO> listaEnderecos = endDAO.consultarTodos();
		
		Object[] enderecos = listaEnderecos.toArray();
		EnderecoVO enderecoSelecionado = (EnderecoVO) JOptionPane.showInputDialog(null, 
				"Selecione um endere�o", "Endere�o", 
				JOptionPane.QUESTION_MESSAGE, 
				null, enderecos, null);

		ClienteVO novoCliente = new ClienteVO(nome, sobrenome, cpf, 
				new ArrayList<TelefoneVO>(), enderecoSelecionado);

		return novoCliente;
	}
	
	private static TelefoneVO obterTelefoneDaTela() {
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
		
		TelefoneVO novoTelefone = new TelefoneVO(codigoDoPais, ddd, numero, movel, ativo);
		
		return novoTelefone;
	}
		
}
