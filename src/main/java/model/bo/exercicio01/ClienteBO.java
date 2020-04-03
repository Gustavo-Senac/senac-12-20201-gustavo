package model.bo.exercicio01;

import model.dao.exercicio01.ClienteDAO;
import model.dao.exercicio01.TelefoneDAO;
import model.vo.exercicio01.ClienteVO;

public class ClienteBO {

	private ClienteDAO dao = new ClienteDAO();
	private TelefoneDAO telefoneDAO = new TelefoneDAO();
	
	/**
	 * Tenta salvar um cliente novo, validando o CPF
	 * @param cliente o Cliente a ser salvo no banco
	 * @return
	 */
	public String salvar(ClienteVO cliente) {
		String mensagem = "";
		
		if(dao.cpfJaUtilizado(cliente.getCpf())) {
			mensagem = "CPF informado (" + cliente.getCpf() + ") já foi utilizado";
		} else {
			cliente = dao.salvar(cliente);
			
			if(cliente.getId() > 0) {
				mensagem = "Cliente salvo com sucesso";
			} else {
				mensagem = "Erro ao salvar cliente";
			}
		}
		
		return mensagem;
	}
	public String excluirPorCpf(String cpf) {
		String mensagem = "";
		
		ClienteVO clienteConsultado = dao.consultarPorCpf(cpf);

		if(clienteConsultado != null && clienteConsultado.getId() > 0) {
			if(telefoneDAO.consultarTodosPorIdCliente(clienteConsultado.getId()).isEmpty()) {
				boolean resposta = dao.excluir(clienteConsultado.getId());
				if(resposta) {
					mensagem = "Cliente excluido com sucesso";
				} else {
					mensagem = "Falha na exclusão de cliente";
				}
			} else {
				mensagem = "Cliente possui telefone cadastrado";
			}
		} else {
			mensagem = "Cliente não encontrado";
		} 
		
		return mensagem;
	}

}
