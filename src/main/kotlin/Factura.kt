import java.util.Properties

class Factura (){
    //Coleccion de objetos tipo Producto, carrito de compras
    private var carritoProductos: ArrayList<Producto>
     var precioTotal: Double
     var cantidadTotal: Int

    init {
        //Inicializando datos con vacios
        this.carritoProductos= arrayListOf<Producto>()
        this.precioTotal=0.0
        this.cantidadTotal=0
    }

    fun agregarProducto(producto: Producto, cantidadProducto: Int){
        //Agregando producto a la lista del carrito
        producto.setCantidadComprada(cantidadProducto)
        this.carritoProductos.add(producto)
        //Actualizando precioTotal y cantidad total de la venta
        this.precioTotal+=producto.getPrecioProducto() * cantidadProducto
        this.cantidadTotal+=cantidadProducto
    }

    fun eliminarProducto(posicion: Int): String{

        //Guardando producto actual en variable para facilitar un poco el manejo del dato
        var productoActual = this.carritoProductos.get(posicion)
        //Restando del carrito el precio total del producto a eliminar
        this.precioTotal -=(productoActual.getPrecioProducto()*productoActual.getCantidadComprada())
        //Actualizando la cantidadTotal de productos que se mostraran en la factura
        this.cantidadTotal -=productoActual.getCantidadComprada()
        //Capturando el nombre del producto eliminado para operaciones futuras
        var nombreProducto = productoActual.getNombreProducto()
        //Eliminando producto de la lista del carrito
        this.carritoProductos.removeAt(posicion);

        //Retornando el nombre del producto eliminado
        return nombreProducto
    }

    //Funcion utilizada para conocer cuanto producto fue comprado, antes de eliminarlo para reestablecer la lista de productos iniciales
    fun verificarCantidadCompradaDeProducto(posicion: Int):Int{
        for (iterador in this.carritoProductos){
            if(iterador.getNombreProducto()==this.carritoProductos.get(posicion).getNombreProducto()){
               return iterador.getCantidadComprada()
            }
        }
        return 0
    }

    //Mostrando el contenido de la factura a generar...
    fun mostrarFactura(){
        var i=1
        println("\n\n---------------------Lista de productos en carrito---------------------")
        println("|| N ||Producto\t||Precio U.|| Cantidad || Total del producto||")
        for (producto in this.carritoProductos){
            producto.mostrarProductoFactura(i)
            i++
        }
        println("-----------------------------------------------------------------------")
        println("Cantidad de productos: "+this.cantidadTotal)
        println("Venta total: "+this.precioTotal)
        println("-----------------------------------------------------------------------")

    }

    //Mostrando el contenido de la factura generada y reinicializando algunos datos para la proxima factura
    fun cerrarFactura(){
        var i=1
        println("\n\n---------------------Lista de productos en carrito---------------------")
        println("|| N ||Producto\t||Precio U.|| Cantidad || Total del producto||")
        for (producto in this.carritoProductos){
            producto.mostrarProductoFactura(i)
            producto.setCantidadComprada(-producto.getCantidadComprada())
            i++
        }
        println("-----------------------------------------------------------------------")
        println("Cantidad de productos: "+this.cantidadTotal)
        println("Venta total: "+this.precioTotal)
        println("-----------------------------------------------------------------------")
    }



}