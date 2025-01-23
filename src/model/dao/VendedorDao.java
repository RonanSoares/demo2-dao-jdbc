package model.dao;

import java.util.List;

import model.entities.Departamento;
import model.entities.Vendedor;

public interface VendedorDao {
	
	// Operação para Inserir dados do Vendedor no BD
		void insert(Vendedor obj);
		void update(Vendedor obj);
		void deleteById(Integer id);
		Vendedor findById(Integer id);  // Retorna um obj Vendedor do id informado. Senão retorna nulo
		List<Vendedor> findAll();       // Retorna uma lista de todos Vendedores
}
