<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.model.dto.Categoria"%>
<%@page import="java.util.List"%>
<%@page import="com.ipartek.model.dto.V_Disco"%>
<%@page import="com.ipartek.model.I_Conexion"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%
    V_Disco disco = new V_Disco();
    if(request.getAttribute(I_Conexion.ATR_DISCO)!= null){
    	disco = (V_Disco) request.getAttribute(I_Conexion.ATR_DISCO);
    }
    
    List<Categoria> listaCategorias = new ArrayList<>();
    if(request.getAttribute(I_Conexion.ATR_LISTA_CATEGORIAS)!= null){
    	listaCategorias = (List<Categoria>) request.getAttribute(I_Conexion.ATR_LISTA_CATEGORIAS);
    }
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="styles/style.css">
<title>Insert title here</title>
</head>
<body>

<div >
<form action="Modificar" method="get" class="form">

<input type="hidden" name="p_id" value="<%=disco.getId() %>" readonly>
<label> Title: </label>
<input type="text" name="p_title" value="<%= disco.getTitle() %>" maxlength="100" required>
<label>Group:</label>
<input type="text" name="p_group" value="<%=disco.getGroupname() %>" maxlength="90" required>
<label>Release Date:</label>
<input type="text" name="p_year" value="<%=disco.getYear() %>" >
<label>Price:</label>
<input type="number" name="p_price" value="<%=disco.getPrice() %>" min="1" step="0.01">
<label>Category:</label>
<select name="p_category" required>
<%for(Categoria elem: listaCategorias){ %>
<option value="<%= elem.getId()%>" <%= disco.getFK_categoria() == elem.getId() ? "selected" : "" %>><%=elem.getNombre() %> </option>
<%} %>
</select>

<input type="submit">
</form>
</div>

<div>
<a href="Cargar">Volver</a>
</div>

</body>
</html>