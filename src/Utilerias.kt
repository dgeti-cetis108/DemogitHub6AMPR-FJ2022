import java.lang.NumberFormatException

/**
 * CETis108
 * Semestre: Febrero-Julio 2022
 * Asignatura: Desarrolla aplicaciones móviles
 * Profesor: Bidkar Aragón Cárdenas
 * Alumno(a): ?
 * Fecha: 25/02/22 7:26
 * Grupo: 6AM-PR Bloque A
 */


fun pedirCadenaPorTeclado(mensaje: String): String {
    println(mensaje)
    return readLine()!!
}

fun pedirEnteroPorTeclado(mensaje: String): Int {
    while (true) {
        try {
            println(mensaje)
            return readLine()!!.toInt()
        } catch (ex: NumberFormatException) {
            println("Error, el dato debe ser número entero")
        }
    }
}

fun pedirDoublePorTeclado(mensaje: String): Double {
    while (true) {
        try {
            println(mensaje)
            return readLine()!!.toDouble()
        } catch (ex: NumberFormatException) {
            println("Error, el dato debe ser número decimal")
        }
    }
}

fun pedirFloatPorTeclado(mensaje: String): Float {
    while (true) {
        try {
            println(mensaje)
            return readLine()!!.toFloat()
        } catch (ex: NumberFormatException) {
            println("Error, el dato debe ser número decimal")
        }
    }
}

fun imprimirTitulo(titulo: String) {
    println("-".repeat(60))
    println(titulo.uppercase())
    println("-".repeat(60))
}