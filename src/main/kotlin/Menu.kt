import java.util.Scanner
object Menu {
    private val scanner = Scanner(System.`in`)
    private var factura = Factura()
    private var producto = null

    // Función para mostrar las opciones del menú
    private fun mostrarOpciones() {
        println("\n----- Menú -----")
        println("1. Agregar producto")
        println("2. Eliminar producto")
        println("3. Mostrar carrito")
        println("4. Cerrar venta")
        println("5. Salir")
        println("----------------")
    }
    // Función para ejecutar el menú
    fun ejecutarMenu() {
        var opcion: Int
        do {

            mostrarOpciones()
            print("Ingrese una opción: ")
            opcion = scanner.nextInt()
            when (opcion) {
                1 -> agregarProducto()
                2 -> eliminarProducto()
                3 -> mostrarCarrito()
                4 -> cerrarVenta()
                5 -> println("¡Hasta luego!")
                else -> println("Opción inválida. Por favor, ingrese una opción válida.")
            }
        } while (opcion != 5)
    }
    // Función para agregar un producto al inventario
    private fun agregarProducto() {
        try{
            println("----- Agregar producto -----")
            print("Ingrese el nombre del producto: ")
            val nombre = scanner.next()
            print("Ingrese el precio del producto: ")
            val precio = scanner.nextDouble()
            print("Ingrese la cantidad a comprar: ")
            val cantidad = scanner.nextInt()
            val producto = Producto(nombre, precio, cantidad)
            println("Producto agregado con éxito.")
            println("----------------")

            factura.agregarProducto(producto)
        }catch (e: NumberFormatException){
            println("Se ha ingresado un dato erroneo!")
        }

    }

    private fun eliminarProducto(){
        println("----- Eliminar producto -----\n")
        factura.mostrarFactura()
        println("Digite el nº de producto que desea eliminar: ")
        val posicion = scanner.nextInt()
        factura.eliminarProducto((posicion-1))
    }
    // Función para mostrar el contenido del carrito
    private fun mostrarCarrito() {
        factura.mostrarFactura()
        print("Presione enter para continuar...")
        System.`in`.read()
    }
    // Función para reinicializar la factura
    private fun cerrarVenta() {
        factura.mostrarFactura()
        println("La venta a sido finalizada, limpiando carrito...")
        print("\nPresione enter para continuar...")
        System.`in`.read()
        factura= Factura()
    }


}