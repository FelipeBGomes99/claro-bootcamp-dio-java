package br.com.dio.desafio.classes;

public class ParametrosInvalidosException extends Exception {
		
	private static final long serialVersionUID = 1L;

	public static void verificarParametros(int n1, int n2) throws ParametrosInvalidosException {
		if(n1>n2) {
			throw new ParametrosInvalidosException();
		}
	}
}
