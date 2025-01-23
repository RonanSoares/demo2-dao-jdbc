package application;

import java.util.Date;

import model.entities.Departamento;
import model.entities.Vendedor;

public class Program {

	public static void main(String[] args) {
		
		Departamento obj = new Departamento(1, "Informática");
		
		System.out.println("Departamentos");
		System.out.println(obj);
		
		System.out.println("=====================================");
		
		Vendedor vend = new Vendedor(1, "Ronan Soares", "ronan@gmail.com", new Date(), 3000.0, obj);
		
		System.out.println("Vendedores");
		System.out.println(vend);

	}

}
