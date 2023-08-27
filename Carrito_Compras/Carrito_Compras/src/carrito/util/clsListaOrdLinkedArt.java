package carrito.util;
import Tienda.clsArticulo;

public class clsListaOrdLinkedArt extends clsListaOrdLinkedL {
	public boolean esMenor(Object objA, Object objB){
		boolean response=false;
		clsArticulo art1=(clsArticulo)objA;
		clsArticulo art2=(clsArticulo)objB;
		if (art1.getId().compareToIgnoreCase(art2.getId())<0){
			response=true;
		}
		return response;
	}
	public boolean esMayor(Object objA, Object objB){
		boolean response=false;
		clsArticulo art1=(clsArticulo)objA;
		clsArticulo art2=(clsArticulo)objB;
		if (art1.getId().compareToIgnoreCase(art2.getId())>0){
			response=true;
		}	
		return response;
	}
	public boolean iguales(Object objA, Object objB){
		boolean response=false;
		clsArticulo art1=(clsArticulo)objA;
		clsArticulo art2=(clsArticulo)objB;
		if (art1.getId()== art2.getId()){
			response=true;
		}
		return response;
	}
	
	public void muestra(){
		clsNode temp;		
		if (!estaVacia()){
			int i = 0;
			temp=this.lista;
			while (temp!=null){
				clsArticulo art=(clsArticulo)temp.getNodeInfo();
				i++;
				System.out.println("============");
				System.out.println("Articulo N°" + i);
				art.muestra();
				temp=temp.getNextNode();
			}
			System.out.println("============");
		}else{
			System.out.println("Error muestra. Lista vacia");
		}		
	}
	
	public int getcontador() { 
		return this.contador;
	}
	
	public boolean menorP (Object objA, Object objB) {
		boolean response=false;
		clsArticulo art1=(clsArticulo)objA;
		clsArticulo art2=(clsArticulo)objB;
		if (art1.getprecio() < art2.getprecio()){
			response=true;
		}
		return response;
	
	}
}
