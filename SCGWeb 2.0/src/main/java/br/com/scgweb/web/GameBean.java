package br.com.scgweb.web;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.scgweb.model.game.Game;
import br.com.scgweb.model.game.GameRN;

@ManagedBean (name = "viewGame")
public class GameBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private Game game = new Game();
	
	public String actionAtualizar(){
		return "formulario_game";
	}
	
	public String actionApagar(){
		new GameRN().apagar(game);
		return "listagem_games?faces-redirect=true";
	}
	
	public List<Game> getTodosGames(){
		return new GameRN().listarTodos();
	}
	
	public String actionNovo(){
		this.game = new Game();
		return "formulario_game";
	}
	public String actionGravar(){
		new GameRN().salvar(game);
		return "listagem_games?faces-redirect=true";
	}
	
	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
	}
	

}
