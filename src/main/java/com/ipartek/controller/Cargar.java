package com.ipartek.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.model.DB_Helper;
import com.ipartek.model.I_Conexion;
import com.ipartek.model.dto.Categoria;
import com.ipartek.model.dto.V_Disco;


@WebServlet("/Cargar")
public class Cargar extends HttpServlet implements I_Conexion {
	private static final long serialVersionUID = 1L;
   
    public Cargar() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DB_Helper db = new DB_Helper();
		Connection con = db.conectar();
		
		List<V_Disco> listaDiscos = db.obtenerTodos(con);
		List<Categoria> listaCategorias = db.obtenerCategorias(con);
		
		db.desconectar(con);
		
		request.setAttribute(ATR_LISTA_DISCOS, listaDiscos);
		request.setAttribute(ATR_LISTA_CATEGORIAS, listaCategorias);
		
		request.getRequestDispatcher(JSP_INDEX).forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
