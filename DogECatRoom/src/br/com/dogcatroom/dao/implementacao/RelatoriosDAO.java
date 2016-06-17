package br.com.dogcatroom.dao.implementacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.dogcatroom.conexao.ConnectionFactory;
import br.com.dogcatroom.dao.IRelatoriosDAO;
import br.com.dogcatroom.dto.RelatoriosDTO;

public class RelatoriosDAO implements IRelatoriosDAO{

	private Connection con = ConnectionFactory.getConnection();
	
	@Override
	public void RelatorioQuantitativoClientes(RelatoriosDTO rel) {
		String sql = "SELECT (SELECT count(*) FROM clientes) as countClientes ";
		ResultSet rs = null;
		try{
			PreparedStatement pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()){
				rel.setCountClientes(rs.getInt("countClientes"));
			}
			
		}catch (SQLException e) {
			System.out.println("Operação não concluída.");
			e.printStackTrace();
		}
	}

	@Override
	public void RelatorioQuantitativoServicos(RelatoriosDTO rel) {
		String sql = "SELECT (SELECT count(*) FROM servicos) as countServicos ";
		ResultSet rs = null;
		try{
			PreparedStatement pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()){
				rel.setCountServicos(rs.getInt("countServicos"));
			}
			
		}catch (SQLException e) {
			System.out.println("Operação não concluída.");
			e.printStackTrace();
		}
	}

	@Override
	public void RelatorioQuantitativoFuncionarios(RelatoriosDTO rel) {
		String sql = "SELECT (SELECT count(*) FROM funcionarios) as countFuncionarios; ";
		ResultSet rs = null;
		try{
			PreparedStatement pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()){
				rel.setCountFuncionarios(rs.getInt("countFuncionarios"));
			}
			
		}catch (SQLException e) {
			System.out.println("Operação não concluída.");
			e.printStackTrace();
		}
	}

	@Override
	public void RelatorioQuantitativoAtendimentos(RelatoriosDTO rel) {
		String sql = "SELECT (SELECT count(*) FROM atendimentos) as countAtendimentos; ";
		ResultSet rs = null;
		try{
			PreparedStatement pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()){
				rel.setCountAtendimentos(rs.getInt("countAtendimentos"));
			}
			
		}catch (SQLException e) {
			System.out.println("Operação não concluída.");
			e.printStackTrace();
		}	
	}

	@Override
	public void RelatorioAtendimentosPorHorario(RelatoriosDTO rel) {
		String sql = ""
				+ "SELECT "
				+ "		c.nome, "
				+ "    	ani.nome as Animal, "
				+ "    	s.descricao, "
				+ "    	f.nome as Funcionario, "
				+ "		date_format(data,'%H:%i') as data "
				+ "from atendimentos a "
				+ "		inner join animais ani on ani.idAnimal = a.idAnimal "
				+ "    	inner join clientes c on c.idCliente = ani.idCliente "
				+ "    	inner join servicos s on s.idServico = a.idServico "
				+ "    	inner join funcionarios f on f.idFuncionario = a.idFuncionario "
				+ "where "
				+ "		day(data) = day(now()) and month(data) = month(now()) and year(data) = year(now());";
		
		ResultSet rs = null;
		try{
			PreparedStatement pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			ArrayList<String> RelHorario = new ArrayList<String>();
			
			while(rs.next()){
				String HoraAtendimento = rs.getString("data");
				RelHorario.add(HoraAtendimento);
			}
			rel.HoraAtendimento = RelHorario;
			
		}catch (SQLException e) {
			System.out.println("Operação não concluída.");
			e.printStackTrace();
		}
		
	}

}
