<%@page import="java.util.List"%>
<%@page import="modelo.Moviles"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRUD Móviles</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <ul class="navbar-nav">
                <a class="navbar-brand" href="#">Navbar</a>
                <li class="nav-item">
                    <a class="nav-link" href="movilesServlet?op=listar">Listar</a><br>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="movilesServlet?op=insert1">Insertar</a> 
                </li>
            </ul>
        </nav>

        <div class="container">
            <h1>Móviles</h1>
            <% List<Moviles> moviles = (List<Moviles>) request.getAttribute("moviles");%>

            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">Marca</th>
                        <th scope="col">Modelo</th>
                        <th scope="col">Color</th>
                        <th scope="col">Precio</th>
                        <th scope="col">Borrar</th>
                        <th scope="col">Actualizar</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (Moviles m : moviles) {
                            String cadenaBorrar = "<a class='btn btn-outline-danger' href='movilesServlet?op=borrar&id=" + m.getId() + "'>Borrar</a>";
                            String cadenaActualizar = "<a class='btn btn-outline-secondary' href='movilesServlet?op=update1&id=" + m.getId() + "'>Actualizar</a>";
                    %>
                    <tr>
                        <td><%= m.getMarca()%></td>
                        <td><%= m.getModelo()%></td>
                        <td><%= m.getColor()%></td>
                        <td><%= m.getPrecio()%> €</td>
                        <td><%= cadenaBorrar %></td>
                        <td><%= cadenaActualizar %></td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
    </body>
</html>
