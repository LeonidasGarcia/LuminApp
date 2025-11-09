package com.luminteam.lumin.ui.mock

import com.luminteam.lumin.ui.domain.PageData

// lol

// Section id=0

val WhatIsAProgramPage = PageData(
    id = 0,
    content = """# ¿Qué es un Programa?

Un **programa** (o _software_) es un conjunto de **instrucciones** lógicas, precisas y ordenadas, que le decimos a una computadora que ejecute para lograr un objetivo específico.

Piensa en un programa como una **receta detallada**: la computadora es el chef, y las instrucciones le indican exactamente qué pasos seguir, en qué orden y con qué ingredientes (datos).

| **Concepto**      | **Definición**                                                                                         |
| ----------------- | ------------------------------------------------------------------------------------------------------ |
| **Instrucción**   | La orden más simple que la CPU puede entender: guardar un dato, sumar dos números, mostrar un mensaje. |
| **Código Fuente** | El texto (la "receta") escrito por el programador en un lenguaje que es legible para humanos.          |
| **Ejecución**     | El proceso en el que la computadora sigue las instrucciones del código fuente.                         |

## Introducción al Lenguaje de Programación: Python

A lo largo de este curso, utilizaremos **Python**. Python es un lenguaje de **alto nivel**, lo que significa que es muy similar al idioma inglés y está diseñado para ser fácil de leer y escribir. Esto nos permite centrarnos en los conceptos de programación sin distraernos con sintaxis compleja.

Python es extremadamente popular debido a su **simplicidad y versatilidad**, siendo utilizado en desarrollo web, análisis de datos, inteligencia artificial y automatización.

## Ejemplos de Instrucciones Básicas en Python

A continuación, se muestra cómo se ven las instrucciones básicas que estudiaremos en Python:

- Ordena la computadora a mostrar el mensaje en pantalla

```python
print("Hola Lumin")
```

```txt
Output: Hola Lumin
```

- Ordena a la computadora guardar el valor 25 en el **contenedor** llamado edad

```python
edad = 25
```

- Ordena sumar y guardar el resultado (`8`) en el contenedor llamado `suma`.

```python
suma = 5 + 3
```


En las siguientes páginas, aprenderemos cómo la computadora ejecuta estas instrucciones de manera **secuencial**.""",
    pageNumber = 1
)

val SequentialExecutionPage = PageData(
    id = 1,
    content = """# Ejecución Secuencial

La **Ejecución Secuencial** es el principio más fundamental del flujo de programa: las instrucciones se ejecutan una después de la otra, **en el orden exacto en que aparecen en el código**, de arriba hacia abajo.

## La Regla de Oro del Flujo

1. La computadora lee la **Línea 1**.
2. La ejecuta y la completa.
3. Solo entonces, pasa a leer y ejecutar la **Línea 2**.
4. Este proceso continúa hasta que se alcanza la última instrucción del programa.

Este orden estricto es lo que garantiza la **predecibilidad**. El valor de una variable en la Línea 5 depende de los cálculos realizados en las líneas 1 a 4. Si el orden cambiara, el resultado sería incorrecto.

## Ejemplo con Python

Considera el siguiente código. Nota cómo la salida del programa (el valor de `c`) se define completamente por la secuencia de las tres líneas anteriores:

|Línea|Instrucción en Python|Flujo de Ejecución (Paso a Paso)|
|---|---|---|
|**1**|`a = 10`|La computadora guarda el número **10** en la memoria con el nombre `a`.|
|**2**|`b = 5`|La computadora guarda el número **5** en la memoria con el nombre `b`.|
|**3**|`c = a + b`|La computadora **lee los valores actuales** de `a` (10) y `b` (5), los suma, y guarda el resultado **15** en `c`.|
|**4**|`print(c)`|La computadora muestra el valor actual de `c`. **Salida: 15**|
## Consecuencias de la Secuencia

La ejecución secuencial tiene dos implicaciones clave:

1. **Dependencia:** Si intentaras usar la variable `c` en la Línea 2, el programa fallaría, ya que `c` aún no ha sido definida por la operación en la Línea 3.
2. **Sobreescritura:** Una instrucción posterior siempre **sobrescribe** el resultado de una instrucción anterior si ambas usan la misma variable.

### Ejemplo de Sobreescritura:

```python
total = 5
total = 10  
print(total)
```

```txt
Output: 10
```

En este caso, la Línea 2 se ejecuta _después_ de la Línea 1, lo que resulta en la pérdida del valor original `5`.""",
    pageNumber = 2
)

val InstructionTypesPage = PageData(
    id = 2,
    content = """# Tipos de Instrucciones

Aunque las instrucciones varían entre lenguajes, todas cumplen una de estas funciones básicas para que el programa pueda interactuar y procesar datos.

## 1. Instrucciones de Asignación

Son la base para almacenar y manipular datos. Estas instrucciones **guardan un valor** en un contenedor de memoria llamado **variable**.

| Concepto       | Descripción                                                                        | Ejemplo en Python       |
| -------------- | ---------------------------------------------------------------------------------- | ----------------------- |
| **Asignación** | Define o actualiza el valor de una variable, usando el operador de igualdad (`=`). | `precio = 45.99`        |
| **Cálculo**    | Combina la asignación con operadores aritméticos (`+`, `-`, `*`, `/`).             | `total = precio * 1.15` |
| **Lógica**     | Combina valores y produce un resultado Booleano (`True` o `False`).                | `es_mayor = edad > 18`  |
## 2. Instrucciones de Entrada/Salida (I/O)

Permiten al programa comunicarse con el mundo exterior (el usuario, un archivo, la red, etc.).

|Tipo|Función|Ejemplo en Python|
|---|---|---|
|**Salida (Output)**|Muestra datos o resultados al usuario, generalmente en la consola.|`print("El total es:", total)`|
|**Entrada (Input)**|Permite al programa recibir datos del usuario. El programa **espera** hasta que el usuario ingresa la información.|`nombre = input("Dime tu nombre: ")`|
**Nota sobre la Secuencia:** Cuando la computadora llega a una instrucción `input()`, la ejecución secuencial **se pausa** hasta que el usuario presiona Enter.

## 3. Instrucciones de Control de Flujo

Estas son las instrucciones que **rompen** la regla de la ejecución secuencial. En lugar de seguir la línea siguiente, deciden si saltar, repetir o tomar un camino diferente.

|Tipo|Propósito|Ejemplo (Concepto)|
|---|---|---|
|**Condicionales**|Tomar decisiones. Ejecutar un bloque de código **SOLO SI** se cumple una condición (ej. `IF-THEN-ELSE`).|Si la edad es mayor a 18, imprimir "Adulto".|
|**Bucles**|Repetir un bloque de código varias veces hasta que se cumpla una condición de parada.|Repetir 10 veces la instrucción de imprimir.|
Las instrucciones de control de flujo son esenciales, ya que un programa que solo se ejecuta secuencialmente es muy limitado. Estas serán exploradas en detalle en secciones posteriores.""",
    pageNumber = 3
)

val SyntaxAndErrorsPage = PageData(
    id = 3,
    content = """# Sintaxis y Errores

Para que un programa pueda ser ejecutado **secuencialmente**, cada instrucción debe estar escrita correctamente. Aquí es donde entra en juego la sintaxis y el manejo de errores.

## 1. La Sintaxis: La Gramática del Código

La **Sintaxis** es el conjunto de reglas que definen cómo deben estructurarse las instrucciones en un lenguaje de programación. Es la gramática que el intérprete (en este caso, Python) entiende.

- **En Lenguaje Humano:** Las reglas de sintaxis definen que una oración debe terminar con un punto o que los nombres deben empezar con mayúscula.
- **En Python:** Las reglas definen el uso correcto de dos puntos (`:`) después de una condición o el uso obligatorio de la **indentación** (espacios o tabulaciones) para definir bloques de código.


**Ejemplo de Sintaxis Correcta:**

```python
if 5 > 2: 
	print("Cinco es mayor")
```

```txt
Output: Cinco es mayor
```

## 2. El Error de Sintaxis (`SyntaxError`)

Un **Error de Sintaxis** ocurre cuando el programador rompe las reglas del lenguaje.

- **Consecuencia:** Si el intérprete encuentra un error de sintaxis, no puede traducir la instrucción. La ejecución secuencial **se detiene inmediatamente** y el programa no puede continuar.
    
- **Identificación:** El intérprete generalmente señala la línea y la columna donde se detectó el error, lo que facilita al programador corregirlo.
    

**Ejemplo de Error de Sintaxis en Python:**

```python
if 10 == 10 
	print("Faltan dos puntos")
```

```txt
Output: Syntax Error
```

### 3. La Clave de la Ejecución Secuencial y los Errores

Es importante notar la diferencia entre un error de sintaxis y la lógica incorrecta:

|Tipo de Error|¿Cuándo Ocurre?|¿Detiene la Secuencia?|
|---|---|---|
|**Sintaxis**|Antes de que el código comience a ejecutarse.|**SÍ.** El intérprete no puede traducir el código.|
|**Lógico**|Durante la ejecución (por ejemplo, una variable no existe o una operación es imposible).|SÍ, pero solo **en la línea del error**.|
Ejemplo de Error Lógico (en Tiempo de Ejecución):

```python
a = 10
b = 0
c = a / b
print("Fin")
```

```txt
Output: Syntax Error
```

En conclusión, la **ejecución secuencial** solo es posible si cada línea, desde la primera hasta la última, respeta rigurosamente la **sintaxis** del lenguaje.""",
    pageNumber = 4
)

// Section id = 1

val WhatIsDataAbstractionPage = PageData(
    id = 4,
    content = """La **abstracción** es uno de los conceptos más importantes en programación.  
Significa **simplificar la realidad**, quedándonos solo con los **detalles esenciales** y ocultando la complejidad innecesaria.

Piensa en ella como una **caja negra**:  
Sabes **qué hace**, pero no necesitas saber **cómo lo hace internamente**.
#### 🧩 Ejemplo en la vida real

Cuando usas un **teléfono**, no necesitas entender cómo funciona el circuito interno.  
Solo sabes que si presionas un botón, ocurre una acción.  
En programación, pasa lo mismo: trabajamos con objetos o funciones sin preocuparnos por su implementación interna.
#### 💡 En programación:

|Concepto|Descripción|Ejemplo|
|---|---|---|
|**Abstracción**|Mostrar solo los detalles importantes y ocultar los irrelevantes.|Saber que `print()` muestra algo en pantalla sin entender cómo lo hace.|
|**Datos**|La información que manipulamos (números, texto, listas, etc.).|`edad = 18`|
|**Tipo de Dato**|Define la naturaleza del valor almacenado.|`int`, `float`, `str`, `bool`|

#### 🧮 Ejemplo en Python

```python
print("Hola Mundo")
```

👉 Sabes que la instrucción **muestra texto en pantalla**,  
pero no necesitas entender cómo Python maneja la memoria, la consola o los buffers.
""",
    pageNumber = 1
)

val DataAndDataTypesPage = PageData(
    id = 5,
    content = """#### **1. ¿Qué es un Dato?**

Un **dato** es cualquier valor que puede ser procesado por la computadora:  
un número, una palabra, un valor lógico, etc.

Los datos se almacenan en **variables**, y cada uno pertenece a un **tipo** que define qué operaciones se pueden hacer con él.

|**Tipo de Dato**|**Ejemplo**|**Descripción**|
|---|---|---|
|**int**|`25`|Números enteros (positivos o negativos).|
|**float**|`3.14`|Números decimales.|
|**str**|`"Hola"`|Cadenas de texto.|
|**bool**|`True` / `False`|Valores lógicos (verdadero o falso).|

#### **2. Ejemplo Básico en Python**

```python
# Ejemplos de tipos de datos
edad = 25              # int
altura = 1.75          # float
nombre = "Lumin"       # str
es_estudiante = True   # bool

print(type(edad))
print(type(altura))
print(type(nombre))
print(type(es_estudiante))
```

```txt
Output:
<class 'int'>
<class 'float'>
<class 'str'>
<class 'bool'>
```

#### **3. ¿Por qué son importantes los tipos de datos?**

Porque **cada tipo tiene un comportamiento distinto**.  
Por ejemplo, sumar dos números no es lo mismo que sumar dos textos.

```python
# Suma numérica
print(5 + 3)

# Suma de textos (concatenación)
print("Hola " + "Mundo")
```

```txt
Output:
8
Hola Mundo
```

#### **4. Conversión de Tipos (Casting)**

Python permite **convertir un tipo de dato en otro**.  
Esto se llama **“casting”**.

```python
# Convertir un número a texto
numero = 10
texto = str(numero)

# Convertir texto a número
edad = int("25")

print(texto)
print(edad + 5)
```

```txt
Output:
10
30
```
""",
    pageNumber = 2
)

val AbstractionAndVariablesPage = PageData(
    id = 6,
    content = """Una **variable** es una forma de **abstraer datos** dentro de un programa.  
En lugar de trabajar directamente con los valores, usamos **nombres simbólicos** que representan esos valores en la memoria de la computadora.

Cuando escribes:

```python
x = 10
```

Python crea un **espacio en memoria** donde guarda el valor `10`  
y lo asocia con el **nombre** `x`.

Así, tú no necesitas saber _dónde_ ni _cómo_ se almacena —  
solo trabajas con el nombre, y esa es la esencia de la **abstracción**.

### **1. Creación de Variables**

Las variables se crean simplemente asignando un valor con el operador `=`:

```python
nombre = "Lumin"
edad = 20
altura = 1.75
es_estudiante = True
```

```txt
Output:
No hay salida directa, pero los valores ya están almacenados en memoria.
```
### **2. Nombres de Variables**

Python tiene reglas para los nombres de variables:

|**Regla**|**Ejemplo Correcto**|**Ejemplo Incorrecto**|
|---|---|---|
|Debe comenzar con letra o guion bajo|`nombre`, `_edad`|`1dato`|
|No puede contener espacios|`mi_variable`|`mi variable`|
|Distingue mayúsculas/minúsculas|`Edad` ≠ `edad`|—|
|No puede usar palabras reservadas|—|`class`, `if`, `for`|

### **3. La Variable como Caja**

Imagina que una variable es una **caja con etiqueta**:

- La **etiqueta** es el nombre (por ejemplo, `precio`).
    
- El **contenido** es el valor (por ejemplo, `45.99`).
    

```python
precio = 45.99
print("El precio es:", precio)
```

```txt
Output:
El precio es: 45.99
```

Si cambias el contenido de la caja, la etiqueta sigue siendo la misma:

```python
precio = 45.99
precio = 39.99
print("Nuevo precio:", precio)
```

```txt
Output:
Nuevo precio: 39.99
```

Esto demuestra que una variable puede **actualizar su valor** en cualquier momento.

### **4. Variables como parte de la Abstracción**

Las variables nos permiten **darle significado a los datos**.

En lugar de hacer cálculos con números sueltos,  
usamos nombres que describen su propósito:

```python
subtotal = 120
impuesto = 0.18
total = subtotal + (subtotal * impuesto)
print("Total a pagar:", total)
```

```txt
Output:
Total a pagar: 141.6
```

En este ejemplo, el código se entiende casi como una oración en español.  
Eso es **abstracción semántica**: el código es más humano, claro y legible.
""",
    pageNumber = 3
)

val MutabilityAndConstantsPage = PageData(
    id = 7,
    content = """En Python, **no todo debe cambiar**.  
Algunos valores deben permanecer **constantes** durante la ejecución del programa.  
Entender qué puede cambiar (**mutabilidad**) y qué no (**inmutabilidad**) es esencial para escribir código predecible y confiable.
### **1. Constantes**

Aunque Python no tiene constantes “oficiales”, por convención se escriben **en mayúsculas**.  
Esto indica al lector del código que **no deben modificarse**.

```python
PI = 3.1416
GRAVEDAD = 9.8
APP_NAME = "Lumin Aprende Python"

print(PI)
print(APP_NAME)
```

```txt
Output:
3.1416
Lumin Aprende Python
```

Python **no impide** que cambies su valor,  
pero hacerlo va en contra de las buenas prácticas:

```python
PI = 3.1416
PI = 3   # ❌ Mala práctica: estás cambiando una constante
```

### **2. Mutabilidad e Inmutabilidad**

Algunos tipos de datos pueden **cambiar su contenido** sin necesidad de reasignarse,  
otros no.

|**Tipo**|**Mutable**|**Ejemplo**|
|---|---|---|
|`int`, `float`, `str`, `tuple`|❌ No|`x = 5` → cambiarlo requiere reasignar|
|`list`, `set`, `dict`|✅ Sí|Se puede modificar su contenido directamente|

### **3. Ejemplo de Inmutabilidad**

Los números y cadenas son **inmutables**.  
Si los “modificas”, en realidad Python crea un nuevo valor.

```python
nombre = "Lumin"
nombre = nombre + " App"
print(nombre)
```

```txt
Output:
Lumin App
```

Internamente, Python no cambió `"Lumin"`.  
Creó un **nuevo texto** `"Lumin App"` y reasignó el nombre `nombre`.


### **4. Ejemplo de Mutabilidad**

Las listas **sí son mutables**.  
Puedes cambiar sus elementos sin crear una nueva lista.

```python
numeros = [1, 2, 3]
numeros[0] = 100
print(numeros)
```

```txt
Output:
[100, 2, 3]
```

Aquí, **la lista original fue modificada** directamente.  
Esto puede ser útil, pero también peligroso si no lo controlas.

### **5. La Abstracción detrás de la Mutabilidad**

La mutabilidad es una forma de **abstraer el control del cambio**.

- Usamos **variables inmutables** cuando queremos **seguridad** (como `PI` o `nombre_usuario`).
    
- Usamos **estructuras mutables** cuando necesitamos **flexibilidad** (como listas o diccionarios).
""",
    pageNumber = 4
)

val SimpleDataStructuresPage = PageData(
    id = 8,
    content = """
Las **estructuras de datos** son una forma poderosa de **abstraer y organizar información**.  
En lugar de manejar cada valor individualmente, agrupamos varios datos en una sola unidad lógica.

Por ejemplo, una lista puede representar los **nombres de estudiantes**, un conjunto puede representar **valores únicos**, y una tupla puede agrupar **coordenadas**.

### **1. ¿Qué es una estructura de datos?**

Una **estructura de datos** define cómo se **almacenan y organizan los datos** en memoria.  
Python ofrece varias estructuras integradas que ya gestionan los detalles internos por nosotros.

|**Estructura**|**Descripción**|**Ejemplo**|
|---|---|---|
|`list`|Colección ordenada y mutable.|`[1, 2, 3]`|
|`tuple`|Colección ordenada e inmutable.|`(1, 2, 3)`|
|`set`|Conjunto de elementos únicos (sin orden).|`{1, 2, 3}`|
|`dict`|Colección de pares clave-valor.|`{"nombre": "Lumin", "edad": 20}`|

Estas estructuras son **abstracciones** porque no nos preocupamos por cómo Python gestiona la memoria o el orden — solo por **qué queremos almacenar**.

### **2. Ejemplo con Listas**

```python
frutas = ["manzana", "banana", "uva"]
print(frutas[0])
print(frutas[1])
```

```txt
Output:
manzana
banana
```

Las listas permiten acceder a cada elemento usando su **posición (índice)**, empezando en `0`.

### **3. Ejemplo con Tuplas**

```python
coordenada = (10, 20)
print("X:", coordenada[0])
print("Y:", coordenada[1])
```

```txt
Output:
X: 10
Y: 20
```

Una tupla se usa cuando los datos **no deben cambiar**.

### **4. Ejemplo con Conjuntos (Sets)**

```python
numeros = {1, 2, 2, 3, 3, 4}
print(numeros)
```

```txt
Output:
{1, 2, 3, 4}
```

Los conjuntos **eliminan duplicados automáticamente**, mostrando solo valores únicos.

### **5. Ejemplo con Diccionarios**

```python
persona = {"nombre": "Lumin", "edad": 20}
print(persona["nombre"])
print(persona["edad"])
```

```txt
Output:
Lumin
20
```

Los diccionarios permiten acceder a los datos **por su clave**, no por posición.

## **6. Niveles de Abstracción: del Dato al Objeto**

La **abstracción** no se detiene en los tipos de datos o estructuras.  
También se aplica al diseño de programas completos.  
Podemos pensar en distintos **niveles de abstracción**, desde lo más simple (valores) hasta lo más complejo (objetos y sistemas).

---

### **1. Niveles de Abstracción en Programación**

|**Nivel**|**Descripción**|**Ejemplo en Python**|
|---|---|---|
|**Datos**|Valores individuales, como números o texto.|`5`, `"Hola"`|
|**Estructuras**|Agrupan datos relacionados.|`[1, 2, 3]`, `{"nombre": "Lumin"}`|
|**Funciones**|Agrupan instrucciones que realizan una tarea.|`print()`, `len()`|
|**Objetos**|Combinan datos y comportamientos.|Clases como `Usuario`, `Coche`, etc.|

Cada nivel **oculta la complejidad del anterior**, haciendo el código más modular y fácil de mantener.

---

### **2. Ejemplo: Sin Abstracción**

```python
nombre = "Lumin"
edad = 20
print(nombre + " tiene " + str(edad) + " años.")
```

```txt
Output:
Lumin tiene 20 años.
```

El código funciona, pero mezcla datos y lógica directamente.  
Esto se vuelve difícil de mantener a medida que el programa crece.

---

### **3. Ejemplo: Con Abstracción mediante Función**

```python
def mostrar_informacion(nombre, edad):
    print(f"{nombre} tiene {edad} años.")

mostrar_informacion("Lumin", 20)
```

```txt
Output:
Lumin tiene 20 años.
```

Ahora, la lógica está **abstraída dentro de una función**,  
lo que hace que el código sea **reutilizable** y **más legible**.

---

### **4. Ejemplo: Abstracción con Objeto**

```python
class Persona:
    def __init__(self, nombre, edad):
        self.nombre = nombre
        self.edad = edad
    
    def presentar(self):
        print(f"{self.nombre} tiene {self.edad} años.")

usuario = Persona("Lumin", 20)
usuario.presentar()
```

```txt
Output:
Lumin tiene 20 años.
```

Aquí, la **clase** abstrae tanto los **datos** (`nombre`, `edad`)  
como el **comportamiento** (`presentar`), creando una unidad lógica coherente.

---

### **5. Conclusión del Tema**

En esta sección aprendiste que la **abstracción de datos**:

- Te permite manejar información sin preocuparte por los detalles internos.
    
- Es la base de las **estructuras**, **funciones** y **objetos** en Python.
    
- Es clave para escribir **código claro, escalable y mantenible**.
    

---

### **➡️ Próxima sección:**

> _“Interacción y Representación de Datos”_ — aprenderás cómo mostrar, recibir y formatear datos para comunicarte con el usuario.""",
    pageNumber = 5
)

val AbstractionLevelsPage = PageData(
    id = 9,
    content = """## **Niveles de Abstracción: del Dato al Objeto**

La **abstracción** no se detiene en los tipos de datos o estructuras.  
También se aplica al diseño de programas completos.  
Podemos pensar en distintos **niveles de abstracción**, desde lo más simple (valores) hasta lo más complejo (objetos y sistemas).
### **1. Niveles de Abstracción en Programación**

|**Nivel**|**Descripción**|**Ejemplo en Python**|
|---|---|---|
|**Datos**|Valores individuales, como números o texto.|`5`, `"Hola"`|
|**Estructuras**|Agrupan datos relacionados.|`[1, 2, 3]`, `{"nombre": "Lumin"}`|
|**Funciones**|Agrupan instrucciones que realizan una tarea.|`print()`, `len()`|
|**Objetos**|Combinan datos y comportamientos.|Clases como `Usuario`, `Coche`, etc.|

Cada nivel **oculta la complejidad del anterior**, haciendo el código más modular y fácil de mantener.

### **2. Ejemplo: Sin Abstracción**

```python
nombre = "Lumin"
edad = 20
print(nombre + " tiene " + str(edad) + " años.")
```

```txt
Output:
Lumin tiene 20 años.
```

El código funciona, pero mezcla datos y lógica directamente.  
Esto se vuelve difícil de mantener a medida que el programa crece.

### **3. Ejemplo: Con Abstracción mediante Función**

```python
def mostrar_informacion(nombre, edad):
    print(f"{nombre} tiene {edad} años.")

mostrar_informacion("Lumin", 20)
```

```txt
Output:
Lumin tiene 20 años.
```

Ahora, la lógica está **abstraída dentro de una función**,  
lo que hace que el código sea **reutilizable** y **más legible**.

### **4. Ejemplo: Abstracción con Objeto**

```python
class Persona:
    def __init__(self, nombre, edad):
        self.nombre = nombre
        self.edad = edad
    
    def presentar(self):
        print(f"{self.nombre} tiene {self.edad} años.")

usuario = Persona("Lumin", 20)
usuario.presentar()
```

```txt
Output:
Lumin tiene 20 años.
```

Aquí, la **clase** abstrae tanto los **datos** (`nombre`, `edad`)  
como el **comportamiento** (`presentar`), creando una unidad lógica coherente.

### **5. Conclusión del Tema**

En esta sección aprendiste que la **abstracción de datos**:

- Te permite manejar información sin preocuparte por los detalles internos.
    
- Es la base de las **estructuras**, **funciones** y **objetos** en Python.
    
- Es clave para escribir **código claro, escalable y mantenible**.""",
    pageNumber = 6
)

// Section id = 2

val CommunicationPage = PageData(
    id = 10,
    content = """Un programa no solo ejecuta instrucciones internas: también **interactúa con el usuario**.  
Esa interacción puede ser de dos tipos:

1. **Entrada de datos:** el usuario proporciona información al programa.
    
2. **Salida de datos:** el programa muestra resultados o mensajes al usuario.

La combinación de ambas crea una **conversación lógica** entre humano y máquina.

### **1. Entrada y salida: la base de la interacción**

Todo programa útil necesita comunicarse.  
En Python, esa comunicación se realiza principalmente con dos funciones:

|**Función**|**Propósito**|**Ejemplo**|
|---|---|---|
|`input()`|Recibir información del usuario.|`nombre = input("Tu nombre: ")`|
|`print()`|Mostrar información al usuario.|`print("Hola, Mundo")`|

Ambas son **abstracciones**: tú no ves cómo Python obtiene o muestra la información,  
solo defines **qué** quieres pedir o mostrar.

### **2. Ejemplo simple de interacción**

```python
nombre = input("¿Cómo te llamas? ")
print("¡Hola", nombre + "!")
```

```txt
Input:
¿Cómo te llamas? Lumin
Output:
¡Hola Lumin!
```

Aquí el programa **espera** que el usuario escriba algo,  
luego utiliza esa entrada para construir una respuesta personalizada.

### **3. Flujo lógico de la interacción**

1. El programa se **detiene** al llegar a una función `input()`.
    
2. Espera a que el usuario escriba algo y presione **Enter**.
    
3. Al recibir la información, continúa la ejecución normal y muestra el resultado con `print()`.

### **4. Ejemplo visual del flujo**

```python
nombre = input("Introduce tu nombre: ")
edad = input("Introduce tu edad: ")

print("Tu nombre es", nombre, "y tienes", edad, "años.")
```

```txt
Input:
Introduce tu nombre: Lumin
Introduce tu edad: 20

Output:
Tu nombre es Lumin y tienes 20 años.
```

Cada interacción con `input()` representa un **momento de pausa**,  
en el que el usuario participa activamente en el programa.
""",
    pageNumber = 1
)

val InputFunctionPage = PageData(
    id = 11,
    content = """La función `input()` se usa para **leer información desde el teclado**.  
Todo lo que el usuario escriba será **interpretado como texto (str)**.

### **1. Sintaxis**

```python
variable = input("Mensaje para el usuario: ")
```

El texto dentro de los paréntesis es **opcional**, pero sirve como **instrucción o guía**.

### **2. Ejemplo básico**

```python
nombre = input("Escribe tu nombre: ")
print("Bienvenido,", nombre)
```

```txt
Input:
Escribe tu nombre: Lumin
Output:
Bienvenido, Lumin
```

### **3. Todos los valores ingresados son texto**

```python
edad = input("Ingresa tu edad: ")
print(edad + 5)  # ❌ Error
```

Esto genera un error porque `"20"` es un texto, no un número.

### **4. Conversión de tipo (Casting)**

Para usar el valor como número, debemos convertirlo:

```python
edad = int(input("Ingresa tu edad: "))
print("El próximo año tendrás", edad + 1)
```

```txt
Input:
Ingresa tu edad: 20
Output:
El próximo año tendrás 21
```

### **5. Otros tipos posibles**

```python
precio = float(input("Precio del producto: "))
print("Precio con descuento:", precio * 0.9)
```

```txt
Input:
Precio del producto: 100.5
Output:
Precio con descuento: 90.45
```

""",
    pageNumber = 2
)

val PrintFunctionPage = PageData(
    id = 12,
    content = """La función `print()` se utiliza para **mostrar resultados, mensajes o variables** al usuario.  
Es la salida visual del programa.

### **1. Sintaxis**

```python
print(valor1, valor2, ..., valorN)
```

Cada argumento se separa por **comas**, y Python añade un espacio automático entre ellos.

### **2. Ejemplo básico**

```python
nombre = "Lumin"
edad = 20
print("Nombre:", nombre, "Edad:", edad)
```

```txt
Output:
Nombre: Lumin Edad: 20
```

### **3. Mostrar texto con formato**

```python
nombre = "Lumin"
print(f"Hola, {nombre}. ¡Bienvenido al curso!")
```

```txt
Output:
Hola, Lumin. ¡Bienvenido al curso!
```

El prefijo `f` indica una **f-string**, una forma moderna y legible de combinar texto con variables.

### **4. Controlar saltos de línea**

Por defecto, `print()` agrega un salto de línea al final.  
Puedes cambiarlo con el parámetro `end`.

```python
print("Hola", end=" ")
print("Lumin")
```

```txt
Output:
Hola Lumin
```
""",
    pageNumber = 3
)

val RepresentationOfDataPage = PageData(
    id = 13,
    content = """Los datos pueden representarse de muchas formas: texto, números, booleanos, etc.  
Python ofrece varias maneras de **dar formato** a esa salida.

### **1. Concatenación de texto**

```python
nombre = "Lumin"
curso = "Python"
print("Hola " + nombre + ", estás aprendiendo " + curso)
```

```txt
Output:
Hola Lumin, estás aprendiendo Python
```

### **2. Separación por comas**

```python
print("Hola", "Lumin", "aprendiendo", "Python")
```

```txt
Output:
Hola Lumin aprendiendo Python
```

### **3. Formateo con f-strings**

```python
nombre = "Lumin"
edad = 20
print(f"{nombre} tiene {edad} años.")
```

```txt
Output:
Lumin tiene 20 años.
```

### **4. Formateo con `format()`**

```python
nombre = "Lumin"
edad = 20
print("El usuario {} tiene {} años.".format(nombre, edad))
```

```txt
Output:
El usuario Lumin tiene 20 años.
```

### **5. Formato numérico**

```python
pi = 3.14159265
print(f"Pi con 2 decimales: {pi:.2f}")
```

```txt
Output:
Pi con 2 decimales: 3.14
```
""",
    pageNumber = 4
)

val ConversionTypesPage = PageData(
    id = 14,
    content = """A veces necesitamos **transformar** o **manipular** los datos ingresados para mostrar o procesar información correctamente.

### **1. Conversión entre tipos**

|**Conversión**|**Descripción**|**Ejemplo**|
|---|---|---|
|`int(x)`|Convierte a número entero.|`int("25") → 25`|
|`float(x)`|Convierte a número decimal.|`float("3.14") → 3.14`|
|`str(x)`|Convierte a texto.|`str(100) → "100"`|
|`bool(x)`|Convierte a valor lógico.|`bool(0) → False`|

### **2. Manipulación de texto**

```python
nombre = "lumin"
print(nombre.upper())   # Mayúsculas
print(nombre.capitalize())  # Primera letra mayúscula
print(nombre.replace("l", "L"))  # Reemplazar letras
```

```txt
Output:
LUMIN
Lumin
Lumin
```

### **3. Unir y dividir texto**

```python
frase = "Aprender Python es divertido"
palabras = frase.split()
print(palabras)
print(" ".join(palabras))
```

```txt
Output:
['Aprender', 'Python', 'es', 'divertido']
Aprender Python es divertido
```
""",
    pageNumber = 5
)

// Section id = 3

val IntroductionToListsPage = PageData(
    id = 15,
    content = """Una **lista** es una estructura de datos que permite **almacenar múltiples valores** bajo un solo nombre.  
Los elementos de una lista están **ordenados** y **pueden modificarse**.

En la vida real, una lista es como una **colección de objetos en una caja ordenada**.  
Cada objeto tiene una **posición (índice)** y puede ser accedido fácilmente.

### **1. Crear una lista**

```python
frutas = ["manzana", "banana", "naranja"]
print(frutas)
```

```txt
Output:
['manzana', 'banana', 'naranja']
```

### **2. Características principales**

|Propiedad|Descripción|
|---|---|
|Ordenada|Los elementos mantienen su posición.|
|Mutable|Se pueden cambiar, agregar o eliminar elementos.|
|Heterogénea|Puede contener distintos tipos de datos.|
|Indexada|Cada elemento tiene una posición (índice).|

### **3. Ejemplo con distintos tipos**

```python
datos = ["Lumin", 25, True, 3.14]
print(datos)
```

```txt
Output:
['Lumin', 25, True, 3.14]
```

""",
    pageNumber = 1
)

val ListElementCreationAndAccessPage = PageData(
    id = 16,
    content = """Las listas se comportan como **colecciones indexadas**.  
El primer elemento tiene índice `0`.

### **1. Acceder a elementos**

```python
colores = ["rojo", "verde", "azul"]
print(colores[0])  # Primer elemento
print(colores[2])  # Tercer elemento
```

```txt
Output:
rojo
azul
```

### **2. Índices negativos**

Puedes acceder desde el final usando índices negativos:

```python
print(colores[-1])  # Último elemento
print(colores[-2])  # Penúltimo elemento
```

```txt
Output:
azul
verde
```

### **3. Rango de elementos (slicing)**

```python
numeros = [10, 20, 30, 40, 50]
print(numeros[1:4])
```

```txt
Output:
[20, 30, 40]
```

### **4. Longitud de una lista**

```python
print(len(numeros))
```

```txt
Output:
5
```


""",
    pageNumber = 2
)

val ModifyingAndMethodsPage = PageData(
    id = 17,
    content = """
Las listas son **mutables**, lo que significa que puedes cambiar sus valores o su tamaño.

### **1. Cambiar un elemento**

```python
nombres = ["Ana", "Luis", "Mia"]
nombres[1] = "Carlos"
print(nombres)
```

```txt
Output:
['Ana', 'Carlos', 'Mia']
```

### **2. Agregar elementos**

```python
nombres.append("Sofía")       # Agrega al final
nombres.insert(1, "Pedro")    # Inserta en posición específica
print(nombres)
```

```txt
Output:
['Ana', 'Pedro', 'Carlos', 'Mia', 'Sofía']
```

### **3. Eliminar elementos**

```python
nombres.remove("Mia")  # Elimina por valor
nombres.pop(0)         # Elimina por índice
print(nombres)
```

```txt
Output:
['Pedro', 'Carlos', 'Sofía']
```

### **4. Vaciar o borrar lista**

```python
nombres.clear()
print(nombres)
```

```txt
Output:
[]
```

""",
    pageNumber = 3
)

val TraverseAndOperationsPage = PageData(
    id = 18,
    content = """
Las listas pueden **recorrerse** elemento por elemento, lo que permite realizar operaciones sobre cada valor.

### **1. Recorrido con `for`**

```python
frutas = ["manzana", "pera", "uva"]
for fruta in frutas:
    print("Me gusta la", fruta)
```

```txt
Output:
Me gusta la manzana
Me gusta la pera
Me gusta la uva
```

### **2. Recorrido por índice**

```python
for i in range(len(frutas)):
    print(i, frutas[i])
```

```txt
Output:
0 manzana
1 pera
2 uva
```

### **3. Operaciones comunes**

|Operación|Ejemplo|Resultado|
|---|---|---|
|Concatenar|`[1, 2] + [3, 4]`|`[1, 2, 3, 4]`|
|Repetir|`[0] * 3`|`[0, 0, 0]`|
|Buscar valor|`"pera" in frutas`|`True`|
|Contar|`frutas.count("uva")`|`1`|


""",
    pageNumber = 4
)

val NestedListsPage = PageData(
    id = 19,
    content = """
Una lista puede contener **otras listas**, creando estructuras más complejas.  
Esto permite representar tablas, matrices o conjuntos de datos relacionados.

### **1. Ejemplo de lista anidada**

```python
matriz = [
    [1, 2, 3],
    [4, 5, 6],
    [7, 8, 9]
]
print(matriz[1][2])
```

```txt
Output:
6
```

### **2. Recorrer una lista anidada**

```python
for fila in matriz:
    for elemento in fila:
        print(elemento, end=" ")
    print()
```

```txt
Output:
1 2 3 
4 5 6 
7 8 9
```

### **3. Aplicación: datos organizados**

```python
estudiantes = [
    ["Ana", 18],
    ["Luis", 20],
    ["Marta", 19]
]
print("Nombre:", estudiantes[0][0], "Edad:", estudiantes[0][1])
```

```txt
Output:
Nombre: Ana Edad: 18
```

Las listas anidadas permiten abstraer estructuras **bidimensionales**,  
como si fueran **tablas en memoria**.


""",
    pageNumber = 5
)

val ListComprehensionPage = PageData(
    id = 20,
    content = """
Una **list comprehension** es una forma corta y elegante de crear listas.  
Permite generar listas en una sola línea.

### **1. Sintaxis básica**

```python
[expresión for elemento in iterable]
```

### **2. Ejemplo básico**

```python
numeros = [x for x in range(5)]
print(numeros)
```

```txt
Output:
[0, 1, 2, 3, 4]
```

### **3. Ejemplo con condición**

```python
pares = [x for x in range(10) if x % 2 == 0]
print(pares)
```

```txt
Output:
[0, 2, 4, 6, 8]
```

### **4. Ejemplo práctico**

```python
nombres = ["ana", "luis", "marta"]
mayus = [n.upper() for n in nombres]
print(mayus)
```

```txt
Output:
['ANA', 'LUIS', 'MARTA']
```

""",
    pageNumber = 6
)

// Section id = 4

val TupleIntroductionPage = PageData(
    id = 21,
    content = """
Una **tupla** es una colección **ordenada e inmutable** de elementos.  
Es decir, puedes acceder a sus valores, pero **no puedes cambiarlos** después de su creación.

Se define usando **paréntesis `( )`** en lugar de corchetes `[ ]`.

### **1. Ejemplo básico**

```python
coordenadas = (10, 20)
print(coordenadas)
```

```txt
Output:
(10, 20)
```

### **2. Diferencias entre lista y tupla**

|Característica|Lista|Tupla|
|---|---|---|
|Sintaxis|`[ ]`|`( )`|
|Mutable|✅ Sí|❌ No|
|Velocidad|Más lenta|Más rápida|
|Uso típico|Datos cambiantes|Datos fijos|

Las tuplas permiten **mayor seguridad** al evitar modificaciones accidentales.



""",
    pageNumber = 1
)

val TupleElementCreationAndAccessPage = PageData(
    id = 22,
    content = """
Las tuplas, al igual que las listas, son **indexadas**.  
Puedes acceder a cada elemento mediante su posición.

### **1. Crear tuplas**

```python
colores = ("rojo", "verde", "azul")
print(colores)
```

```txt
Output:
('rojo', 'verde', 'azul')
```

### **2. Tupla con un solo elemento**

Para crear una tupla con un solo valor, debes usar una **coma final**:

```python
tupla = (5,)
print(type(tupla))
```

```txt
Output:
<class 'tuple'>
```

Sin la coma, Python interpretaría el valor como un número común.

### **3. Acceso a elementos**

```python
print(colores[0])
print(colores[-1])
```

```txt
Output:
rojo
azul
```

### **4. Subtuplas (slicing)**

```python
print(colores[0:2])
```

```txt
Output:
('rojo', 'verde')
```


""",
    pageNumber = 2
)

val InmutabilityPage = PageData(
    id = 23,
    content = """
Una vez creada una tupla, **no se puede modificar**.  
Esto garantiza que los datos se mantengan **seguros e inalterables** durante la ejecución.

### **1. Intentar modificar una tupla**

```python
numeros = (1, 2, 3)
numeros[0] = 10
```

```txt
Output:
TypeError: 'tuple' object does not support item assignment
```

### **2. Ventajas de usar tuplas**

|Ventaja|Explicación|
|---|---|
|**Seguridad**|No se pueden cambiar accidentalmente.|
|**Rendimiento**|Se almacenan de forma más eficiente.|
|**Uso en estructuras fijas**|Como coordenadas, días de la semana, etc.|

### **3. Ejemplo práctico**

```python
dias = ("Lunes", "Martes", "Miércoles", "Jueves", "Viernes")
print("Los días laborales son:", dias)
```

```txt
Output:
Los días laborales son: ('Lunes', 'Martes', 'Miércoles', 'Jueves', 'Viernes')
```

""",
    pageNumber = 3
)

val UnpackingAndOperationsPage = PageData(
    id = 24,
    content = """
El **desempaquetado** permite asignar cada valor de una tupla a una variable separada.

### **1. Desempaquetar una tupla**

```python
persona = ("Lumin", 20, "Estudiante")
nombre, edad, ocupacion = persona
print(nombre)
print(edad)
print(ocupacion)
```

```txt
Output:
Lumin
20
Estudiante
```

### **2. Operaciones comunes con tuplas**

|Operación|Ejemplo|Resultado|
|---|---|---|
|Concatenar|`(1, 2) + (3, 4)`|`(1, 2, 3, 4)`|
|Repetir|`("A",) * 3`|`('A', 'A', 'A')`|
|Pertenencia|`"rojo" in colores`|`True`|
|Longitud|`len(colores)`|`3`|

### **3. Conversión entre lista y tupla**

Puedes transformar una tupla en lista (y viceversa) para modificarla si es necesario.

```python
tupla = (1, 2, 3)
lista = list(tupla)
lista.append(4)
tupla = tuple(lista)
print(tupla)
```

```txt
Output:
(1, 2, 3, 4)
```

---
""",
    pageNumber = 4
)

// Section id = 5

val SetIntroductionPage = PageData(
    id = 25,
    content = """
Un **conjunto** es una colección que **no mantiene orden** y **no admite duplicados**.  
Se define con **llaves `{ }`** o usando la función `set()`.

### **1. Ejemplo básico**

```python
frutas = {"manzana", "pera", "uva", "manzana"}
print(frutas)
```

```txt
Output:
{'manzana', 'pera', 'uva'}
```

Aunque escribimos `"manzana"` dos veces, el conjunto solo la mantiene una vez.  
Esto demuestra que los **sets eliminan duplicados automáticamente**.

### **2. ¿Para qué sirve un conjunto?**

- Para **almacenar valores únicos**.
    
- Para **comparar grupos de datos** (intersección, unión, diferencia).
    
- Para **buscar rápidamente** si un valor existe.""",
    pageNumber = 1
)

val SetCreationAndPropertiesPage = PageData(
    id = 26,
    content = """## **Creación y Propiedades de los Sets**

Los conjuntos son similares a las listas o tuplas,  
pero con reglas especiales que los hacen únicos.

### **1. Crear conjuntos**

```python
numeros = {1, 2, 3, 4}
print(numeros)
```

```txt
Output:
{1, 2, 3, 4}
```

También puedes crearlos desde una lista:

```python
numeros = set([1, 2, 2, 3])
print(numeros)
```

```txt
Output:
{1, 2, 3}
```

### **2. No hay orden ni duplicados**

```python
datos = {"a", "b", "c", "a"}
print(datos)
```

```txt
Output:
{'a', 'b', 'c'}
```

### **3. Tipos de datos válidos**

Los elementos de un set deben ser **inmutables**,  
por eso no puedes incluir listas ni otros sets dentro de un set.

```python
valores = {1, 2, (3, 4)}   # ✅ Tupla sí es válida
```

```python
valores = {1, [2, 3]}      # ❌ Error
```

```txt
Output:
TypeError: unhashable type: 'list'
```


""",
    pageNumber = 2
)

val SetOperationsPage = PageData(
    id = 27,
    content = """## **Operaciones entre Conjuntos**

Python permite realizar **operaciones matemáticas** con conjuntos,  
lo que los hace ideales para comparar datos.

### **1. Unión (combine elementos)**

```python
a = {1, 2, 3}
b = {3, 4, 5}
print(a | b)
```

```txt
Output:
{1, 2, 3, 4, 5}
```

### **2. Intersección (elementos comunes)**

```python
print(a & b)
```

```txt
Output:
{3}
```

### **3. Diferencia (solo en el primer conjunto)**

```python
print(a - b)
```

```txt
Output:
{1, 2}
```

### **4. Diferencia simétrica (no comunes)**

```python
print(a ^ b)
```

```txt
Output:
{1, 2, 4, 5}
```

""",
    pageNumber = 3
)

val SetTraversePage = PageData(
    id = 28,
    content = """## **Métodos Útiles y Recorridos**

Los conjuntos tienen varios métodos integrados que permiten manipular sus elementos fácilmente.

### **1. Agregar elementos**

```python
colores = {"rojo", "verde"}
colores.add("azul")
print(colores)
```

```txt
Output:
{'rojo', 'verde', 'azul'}
```

### **2. Eliminar elementos**

```python
colores.remove("verde")  # Error si no existe
colores.discard("negro") # No lanza error si no existe
print(colores)
```

```txt
Output:
{'rojo', 'azul'}
```

### **3. Recorrer un conjunto**

```python
for color in colores:
    print("Color:", color)
```

```txt
Output:
Color: rojo  
Color: azul
```

### **4. Vaciar el conjunto**

```python
colores.clear()
print(colores)
```

```txt
Output:
set()
```


""",
    pageNumber = 4
)

// Section id = 6

val DictIntroductionPage = PageData(
    id = 29,
    content = """
Un **diccionario** es una colección de elementos **no ordenados**,  
donde cada elemento tiene una **clave (key)** y un **valor (value)**.

A diferencia de las listas (que usan índices numéricos),  
los diccionarios usan **claves personalizadas** para acceder a los datos.

### **1. Ejemplo básico**

```python
persona = {
    "nombre": "Lumin",
    "edad": 20,
    "ocupacion": "Estudiante"
}
print(persona)
```

```txt
Output:
{'nombre': 'Lumin', 'edad': 20, 'ocupacion': 'Estudiante'}
```

### **2. Estructura general**

|Elemento|Descripción|
|---|---|
|**Clave (key)**|Identificador único.|
|**Valor (value)**|Dato asociado a la clave.|
|**Par clave–valor**|Cada relación dentro del diccionario.|

Ejemplo: `"nombre": "Lumin"`  
👉 clave = `"nombre"`, valor = `"Lumin"`



""",
    pageNumber = 1
)

val DictElementCreationAndAccessPage = PageData(
    id = 30,
    content = """
Puedes crear un diccionario con llaves `{}` o con la función `dict()`.

### **1. Crear un diccionario**

```python
producto = {
    "nombre": "Laptop",
    "precio": 2500,
    "stock": 10
}
```

### **2. Acceder a un valor**

```python
print(producto["nombre"])
print(producto["precio"])
```

```txt
Output:
Laptop
2500
```

### **3. Acceso seguro con `.get()`**

Si intentas acceder a una clave que no existe, Python generará un error.  
Para evitarlo, usa el método `get()`:

```python
print(producto.get("marca", "No especificado"))
```

```txt
Output:
No especificado
```

### **4. Ver todas las claves y valores**

```python
print(producto.keys())
print(producto.values())
```

```txt
Output:
dict_keys(['nombre', 'precio', 'stock'])
dict_values(['Laptop', 2500, 10])
```


""",
    pageNumber = 2
)

val ModifyingAndDeletePage = PageData(
    id = 31,
    content = """
Los diccionarios son **mutables**, lo que significa que sus valores pueden cambiar.

### **1. Modificar un valor**

```python
producto["precio"] = 2000
print(producto)
```

```txt
Output:
{'nombre': 'Laptop', 'precio': 2000, 'stock': 10}
```

### **2. Agregar un nuevo par clave–valor**

```python
producto["marca"] = "Lenovo"
print(producto)
```

```txt
Output:
{'nombre': 'Laptop', 'precio': 2000, 'stock': 10, 'marca': 'Lenovo'}
```

### **3. Eliminar un elemento**

```python
del producto["stock"]
print(producto)
```

```txt
Output:
{'nombre': 'Laptop', 'precio': 2000, 'marca': 'Lenovo'}
```

### **4. Método `.pop()`**

Elimina una clave y devuelve su valor:

```python
precio = producto.pop("precio")
print(precio)
```

```txt
Output:
2000
```


""",
    pageNumber = 3
)

val DictTraversePage = PageData(
    id = 32,
    content = """
Puedes recorrer un diccionario para acceder a sus claves, valores o ambos.

### **1. Recorrer solo claves**

```python
for clave in producto:
    print(clave)
```

```txt
Output:
nombre
marca
```

### **2. Recorrer claves y valores**

```python
for clave, valor in producto.items():
    print(clave, "→", valor)
```

```txt
Output:
nombre → Laptop  
marca → Lenovo
```

### **3. Métodos comunes**

|Método|Descripción|Ejemplo|
|---|---|---|
|`.keys()`|Devuelve todas las claves.|`producto.keys()`|
|`.values()`|Devuelve todos los valores.|`producto.values()`|
|`.items()`|Devuelve pares (clave, valor).|`producto.items()`|
|`.update()`|Agrega o actualiza elementos.|`producto.update({"stock": 15})`|
|`.clear()`|Vacía el diccionario.|`producto.clear()`|

### **4. Comprobación de existencia**

```python
if "precio" in producto:
    print("La clave 'precio' existe.")
```

```txt
Output:
La clave 'precio' existe.
```

""",
    pageNumber = 4
)

val NestedDictsPage = PageData(
    id = 33,
    content = """
Un diccionario puede contener **otros diccionarios** dentro, lo que permite crear estructuras complejas.

### **1. Ejemplo de diccionario anidado**

```python
usuarios = {
    "user1": {"nombre": "Ana", "edad": 19},
    "user2": {"nombre": "Luis", "edad": 22}
}
print(usuarios["user2"]["nombre"])
```

```txt
Output:
Luis
```

### **2. Recorrido de diccionarios anidados**

```python
for clave, info in usuarios.items():
    print("ID:", clave)
    print("Nombre:", info["nombre"])
    print("Edad:", info["edad"])
```

```txt
Output:
ID: user1  
Nombre: Ana  
Edad: 19  
ID: user2  
Nombre: Luis  
Edad: 22
```

### **3. Estructuras jerárquicas**

Este tipo de estructuras es muy común en archivos **JSON**,  
donde los datos se organizan en pares clave–valor anidados.


""",
    pageNumber = 5
)

// Section id = 7

val ConditionalIntroductionPage = PageData(
    id = 34,
    content = """
Un diccionario puede contener **otros diccionarios** dentro, lo que permite crear estructuras complejas.

### **1. Ejemplo de diccionario anidado**

```python
usuarios = {
    "user1": {"nombre": "Ana", "edad": 19},
    "user2": {"nombre": "Luis", "edad": 22}
}
print(usuarios["user2"]["nombre"])
```

```txt
Output:
Luis
```

### **2. Recorrido de diccionarios anidados**

```python
for clave, info in usuarios.items():
    print("ID:", clave)
    print("Nombre:", info["nombre"])
    print("Edad:", info["edad"])
```

```txt
Output:
ID: user1  
Nombre: Ana  
Edad: 19  
ID: user2  
Nombre: Luis  
Edad: 22
```

### **3. Estructuras jerárquicas**

Este tipo de estructuras es muy común en archivos **JSON**,  
donde los datos se organizan en pares clave–valor anidados.


""",
    pageNumber = 1
)

val IfStructurePage = PageData(
    id = 35,
    content = """
La instrucción `if` ejecuta un bloque de código **solo si** la condición es verdadera.  
Si no lo es, el bloque se salta.

### **1. Sintaxis básica**

```python
if condicion:
    # bloque de código
```

El bloque dentro del `if` debe estar **indentado** (con tabulación o 4 espacios).

### **2. Ejemplo simple**

```python
edad = 18

if edad >= 18:
    print("Eres mayor de edad.")
```

```txt
Output:
Eres mayor de edad.
```

Si la condición no se cumple, no ocurre nada.


""",
    pageNumber = 2
)

val IfElseStructurePage = PageData(
    id = 36,
    content = """
La estructura `if–else` permite ejecutar **una acción alternativa** cuando la condición no se cumple.

### **1. Sintaxis**

```python
if condicion:
    # bloque si es verdadero
else:
    # bloque si es falso
```

### **2. Ejemplo**

```python
numero = 7

if numero % 2 == 0:
    print("El número es par.")
else:
    print("El número es impar.")
```

```txt
Output:
El número es impar.
```

Python evalúa la condición y ejecuta solo **uno** de los dos bloques.


""",
    pageNumber = 3
)

val IfElifStructurePage = PageData(
    id = 37,
    content = """
Cuando hay **más de dos opciones posibles**, se usa `elif` (abreviación de “else if”).

### **1. Sintaxis general**

```python
if condicion1:
    # bloque 1
elif condicion2:
    # bloque 2
else:
    # bloque 3
```

### **2. Ejemplo**

```python
nota = 85

if nota >= 90:
    print("Excelente")
elif nota >= 70:
    print("Aprobado")
else:
    print("Reprobado")
```

```txt
Output:
Aprobado
```

Python evalúa las condiciones **en orden** y ejecuta la primera que sea verdadera.


""",
    pageNumber = 4
)

val OperatorsPage = PageData(
    id = 38,
    content = """
Los operadores permiten **construir condiciones más complejas**.

### **1. Operadores relacionales**

|Operador|Significado|Ejemplo|Resultado|
|---|---|---|---|
|`==`|Igual a|`5 == 5`|`True`|
|`!=`|Diferente de|`5 != 3`|`True`|
|`>`|Mayor que|`8 > 6`|`True`|
|`<`|Menor que|`3 < 7`|`True`|
|`>=`|Mayor o igual que|`5 >= 5`|`True`|
|`<=`|Menor o igual que|`2 <= 3`|`True`|

### **2. Operadores lógicos**

|Operador|Descripción|Ejemplo|Resultado|
|---|---|---|---|
|`and`|Verdadero si ambas condiciones son verdaderas.|`(x > 0) and (x < 10)`|`True`|
|`or`|Verdadero si al menos una condición es verdadera.|`(x < 0) or (x > 100)`|`False`|
|`not`|Invierte el valor lógico.|`not(x > 0)`|`False`|

### **3. Ejemplo combinado**

```python
edad = 25
pais = "Perú"

if edad >= 18 and pais == "Perú":
    print("Puedes votar.")
```

```txt
Output:
Puedes votar.
```


""",
    pageNumber = 5
)

val NestedConditionalsPage = PageData(
    id = 39,
    content = """
Un **condicional anidado** es un `if` dentro de otro `if`.  
Se usa cuando las decisiones dependen de varios niveles de evaluación.

### **1. Ejemplo**

```python
usuario = "Lumin"
clave = "1234"

if usuario == "Lumin":
    if clave == "1234":
        print("Acceso concedido.")
    else:
        print("Contraseña incorrecta.")
else:
    print("Usuario no encontrado.")
```

```txt
Output:
Acceso concedido.
```

Cada `if` controla una condición distinta, y ambos deben cumplirse  
para llegar al mensaje final.

### **2. Evitar anidamientos excesivos**

Demasiados condicionales anidados pueden volver el código difícil de leer.  
En esos casos, se recomienda usar **lógica combinada** con `and` / `or`.


""",
    pageNumber = 6
)

val SimplifiedConditionalsPage = PageData(
    id = 40,
    content = """Cuando solo hay **una acción corta** según una condición,  
se puede usar una **expresión condicional en una sola línea**.

### **1. Sintaxis**

```python
valor_si_verdadero if condicion else valor_si_falso
```

### **2. Ejemplo**

```python
edad = 17
mensaje = "Mayor de edad" if edad >= 18 else "Menor de edad"
print(mensaje)
```

```txt
Output:
Menor de edad
```

### **3. Ventaja**

Estas expresiones hacen que el código sea **más legible y compacto**  
cuando se manejan decisiones simples.
""",
    pageNumber = 7
)

// Section id = 8

val LoopIntroductionPage = PageData(
    id = 41,
    content = """Cuando solo hay **una acción corta** según una condición,  
se puede usar una **expresión condicional en una sola línea**.

### **1. Sintaxis**

```python
valor_si_verdadero if condicion else valor_si_falso
```

### **2. Ejemplo**

```python
edad = 17
mensaje = "Mayor de edad" if edad >= 18 else "Menor de edad"
print(mensaje)
```

```txt
Output:
Menor de edad
```

### **3. Ventaja**

Estas expresiones hacen que el código sea **más legible y compacto**  
cuando se manejan decisiones simples.
""",
    pageNumber = 1
)

val WhileLoopPage = PageData(
    id = 42,
    content = """El bucle `while` repite un bloque de código **mientras la condición sea verdadera**.  
        Cuando la condición se vuelve falsa, el ciclo termina.

        ### **1. Sintaxis**

        ```python
        while condicion:
            # bloque de código
        ```

        ### **2. Ejemplo**

        ```python
        contador = 1
        while contador <= 5:
            print("Contador:", contador)
            contador += 1
        ```

        ```txt
        Output:
        Contador: 1  
        Contador: 2  
        Contador: 3  
        Contador: 4  
        Contador: 5
        ```

        El ciclo se detiene cuando la condición `contador <= 5` deja de cumplirse.

        ### **3. Cuidado con los bucles infinitos**

        Si la condición nunca se vuelve falsa, el programa **nunca termina**.

        ```python
        # ❌ Ejemplo peligroso
        while True:
            print("Esto no se detendrá nunca")
        ```

        Para evitarlo, asegúrate siempre de **actualizar las variables de control** dentro del ciclo.



    """.trimIndent(),
    pageNumber = 2
)

val ForLoopPage = PageData(
    id = 43,
    content = """
El bucle `for` recorre automáticamente una **secuencia de elementos**,  
como una lista, cadena o rango de números.

### **1. Sintaxis**

```python
for variable in secuencia:
    # bloque de código
```

### **2. Ejemplo con lista**

```python
frutas = ["manzana", "pera", "uva"]
for fruta in frutas:
    print("Fruta:", fruta)
```

```txt
Output:
Fruta: manzana  
Fruta: pera  
Fruta: uva
```

### **3. Ejemplo con texto**

```python
for letra in "Lumin":
    print(letra)
```

```txt
Output:
L  
u  
m  
i  
n
```

El bucle recorre cada carácter de la cadena uno por uno.


""",
    pageNumber = 3
)

val RangeFunctionPage = PageData(
    id = 44,
    content = """
`range()` genera una secuencia de números enteros,  
ideal para controlar el número de repeticiones en un `for`.

### **1. Sintaxis general**

```python
range(inicio, fin, paso)
```

- `inicio` → valor inicial (por defecto 0)
    
- `fin` → valor donde termina (no incluido)
    
- `paso` → incremento (por defecto 1)
    

### **2. Ejemplo básico**

```python
for i in range(5):
    print(i)
```

```txt
Output:
0  
1  
2  
3  
4
```

### **3. Ejemplo con inicio y paso**

```python
for i in range(2, 10, 2):
    print(i)
```

```txt
Output:
2  
4  
6  
8
```


""",
    pageNumber = 4
)

val BreakAndContinuePage = PageData(
    id = 45,
    content = """
Estas instrucciones permiten **controlar el comportamiento** de un bucle desde dentro.

### **1. `break`: terminar el ciclo antes de tiempo**

```python
for numero in range(10):
    if numero == 5:
        break
    print(numero)
```

```txt
Output:
0  
1  
2  
3  
4
```

Cuando `numero == 5`, el bucle se detiene completamente.

### **2. `continue`: saltar a la siguiente iteración**

```python
for numero in range(6):
    if numero == 3:
        continue
    print(numero)
```

```txt
Output:
0  
1  
2  
4  
5
```

El número `3` se salta, pero el bucle continúa con el siguiente valor.


""",
    pageNumber = 5
)

val NestedLoopsPage = PageData(
    id = 46,
    content = """
Un bucle puede contener **otro bucle** dentro.  
Esto se usa cuando es necesario recorrer estructuras **bidimensionales** como listas de listas.

### **1. Ejemplo con bucles anidados**

```python
matriz = [
    [1, 2, 3],
    [4, 5, 6]
]

for fila in matriz:
    for elemento in fila:
        print(elemento, end=" ")
    print()
```

```txt
Output:
1 2 3  
4 5 6
```

El bucle exterior recorre las filas y el interior los elementos de cada fila.

### **2. Consideraciones**

- Los bucles anidados aumentan la complejidad del programa.
    
- Es recomendable usarlos solo cuando sea necesario.
    
- Se pueden combinar `for` y `while` si la lógica lo requiere.



""",
    pageNumber = 6
)

val DiffsAndGoodPracticesPage = PageData(
    id = 47,
    content = """
### **1. Comparación entre `for` y `while`**

| Característica           | `for`                              | `while`                         |
| ------------------------ | ---------------------------------- | ------------------------------- |
| Control                  | Recorre una secuencia predefinida. | Depende de una condición.       |
| Ideal para               | Iteraciones conocidas.             | Repeticiones indefinidas.       |
| Riesgo de bucle infinito | Bajo.                              | Alto si la condición no cambia. |

### **2. Recomendaciones de uso**

- Usa `for` cuando sepas **cuántas veces** necesitas repetir.
    
- Usa `while` cuando la repetición dependa de **una condición variable**.
    
- Evita bucles con lógica demasiado compleja dentro.
    
- Controla siempre las **condiciones de salida**.
    
- Puedes usar `break` para detener bucles y `continue` para saltar pasos.
    

### **3. Ejemplo de comparación directa**

```python
# Con for
for i in range(5):
    print("Repetición", i)

# Con while
i = 0
while i < 5:
    print("Repetición", i)
    i += 1
```

```txt
Output:
Repetición 0  
Repetición 1  
Repetición 2  
Repetición 3  
Repetición 4
```

Ambos logran el mismo resultado, pero con diferente enfoque lógico.
""",
    pageNumber = 7
)

// Section id = 9

val FunctionsIntroductionPage = PageData(
    id = 48,
    content = """
Un programa puede tener muchas instrucciones repetidas.  
Las **funciones** sirven para **agrupar esas instrucciones** en una sola unidad lógica con un nombre descriptivo.

Así, en lugar de repetir el mismo bloque de código varias veces,  
solo **llamas** a la función cuando la necesitas.

### **1. Ventajas de las funciones**

|Ventaja|Descripción|
|---|---|
|**Reutilización**|Escribes una vez y usas muchas veces.|
|**Organización**|El código se divide en partes lógicas.|
|**Mantenimiento**|Más fácil de leer, probar y modificar.|
|**Modularidad**|Cada función cumple una tarea específica.|

### **2. Ejemplo comparativo**

```python
# Sin funciones
print("Hola, Lumin")
print("Hola, Ana")
print("Hola, Luis")

# Con función
def saludar(nombre):
    print("Hola,", nombre)

saludar("Lumin")
saludar("Ana")
saludar("Luis")
```

```txt
Output:
Hola, Lumin  
Hola, Ana  
Hola, Luis
```

El segundo ejemplo es más **limpio y reutilizable**.

""",
    pageNumber = 1
)

val FunctionExecutionPage = PageData(
    id = 49,
    content = """
Para crear una función, se usa la palabra clave **`def`**, seguida del **nombre** y los **parámetros** entre paréntesis.

### **1. Sintaxis general**

```python
def nombre_funcion(parametros):
    # bloque de instrucciones
```

### **2. Ejemplo básico**

```python
def saludar():
    print("¡Bienvenido al curso de Python!")
```

```python
saludar()
```

```txt
Output:
¡Bienvenido al curso de Python!
```

Una función debe **definirse antes de ser llamada**,  
ya que Python ejecuta el código **de arriba hacia abajo**.

### **3. Funciones con y sin parámetros**

```python
def mostrar_mensaje():
    print("Función sin parámetros")

def mostrar_nombre(nombre):
    print("Hola,", nombre)
```

Ambas son funciones válidas, pero la segunda espera recibir un valor.
""",
    pageNumber = 2
)

val ArgumentsAndParametersPage = PageData(
    id = 50,
    content = """
Los **parámetros** son variables dentro de la definición de una función.  
Los **argumentos** son los valores que se pasan al llamarla.

### **1. Ejemplo básico**

```python
def sumar(a, b):
    print("Resultado:", a + b)

sumar(5, 3)
```

```txt
Output:
Resultado: 8
```

- `a` y `b` → parámetros
    
- `5` y `3` → argumentos
    

### **2. Argumentos por posición**

Los valores se asignan en el orden en que aparecen.

```python
def resta(x, y):
    print(x - y)

resta(10, 4)
```

```txt
Output:
6
```

### **3. Argumentos con nombre**

Puedes especificar los nombres de los parámetros al llamar la función.

```python
def presentar(nombre, edad):
    print(nombre, "tiene", edad, "años")

presentar(edad=20, nombre="Lumin")
```

```txt
Output:
Lumin tiene 20 años
```

### **4. Parámetros con valores por defecto**

```python
def saludar(nombre="visitante"):
    print("Hola,", nombre)

saludar()
saludar("Lumin")
```

```txt
Output:
Hola, visitante  
Hola, Lumin
```
""",
    pageNumber = 3
)

val ReturnValuesPage = PageData(
    id = 51,
    content = """
Una función puede **devolver un resultado** usando la palabra clave `return`.  
Esto permite **guardar el valor** en una variable o usarlo en cálculos.

### **1. Ejemplo con retorno**

```python
def sumar(a, b):
    return a + b

resultado = sumar(10, 5)
print("La suma es:", resultado)
```

```txt
Output:
La suma es: 15
```

### **2. Diferencia entre `print` y `return`**

- `print()` → muestra un valor en pantalla.
    
- `return` → entrega un valor al programa para usarlo después.
    

```python
def doble(n):
    return n * 2

print(doble(4))
```

```txt
Output:
8
```

### **3. Funciones sin retorno**

Si no usas `return`, la función devuelve `None` por defecto.

```python
def nada():
    pass

print(nada())
```

```txt
Output:
None
```


""",
    pageNumber = 4
)

val ScopePage = PageData(
    id = 52,
    content = """
El **ámbito** define desde dónde puede accederse a una variable.

### **1. Variables locales**

Se crean dentro de una función y solo existen allí.

```python
def ejemplo():
    mensaje = "Hola desde dentro"
    print(mensaje)

ejemplo()
print(mensaje)  # ❌ Error
```

```txt
Output:
Hola desde dentro  
NameError: name 'mensaje' is not defined
```

### **2. Variables globales**

Existen fuera de las funciones y pueden usarse dentro de ellas.

```python
mensaje = "Hola global"

def mostrar():
    print(mensaje)

mostrar()
```

```txt
Output:
Hola global
```

### **3. Modificar variable global dentro de una función**

Para modificarla, se usa la palabra clave `global`.

```python
contador = 0

def incrementar():
    global contador
    contador += 1

incrementar()
print(contador)
```

```txt
Output:
1
```


""",
    pageNumber = 5
)

val ModularPage = PageData(
    id = 53,
    content = """
La **modularidad** consiste en dividir un programa en **módulos** o **funciones independientes**.  
Cada módulo cumple una función específica, lo que hace el código **más claro y mantenible**.

### **1. Ejemplo de modularización**

```python
def leer_datos():
    nombre = input("Nombre: ")
    edad = int(input("Edad: "))
    return nombre, edad

def mostrar_datos(nombre, edad):
    print(f"{nombre} tiene {edad} años.")

# Programa principal
n, e = leer_datos()
mostrar_datos(n, e)
```

Aquí se separan las tareas:

- `leer_datos()` obtiene la información.
    
- `mostrar_datos()` la presenta.
    
- El **programa principal** coordina la ejecución.
    

### **2. Beneficios**

|Beneficio|Descripción|
|---|---|
|**Claridad**|Cada función tiene una tarea concreta.|
|**Reutilización**|Puedes usar la misma función en otros programas.|
|**Mantenimiento**|Cambiar una parte no afecta el resto.|
""",
    pageNumber = 6
)

val BuiltinFunctionsPage = PageData(
    id = 54,
    content = """
Python incluye muchas **funciones predefinidas** que puedes usar sin necesidad de definirlas.

### **1. Ejemplos de funciones integradas**

|Función|Descripción|Ejemplo|Resultado|
|---|---|---|---|
|`len()`|Longitud de una secuencia.|`len("Hola")`|`4`|
|`type()`|Tipo de dato.|`type(3.14)`|`<class 'float'>`|
|`max()`|Valor máximo.|`max([1, 5, 2])`|`5`|
|`min()`|Valor mínimo.|`min(3, 1, 9)`|`1`|
|`sum()`|Suma de elementos.|`sum([1, 2, 3])`|`6`|

### **2. Documentar funciones con docstrings**

Los **docstrings** son cadenas que describen qué hace una función.

```python
def saludar(nombre):
    ""${'"'}Imprime un saludo personalizado con el nombre dado.""${'"'}
    print("Hola,", nombre)

help(saludar)
```

```txt
Output:
Help on function saludar in module __main__:

saludar(nombre)
    Imprime un saludo personalizado con el nombre dado.
```

Esto permite que tu código sea **autoexplicativo** y fácil de usar por otros.
""",
    pageNumber = 7
)

// Section id = 10

val WhatIsAnExceptionPage = PageData(
    id = 55,
    content = """Una **excepción** ocurre cuando el intérprete de Python **encuentra un error** que impide continuar con la ejecución normal del programa.  
En lugar de “crashear”, podemos **capturar** ese error y tomar una **acción alternativa**.

### **1. Ejemplo sin manejo de excepciones**

```python
numero = int(input("Ingresa un número: "))
print("El doble es:", numero * 2)
```

Si el usuario escribe algo no numérico, el programa se detiene:

```txt
Input:
Hola
Output:
ValueError: invalid literal for int() with base 10: 'Hola'
```

### **2. Ejemplo con manejo de excepción**

```python
try:
    numero = int(input("Ingresa un número: "))
    print("El doble es:", numero * 2)
except:
    print("Error: debes ingresar un número válido.")
```

```txt
Input:
Hola
Output:
Error: debes ingresar un número válido.
```

Aquí, el programa **no se detiene**, sino que muestra un mensaje controlado.



""",
    pageNumber = 1
)

val TryExceptPage = PageData(
    id = 56,
    content = """La instrucción `try–except` define dos bloques:

- El **bloque `try`** contiene el código que podría causar un error.
    
- El **bloque `except`** define qué hacer si ocurre ese error.
    

### **1. Sintaxis general**

```python
try:
    # Código que puede generar error
except:
    # Código que se ejecuta si ocurre un error
```

### **2. Ejemplo simple**

```python
try:
    division = 10 / 0
except:
    print("No puedes dividir entre cero.")
```

```txt
Output:
No puedes dividir entre cero.
```

### **3. Flujo de ejecución**

1. Python ejecuta el bloque dentro de `try`.
    
2. Si todo va bien, **ignora** el bloque `except`.
    
3. Si ocurre un error, salta al `except` y **continúa el programa** después del bloque.
    


""",
    pageNumber = 2
)

val CommonExceptionsPage = PageData(
    id = 57,
    content = """Python tiene muchas excepciones predefinidas que se lanzan ante diferentes errores.  
Podemos **capturarlas individualmente** para actuar de forma más específica.

### **1. Sintaxis**

```python
try:
    # código
except TipoDeError:
    # respuesta
```

### **2. Ejemplos comunes**

|Tipo de Error|Causa|
|---|---|
|`ValueError`|Conversión inválida de tipo de dato.|
|`ZeroDivisionError`|División entre cero.|
|`TypeError`|Operación con tipos incompatibles.|
|`IndexError`|Acceso a índice fuera del rango.|
|`KeyError`|Clave inexistente en un diccionario.|
|`FileNotFoundError`|Archivo no encontrado.|

### **3. Ejemplo específico**

```python
try:
    numero = int("Hola")
except ValueError:
    print("Error: no se puede convertir texto a número.")
```

```txt
Output:
Error: no se puede convertir texto a número.
```

### **4. Capturar varios tipos de error**

```python
try:
    resultado = 10 / 0
except (ZeroDivisionError, ValueError):
    print("Ocurrió un error matemático.")
```

```txt
Output:
Ocurrió un error matemático.
```

""",
    pageNumber = 3
)

val ElseFinallyBlocksPage = PageData(
    id = 58,
    content = """Python permite ampliar el manejo de excepciones con dos bloques adicionales:

- **`else`** → se ejecuta solo si no hubo error.
    
- **`finally`** → se ejecuta siempre, ocurra o no un error.
    

### **1. Sintaxis completa**

```python
try:
    # código que puede fallar
except:
    # manejo del error
else:
    # se ejecuta si no hubo error
finally:
    # se ejecuta siempre
```

### **2. Ejemplo**

```python
try:
    x = int(input("Número: "))
except ValueError:
    print("Entrada inválida.")
else:
    print("Número válido:", x)
finally:
    print("Fin del programa.")
```

```txt
Input:
abc
Output:
Entrada inválida.  
Fin del programa.
```

El bloque `finally` se usa para **cerrar conexiones, archivos o liberar recursos**,  
garantizando que el código final siempre se ejecute.


""",
    pageNumber = 4
)

val ExceptionsNestedHandlingPage = PageData(
    id = 59,
    content = """Puedes manejar diferentes errores en bloques separados o dentro de otros `try`.

### **1. Múltiples `except`**

```python
try:
    a = int(input("Número A: "))
    b = int(input("Número B: "))
    print("Resultado:", a / b)
except ValueError:
    print("Debes ingresar solo números.")
except ZeroDivisionError:
    print("No puedes dividir entre cero.")
```

```txt
Output (si b = 0):
No puedes dividir entre cero.
```

Cada bloque maneja un tipo de error específico.

### **2. Bloques anidados**

```python
try:
    x = int(input("Número: "))
    try:
        print(10 / x)
    except ZeroDivisionError:
        print("División entre cero.")
except ValueError:
    print("Entrada no válida.")
```

```txt
Output:
Entrada no válida.  
o  
División entre cero.
```

Cada `try` puede tener su propio `except`, lo que da un **control más fino**  
en procesos que pueden fallar en distintos niveles.


""",
    pageNumber = 5
)

val CustomExceptionsPage = PageData(
    id = 60,
    content = """Python permite **definir tus propias excepciones** para casos específicos de tu aplicación.

### **1. Definir una excepción personalizada**

```python
class EdadInvalidaError(Exception):
    pass
```

### **2. Lanzar una excepción personalizada**

```python
def verificar_edad(edad):
    if edad < 0:
        raise EdadInvalidaError("La edad no puede ser negativa.")
    else:
        print("Edad válida.")

try:
    verificar_edad(-5)
except EdadInvalidaError as e:
    print("Error:", e)
```

```txt
Output:
Error: La edad no puede ser negativa.
```

Las excepciones personalizadas permiten crear mensajes y comportamientos  
**acordes al contexto del programa**, manteniendo el control completo sobre los errores.
""",
    pageNumber = 6
)

// Section id = 11

val ProgrammingParadigmIntroductionPage = PageData(
    id = 61,
    content = """
Un **paradigma** define el **estilo de pensamiento** detrás de un programa.  
No se trata del lenguaje, sino de **cómo lo utilizamos** para resolver un problema.

### **1. Ejemplo general**

Un mismo problema puede resolverse de distintas maneras,  
dependiendo del paradigma aplicado.

**Ejemplo:** Calcular la suma de una lista de números.

**Paradigma imperativo (paso a paso):**

```python
suma = 0
for numero in [1, 2, 3]:
    suma += numero
print(suma)
```

**Paradigma funcional (sin pasos explícitos):**

```python
print(sum([1, 2, 3]))
```

Ambos programas hacen lo mismo, pero **piensan diferente**.  
El primero describe _cómo hacerlo_ (el proceso).  
El segundo describe _qué hacer_ (el resultado).



""",
    pageNumber = 1
)

val ImperativePage = PageData(
    id = 62,
    content = """
El paradigma **imperativo** se basa en **dar instrucciones detalladas** al computador  
para modificar el estado del programa paso a paso.

### **1. Características principales**

|Característica|Descripción|
|---|---|
|Secuencia de instrucciones|Las acciones se ejecutan una tras otra.|
|Variables con estado|Los valores cambian durante la ejecución.|
|Control explícito del flujo|Se usan condicionales y bucles.|

### **2. Ejemplo**

```python
total = 0
for i in range(5):
    total = total + i
print(total)
```

```txt
Output:
10
```

El programador **controla cada paso** de la operación.  
Este enfoque es el más natural para aprender a programar.


""",
    pageNumber = 2
)

val StructuredPage = PageData(
    id = 63,
    content = """
El paradigma **estructurado** surge como una mejora del imperativo.  
Busca **organizar** el código en bloques lógicos (funciones) y evitar el uso desordenado de saltos (`goto` o anidamientos excesivos).

### **1. Principios clave**

|Principio|Descripción|
|---|---|
|**Secuencia**|Ejecución ordenada de instrucciones.|
|**Selección**|Decisiones mediante condicionales (`if`, `else`).|
|**Iteración**|Repetición mediante bucles (`for`, `while`).|
|**Modularidad**|Dividir el programa en funciones o módulos.|

### **2. Ejemplo estructurado**

```python
def calcular_promedio(lista):
    total = sum(lista)
    return total / len(lista)

def mostrar_resultado():
    notas = [15, 18, 12]
    promedio = calcular_promedio(notas)
    print("Promedio:", promedio)

mostrar_resultado()
```

```txt
Output:
Promedio: 15.0
```

Cada función tiene una tarea específica,  
y el programa principal las combina de forma ordenada.


""",
    pageNumber = 3
)

val FunctionalPage = PageData(
    id = 64,
    content = """
El paradigma **funcional** se centra en el uso de **funciones puras**,  
sin modificar datos ni depender de estados externos.

### **1. Características**

| Propiedad                   | Descripción                                         |
| --------------------------- | --------------------------------------------------- |
| **Sin efectos secundarios** | Las funciones no cambian variables externas.        |
| **Inmutabilidad**           | Los datos no se alteran, se generan nuevos valores. |
| **Expresividad**            | Se combinan funciones para obtener resultados.      |

### **2. Ejemplo con funciones puras**

```python
def cuadrado(x):
    return x * x

numeros = [1, 2, 3, 4]
resultado = list(map(cuadrado, numeros))
print(resultado)
```

```txt
Output:
[1, 4, 9, 16]
```

Aquí, `map()` aplica la función `cuadrado` a cada elemento  
sin alterar la lista original.

### **3. Ejemplo con comprensión funcional**

```python
pares = [x for x in range(10) if x % 2 == 0]
print(pares)
```

```txt
Output:
[0, 2, 4, 6, 8]
```


""",
    pageNumber = 4
)

val POOPage = PageData(
    id = 65,
    content = """
El paradigma **orientado a objetos (POO)** organiza el código en **clases y objetos**,  
imitando la forma en que pensamos en el mundo real:  
objetos con **propiedades (datos)** y **comportamientos (métodos)**.

### **1. Conceptos clave**

|Concepto|Descripción|
|---|---|
|**Clase**|Plantilla que define propiedades y métodos.|
|**Objeto**|Instancia concreta de una clase.|
|**Atributo**|Dato o característica del objeto.|
|**Método**|Función que pertenece al objeto.|

### **2. Ejemplo básico**

```python
class Persona:
    def __init__(self, nombre):
        self.nombre = nombre

    def saludar(self):
        print("Hola, soy", self.nombre)

p1 = Persona("Lumin")
p1.saludar()
```

```txt
Output:
Hola, soy Lumin
```

Cada objeto tiene su propio estado y comportamiento.  
La POO se usa ampliamente en sistemas grandes y mantenibles.


""",
    pageNumber = 5
)

val ComparisonAndApplicationsPage = PageData(
    id = 66,
    content = """
Cada paradigma ofrece **ventajas y contextos de uso diferentes**.  
Python permite combinarlos de manera flexible.

|Paradigma|Enfoque|Ejemplo de uso común|
|---|---|---|
|**Imperativo**|Describir paso a paso las acciones.|Scripts simples, automatización.|
|**Estructurado**|Organización mediante funciones.|Programas educativos, aplicaciones básicas.|
|**Funcional**|Uso de funciones puras e inmutabilidad.|Procesamiento de datos, IA, matemáticas.|
|**Orientado a Objetos**|Modelar entidades con clases y objetos.|Aplicaciones grandes, juegos, frameworks web.|

### **Ejemplo combinado**

```python
class Calculadora:
    def __init__(self):
        self.total = 0

    def sumar(self, a, b):
        return a + b

    def cuadrado(self, x):
        return x * x

calc = Calculadora()
print(calc.sumar(2, 3))       # Imperativo / Estructurado
print(calc.cuadrado(4))       # Funcional
```

```txt
Output:
5  
16
```

Este ejemplo demuestra cómo Python puede **unir paradigmas** en un solo programa,  
lo que lo convierte en un lenguaje sumamente versátil y moderno.
""",
    pageNumber = 6
)

// Section id = 12

val PooFundamentalsPage = PageData(
    id = 67,
    content = """
La **Programación Orientada a Objetos (POO)** modela los programas según la **realidad**.  
Un programa se compone de **objetos**, que son **entidades con características (atributos)** y **acciones (métodos)**.

### **1. Conceptos clave**

|Término|Descripción|
|---|---|
|**Clase**|Es el “molde” o plantilla para crear objetos.|
|**Objeto**|Instancia concreta creada a partir de una clase.|
|**Atributos**|Datos que describen al objeto (como su estado).|
|**Métodos**|Acciones o comportamientos que puede realizar el objeto.|

### **2. Ejemplo del mundo real**

**Clase:** “Perro”  
→ **Atributos:** nombre, raza, edad  
→ **Métodos:** ladrar(), comer()

**Objeto:**

```txt
nombre = "Lumi"
raza = "Labrador"
edad = 3
```

Cada objeto es **único**, pero todos siguen la estructura de la clase “Perro”.



""",
    pageNumber = 1
)

val PythonClassesAndObjectsPage = PageData(
    id = 68,
    content = """
Las clases se definen con la palabra clave `class`.  
Un objeto se crea “instanciando” la clase.

### **1. Definir una clase**

```python
class Persona:
    pass  # Clase vacía (por ahora)
```

### **2. Crear un objeto**

```python
p1 = Persona()
print(type(p1))
```

```txt
Output:
<class '__main__.Persona'>
```

Cada objeto creado a partir de una clase tiene su **propio espacio de datos**.  
A partir de este punto, podemos añadir atributos y métodos personalizados.


""",
    pageNumber = 2
)

val InitMethodPage = PageData(
    id = 69,
    content = """
El método `__init__` se ejecuta **automáticamente** al crear un objeto.  
Se usa para **inicializar atributos**.

### **1. Sintaxis general**

```python
class Clase:
    def __init__(self, parametros):
        # inicialización de atributos
```

### **2. Ejemplo con atributos**

```python
class Persona:
    def __init__(self, nombre, edad):
        self.nombre = nombre
        self.edad = edad
```

`self` representa **la instancia actual del objeto**.

### **3. Crear objetos con atributos iniciales**

```python
p1 = Persona("Lumin", 20)
p2 = Persona("Ana", 25)

print(p1.nombre)
print(p2.edad)
```

```txt
Output:
Lumin  
25
```

Cada objeto mantiene sus propios valores internos.


""",
    pageNumber = 3
)

val InstanceMethodsPage = PageData(
    id = 70,
    content = """
Los **métodos** son funciones definidas dentro de una clase.  
Sirven para definir los **comportamientos** de los objetos.

### **1. Ejemplo de método**

```python
class Persona:
    def __init__(self, nombre):
        self.nombre = nombre

    def saludar(self):
        print("Hola, soy", self.nombre)
```

### **2. Uso del método**

```python
p1 = Persona("Lumin")
p1.saludar()
```

```txt
Output:
Hola, soy Lumin
```

El parámetro `self` **siempre debe estar presente** en los métodos de instancia,  
ya que hace referencia al propio objeto que los llama.


""",
    pageNumber = 4
)

val ClassAndObjectVariablesPage = PageData(
    id = 71,
    content = """
En Python existen dos tipos de variables dentro de una clase:

| Tipo             | Descripción                        | Acceso           |
| ---------------- | ---------------------------------- | ---------------- |
| **De instancia** | Propias de cada objeto.            | `self.atributo`  |
| **De clase**     | Compartidas por todos los objetos. | `Clase.atributo` |

### **1. Ejemplo combinado**

```python
class Persona:
    especie = "Humano"  # Variable de clase

    def __init__(self, nombre):
        self.nombre = nombre  # Variable de instancia
```

```python
p1 = Persona("Lumin")
p2 = Persona("Ana")

print(p1.especie)
print(p2.nombre)
```

```txt
Output:
Humano  
Ana
```

Las variables de clase **no cambian entre objetos**,  
mientras que las de instancia sí son únicas.


""",
    pageNumber = 5
)

val ObjectRepresentationPage = PageData(
    id = 72,
    content = """
Cuando imprimimos un objeto, Python muestra su ubicación en memoria.  
Podemos personalizar su representación usando el método especial `__str__`.

### **1. Ejemplo sin `__str__`**

```python
class Persona:
    def __init__(self, nombre):
        self.nombre = nombre

p1 = Persona("Lumin")
print(p1)
```

```txt
Output:
<__main__.Persona object at 0x00000123>
```

### **2. Ejemplo con `__str__`**

```python
class Persona:
    def __init__(self, nombre, edad):
        self.nombre = nombre
        self.edad = edad

    def __str__(self):
        return f"Persona: {self.nombre}, {self.edad} años"
```

```python
p1 = Persona("Lumin", 20)
print(p1)
```

```txt
Output:
Persona: Lumin, 20 años
```

Ahora el objeto muestra información **legible y significativa**.


""",
    pageNumber = 6
)

val BasicEncapsulationPage = PageData(
    id = 73,
    content = """La **encapsulación** protege los datos internos del objeto.  
Se logra limitando el acceso directo a los atributos.

### **1. Atributos “protegidos” y “privados”**

En Python no existen modificadores estrictos,  
pero se usan **convenciones**:

|Notación|Nivel|Ejemplo|
|---|---|---|
|`nombre`|Público|`objeto.nombre`|
|`_nombre`|Protegido (uso interno)|`objeto._nombre`|
|`__nombre`|Privado|`objeto.__nombre`|

### **2. Ejemplo de encapsulación**

```python
class Cuenta:
    def __init__(self, saldo):
        self.__saldo = saldo  # privado

    def mostrar_saldo(self):
        print("Saldo:", self.__saldo)
```

```python
c = Cuenta(1000)
c.mostrar_saldo()
print(c.__saldo)  # ❌ Error
```

```txt
Output:
Saldo: 1000  
AttributeError: 'Cuenta' object has no attribute '__saldo'
```

El atributo privado **solo puede ser accedido** mediante los métodos del objeto.  
Esto garantiza **seguridad e integridad** de los datos.
""",
    pageNumber = 7
)

// Section id = 13

val AdvancedPrinciplesPage = PageData(
    id = 74,
    content = """
En la POO existen tres conceptos fundamentales que amplían el poder de las clases y objetos:

|Concepto|Propósito|
|---|---|
|**Herencia**|Permite que una clase reutilice atributos y métodos de otra.|
|**Encapsulamiento**|Protege los datos internos del acceso directo.|
|**Polimorfismo**|Permite usar un mismo método con comportamientos diferentes.|

Estos principios trabajan **juntos** para crear programas organizados y extensibles.  
Los veremos uno a uno a continuación.



""",
    pageNumber = 1
)

val PythonInheritancePage = PageData(
    id = 75,
    content = """
La **herencia** permite crear una **nueva clase (hija)** a partir de una **clase existente (padre)**,  
heredando sus atributos y métodos.

### **1. Sintaxis general**

```python
class ClasePadre:
    # atributos y métodos

class ClaseHija(ClasePadre):
    # nuevos atributos o métodos
```

### **2. Ejemplo simple**

```python
class Persona:
    def __init__(self, nombre):
        self.nombre = nombre

    def saludar(self):
        print("Hola, soy", self.nombre)

class Estudiante(Persona):
    def estudiar(self):
        print(self.nombre, "está estudiando.")
```

```python
e = Estudiante("Lumin")
e.saludar()
e.estudiar()
```

```txt
Output:
Hola, soy Lumin  
Lumin está estudiando.
```

La clase `Estudiante` **hereda** el comportamiento de `Persona`  
y puede **agregar nuevos métodos**.

### **3. Función `super()`**

Permite acceder a métodos o atributos de la clase padre dentro de la hija.

```python
class Estudiante(Persona):
    def __init__(self, nombre, carrera):
        super().__init__(nombre)
        self.carrera = carrera
```

El uso de `super()` evita la duplicación de código y garantiza  
la correcta inicialización de las clases heredadas.


""",
    pageNumber = 2
)

val MultipleInheritancePage = PageData(
    id = 76,
    content = """
Python permite que una clase herede de **más de una clase**.  
Esto se llama **herencia múltiple**.

### **1. Sintaxis**

```python
class ClaseHija(ClasePadre1, ClasePadre2):
    pass
```

### **2. Ejemplo**

```python
class A:
    def saludo(self):
        print("Saludo desde A")

class B:
    def saludo(self):
        print("Saludo desde B")

class C(A, B):
    pass

obj = C()
obj.saludo()
```

```txt
Output:
Saludo desde A
```

Python sigue el **Orden de Resolución de Métodos (MRO)**,  
es decir, busca los métodos de izquierda a derecha.  
En este caso, el método `saludo` de `A` se ejecuta antes que el de `B`.


""",
    pageNumber = 3
)

val EncapsulationMethodsPage = PageData(
    id = 77,
    content = """
El **encapsulamiento** controla el acceso a los atributos internos del objeto.  
Python no tiene modificadores estrictos, pero usa convenciones y propiedades para lograrlo.

### **1. Atributos privados**

```python
class Cuenta:
    def __init__(self, saldo):
        self.__saldo = saldo  # privado

    def mostrar_saldo(self):
        return self.__saldo
```

### **2. Acceso controlado con getters y setters**

Podemos crear métodos para **leer** y **modificar** el valor de forma segura.

```python
class Cuenta:
    def __init__(self, saldo):
        self.__saldo = saldo

    def get_saldo(self):
        return self.__saldo

    def set_saldo(self, nuevo_saldo):
        if nuevo_saldo >= 0:
            self.__saldo = nuevo_saldo
        else:
            print("Saldo inválido.")
```

```python
c = Cuenta(500)
print(c.get_saldo())
c.set_saldo(1000)
print(c.get_saldo())
```

```txt
Output:
500  
1000
```

### **3. Uso de decoradores `@property`**

Simplifica el acceso a métodos que actúan como atributos.

```python
class Cuenta:
    def __init__(self, saldo):
        self.__saldo = saldo

    @property
    def saldo(self):
        return self.__saldo

    @saldo.setter
    def saldo(self, valor):
        if valor >= 0:
            self.__saldo = valor
```

```python
c = Cuenta(300)
c.saldo = 700
print(c.saldo)
```

```txt
Output:
700
```


""",
    pageNumber = 4
)

val PolymorphismPage = PageData(
    id = 78,
    content = """
El **polimorfismo** significa “muchas formas”.  
En POO, permite usar el **mismo método** en objetos de distintas clases,  
pero con comportamientos diferentes.

### **1. Ejemplo básico**

```python
class Ave:
    def sonido(self):
        print("Algunas aves cantan")

class Loro(Ave):
    def sonido(self):
        print("El loro dice: ¡Hola!")

class Pato(Ave):
    def sonido(self):
        print("El pato hace: Cuac")
```

```python
aves = [Loro(), Pato()]
for ave in aves:
    ave.sonido()
```

```txt
Output:
El loro dice: ¡Hola!  
El pato hace: Cuac
```

Aunque el método se llama igual (`sonido`),  
cada clase tiene **su propia implementación**.


""",
    pageNumber = 5
)

val MethodOverridingPage = PageData(
    id = 79,
    content = """
La **sobreescritura** permite redefinir un método heredado de la clase padre  
para adaptarlo al comportamiento de la clase hija.

### **1. Ejemplo**

```python
class Empleado:
    def trabajar(self):
        print("El empleado está trabajando")

class Programador(Empleado):
    def trabajar(self):
        print("El programador escribe código")
```

```python
p = Programador()
p.trabajar()
```

```txt
Output:
El programador escribe código
```

Python usa siempre la versión **más específica** del método  
(definida en la subclase).


""",
    pageNumber = 6
)

val AbstractClassesPage = PageData(
    id = 80,
    content = """
En algunos casos, necesitamos definir una clase que **no se instancie directamente**,  
sino que sirva como **modelo** para otras.

### **1. Concepto de clase abstracta**

Una clase abstracta define **métodos obligatorios**,  
pero **no los implementa completamente**.  
En Python se crean con el módulo `abc`.

### **2. Ejemplo**

```python
from abc import ABC, abstractmethod

class Figura(ABC):
    @abstractmethod
    def area(self):
        pass
```

```python
class Cuadrado(Figura):
    def __init__(self, lado):
        self.lado = lado

    def area(self):
        return self.lado * self.lado

c = Cuadrado(4)
print(c.area())
```

```txt
Output:
16
```

Las clases abstractas garantizan que las subclases  
**implementen los métodos definidos** en la clase base.
""",
    pageNumber = 7
)

// Section id = 14

val FileConceptPage = PageData(
    id = 81,
    content = """
Un **archivo** es una colección de información guardada en un medio físico (como el disco duro).  
Los programas pueden **abrir, leer, escribir o modificar** estos archivos.

### **1. Tipos de archivos comunes**

|Tipo|Descripción|Ejemplo|
|---|---|---|
|**Texto**|Contiene caracteres legibles.|`.txt`, `.csv`, `.json`|
|**Binario**|Contiene datos codificados (no legibles directamente).|`.jpg`, `.exe`, `.dat`|

### **2. Ciclo de manejo de archivos**

1. **Abrir** el archivo.
    
2. **Leer o escribir** datos.
    
3. **Cerrar** el archivo para liberar recursos.
    

### **3. Ejemplo conceptual**

```python
# Ciclo básico
archivo = open("datos.txt", "r")  # abrir
contenido = archivo.read()        # leer
archivo.close()                   # cerrar
```

Sin cerrar un archivo, puede perderse información o bloquear el acceso.



""",
    pageNumber = 1
)

val OpenAndCloseFilesPage = PageData(
    id = 82,
    content = """
La función principal para trabajar con archivos en Python es `open()`.  
Se usa con dos argumentos: **nombre del archivo** y **modo de apertura**.

### **1. Sintaxis general**

```python
open(nombre, modo)
```

### **2. Modos de apertura más comunes**

|Modo|Descripción|
|---|---|
|`"r"`|Lectura (read). Da error si el archivo no existe.|
|`"w"`|Escritura (write). Crea un nuevo archivo o sobrescribe el existente.|
|`"a"`|Agregar (append). Escribe al final sin borrar el contenido previo.|
|`"x"`|Creación exclusiva. Da error si el archivo ya existe.|
|`"b"`|Binario. Se combina con otros modos (ej: `"rb"` o `"wb"`).|

### **3. Ejemplo básico de apertura**

```python
archivo = open("ejemplo.txt", "w")
archivo.write("Aprendiendo Python con Lumin")
archivo.close()
```

Esto crea (o sobrescribe) el archivo `ejemplo.txt` con el texto indicado.


""",
    pageNumber = 2
)

val FileReadPage = PageData(
    id = 83,
    content = """
Los archivos abiertos en modo lectura (`"r"`) pueden ser leídos de distintas formas.

### **1. Leer todo el contenido**

```python
archivo = open("texto.txt", "r")
contenido = archivo.read()
print(contenido)
archivo.close()
```

```txt
Output:
Hola, mundo
Bienvenido a Python
```

### **2. Leer línea por línea**

```python
archivo = open("texto.txt", "r")
for linea in archivo:
    print(linea.strip())
archivo.close()
```

```txt
Output:
Hola, mundo  
Bienvenido a Python
```

### **3. Leer una sola línea**

```python
archivo = open("texto.txt", "r")
print(archivo.readline())
archivo.close()
```

```txt
Output:
Hola, mundo
```

Cada lectura **mueve el cursor** dentro del archivo.  
Después de leer todo el contenido, el cursor queda al final.



""",
    pageNumber = 3
)

val FileWritePage = PageData(
    id = 84,
    content = """
Python permite **escribir o añadir texto** en archivos con los modos `"w"` y `"a"`.

### **1. Escribir desde cero**

```python
archivo = open("notas.txt", "w")
archivo.write("Primera línea\n")
archivo.write("Segunda línea\n")
archivo.close()
```

```txt
Archivo creado con:
Primera línea  
Segunda línea
```

Cada ejecución en modo `"w"` **sobrescribe** el contenido anterior.

### **2. Agregar contenido sin borrar lo existente**

```python
archivo = open("notas.txt", "a")
archivo.write("Tercera línea\n")
archivo.close()
```

```txt
Archivo actualizado con:
Primera línea  
Segunda línea  
Tercera línea
```

El modo `"a"` siempre escribe al **final del archivo**.


""",
    pageNumber = 4
)

val ContextWithPage = PageData(
    id = 85,
    content = """
Abrir archivos manualmente requiere recordar `close()`.  
El bloque `with` se encarga **automáticamente** de abrir y cerrar el archivo,  
incluso si ocurre un error.

### **1. Ejemplo con `with`**

```python
with open("datos.txt", "r") as archivo:
    contenido = archivo.read()
    print(contenido)
```

No es necesario llamar a `close()`: Python lo hace al salir del bloque.

### **2. Ventajas de usar `with`**

|Ventaja|Descripción|
|---|---|
|**Seguridad**|Garantiza el cierre del archivo.|
|**Legibilidad**|Código más limpio y estructurado.|
|**Manejo automático de errores**|Evita pérdidas de datos si ocurre una excepción.|

### **3. Ejemplo con escritura**

```python
with open("registro.txt", "a") as f:
    f.write("Nueva entrada\n")
```

El archivo se abrirá, escribirá y cerrará automáticamente.


""",
    pageNumber = 5
)

val FileErrorHandlingPage = PageData(
    id = 86,
    content = """
Trabajar con archivos puede generar errores si el archivo no existe  
o si el usuario no tiene permisos.

### **1. Ejemplo con manejo de excepciones**

```python
try:
    with open("archivo_inexistente.txt", "r") as f:
        print(f.read())
except FileNotFoundError:
    print("El archivo no existe.")
```

```txt
Output:
El archivo no existe.
```

### **2. Otras excepciones comunes**

|Error|Causa|
|---|---|
|`FileNotFoundError`|Archivo no existe.|
|`PermissionError`|No hay permisos de lectura o escritura.|
|`IOError`|Error general de entrada/salida.|

### **3. Ejemplo completo**

```python
try:
    with open("config.txt", "r") as archivo:
        for linea in archivo:
            print(linea.strip())
except FileNotFoundError:
    print("Archivo no encontrado.")
finally:
    print("Ejecución finalizada.")
```

```txt
Output:
Archivo no encontrado.  
Ejecución finalizada.
```

El uso combinado de `with`, `try–except` y `finally`  
asegura un manejo **robusto y controlado** de los archivos.

""",
    pageNumber = 6
)

// Section id = 15

val ReviewStructuresPage = PageData(
    id = 87,
    content = """
Python ofrece cuatro estructuras de datos fundamentales que forman la base de su manejo de información.

|Tipo|Mutable|Ordenado|Elementos Duplicados|Ejemplo|
|---|---|---|---|---|
|**Listas (`list`)**|✅|✅|✅|`[1, 2, 3]`|
|**Tuplas (`tuple`)**|❌|✅|✅|`(1, 2, 3)`|
|**Conjuntos (`set`)**|✅|❌|❌|`{1, 2, 3}`|
|**Diccionarios (`dict`)**|✅|✅ (desde Python 3.7)|🔑 Claves únicas|`{"a": 1, "b": 2}`|

Cada una tiene su propósito específico:

- **Listas:** para colecciones cambiantes.
    
- **Tuplas:** para datos inmutables.
    
- **Conjuntos:** para valores únicos.
    
- **Diccionarios:** para pares clave–valor.
    

Sin embargo, cuando los programas crecen, a veces necesitamos estructuras **más especializadas** — ahí entra el módulo `collections`.



""",
    pageNumber = 1
)

val CollectionsModulePage = PageData(
    id = 88,
    content = """
El módulo `collections` proporciona **estructuras optimizadas** para manejar colecciones de datos.  
Estas estructuras ofrecen mayor rendimiento o características específicas para casos concretos.

### **1. Importar el módulo**

```python
import collections
```

O directamente las clases que se usarán:

```python
from collections import namedtuple, deque, Counter, defaultdict, OrderedDict
```

### **2. Ventajas principales**

|Estructura|Propósito|
|---|---|
|`namedtuple`|Crear tuplas con nombres de campo.|
|`deque`|Lista optimizada para inserciones y eliminaciones rápidas.|
|`Counter`|Contar elementos en colecciones.|
|`defaultdict`|Diccionario con valores predeterminados.|
|`OrderedDict`|Diccionario que conserva el orden de inserción.|

Cada una simplifica tareas comunes sin necesidad de escribir estructuras complejas manualmente.



""",
    pageNumber = 2
)

val NamedTuplePage = PageData(
    id = 89,
    content = """
Una `namedtuple` actúa como una tupla normal, pero **sus elementos pueden ser accedidos por nombre** además de por posición.  
Esto mejora la legibilidad del código.

### **1. Definición básica**

```python
from collections import namedtuple

Persona = namedtuple("Persona", ["nombre", "edad", "pais"])
p1 = Persona("Lumin", 20, "Perú")

print(p1.nombre)
print(p1[1])
```

```txt
Output:
Lumin  
20
```

### **2. Características**

|Propiedad|Descripción|
|---|---|
|**Inmutable**|No se pueden modificar los valores.|
|**Legible**|Acceso por nombre en lugar de índice.|
|**Ligera**|Más eficiente que una clase completa.|

### **3. Ejemplo práctico**

```python
Libro = namedtuple("Libro", "titulo autor")
l = Libro("1984", "George Orwell")
print(f"{l.titulo} fue escrito por {l.autor}")
```

```txt
Output:
1984 fue escrito por George Orwell
```


""",
    pageNumber = 3
)

val DequePage = PageData(
    id = 90,
    content = """
Un **deque** (Double-Ended Queue) es una cola que permite **añadir o quitar elementos por ambos extremos** de forma eficiente.  
Es ideal para implementar colas o pilas.

### **1. Ejemplo básico**

```python
from collections import deque

cola = deque(["A", "B", "C"])
cola.append("D")        # Agrega al final
cola.appendleft("Z")    # Agrega al inicio
print(cola)
```

```txt
Output:
deque(['Z', 'A', 'B', 'C', 'D'])
```

### **2. Eliminar elementos**

```python
cola.pop()       # Elimina del final
cola.popleft()   # Elimina del inicio
```

```txt
Output:
deque(['A', 'B', 'C'])
```

### **3. Usos comunes**

- Implementar colas FIFO (primero en entrar, primero en salir).
    
- Simular pilas LIFO (último en entrar, primero en salir).
    
- Desplazamientos de datos o buffers circulares.
    


""",
    pageNumber = 4
)

val CounterPage = PageData(
    id = 91,
    content = """
`Counter` permite contar cuántas veces aparece cada elemento en una secuencia.

### **1. Ejemplo básico**

```python
from collections import Counter

frase = "python es poderoso y python es divertido".split()
conteo = Counter(frase)
print(conteo)
```

```txt
Output:
Counter({'python': 2, 'es': 2, 'poderoso': 1, 'y': 1, 'divertido': 1})
```

### **2. Métodos útiles**

|Método|Descripción|
|---|---|
|`.most_common(n)`|Devuelve los `n` elementos más frecuentes.|
|`.elements()`|Itera repitiendo cada elemento según su cantidad.|
|`.update()`|Suma nuevos conteos a un contador existente.|

### **3. Ejemplo de `.most_common()`**

```python
print(conteo.most_common(2))
```

```txt
Output:
[('python', 2), ('es', 2)]
```

El `Counter` es ideal para **analizar texto, datos o estadísticas.**


""",
    pageNumber = 5
)

val DefaultDictPage = PageData(
    id = 92,
    content = """### **1. `defaultdict`**

Es un diccionario que asigna un **valor por defecto** a las claves inexistentes.  
Evita errores de tipo `KeyError`.

```python
from collections import defaultdict

notas = defaultdict(int)
notas["Lumin"] += 10
notas["Ana"] += 5
print(notas)
```

```txt
Output:
defaultdict(<class 'int'>, {'Lumin': 10, 'Ana': 5})
```

Cada nueva clave inicia con el valor de su tipo base (en este caso, `int` → `0`).

### **2. `OrderedDict`**

Antes de Python 3.7, los diccionarios no garantizaban el orden.  
`OrderedDict` mantiene el **orden de inserción** de los elementos.

```python
from collections import OrderedDict

datos = OrderedDict()
datos["nombre"] = "Lumin"
datos["edad"] = 20
datos["pais"] = "Perú"

for clave, valor in datos.items():
    print(clave, "→", valor)
```

```txt
Output:
nombre → Lumin  
edad → 20  
pais → Perú
```

### **3. Diferencias clave**

|Estructura|Propósito|Ventaja|
|---|---|---|
|`defaultdict`|Evitar errores al acceder a claves inexistentes.|Asigna valores iniciales automáticamente.|
|`OrderedDict`|Mantener el orden de inserción.|Control del orden en iteraciones.|
""",
    pageNumber = 6
)

// Section id = 16

val WhyWeMeasureEfficiencyPage = PageData(
    id = 93,
    content = """Cuando escribimos un programa, queremos que **funcione correctamente**, pero también que lo haga **rápido y sin desperdiciar recursos**.  
Aquí entra en juego el concepto de **eficiencia algorítmica**.

Un algoritmo puede resolver un problema, pero si su rendimiento se degrada con pocos datos, **no es eficiente**.  
Por eso medimos **cuánto tarda** y **cuánta memoria usa** según el tamaño de la entrada.

### **Ejemplo simple**

```python
# Suma con un bucle
def suma_lista(lista):
    total = 0
    for numero in lista:
        total += numero
    return total

# Suma usando la función incorporada de Python
def suma_rapida(lista):
    return sum(lista)
```

Ambas funciones dan el mismo resultado, pero `sum()` es mucho más rápida.  
¿Por qué? Porque su implementación interna está **optimizada**.  
La notación asintótica nos ayuda a **medir** esa diferencia sin necesidad de probar todos los casos.

### **Dos tipos de eficiencia**

|Tipo|Qué mide|Ejemplo|
|---|---|---|
|**Temporal**|Cuánto tarda el algoritmo.|Un bucle con 1000 iteraciones tarda más que uno con 10.|
|**Espacial**|Cuánta memoria usa.|Crear listas grandes o copiar datos ocupa más espacio.|

Analizar la eficiencia es esencial para saber **qué tan bien escalará** tu programa a medida que aumente la cantidad de datos.



""",
    pageNumber = 1
)

val MeetingBig0ONotationPage = PageData(
    id = 94,
    content = """La **Notación Big O** (se lee “O grande”) describe el **comportamiento del tiempo o espacio** que necesita un algoritmo cuando la cantidad de datos de entrada crece.

En lugar de contar segundos, contamos **cuántas operaciones** realiza en función del tamaño `n` de los datos.

### **Idea principal**

> “Big O mide el crecimiento del algoritmo a gran escala.”

Si un algoritmo tarda 3 pasos con 10 elementos y 3000 con 1000 elementos,  
decimos que **crece linealmente** → O(n).

### **Ejemplo visual**

|Tamaño de entrada|Operaciones ejecutadas|Complejidad|
|---|---|---|
|10|10|O(n)|
|10|100|O(n²)|
|10|1|O(1)|

### **Ejemplo en código**

```python
# O(1) - constante
def acceso_directo(lista):
    return lista[0]  # solo una operación

# O(n) - lineal
def imprimir(lista):
    for elemento in lista:
        print(elemento)
```

La primera función hace una sola operación (constante).  
La segunda depende de cuántos elementos haya en la lista (lineal).


""",
    pageNumber = 2
)

val ConstantComplexityPage = PageData(
    id = 95,
    content = """### **1. O(1) – Complejidad Constante**

El algoritmo tarda **siempre lo mismo**, sin importar el tamaño de los datos.

```python
def obtener_primero(lista):
    return lista[0]
```

- No importa si la lista tiene 10 o 10 millones de elementos.
    
- Solo se accede al **primer elemento**, por lo que siempre es una sola operación.
    

🧩 Ejemplos típicos:

- Acceder a un elemento de una lista o diccionario.
    
- Sumar dos variables.
    
- Comparar dos valores.
    
### **2. O(n) – Complejidad Lineal**

El tiempo crece **de forma proporcional** al número de elementos.

```python
def buscar_elemento(lista, valor):
    for x in lista:
        if x == valor:
            return True
    return False
```

Si la lista tiene 1000 elementos, la función podría hacer hasta **1000 comparaciones**.  
Esto se llama **búsqueda lineal**.

🧩 Ejemplos típicos:

- Recorrer listas con `for`.
    
- Contar elementos.
    
- Filtrar o buscar sin estructura optimizada.
    

### **Visualmente**

|Tamaño `n`|O(1)|O(n)|
|---|---|---|
|10|1|10|
|100|1|100|
|1000|1|1000|


""",
    pageNumber = 3
)

val CuadraticComplexityPage = PageData(
    id = 96,
    content = """### **1. O(n²) – Complejidad Cuadrática**

Los algoritmos cuadráticos ejecutan **un bucle dentro de otro bucle**,  
repitiendo operaciones por cada elemento del conjunto.

```python
def comparar_todos(lista):
    for i in lista:
        for j in lista:
            print(i, j)
```

- Si `n = 10`, se hacen 100 comparaciones.
    
- Si `n = 1000`, se hacen 1,000,000 comparaciones.
    

🧩 Ejemplo típico: algoritmos de ordenamiento simples (burbuja, inserción).

---

### **2. O(log n) – Complejidad Logarítmica**

Los algoritmos logarítmicos **reducen el problema a la mitad en cada paso**.  
Esto los hace extremadamente eficientes.

```python
def busqueda_binaria(lista, valor):
    inicio, fin = 0, len(lista) - 1
    while inicio <= fin:
        medio = (inicio + fin) // 2
        if lista[medio] == valor:
            return True
        elif lista[medio] < valor:
            inicio = medio + 1
        else:
            fin = medio - 1
    return False
```

Cada paso **descarta la mitad** de la lista.  
Si hay 1 millón de elementos, se necesitan solo unos **20 pasos**.

🧩 Ejemplo típico: búsqueda binaria (requiere datos ordenados).


""",
    pageNumber = 4
)

val LogarithmicPage = PageData(
    id = 97,
    content = """
La complejidad **O(n log n)** representa el punto óptimo entre velocidad y utilidad.  
Es la base de los **algoritmos de ordenación eficientes** como **Merge Sort** o **Quick Sort**.

### **Cómo funciona**

- El algoritmo **divide** el problema (log n)
    
- Y **procesa** cada parte (n)
    

Por eso se multiplica → O(n log n)

### **Ejemplo conceptual:**

```python
def mergesort(lista):
    if len(lista) <= 1:
        return lista
    mitad = len(lista) // 2
    izquierda = mergesort(lista[:mitad])
    derecha = mergesort(lista[mitad:])
    return fusionar(izquierda, derecha)

def fusionar(a, b):
    resultado = []
    while a and b:
        resultado.append(a.pop(0) if a[0] < b[0] else b.pop(0))
    return resultado + a + b
```

🧩 Este tipo de algoritmos **se escalan bien**, incluso con millones de datos.

|Complejidad|Rendimiento estimado|
|---|---|
|O(n²)|Lento (crece rápido)|
|O(n log n)|Rápido (ideal para grandes volúmenes)|
|O(n)|Excelente (limitado a casos lineales)|


""",
    pageNumber = 5
)

val IdentifyingBigOPage = PageData(
    id = 98,
    content = """
Reconocer la complejidad en tu código es una **habilidad esencial**.

### **1. Reglas prácticas**

|Patrón|Complejidad|Ejemplo|
|---|---|---|
|Una sola operación|O(1)|`x = lista[0]`|
|Un bucle simple|O(n)|`for x in lista:`|
|Dos bucles anidados|O(n²)|`for i in lista: for j in lista:`|
|División del problema|O(log n)|búsqueda binaria|
|Bucle dentro de recursión logarítmica|O(n log n)|mergesort|

### **2. Ejemplos en Python**

```python
# O(n)
for i in range(n):
    print(i)

# O(n²)
for i in range(n):
    for j in range(n):
        print(i, j)

# O(n log n)
def ejemplo(n):
    i = n
    while i > 1:
        i = i // 2
        for j in range(n):
            pass
```


### **3. Consejo final**

No siempre el algoritmo más corto es el más rápido.  
El verdadero dominio está en **entender cómo crece su complejidad**.

> Saber Big O no es memorizar letras, es **predecir el futuro de tu programa** cuando los datos crecen.

""",
    pageNumber = 6
)

// Section id = 17

val WhatIsADesignParadigmPage = PageData(
    id = 99,
    content = """
Un **paradigma de diseño** es una **estrategia general** para resolver problemas algorítmicos.  
En lugar de enfocarnos en el código, pensamos **cómo atacar el problema**.

Cada paradigma tiene su **filosofía**: algunos dividen el problema, otros prueban todas las opciones o eligen la mejor decisión en cada paso.

### **1. Enfoques más comunes**

|Paradigma|Idea principal|Ejemplo|
|---|---|---|
|**Divide y vencerás**|Divide el problema en subproblemas pequeños y combina sus resultados.|Merge Sort|
|**Greedy (voraz)**|Toma decisiones óptimas locales esperando un resultado global óptimo.|Dijkstra|
|**Programación dinámica**|Guarda soluciones parciales para no repetir cálculos.|Fibonacci optimizado|
|**Recursivo**|El algoritmo se llama a sí mismo hasta resolver un caso base.|Factorial|

### **2. ¿Por qué importa elegir un paradigma?**

El paradigma define la **estructura mental del algoritmo**.  
Elegir mal puede hacer que tu solución sea **correcta pero ineficiente**.

```python
# Ejemplo: Suma de los primeros n números

# Solución 1: Iterativa (O(n))
def suma_iterativa(n):
    total = 0
    for i in range(1, n + 1):
        total += i
    return total

# Solución 2: Matemática (O(1))
def suma_formula(n):
    return n * (n + 1) // 2
```

Ambos métodos funcionan, pero uno requiere recorrer todos los números (O(n))  
y el otro **usa una fórmula directa** (O(1)).

> El diseño de algoritmos es el arte de **resolver un problema de la mejor forma posible**.



""",
    pageNumber = 1
)

val DivideAndConquerPage = PageData(
    id = 100,
    content = """
El paradigma de **divide y vencerás** consiste en **dividir un problema grande** en partes más pequeñas,  
resolver cada parte por separado y luego **combinar los resultados**.

### **1. Etapas principales**

1. **Dividir:** el problema se fragmenta en subproblemas más pequeños.
    
2. **Conquistar:** se resuelve cada subproblema (normalmente de forma recursiva).
    
3. **Combinar:** se unen los resultados en una solución final.
    


### **2. Ejemplo clásico: Buscar el máximo valor**

```python
def maximo(lista):
    if len(lista) == 1:
        return lista[0]
    mitad = len(lista) // 2
    izq = maximo(lista[:mitad])
    der = maximo(lista[mitad:])
    return izq if izq > der else der
```

El algoritmo **divide la lista a la mitad** hasta que queda un solo elemento,  
y luego **combina** los resultados comparando valores.

🧩 Complejidad: **O(n)**  
Cada elemento se compara una vez, aunque el proceso sea recursivo.


### **3. Ejemplo más complejo: Merge Sort**

```python
def merge_sort(lista):
    if len(lista) <= 1:
        return lista
    mitad = len(lista) // 2
    izquierda = merge_sort(lista[:mitad])
    derecha = merge_sort(lista[mitad:])
    return fusionar(izquierda, derecha)

def fusionar(izq, der):
    resultado = []
    while izq and der:
        if izq[0] < der[0]:
            resultado.append(izq.pop(0))
        else:
            resultado.append(der.pop(0))
    return resultado + izq + der
```

🧩 Complejidad: **O(n log n)**  
→ Divide el problema log(n) veces y combina en tiempo lineal.

Divide y vencerás es ideal cuando puedes **fragmentar el problema naturalmente**, como en búsquedas o ordenamientos.

""",
    pageNumber = 2
)

val GreedyAlgorithmsPage = PageData(
    id = 101,
    content = """
Los algoritmos **greedy (voraces)** toman **la mejor decisión posible en cada paso**,  
esperando que esas decisiones locales conduzcan a la solución global óptima.

### **1. Idea central**

> “Haz siempre lo que parece mejor ahora.”

No revisa todo el conjunto ni guarda resultados anteriores;  
simplemente **elige la mejor opción inmediata**.


### **2. Ejemplo clásico: Cambio de monedas**

Supongamos que queremos devolver cambio con el **menor número de monedas posible**.

```python
def cambio(monedas, cantidad):
    monedas.sort(reverse=True)
    resultado = []
    for moneda in monedas:
        while cantidad >= moneda:
            cantidad -= moneda
            resultado.append(moneda)
    return resultado

print(cambio([10, 5, 1], 28))
```

```txt
Output:
[10, 10, 5, 1, 1, 1]
```

🧩 Complejidad: **O(n)**  
Funciona si las monedas tienen una **relación uniforme** (como las del ejemplo).  
Pero puede fallar con sistemas irregulares.


### **3. Otros ejemplos de algoritmos voraces**

|Problema|Estrategia Greedy|
|---|---|
|Caminos mínimos|Elige siempre la arista más corta (Dijkstra).|
|Selección de actividades|Elige la que termina más temprano.|
|Compresión de datos|Huffman usa la frecuencia mínima.|

Los algoritmos greedy son **rápidos y simples**, aunque **no siempre óptimos**.


""",
    pageNumber = 3
)

val DynamicProgrammingPage = PageData(
    id = 102,
    content = """
La **programación dinámica (DP)** se usa cuando un problema puede **dividirse en subproblemas repetidos**.  
Guarda los resultados ya calculados para **evitar repetir trabajo**.

### **1. Idea base**

> “Resuelve cada subproblema una sola vez y reutiliza su resultado.”

### **2. Ejemplo: Fibonacci**

#### Versión recursiva (ineficiente)

```python
def fib(n):
    if n <= 1:
        return n
    return fib(n - 1) + fib(n - 2)
```

🧩 Complejidad: **O(2ⁿ)**  
Repite cálculos muchas veces.

#### Versión con Programación Dinámica

```python
def fib_dp(n):
    memo = [0, 1]
    for i in range(2, n + 1):
        memo.append(memo[i-1] + memo[i-2])
    return memo[n]
```

🧩 Complejidad: **O(n)**  
Guarda los resultados previos y los reutiliza.

### **3. Tipos de DP**

|Tipo|Descripción|
|---|---|
|**Bottom-up**|Se construye desde los casos base hacia arriba (iterativo).|
|**Top-down (memoization)**|Se usa recursión y se almacenan resultados en caché.|

La programación dinámica se aplica a problemas **complejos pero estructurados**,  
como rutas, optimización de recursos o secuencias.

""",
    pageNumber = 4
)

val RecursionPage = PageData(
    id = 103,
    content = """
Un algoritmo **recursivo** es aquel que **se llama a sí mismo** para resolver versiones más pequeñas del mismo problema.

### **1. Requisitos de la recursión**

1. **Caso base:** detiene la recursión.
    
2. **Caso recursivo:** llama a la función con una versión reducida del problema.
    

### **2. Ejemplo: Factorial**

```python
def factorial(n):
    if n == 0:
        return 1
    return n * factorial(n - 1)
```

🧩 `factorial(5)` → 5 × 4 × 3 × 2 × 1 = 120

Cada llamada queda **en pausa** hasta que el caso base se cumple,  
luego se resuelven en orden inverso.

### **3. Ventajas y desventajas**

|Ventaja|Desventaja|
|---|---|
|Código más limpio y legible.|Mayor consumo de memoria (pila).|
|Ideal para problemas que se dividen naturalmente.|Riesgo de recursión infinita sin caso base.|

### **4. Ejemplo adicional: Suma recursiva**

```python
def suma_recursiva(lista):
    if not lista:
        return 0
    return lista[0] + suma_recursiva(lista[1:])
```

🧩 Complejidad: **O(n)**  
Cada llamada resuelve una parte y delega el resto.


> La recursividad no solo es elegante, sino que también **permite expresar ideas complejas de forma natural**, como árboles, fractales o recorridos jerárquicos.
""",
    pageNumber = 5
)

// Section id = 18

val WhyArrangePage = PageData(
    id = 104,
    content = """## **Página 1: El problema — ¿Por qué ordenar?**

Ordenar datos es una de las operaciones más comunes en la programación.  
Muchos problemas —como buscar, clasificar, o analizar información— requieren que los datos estén **ordenados** para ser más eficientes.

### **1. Ejemplo simple**

Supongamos que tienes una lista de nombres:

```python
nombres = ["Carlos", "Ana", "Lumin", "Beatriz"]
```

Si están desordenados, **buscar o comparar** elementos puede ser lento.  
Pero si están ordenados alfabéticamente, puedes usar algoritmos **rápidos y predecibles**, como la **búsqueda binaria (O(log n))**.

### **2. Tipos de ordenamiento**

|Tipo|Descripción|
|---|---|
|**Ascendente**|De menor a mayor (`[1, 2, 3, 4]`)|
|**Descendente**|De mayor a menor (`[4, 3, 2, 1]`)|
|**Personalizado**|Según una regla definida (por ejemplo, por longitud de palabra)|

### **3. Objetivo de los algoritmos de ordenación**

- Reorganizar los elementos de forma eficiente.
    
- Minimizar el número de comparaciones e intercambios.
    
- Adaptarse al tamaño de los datos.
    

Existen muchos métodos, pero todos buscan **equilibrar simplicidad y rendimiento**.



""",
    pageNumber = 1
)

val BubbleSortPage = PageData(
    id = 105,
    content = """## **Página 2: Ordenamiento Burbuja (Bubble Sort): El ineficiente**

El **ordenamiento burbuja** compara **pares de elementos adyacentes**  
y los intercambia si están en el orden incorrecto.  
Repite el proceso hasta que la lista esté ordenada.

### **1. Ejemplo paso a paso**

```python
def bubble_sort(lista):
    n = len(lista)
    for i in range(n):
        for j in range(0, n - i - 1):
            if lista[j] > lista[j + 1]:
                lista[j], lista[j + 1] = lista[j + 1], lista[j]
    return lista

print(bubble_sort([5, 3, 8, 2]))
```

```txt
Output:
[2, 3, 5, 8]
```

### **2. Visualización del proceso**

Cada pasada “empuja” el elemento más grande al final,  
como una burbuja que sube a la superficie.

|Iteración|Lista|Comparaciones|
|---|---|---|
|1|[3, 5, 2, 8]|3|
|2|[3, 2, 5, 8]|2|
|3|[2, 3, 5, 8]|1|

### **3. Complejidad**

|Caso|Complejidad|
|---|---|
|Mejor (ya ordenado)|O(n)|
|Promedio / Peor|O(n²)|

🧩 **Inconveniente:** Muy lento para grandes listas.  
🧩 **Ventaja:** Fácil de entender y programar.


""",
    pageNumber = 2
)

val SelectionSortPage = PageData(
    id = 106,
    content = """## **Página 3: Ordenamiento por Selección (Selection Sort)**

El **ordenamiento por selección** busca el **menor elemento** en cada pasada  
y lo coloca en la posición correcta.

### **1. Ejemplo en código**

```python
def selection_sort(lista):
    n = len(lista)
    for i in range(n):
        min_index = i
        for j in range(i + 1, n):
            if lista[j] < lista[min_index]:
                min_index = j
        lista[i], lista[min_index] = lista[min_index], lista[i]
    return lista

print(selection_sort([29, 10, 14, 37, 13]))
```

```txt
Output:
[10, 13, 14, 29, 37]
```

### **2. Proceso**

1. Encuentra el mínimo en el resto de la lista.
    
2. Intercámbialo con el primer elemento no ordenado.
    
3. Repite hasta ordenar todos.
    

|Iteración|Lista|Mínimo encontrado|
|---|---|---|
|1|[10, 29, 14, 37, 13]|10|
|2|[10, 13, 14, 37, 29]|13|
|3|[10, 13, 14, 37, 29]|14|

### **3. Complejidad**

|Caso|Complejidad|
|---|---|
|Todos los casos|O(n²)|

🧩 **Ventaja:** Sencillo, menos intercambios que Bubble Sort.  
🧩 **Desventaja:** No mejora con listas parcialmente ordenadas.


""",
    pageNumber = 3
)

val InsertionSortPage = PageData(
    id = 107,
    content = """## **Página 4: Ordenamiento por Inserción (Insertion Sort)**

El **ordenamiento por inserción** construye una lista ordenada **insertando un elemento a la vez**  
en la posición correcta.

### **1. Ejemplo**

```python
def insertion_sort(lista):
    for i in range(1, len(lista)):
        actual = lista[i]
        j = i - 1
        while j >= 0 and lista[j] > actual:
            lista[j + 1] = lista[j]
            j -= 1
        lista[j + 1] = actual
    return lista

print(insertion_sort([9, 5, 1, 4, 3]))
```

```txt
Output:
[1, 3, 4, 5, 9]
```

### **2. Cómo funciona**

1. Toma el segundo elemento como “llave”.
    
2. Lo compara con los anteriores.
    
3. Lo inserta donde corresponde.
    
4. Repite con el siguiente.
    

### **3. Complejidad**

|Caso|Complejidad|
|---|---|
|Mejor (ya ordenado)|O(n)|
|Promedio / Peor|O(n²)|

🧩 Ideal para **listas pequeñas o casi ordenadas**.  
🧩 Se usa como base en algoritmos más avanzados (como Timsort en Python).


""",
    pageNumber = 4
)

val MergeSortPage = PageData(
    id = 108,
    content = """## **Página 5: Merge Sort — El método de “Divide y Vencerás”**

**Merge Sort** usa el paradigma **Divide y Vencerás**.  
Divide la lista a la mitad, ordena cada parte y luego **fusiona** ambas listas ordenadas.

### **1. Ejemplo en código**

```python
def merge_sort(lista):
    if len(lista) <= 1:
        return lista
    mitad = len(lista) // 2
    izquierda = merge_sort(lista[:mitad])
    derecha = merge_sort(lista[mitad:])
    return fusionar(izquierda, derecha)

def fusionar(a, b):
    resultado = []
    while a and b:
        if a[0] < b[0]:
            resultado.append(a.pop(0))
        else:
            resultado.append(b.pop(0))
    return resultado + a + b
```

```python
print(merge_sort([38, 27, 43, 3, 9, 82, 10]))
```

```txt
Output:
[3, 9, 10, 27, 38, 43, 82]
```

### **2. Complejidad**

|Caso|Complejidad|
|---|---|
|Todos los casos|O(n log n)|

🧩 **Ventaja:** Muy estable y eficiente.  
🧩 **Desventaja:** Usa más memoria al dividir listas.


""",
    pageNumber = 5
)

val QuickSortPage = PageData(
    id = 109,
    content = """## **Página 6: Quick Sort — El poder del “pivote”**

**Quick Sort** también usa “Divide y Vencerás”,  
pero elige un **pivote** y **reorganiza** los elementos según él.

### **1. Ejemplo**

```python
def quick_sort(lista):
    if len(lista) <= 1:
        return lista
    pivote = lista[len(lista)//2]
    menores = [x for x in lista if x < pivote]
    iguales = [x for x in lista if x == pivote]
    mayores = [x for x in lista if x > pivote]
    return quick_sort(menores) + iguales + quick_sort(mayores)

print(quick_sort([10, 7, 8, 9, 1, 5]))
```

```txt
Output:
[1, 5, 7, 8, 9, 10]
```

### **2. Proceso**

1. Elige un pivote.
    
2. Divide los elementos menores y mayores.
    
3. Ordena cada parte recursivamente.
    

### **3. Complejidad**

|Caso|Complejidad|
|---|---|
|Promedio|O(n log n)|
|Peor (pivote malo)|O(n²)|

🧩 **Ventaja:** Muy rápido en la práctica.  
🧩 **Desventaja:** Depende de la elección del pivote.


""",
    pageNumber = 6
)

val BuiltinSortFunctionsPage = PageData(
    id = 110,
    content = """## **Página 7: sort() y sorted(): Cómo lo hace Python**

Python tiene funciones integradas para ordenar listas,  
y ambas se basan en un algoritmo optimizado llamado **Timsort** (mezcla de Merge Sort e Insertion Sort).

### **1. Diferencia entre `sort()` y `sorted()`**

|Función|Modifica la lista|Devuelve nueva lista|
|---|---|---|
|`sort()`|✅ Sí|❌ No|
|`sorted()`|❌ No|✅ Sí|

### **2. Ejemplo**

```python
numeros = [4, 2, 9, 1]
numeros.sort()
print(numeros)
```

```txt
Output:
[1, 2, 4, 9]
```

```python
nombres = ["Lumin", "Ana", "Carlos"]
nueva_lista = sorted(nombres, reverse=True)
print(nueva_lista)
```

```txt
Output:
['Lumin', 'Carlos', 'Ana']
```

### **3. Clave personalizada**

```python
palabras = ["Python", "es", "genial"]
ordenadas = sorted(palabras, key=len)
print(ordenadas)
```

```txt
Output:
['es', 'Python', 'genial']
```

🧩 Timsort combina la **velocidad de QuickSort** con la **estabilidad de MergeSort**,  
alcanzando una complejidad de **O(n log n)** en la mayoría de los casos.
""",
    pageNumber = 7
)

// Section id = 19

val ProblemFindPage = PageData(
    id = 111,
    content = """## **Página 1: El problema — Encontrar una aguja en un pajar**

Buscar un elemento dentro de una colección es una de las operaciones **más comunes y críticas** en la programación.  
Desde localizar un nombre en una lista hasta identificar un registro en una base de datos, **los algoritmos de búsqueda** son esenciales.

### **1. Objetivo**

Encontrar si un elemento **existe o no**, y en algunos casos, **su posición** dentro de la colección.

```python
nombres = ["Ana", "Luis", "Carlos", "Lumin"]
# ¿Está "Lumin" en la lista?
```

Podemos responder esa pregunta con diferentes estrategias,  
algunas más rápidas que otras dependiendo del **orden y tamaño de los datos**.


### **2. Tipos de búsqueda**

|Tipo|Requisitos|Complejidad promedio|
|---|---|---|
|**Lineal**|Ninguno (lista desordenada).|O(n)|
|**Binaria**|Lista ordenada.|O(log n)|
|**Hash / Diccionario**|Estructura de clave-valor.|O(1)|

Cada una tiene ventajas según el contexto.  
Veámoslas una por una.



""",
    pageNumber = 1
)

val LinearSearchPage = PageData(
    id = 112,
    content = """## **Página 2: Búsqueda Lineal — El método simple (O(n))**

La **búsqueda lineal** revisa **cada elemento uno por uno**,  
hasta encontrar el valor buscado o llegar al final de la lista.

### **1. Ejemplo en código**

```python
def busqueda_lineal(lista, valor):
    for i in range(len(lista)):
        if lista[i] == valor:
            return i  # Devuelve la posición
    return -1  # No encontrado

print(busqueda_lineal([4, 2, 9, 7], 9))
```

```txt
Output:
2
```

### **2. Análisis**

- Si el elemento está al principio → rápido.
    
- Si está al final → lento.
    
- Si no está → se revisa todo.
    

🧩 **Complejidad temporal:** O(n)  
🧩 **Complejidad espacial:** O(1)



### **3. Ejemplo visual**

|Lista|Valor buscado|Pasos|
|---|---|---|
|[3, 8, 5, 1]|8|2|
|[3, 8, 5, 1]|1|4|
|[3, 8, 5, 1]|9|4|



### **4. En Python**

Python ya incluye una forma rápida de hacer búsqueda lineal:

```python
nombres = ["Ana", "Carlos", "Lumin"]
print("Lumin" in nombres)
```

```txt
Output:
True
```


""",
    pageNumber = 2
)

val BinarySearchPage = PageData(
    id = 113,
    content = """## **Página 3: Búsqueda Binaria — El poder de los datos ordenados (O(log n))**

La **búsqueda binaria** es mucho más eficiente,  
pero **requiere que los datos estén ordenados**.  
Divide la lista a la mitad y descarta la mitad donde el valor no puede estar.



### **1. Ejemplo en código**

```python
def busqueda_binaria(lista, valor):
    inicio = 0
    fin = len(lista) - 1

    while inicio <= fin:
        medio = (inicio + fin) // 2
        if lista[medio] == valor:
            return medio
        elif lista[medio] < valor:
            inicio = medio + 1
        else:
            fin = medio - 1
    return -1
```

```python
print(busqueda_binaria([1, 3, 5, 7, 9], 7))
```

```txt
Output:
3
```



### **2. Visualización paso a paso**

|Paso|Rango|Elemento medio|Acción|
|---|---|---|---|
|1|[1, 3, 5, 7, 9]|5|7 > 5 → busca derecha|
|2|[7, 9]|7|Encontrado ✅|



### **3. Complejidad**

|Caso|Comparaciones|Complejidad|
|---|---|---|
|Mejor|1|O(1)|
|Promedio / Peor|log₂(n)|O(log n)|

🧩 **Ventaja:** Muy rápido con grandes volúmenes de datos.  
🧩 **Desventaja:** Solo sirve con listas ordenadas.


""",
    pageNumber = 3
)

val BinarySearchRequirementPage = PageData(
    id = 114,
    content = """## **Página 4: El requisito de la Búsqueda Binaria**

Para aplicar la búsqueda binaria correctamente, los datos deben estar **ordenados** previamente.  
Si no lo están, la división del rango no tiene sentido.

### **1. Ejemplo del error**

```python
# Lista no ordenada
lista = [9, 3, 5, 1, 7]
print(busqueda_binaria(lista, 5))  # Resultado incorrecto
```

La búsqueda binaria asume que los valores están en orden ascendente.  
En este ejemplo, el resultado puede ser erróneo o inexistente.


### **2. Solución correcta**

Primero ordena la lista antes de buscar:

```python
lista = [9, 3, 5, 1, 7]
lista.sort()
print(busqueda_binaria(lista, 5))
```

```txt
Output:
2
```

🧩 La búsqueda binaria depende completamente del **orden de los datos**.


### **3. En Python con el módulo `bisect`**

Python ofrece una herramienta optimizada para búsqueda binaria:

```python
import bisect

lista = [1, 3, 4, 7, 9]
pos = bisect.bisect_left(lista, 7)
print(pos)
```

```txt
Output:
3
```

`bisect` puede encontrar e insertar elementos **manteniendo el orden** de forma eficiente.


""",
    pageNumber = 4
)

val HashTablesPage = PageData(
    id = 115,
    content = """## **Página 5: Tablas Hash — La magia de O(1) (Diccionarios)**

Las **tablas hash** son estructuras que permiten **buscar datos casi instantáneamente**,  
gracias al uso de **claves únicas**.

En Python, los **diccionarios (`dict`)** usan este principio internamente.


### **1. Ejemplo simple**

```python
telefonos = {
    "Ana": 1234,
    "Carlos": 5678,
    "Lumin": 9999
}

print(telefonos["Lumin"])
```

```txt
Output:
9999
```

- Buscar un valor **no requiere recorrer toda la estructura**.
    
- Python calcula un **hash** (identificador único) de la clave y accede directamente a la posición.
    


### **2. Operaciones típicas**

|Operación|Complejidad|
|---|---|
|Buscar clave|O(1)|
|Insertar|O(1)|
|Eliminar|O(1)|
|Recorrer todo|O(n)|


### **3. Ejemplo de inserción y búsqueda**

```python
diccionario = {}
diccionario["nombre"] = "Lumin"
diccionario["edad"] = 20

print("edad" in diccionario)  # Buscar clave
print(diccionario.get("nombre"))
```

```txt
Output:
True
Lumin
```


### **4. Ventajas de las tablas hash**

- Acceso instantáneo a los elementos.
    
- No necesitan datos ordenados.
    
- Implementadas en estructuras modernas (bases de datos, caches, sets, etc.).
    

🧩 **Desventaja:** Consumen más memoria que una lista simple.


> Las tablas hash son el **punto máximo de eficiencia en búsquedas**,  
> alcanzando un tiempo promedio constante: **O(1)**.
""",
    pageNumber = 5
)

// Section id = 20

val CongratulationsPage = PageData(
    id = 116,
    content = """## **Página 1: ¡Felicitaciones, completaste la ruta!**

Llegar hasta aquí significa que ya dominas las bases más sólidas de la programación:

- Comprendes cómo funcionan los algoritmos.
    
- Sabes analizar su eficiencia con **Notación Big O**.
    
- Has aprendido a diseñar soluciones optimizadas y escalables.
    
- Y entiendes cómo aplicar estructuras de datos de forma lógica.
    

👏 ¡Has pasado de **escribir código** a **pensar como un programador profesional**!


### **¿Qué lograste con este nivel avanzado?**

- Pensar en términos de **eficiencia y rendimiento**.
    
- Aplicar paradigmas de diseño como **Divide y Vencerás** o **Programación Dinámica**.
    
- Comprender **cómo y por qué** funcionan los algoritmos más usados.
    
- Prepararte para **problemas más grandes y reales**.
    

### **El siguiente paso**

Ahora comienza la etapa más divertida: **crear, explorar y especializarte**.  
Python es un lenguaje enorme y poderoso, con caminos muy distintos según tus intereses.

A continuación descubrirás **las principales rutas** que puedes seguir.

""",
    pageNumber = 1
)

val PythonEcosystemPage = PageData(
    id = 117,
    content = """## **Página 2: El Ecosistema de Python — ¿Qué más hay?**

Python es mucho más que un lenguaje de programación:  
es un **ecosistema** lleno de librerías, herramientas y comunidades.


### **1. Áreas principales donde se usa Python**

|Área|Descripción|Librerías clave|
|---|---|---|
|**Desarrollo web**|Construcción de sitios y APIs.|Flask, Django, FastAPI|
|**Ciencia de datos**|Análisis, visualización y predicción.|Pandas, NumPy, Matplotlib|
|**Inteligencia artificial**|Redes neuronales, machine learning.|TensorFlow, PyTorch|
|**Automatización y scripting**|Tareas repetitivas, bots, utilidades.|os, sys, Selenium|
|**Ciberseguridad y hacking ético**|Análisis y automatización de ataques.|Scapy, Requests|

### **2. Ecosistema de herramientas**

- **Gestores de paquetes:** `pip`, `poetry`
    
- **Entornos virtuales:** `venv`, `conda`
    
- **Versionado:** Git y GitHub
    
- **Pruebas:** `pytest`, `unittest`
    

Python es un universo con miles de librerías open-source.  
Saber explorar su ecosistema te convierte en un desarrollador completo.


""",
    pageNumber = 2
)

val PathOnePage = PageData(
    id = 118,
    content = """## **Página 3: Camino 1 — Desarrollo Web (Flask y Django)**

Si te apasiona **crear aplicaciones y APIs**, este es tu camino.

### **1. Flask — minimalista y flexible**

```python
from flask import Flask
app = Flask(__name__)

@app.route("/")
def inicio():
    return "Hola, mundo desde Flask!"
```

```txt
Output:
Hola, mundo desde Flask!
```

- Ideal para proyectos pequeños y APIs rápidas.
    
- Te enseña conceptos de **rutas, peticiones y respuestas**.
    


### **2. Django — completo y estructurado**

```python
# views.py
from django.http import HttpResponse

def inicio(request):
    return HttpResponse("Hola desde Django!")
```

- Incluye **ORM, autenticación, panel de administración y plantillas**.
    
- Perfecto para proyectos grandes o comerciales.
    


🧩 Si te gusta **construir cosas visibles**, el **desarrollo web** es tu mejor opción.  
Te permitirá conectar la lógica que ya dominas con el mundo real.

""",
    pageNumber = 3
)

val PathTwoPage = PageData(
    id = 119,
    content = """## **Página 4: Camino 2 — Ciencia de Datos e Inteligencia Artificial**

Si disfrutas **trabajar con números, gráficos o patrones**,  
este es el terreno más emocionante del ecosistema Python.


### **1. Ciencia de Datos**

Analizar información para obtener conocimiento útil.

```python
import pandas as pd

datos = pd.DataFrame({
    "Nombre": ["Lumin", "Ana", "Carlos"],
    "Edad": [20, 25, 22]
})

print(datos.describe())
```

```txt
Output:
       Edad
count   3.0
mean   22.3
```

- Librerías clave: **Pandas**, **NumPy**, **Matplotlib**
    
- Aprenderás limpieza, análisis y visualización de datos.
    


### **2. Inteligencia Artificial y Machine Learning**

```python
from sklearn.linear_model import LinearRegression
import numpy as np

x = np.array([[1], [2], [3]])
y = np.array([2, 4, 6])

modelo = LinearRegression()
modelo.fit(x, y)
print(modelo.predict([[4]]))
```

```txt
Output:
[8.]
```

🧠 Aquí Python se usa para **entrenar máquinas**, reconocer patrones y hacer predicciones.

""",
    pageNumber = 4
)

val PathThreePage = PageData(
    id = 120,
    content = """## **Página 5: Camino 3 — Scripting y Automatización**

La **automatización** es el alma de la productividad.  
Python puede hacer tareas por ti: mover archivos, leer correos o controlar el navegador.


### **1. Ejemplo de automatización**

```python
import os

for archivo in os.listdir():
    if archivo.endswith(".txt"):
        print("Archivo encontrado:", archivo)
```

```txt
Output:
Archivo encontrado: notas.txt
```

### **2. Automatizar con tiempo**

```python
import time

print("Iniciando tarea...")
time.sleep(3)
print("Tarea completada ✅")
```

🧩 Ideal si te interesa **crear herramientas útiles** o **mejorar tu flujo de trabajo diario**.


### **3. Librerías comunes**

|Propósito|Librería|
|---|---|
|Control del sistema|os, sys|
|Web scraping|requests, BeautifulSoup|
|Automatización de navegador|selenium|
|Archivos y datos|csv, json, shutil|

""",
    pageNumber = 5
)

val NeverStopLearning = PageData(
    id = 121,
    content = """## **Página 6: Nunca pares de aprender — Proyectos y Comunidad**

La programación no termina cuando terminas un curso,  
**comienza cuando aplicas lo aprendido**.


### **1. Proyectos para practicar**

- Crear un **mini sistema de gestión de tareas**.
    
- Desarrollar un **analizador de texto** con Python.
    
- Simular un **ordenamiento visual** con animaciones.
    
- Hacer un **bot de Telegram o Discord**.
    

Estos proyectos refuerzan los conceptos de algoritmos, estructuras y eficiencia.


### **2. Participa en la comunidad**

- **GitHub:** Sube tus proyectos.
    
- **Stack Overflow:** Responde y aprende de otros.
    
- **Discord / Reddit / X:** Hay comunidades activas de Python.
    


### **3. Filosofía final**

> La meta no es aprender Python.  
> La meta es **aprender a pensar como un programador**.

Sigue explorando, construyendo y compartiendo tu conocimiento.  
Cada proyecto que crees será una nueva lección.

👏 ¡Felicitaciones! Has completado el **Nivel Avanzado de Programación con Python**.

""",
    pageNumber = 6
)