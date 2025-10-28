package com.luminteam.lumin.data.levels.basic.sections.SequentialExecution.Theory.Pages

import com.luminteam.lumin.data.PageData

val PageTwo = PageData(
    pageNumber = 2,
    content = """
        # Ejecución Secuencial

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

        En este caso, la Línea 2 se ejecuta _después_ de la Línea 1, lo que resulta en la pérdida del valor original `5`.
    """.trimIndent()
)