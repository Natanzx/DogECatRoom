package br.com.dogcatroom.dao.implementacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.dogcatroom.bo.AnimalBO;
import br.com.dogcatroom.bo.FuncionarioBO;
import br.com.dogcatroom.bo.ServicoBO;
import br.com.dogcatroom.conexao.ConnectionFactory;
import br.com.dogcatroom.dao.IAtendimentoDAO;
import br.com.dogcatroom.dto.AtendimentoDTO;

public class AtendimentoDAO implements IAtendimentoDAO {
	private Connection con = ConnectionFactory.getConnection();
	
	public void cadastrarAtendimento(AtendimentoDTO atendimento){
			String sql = "INSERT INTO atendimentos(idAnimal, idServico, idFuncionario, data) values(?,?,?,NOW())";
			
			try {
				PreparedStatement pstm = con.prepareStatement(sql);
				pstm.setInt(1, atendimento.getAnimal().getIdAnimal());
				pstm.setInt(2, atendimento.getServico().getId());
				pstm.setInt(3, atendimento.getFuncionario().getId());
				pstm.execute();
				pstm.close();
				System.out.println("Atendimento cadastrada com sucesso!");
				
			} catch (SQLException e) {
				e.printStackTrace();
			}

	
	}
	
	public List<AtendimentoDTO> buscarTodosAtendimentos() {
			AnimalBO animalBO = new AnimalBO();
			ServicoBO servicoBo = new ServicoBO();
			FuncionarioBO funcionarioBO = new FuncionarioBO();
			String sql = 
					  " SELECT a.idAtendimento, ani.idAnimal, c.nome, a.idServico, s.nome, s.valor, a.data, f.idFuncionario "
					+ "FROM atendimentos a "
					+ "inner join animais ani on ani.idAnimal = a.idAnimal "
					+ "inner join clientes c on c.idCliente = ani.idCliente "
					+ "inner join servicos s on s.idServico = a.idServico "
					+ "inner join funcionarios f on f.idFuncionario = a.idFuncionario "
					+ "order by data";
			
			List<AtendimentoDTO> lista = new ArrayList<AtendimentoDTO>();
			// Constroi PrepareStatement com sql
			try {
				PreparedStatement pstm = con.prepareStatement(sql);
	
				ResultSet resultado = pstm.executeQuery();
	
				while (resultado.next()) {
					AtendimentoDTO atendimento = new AtendimentoDTO();
					atendimento.setId(resultado.getInt("idAtendimento"));
					atendimento.setAnimal(animalBO.buscaAnimalPorID(resultado.getInt("idAnimal")));
					atendimento.setServico(servicoBo.buscarServicoPorID(resultado.getInt("idServico")));
					atendimento.setFuncionario(funcionarioBO.buscarFuncionarioPorID(resultado.getInt("idFuncionario")));
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
