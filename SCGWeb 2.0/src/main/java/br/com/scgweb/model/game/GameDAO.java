package br.com.scgweb.model.game;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.scgweb.util.ConnectionFactory;

public class GameDAO extends ConnectionFactory{

	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	public void update(Game game){
		String sql = "UPDATE game SET titulo = ?, desenvolvedor = ?, "
				+ "plataforma = ?, classificacao = ? WHERE id = ?";
		try {
			con = openConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, game.getTitulo());
			ps.setString(2, game.getDesenvolvedor());
			ps.setString(3, game.getPlataforma());
			ps.setString(4, game.getClassificacao());
			ps.setLong(5, game.getId());
			ps.executeUpdate();
		} catch (Exception e){
			System.err.println("---------------------");
			System.err.println("Erro: " + e.getMessage());
			e.printStackTrace();
			System.err.println("---------------------");
		} finally {
			closeConnection(con, ps);
		}
	}
	public void delete(Game game){
		String sql = "DELETE FROM game WHERE id = ?";
		try {
			con = openConnection();
			ps = con.prepareStatement(sql);
			ps.setLong(1, game.getId());
			ps.executeUpdate();
		} catch (Exception e){
			System.err.println("---------------------");
			System.err.println("Erro: " + e.getMessage());
			e.printStackTrace();
			System.err.println("---------------------");
		} finally {
			closeConnection(con, ps);
		}
	}
	public List<Game> selectAll(){
		List<Game> lsGames = null;
		String sql = "SELECT id, titulo, desenvolvedor, plataforma, classificacao FROM game " 
				+ "ORDER BY id";
		try {
			con = openConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			lsGames = new ArrayList<Game>();
			while (rs.next()){
				Game g = new Game();
				g.setId(rs.getLong("id"));
				g.setTitulo(rs.getString("titulo"));
				g.setDesenvolvedor(rs.getString("desenvolvedor"));
				g.setPlataforma(rs.getString("plataforma"));
				g.setClassificacao(rs.getString("classificacao"));
				lsGames.add(g);
			}
		} catch (Exception e){
			System.err.println("---------------------");
			System.err.println("Erro: " + e.getMessage());
			e.printStackTrace();
			System.err.println("---------------------");
		} finally {
			closeConnection(con, ps);
		}
		return lsGames;
	}
	
	public void insert(Game game){
		String sql = "INSERT INTO game (titulo, desenvolvedor, plataforma, classificacao) "
				+ "VALUES (?, ? , ?, ?)";
		try {
			con = openConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, game.getTitulo());
			ps.setString(2, game.getDesenvolvedor());
			ps.setString(3, game.getPlataforma());
			ps.setString(4, game.getClassificacao());
			ps.executeUpdate();
		} catch (Exception e){
			System.err.println("---------------------");
			System.err.println("Erro: " + e.getMessage());
			e.printStackTrace();
			System.err.println("---------------------");
		} finally {
			closeConnection(con, ps);
		}
	}
}
