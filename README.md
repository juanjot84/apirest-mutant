# Api Rest Mutantes

Magneto quiere reclutar la mayor cantidad de mutantes para poder luchar contra los X-Mens. Te ha contratado a ti para que desarrolles un proyecto que detecte si un humano es mutante basándose en su secuencia de ADN.
Para eso te ha pedido crear un programa con un método o función con la siguiente firma:

                                                     boolean isMutant(String[] dna)

En donde recibirás como parámetro un array de Strings que representan cada fila de una tabla
de (NxN) con la secuencia del ADN. Las letras de los Strings solo pueden ser: (A,T,C,G), las
cuales representa cada base nitrogenada del ADN.

<div align=”center”>
  <img src="https://cdn.icon-icons.com/icons2/1412/PNG/512/comics-magneto_97502.png" width="300" height="300"/>
</div>

### Descripción de los algoritmos desarrollados
#### Verificación de dna
En primera instancia, se verifica que el dna recibido contenga sólamente las letras correspondientes a la base nitrogenada (A,T,C,G), en donde se utiliza una expresión regular para tal propósito:

```
"^[ATCG]+$"
```
Si el dna es incorrecto, la aplicación devolverá el siguiente mensaje:

```
{"dna incorrecto"}
```
#### Código de búsqueda
El algoritmo fue planteado con la premisa de no tener que recorrer la matriz elemento por elemento para poder determinar si el dna es mutante o no.
Para evitar procesamiento innecesario, se controla en todo momento que de cumplirse la condición mínima de encontrar más de una secuencia de cuatro letras iguales,
la aplicación finaliza su ejecución y devuelve el resultado correspondiente.

Respuesta de mutante encontrado:
```
{"Es mutante"}
```
Respuesta de humano encontrado:
```
{"Es humano"}
```

La estrategia de búsqueda consiste en escanear un caracter cada tanto de manera que alcance a ver con lo justo si hay dos iguales y cercanos que podrían formar parte de una cadena de 4.
Para longitud 4 resultó ser escanear el primer y último caracter de una cadena de 4 elementos. En el caso de que estos dos valores sean iguales, se evaluan los valores restantes,
en el caso de que los dos primeros valores de los extremos no sean iguales se avanza hacia los siguientes caracteres.
En el caso de los recorridos de forma oblicua, al presentarse la situación de que no todas las líneas de letras tendrán una longitud de cuatro caracteres,
se controla su longitud y se omiten las que tengan una dimensión menor a cuatro.

### Uso
La plicación cuenta con 2 servicios:

#### Detección de mutantes

https://mutant-apirest-jjt.herokuapp.com/api/v1/mutant

Servicio en donde se puede detectar si un humano es mutante enviando la secuencia de ADN mediante un HTTP POST con un Json el cual tenga el siguiente formato:
```
{
  “dna”:["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]
}
```
#### Estadísticas

https://mutant-apirest-jjt.herokuapp.com/api/v1/mutant/stats

Servicio que devuelve un Json con las estadísticas de las verificaciones de ADN

```
ADN: {“count_mutant_dna”:40, “count_human_dna”:100: “ratio”:0.4}
```

### Tecnología

- Java 11
- Spring Boot
- MySQL
- JPA
- Heroku

### The Be Sharps - Integrantes

<table border="0">
  <tr>
    <td>
      <img src="https://i.pinimg.com/564x/59/15/52/5915521ddfe5e6080feecad542ace83c.jpg" width="250" height="250"/>
    </td>
    <td>
      <ul>
        <li>Andres Jesus Capone - Legajo 42821</li>
        <li>Mariano Gabriel Martinez Said- Legajo 40013</li>
        <li>Juan José Tassin - Legajo 27213</li>
        <li>Sebastian Morici - Legajo 45365</li>
      </ul>
    </td>
  </tr>
</table>
