<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestión de Reservas</title>
    </head>
    <body>
        <h1>
            Gestión de Reservas
        </h1>
        <div class="barra">
            <p>En este espacio podrás agendar y adminisitrar las reservas</p>
        </div>

        <div class="datosClientes">
            <div class="cajaDatosCliente">
                <h2>
                    Ingresa los siguientes datos
                </h2>
                <form action="ReservaServlet1" method="POST">
                    <p><label>Nombre: </label><input type="text" name="nombre" required></p>
                    <p><label>Fecha: </label><input type="date" name="fecha" required></p>
                    <p><label>Espacio: </label>
                    <p><label></label><input type="radio" name="espacio" value="escritorio" required>Escritorio</p>
                    <p><label></label><input type="radio" name="espacio" value="SalaReuniones" required>Sala de Reuniones</p>
                    <p><label></label><input type="radio" name="espacio" value="OficinaPrivada" required>Oficina Privada</p>
                    <p><label>Duración en horas: </label><input type="number" name="horas" required></p>
                    <p><button type="submit">Enviar</button></p>
                </form>
            </div>

        </div>
    </body>
</html>
