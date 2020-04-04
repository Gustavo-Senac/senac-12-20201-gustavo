package controller.exercicio01;

import java.util.ArrayList;

import model.bo.exercicio01.TelefoneBO;
import model.dao.exercicio01.TelefoneDAO;
import model.vo.exercicio01.TelefoneVO;

public class TelefoneController {

	private TelefoneDAO dao = new TelefoneDAO();
	private TelefoneBO bo = new TelefoneBO();
	
	private static final int TAMANHO_MINIMO_CAMPO_CODIGO_PAIS = 1;
	private static final int TAMANHO_MAXIMO_CAMPO_CODIGO_PAIS = 4;
	private static final int TAMANHO_MINIMO_CAMPO_DDD = 2;
	private static final int TAMANHO_MAXIMO_CAMPO_DDD = 3;
	private static final int TAMANHO_MINIMO_CAMPO_NUMERO = 7;
	private static final int TAMANHO_MAXIMO_CAMPO_NUMERO = 11;


	/**
	 * Salva um novo telefone, validando os valores informados
	 * 
	 * @param novoTelefone o telefone a ser salvo;
	 * @return uma mensagem informando uma das opções a seguir:
	 * 
	 *         (1) há campos para ajustar
	 * 
	 *         (2) salvo com sucesso
	 * 
	 *         (3) erro ao salvar
	 */
	public String salvar(TelefoneVO novoTelefone) {
		String mensagemValidacao = validarCampos(novoTelefone);

		if (mensagemValidacao.isEmpty()) {
			mensagemValidacao = bo.salvar(novoTelefone);
		}
		return mensagemValidacao;
	}

	private String validarCampos(TelefoneVO novoTelefone) {
		String mensagem = "";

		if (novoTelefone == null) {
			return "Telefone não foi criado";
		}
			
		try {
			Integer.parseInt(novoTelefone.getCodigoPais());
			Integer.parseInt(novoTelefone.getDdd());
			Integer.parseInt(novoTelefone.getNumero());
			
		} catch (NumberFormatException ex) {
			mensagem += "Todos os campos devem ser números";
		}
			
		mensagem += validarCampoNumerico("Código do país", novoTelefone.getCodigoPais(), TAMANHO_MINIMO_CAMPO_CODIGO_PAIS, TAMANHO_MAXIMO_CAMPO_CODIGO_PAIS);
		mensagem += validarCampoNumerico("DDD", novoTelefone.getDdd(), TAMANHO_MINIMO_CAMPO_DDD, TAMANHO_MAXIMO_CAMPO_DDD);
		mensagem += validarCampoNumerico("Número", novoTelefone.getNumero(), TAMANHO_MINIMO_CAMPO_NUMERO, TAMANHO_MAXIMO_CAMPO_NUMERO);

		if (mensagem.isEmpty()) {
			mensagem = bo.salvar(novoTelefone);
		}
		
		return mensagem;
	}

	private String validarCampoNumerico(String valorDoCampo, String nomeDoCampo, int tamanhoMinimo, int tamanhoMaximo) {
		String mensagemValidacao = "";
	
		if (valorDoCampo != null && !valorDoCampo.isEmpty() 
					|| valorDoCampo.length() < tamanhoMinimo 
					|| valorDoCampo.length() > tamanhoMaximo) {
				mensagemValidacao = nomeDoCampo + " deve possuir pelo menos " + tamanhoMinimo + " e no máximo "
						+ tamanhoMaximo + " caracteres \n";
			}
	
		return mensagemValidacao;
		
	}

	public ArrayList<TelefoneVO> listarTodosOsTelefones() {
		return dao.consultarTodos();
	}

	
}
