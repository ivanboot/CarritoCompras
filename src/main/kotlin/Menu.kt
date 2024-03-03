import java.util.Scanner

object Menu {
    private var scanner = Scanner(System.`in`)
    private var factura = Factura()

    //Inicializando lista vacia
    private var productosDisponibles: ArrayList<Producto> = arrayListOf<Producto>()

    // Función para mostrar las opciones del menú
    private fun mostrarOpciones() {
        println("\n----- Menu -----")
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
        cargarProductosIniciales()
        do {

            mostrarOpciones()
            print("Ingrese una opcion: ")
            opcion = scanner.nextInt()
            when (opcion) {
                1 -> agregarProducto()
                2 -> eliminarProducto()
                3 -> mostrarCarrito()
                4 -> cerrarVenta()
                5 -> println("¡Hasta luego!")
                else -> println("Opcion invalida. Por favor, ingrese una opcion valida.")
            }
        } while (opcion != 5)
    }

    // Función para agregar un producto al inventario
    private fun agregarProducto() {
        do {
            var repetirCompra: Boolean = true
            try {

                var i = 1;
                println("----- Lista de productos disponibles -----")
                println("|| N ||Producto\t||Precio Unitario  ||Cantidad disponible")
                for (producto in this.productosDisponibles) {
                    producto.mostrarProducto(i)
                    i++
                }
                print("Seleccione el Nº de producto que desea agregar al carrito: ")
                var nProducto = scanner.nextInt()
                nProducto--

                println("----------------")

                //Serie de validaciones
                //En caso de que el producto seleccionado ya no tenga disponibilidad
                if (this.productosDisponibles.get(nProducto).cantidadDisponible == 0) {
                    println("No hay existencias para ese producto intente de nuevo...")
                    println("Presione enter para continuar...")
                    System.`in`.read()
                } else { //En caso de que exista disponibilidad del producto
                    println(
                        "Cantidad de " + this.productosDisponibles.get(nProducto).getNombreProducto() + " a comprar: "
                    )
                    var cantidad = scanner.nextInt()

                    //if que comprueba si el usuario intenta comprar mas producto del que se encuentra disponible
                    if (cantidad > this.productosDisponibles.get(nProducto).cantidadDisponible) {
                        println("ERROR: La cantidad deseada sobrepasa la disponibilidad del producto...")
                        println("Presione enter para continuar...")
                        System.`in`.read()
                    } else { //Si el usuario compra la cantidad valida, continuamos...
                        println(
                            this.productosDisponibles.get(nProducto)
                                .getNombreProducto() + " ha sido agregado al carrito!\n"
                        )

                        //Reduciendo la cantidad de producto disponible en la lista de productosDisponibles
                        this.productosDisponibles.get(nProducto).reducirCantidadDisponible(cantidad)
                        //Agregando productos a la factura, que generara una lista interna llamada carritoProductos
                        factura.agregarProducto(this.productosDisponibles.get(nProducto), cantidad)

                        //Se repite si selecciona 1, si no, salimos de esta opcion
                        println("Desea seguir comprando?")
                        println("1.Si")
                        println("2.No")
                        val opcion = scanner.nextInt()
                        if (opcion != 1) {
                            repetirCompra = false
                        }
                    }

                }

                //Capturando errores mediante try catch, en caso de error se repite la compra desde principio
            } catch (e: NumberFormatException) {
                println("Se ha ingresado un valor no numerico!")
                println("Presione enter para continuar...")
                System.`in`.read()
            } catch (e: java.lang.IndexOutOfBoundsException) {
                println("Nº de producto no encontrado! intente de nuevo...")
                println("Presione enter para continuar...")
                System.`in`.read()
            }
        } while (repetirCompra)
    }

    //Funcion que carga una lista inicial de productos disponibles para comprar
    private fun cargarProductosIniciales() {
        productosDisponibles.add(Producto("Galletas", 5.25, 25))
        productosDisponibles.add(Producto("Leche", 1.25, 43))
        productosDisponibles.add(Producto("Cafe", 2.50, 29))
        productosDisponibles.add(Producto("Alfajores", 1.05, 15))
        productosDisponibles.add(Producto("Semita", 0.75, 30))
    }


    //Funcion para eliminar productos de la factura y por ende del carrito interno definido en la factura
    private fun eliminarProducto() {
        println("----- Eliminar producto -----\n")
        factura.mostrarFactura()
        println("Digite el nº de producto que desea eliminar: ")
        val posicion = scanner.nextInt()
        //Eliminando producto del carrito y capturando el nombre de dicho producto
        var cantidadComprada = factura.verificarCantidadCompradaDeProducto(posicion-1)
        //Capturando nombre del producto eliminado para reestablecerlo despues
        var productoEliminado=factura.eliminarProducto((posicion - 1))

        for (iterador in this.productosDisponibles){
            //Al encontrar el producto eliminado en la lista de productosDisponibles...
            if(iterador.getNombreProducto()==productoEliminado){
                //Se le restablece la cantidad comprada, para que vuelva a estar disponible
                iterador.cantidadDisponible+=cantidadComprada
            }
        }


    }

    // Función para mostrar el contenido del carrito
    private fun mostrarCarrito() {
        factura.mostrarFactura()
        print("Presione enter para continuar...")
        System.`in`.read()
    }

    // Función para reinicializar la factura
    private fun cerrarVenta() {
        factura.cerrarFactura()
        println("La venta a sido finalizada, limpiando carrito...")
        print("\nPresione enter para continuar...")
        System.`in`.read()
        //Inicializando nuevamente la factura, se utiliza una nueva factura vacia
        factura = Factura()
    }


}