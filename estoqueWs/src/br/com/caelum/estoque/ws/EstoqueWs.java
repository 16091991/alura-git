package br.com.caelum.estoque.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import br.com.caelum.estoque.modelo.item.Filtro;
import br.com.caelum.estoque.modelo.item.Filtros;
import br.com.caelum.estoque.modelo.item.Item;
import br.com.caelum.estoque.modelo.item.ItemDao;
import br.com.caelum.estoque.modelo.item.ListaItens;
import br.com.caelum.estoque.modelo.usuario.AutorizationException;
import br.com.caelum.estoque.modelo.usuario.TokenDao;
import br.com.caelum.estoque.modelo.usuario.TokenUsuario;

@WebService
public class EstoqueWs {

	private ItemDao dao = new ItemDao();

	@WebMethod(operationName = "todosItens")
	@WebResult(name = "itens")
	public ListaItens getItens(@WebParam(name = "filtros") Filtros filtros) {
		System.out.println("Chamando getItens()");
		List<Filtro> lista = filtros.getLista();
		List<Item> itensResultado = dao.todosItens(lista);
		return new ListaItens(itensResultado);
	}

	@WebMethod(operationName = "cadastrarItem")
	@WebResult(name = "item")

	public Item cadastrarItem(@WebParam(name = "usuario", header = true) TokenUsuario token,
			@WebParam(name = "item") Item item) throws AutorizationException {
		System.out.println("Cadastrando item" + item + "token "+ token );
		boolean valido = new TokenDao().ehValido(token);
		if(!valido) {
			throw new AutorizationException("Nao Autorizado! ");
		}
		this.dao.cadastrar(item);
		return item;
	}
}
