package br.com.dogcatroom.dto;

public class ClienteDTO {

	private Long id;
	private String nome;
	private String cpf;
	private EnderecoDTO endereco;
	private TelefoneDTO telefone;
	private AnimalDTO animal;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public EnderecoDTO getEndereco() {
		return endereco;
	}
	public void setEndereco(EnderecoDTO endereco) {
		this.endereco = endereco;
	}
	public TelefoneDTO getTelefone() {
		return telefone;
	}
	public void setTelefone(TelefoneDTO telefone) {
		this.telefone = telefone;
	}
	public AnimalDTO getAnimal() {
		return animal;
	}
	public void setAnimal(AnimalDTO animal) {
		this.animal = animal;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
