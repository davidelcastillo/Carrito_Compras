package Tienda;
public class clsArticulo {
	String nombre, descripcion, id;
	int  precio, precio_dsc, cantidad;
	
	clsArticulo() {
		this.nombre = null;
		this.descripcion = null;
		this.id = null;
		this.precio = 0;
		this.cantidad = 0;
	}
	
	clsArticulo (String nombre, String descripcion, String id, int precio, int cantidad) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.id = id;
		this.precio = precio;
		this.cantidad = cantidad;
		this.precio_dsc = precio;
	}
	
	void descuento (int descuento) {
		this.precio_dsc = descuento;
	}
	
	void quitar_dsc () {
		this.precio_dsc = precio;
	}
	
	String getnombre () {
		return this.nombre;
	}
	
	public String getId() {
		return this.id;
	}
	
	public int getprecio() {
		return this.precio_dsc;
	}
	
	int getcantidad () {
		return this.cantidad;
	}
	
	protected void compra() {
		this.cantidad --;
	}
	protected void cancel() {
		this.cantidad ++;
	}
	
	public void muestra() {
		System.out.println(this.id + " - " + this.nombre + " - " + this.descripcion + " - " + this.precio_dsc);
	}

	// Falta hacer un metodo para conocer el más barato

}
