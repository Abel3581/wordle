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
<ul>
  <li>Si la letra no esta en la palabra secreta, se marca en gris.</li>
  <li>Si la letra esta en la palabra secreta pero no esta en la misma posicion que en la palabra
   que dio el usuario, se marca en amarillo.</li>
  <li>Si la letra esta en la palabra secreta y en la posicion correcta, se marca en verde.
     El usuario tiene seis intentos para descubrir la palabra secreta. Si luego de los seis intentos
     no lo consigue, pierde el juego.</li>
</ul>
<h3>Como objetivos opcionales no obligatorios, se pueden contemplar los siguientes elementos:</h3>
<ol>
  <li>Proponer varios niveles de dificultad, que consistan por ejemplo en palabras más difíciles
    o bien una menor cantidad de intentos.</li>
  <li>Permitir que el idioma de la aplicación sea configurable.</li>
  <li>Medir el tiempo que tarda el usuario en adivinar la palabra, y mostrar el mejor tiempo
    hasta el momento.</li>
</ol>

  <br>
  <h3>Tecnologias</h3>
  <ul>
    <li>Java-11</li>
    <li>Swing</li>
</ul>
<br>
  <h3>UML</h3>
  
<img width="421" alt="uml_wordle" src="https://user-images.githubusercontent.com/59884602/190047919-db522ec9-e2f4-4e8b-8011-49be648afb20.png">
<br>
<img width="158" alt="1m" src="https://user-images.githubusercontent.com/59884602/190048832-3ed526cb-81a6-49eb-a497-29a38b1e2f3c.png">

<img width="156" alt="2m" src="https://user-images.githubusercontent.com/59884602/190048842-faa10c3d-df2e-42c7-9184-bdd42b864560.png">

<img width="154" alt="3m" src="https://user-images.githubusercontent.com/59884602/190048851-f9b77575-886d-4192-ba2b-1826f22bcaf2.png">
<br>
