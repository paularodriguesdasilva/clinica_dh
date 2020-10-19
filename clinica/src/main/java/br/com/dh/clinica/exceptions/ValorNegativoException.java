package br.com.dh.clinica.exceptions;

@SuppressWarnings("serial")
public class ValorNegativoException extends RuntimeException {
	String atributo;

	public ValorNegativoException(String atributo) {
		this.atributo = atributo;
	}
	
	@Override
	public String getMessage() {
		return atributo + " não pode ser negativo!";
	}
}
