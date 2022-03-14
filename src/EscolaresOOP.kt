/**
 * CETis108
 * Semestre: Febrero-Julio 2022
 * Asignatura: Desarrolla aplicaciones móviles
 * Profesor: Bidkar Aragón Cárdenas
 * Alumno(a): ?
 * Fecha: 08/03/22 10:08
 * Grupo: 6AM-PR Bloque A
 */

/**
 * Alumnos inscritos a un periodo semestral
 * los periodos semestrales se representan por el
 * primer año del ciclo seguido de -1 o -2 segun sea el caso
 * Ej: 2021-2 -> Febrero-Julio 2022
 * Ej: 2021-1 -> Agosto 2021 - Enero 2022
 * Los periodos semestral constan de 16 semanas
 *
 * Los alumnos son agrupados por semestre, turno, carrera y letra grupal
 * Ej: Semestre=6 Turno=Matutino Carrera=Programacion Letra=A
 * Ej: 6AM-PR
 *
 * Los alumnos cursan materias, las cuales tienen un determinado
 * numero de horas al semestre
 * Ej: Desarrollo de aplicaiones Android=96 horas al semestre
 * para acreditar una materia el alumno debe tener un promedio minimo
 * de 6 semestral, dividido en tres calificaciones parciales y tres
 * asistencias parciales
 *
 * Realiza un programa que permita imprimir la boleta de un alumno
 * que incluya los datos del plantel (nombre y clave)
 * datos del alumno (nombre, apellidos, grupo, periodo, carrera, no control)
 * datos de calificaciones (materia, tres parciales y tres asistencias)
 * al final una columna para el promedio de las calificaciones
 */
fun main() {
    val fj2022 = Periodo(
        "2021-2022",
        "2021-2",
        "Febrero-Julio 2022"
    )

    val programacion = Carrera("PR", "Programación")

    val sextoAMatutinoProgramacion = Grupo(
        "6AM-PR",
        6,
        'A',
        'M',
        programacion,
        fj2022
    )

    val ulises = Alumno(
        "Ulises",
        "del Corral🐷",
        "89723987297"
    )

    val nahomy = Alumno(
        "Nahomy",
        "Trejo",
        "76536752472"
    )

    val mariana = Alumno(
        "Mariana",
        "de los Angeles👼👼",
        "09387932747"
    )

    sextoAMatutinoProgramacion.alumnos.add(ulises)
    sextoAMatutinoProgramacion.alumnos.add(nahomy)
    sextoAMatutinoProgramacion.alumnos.add(mariana)

    val android = Materia("Desarrolla apps para Android", 96)
    val ios = Materia("Desarrolla apps para iOS", 96)

    val cal1 = Calificacion(ulises, android, sextoAMatutinoProgramacion)
    val cal2 = Calificacion(ulises, ios, sextoAMatutinoProgramacion)
    val cal3 = Calificacion(nahomy, android, sextoAMatutinoProgramacion)
    val cal4 = Calificacion(nahomy, ios, sextoAMatutinoProgramacion)
    val cal5 = Calificacion(mariana, android, sextoAMatutinoProgramacion)
    val cal6 = Calificacion(mariana, ios, sextoAMatutinoProgramacion)

    cal1.simularCalificacionYAsistencias()
    cal2.simularCalificacionYAsistencias()
    cal3.simularCalificacionYAsistencias()
    cal4.simularCalificacionYAsistencias()
    cal5.simularCalificacionYAsistencias()
    cal6.simularCalificacionYAsistencias()
}

class Alumno(
    var nombre: String,
    var apellidos: String,
    var numeroDeControl: String
) {}

class Periodo(
    var ciclo: String,
    var nombreCorto: String,
    var nombreLargo: String
) {}

class Grupo(
    var nombre: String,
    var semestre: Int,
    var letra: Char,
    var turno: Char,
    var carrera: Carrera,
    var periodo: Periodo
) {
    var alumnos = ArrayList<Alumno>()
}

class Carrera(
    var id: String,
    var nombre: String
) {}

class Calificacion(
    var alumno: Alumno,
    var materia: Materia,
    var grupo: Grupo
) {
    var parcial1: Float? = null
    var parcial2: Float? = null
    var parcial3: Float? = null
    var asistencia1: Int? = null
    var asistencia2: Int? = null
    var asistencia3: Int? = null

    fun promedio(): Float {
        return (parcial1!! + parcial2!! + parcial3!!) / 3
    }

    fun asistencias(): Int {
        return asistencia1!! + asistencia2!! + asistencia3!!
    }

    fun simularCalificacionYAsistencias() {
        parcial1 = (50..100).random().toFloat()/10
        parcial2 = (50..100).random().toFloat()/10
        parcial3 = (50..100).random().toFloat()/10
        asistencia1 = (25..32).random()
        asistencia2 = (25..32).random()
        asistencia3 = (25..32).random()
    }
}

class Materia(
    var nombre: String,
    var horas: Int
) {}

class Boleta(
    var alumno: Alumno,
    var grupo: Grupo
) {
    var calificaciones = ArrayList<Calificacion>()
}


class Alumno2 {
    var nombre: String = ""
    var apellidos: String = ""
    var numeroDeControl: String = ""

    constructor(nombre: String, apellidos: String, numeroDeControl: String) {
        this.nombre = nombre.uppercase()
        this.apellidos = apellidos
        this.numeroDeControl = numeroDeControl
    }
}