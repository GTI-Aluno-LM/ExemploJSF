package br.com.scgweb.model.classificacao;

import java.io.Serializable;

public class Classificacao implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String categoria;
	private String descricao;
	private String descricaoViolencia;
	private String descricaoSexoNudez;
	private String descricaoDrogas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricaoViolencia() {
		return descricaoViolencia;
	}

	public void setDescricaoViolencia(String descricaoViolencia) {
		this.descricaoViolencia = descricaoViolencia;
	}

	public String getDescricaoSexoNudez() {
		return descricaoSexoNudez;
	}

	public void setDescricaoSexoNudez(String descricaoSexoNudez) {
		this.descricaoSexoNudez = descricaoSexoNudez;
	}

	public String getDescricaoDrogas() {
		return descricaoDrogas;
	}

	public void setDescricaoDrogas(String descricaoDrogas) {
		this.descricaoDrogas = descricaoDrogas;
	}
}
