<%@page import="com.ipartek.model.dto.Categoria"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.model.dto.V_Disco"%>
<%@page import="java.util.List"%>
<%@page import="com.ipartek.model.I_Conexion"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%List<V_Disco> listaDiscos = new ArrayList<>();
    if(request.getAttribute(I_Conexion.ATR_LISTA_DISCOS)!= null){
    	listaDiscos = (List<V_Disco>) request.getAttribute(I_Conexion.ATR_LISTA_DISCOS);
    }
    
    List<Categoria> listaCategorias = new ArrayList<>();
    if(request.getAttribute(I_Conexion.ATR_LISTA_CATEGORIAS)!= null){
    	listaCategorias = (List<Categoria>) request.getAttribute(I_Conexion.ATR_LISTA_CATEGORIAS);
    }
    
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" type="image" href="styles/images/disco-fonografico-o-disco-vinilo_1308-121279.jpg" />
<link rel="stylesheet" href="styles/style.css">
<title>Disco Stu</title>
</head>
<body>

<div class= "title">
<h1>DISCO STU</h1>
<h3>TIENDA DE DISCOS</h3>
</div>

<div>

<form action="Insertar" method="get" class="form">

<label>Título: </label>

<input type="text" name="p_nombre" maxlength="100" required>

<label>Grupo:</label>
<input type="text" name="p_grupo" maxlength="90" required>

<label>Fecha de publicación:</label>
<input type="date" name="p_year" required>

<label>Precio:</label>
<input type="number" name="p_precio" min="1" step="0.01" required>
<label>Categoría:</label>
<select name="p_category">
<%for(Categoria elem: listaCategorias){ %>
<option value=<%= elem.getId() %>><%= elem.getNombre() %></option>
<%} %>
</select>

<input type="submit"></input>

</form>

</div>


<div>
<form action="Buscar" method="get" class="searchbar">
<label> Búsqueda </label>
<input type="text" name="p_text" maxlength=255 placeholder="Busca aquí">
<input type="submit">

</form>


</div>


<form  action="BorrarTodos" method="get">

<div class="button-erase" style="display: flex; justify-content: center; align-items: center; padding: 10px 0 10px 0;">
<input  type="submit" value="BORRAR SELECCIONADOS" onclick="return confirm('¿Estás seguro de que deseas borrarlos?')">
</div>

<div class="card-container">

<%for(V_Disco item: listaDiscos){ %>

<div class="card">

<input type="checkbox" name="id_borrar" value="<%=item.getId()%>">
<p> <strong>Título: </strong>  <%= item.getTitle() %> </p>
<p> <strong>Grupo: </strong>  <%= item.getGroupname() %> </p>
<p> <strong>Publicación: </strong>  <%= item.getYear() %> </p>
<p> <strong>Precio: </strong>  <%= item.getPrice() %> € </p>
<p> <strong>Categoría: </strong>  <%= item.getCategoria() %> </p>
<div class="buttons">
<a href="ObtenerPorId?id=<%= item.getId()%>">Modificar</a>
<a href="Borrar?id=<%= item.getId()%>" onclick="return confirm('¿Estás seguro de que quieres borrar?')">Borrar</a>
</div>


</div>

<%} %>
</div>
</form>

</body>
</html>