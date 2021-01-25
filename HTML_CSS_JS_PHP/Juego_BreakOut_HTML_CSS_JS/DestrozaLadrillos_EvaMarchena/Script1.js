var canvas = document.getElementById("myCanvas"); //Referencia al elemento canvas
var ctx = canvas.getContext("2d"); //Almacena el contexto de renderizado 2D
var x = canvas.width/2; //Define posición en que se dibuja el circulo
var y = canvas.height-30; //Define posición en que se dibuja el circulo
var dx = 4; //Actualiza el valor de x para que parezca que se mueve
var dy = -4; //Actualiza el valor de y para que parezca que se está moviendo
var ballRadius = 10; //Contiene el radio del circulo dibujado
var paddleHeight = 10; // Altura de la paleta
var paddleWidth = 75; // Ancho de la paleta
var paddleX = (canvas.width-paddleWidth) / 2; // Punto de partida en el eje x. Posición
var rightPressed = false; //Almacena info si se presiona el botón de control derecho. Predeterminado False porque al principio no se presionan botones de control
var leftPressed = false; //Almacena info si se presiona el botón de control izquierdo. Predeterminado False porque al principio no se presionan botones de control
var brickRowCount = 3; // Ladrillos. Número de filas
var brickColumnCount = 7; // Ladrillos. Número de columnas
var brickWidth = 60; // Ladrillos. Ancho del ladrillo
var brickHeight = 20; // Ladrillos. Alto del ladrillo
var brickPadding = 7; // Ladrillos. Relleno entre ladrillos para que no se toquen
var brickOffsetTop = 60; // Ladrillos. Desplazamiento superior para que no se dibuje desde el borde del lienzo
var brickOffsetLeft = 10; // Ladrillos. Desplazamiento izquierdo para que no se dibuje desde el borde del lienzo
var score = 0; // Puntuación
var lives = 3; //Vidas

var bricks = []; //Matriz bidimensional. Recorrerá las filas y columnas y creará los nuevos ladrillos
for(var c=0; c<brickColumnCount; c++) { //Columnas de ladrillos (c)
    bricks[c] = [];
    for(var r=0; r<brickRowCount; r++) { //Filas de ladrillos (r)
        bricks[c][r] = { x: 0, y: 0, status: 1 }; //Objeto con posición X e Y para pintar cada ladrillo en pantalla
    }
}

document.addEventListener("keydown", keyDownHandler, false); //Detector de eventos. Escucha las pulsaciones de las teclas. Keydown = cuando se presionan las teclas, se ejecuta la función keyDownHandler
document.addEventListener("keyup", keyUpHandler, false); //Detector de eventos. Escucha las pulsaciones de las teclas. Keyup = cuando dejen de presionarse las teclas, se ejecuta la función keyUpHandler
document.addEventListener("mousemove", mouseMoveHandler, false); //Detector de eventos. Escuchar movimiento del ratón

function mouseMoveHandler(e) { //Actualiza la posición de la paleta en función de las coordenadas del puntero del ratón
    var relativeX = e.clientX - canvas.offsetLeft; 
    if(relativeX > 0 && relativeX < canvas.width) { //Si la posición del puntero X es mayor que 0 y menor al ancho del lienzo: el puntero está dentro del lienzo
        paddleX = relativeX - paddleWidth/2; //La paleta sigue la posición del ratón
    }
}

function keyDownHandler(e) { 
    if(e.key == "Right" || e.key == "ArrowRight") { //Cuando presionamos la tecla a la derecha. Key da info de la letra que se presionó. ArrowRight o Right (para todos los navegadores)
        rightPressed = true; //La variable se establece en true
    }else if(e.key == "Left" || e.key == "ArrowLeft") { //Cuando presionamos la tecla a la izquierda. Key da info de la letra que se presionó. ArrowLeft o Left
            leftPressed = true; //La variable se establece en true
    }
}

function keyUpHandler(e) {
    if(e.key == "Right" || e.key == "ArrowRight") { //Cuando se suelta la tecla derecha. Key da info de la letra que se presionó. ArrowRight o Right 
        rightPressed = false; //La variable se establece en false
    }
    else if(e.key == "Left" || e.key == "ArrowLeft") { //Cuando se suelta la tecla izquierda. Key da info de la letra que se presionó. ArrowLeft o Left
        leftPressed = false; //La variable se establece en False
    }
}

function collisionDetection() { //Detección de colisiones entre bola y ladrillo
    for(var c=0; c<brickColumnCount; c++) { //Recorre todos los ladrillos - Columnas
        for(var r=0; r<brickRowCount; r++) { //Recorre todos los ladrillos - Filas
            var b = bricks[c][r]; // Ladrillo
            if(b.status == 1){ 
                //Si la posición X de la bola es mayor que la posición X del ladrillo
                //Su ka posición X de la bola es menor que la posición X del ladrillo + ancho del ladrillo
                //Si la posición Y de la bola es mayor que la posición Y del ladrillo
                //Si la posición Y de la bola es menor que la posición Y del ladrillo + altura del ladrillo
                if(x > b.x && x < b.x+brickWidth && y > b.y && y < b.y+brickHeight) { 
                    dy = -dy; //si antes te movías habia arriba a 2 px, ahora te moveras hacia arriba a -2px, es decir, hacia abajo a 2px. Invierte el movimiento
                    b.status = 0; //Damos valor 0 al status para que no lo pinte en pantalla 
                    score++; //Suma un punto
                    if(score == brickRowCount*brickColumnCount) { //Si la puntuación es igual que los ladrillos
                        alert("ENHORABUENA, ¡HAS GANADO!"); //alerta
                        document.location.reload(); //Vuelve a cargar la página
                    }
                }
            }
        }
    }
}

function drawtittle() { //Dibujar titulo
    ctx.font = "20px Calibri"; //tamaño y tipo de fuente
    ctx.fillStyle = "#0095DD"; //color
    ctx.fillText("JUEGA A DESTROZAR LADRILLOS",110, 20); //texto que se colocará en el lienzo y coordenadas donde se colocará
}

function drawScore() { //Dibujar puntuación
    ctx.font = "20px Calibri"; //tamaño y tipo de fuente
    ctx.fillStyle = "#0095DD"; //color
    ctx.fillText("Puntuación: "+score, 8, 50); //texto que se colocará en el lienzo y coordenadas donde se colocará
}

function drawLives() { // Dibujar vidas
    ctx.font = "20px Calibri"; //tamaño y tipo de fuente
    ctx.fillStyle = "#0095DD"; //color
    ctx.fillText("Vidas: "+lives, canvas.width-70, 50); //texto que se colocará en el lienzo y coordenadas donde se colocará
}

function drawBall() { //Definine la bola
    ctx.beginPath(); //siempre comienza con beginPath y termina con closePath();
    ctx.arc(x, y, ballRadius, 0, Math.PI*2); //Bola
    ctx.fillStyle = "#EF4B4B"; //Color
    ctx.fill();
    ctx.closePath();
}

function drawPaddle() { //Define la paleta
    ctx.beginPath();// Siempre comienza con beginPath y termina con closePath();
    ctx.rect(paddleX, canvas.height-paddleHeight, paddleWidth, paddleHeight); //Los dos primeros valores = coordenadas esquina superior izquierda. Los dos segundos ancho y altura. 
    ctx.fillStyle = "#0095DD"; //Color
    ctx.fill();
    ctx.closePath();
}

function drawBricks() { //Define los ladrillos
    for(var c=0; c<brickColumnCount; c++) {
        for(var r=0; r<brickRowCount; r++) {
            if(bricks[c][r].status == 1) { //Si status = 1 dibuja un ladrillo, si no es 1 no lo dibuja (fue golpeado por la pelota y ya no lo queremos en pantalla)
                var brickX = (c*(brickWidth+brickPadding))+brickOffsetLeft;
                var brickY = (r*(brickHeight+brickPadding))+brickOffsetTop;
                bricks[c][r].x = brickX;
                bricks[c][r].y = brickY;
                ctx.beginPath();
                ctx.rect(brickX, brickY, brickWidth, brickHeight);
                ctx.fillStyle = "#0095DD";
                ctx.fill();
                ctx.closePath();
            }
        }
    }
}

function draw() { //Pilota el programa
    ctx.clearRect(0, 0, canvas.width, canvas.height); //El area cubierta se limpia de lo que hubiera antes. x, y de esquina sup izda + x, y de esquina inf dcha. 
    drawBricks(); //Llama a la función donde definimos los ladrillos
    drawBall(); //Llama a la funcion donde definimos el circulo
    drawPaddle(); //Llama a la función donde definimos la paleta
    drawtittle(); //Llama a la función donde definimos el título
    drawScore(); //Llama a la función donde definimos la puntuación
    drawLives(); //Llama a la función donde definimos las vidas
    collisionDetection(); //Llama a la función donde definimos la detección de colisiones
    x += dx; //Damos nuevo valor a X
    y += dy; //Damos nuevo valor a Y

    //Condición para cuando la bola choca en las paredes. Y: superior e inferior. X derecha e izquierda
    if(x + dx > canvas.width-ballRadius || x + dx < ballRadius) {//Si cuando se mueva la pelota está fuera de algún lateral del canvas 
        dx = -dx;   //Si antes te movías hacia arriba a 2 px, ahora te moveras hacia arriba a -2px, es decir, hacia abajo a 2px. Se invierte el movimiento
    }
    if(y + dy < ballRadius) { //Si la pelota toca el borde superior
        dy = -dy; //Si antes te movías hacia arriba a 2 px, ahora te moveras hacia arriba a -2px, es decir, hacia abajo a 2px. Invierte el movimiento
    }else if(y + dy > canvas.height-ballRadius) { //Si la pelota toca el borde inferior
        if(x > paddleX && x < paddleX + paddleWidth) { // Si la pelota toca la paleta
            dy = -dy;//Si antes te movías hacia arriba a 2 px, ahora te moveras hacia arriba a -2px, es decir, hacia abajo a 2px. Invierte el movimiento
        }
        else { //Si la pelota no toca la paleta
            lives--; // Restamos una vida
            if(!lives) { // Si no quedan vidas
                alert("GAME OVER"); // Alerta
                document.location.reload(); // Vuelve a cargar la página
            }
            else { // Si aún quedan vidas reestablece posiciones
                x = canvas.width/2; //Define posición en que se dibuja el circulo
                y = canvas.height-30; //Define posición en que se dibuja el circulo
                dx = 4; //Actualiza el valor de x para que parezca que se mueve
                dy = -4; //Actualiza el valor de x para que parezca que se mueve
                paddleX = (canvas.width-paddleWidth)/2; // Punto de partida en el eje x - posición
            }
        }
    }


    
    //Condición para cuando se presionan las teclas.
    if(rightPressed) {
        paddleX += 7; //Si se presiona el botón derecho, la paleta se mueve siete píxeles a la derecha
        if (paddleX + paddleWidth > canvas.width){ // PARA QUE NO SE SALGA DEL CANVAS: Si la posición de la paleta + el ancho de la paleta es mayor que el ancho del candas (fuera del canvas)
            paddleX = canvas.width - paddleWidth; //EL tamaño de la paleta será igual al ancho del canvas menos el ancho de la paleta (dentro del canvas)
        }
    }
    else if(leftPressed) { //Si se presiona el botón izquierdo, la paleta se mueve siete píxeles a la izquierda
        paddleX -= 7;
        if (paddleX < 0){ // PARA QUE NO SE SALGA DEL CANVAS: Si la posición de la paleta es menor que cero (fuera del canvas)
            paddleX = 0; //Igualamos la posición de la paleta a 0 (dentro del canvas)
        }

    }
    requestAnimationFrame(draw); //La función volverá a llamarse a si misma.
}


draw();