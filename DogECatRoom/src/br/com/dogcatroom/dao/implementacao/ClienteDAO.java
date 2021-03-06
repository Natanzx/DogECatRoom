package br.com.dogcatroom.dao.implementacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.dogcatroom.bo.ClienteBO;
import br.com.dogcatroom.conexao.ConnectionFactory;
import br.com.dogcatroom.dao.IClienteDAO;
import br.com.dogcatroom.dto.AnimalDTO;
import br.com.dogcatroom.dto.ClienteDTO;


public class ClienteDAO implements IClienteDAO {

	private Connection con = ConnectionFactory.getConnection();

	public void cadastrarCliente(ClienteDTO cliente) {
		
		String sql = "call ClienteInserirListar(?,?,?,?,?,?,?,?,?,?,?);";
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, cliente.getNome());
			preparador.setString(2, cliente.getCpf());
			preparador.setString(3, cliente.getEndereco());
			preparador.setString(4, cliente.getCep());
			preparador.setInt(5, cliente.getNumero());
			preparador.setString(6, cliente.getComplemento());
			preparador.setString(7, cliente.getBairro());
			preparador.setString(8, cliente.getCidade());
			preparador.setString(9, cliente.getEstado());
			preparador.setString(10, cliente.getTelCelular());
			preparador.setString(11, cliente.getTelFixo());
			
			
			ResultSet rs = preparador.executeQuery();
			
			while(rs.next()){
				cliente.setId(rs.getInt("idCliente"));
			}
			preparador.close();

			System.out.println("Parab�ns!!! Cliente cadastrado com sucesso!");

		} catch (SQLException e) {

			System.out.println("Opera��o n�o conclu�da.");

			e.printStackTrace();
		}

	}
	
	public void alterarCliente(ClienteDTO cliente) {

		String sql = "update clientes set nome=?, cpf=?,endereco=?,numero=?,complemento=?,bairro=?,cidade=?,estado=?,telCelular=?,telFixo=?,cep=?,ativo=? "
				+"where idCliente = ?";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, cliente.getNome());
			preparador.setString(2, cliente.getCpf());
			preparador.setString(3, cliente.getEndereco());
			preparador.setInt(4, cliente.getNumero());
			preparador.setString(5, cliente.getComplemento());
			preparador.setString(6, cliente.getBairro());
			preparador.setString(7, cliente.getCidade());
			preparador.setString(8, cliente.getEstado());
			preparador.setString(9, cliente.getTelCelular());
			preparador.setString(10, cliente.getTelFixo());
			preparador.setString(11, cliente.getCep());
			preparador.setInt(12, cliente.getAtivo());
			preparador.setInt(13, cliente.getId());

			preparador.execute();
			preparador.close();

			System.out.println("Cliente alterado com sucesso!");

		} catch (SQLException e) {

			System.out.println("Opera��o n�o conclu�da. ):");

			e.printStackTrace();
		}

	}
	
	public void excluirCliente(ClienteDTO cliente) {
		String sql = "update clientes set ativo = 0 where idCliente = ?";

		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, cliente.getId());
			pstm.execute();
			pstm.close();
			System.out.println("Cliente excluido com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public List<ClienteDTO> buscarTodosClientes() {
		String sql = "SELECT * FROM clientes where ativo = 1";
		List<ClienteDTO> lista = new ArrayList<ClienteDTO>();
		try {
			PreparedStatement pstm = con.prepareStatement(sql);

			ResultSet resultado = pstm.executeQuery();

			while (resultado.next()) {
				ClienteDTO cliente = new ClienteDTO();
				
				cliente.setId(Integer.parseInt(resultado.getString("idCliente")));
				cliente.setNome(resultado.getString("nome"));
				cliente.setCpf(resultado.getString("cpf"));
				cliente.setEndereco(resultado.getString("endereco"));
				cliente.setNumero(resultado.getInt("numero"));
				cliente.setComplemento(resultado.getString("complemento"));
				cliente.setBairro(resultado.getString("bairro"));
				cliente.setCidade(resultado.getString("cidade"));
				cliente.setEstado(resultado.getString("estado"));
				cliente.setTelCelular(resultado.getString("telCelular"));
				cliente.setTelFixo(resultado.getString("telFixo"));
				cliente.setCep(resultado.getString("cep"));

				lista.add(cliente);

			}

			pstm.close();
			System.out.println("Buscar todos clientes com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
		}return lista;

	}
	
	public List<ClienteDTO> buscarClienteAnimais() {
		String sql = "SELECT * FROM clientes where ativo = 1";
		
		List<ClienteDTO> lista = new ArrayList<ClienteDTO>();
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			
			ResultSet resultado = pstm.executeQuery();

			while (resultado.next()) {
				ClienteDTO cliente = new ClienteDTO();
				
				cliente.setId(Integer.parseInt(resultado.getString("idCliente")));
				cliente.setNome(resultado.getString("nome"));
				cliente.setCpf(resultado.getString("cpf"));
				cliente.setEndereco(resultado.getString("endereco"));
				cliente.setNumero(resultado.getInt("numero"));
				cliente.setComplemento(resultado.getString("complemento"));
				cliente.setBairro(resultado.getString("bairro"));
				cliente.setCidade(resultado.getString("cidade"));
				cliente.setEstado(resultado.getString("estado"));
				cliente.setTelCelular(resultado.getString("telCelular"));
				cliente.setTelFixo(resultado.getString("telFixo"));
				cliente.setCep(resultado.getString("cep"));
				cliente.setAnimal(buscarAnimalPorCliente(cliente));
				lista.add(cliente);

			}

			pstm.close();
			System.out.println("Buscar todos clientes com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
		}return lista;

	}
	
	public List<AnimalDTO> buscarAnimalPorCliente(ClienteDTO cliente){
		String sql = "SELECT a.* FROM clientes c inner join animais a on a.idCliente = c.idCliente and c.idCliente = ? where c.ativo = 1";
		List<AnimalDTO> listaAnimal = new ArrayList<AnimalDTO>();
		
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, cliente.getId());
			ClienteBO clienteBO = new ClienteBO();
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
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
			
		}catch (SQLException e) {
			e.printStackTrace();
		}return listaAnimal;
	}

	public ClienteDTO buscarClientePorID(Integer id) {
		String sql = "SELECT * FROM clientes WHERE idCliente = ?";
		ClienteDTO cliente = null;
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);
			ResultSet resultado = pstm.executeQuery();
			
			if(resultado.next()) { 
				cliente = new ClienteDTO();
				cliente.setNome(resultado.getString("nome"));
				cliente.setCpf(resultado.getString("cpf"));
				cliente.setEndereco(resultado.getString("endereco"));
				cliente.setNumero(Integer.parseInt(resultado.getString("numero")));
				cliente.setComplemento(resultado.getString("complemento"));
				cliente.setBairro(resultado.getString("bairro"));
				cliente.setCidade(resultado.getString("cidade"));
				cliente.setEstado(resultado.getString("estado"));
				cliente.setTelCelular(resultado.getString("telCelular"));
				cliente.setTelFixo(resultado.getString("telFixo"));
				cliente.setCep(resultado.getString("cep"));
				cliente.setId(id);
	}

			pstm.close();
			System.out.println("Buscar por ID com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
		}return cliente;

	}
	
	public ClienteDTO buscarClientePorCPF(String CPF) {
		String sql = "SELECT * FROM clientes WHERE CPF = ?";
		ClienteDTO cliente = null;
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, CPF);
			ResultSet resultado = pstm.executeQuery();
			
			if(resultado.next()) { 
				cliente = new ClienteDTO();
				cliente.setId(resultado.getInt("idCliente"));
				cliente.setNome(resultado.getString("nome"));
				cliente.setCpf(resultado.getString("cpf"));
				cliente.setEndereco(resultado.getString("endereco"));
				cliente.setNumero(Integer.parseInt(resultado.getString("numero")));
				cliente.setComplemento(resultado.getString("complemento"));
				cliente.setBairro(resultado.getString("bairro"));
				cliente.setCidade(resultado.getString("cidade"));
				cliente.setEstado(resultado.getString("estado"));
				cliente.setTelCelular(resultado.getString("telCelular"));
				cliente.setTelFixo(resultado.getString("telFixo"));
				cliente.setCep(resultado.getString("cep"));
	}

			pstm.close();
			System.out.println("Buscar por CPF com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
		}return cliente;

	}	

}
