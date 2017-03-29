package br.com.scgweb.model.classificacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.scgweb.model.classificacao.Classificacao;
import br.com.scgweb.util.ConnectionFactory;

public class ClassificacaoDAO extends ConnectionFactory {

	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	public void update(Classificacao classificacao) {
		String sql = "UPDATE classificacao SET categoria = ?, descricao = ?, descricaoViolencia = ?,"
				+ " descricaoSexoNudez = ?, descricaoDrogas = ? WHERE id = ?";
		try {
			con = openConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, classificacao.getCategoria());
			ps.setString(2, classificacao.getDescricao());
			ps.setString(3, classificacao.getDescricaoViolencia());
			ps.setString(4, classificacao.getDescricaoSexoNudez());
			ps.setString(5, classificacao.getDescricaoDrogas());
			ps.setLong(6, classificacao.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			System.err.println("---------------------");
			System.err.println("Erro: " + e.getMessage());
			e.printStackTrace();
			System.err.println("---------------------");
		} finally {
			closeConnection(con, ps);
		}
	}

	public void delete(Classificacao classificacao) {
		String sql = "DELETE FROM classificacao WHERE id = ?";
		try {
			con = openConnection();
			ps = con.prepareStatement(sql);
			ps.setLong(1, classificacao.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			System.err.println("---------------------");
			System.err.println("Erro: " + e.getMessage());
			e.printStackTrace();
			System.err.println("---------------------");
		} finally {
			closeConnection(con, ps);
		}
	}

	public List<Classificacao> selectAll() {
		List<Classificacao> lsClassificacoes = null;
		String sql = "SELECT id, categoria, descricao, descricaoViolencia, descricaoSexoNudez,"
				+ " descricaoDrogas FROM classificacao " + "ORDER BY id";
		try {
			con = openConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			lsClassificacoes = new ArrayList<Classificacao>();
			while (rs.next()) {
				Classificacao classificacao = new Classificacao();
				classificacao.setId(rs.getLong("id"));
				classificacao.setCategoria(rs.getString("categoria"));
				classificacao.setDescricao(rs.getString("descricao"));
				classificacao.setDescricaoViolencia(rs
						.getString("descricaoViolencia"));
				classificacao.setDescricaoSexoNudez(rs
						.getString("descricaoSexoNudez"));
				classificacao.setDescricaoDrogas(rs
						.getString("descricaoDrogas"));
				lsClassificacoes.add(classificacao);
			}
		} catch (Exception e) {
			System.err.println("---------------------");
			System.err.println("Erro: " + e.getMessage());
			e.printStackTrace();
			System.err.println("---------------------");
		} finally {
			closeConnection(con, ps);
		}
		return lsClassificacoes;
	}

	public void insert(Classificacao classificacao) {
		String sql = "INSERT INTO classificacao (categoria, descricao, descricaoViolencia, "
				+ "descricaoSexoNudez, descricaoDrogas) "
				+ "VALUES (?, ? , ?, ?, ?)";
		try {
			con = openConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, classificacao.getCategoria());
			ps.setString(2, classificacao.getDescricao());
			ps.setString(3, classificacao.getDescricaoViolencia());
			ps.setString(4, classificacao.getDescricaoSexoNudez());
			ps.setString(5, classificacao.getDescricaoDrogas());
			ps.executeUpdate();
		} catch (Exception e) {
			System.err.println("---------------------");
			System.err.println("Erro: " + e.getMessage());
			e.printStackTrace();
			System.err.println("---------------------");
		} finally {
			closeConnection(con, ps);
		}
	}
}
