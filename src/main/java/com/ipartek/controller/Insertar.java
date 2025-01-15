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
import com.ipartek.model.dto.Disco;
import com.ipartek.model.dto.V_Disco;


@WebServlet("/Insertar")
public class Insertar extends HttpServlet implements I_Conexion{
	private static final long serialVersionUID = 1L;
       
   
    public Insertar() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title = "";
		if(request.getParameter("p_nombre")!= null && !request.getParameter("p_nombre").trim().isEmpty()) {
			title = request.getParameter("p_nombre");
		}
		
		String group = "";
		if(request.getParameter("p_grupo")!= null && !request.getParameter("p_grupo").trim().isEmpty()) {
			group = request.getParameter("p_grupo");
		}
		
		String releaseDate= "";
		
		if(request.getParameter("p_year")!= null && !request.getParameter("p_year").trim().isEmpty()) {
			releaseDate = request.getParameter("p_year");
		}
		
		double price = 0.0;
		if(request.getParameter("p_precio")!= null && !request.getParameter("p_precio").trim().isEmpty()) {
			price = Double.parseDouble(request.getParameter("p_precio"));
		}
		
		int categoria = 0;
		if(request.getParameter("p_category")!= null && !request.getParameter("p_category").trim().isEmpty()) {
			categoria = Integer.parseInt(request.getParameter("p_category"));
		}
		
		DB_Helper db = new DB_Helper();
		
		Connection con = db.conectar();
		
		Disco disc = new Disco(0, title, group, releaseDate, price, categoria);
		
		db.insertarDisco(con, disc);
		
		List<V_Disco> listaDiscos = db.obtenerTodos(con);
		List<Categoria> listaCategorias = db.obtenerCategorias(con);
		
		db.desconectar(con);
		
		request.setAttribute(ATR_LISTA_DISCOS, listaDiscos);
		request.setAttribute(ATR_LISTA_CATEGORIAS, listaCategorias);
		
		request.getRequestDispatcher("/Cargar").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
