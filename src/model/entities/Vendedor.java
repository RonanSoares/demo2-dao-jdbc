package model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Vendedor implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer idVend;
	private String nomeVend;
	private String email;
	private Date dataAniversario;
	private Double salarioBase;
	
	// Associação com a Classe Departamento
	Departamento departamento;
	
	// Construtor Vazio
	public Vendedor() {		
	}
	
	// Construtor com Argumentos
	public Vendedor(Integer idVend, String nomeVend, String email, Date dataAniversario, Double salarioBase, Departamento departamento) {
		this.idVend = idVend;
		this.nomeVend = nomeVend;
		this.email = email;
		this.dataAniversario = dataAniversario;
		this.salarioBase = salarioBase;
		this.departamento = departamento;
	}
	
	// Métodos Getters/Setters
	public Integer getIdVend() {
		return idVend;
	}

	public void setIdVend(Integer idVend) {
		this.idVend = idVend;
	}

	public String getNomeVend() {
		return nomeVend;
	}

	public void setNomeVend(String nomeVend) {
		this.nomeVend = nomeVend;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataAniversario() {
		return dataAniversario;
	}

	public void setDataAniversario(Date dataAniversario) {
		this.dataAniversario = dataAniversario;
	}

	public Double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	// Método HashCode / Equals  (Compara por Id)
	@Override
	public int hashCode() {
		return Objects.hash(idVend);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vendedor other = (Vendedor) obj;
		return Objects.equals(idVend, other.idVend);
	}

	@Override
	public String toString() {
		return    "Id Vendedor    : " + idVend + "\n"
				+ "Nome Vendedor  : " + nomeVend + "\n" 
				+ "Email Vendedor : " + email + "\n"
				+ "Data Nascimento: " + dataAniversario + "\n"
				+ "Salario Base   : " + salarioBase + "\n"
				+ "Departamentos " + "\n"
				+ departamento + "\n";
	}
}
