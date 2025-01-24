package application;

import java.util.Date;

import model.dao.DaoFactory;
import model.dao.VendedorDao;
import model.entities.Departamento;
import model.entities.Vendedor;

public class Program {

	public static void main(String[] args) {
		
		VendedorDao vendedorDao = DaoFactory.createVendedorDao();  // Instancia o VendedorDao
		
		Vendedor vendedor = vendedorDao.findById(3);               // Variável vendedor recebe a função retornar vendedor por id
		
		System.out.println(vendedor);
	
	}
}
