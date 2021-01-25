import pygame, sys, random


def animacionBola():  # Animación de la bola
    global velocidadBolaX, velocidadBolaY, puntuacion, vidasJugador, estado, ladrillos, ladrillosDestruidos, bola, jugador, textoJugador  # Variables globales

    #Variables de la velocidad
    bola.x += velocidadBolaX  # En cada vuelta del bucle, cambia la posición de la bola
    bola.y += velocidadBolaY  # En cada vuelta del bucle, cambia la posición de la bola

    #Control de colisiones de la bola con la pantalla
    if bola.top <= 0:  # Si la bola colisiona con la parte de arriba de la superficie
        velocidadBolaY *= -1  # Invierte su movimiento
    if bola.left <= 0 or bola.right >= anchoVentana:  # Si la bola colisiona con los laterales de la superficie
        velocidadBolaX *= -1  # Invierte su movimiento.
    if bola.bottom >= altoVentana:  # Si la bola colisiona con la parte de abajo de la superficie
        vidasJugador -= 1  # Reduce una vida del jugador
        if vidasJugador > 0:  #  Si al colisionar con la parte de abajo de la superficie las vidas son mayores que 0
            pygame.mixer.Sound.play(sonido_PerderVida)  # Reproduce el sonido de perder una vida
        reiniciaBola()  # Reinicia la bola para empezar de nuevo desde la posición inicial

        if vidasJugador == 0:  # Si las vidas tras colisionar con la parte de abajo de la pantalla son 0
            pygame.mixer.Sound.play(sonido_GameOver)  # Reproduce sonido de GameOver
            fuente = pygame.font.Font(None, 74)  # Fuente
            textoGameOver = fuente.render("GAME OVER", 1, color_bola)  # Muestra mensaje 'Game Over'
            ventana.blit(textoGameOver, (350, 300))  # Posición del texto
            pygame.display.flip()  # Actualiza el contenido de la ventana
            pygame.time.wait(3000)  # Tiempo de espera para reiniciar la partida
            reiniciarPartida()

    if bola.colliderect(jugador):  # Si la bola colisiona con la paleta
        velocidadBolaY *= -1  # Invierte el movimiento
        pygame.mixer.Sound.play(sonido_Jugador)  # Emite sonido seleccionado


def animacionJugador():  # Animación y movimiento de la pala
    jugador.x += velocidadJugador  # En cada vuelta de bucle cambia la posición de la pala

    if jugador.right >= anchoVentana:  # Si la parte derecha de la pala llega al final de la pantalla
        jugador.right = anchoVentana  # No permite que sobrepase el tamaño de la pantalla
    if jugador.left <= 0:  # Si la parte izquierda de la pala llega al final de la pantalla
        jugador.left = 0  # No permite que sobrepase el tamaño de la pantalla


def reiniciaBola():  # Reinicia el estado de la bola
    global velocidadBolaX, velocidadBolaY  #Variables globales

    bola.center = anchoVentana / 2 - 12.5, altoVentana - 50  # Posicionamos la bola en el centro en la parte inferior
    velocidadBolaY *= -1  #Mueve la dirección de la bola


def dibujaLadrillos():  # Pinta todos los ladrillos cuando se inicia el juego
    global estado

    # If en el que entrará en la primera vuelta al bucle del juego
    if estado == 0:  # Booleana que pinta todos los ladrillos cuando vale 0
        for c in range(columnasLadrillos):  # Columnas
            for r in range(filasLadrillos):  # Filas
                ladrilloX = (c * (anchoLadrillo + paddingLadrillo)) + margenIzqLadrillo  # Construye los ladrillos
                ladrilloY = (r * (altoLadrillo + paddingLadrillo)) + margenTopLadrillo  # Construye los ladrillos
                ladrillo = pygame.draw.rect(ventana, color_ladrillos, (ladrilloX, ladrilloY, anchoLadrillo, altoLadrillo))  # Dibuja el ladrillo en la pantalla
                ladrillos.append([ladrillo, 1])  # Añade el ladrillo en el array
        estado = 1  # Da valor 1 a la booleana

    i = 0
    # If en el que entrará el resto del tiempo, controlando ladrillos destruidos
    if estado == 1:  # Cuando vale 1 pinta los ladrillos que no han colisionado
        for c in range(columnasLadrillos):  # Columnas
            for r in range(filasLadrillos):  # Filas
                ladrilloX = (c * (anchoLadrillo + paddingLadrillo)) + margenIzqLadrillo
                ladrilloY = (r * (altoLadrillo + paddingLadrillo)) + margenTopLadrillo
                if ladrillos[i][1] == 1:  # Si el ladrillo no ha colisionado lo pinta
                    ladrillo = pygame.draw.rect(ventana, color_ladrillos, (ladrilloX, ladrilloY, anchoLadrillo, altoLadrillo))
                    ladrillos[i][0] = ladrillo
                i = i + 1


def colisionLadrillos():  # Controla la colisión con los ladrillos
    global velocidadBolaX, puntuacion, velocidadBolaY, ladrillosDestruidos  # Variables globales

    for numeroLadrillos in range(35):
        if bola.colliderect(ladrillos[numeroLadrillos][0]):  # Si la bola colisiona con un ladrillo
            if ladrillos[numeroLadrillos][1] == 1:
                if abs(bola.left - ladrillos[numeroLadrillos][0].right) < 10:  # Si la bola colisiona con el lado derecho del ladrillo
                    velocidadBolaX *= -1  # Invierte el movimiento de la bola
                    ladrillos[numeroLadrillos][1] = 0  # Cambia valor a 0 para que no sea repintado
                    puntuacion = puntuacion + 10  # Suma 10 puntos al contador de puntuación
                    ladrillosDestruidos = ladrillosDestruidos + 1  # Contabiliza el ladrillo como un ladrillo destruido
                    pygame.mixer.Sound.play(sonido_Ladrillo)  # Emite sonido seleccionado

                elif abs(bola.bottom - ladrillos[numeroLadrillos][0].top) < 10:  # Si la bola colisiona por arriba con el ladrillo
                    velocidadBolaY *= -1  # Invierte el movimiento de la bola
                    ladrillos[numeroLadrillos][1] = 0  # Cambia valor a 0 para que no sea repintado
                    puntuacion = puntuacion + 10  # Suma 10 puntos al contador de puntuación
                    ladrillosDestruidos = ladrillosDestruidos + 1  # Contabiliza el ladrillo como un ladrillo destruido
                    pygame.mixer.Sound.play(sonido_Ladrillo)  # Emite sonido seleccionado

                elif abs(bola.top - ladrillos[numeroLadrillos][0].bottom) < 10:  # Si la bola colisiona por abajo con el ladrillo
                    velocidadBolaY *= -1  # Invierte el movimiento de la bola
                    ladrillos[numeroLadrillos][1] = 0  # Cambia valor a 0 para que no sea repintado
                    puntuacion = puntuacion + 10  # Suma 10 puntos al contador de puntuación
                    ladrillosDestruidos = ladrillosDestruidos + 1  # Contabiliza el ladrillo como un ladrillo destruido
                    pygame.mixer.Sound.play(sonido_Ladrillo)  # Emite sonido seleccionado

                elif abs(bola.right - ladrillos[numeroLadrillos][0].left) < 10:  # Si la bola colisiona por abajo con el ladrillo
                    velocidadBolaX *= -1  # Invierte el movimiento de la bola
                    ladrillos[numeroLadrillos][1] = 0  # Cambia valor a 0 para que no sea repintado
                    puntuacion = puntuacion + 10  # Suma 10 puntos al contador de puntuación
                    ladrillosDestruidos = ladrillosDestruidos + 1  # Contabiliza el ladrillo como un ladrillo destruido
                    pygame.mixer.Sound.play(sonido_Ladrillo)  # Emite sonido seleccionado


def comprobarVictoria(): # Animación si se gana el juego
    global ladrillosDestruidos, vidasJugador, puntuacion, estado, ladrillos, bola, velocidadBolaY, velocidadBolaX, jugador  # Variables globales

    if ladrillosDestruidos == 35:  # Si se han destruido todos los ladrillos
        pygame.mixer.Sound.play(sonido_Ganar)  # Emite sonido seleccionado
        fuente = pygame.font.Font(None, 74)  # Fuente
        textoHasGanado = fuente.render("¡HAS GANADO!", 1, color_bola)  # Muestra mensaje '¡HAS GANADO!'
        ventana.blit(textoHasGanado, (300, 300))  # Posición del texto
        pygame.display.flip()  # Actualiza el contenido de la ventana
        pygame.time.wait(3500)  # Tiempo de espera para reiniciar la partida
        reiniciarPartida()


def reiniciarPartida():  # Método que colocará todos los elementos del juego como al inicio
    global vidasJugador, puntuacion, estado, ladrillos, ladrillosDestruidos, jugador

    vidasJugador = 3  # Se reestablecen las vidas para empezar de nuevo
    puntuacion = 0  # Se reestablece la puntuación a 0
    estado = 0  # Inicializa el estado a cero para que el método dibujaLadrillos pinte todos de nuevo
    ladrillos = []  # Array donde almacenamos los ladrillos
    dibujaLadrillos()  # Llama al método que pinta los ladrillos
    ladrillosDestruidos = 0  # Reestablece que no hay ningún ladrillo destruido
    reiniciaBola()  # Reinicia la bola para empezar de nuevo desde la posición inicial
    # Posiciona la paleta en la posición original
    jugador = pygame.Rect(anchoVentana / 2 - 50, altoVentana - 20, 100, 10)

# Configuración principal
pygame.mixer.pre_init(44100, -16, 2, 512)  # Iniciamos el mezclador de sonido. Valores por defecto, menos el buffer, que lo ponemos a 512 en vez de 4196 para que no se retrase el sonido
pygame.init()  # Inicializa pygame
reloj = pygame.time.Clock()  # Crea un objeto Clock para que el juego se ejecute a velocidad constante

# Ventana principal
anchoVentana = 960  # Ancho de la ventana
altoVentana = 720   # Alto de la ventana
ventana = pygame.display.set_mode((anchoVentana, altoVentana))  # Construye la superficie con las dimensiones indicadas
pygame.display.set_caption('Destrozando ladrillos')  # Define el título de la ventana

# Variables de elementos que se muestran en pantalla
bola = pygame.Rect(anchoVentana / 2 - 12.5, altoVentana - 50, 25, 25)  # Define posición de la bola - Posición X, posición Y, ancho y alto (en el centro)
jugador = pygame.Rect(anchoVentana / 2 - 50, altoVentana - 20, 100, 10)  # Define posición de la paleta del jugador

# Asignación de colores
colorFondo = pygame.image.load("fondo.jpg").convert()  # Define el color del fondo de la superficie
color_ladrillos = pygame.Color('darkturquoise')  # Color de los ladrillos
color_jugador = pygame.Color('mediumorchid')  # Color de la pala
color_bola = pygame.Color('greenyellow')  # Color de la bola
color_texto = pygame.Color('greenyellow')  # Color del texto

# Variables del juego
velocidadBolaX = -7 * random.choice((1, -1))  # Define velocidad horizontal. La bola comienza en una dirección aleatoria.
velocidadBolaY = -7  # Define velocidad vertical
velocidadJugador = 0  # Define la velocidad del jugador

# Variables de ladrillos
filasLadrillos= 5  # Define el número de filas
columnasLadrillos = 7  # Define el número de columnas
anchoLadrillo = 115  # Define el ancho del ladrillo
altoLadrillo = 30  # Define el alto del ladrillo
paddingLadrillo=15  # Define el grosor del ladrillo
margenTopLadrillo = 100  # Define el margen por arriba
margenIzqLadrillo = 30  # Define el margen izquierdo
ladrillosDestruidos = 0  # Variable que contabilizará los ladrillos que se destruyen
ladrillos = []  # Array que almacena los ladrillos
estado = 0  # Variabole que controla qué ladrillos se deben dibujar en cada momento del juego

# Variables de texto
puntuacion = 0  # Variabla de puntuación del jugador
vidasJugador = 3  # Variable de vidas que quedan
fuenteTexto = pygame.font.Font("coolveticarg.ttf", 32)  # Estilo de fuente de los textos del juego

# Variables de sonido
sonido_GameOver = pygame.mixer.Sound("GameOver.wav")
sonido_Ganar = pygame.mixer.Sound("WinnerSound.wav")
sonido_Ladrillo = pygame.mixer.Sound("Brick_Destroyed.wav")
sonido_Jugador = pygame.mixer.Sound("Colission.wav")
sonido_PerderVida = pygame.mixer.Sound("LifeLost.wav")

#Ciclo principal
while True:  # Ciclo principal
    # Manejo de entrada
    for event in pygame.event.get():  # Registra los eventos en una cola de eventos.
        if event.type == pygame.QUIT:  # Si pulsamos la X de la ventana para cerrar
            pygame.quit()  # Cierra la ventana
            sys.exit()  # Termina la ejecución
        if event.type == pygame.KEYDOWN:  # Si se presiona una tecla en el teclado
            if event.key == pygame.K_RIGHT:  # Si se presiona la fecha de abajo
                velocidadJugador += 10  # La paleta del jugador se mueve +7 píxeles (hacia abajo)
            if event.key == pygame.K_LEFT:  # Si se presiona la fecha de arriba
                velocidadJugador -= 10  # La paleta del jugador se mueve -7 píxeles (hacia abajo)

        if event.type == pygame.KEYUP:  # Si soltamos la tecla
            if event.key == pygame.K_RIGHT:  # Si se presiona la fecha de abajo
                velocidadJugador -= 10  # La paleta del jugador se mueve +7 píxeles (se queda quieta)
            if event.key == pygame.K_LEFT:  # Si se presiona la fecha de arriba
                velocidadJugador += 10  # La paleta del jugador se mueve 10 pixeles (se queda quieta)



    #Dibuja todos los elementos del juego
    ventana.blit(colorFondo, [0, 0])  # Dibuja la superficie de un color sólido
    pygame.draw.rect(ventana, color_jugador, jugador)  # Dibuja la pala del jugador - superficie, color rectángulo
    pygame.draw.ellipse(ventana, color_bola, bola)  # Dibuja la bola - superficie, color, rectángulo

    # Muestra la puntuación y las vidas
    textoJugador = fuenteTexto.render("Vidas: " + f"{vidasJugador}", True, color_texto)  # Texto a mostrar
    ventana.blit(textoJugador, (800, 25))  # Posición del texto en la pantalla
    textoPuntuacion = fuenteTexto.render("Puntuación: " + f"{puntuacion}", True, color_texto)  # Texto a mostrar
    ventana.blit(textoPuntuacion, (30, 25))  # Posición del texto en pantalla

    #Lógica del juego
    animacionBola()  # Llama a la función que se encarga de la animación de la bola
    animacionJugador()  # Llama a la función que se encarga de la animación de la pala
    dibujaLadrillos()  # Llama a la función que dibuja los ladrillos
    comprobarVictoria()  # Llama a la función que controla cuando se gana la partida
    colisionLadrillos()  # llama a la función que contorla la colisión de la bola con los ladrillos

    #Actualiza la ventana
    pygame.display.flip()  # Actualiza el contenido de la ventana.
    reloj.tick(60)  # El programa nunca se ejecutará a más de 60 fotogramas por segundo