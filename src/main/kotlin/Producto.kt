class Producto(nombre: String, precio: Double, cantidad: Int){
    //Propiedades de la clase Producto
    private var nombreProducto: String
    private var precioProducto: Double
    var cantidadDisponible: Int
    private var cantidadComprada: Int=0


    //Inicializador init para asignar los valores iniciales
    init{
        this.nombreProducto=nombre
        this.precioProducto=precio
        this.cantidadDisponible=cantidad
        this.cantidadComprada=0
    }

    //Metodos de la clase Producto

    //Utilizado al mostrar productosDisponibles al usuario
    fun mostrarProducto(i:Int){

        println("|| "+i+" ||"+this.nombreProducto+"  || "+this.precioProducto+" || "+this.cantidadDisponible)
    }

    //Utilizado al mostrar productos en factura y por ende los que se encuentran en carrito de compra
    fun mostrarProductoFactura(i:Int){
        println("|| "+i+" ||"+this.nombreProducto+"  || "+this.precioProducto+" || "+this.cantidadComprada+" || "+(this.cantidadComprada*this.precioProducto))
    }


    //Getters y Setters
    fun getNombreProducto(): String{
        return this.nombreProducto
    }

    fun getPrecioProducto(): Double{
        return this.precioProducto;
    }

    fun getCantidadComprada():Int{
        return this.cantidadComprada
    }

    fun setCantidadComprada(cant: Int){
        this.cantidadComprada= (this.cantidadComprada+cant)
    }

    fun reducirCantidadDisponible(cantComprada: Int){
        this.cantidadDisponible= (this.cantidadDisponible-cantComprada)
    }

}
