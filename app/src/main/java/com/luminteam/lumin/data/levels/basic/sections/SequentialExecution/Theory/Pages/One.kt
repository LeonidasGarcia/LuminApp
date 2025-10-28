package com.luminteam.lumin.data.levels.basic.sections.SequentialExecution.Theory.Pages

import com.luminteam.lumin.data.PageData

val PageOne = PageData(
    pageNumber = 1,
    content = """
        # ¿Qué es un Programa?

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


        En las siguientes páginas, aprenderemos cómo la computadora ejecuta estas instrucciones de manera **secuencial**.
    """.trimIndent()
)