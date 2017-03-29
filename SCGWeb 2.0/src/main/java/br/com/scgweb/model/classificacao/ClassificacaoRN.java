package br.com.scgweb.model.classificacao;

import java.util.List;

public class ClassificacaoRN {

	public void apagar(Classificacao classificacao) {
		new ClassificacaoDAO().delete(classificacao);
	}

	public List<Classificacao> listarTodos() {
		return new ClassificacaoDAO().selectAll();
	}

	public void salvar(Classificacao classificacao) {
		if (classificacao.getId() == null) {
			new ClassificacaoDAO().insert(classificacao);
		} else {
			new ClassificacaoDAO().update(classificacao);
		}
	}

}
