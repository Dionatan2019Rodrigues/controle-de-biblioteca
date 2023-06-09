package infra.dados.dao.memoria;

import infra.dados.dao.DAO;
import infra.entidades.Registro;
import infra.negocios.DadoNaoEncontrado;

import java.util.ArrayList;
import java.util.Collection;

public abstract class DAOMemoria<T extends Registro> implements DAO<T>{
	protected ArrayList<T> dados = new ArrayList<T>();

	public void adicionar(T t) {
		dados.add(t);
	}

	public void remover(T t) throws DadoNaoEncontrado {
		boolean ok = dados.remove(t);
		if (!ok)
			throw new DadoNaoEncontrado();
	}

	public void alterar(T e) throws DadoNaoEncontrado {
		for (T temp : dados) {
			if (temp.equals(e)) {
				preencher(temp,e);
			}
		}
	}

	protected abstract void preencher(T destino, T origem);

	public T buscar(T elemento) throws DadoNaoEncontrado { 
		for (T e : dados)
			if (e.equals(elemento))
				return e;
		throw new DadoNaoEncontrado();
	}

	public Collection<T> buscarTodos() {
		return dados;
	}
	

}
