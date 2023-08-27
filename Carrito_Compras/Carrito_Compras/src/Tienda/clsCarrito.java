package Tienda;
import java.util.Scanner;
import carrito.util.clsListaOrdLinkedArt;

public class clsCarrito {
	private int cant_art, total;
	clsListaOrdLinkedArt Articulos;
	
	clsCarrito () {
		this.cant_art = 0;
		this.total = 0;
		this.Articulos = new clsListaOrdLinkedArt ();
	}
	
	boolean confirm_art () {
		Scanner sca = new Scanner(System.in);
		System.out.println("Desea agregar el articulo? Si o No:");
		String x = sca.next();
		sca.close();
		x.toLowerCase();
		if(x.equals("si")) {
			return true;
		}else {
			return false;
		}	
	}
	
	void agregar_articulo (clsArticulo Articulo) {
		if (Articulo.getcantidad() > 0) {
			//if (confirm_art()) {
			Articulos.inserta(Articulo);
			cant_art ++;
			total = total + Articulo.getprecio();
			Articulo.compra();
		//}	
		}else {
			System.out.println ("Articulo no disponible");
		}
	}
	
	boolean expuls_art () {
		Scanner sca = new Scanner(System.in);
		System.out.println("Desea quitar el articulo? Si o No:");
		String x = sca.next();
		sca.close();
		x.toLowerCase();
		if(x.equals("si")) {
			return true;
		}else {
			return false;
		}	
	}
	
	void quitar_articulo () {
		//if (expuls_art()) {
			if (!Articulos.estaVacia()) {
				clsArticulo temp = new clsArticulo();
				temp = (clsArticulo) Articulos.devuelveElemento(Articulos.getcontador() - 1);
				total = total - temp.getprecio();
				cant_art --;
				Articulos.elimina(temp);
				temp.cancel();
			}else {
				System.out.println ("Carro vacio");
			}
		//}
	}
	
	protected int getcantidad () {
		return this.cant_art;
	}
	
	int precio_art (int posicion) {
		clsArticulo articulo = new clsArticulo();
		articulo = (clsArticulo) Articulos.devuelveElemento (posicion);
		return articulo.getprecio();		
	}
	
	int getMenor () {
		clsArticulo menor = new clsArticulo();
		menor = (clsArticulo) Articulos.devuelveMenor();
		return menor.getprecio();
	}
	
	int getTotal () {
		return this.total;
	}
	
	void muestra () {
		Articulos.muestra();
	}
	
	void comprar () {
		Articulos.limpiarLista();
		this.cant_art = 0;
		this.total = 0;
		}

}
