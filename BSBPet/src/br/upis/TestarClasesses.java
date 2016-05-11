package br.upis;

import java.sql.SQLException;
import java.util.List;

import br.upis.jdbc.UsuarioDAO;
import br.upis.jdbc.ClienteDAO;
import br.upis.jdbc.OrcamentoDAO;
import br.upis.jdbc.ConexaoBanco;
import br.upis.jdbc.ServicoDAO;

public class TestarClasesses {

	public static void main(String[] args) {
		orcamentobuscartodos();
	}

	private static void testeConexao() {
		// testar conexao
		ConexaoBanco t1 = new ConexaoBanco();
		t1.getConnection();
	}

	private static void testeCadastrar() {
		// testarClienteDAO
		Cliente cliente = new Cliente();
		cliente.setNome("Marco");
		cliente.setTelefone(33887676);
		cliente.setCpf("021.567.890-52");
		cliente.setEndereco("Brasília");
		cliente.setAnimal("Ave");

		ClienteDAO clientedao = new ClienteDAO();
		clientedao.inserir(cliente);
	}

	private static void testeAlterar() {
		Cliente cliente = new Cliente();
		cliente.setId(2);
		cliente.setNome("Jose");

		ClienteDAO clientedao = new ClienteDAO();
		clientedao.alterar(cliente);

	}
	
	private static void testeExcluir() {
		Cliente cliente = new Cliente();
		cliente.setId(3);
		
		ClienteDAO clientedao = new ClienteDAO();
		clientedao.excluir(cliente);

	}
	
	private static void testebuscarTodos(){
		ClienteDAO clientedao = new ClienteDAO();
		List<Cliente> listaResultado = clientedao.buscarTodos();
		
		for(Cliente c: listaResultado){
			System.out.println(c.getId()+ " "+ c.getNome()+" "+c.getTelefone()+" "+c.getCpf()+" "+
			c.getEndereco()+" "+ c.getAnimal());
		}
		
		
	}
	
	private static void testeautenticar(){
		Usuario autenticar = new Usuario();
		autenticar.setLogin("JoseBR");
		autenticar.setSenha("12345");
		
		UsuarioDAO autenticardao = new UsuarioDAO();
		System.out.println(autenticardao.existeUsuario(autenticar));	
		
		
	}

//servico
	
	private static void servicobuscarTodos(){
		ServicoDAO servicodao = new ServicoDAO();
		List<Servico> listaResultado = servicodao.buscarTodos();
		
		for(Servico c: listaResultado){
			System.out.println(c.getId()+ " "+ c.getTipo()+" "+c.getValor());
		}
		
	
	}
	
	private static void servicoCadastrar() {
			
			Servico servico = new Servico();
			servico.setTipo("Consulta");
			servico.setValor(30.0);
			
			ServicoDAO servicodao = new ServicoDAO();
			servicodao.inserir(servico);
		}

//Orcamento
	private static void orcamentobuscartodos(){
		OrcamentoDAO orcamentodao = new OrcamentoDAO();
		List<Orcamento> listaResultado = orcamentodao.buscarTodos();
		
		for(Orcamento o: listaResultado){
			System.out.println(	o.getId()+ " "
								+o.getId_cliente() + " "
								+o.getNome_cliente() + " "
								+o.getId_servico() + " "
								+o.getNome_servico() + " "
								+o.getValor() + " "
								+o.getData()
									);
			

			}
			
		}
}