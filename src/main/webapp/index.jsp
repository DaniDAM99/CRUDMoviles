<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

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
    </body>
</html>
