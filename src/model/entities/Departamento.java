package model.entities;

import java.io.Serializable;
import java.util.Objects;

// implements Serializable, para que os objetos sejam transformados em sequencias de bytes (Tráfego em redes, arquivos etc).
public class Departamento implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer idDep;
	private String nomeDep;
	
	// Construtor vazio
	public Departamento() {		
	}
	
	// Construtor com Argumentos
	public Departamento(Integer idDep, String nomeDep) {
		this.idDep = idDep;
		this.nomeDep = nomeDep;
	}
	
	// Métodos Getters/Setters
	public Integer getIdDep() {
		return idDep;
	}

	public void setIdDep(Integer idDep) {
		this.idDep = idDep;
	}

	public String getNomeDep() {
		return nomeDep;
	}

	public void setNomeDep(String nomeDep) {
		this.nomeDep = nomeDep;
	}
	
	// Método HashCode/Equals - Comparar por Id
	@Override
	public int hashCode() {
		return Objects.hash(idDep);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Departamento other = (Departamento) obj;
		return Objects.equals(idDep, other.idDep);
	}
	
	// Método toString
	@Override
	public String toString() {
		return    "Id    : " + idDep + "\n"
				+ "Depart: " + nomeDep;
	}
}
