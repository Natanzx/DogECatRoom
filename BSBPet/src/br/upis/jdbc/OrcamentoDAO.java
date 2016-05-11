package br.upis.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.upis.Orcamento;

public class OrcamentoDAO {
	ConexaoBanco conexao = new ConexaoBanco();
	Connection con = conexao.getConnection();
	
	public void inserir(Orcamento orcamento) {
		// Criar query
		String sql = "INSERT INTO orcamento(id_cliente,id_servico,data,usuario) values(?,?,NOW(),?)";
		
		
		// Constroi PrepareStatement com sql
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, orcamento.getId_cliente());
			pstm.setInt(2, orcamento.getId_servico());
			pstm.setString(3, orcamento.getUsuario());
			pstm.execute();
			pstm.close();
			System.out.println("Venda cadastrada com sucesso!");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public List<Orcamento> buscarTodos() {
		
		// Criar query
		String sql = 
				  "SELECT o.id,id_cliente,c.nome,id_servico,s.tipo,s.valor,o.usuario, o.data "
				+ "FROM orcamento o "
				+ "inner join cliente c on c.id = o.id_cliente "
				+ "inner join servico s on s.id = o.id_servico "
				+ "order by data";
		
		List<Orcamento> lista = new ArrayList<Orcamento>();
		// Constroi PrepareStatement com sql
		try {
			PreparedStatement pstm = con.prepareStatement(sql);

			ResultSet resultado = pstm.executeQuery();

			while (resultado.next()) {
				Orcamento orac = new Orcamento();
				orac.setId(resultado.getInt("o.id"));
				orac.setId_cliente(resultado.getInt("id_cliente"));
				orac.setNome_cliente(resultado.getString("c.nome"));
				orac.setId_servico(resultado.getInt("id_servico"));
				orac.setNome_servico(resultado.getString("s.tipo"));
				orac.setValor(resultado.getString("s.valor"));
				orac.setUsuario(resultado.getString("usuario"));
				orac.setData(resultado.getString("o.data"));

				lista.add(orac);

			}	
			pstm.close();
			System.out.println("Buscar todos registros com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
		}return lista;

	}
}
