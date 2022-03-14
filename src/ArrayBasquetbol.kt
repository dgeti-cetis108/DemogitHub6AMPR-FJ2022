/**
 * CETis108
 * Semestre: Febrero-Julio 2022
 * Asignatura: Desarrolla aplicaciones móviles
 * Profesor: Bidkar Aragón Cárdenas
 * Alumno(a): ?
 * Fecha: 02/03/22 7:33
 * Grupo: 6AM-PR Bloque A
 */

/**
 * Realiza un programa que simule una temporada regular
 * y sus resultados de la liga magisterial de Guasave
 * que consta de n equipos y se juegan un total de
 * 2 vueltas, registra la información acerca de
 * Juegos Ganados, Perdidos, Jugados y Porcentaje
 * Porcentaje = Juegos Ganados / Juegos Jugados
 * por cada juego simulado imprime los protagonistas
 * Ej: [H] Equipo1 vs Equipo2 [V] => Gana Equipo1
 * imprime los resultados ordenados de mayor a menor porcentaje
 * utiliza las estructuras Array o ArrayList segun convenga
 */
var numeroDeEquipos: Int = 0
var nombresDeEquipos = ArrayList<String>()
var resultados = ArrayList<Array<Int>>()

fun main() {
    imprimirTitulo("liga magisterial de basquetbol guasave")
    inicializarTemporada()
    simularVueltaRegular()
    simularVueltaRegular()
    imprimirResultadosOriginales()
    imprimirResultadosOrdenados()
}

fun imprimirResultadosOrdenados() {
    imprimirTitulo("Resultados ordenados de la temporada regular")
    val resultadosOrdenados =
        resultados.sortedByDescending { r -> r[1] }
    for (rst in resultadosOrdenados) {
        val avg = rst[1].toFloat()/rst[0].toFloat()
        println("${nombresDeEquipos[rst[3]]} JJ:${rst[0]} JG:${rst[1]} " +
                "JP:${rst[2]} AVG:%.3f".format(avg))
    }
}

fun imprimirResultadosOriginales() {
    imprimirTitulo("Resultados originales de la temporada regular")
    for (rst in resultados) {
        val avg = rst[1].toFloat()/rst[0].toFloat()
        println("${nombresDeEquipos[rst[3]]} JJ:${rst[0]} JG:${rst[1]} " +
                "JP:${rst[2]} AVG:%.3f".format(avg))
    }
}

fun simularVueltaRegular() {
    for (c in 0 until numeroDeEquipos - 1) {
        for (v in c+1 until numeroDeEquipos) {
            print("[H] ${nombresDeEquipos[c]} vs ${nombresDeEquipos[v]} [V]")
            // registra juegos jugados
            resultados[c][0]++
            resultados[v][0]++

            // registra juegos ganados y perdidos (como mis alumnos de 6AM-PR)
            if ((1..2).random() == 1) {
                println(" => Gana ${nombresDeEquipos[c]}")
                resultados[c][1]++
                resultados[v][2]++
            } else {
                println(" => Gana ${nombresDeEquipos[v]}")
                resultados[v][1]++
                resultados[c][2]++
            }
        }
    }
}


fun inicializarTemporada() {
    var mensaje = "¿Cuantos equipos tiene la liga?"
    numeroDeEquipos = pedirEnteroPorTeclado(mensaje)
    for (i in 0 until numeroDeEquipos) {
        nombresDeEquipos.add(
            pedirCadenaPorTeclado("Nombre del equipo ${i + 1}")
        )
        resultados.add(arrayOf(0, 0, 0, i))
    }
}