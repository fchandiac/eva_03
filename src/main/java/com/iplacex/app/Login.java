package com.iplacex.app;
import com.iplacex.app.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Login {
	
	public Login() {}
	
	public boolean TryLogin (String user_in, String pass_in) {
		Conexion conn = new Conexion(); 
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		
		
		try {
			cn = conn.conectar("Fenasantma");
			stm = cn.createStatement();
			rs = stm.executeQuery("SELECT * FROM iplacex.usuario WHERE username = '"+user_in+"'");
			String user = "";
			String pass = "";
			
			while (rs.next()) {
				int id = rs.getInt(1);
				user = rs.getString(3);
				pass = rs.getString(4);
				
				System.out.println("id:"+ id + " - user: " + user + " - pass: " + pass);
				
			}
			
			boolean result = false;
			
			if(pass.equals(pass_in)== true) {
				System.out.println("Login true");
				result = true;
			} else {
				System.out.println("Login false");
				result = false;
				
			}
			
			return result;
	
			
	} catch(SQLException e) {
		e.printStackTrace();
		}
		return false;
	}

}
