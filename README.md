<h1>Programacion III - Universidad Nacional de General Sarmiento</h1>
<h2>Trabajo Practico 1: W-UNGS-dle</h2>
<br>
<p>
  El objetivo del trabajo práctico es implementar una aplicación para jugar a Wordle. El juego
  consiste en adivinar una palabra secreta de cinco letras que propone la aplicacion. Al iniciar
  el juego, la aplicacion selecciona aleatoriamente la palabra secreta de una lista de palabras, y
  el usuario debe adivinar la palabra secreta arriesgando palabras por turnos. En cada turno
  el usuario le informa al juego una palabra. Si la palabra que introdujo el usuario coincide
  con la palabra secreta, el usuario gana el juego. Si no, la aplicacion le informa al usuario el
  "status" de cada letra de la palabra:
</p>

• Si la letra no esta en la palabra secreta, se marca en gris.<br>
• Si la letra esta en la palabra secreta pero no esta en la misma posicion que en la palabra
  que dio el usuario, se marca en amarillo.<br>
• Si la letra est´a en la palabra secreta y en la posicion correcta, se marca en verde.
  El usuario tiene seis intentos para descubrir la palabra secreta. Si luego de los seis intentos
  no lo consigue, pierde el juego.
  <br>
  <h3>UML</h3>
  
<img width="421" alt="uml_wordle" src="https://user-images.githubusercontent.com/59884602/190047919-db522ec9-e2f4-4e8b-8011-49be648afb20.png">
