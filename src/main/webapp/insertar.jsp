<%-- 
    Document   : insertar
    Created on : 17-mar-2021, 15:33:07
    Author     : Cristian
--%>

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
            <h1>Insertar</h1>
            <form action="movilesServlet" "class="form-group">
                Marca: <input type="text" class="form-control" name="marca" required="">
                Modelo: <input type="text" class="form-control" name="modelo" required="">
                Color: <input type="text" class="form-control" name="color" required="">
                Precio <input type="number" step="any" class="form-control" name="precio" required="">
                <input type="text" name="op" required value="insert2" hidden> 
                <input type="submit" class="btn btn-primary mt-2" value="insertar" >       
            </form>
        </div>
    </body>
</html>
