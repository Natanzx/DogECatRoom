package br.com.dogcatroom.dao.implementacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.dogcatroom.bo.ClienteBO;
import br.com.dogcatroom.conexao.ConnectionFactory;
import br.com.dogcatroom.dao.IAnimalDAO;
import br.com.dogcatroom.dto.AnimalDTO;

public class AnimalDAO implements IAnimalDAO {

	private Connection con = ConnectionFactory.getConnection();
	
	@Override
	public void cadastrarAnimal(AnimalDTO a) {
		String sql = "INSERT INTO animais (idCliente, nome, tipo, raca, cor, dataNasc, sexo, pedigre, numPedigre, ativo) values (?,?,?,?,?,?,?,?,?,1)";

		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, a.getCliente().getId());
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
	public List<AnimalDTO> buscarAnimaisPeloidCliente(int idCliente) {
		String sql = "SELECT * FROM animais WHERE idCliente = ? and ativo = 1";
		List<AnimalDTO> listaAnimal = new ArrayList<AnimalDTO>();
		
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, idCliente);
			ClienteBO clienteBO = new ClienteBO();
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()){
				AnimalDTO a = new AnimalDTO();
				
				a.setIdAnimal(rs.getInt("idAnimal"));
				a.setCliente(clienteBO.buscarClientePorID(rs.getInt("idCliente")));
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
	public void excluirAnimal(int idAnimal) {
		String sql = "UPDATE animais SET ativo = 0 where idAnimal = ?";

		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, idAnimal);
			
			pstm.execute();
			pstm.close();

			System.out.println("Animal excluido com sucesso!");
		} catch (SQLException e) {
			System.out.println("Operação não concluída. ):");
			e.printStackTrace();
		}
	}

	@Override
	public AnimalDTO buscaAnimalPorID(int idAnimal) {
		String sql = "SELECT * FROM animais WHERE idAnimal = ? and ativo = 1";
		AnimalDTO a = new AnimalDTO();
		
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, idAnimal);
			ClienteBO clienteBO = new ClienteBO();
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()){
				a.setIdAnimal(rs.getInt("idAnimal"));
				a.setCliente(clienteBO.buscarClientePorID(rs.getInt("idCliente")));
				a.setNome(rs.getString("nome"));
				a.setTipo(rs.getString("tipo"));
				a.setRaca(rs.getString("raca"));
				a.setCor(rs.getString("cor"));
				a.setDataNasc(rs.getString("dataNasc"));
				a.setSexo(rs.getString("sexo"));
				a.setPedigre(rs.getInt("pedigre"));
				a.setNumPedigre(rs.getInt("numPedigre"));
			}
			pstm.close();
			System.out.println("Busca animal por id concluida com sucesso!");

		} catch (SQLException e) {
			System.out.println("Operação não concluída. ):");
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public void alterarAnimal(AnimalDTO a) {
		String sql = "UPDATE animais SET nome = ?, tipo = ?, raca = ?, cor = ?, dataNasc = ?, sexo = ?, pedigre = ?, numPedigre = ? where idAnimal = ?";

		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, a.getNome());
			pstm.setString(2, a.getTipo());
			pstm.setString(3, a.getRaca());
			pstm.setString(4, a.getCor());
			pstm.setString(5, a.getDataNasc());
			pstm.setString(6, a.getSexo());
			pstm.setInt(7, a.getPedigre());
			pstm.setInt(8, a.getNumPedigre());
			pstm.setInt(9, a.getIdAnimal());
			
			pstm.execute();
			pstm.close();

			System.out.println("Parabéns!!! Animal alterado com sucesso!");

		} catch (SQLException e) {
			System.out.println("Operação não concluída. ):");
			e.printStackTrace();
		}
	
	}

}
