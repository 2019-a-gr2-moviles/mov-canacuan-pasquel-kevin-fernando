import java.util.*

fun main(args: Array<String>) {

    /*
    * Comentario
    * */

    // Variables

    // QUE ES MUTAR?? CAMBIAR???
    // Mutables
    var nombre = "Adrian"
    nombre = "Vicente"
    // Inmutables
    val nombreI = "Adrian"
    // nombreI = "Vicente"

    // Tipos de Datos

    // val apellido = "Eguez"

    val apellido = "Eguez"
    val edad: Int = 29
    val sueldo: Double = 1.21
    val casado: Boolean = false
    val profesor: Boolean = true
    val hijos = null

    // Duck Typing
    // Si parace un pato
    // Si camina como pato
    // Si suena como pato
    // Si vuela como pato
    // PATO

    // Condicionales

    if (apellido == "Eguez" || nombre == "Adrian") {
        println("Verdadero")
    } else {
        println("Falso")
    }

    val tieneNombreYApellido = if (apellido != null && nombre != null) "ok" else "no"
    println(tieneNombreYApellido)
    estaJalado(1.0)
    estaJalado(8.0)
    estaJalado(0.0)
    estaJalado(7.0)
    estaJalado(10.0)
    holaMundo("Kevin")
    holaMundoAvanzado(2)
    val total = sumarDosNumeros(1,3)
    println(total)

    val arregloCumpleanos: Array<Int> = arrayOf(1,2,3,4)

    var arregloTodo: Array<Any> = arrayOf(1,"asd",10.2,true)

    arregloCumpleanos[0] = 5
    arregloCumpleanos.set(0,5)

    arregloTodo = arrayOf(5,2,3,4)

    val notas = arrayListOf(1,2,3,4,5,6)

    //notas.forEach { nota: Int ->
        // it -> variable siempre q esta disponible por defecto
        // se cambia el nombre de it a nota
        // ademas se tipa la nota
      //  println(nota)
    //}

    //MAP -> itera y modifica el arreglo
    val notasDos = notas.map { nota ->
        nota + 1
    }
    notasDos.forEach{
        println("Notas 2: $it")
    }

    // FOR EACH -> itera el arreglo
    notas.forEachIndexed { indice, nota ->
        println("Indice: $indice")
        println("Nota: $nota")
        //return Unit // -> xq no se devuelve nada
    }

    // Imapres + 2
    // Pares + 1
    val notasTres = notas.map{nota ->
        val modulo = nota % 2
        val esPar = 0
        when (modulo) {
            esPar -> {
                nota + 1
            }
            else -> {
                nota + 2
            }
        }
    }
    notasTres.forEach{
        println("Nota 3: $it")
    }


    //FILTER -> filtra el arreglo
    //Devolver los mayores a 2
    // Multiplicarlos * 2
    val respuestaFilter = notas.filter {
        it in 3..5
        // it > 2 && it < 6
    }
            .map {
                it * 2
            }
    respuestaFilter.forEach { println(it) }

    // ANY -> retorna un valor booleano si encuentra la coincidencia
    // Existe un elemente == 3 ?
    val novias = arrayListOf(1,2,2,3,4,5)
    val respuestaNovia = novias.any{
        it == 3
    }
    println(respuestaNovia)

    //ALL -> compara tooodos los valores
    val tazos = arrayListOf(1,2,3,4,5,6,7)
    val respuestaTazos = tazos.all {
        it > 1
    }
    println(respuestaTazos)

    //REDUCE ->
    // La suma de todos los tazos ?
    val totalTazos = tazos.reduce { valorAcumulado, tazo ->
        valorAcumulado + tazo
    }
    println(totalTazos)

    // val fecha = Date()
    // fecha.time = 11231231
    // fecha.year = 2000
    // fecha = Date(1989,6,10)

    val numerito = Numero(1)
}

fun holaMundo(mensaje: String): Unit {
    println("Mensaje: $mensaje.")
}

fun holaMundoAvanzado(mensaje: Any): Unit {
    println("Mensaje: $mensaje.")
}

fun sumarDosNumeros(numUno: Int, numDos: Int): Int{
    return numUno+numDos
}


fun estaJalado(nota: Double): Double {
    when (nota) {
        7.0 -> {
            println("Pasaste con las justas")
        }
        10.0 -> {
            println("Genial :D Felicitaciones!")
        }
        0.0 -> {
            println("Dios mio que vago!")
        }
        else -> {
            println("Tu nota es: $nota")
            // println("Tu nota es: ${nota}")
        }
    }
    return nota
}


//Clase 25-04-2019
class Usuario(val cedula:String) {
    public var nombre:String = ""
    public var apellido:String = ""

    constructor(cedulaM:String,
                apellido:String) : this(cedulaM) {
        this.apellido = apellido
    }
}

// public and unit -> son por defecto en Kotlin
class UsuarioKT(public var nombre:String,
                public var apellido: String,
                private var id:Int,
                protected var id2:Int) {

    init {

    }

    private fun hola2() {}
    protected fun hola3() {}

    public fun hola():String {
        return  this.apellido
    }

    companion object {
        val gravedad = 10.5
        fun correr() {
            println("Estoy corriendo en $gravedad")
        }
    }
}
// -> init, se ejecuta despues del primer constructor

class BaseDeDatos {
    companion object {
        private val usuarios = arrayListOf(1,2,3)
        fun agregarUsuario(usuario:Int) {
            this.usuarios.add(usuario)
        }
        fun eliminarUsuario(usuario: Int) {
            this.usuarios.remove(usuario)
        }
    }
}

fun aa() {
    UsuarioKT.gravedad
    UsuarioKT.correr()
}

fun a() {
    //val kevin = UsuarioKT("q","b")
    //kevin.apellido
    //kevin.nombre
    //kevin.nombre = "fernando"
}

class  A {}
//A.correr()  -> Metodo estatico
//A.gravedad  -> Propiedad estatica

//Companion object -> metodos y propiedades

//Sobre cargar de constructores ->
// recibir distintos numeros de parametros
class Numero(var numero:Int) {
    constructor(numeroString:String):this(numeroString.toInt()){
        println("CONSTRUCTOR")
    }
    init {
        println("INIT")
    }
}

//open y final -> heredar clases, clases abstractas

//open class Numeros(var numeroUno:Int,
abstract class Numeros(var numeroUno:Int,
             var numeroDos:Int
)
class Suma(numeroUnos: Int,
           numeroDoss: Int) :
        Numeros(numeroUnos,numeroDoss) {
}
fun cc() {
    val a = Suma(1,2)
    //val a2 = Numeros(1,2) -> clase abstracta
}


// ? -> a veces va hacer nulo
// KT -> ayuda a no tener los errroes de nullpointerexception

fun presley(requerido:Int,
            opcional:Int = 1,
            nulo:UsuarioKT?) {
    if(nulo != null) {
        nulo.nombre
    }
    val nombresito:String? = nulo?.nombre.toString()

    nulo!!.nombre //-> dice al compilador que la variable existe
}

fun cddd() {
    presley(requerido = 1, nulo = null)    // Named Parameters
    presley(1,1,null)    // Named Parameters
    presley(1,1,null)    // Named Parameters
}