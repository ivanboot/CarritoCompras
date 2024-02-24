class Producto(nombre: String, precio: Double, cantidad: Int){
    //Propiedades de la clase Persona
    private var nombreProducto: String
    private var precioProducto: Double
    var cantidadProducto: Int
    var precioTotal: Double

    //Inicializador init para asignar los valores iniciales
    init{
        this.nombreProducto=nombre
        this.precioProducto=precio
        this.cantidadProducto=cantidad
        this.precioTotal=(precio*cantidad)
    }

    //Metodos de la clase Producto
    fun mostrarProducto(i:Int){

        println("|| "+i+" ||"+this.nombreProducto+"  ||"+this.precioProducto+"\t\t\t\t||"+this.cantidadProducto+"\t\t ||"+this.precioTotal)
    }

}
