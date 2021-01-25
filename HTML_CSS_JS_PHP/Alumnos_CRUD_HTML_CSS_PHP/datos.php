<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
        <title>Gestión Alumnos</title>
        <link rel="stylesheet" href = "resultado.css">
	</head>
	<body>
        <div id="consultas">
            <?php
            $conexbd = new mysqli("localhost:3306", "root", "root", "puntuable4ldm");
            if (mysqli_connect_errno()) {
                echo "Error: No se pudo conectar a MariaDB.<br/>errno de depuración: " . mysqli_connect_errno() . "<br/>error de depuración: " . mysqli_connect_error();
                exit;
            }

            if(isset($_POST["introduce"])){

                $codigo = $_POST['cod'];
                $nombre = $_POST['nom'];
                $apellido = $_POST['ape'];
                $ruta = 'imagenes/Alumno_'.$codigo.'.jpg';
                move_uploaded_file( $_FILES['foto']['tmp_name'], $ruta);
                $conexbd->query("INSERT INTO alumnos VALUES ('$codigo','$nombre','$apellido', LOAD_FILE ('C:/xampp/htdocs/Puntuable4/$ruta'))");
                if($conexbd->affected_rows === 1) {
                    echo "<h3>Registro insertado correctamente</h3>"; 
                } else {
                    echo "<h3>Error en la consulta. Registro no insertado</h3>";
                }
            }

            if(isset($_POST["consulta"])) {
                $codigo = $_POST['cod'];
                $resul = $conexbd->query("SELECT * FROM alumnos WHERE codigo = '$codigo'");
                if($resul->num_rows === 1) {
                    $registro = $resul->fetch_assoc();
                    echo "<label>Código:</label> " . $registro["codigo"] . "<label><br/>Nombre:</label> " . $registro["nombre"] . "<label><br/>Apellidos:</label> " . $registro["apellidos"] . "<label><br/>Foto:<br/></label><br/><img src=\"imagenes/Alumno_" . $codigo . ".jpg\" />";   
                } else {
                    echo "<h3>Error en la consulta. No se puede mostrar el registro</h3>";
                }
            }

            if(isset($_POST["modifica"])) {
                $codigo = $_POST['cod'];
                $nombre = $_POST['nom'];
                $apellido = $_POST['ape'];
                $ruta = 'imagenes/Alumno_'.$codigo.'.jpg';
                move_uploaded_file( $_FILES['foto']['tmp_name'], $ruta);

                $conexbd->query("UPDATE alumnos SET nombre = '$nombre', apellidos = '$apellido', foto = LOAD_FILE ('C:/xampp/htdocs/Puntuable4/$ruta') WHERE codigo = $codigo");
                if($conexbd->affected_rows === 1) {
                    echo "<h3>Registro modificado correctamente</h3>";
                } else {
                    echo "<h3>Error en la consulta. Registro no modificado</h3>";
                }
            }

            if(isset($_POST["borra"])){
                $codigo = $_POST['cod'];
                $conexbd->query("DELETE FROM alumnos WHERE codigo = '$codigo'");
                if($conexbd->affected_rows === 1) {
                    echo "<h3>Registro borrado correctamente</h3>";
                } else {
                    echo "<h3>Error en la consulta. Registro no eliminado</h3>";
                }  
            }

            $conexbd->close();
            ?>
            <a href="menu.html"> <h3>Volver a Menú </h3> </a>
        </div>
	</body>
</html>