package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.VendedorDao;
import model.entities.Departamento;
import model.entities.Vendedor;

// Implementação dos métodos da Interface VendedorDao (CRUD)
public class VendedorDaoJDBC implements VendedorDao{
	
	
	private Connection conn;  // Cria o atributo de Conexão
	
	// Construtor para injeção de dependência
	public VendedorDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Vendedor obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Vendedor obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}
	
	// Busca o registro em um BD, pelo id.
	@Override
	public Vendedor findById(Integer id) {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(
					
				"SELECT seller. *, department.Name as DepName "  // Selecione todo campos tb seller e department nome, apelido DepName
				+ "FROM seller INNER JOIN department "           // Junção das tabelas seller e department
				+ "ON seller.DepartmentId = department.Id "      // Onde Chave Estrangeira da tbl seller = ao id da tbl department
				+ "WHERE seller.id = ? ");                       // Onde id da tbl seller = a alguma coisa.
			
			ps.setInt(1, id);                                    // 1 Interrogação recebe o id do parâmetro da função findById.
			rs = ps.executeQuery();                              // rs recebe a execução do cmdo SQL. Apesar de pega em forma de tbl. Tem q transformar em obj
			if(rs.next()) {                                     // Se o rs.next der falso (Não retornou nada). Não tem vendedor com o id informado.
				
				// CRIA FUNÇÃO  DAS INSTANCIAÇÕES PARA REUTILIZAÇÃO DOS CÓDIGOS	
				Departamento dep = instantiateDepartment(rs);   // Chama o método
				Vendedor vend = instanciateVendedor(rs, dep);   // Chama o método inst..Ven..
				vend.setDepartamento(dep);                      // Associação entre os obj Departamento e Vendedor
				return vend;                                    // Retorna o obj vend 				
			}			
			return null;       // Pula o if e retorna nulo.			
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		// Fecha os recursos
		finally {
			DB.closeStatement(ps);
			DB.closeResultSet(rs);
			// DB.closeConnection();  Não fecha a conexão, pois pode usar o dao para fazer outras operações. (Fecha a conexão no Prog principal)
		}
	}
	private Vendedor instanciateVendedor(ResultSet rs, Departamento dep) throws SQLException {
		Vendedor vend = new Vendedor();          // Instancia o Vendedor
		vend.setIdVend(rs.getInt("Id"));         // Seta o Id no obj vend
		vend.setNomeVend(rs.getString("Name"));  // Seta o Nome no obj vend
		vend.setEmail(rs.getString("Email"));
		vend.setSalarioBase(rs.getDouble("BaseSalary"));
		vend.setDataAniversario(rs.getDate("BirthDate"));
		return vend;
	}

	// Cria a função para instanciar os objetos
	private Departamento instantiateDepartment(ResultSet rs) throws SQLException {
		Departamento dep = new Departamento();   // Instancia
		dep.setIdDep(rs.getInt("DepartmentId")); // Seta no obj dep o Id do DepartmentId.
		dep.setNomeDep(rs.getString("DepName")); // Seta no obj dep o Nome do Departamento
		return dep;	
	}

	@Override
	public List<Vendedor> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
