package com.luminteam.lumin.data.levels.basic.sections.SequentialExecution.Theory.Pages

import com.luminteam.lumin.data.PageData

val PageFour = PageData(
    pageNumber = 4,
    content = """
        # Sintaxis y Errores

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

        En conclusión, la **ejecución secuencial** solo es posible si cada línea, desde la primera hasta la última, respeta rigurosamente la **sintaxis** del lenguaje.
    """.trimIndent()
)