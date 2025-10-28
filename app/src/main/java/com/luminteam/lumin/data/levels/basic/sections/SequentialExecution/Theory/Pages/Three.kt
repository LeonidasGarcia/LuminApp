package com.luminteam.lumin.data.levels.basic.sections.SequentialExecution.Theory.Pages

import com.luminteam.lumin.data.PageData

val PageThree = PageData(
    pageNumber = 3,
    content = """
        # Tipos de Instrucciones

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
        
        Las instrucciones de control de flujo son esenciales, ya que un programa que solo se ejecuta secuencialmente es muy limitado. Estas serán exploradas en detalle en secciones posteriores.
    """.trimIndent()
)