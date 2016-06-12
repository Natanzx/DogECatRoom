package br.com.dogcatroom.dao.implementacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.dogcatroom.bo.ClienteBO;
import br.com.dogcatroom.bo.ServicoBO;
import br.com.dogcatroom.conexao.ConnectionFactory;
import br.com.dogcatroom.dao.IAtendimentoDAO;
import br.com.dogcatroom.dto.AtendimentoDTO;

public class AtendimentoDAO implements IAtendimentoDAO {
	private Connection con = ConnectionFactory.getConnection();
	
	public void cadastrarAtendimento(AtendimentoDTO atendimento){
			String sql = "INSERT INTO atendimentos(idCliente,idServico,data) values(?,?,NOW())";
			
			try {
				PreparedStatement pstm = con.prepareStatement(sql);
				pstm.setInt(1, atendimento.getCliente().getId());
				pstm.setInt(2, atendimento.getServico().getId());
				pstm.execute();
				pstm.close();
				System.out.println("Atendimento cadastrada com sucesso!");
				
			} catch (SQLException e) {
				e.printStackTrace();
			}

	
	}
	
	public List<AtendimentoDTO> buscarTodosAtendimentos() {
			ClienteBO clienteBo = new ClienteBO();
			ServicoBO servicoBo = new ServicoBO();
			String sql = 
					  " SELECT o.idAtendimento,o.idCliente,c.nome,o.idServico,s.nome,s.valor,o.data "
					+ "FROM atendimentos o "
					+ "inner join clientes c on c.idCliente = o.idCliente "
					+ "inner join servicos s on s.idServico = o.idServico "
					+ "order by data";
			
			List<AtendimentoDTO> lista = new ArrayList<AtendimentoDTO>();
			// Constroi PrepareStatement com sql
			try {
				PreparedStatement pstm = con.prepareStatement(sql);
	
				ResultSet resultado = pstm.executeQuery();
	
				while (resultado.next()) {
					AtendimentoDTO atendimento = new AtendimentoDTO();
					atendimento.setId(resultado.getInt("idAtendimento"));
					atendimento.setCliente((clienteBo.buscarClientePorID(resultado.getInt("idCliente"))));
					atendimento.setServico((servicoBo.buscarServicoPorID(resultado.getInt("idServico"))));
					
					atendimento.setData(resultado.getString("data").substring(0, 10));
					atendimento.setHora(resultado.getString("data").substring(10, 16));
					
					
					lista.add(atendimento);
	
				}	
				pstm.close();
				System.out.println("Buscar todos registros com sucesso!");
			} catch (SQLException e) {
				e.printStackTrace();
			}return lista;
	
		}
}
