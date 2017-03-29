package br.com.scgweb.model.game;

import java.util.List;

public class GameRN {

	public void apagar(Game game) {
		new GameDAO().delete(game);
	}

	public List<Game> listarTodos() {
		return new GameDAO().selectAll();
	}

	public void salvar(Game game) {
		if (game.getId() == null) {
			new GameDAO().insert(game);
		} else {
			new GameDAO().update(game);
		}
	}

}
