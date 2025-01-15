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


@WebServlet("/Buscar")
public class Buscar extends HttpServlet implements I_Conexion {
	private static final long serialVersionUID = 1L;
       
    
    public Buscar() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String text = "";
		if(request.getParameter("p_text")!= null && !request.getParameter("p_text").trim().isEmpty()) {
			text = request.getParameter("p_text");
		}
		
		DB_Helper db = new DB_Helper();
		Connection con = db.conectar();
		
		List<V_Disco> listaDiscos = db.buscarDisco(con, text);
		
		System.out.println(listaDiscos);
		
		db.desconectar(con);
		
		request.setAttribute(ATR_LISTA_DISCOS, listaDiscos);
		request.getRequestDispatcher(JSP_INDEX).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
