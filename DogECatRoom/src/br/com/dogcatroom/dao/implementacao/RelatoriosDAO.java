package br.com.dogcatroom.dao.implementacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
		public List<RelatoriosDTO> RelatorioAtendimentosPorHorario() {
			String sql = 
					  	" SELECT h.horarios, count(a.idAtendimento) as contHorarios "
					  + "	from horarios h "
					  + "		left join atendimentos a on date_format(a.data,'%H') = date_format(h.horarios,'%H') "
					  + "	group by h.horarios order by 1 ";
			
			List<RelatoriosDTO> lista = new ArrayList<RelatoriosDTO>();
			// Constroi PrepareStatement com sql
			try {
				PreparedStatement pstm = con.prepareStatement(sql);
				ResultSet resultado = pstm.executeQuery();

				while (resultado.next()) {
					RelatoriosDTO Horarios = new RelatoriosDTO();
					Horarios.setHorarios(resultado.getString("horarios"));
					Horarios.setCountHorarios(resultado.getString("contHorarios"));
					
					lista.add(Horarios);
				}	
				pstm.close();
				System.out.println("Buscar todos registros com sucesso!");
			} catch (SQLException e) {
				e.printStackTrace();
			}return lista;
			
		}

}
