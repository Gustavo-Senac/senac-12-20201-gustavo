package model.bo.exercicio01;

import model.dao.exercicio01.TelefoneDAO;
import model.vo.exercicio01.TelefoneVO;

public class TelefoneBO {

	private TelefoneDAO dao = new TelefoneDAO();

	public String salvar(TelefoneVO telefone) {
		String mensagem = "";
		
		if(dao.telefoneJaCadastrado(telefone)) {
			mensagem = "Telefone já cadastrado";
		} else {		
			telefone = dao.salvar(telefone);
			
			if(telefone.getId() > 0) {
				mensagem = "Telefone salvo com sucesso";
			} else {
				mensagem = "Erro ao salvar telefone";
			}
		}
		return mensagem;
	}
	
}
