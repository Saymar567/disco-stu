package com.ipartek.model;

public interface I_Conexion {

	
	//CONEXION A BD
	
	String BD = "db_discos";
	String DRIVER = "com.mysql.jdbc.Driver";
	String CONEXION = "jdbc:mysql://localhost:3306/" + BD;
	String USER = "root";
	String PASS = "1234";
	
	//CONSTANTES DE TABLAS
	
	String TABLE1 = "categorias";
	String CATEGORIAS_ID = "id";
	String CATEGORIAS_NOMBRE = "name";
	
	String TABLE2 = "discos";
	String DISCOS_ID = "id";
	String DISCOS_TITLE = "title";
	String DISCOS_GROUP = "groupname";
	String DISCOS_YEAR = "year";
	String DISCOS_PRICE = "price";
	String DISCOS_FK_CATEGORIA = "FK_categoria";
	
	String TABLE3 = "v_discos";
	String V_DISCOS_ID = "id";
	String V_DISCOS_TITLE = "title";
	String V_DISCOS_GROUP = "group";
	String V_DISCOS_YEAR = "year";
	String V_DISCOS_PRICE = "price";
	String V_DISCOS_FK_CATEGORIA = "FK_categoria";
	String V_DISCOS_CATEGORIA = "categoria";
	
	//JSP 
	
	String JSP_INDEX = "index.jsp";
	String JSP_UPDATE = "update.jsp";
	
	//STORED PROCEDURES
	
	String SP_DISCOS_OBTENER_TODOS = "call sp_v_discos_obtener_todos();";
	String SP_DISCOS_OBTENER_POR_ID = "call sp_v_discos_obtener_por_id(?);";
	String SP_DISCOS_BORRAR = "call sp_discos_borrar(?);";
	String SP_DISCOS_INSERTAR = "call sp_discos_insertar(?, ?, ?, ?, ?);";
	String SP_DISCOS_MODIFICAR = "call sp_discos_modificar(?, ?, ?, ?, ?, ?);";
	
	String SP_CATEGORIAS_OBTENER_TODAS = "call sp_categorias_obtener_todas();";
	String SP_CATEGORIAS_OBTENER_POR_ID = "call sp_categorias_obtener_por_id(?);";
	String SP_CATEGORIAS_BORRAR = "";
	String SP_CATEGORIAS_INSERTAR = "";
	String SP_CATEGORIAS_MODIFICAR = "";
	
	String SP_DISCOS_FULLTEXT="call sp_buscar(?)";
	
	//ATTRIBUTES
	
	String ATR_LISTA_DISCOS = "atr_lista_discos";
	String ATR_DISCO = "atr_disco";
	String ATR_LISTA_CATEGORIAS = "atr_lista_categorias";
	String ATR_CATEGORIA = "atr_categoria";
}
