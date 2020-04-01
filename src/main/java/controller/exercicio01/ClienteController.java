package controller.exercicio01;

import java.util.ArrayList;

import model.dao.exercicio01.ClienteDAO;
import model.vo.exercicio01.ClienteVO;

public class ClienteController {

	private ClienteDAO dao = new ClienteDAO();
	
	public ArrayList<ClienteVO> listarTodosOsClientes() {
		return dao.consultarTodos();
	}

}
