package com.iplacex.app;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FindUser {
	
	public FindUser() {}
	
	public String getRutbyUser (String user_in)  {
		Conexion conn = new Conexion(); 
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		
		
		try {
			cn = conn.conectar("Fenasantma");
			stm = cn.createStatement();
			rs = stm.executeQuery("SELECT * FROM iplacex.usuario WHERE username = '"+user_in+"'");
			String rut ="";
			
			while (rs.next()) {
				rut = rs.getString(2);
				System.out.println("rut:"+ rut);
			}
			return rut;
	
			
	} catch(SQLException e) {
		e.printStackTrace();
		}
		return "usuario no encontrado";
	}
	
	public String getPerson(String rut_in) {
		Conexion conn = new Conexion(); 
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		
		
		try {
			cn = conn.conectar("Fenasantma");
			stm = cn.createStatement();
			rs = stm.executeQuery("SELECT * FROM iplacex.persona WHERE rut = '"+rut_in+"'");
			String result = "";
			
			while (rs.next()) {
				result = "Rut: "+rs.getString(1)+" Nombre: "+rs.getString(2)+" Apellido: "+rs.getString(3);
				System.out.println(result);
			}
			return result;
	
			
	} catch(SQLException e) {
		e.printStackTrace();
		}
		return "usuario no encontrado";
	}
		
	

}
