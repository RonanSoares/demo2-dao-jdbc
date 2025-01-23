package model.dao;

import java.util.List;

import model.entities.Departamento;

public interface DepartamentoDao {
	
	// Operação para Inserir dados do Departamento no BD
	void insert(Departamento obj);
	void update(Departamento obj);
	void deleteById(Integer id);
	Departamento findById(Integer id);  // Retorna um obj Departamento do id informado. Senão retorna nulo
	List<Departamento> findAll();       // Retorna uma lista de todos Departamentos
}
