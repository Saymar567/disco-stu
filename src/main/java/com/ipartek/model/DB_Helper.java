package com.ipartek.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.model.dto.Categoria;
import com.ipartek.model.dto.Disco;
import com.ipartek.model.dto.V_Disco;

public class DB_Helper implements I_Conexion {

	public Connection conectar() {
		
		Connection con = null;
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(CONEXION, USER, PASS);
			
		} catch(ClassNotFoundException e) {
			System.out.println("No se encontró el driver" + e);
		} catch(SQLException e) {
			System.out.println("Problema conectando" + e);
		} catch (Exception e) {
			System.out.println("No ha conectado" + e);
		}
		
		return con;
		
	}
	
	public void desconectar(Connection con) {
		try {
			con.close();
			System.out.println("DESCONECTADO DE LA BD");
		} catch (SQLException e) {
			System.out.println("PROBLEMA AL DESCONECTAR.");
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("PROBLEMA PROBLEMILLA, FLANDERS");
			e.printStackTrace();
		}
	}

	public List<V_Disco> obtenerTodos(Connection con) {
		
		try {
			List<V_Disco> list = new ArrayList<>();
			
			String sql = SP_DISCOS_OBTENER_TODOS;
			
			CallableStatement cstmt = con.prepareCall(sql);
			
			cstmt.execute();
			
			ResultSet rs = cstmt.getResultSet();
			
			while(rs.next()) {
				V_Disco disc = new V_Disco();
				
				disc.setId(rs.getInt(V_DISCOS_ID));
				disc.setTitle(rs.getString(V_DISCOS_TITLE));
				disc.setGroupname(rs.getString(V_DISCOS_GROUP));
				disc.setPrice(rs.getDouble(V_DISCOS_PRICE));
				disc.setYear(rs.getString(V_DISCOS_YEAR));
				disc.setFK_categoria(rs.getInt(V_DISCOS_FK_CATEGORIA));
				disc.setCategoria(rs.getString(V_DISCOS_CATEGORIA));
				
				list.add(disc);
			}
			return list;
			
		} catch (SQLException e) {
			System.out.println("es aquí el problema?");
			e.printStackTrace();
			return new ArrayList<>();
		}
		
		
		
	}

	public List<Categoria> obtenerCategorias(Connection con) {
		
		try {
			List<Categoria> list = new ArrayList<>();
			String sql = SP_CATEGORIAS_OBTENER_TODAS;
			
			CallableStatement cstmt = con.prepareCall(sql);
			cstmt.execute();
			
			ResultSet rs = cstmt.getResultSet();
			
			while(rs.next()) {
				Categoria cat = new Categoria();
				
				cat.setId(rs.getInt(CATEGORIAS_ID));
				cat.setNombre(rs.getString(CATEGORIAS_NOMBRE));
				
				list.add(cat);
			}
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}

	public V_Disco obtenerPorId(Connection con, int id) {
		
		try {
			V_Disco disc = new V_Disco();
			
			String sql = SP_DISCOS_OBTENER_POR_ID;
			
			CallableStatement cstmt = con.prepareCall(sql);
			cstmt.setInt(1, id);
			cstmt.execute();
			
			ResultSet rs = cstmt.getResultSet();
			
			while(rs.next()) {
				disc.setId(rs.getInt(V_DISCOS_ID));
				disc.setTitle(rs.getString(V_DISCOS_TITLE));
				disc.setGroupname(rs.getString(V_DISCOS_GROUP));
				disc.setPrice(rs.getDouble(V_DISCOS_PRICE));
				disc.setYear(rs.getString(V_DISCOS_YEAR));
				disc.setFK_categoria(rs.getInt(V_DISCOS_FK_CATEGORIA));
				disc.setCategoria(rs.getString(V_DISCOS_CATEGORIA));
				
			}
			return disc;
			
		} catch (Exception e) {
			System.out.println("no obtiene por id" + e);
			return new V_Disco();
		}
		
	}

	public void insertarDisco(Connection con, Disco disc) {
		
		try {
			String sql = SP_DISCOS_INSERTAR;
			
			CallableStatement cstmt = con.prepareCall(sql);
			
			cstmt.setString(1, disc.getTitle());
			cstmt.setString(2, disc.getGroupname());
			cstmt.setString(3, disc.getYear());
			cstmt.setDouble(4, disc.getPrice());
			cstmt.setInt(5, disc.getFK_categoria());
			
			cstmt.execute();
			
			
			
		} catch (Exception e) {
			System.out.println("no se pudo insertar");
			e.printStackTrace();
		}
		
	}

	public void borrarDisco(Connection con, int id) {
		try {
			String sql = SP_DISCOS_BORRAR;
			
			CallableStatement cstmt = con.prepareCall(sql);
			cstmt.setInt(1, id);
			cstmt.execute();
			
		} catch (Exception e) {
			System.out.println("no borra" + e);
		}
		
	}

	public void modificarDisco(Connection con, Disco disc) {
		try {
			String sql = SP_DISCOS_MODIFICAR;
			
			CallableStatement cstmt = con.prepareCall(sql);
			
			cstmt.setInt(1, disc.getId());
			cstmt.setString(2, disc.getTitle());
			cstmt.setString(3, disc.getGroupname());
			cstmt.setString(4, disc.getYear());
			cstmt.setDouble(5, disc.getPrice());
			cstmt.setInt(6, disc.getFK_categoria());
			
			
			cstmt.execute();
			
			
		} catch (Exception e) {
		System.out.println("No modifica, don't know why" + e);	
	
		}
		
	}

	public List<V_Disco> buscarDisco(Connection con, String text) {
		
		try {
			
		List<V_Disco> list = new ArrayList<>();
		
		String sql = SP_DISCOS_FULLTEXT;
		
		CallableStatement cstmt = con.prepareCall(sql);
		
		cstmt.setString(1, text);
		
		cstmt.execute();
		
		ResultSet rs = cstmt.getResultSet();
		
		while(rs.next()) {
			V_Disco disc = new V_Disco();
			
			disc.setId(rs.getInt(V_DISCOS_ID));
			disc.setTitle(rs.getString(V_DISCOS_TITLE));
			disc.setGroupname(rs.getString(V_DISCOS_GROUP));
			disc.setPrice(rs.getDouble(V_DISCOS_PRICE));
			disc.setYear(rs.getString(V_DISCOS_YEAR));
			disc.setFK_categoria(rs.getInt(V_DISCOS_FK_CATEGORIA));
			disc.setCategoria(rs.getString(V_DISCOS_CATEGORIA));
			
			list.add(disc);
		}
		return list;
		
	} catch (SQLException e) {
		System.out.println("es aquí el problemilla?");
		e.printStackTrace();
		return new ArrayList<>();
	}
	
}

	public void borrarTodos(Connection con, String[] listaId) {
		try {
			String sql = SP_DISCOS_BORRAR;
			
			CallableStatement cstmt = con.prepareCall(sql);
			
			for(String elem:listaId) {
				
				cstmt.setString(1, elem);
				cstmt.execute();
			}
			
		} catch (Exception e) {
			System.out.println("No entiendo qué cohone pasa" + e);
		}
		
	}
	
	
	
}
