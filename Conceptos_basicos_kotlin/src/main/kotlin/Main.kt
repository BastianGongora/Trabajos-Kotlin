import kotlin.math.abs


fun main() {

    // Ejercicio notificaciones
    val morningNotification = 51
    val eveningNotification = 135
    println("------------------------******1*******------------------------")
    printNotificationSummary(morningNotification)
    printNotificationSummary(eveningNotification)

    // Ejercicio Entradas del Cine
    val child = 5
    val adult = 28
    val senior = 87

    val isMonday = true
    println("------------------------******2*******------------------------")
    println("The movie ticket price for a person aged $child is \$${ticketPrice(child, isMonday)}.")
    println("The movie ticket price for a person aged $adult is \$${ticketPrice(adult, isMonday)}.")
    println("The movie ticket price for a person aged $senior is \$${ticketPrice(senior, isMonday)}.")


    println("------------------------******3*******------------------------")
    // Conversor de temperatura

    printFinalTemperature(27.0, "Celsius", "Fahrenheit") { celsiusToFahrenheit(it) }
    printFinalTemperature(350.0, "Kelvin", "Celsius") { kelvinToCelsius(it) }
    printFinalTemperature(10.0, "Fahrenheit", "Kelvin") { fahrenheitToKelvin(it) }
    println("------------------------******4*******------------------------")

    val song1 = Song("Valley of the Damned", "DragonForce", 2003, 1500)
    val song2 = Song("Through the Fire and Flames", "DragonForce", 2006, 950)

    song1.printSongDescription()
    println("¿Es ${song1.title} popular? ${if (song1.isPopular) "Sí" else "No"}")

    song2.printSongDescription()
    println("¿Es ${song2.title} popular? ${if (song2.isPopular) "Sí" else "No"}")
}

/* 1. ---------------------    Notificaciones Móviles   --------------------------------------------

Por lo general, el teléfono te proporciona un resumen de las notificaciones.
En el código inicial que se proporciona en el siguiente fragmento de código, escribe un programa
que imprima el mensaje de resumen según la cantidad de notificaciones que recibiste.

El mensaje debe incluir lo siguiente:

La cantidad exacta de notificaciones cuando haya menos de 100
99+ como cantidad de notificaciones cuando haya 100 o más

Completa la función printNotificationSummary() para que el programa imprima estas líneas:

You have 51 notifications.
Your phone is blowing up! You have 99+ notifications.

*/

fun printNotificationSummary(numberOfMessages: Int) {
    if (numberOfMessages < 100) {
        println("You have $numberOfMessages notifications.")
    } else {
        println("Your phone is blowing up! You have 99+ notifications.")
    }

}


/**  2) ------------------------  PRECIO DE LA ENTRADA DE CINE -------------------------------

 *  Las entradas de cine suelen tener un precio diferente según la edad de los espectadores.
 *
 * En el código inicial que se proporciona en el siguiente fragmento de código, escribe un programa que calcule los
 * precios de estas entradas basados en la edad:
 *
 * -> Un precio de entrada infantil de USD 15 para personas de 12 años o menos.
 * -> Un precio de entrada estándar de USD 30 para personas de entre 13 y 60 años. Los lunes, un precio estándar
 * con descuento de USD 25 para el mismo grupo etario.
 * -> Un precio para adultos mayores de USD 20 para personas de 61 años o más (asumimos que la edad máxima de un espectador es de 100 años)
 * -> Un valor de -1 para indicar que el precio no es válido cuando un usuario ingresa una edad fuera de las especificaciones
 *
 *
 *  Completa la función ticketPrice() para que el programa imprima estas líneas:
 *
 *  The movie ticket price for a person aged 5 is $15.
 *  The movie ticket price for a person aged 28 is $25.
 *  The movie ticket price for a person aged 87 is $20.
 */

fun ticketPrice(age: Int, isMonday: Boolean): Int {
    // Fill in the code.
    return when {
        age <= 12 -> 15
        age in 13..60 -> if (isMonday) 25 else 30
        age in 61..100 -> 20
        else -> -1
    }

}

/** 3)  -------------        Conversor de temperatura ------------------------------------
 *
 *En el mundo, se usan tres escalas de temperatura principales: Celsius, Fahrenheit y Kelvin.
 *
 * En el código inicial que se proporciona en el siguiente fragmento de código,
 * escribe un programa que convierta una temperatura de una escala a otra con estas fórmulas:
 *
 * -> De grados Celsius a Fahrenheit: °F = 9/5 (°C) + 32
 * -> Kelvin a Celsius: °C = K - 273.15
 * -> De Fahrenheit a Kelvin: K = 5/9 (°F - 32) + 273.15
 *
 * Ten en cuenta que el método String.format("%.2f", /* measurement */ )
 * se usa para convertir un número en un tipo String con 2 decimales.
 *
 * Completa la función main() para que llame a la función printFinalTemperature() e imprima las siguientes líneas.
 * Debes pasar argumentos para la fórmula de conversión y temperatura.
 *
 * Sugerencia: Te recomendamos usar valores Double para evitar el truncamiento de Integer durante las operaciones de división.
 *
 *  27.0 degrees Celsius is 80.60 degrees Fahrenheit.
 *  350.0 degrees Kelvin is 76.85 degrees Celsius.
 *  10.0 degrees Fahrenheit is 260.93 degrees Kelvin.
 *
 */

fun printFinalTemperature(
    initialMeasurement: Double,
    initialUnit: String,
    finalUnit: String,
    conversionFormula: (Double) -> Double
) {
    val finalMeasurement = String.format("%.2f", conversionFormula(initialMeasurement)) // two decimal places
    println("$initialMeasurement degrees $initialUnit is $finalMeasurement degrees $finalUnit.")
}
fun celsiusToFahrenheit(celsius: Double): Double {
    return (9.0 / 5.0 * celsius) + 32
}

fun kelvinToCelsius(kelvin: Double): Double {
    return kelvin - 273.15
}

fun fahrenheitToKelvin(fahrenheit: Double): Double {
    return (5.0 / 9.0 * (fahrenheit - 32)) + 273.15
}

/** 4. Catálogo de canciones
Imagina que necesitas crear una app de reproducción de música.

Crea una clase que pueda representar la estructura de una canción. La clase Song debe incluir estos elementos de código:

Propiedades para el título, el artista, el año de publicación y el recuento de reproducciones
Propiedad que indica si la canción es popular (si el recuento de reproducciones es inferior a 1,000, considera que es poco popular)
Un método para imprimir la descripción de una canción en este formato:

"[Título], interpretada por [artista], se lanzó en [año de lanzamiento]".
 *
 */
class Song(
    val title: String,
    val artist: String,
    val yearReleased: Int,
    var playCount: Int
) {
    val isPopular: Boolean
        get() = playCount < 1000

    fun printSongDescription() {
        println("$title, interpretada por $artist, se lanzó en $yearReleased.")
    }
}