# FlappyEagle
![Flappy Eagle](http://i.imgur.com/N3h06Kk.png)

### Objetivo del juego
Flappy Eagle es un juego sobre un águila que debe ir volando por el mundo sin caer al suelo, sin chocar con los obstáculos y recolectando comida para así sumar puntos, tendrá 3 tipos de comida y cada una le dará un puntaje diferente al jugador, si cae al suelo o choca con un obstáculo el juego termina, así mismo tendrá 3 tipos de obstáculos diferentes, uno mas difícil de superar que otro, entre mas obstáculos supere y mas comida recolecte su puntaje va a ser mas alto hasta que al fin pierda.

### Descripción del juego
Un obstáculo es una tubería que aparece arriba y abajo para que el personaje vuele por en medio, al pasar se suma 1 al score, estas aparecen random y si choca contra una de estas, termina el juego. El segundo obstáculo será una planta carnívora saliendo random de ciertas tuberías y al tocarlas se termina el juego. El obstáculo 2 son fantasmas volando por el mundo y al tocarlo igualmente se termina el juego. En cuanto a las comidas, si recolecta unas papas fritas se suma 1 al score, si recolecta la hamburguesa se suma 2 al score y si recolecta la pizza se suman 5 al score y el personaje se vuelve inmune hasta que termine el efecto, entre mas puntaje te de la comida, mas difícil es de recolectar porque se va a mover mas rápido.

### Clases principales y sus características
1. FlappyWorld
* Creación de los objetos.
* Añadir los objetos al mundo.

2. FlappyEagle
* Movimiento del personaje.
* Checar colisiones con otros objetos.
* Aumentar el puntaje.
* Reproducir sonidos.

3. Pipes
* Aparecen cada cierta distancia.
* El espacio entre ellas es aleatorio.
* Al superar el obstáculo, suma 1 al score.

4. Piranha
* Aparecen aleatoriamente.
* Al tocar una, termina el juego.

5. Ghost
* Aparecen aleatoriamente.
* Pueden aparecer arriba o abajo.
* Al tocar uno, termina el juego.

6. Score
* Maneja el puntaje

7. GameStuff
* Contiene todos los objetos (imagenes) que simplemente aparecen o desaparecen en pantalla. Por ejemplo: El titulo.

8. Food
* Contiene las comidas
* Les da la velocidad a la que deben de ir

9. Fries
* Aparecen aleatoriamente pero más seguido y suman 1 al score.

10. Burger
* Aparecen aleatoriamente cada cierto tiempo, se mueven más rápido y suman 3 al score.

11. Pizza
* Aparecen aleatoriamente cada cierto tiempo, se mueven aún más rápido y suman 5 al score.
* Vuelve inmuna al jugador durante cierto tiempo.

### Diagrama de clases
![Diagrama de clases](http://i.imgur.com/FneZFLN.png)

### Autor
El autor del proyecto es:
- Jorge Hernan Casillas Cabrera (@hernancasillas)

### Materia
- Programación Orientada a Objetos

### Semestre
- 2016-2017/II

### Universidad Autónoma de San Luis Potosí, 2017

### Markdown
El contenido de esta página está escrito en un lenguaje de marcado sencillo llamado _Markdown_. **Para modificar el contenido de esta página se tiene que editar el archivo README.md del repositorio**. Para más detalles consulta la página de [Markdown para GitHub](https://guides.github.com/features/mastering-markdown/).

### Temas de Jekyll
El estilo y presentación de esta página utiliza el tema de Jekyll seleccionado en la configuración del repositorio. El nombre de este tema está almacenado en el archivo de configuración `_config.yml`. Para más información acerca de los temas de Jekyll soportados por GitHub [haz click en este enlace](https://pages.github.com/themes/).
