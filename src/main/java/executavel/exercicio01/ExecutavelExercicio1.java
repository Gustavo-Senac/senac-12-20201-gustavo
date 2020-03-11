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
		System.out.println("Endere�o 3: " + enderecoConsultado.toString());*/
		
		
		//TODO exerc�cio 2
		//Cliente cliente1 = obterClienteDaTela();
		Telefone telefone1 = obterTelefoneDaTela();
		
		//- Salvar no banco
		
		/*ClienteBO clienteBO = new ClienteBO();
		String mensagem = clienteBO.salvar(cliente1);
		
		JOptionPane.showMessageDialog(null, mensagem);*/
		
		TelefoneBO telefoneBO = new TelefoneBO();
		String mensagem = telefoneBO.salvar(telefone1);
		
		JOptionPane.showMessageDialog(null, mensagem);
		
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
		String numero = JOptionPane.showInputDialog("Informe o n�mero do telefone");
		int respostaMovel = JOptionPane.showConfirmDialog(null, "É um telefone móvel", "Escolha uma opção", JOptionPane.YES_NO_OPTION);
		int respostaAtivo = JOptionPane.showConfirmDialog(null, "Está ativo", "Escolha uma opção", JOptionPane.YES_NO_OPTION);
		
		boolean ativo = true;
		boolean movel = true;
		if(respostaMovel == 0) {
			movel = true; 
		} else if(respostaMovel == 1) {
			movel = false;
		}
		
		if(respostaAtivo == 0) {
			ativo = true;
		} else if(respostaAtivo == 1) {
			ativo = false;
		}
		
		Telefone novoTelefone = new Telefone(codigoDoPais, ddd, numero, movel, ativo);
		
		return novoTelefone;
	}
		
}
