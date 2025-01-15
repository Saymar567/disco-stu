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

@WebServlet("/Modificar")
public class Modificar extends HttpServlet implements I_Conexion {
	private static final long serialVersionUID = 1L;
       
    
    public Modificar() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = 0;
		if(request.getParameter("p_id")!= null && !request.getParameter("p_id").trim().isEmpty()) {
			id = Integer.parseInt(request.getParameter("p_id"));
		}
		String title = "";
		if (request.getParameter("p_title") != null && !request.getParameter("p_title").trim().isEmpty()) {
			title = request.getParameter("p_title");
		}

		String group = "";
		if (request.getParameter("p_group") != null && !request.getParameter("p_group").trim().isEmpty()) {
			group = request.getParameter("p_group");
		}
		String releaseDate = "";

		if (request.getParameter("p_year") != null && !request.getParameter("p_year").trim().isEmpty()) {
			releaseDate = request.getParameter("p_year");
		}

		double price = 0.0;

		if (request.getParameter("p_price") != null && !request.getParameter("p_price").trim().isEmpty()) {
			price = Double.parseDouble(request.getParameter("p_price"));
		}

		int fk_categoria = 0;

		if (request.getParameter("p_category") != null && !request.getParameter("p_category").trim().isEmpty()) {
			fk_categoria = Integer.parseInt(request.getParameter("p_category"));
		}
		
		DB_Helper db = new DB_Helper();
		
		Connection con = db.conectar();
		
		Disco disc = new Disco(id, title, group, releaseDate, price, fk_categoria);
		
		db.modificarDisco(con, disc);
		
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
