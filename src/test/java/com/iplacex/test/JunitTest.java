
package com.iplacex.test;
import static org.testng.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.iplacex.app.Conexion;
import com.iplacex.app.Login;
import com.iplacex.app.FindUser;


public class JunitTest {
	
	public JunitTest() {
		
	}
	@BeforeClass
	public static void setUpClass() {}
	@AfterClass
	public static void tearDownClass() {}
	@Before
	public void setUp() {}
	@After 
	public void tearDown() {}
	
	@Test
	public void TestConexionRealPass() {
		System.out.println("Probando Conexión Con contraseña Correcta");
		Conexion conn = new Conexion();
		conn.conectar("Fenasantma");
	}
	@Test
	public void TestLoginFalse() {
		System.out.println("Probando Login. contraseña incorrecta");
		Login log = new Login();
		boolean esperado= false;
		boolean real = log.TryLogin("user", "pas");
		Assert.assertEquals(esperado, real);
	}
	public void TestLoginTrue() {
		System.out.println("Probando Login. contraseña incorrecta");
		Login log = new Login();
		boolean esperado= true;
		boolean real = log.TryLogin("user", "pass");
		Assert.assertEquals(esperado, real);
	}
	@Test
	public void TestQueryUser() {
		System.out.println("Probando busqueda de usuario gestRutByUser que retorna rut, Con usuario correcto.");
		FindUser find = new FindUser();
		
		String esperado = "12345678";
		String real = find.getRutbyUser("user");
		Assert.assertEquals(esperado, real);
	}
	@Test
	public void TestQuery3() {
		System.out.println("Probando busqueda de Persona gestPerson.");
		FindUser find = new FindUser();
		find.getPerson("12345678");	
	}
	@Test
	public void TestConexionFailPass() {
		System.out.println("Probando Conexión con contraseña incorrecta");
		Conexion conn = new Conexion();
		conn.conectar("llll");
	}
}
	
