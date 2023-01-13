/*Una Pila tiene un conjunto de métodos: (para ver más sobre la pila consulta aqui
Tope: devuelve el elemento en la cabeza de la pila.
Push: Insertar o apilar
Pop: Eliminar o desapilar
Vacía: si está vacía (tope es nulo, o tamaño es 0) o llena (si existe tamaño máximo)
El ejercicio consistirá en dos partes:
Crearte una clase Pila, haciendo uso de una lista, que implemente los métodos descritos
anteriormente y que sea capaz de trabajar con cualquier tipo de elemento, para ello consulta
las posibilidades que ofrecen los genéricos en kotlin.
Crear una función reverse que reciba una lista, lista que puede ser de cualquier tipo, y devuelva
la lista invertida. Usaremos la Pila para invertir el orden de elementos y la interface Iterator
para recorrer los elementos de la lista.
Se usará este código para probar el programa para probarla:
   var numbers = listOf("one", "two", "three", "four")
    var numbersRev = reverse(numbers)
    if (!listOf("four", "three", "two", "one").equals(numbersRev))
        println("Error")
    else
        println("Correcto")
    println(numbersRev)
Para llevar a cabo la función reverse, será obligatorio:
Hacer uso de la interfaz Iterator para recorrer la lista.
Hacer uso de la clase Pila que has creado para invertir el orden.*/
interface Iterador{
    fun <T> recorrer(lista:List<T>): Iterator<T> {
        return lista.iterator()
    }
}
class Pila<T>(){
    private var pila = mutableListOf<T>()
    fun tope(): T {
        return pila.last()
    }
    fun push(elemento: T){
        pila.add(elemento)
    }
    fun pop():T?{
        return pila.removeLastOrNull()
    }
    fun empty(): Boolean {
        return pila.isEmpty()
    }
}
fun <T> reverse(list: List<T>): List<T> {
    var pila = Pila<T>()
    val iterador = list.iterator()
    while (iterador.hasNext()){
        pila.push(iterador.next())
    }
    val reversed = mutableListOf<T>()
    while (!pila.empty()){
        reversed.add(pila.pop()!!)
    }
    return reversed
}
fun main() {
    var numbers = listOf("one", "two", "three", "four")
    var numbersRev = reverse(numbers)
    if (!listOf("four", "three", "two", "one").equals(numbersRev))
        println("Error")
    else
        println("Correcto")
    println(numbersRev)
}