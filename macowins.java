int valorRecargo = 10;
 
 class Prenda {
 	int id;
 	Estado estado;
 	Tipo tipo;
 	double precioBase;
 	
 	double precioFinal() {
 		return estado.precio(this);
 	}
 	
 	int precioBase(){
 	return precioBase;
 	}
 }
 
 class PrendaXVenta {
 	Prenda prenda;
 	Venta venta;
 	int cantidadPrendas;
 	
 	int precioPrendasBase = prenda.precioFinak()*cantidadPrendas;
 	int montoRecargo = venta.metodoDePago().calcularRecargo(precioPrendasBase);
 	
 	double pagoParcial() {
 		return precioPrendasBase + montoRecargo;
 	}
 }
 
 class Venta {
 	int id;
 	Date fecha;
 	MetodoPago metodoDePago;
 	PrendaXVenta ventas = [];
 	
 	MetodoPago metodoDePago() {
 		return metodoDePago;
 	}
 	double totalAPagar() {
 		ventas.sum({ventaXPrenda => ventaXPrenda.pagoParcial()}); //no se cómo se hace esto en java, yo lo hice en wollok y lo trate de pasar a java
 	}
 }

class Tipo{
	static void main(String[] args) {
		Tipo saco = new Tipo();
		Tipo pantalon = new Tipo();
		Tipo camisa = new Tipo();
	}
}

class Estado{
	double precio(Prenda prenda);
}

class Nueva extends Estado{
	double precio(Prenda prenda) {
		return prenda.precioBase();
	}
}

class Promocion extends Estado{
	double valor;
	
	double precio(Prenda prenda){
		return prenda.precioBase() - valor;
	}
}

class Liquidacion extends Estado{
	double precio(Prenda prenda) {
		return prenda.precioBase()*0.5;
	}
}

class MetodoPago{
	double calcularRecargo(double precioPrendas);
}

class Efectivo extends MetodoPago{
	
	double calcularRecargo(double precioPrendas) {
		return precioPrendas;
	}
}

class Tarjeta extends MetodoPago{
	int cuotas
	
	double calcularRecargo(double precioPrendas){
		return valorRecargo * cuotas + 0.1*precioPrendas
	}
}


