package br.com.dogcatroom.dao.implementacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.dogcatroom.conexao.ConnectionFactory;
import br.com.dogcatroom.dao.IFuncionarioDAO;
import br.com.dogcatroom.dto.FuncionarioDTO;

public class FuncionarioDAO implements IFuncionarioDAO {

	private Connection con = ConnectionFactory.getConnection();

	@Override
	public void cadastrarFuncionario(FuncionarioDTO funcionarioDTO) {

		String sql = "INSERT INTO funcionarios (nome,cpf,matricula,endereco,numero,complemento,bairro,cidade,estado,telcelular,telfixo,escolaridade,ocupacao,salario,ativo,login,senha) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);

			preparador.setString(1, funcionarioDTO.getNome());
			preparador.setString(2, funcionarioDTO.getCpf());
			preparador.setInt(3, funcionarioDTO.getMatricula());
			preparador.setString(4, funcionarioDTO.getEndereco());
			preparador.setString(5, funcionarioDTO.getNumero());
			preparador.setString(6, funcionarioDTO.getComplemento());
			preparador.setString(7, funcionarioDTO.getBairro());
			preparador.setString(8, funcionarioDTO.getCidade());
			preparador.setString(9, funcionarioDTO.getEstado());
			preparador.setString(10, funcionarioDTO.getTelCelular());
			preparador.setString(11, funcionarioDTO.getTelFixo());
			preparador.setString(12, funcionarioDTO.getEscolaridade());
			preparador.setString(13, funcionarioDTO.getOcupacao());
			preparador.setDouble(14, funcionarioDTO.getSalario());
			preparador.setBoolean(15, funcionarioDTO.isAtivo());
			preparador.setString(16, funcionarioDTO.getLogin());
			preparador.setString(17, funcionarioDTO.getSenha());

			preparador.execute();
			preparador.close();
			System.out.println("Parabéns!!! Cadastrado com sucesso!");

		} catch (SQLException e) {
//			e.printStackTrace();
			System.out.println("erro ao cadastrar");
		}
	}

	@Override
	public void alterarFuncionario(FuncionarioDTO funcionarioDTO) {

		String sql = "UPDATE funcionarios SET nome=?, cpf=?,matricula=?,endereco=?,numero=?,complemento=?,bairro=?,cidade=?,estado=?,telcelular=?,telfixo=?,escolaridade=?,ocupacao=?,salario=?,ativo=?,login=?"
				+ " where idFuncionario = ? ";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);

			preparador.setString(1, funcionarioDTO.getNome());
			preparador.setString(2, funcionarioDTO.getCpf());
			preparador.setInt(3, funcionarioDTO.getMatricula());
			preparador.setString(4, funcionarioDTO.getEndereco());
			preparador.setString(5, funcionarioDTO.getNumero());
			preparador.setString(6, funcionarioDTO.getComplemento());
			preparador.setString(7, funcionarioDTO.getBairro());
			preparador.setString(8, funcionarioDTO.getCidade());
			preparador.setString(9, funcionarioDTO.getEstado());
			preparador.setString(10, funcionarioDTO.getTelCelular());
			preparador.setString(11, funcionarioDTO.getTelFixo());
			preparador.setString(12, funcionarioDTO.getEscolaridade());
			preparador.setString(13, funcionarioDTO.getOcupacao());
			preparador.setDouble(14, funcionarioDTO.getSalario());
			preparador.setBoolean(15, funcionarioDTO.isAtivo());
			preparador.setString(16, funcionarioDTO.getLogin());
			preparador.setInt(17, funcionarioDTO.getId());

			preparador.execute();
			preparador.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<FuncionarioDTO> buscarTodosFuncionariosAtivo() {
		String sql = "SELECT * FROM funcionarios where ativo = 1";

		List<FuncionarioDTO> listaFuncionario = new ArrayList<FuncionarioDTO>();
		try {
			PreparedStatement pstm = con.prepareStatement(sql);

			ResultSet resultado = pstm.executeQuery();

			while (resultado.next()) {
				FuncionarioDTO funcionarioDTO = new FuncionarioDTO();

				funcionarioDTO.setId(Integer.parseInt(resultado.getString("idFuncionario")));
				funcionarioDTO.setNome(resultado.getString("nome"));
				funcionarioDTO.setCpf(resultado.getString("cpf"));
				funcionarioDTO.setMatricula(Integer.parseInt(resultado.getString("matricula")));
				funcionarioDTO.setEndereco(resultado.getString("endereco"));
				funcionarioDTO.setNumero(resultado.getString("numero"));
				funcionarioDTO.setComplemento(resultado.getString("complemento"));
				funcionarioDTO.setBairro(resultado.getString("bairro"));
				funcionarioDTO.setCidade(resultado.getString("cidade"));
				funcionarioDTO.setEstado(resultado.getString("estado"));
				funcionarioDTO.setTelCelular(resultado.getString("telCelular"));
				funcionarioDTO.setTelFixo(resultado.getString("telFixo"));
				funcionarioDTO.setEscolaridade(resultado.getString("escolaridade"));
				funcionarioDTO.setOcupacao(resultado.getString("ocupacao"));
				funcionarioDTO.setSalario(Double.parseDouble(resultado.getString("salario")));
				funcionarioDTO.setAtivo(Boolean.parseBoolean(resultado.getString("ativo")));
				funcionarioDTO.setLogin(resultado.getString("login"));
				
				listaFuncionario.add(funcionarioDTO);

			}

			pstm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaFuncionario;

	}

	@Override
	public FuncionarioDTO buscarFuncionarioPorID(FuncionarioDTO funcionarioDTO) throws SQLException {
		String sql = "SELECT * FROM funcionarios WHERE idFuncionario = ? ";

		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setInt(1, funcionarioDTO.getId());
		ResultSet resultado = pstm.executeQuery();

		if (resultado.next()) {
			FuncionarioDTO funcionario = new FuncionarioDTO();
			
			funcionarioDTO.setNome(resultado.getString("nome"));
			funcionarioDTO.setCpf(resultado.getString("cpf"));
			funcionarioDTO.setMatricula(Integer.parseInt(resultado.getString("matricula")));
			funcionarioDTO.setEndereco(resultado.getString("endereco"));
			funcionarioDTO.setNumero(resultado.getString("numero"));
			funcionarioDTO.setComplemento(resultado.getString("complemento"));
			funcionarioDTO.setBairro(resultado.getString("bairro"));
			funcionarioDTO.setCidade(resultado.getString("cidade"));
			funcionarioDTO.setEstado(resultado.getString("estado"));
			funcionarioDTO.setTelCelular(resultado.getString("telCelular"));
			funcionarioDTO.setTelFixo(resultado.getString("telFixo"));
			funcionarioDTO.setEscolaridade(resultado.getString("escolaridade"));
			funcionarioDTO.setOcupacao(resultado.getString("ocupacao"));
			funcionarioDTO.setSalario(Double.parseDouble(resultado.getString("salario")));
			funcionarioDTO.setAtivo(Boolean.parseBoolean(resultado.getString("ativo")));
			funcionarioDTO.setLogin(resultado.getString("login"));
		}

		pstm.close();
		
		return funcionarioDTO;
	}
	
	public FuncionarioDTO validaLogin(FuncionarioDTO func){
		String sql = "SELECT * FROM funcionarios WHERE login = ? and senha = ?";
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1,func.getLogin());
			pstm.setString(2,func.getSenha());
			ResultSet resultado = pstm.executeQuery();
			
			if(resultado.next()){
				func.setId(resultado.getInt("idFuncionario"));
				func.setNome(resultado.getString("nome"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return func;
	}

	@Override
	public FuncionarioDTO recuperarSenha(FuncionarioDTO func) {
		String sql = "SELECT * FROM funcionarios WHERE cpf = ? and login = ?";
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1,func.getCpf());
			pstm.setString(2,func.getLogin());
			ResultSet resultado = pstm.executeQuery();
			
			if(resultado.next()){
				func.setId(resultado.getInt("idFuncionario"));
				func.setNome(resultado.getString("nome"));
				func.setSenha(resultado.getString("senha"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return func;
	}	

}
