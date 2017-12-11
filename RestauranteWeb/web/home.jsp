<%-- 
    Document   : home
    Created on : 14/11/2017, 08:27:40 PM
    Author     : alumnoFI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Open+Sans" />
        <link rel="stylesheet" href="https://unpkg.com/spectre.css/dist/spectre.min.css">
        <title>Bienvenido, // titulo //!!</title>
        <style>
            .mesa-container {
                width: 50%;
            }
            
            .section {
                    font-family: -apple-system, system-ui, BlinkMacSystemFont, "Segoe UI", Roboto, "Helvetica Neue", sans-serif;
            }
            
            .form-articulo {
                margin-top: 10px;
            }
            
            .form-articulo input, .form-articulo textarea {
                display: block;
            }
            
            .form-articulo button {
                margin-top: 10px;
            }
            
            #toggle {
                margin-top: 10px;
            }
            
            .content {
                padding: 10px;
            }
            
            .nav-right {
                display: block;
                margin-top: 0;
                padding: 0;
            }
            
            .nav-right a { 
                color: inherit;
                text-decoration: none;
            }
        </style>
        
    </head>
    <body>
        <div class="container" >
            <div class="section bg-primary text-light">
                <h1>Inicio</h1>
                <div class="nav-right">
                        <a class="btn btn-error" id="logout">Cerrar sesión</a>
                </div>
            </div>
            <div class="columns content">
                <div class="column col-4" class="mesas-container">
                    <h2>Mesas</h2>
                    <div id="mesas"></div>
                    <button class="btn btn-error" id="toggle" style="display: none"></button>
                </div>
                <div id="serv" hidden class="column col-4">
                    <h2>Servicio <span id="mesa-num"></span></h2>
                    <label for="articulos">Articulos</label>
                    <div id="serv-articulos">
                        
                    </div>
                    <div class="form-articulo">
                        <legend>Introduzca una nueva orden</legend>
                        <hr/>
                        <label for="procesadores">Procesadores</label>
                        <div id="serv-procesadores"></div>
                        <label for="productos">Productos</label>
                        <div id="serv-productos"></div>
                        <label for="art-cantidad">Cantidad</label>
                        <input type="number" id="art-cantidad">
                        <label for="art-desc">Descripción</label>
                        <textarea id="art-desc" rows="4" cols="20"></textarea>
                        <button id="art-introducir" class="btn btn-primary">Introducir</button>
                    </div>
                </div>
            </div>
                
            <div class="modal" id="modal-id">
                <a href="#close" id="modal-overlay-id" class="modal-overlay" aria-label="Close"></a>
                <div class="modal-container">
                    <div class="modal-header">
                    <a href="#close" id="modal-cerrar-id" class="btn btn-clear float-right" aria-label="Cerrar"></a>
                    <div class="modal-title h5" id="modal-title-id"></div>
                    </div>
                    <div class="modal-body">
                        <div class="content">
                            <div id="modal-content-id">
                              <!-- content here -->
                            </div>
                                <button id="modal-button-id" class="btn btn-primary"></button>
                        </div>
                    </div>
                <div class="modal-footer">
                  ...
                </div>
          </div>
        </div>
            
            <script src="http://code.jquery.com/jquery-latest.min.js"></script>
            <script type="text/javascript">
               var vistaWeb = new EventSource("mozo?accion=new");

               vistaWeb.onerror = function(evento) {
                   vistaWeb.close();
                   alert("Error en la conexion del servidor.");
                   document.location.href = "/RestauranteWeb";
               };
    
               vistaWeb.addEventListener("titulo", function(evento) {
                   document.title = evento.data;
               });
               
               vistaWeb.addEventListener("errorVista", function(evento) {
                   modal("Error", evento.data, "Comprendido");
               });
               
               vistaWeb.addEventListener("logoutExitoso", function(evento) {
                   logout();
               });
               
               vistaWeb.addEventListener("mostrarMesas", function (evento){
                    document.getElementById("mesas").innerHTML = evento.data;
                    mesas = document.getElementsByClassName("boton-mesa");
                    for(var i = 0; i < mesas.length; i++) {
                        mesas[i].addEventListener("click", mesaClick)
                    }
               },false);
               
                vistaWeb.addEventListener("habilitarToggle", function (evento){
                    document.getElementById("toggle").style.display = "block"; 
                },false);
                
                vistaWeb.addEventListener("deshabilitarToggle", function (evento){
                    document.getElementById("toggle").style.display = "none"; 
                },false);
                
                
                vistaWeb.addEventListener("textoToggle", function (evento){
                    var element = document.getElementById("toggle");
                    if(evento.data == "true") {
                        element.textContent = "Cerrar";
                    } else {
                        element.textContent = "Abrir";
                    }
                },false);
                
                vistaWeb.addEventListener("hideListas", function(e) {
                    document.getElementById("serv").style.display = "none"; 
                });
                
                vistaWeb.addEventListener("mostrarServicio", function(e) {
                   document.getElementById("serv").style.display = "block"; 
                });
                
                vistaWeb.addEventListener("mostrarServicio", function(e) {
                   document.getElementById("serv").style.display = "block"; 
                });
                
                vistaWeb.addEventListener("mostrarArticulos", function (evento){
                    document.getElementById("serv-articulos").innerHTML = evento.data;
                },false);
                
                vistaWeb.addEventListener("mostrarProcesadores", function (evento){
                    document.getElementById("serv-procesadores").innerHTML = evento.data;
                    document.getElementById("procesadores").addEventListener("change", function(e) {
                        var e = document.getElementById("procesadores");
                        $.get("mozo?accion=procesadoraSeleccionada&procesadora=" + e.options[e.selectedIndex].text, function (data) {
                            
                        });
                    });
                },false);
                
                
                vistaWeb.addEventListener("mostrarProductos", function (evento){
                    document.getElementById("serv-productos").innerHTML = evento.data;
                },false);
                
                vistaWeb.addEventListener("hideListas", function (evento){
                    document.getElementById("serv").style.display = "none";
                },false);
                
                vistaWeb.addEventListener("mostrarServicio", function (evento){
                    document.getElementById("serv").style.display = "display";
                },false);
                
                document.getElementById("toggle").addEventListener("click", function(evento) {
                    $.get("mozo?accion=toggleMesaSeleccionada", function (data) {
                        
                    });
                });
                
                document.getElementById("modal-button-id").addEventListener("click", cerrarModal);
                document.getElementById("modal-overlay-id").addEventListener("click", cerrarModal);
                document.getElementById("modal-cerrar-id").addEventListener("click", cerrarModal);
                document.getElementById("logout").addEventListener("click", function(e) {
                    $.get("mozo?accion=logout", function(e) {
                    });
                });
                
                document.getElementById("art-introducir").addEventListener("click", function(evento) {
                    var productos = document.getElementById("productos");
                    var producto = productos.options[productos.selectedIndex].text;
                    var cantidad = document.getElementById("art-cantidad").value;
                    var desc = document.getElementById("art-desc").value;
                    $.get("mozo?accion=ingresarArticulo&producto=" + producto + "&cantidad=" + cantidad +"&descripcion=" + desc, function(data) {
                        
                    });
                });


                function mesaClick(e) {
                    var id = e.target.id;
                    var mesas = document.getElementsByClassName("mesa");
                    for(var i = 0; i < mesas.length; i++) {
                        mesas[i].style.fontSize = "15px";
                    }
                    e.target.style.fontSize = "30px";
                    numero = id.split("-").pop();
                    $.get("mozo?accion=avisarSeleccionada&numero=" + numero, function (data) {
                    });
                    document.getElementById("mesa-num").textContent = numero;
                };
                
                function cerrarModal(e) {
                    document.getElementById("modal-id").classList.remove("active");
                }
                
                function modal(title, message, button) {
                    document.getElementById("modal-title-id").textContent = title;
                    document.getElementById("modal-content-id").textContent = message;
                    document.getElementById("modal-button-id").textContent = button;
                    document.getElementById("modal-id").classList.add("active");
                }
                
                function logout() {
                    document.location.href = "/RestauranteWeb";
                }
           </script>
        </div>
    </body>
</html>
