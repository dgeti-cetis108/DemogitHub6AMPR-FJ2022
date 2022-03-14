/**
 * CETis108
 * Semestre: Febrero-Julio 2022
 * Asignatura: Desarrolla aplicaciones móviles
 * Profesor: Bidkar Aragón Cárdenas
 * Alumno(a): ?
 * Fecha: 01/03/22 11:17
 * Grupo: 6AM-PR Bloque A
 */


fun main() {
    // realiza un programa que pida nombres de personas
    // hasta que el nombre sea salir
    // almacena los nombres en un ArrayList de Strings
    var nombres = ArrayList<String>()
    while (true) {
        val nombre = pedirCadenaPorTeclado("Escribe un nombre")
        if (nombre.lowercase() == "salir")
            break
        nombres.add(nombre)
    }

    // muestra la cantidad de nombres registrados
    println("El total de nombres registrados es: ${nombres.size}")

    // imprime los nombres como fueron capturados
    println("lista de nombres tal cual fueron capturadas")
    for (n in nombres)
        println(n)
    println("---------------------------------------------")
    // ordena la lista alfabeticamente y no pierdas el orden
    val ordenado = nombres
    ordenado.sort()

    // imprime la lista ordenada
    println("lista de nombres ordenada")
    for (n in ordenado)
        println(n)
}