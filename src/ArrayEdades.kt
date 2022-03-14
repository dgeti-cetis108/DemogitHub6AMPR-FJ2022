/**
 * CETis108
 * Semestre: Febrero-Julio 2022
 * Asignatura: Desarrolla aplicaciones móviles
 * Profesor: Bidkar Aragón Cárdenas
 * Alumno(a): ?
 * Fecha: 01/03/22 10:36
 * Grupo: 6AM-PR Bloque A
 */


fun main() {
    // pedir la edad de n personas
    println("Edad de personas")
    var mensaje = "¿Cuantas personas vamos a entrevistar?"
    val numPersonas = pedirEnteroPorTeclado(mensaje)
    var sumaDeEdades = 0
    var edades = IntArray(numPersonas)

    // solicitar las edades y calcular el promedio de las mismas
    for (persona in 1..numPersonas) {
        mensaje = "¿Cual es la edad de la persona $persona?"
        edades[persona - 1] = pedirEnteroPorTeclado(mensaje)
        sumaDeEdades += edades[persona - 1]
    }
    val promedio = sumaDeEdades / numPersonas

    // contar cuantos son mayores y menores al promedio
    var mayores = 0
    var menores = 0
    for (edad in edades) {
        if (edad > promedio)
            mayores++
        else if (edad < promedio)
            menores++
    }

    // imprimir el resultado
    println("El promedio de edad es: $promedio")
    println("$mayores personas son mayores a la edad promedio")
    println("$menores personas son menores a la edad promedio")
}