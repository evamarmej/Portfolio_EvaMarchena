import pygame
import sys
import random


def animacion_bola():  # Función que se encarga del movimiento de la bola
    global velocidad_bola_x, velocidad_bola_y, puntuacion_jugador, puntuacion_oponente, tiempo_puntuacion
    bola.x += velocidad_bola_x  # En cada vuelta del bucle, la bola se moverá horizontalmente en 7
    bola.y += velocidad_bola_y  # En cada vuelta del bucle, la bola se moverá verticalmente en 7

    # Control de colisiones de la bola con la pantalla
    if bola.top <= 0 or bola.bottom >= alto_pantalla:  # Si la parte superior de la bola es menor o igual a 0 o la inferior es igual o mayor a la altura de la pantalla
        pygame.mixer.Sound.play(sonido_pong)
        velocidad_bola_y *= -1  # Invierte el movimiento de la bola
    #  Si la parte izquierda está fuera de la pantalla
    if bola.left <= 0:
        pygame.mixer.Sound.play(sonido_puntuacion)
        puntuacion_jugador += 1
        tiempo_puntuacion = pygame.time.get_ticks()  # Indica cuánto tiempo ha funcionado el juego desde que se ha iniciado
    #  Si la parte derecha está fuera de la pantalla
    if bola.right >= ancho_pantalla:
        pygame.mixer.Sound.play(sonido_puntuacion)
        puntuacion_oponente += 1
        tiempo_puntuacion = pygame.time.get_ticks()  # Indica cuánto tiempo ha funcionado el juego desde que se ha iniciado

    # Control de colisiones de la bola con las paletas
    if bola.colliderect(jugador) and velocidad_bola_x > 0:  # Si colisiona con la paleta del jugador y la dirección del balón es positiva
        pygame.mixer.Sound.play(sonido_pong)
        if abs(bola.right - jugador.left) < 10:  # Si la paleta del jugador ha sido golpeada por la bola por el lateral
            velocidad_bola_x *= -1  #  Mueve la dirección de la bola
        elif abs(bola.bottom - jugador.top) < 10 and velocidad_bola_y > 0:  # Si la paleta del jugador ha sido golpeada por la bola por arriba o abajo
            velocidad_bola_x *= -1  # Mueve la dirección de la bola
        elif abs(bola.top - jugador.bottom) < 10 and velocidad_bola_y < 0:  # Si la paleta del jugador ha sido golpeada por la bola por arriba o abajo
            velocidad_bola_x *= -1  # Mueve la dirección de la bola

    if bola.colliderect(oponente) and velocidad_bola_x < 0:  # Si colisiona con la paleta oponente y la dirección del valor es negativa
        pygame.mixer.Sound.play(sonido_pong)
        if abs(bola.left - oponente.right) < 10:  # Si la paleta del oponente ha sido golpeada por la bola por el lateral
            velocidad_bola_x *= -1  #  Mueve la dirección de la bola
        elif abs(bola.bottom - oponente.top) < 10 and velocidad_bola_y > 0:  # Si la paleta del jugador ha sido golpeada por la bola por arriba o abajo
            velocidad_bola_x *= -1  # Mueve la dirección de la bola
        elif abs(bola.top - oponente.bottom) < 10 and velocidad_bola_y < 0:  # Si la paleta del jugador ha sido golpeada por la bola por arriba o abajo
            velocidad_bola_x *= -1  # Mueve la dirección de la bola



def animacion_jugador():
    jugador.y += velocidad_jugador

    # Control de movimiento de la paleta, para que no salga de la pantalla
    if jugador.top <= 0:  # Si la parte superior del jugador es menor o igual a 0
        jugador.top = 0  # Ponemos la perte superior de la paleta en la posición 0
    if jugador.bottom >= alto_pantalla:  # Si la parte inferior del jugador es mayor o igual al alto de la pantalla
        jugador.bottom = alto_pantalla  # Ponemos la parte inferior del jugador en la posición del alto de la pantalla


def animacion_oponente():
    #  Control de movimiento de la paleta, para que se mueva en la misma dirección de la pelota
    if oponente.top < bola.y:  # Si la parte superior del oponente está por encima del centro de la pelota
        oponente.top += velocidad_oponente  # Mueve al oponente hacia abajo
    if oponente.bottom > bola.y:  # Si la parte inferior del oponente está por debajo del centro de la pelota
        oponente.bottom -= velocidad_oponente  # Mueve al oponente hacia arriba
    # Control de movimiento de la paleta, para que no salga de la pantalla
    if oponente.top <= 0:  # Si la parte superior del oponente es menor o igual a 0
        oponente.top = 0  # Ponemos la perte superior de la paleta en la posición 0
    if oponente.bottom >= alto_pantalla:  # Si la parte inferior del oponente es mayor o igual al alto de la pantalla
        oponente.bottom = alto_pantalla  # Ponemos la parte inferior del jugador en la posición del alto de la pantalla


def reinicia_bola():
    global velocidad_bola_x, velocidad_bola_y, tiempo_puntuacion

    # Mide el tiempo
    current_time = pygame.time.get_ticks()  #  Obtiene hora actual en que se va a colocar la bola al centro de la pantalla
    bola.center = (ancho_pantalla/2, alto_pantalla/2)  # Posiciona la bola en el centro de la pantalla

    if current_time - tiempo_puntuacion < 700:  # Si han pasado menos de 700 milisegundos entre que la  bola ha colisionado y se ha colocado en el centro de la pantalla
        number_three = fuente_juego.render("3", False, color)  # Aparece un 3
        pantalla.blit(number_three, (ancho_pantalla/2 - 10, alto_pantalla/2 + 20))

    if 700 < current_time - tiempo_puntuacion < 1400:  # Si han pasado entre 700 y 1400 entre que la bola ha colisionado y se ha colocado en el centro de la pantalla
        number_number = fuente_juego.render("2", False, color)  # Aparece un 2
        pantalla.blit(number_number, (ancho_pantalla/2 - 10, alto_pantalla/2 + 20))

    if 1400 < current_time - tiempo_puntuacion < 2100:  # Si han pasado entre 1400 y 2100 entre que la bola ha colisionado y se ha colocado en el centro de la pantalla
        number_one = fuente_juego.render("1", False, color)  # Aparece un 1
        pantalla.blit(number_one, (ancho_pantalla/2 - 10, alto_pantalla/2 + 20))

    if current_time - tiempo_puntuacion < 2100:  # Si el tiempo actual menos el tiempo de puntuación es menor a 2.1 segundos
        velocidad_bola_x, velocidad_bola_y = 0, 0  # La velocidad de la bola es cero y se queda en el centro de la pantalla
    else:  # Cuando el tiempo actual menos el tiempo de puntuación es mayor de 2.1 segundos
        velocidad_bola_y = 7 * random.choice((1, -1))  # Se reiniciará con velocidad 7 y un valor random en vertical, por lo que puede ir hacia arriba o hacia abajo
        velocidad_bola_x = 7 * random.choice((1, -1))  # Se reiniciará con velocidad 7 y un valor random en horizontal, por lo que puede ir hacia la derecha o hacia la izquierda
        tiempo_puntuacion = None

# Configuración general
pygame.mixer.pre_init(44100, -16, 2, 512)  # Iniciamos el mezclador de sonido. Valore por defecto, menos el buffer, que lo ponemos a 512 en vez de 4196 para que no se retrase el sonido
pygame.init()  # Inicializa pygame
reloj = pygame.time.Clock()  # Crea un objeto Clock para que el juego se ejecute a velocidad constante

# Ventana principal
ancho_pantalla = 960  # Ancho de la ventana
alto_pantalla = 720  # Alto de la ventana
pantalla = pygame.display.set_mode((ancho_pantalla, alto_pantalla))  # Construye la superficie con las dimensiones indicadas
pygame.display.set_caption('Juego de Ping-Pong')  # Define el título de la ventana

#  Variables de rectángulos
bola = pygame.Rect(ancho_pantalla / 2 - 15, alto_pantalla / 2 - 15, 25, 25)  # Define posición de la bola - Posición X, posición Y, ancho y alto (en el centro)
jugador = pygame.Rect(ancho_pantalla - 20, alto_pantalla / 2 - 70 - 300, 10, 100)  # Define posición de la paleta del jugador
oponente = pygame.Rect(10, alto_pantalla / 2 - 70, 10, 100)  # Define posición de la paleta del oponente

#  Colores
color_fondo = pygame.Color('grey12')  # Define el color
color = (200, 200, 200)  # Intensidad del color

#  Variables del juego
velocidad_bola_x = 7 * random.choice((1, -1))  # Define velocidad horizontal. La bola comienza en una dirección aleatoria.
velocidad_bola_y = 7 * random.choice((1, -1))  # Define velocidad vertical. La bola comienza en una dirección aleatoria.
velocidad_jugador = 0  # Define velocidad del jugador
velocidad_oponente = 7  # Define la velocidad del oponente

#  Variables de texto
puntuacion_jugador = 0  # Variable de puntuación del jugador
puntuacion_oponente = 0  # Variable de puntuación del oponente
fuente_juego = pygame.font.Font("freesansbold.ttf", 32)  # Define la fuente del texto (tipo y tamaño)

# Temporizador de puntuación
tiempo_puntuacion = True  # Inicializarlo a true hace que cuando empieza el juego haga cuenta atrás

#  Sonido
sonido_pong = pygame.mixer.Sound("pong.ogg")
sonido_puntuacion = pygame.mixer.Sound("score.ogg")


while True:  # Ciclo principal
    # Manejo de entrada
    for event in pygame.event.get():  # Registra los eventos en una cola de eventos.
        if event.type == pygame.QUIT:  # Si pulsamos la X de la ventana para cerrar
            pygame.quit()  # Cierra la ventana
            sys.exit()  # Termina la ejecución
        if event.type == pygame.KEYDOWN:  # Si se presiona una tecla en el teclado
            if event.key == pygame.K_DOWN:  # Si se presiona la fecha de abajo
                velocidad_jugador += 7  # La paleta del jugador se mueve +7 píxeles (hacia abajo)
            if event.key == pygame.K_UP:  # Si se presiona la fecha de arriba
                velocidad_jugador -= 7  # La paleta del jugador se mueve -7 píxeles (hacia arriba)

        if event.type == pygame.KEYUP:  # Si soltamos la tecla
            if event.key == pygame.K_DOWN:  # Si se presiona la fecha de abajo
                velocidad_jugador -= 7  # La paleta del jugador se mueve +7 píxeles (se queda quieta)
            if event.key == pygame.K_UP:  # Si se presiona la fecha de arriba
                velocidad_jugador += 7  # La paleta del jugador se mueve -7 píxeles (Se queda quieta)

    #  Lógica del juego
    animacion_bola()  # Se llama a la función que se encarga del movimiento de la bola
    animacion_jugador()  # Se llama a la función que se encarga del movimiento del jugador
    animacion_oponente()  # Se llama a la función que se encarga del movimiento del oponente

    # Dibuja los rectángulos en la superficie
    pantalla.fill(color_fondo)  # Dibuja la superficie de un color sólido
    pygame.draw.rect(pantalla, color, jugador)  # Dibuja la paleta del jugador - superficie, color, rectángulo
    pygame.draw.rect(pantalla, color, oponente)  # Dibuja la paleta del oponente - superficie, color, rectángulo
    pygame.draw.ellipse(pantalla, color, bola)  # Dibuja la bola - superficie, color, rectángulo
    pygame.draw.aaline(pantalla, color, (ancho_pantalla / 2, 0), (ancho_pantalla / 2, alto_pantalla))  # Define una linea - pantalla, color, posición

    if tiempo_puntuacion:  #Si se controla el tiempo de puntuación
        reinicia_bola()  # Se reinicia la bola

    #  Crear superficie con el texto. Tiene que estar debajo de estas líneas o se pintará el texto debajo del fondo y no se verá
    #  Muestra la puntuación del jugador
    texto_jugador = fuente_juego.render(f"{puntuacion_jugador}", False, color)
    pantalla.blit(texto_jugador, (500, 50))  # Pone una superficie sobre otra. Superficie que queremos poner en la superficie, dónde poner el texto.
    #  Muestra la puntuación del oponente
    texto_oponente = fuente_juego.render(f"{puntuacion_oponente}", False, color)
    pantalla.blit(texto_oponente, (440, 50))  # Pone una superficie sobre otra. Superficie que queremos poner en la superficie, dónde poner el texto.

    # Actualiza la ventana
    pygame.display.flip()  # Actualiza el contenido de la ventana. Dibuja lo anterior
    reloj.tick(60)  # El programa nunca se ejecutará a más de 60 fotogramas por segundo
