/**
 * CETis108
 * Semestre: Febrero-Julio 2022
 * Asignatura: Desarrolla aplicaciones móviles
 * Profesor: Bidkar Aragón Cárdenas
 * Alumno(a): ?
 * Fecha: 04/03/22 7:26
 * Grupo: 6AM-PR Bloque A
 */

fun main() {
    val magisterial = Liga("liga magisterial de guasave")
    imprimirTitulo(magisterial.nombre)
    magisterial.inicializarTemporada()
    magisterial.simularVueltaRegular()
    magisterial.imprimirResultados()
}


fun demo() {
    val equipo = Equipo("CETis108")
    val equipo2 = Equipo("ETI")
    val equipo3 = Equipo("ET4")
    val liga = Liga("Magisterial de Guasave")
    liga.equipos.add(equipo)
    liga.equipos.add(equipo2)
    liga.equipos.add(equipo3)
    println("Numero de equipos: ${liga.equipos.size}")
}

class Liga {
    var nombre: String = ""
    var equipos = ArrayList<Equipo>()

    constructor(nombre: String) {
        this.nombre = nombre
    }

    fun inicializarTemporada() {
        var mensaje = "¿Cuantos equipos tiene la liga?"
        numeroDeEquipos = pedirEnteroPorTeclado(mensaje)
        for (n in 1..numeroDeEquipos) {
            this.equipos.add(
                Equipo(pedirCadenaPorTeclado("Nombre del equipo $n"))
            )
        }
    }

    fun simularVueltaRegular() {
        for (c in 0 until this.equipos.size - 1) {
            for (v in c + 1 until this.equipos.size) {
                print("[H] ${this.equipos[c].nombre} vs ${this.equipos[v].nombre} [V]")
                this.equipos[c].juegosJugados++
                this.equipos[v].juegosJugados++
                if ((1..2).random() == 1) {
                    println(" => Gana ${this.equipos[c].nombre}")
                    this.equipos[c].juegosGanados++
                    this.equipos[v].juegosPerdidos++
                } else {
                    println(" => Gana ${this.equipos[v].nombre}")
                    this.equipos[v].juegosGanados++
                    this.equipos[c].juegosPerdidos++
                }
            }
        }
    }

    fun imprimirResultados() {
        equipos.sortByDescending { r -> r.calcularAvg() }
        for (equipo in equipos) {
            println("${equipo.nombre} JJ:${equipo.juegosJugados} " +
                    "JG:${equipo.juegosGanados} " +
                    "JP:${equipo.juegosPerdidos} " +
                    "AVG:%.3f".format(equipo.calcularAvg()))
        }
    }
}

class Equipo {
    var nombre: String = ""
    var juegosJugados: Int = 0
    var juegosGanados: Int = 0
    var juegosPerdidos: Int = 0

    constructor(nombre: String) {
        this.nombre = nombre.uppercase()
    }

    fun calcularAvg(): Float {
        return juegosGanados.toFloat() / juegosJugados.toFloat()
    }
}