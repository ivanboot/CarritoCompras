import java.util.Properties

class Factura (){
    //Coleccion de objetos tipo Producto, carrito de compras
    private var carritoProductos: ArrayList<Producto>
     var precioTotal: Double
     var cantidadTotal: Int

    init {
        this.carritoProductos= arrayListOf<Producto>()
        this.precioTotal=0.0
        this.cantidadTotal=0
    }

    fun agregarProducto(producto: Producto){
        //Agregando producto a la lista del carrito
        this.carritoProductos.add(producto)
        //Actualizando precioTotal y cantidad total de la venta
        this.precioTotal+=producto.precioTotal
        this.cantidadTotal+=producto.cantidadProducto
    }

    fun eliminarProducto(posicion: Int){
        //Restando del carrito el precio total del producto a eliminar
        this.precioTotal -=this.carritoProductos.get(posicion).precioTotal
        this.cantidadTotal -=this.carritoProductos.get(posicion).cantidadProducto
        //Eliminando producto de la lista del carrito
        this.carritoProductos.removeAt(posicion);
    }

    fun mostrarFactura(){
        var i=1
        println("\n\n---------------------Lista de productos en carrito---------------------")
        println("|| N ||Producto\t||Precio Unitario  ||Cantidad||Total del producto||")
        for (producto in this.carritoProductos){
            producto.mostrarProducto(i)
            i++
        }
        println("-----------------------------------------------------------------------")
        println("Cantidad de productos: "+this.cantidadTotal)
        println("Venta total: "+this.precioTotal)
        println("-----------------------------------------------------------------------\n")

    }



}