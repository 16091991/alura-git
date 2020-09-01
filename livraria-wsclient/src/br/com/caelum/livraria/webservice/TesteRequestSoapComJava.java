package br.com.caelum.livraria.webservice;

import java.rmi.RemoteException;

public class TesteRequestSoapComJava {

	public static void main(String[] args) throws RemoteException {
		
		LivrariaWs cliente = new LivrariaWsProxy();
		
		Livro[] livros = cliente.getLivrosPeloNome("Arquitetura SOA");
		
		for (Livro livro : livros) {
			System.out.println(livro.getTitulo());
			System.out.println(livro.getAutor().getNome());
		}

	}

}
