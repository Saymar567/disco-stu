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
import com.ipartek.model.dto.V_Disco;


@WebServlet("/Borrar")
public class Borrar extends HttpServlet implements I_Conexion {
	private static final long serialVersionUID = 1L;
       
   
    public Borrar() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = 0;
		if(request.getParameter(V_DISCOS_ID)!= null && !request.getParameter(V_DISCOS_ID).trim().isEmpty()) {
			id = Integer.parseInt(request.getParameter(V_DISCOS_ID));
		}
		
		DB_Helper db = new DB_Helper();
		
		Connection con = db.conectar();
		
		db.borrarDisco(con, id);
		
		List<V_Disco> listaDiscos = db.obtenerTodos(con);
		
		db.desconectar(con);
		
		request.setAttribute(ATR_LISTA_DISCOS, listaDiscos);
		
		request.getRequestDispatcher(JSP_INDEX).forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
