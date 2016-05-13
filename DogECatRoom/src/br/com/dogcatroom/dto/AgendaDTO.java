package br.com.dogcatroom.dto;

public class AgendaDTO {

	private int id;
	private String data;
	private String hora;
	private String nome;
	private AnimalDTO animal;
	private ServicoDTO servico;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public AnimalDTO getAnimal() {
		return animal;
	}
	public void setAnimal(AnimalDTO animal) {
		this.animal = animal;
	}
	public ServicoDTO getServico() {
		return servico;
	}
	public void setServico(ServicoDTO servico) {
		this.servico = servico;
	}
	
	
}
