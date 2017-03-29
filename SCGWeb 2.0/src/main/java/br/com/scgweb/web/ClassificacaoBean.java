package br.com.scgweb.web;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.scgweb.model.classificacao.Classificacao;
import br.com.scgweb.model.classificacao.ClassificacaoRN;

@ManagedBean (name = "viewClassificacao")
public class ClassificacaoBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private Classificacao classificacao = new Classificacao();
	
	public String actionAtualizar(){
		return "formulario_classificacao";
	}
	
	public String actionApagar(){
		new ClassificacaoRN().apagar(classificacao);
		return "listagem_classificacao?faces-redirect=true";
	}
	
	public List<Classificacao> getTodosClassificacoes(){
		return new ClassificacaoRN().listarTodos();
	}
	
	public String actionNovo(){
		this.classificacao = new Classificacao();
		return "formulario_classificacao";
	}
	public String actionGravar(){
		new ClassificacaoRN().salvar(classificacao);
		return "listagem_classificacao?faces-redirect=true";
	}
	
	public Classificacao getClassificacao() {
		return classificacao;
	}
	public void setClassificacao(Classificacao classificacao) {
		this.classificacao = classificacao;
	}
	

}