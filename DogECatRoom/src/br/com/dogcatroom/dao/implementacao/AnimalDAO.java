package br.com.dogcatroom.dao.implementacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.dogcatroom.conexao.ConnectionFactory;
import br.com.dogcatroom.dao.IAnimalDAO;
import br.com.dogcatroom.dto.AnimalDTO;
import br.com.dogcatroom.dto.ClienteDTO;

public class AnimalDAO implements IAnimalDAO {

	private Connection con = ConnectionFactory.getConnection();
	
	@Override
	public void cadastrarAnimal(AnimalDTO a) {
		String sql = "INSERT INTO animais (idCliente, nome, tipo, raca, cor, dataNasc, sexo, pedigre, numPedigre, ativo) values (?,?,?,?,?,?,?,?,?,1)";

		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, a.getIdCliente());
			pstm.setString(2, a.getNome());
			pstm.setString(3, a.getTipo());
			pstm.setString(4, a.getRaca());
			pstm.setString(5, a.getCor());
			pstm.setString(6, a.getDataNasc());
			pstm.setString(7, a.getSexo());
			pstm.setInt(8, a.getPedigre());
			pstm.setInt(9, a.getNumPedigre());
			
			pstm.execute();
			pstm.close();

			System.out.println("Parabéns!!! Animal cadastrado com sucesso!");

		} catch (SQLException e) {
			System.out.println("Operação não concluída. ):");
			e.printStackTrace();
		}
	
	}

	@Override
	public List<AnimalDTO> buscarAnimaisPeloCliente(ClienteDTO c) {
		String sql = "SELECT * FROM animais WHERE idCliente = ? and ativo = 1";
		List<AnimalDTO> listaAnimal = new ArrayList<AnimalDTO>();
		
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, c.getId());
			
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()){
				AnimalDTO a = new AnimalDTO();
				
				a.setIdAnimal(rs.getInt("idAnimal"));
				a.setIdCliente(rs.getInt("idAnimal"));
				a.setNome(rs.getString("nome"));
				a.setTipo(rs.getString("tipo"));
				a.setRaca(rs.getString("raca"));
				a.setCor(rs.getString("cor"));
				a.setDataNasc(rs.getString("dataNasc"));
				a.setSexo(rs.getString("sexo"));
				a.setPedigre(rs.getInt("pedigre"));
				a.setNumPedigre(rs.getInt("numPedigre"));
				
				listaAnimal.add(a);
			}
			pstm.close();
			System.out.println("Busca animal pelo cliente concluida com sucesso!");

		} catch (SQLException e) {
			System.out.println("Operação não concluída. ):");
			e.printStackTrace();
		}
		return listaAnimal;
	}

	@Override
	public void excluirAnimal(AnimalDTO a) {
		String sql = "DELETE animais where idAnimal = ?";

		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, a.getIdAnimal());
			
			pstm.execute();
			pstm.close();

			System.out.println("Animal excluido com sucesso!");
		} catch (SQLException e) {
			System.out.println("Operação não concluída. ):");
			e.printStackTrace();
		}
	}

}
