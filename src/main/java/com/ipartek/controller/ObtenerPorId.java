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


@WebServlet("/ObtenerPorId")
public class ObtenerPorId extends HttpServlet implements I_Conexion {
	private static final long serialVersionUID = 1L;
       
    
    public ObtenerPorId() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = 0;
		if(request.getParameter(V_DISCOS_ID)!= null && !request.getParameter(V_DISCOS_ID).trim().isEmpty()) {
			id = Integer.parseInt(request.getParameter(V_DISCOS_ID));
		}
		
		DB_Helper db = new DB_Helper();
		
		Connection con = db.conectar();
		
		V_Disco disco = db.obtenerPorId(con, id);
		List<Categoria> listaCategorias = db.obtenerCategorias(con);
		System.out.println(disco);
		
		db.desconectar(con);
		
		request.setAttribute(ATR_DISCO, disco);
		request.setAttribute(ATR_LISTA_CATEGORIAS, listaCategorias);
		
		request.getRequestDispatcher(JSP_UPDATE).forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
