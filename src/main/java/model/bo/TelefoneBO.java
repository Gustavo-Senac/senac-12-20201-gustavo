package model.bo;

import model.dao.exercicio01.TelefoneDAO;
import model.vo.exercicio01.Telefone;

public class TelefoneBO {

	private TelefoneDAO dao = new TelefoneDAO();

	public String salvar(Telefone telefone) {
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
