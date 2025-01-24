package model.dao;

import db.DB;
import model.dao.impl.VendedorDaoJDBC;

// Classe responsável para Instanciar os DAOs
public class DaoFactory {
	
	public static VendedorDao createVendedorDao() {
		
		return new VendedorDaoJDBC(DB.getConnection()); // Cria obj VendedorDaoJDBC (Tem q passar o getConnection como argumento senã0 dá erro)
		
	}
}
