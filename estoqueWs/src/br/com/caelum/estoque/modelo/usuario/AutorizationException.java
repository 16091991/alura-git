package br.com.caelum.estoque.modelo.usuario;

import javax.xml.ws.WebFault;

@WebFault(name="AutorizationFault")
public class AutorizationException extends Exception {

	public AutorizationException(String mensagem) {
		super(mensagem);
	}

	private static final long serialVersionUID = 1L;

	public String getFaultInfo() {
		
		return "Token invalido";
	}
	
	public int getCodeFault() {
		
		return 403;
		
	}
}
