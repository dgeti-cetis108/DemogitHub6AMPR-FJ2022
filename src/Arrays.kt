/**
 * CETis108
 * Semestre: Febrero-Julio 2022
 * Asignatura: Desarrolla aplicaciones móviles
 * Profesor: Bidkar Aragón Cárdenas
 * Alumno(a): ?
 * Fecha: 01/03/22 9:27
 * Grupo: 6AM-PR Bloque A
 */


fun main() {
    println("Arrays en Kotlin")
    var nombres = Array<String>(2) { "sofia" }
    for (nombre in nombres)
        println(nombre)

    var numeros = Array<Int>(3) { 0 }

    var nombres2 = arrayOf("annia","aliky","mariana")
    //nombres2[0] = true
    var numeros2 = IntArray(5)
    var numeros3 = arrayOf(1,2,3,4,5,6)

    var mixed = arrayOf(true,"texto",'c',0.9,1.6f)
    println(mixed[0])
    mixed[0] = "lo que sea"
    println(mixed[0])

    println("size" +mixed.size)
    println(mixed.first())
    println(mixed.last())
    //mixed.sort()
    for (e in mixed)
        println(e)
}