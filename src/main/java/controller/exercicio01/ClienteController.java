package controller.exercicio01;

import java.util.ArrayList;

import model.bo.exercicio01.ClienteBO;
import model.dao.exercicio01.ClienteDAO;
import model.vo.exercicio01.ClienteVO;

public class ClienteController {

	private ClienteDAO dao = new ClienteDAO();
	private ClienteBO bo = new ClienteBO();
	
	public ArrayList<ClienteVO> listarTodosOsClientes() {
		return dao.consultarTodos();
	}

	public String excluirPorCpf(String cpf) {
		String mensagem = "";
		
		if(cpf.length() != 11) {
			mensagem = "O CPF deve conter 11 dígitos";
		} else {
			mensagem = bo.excluirPorCpf(cpf);
		}
		
		return mensagem;
	}

}
