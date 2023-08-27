package carrito.util;
public abstract class clsListaOrdLinkedL{
	protected clsNode lista;
	protected int contador;
	
	public clsListaOrdLinkedL(){
		limpiarLista();
		this.contador=0;
	}
	
	public boolean estaVacia(){
		return (this.lista==null);
	}
	

	public void limpiarLista(){
		this.lista=null;;
	}
	
	public abstract boolean esMenor(Object objA, Object objB);
	public abstract boolean esMayor(Object objA, Object objB);
	public abstract boolean iguales(Object objA, Object objB);
	public abstract boolean menorP(Object objA, Object objB);
	
	public Object devuelveElemento(int posicion){
		int counter = 0;
		clsNode temp;
		temp = this.lista;
		Object elemento = null;
		if (posicion >= 0 && posicion < this.contador){			
			while (counter < posicion){
				temp = temp.getNextNode();
				counter ++;
			}
			elemento = temp.getNodeInfo();

		}else{
			System.out.println("-");
		}		
		
		return elemento;
	}
	
	public void mezclarListas(clsListaOrdLinkedL lista1 , clsListaOrdLinkedL lista2 ){
		
	}
	
	
	public void inserta(Object objElemento){
		clsNode node;
		node = new clsNode(objElemento);
		this.contador++;
		if (estaVacia()){
			this.lista = node;
		} else{
			if (esMenor(objElemento, this.lista.getNodeInfo())){
				node.setNextNode(this.lista);
				this.lista=node;
			} else{
				clsNode temp = this.lista;
				boolean flag = false;
				while (temp.getNextNode()!=null && !flag){
					if (esMayor(objElemento,temp.getNextNode().getNodeInfo())){
						temp = temp.getNextNode();
					}else{
						flag = true;
					}
				}
				node.setNextNode(temp.getNextNode());
				temp.setNextNode(node);				
			}
		}
	}	
	
	
	public boolean esta(Object objElemento){
		boolean response = false;
		if (estaVacia()){
			System.out.println("Error esta. lista vacia");			
		} else{
			clsNode temp = this.lista;
			while (temp!=null && !response){
				if (iguales(objElemento, temp.getNodeInfo())){
					response=true;
				}else{
					temp=temp.getNextNode();
				}
			}
		}		
		return response;
	}	
	

	public void elimina(Object objElemento){
		clsNode temp, ant;
		boolean flag=false;
		
		if (estaVacia()){
			System.out.println("Error elimina. lista vacia");
		}else{
						
			if (!esta(objElemento)){
				System.out.println("Error elimina. no esta elemento");
			}else{
				
				this.contador--;
				if (iguales(objElemento,this.lista.getNodeInfo())){
					this.lista=this.lista.getNextNode();
				}else{				
					ant=this.lista;
					temp=this.lista.getNextNode();

					while (temp!=null && !flag){
						if (iguales(objElemento, temp.getNodeInfo())){
							flag=true;
						}else{
							ant=temp;
							temp=temp.getNextNode();
						}
					}									
					
					if (flag){
						ant.setNextNode(temp.getNextNode());							
						
					}					
				}		
				
			}
		}	
	}
	
	public Object devuelveMenor (){
		clsNode temp, ant;
		Object men;
		ant = this.lista;
		temp = this.lista.getNextNode();
		if (menorP(ant.getNodeInfo(), temp.getNodeInfo())){
			men = ant.getNodeInfo(); }
		else{ 
			men = temp.getNodeInfo(); }
		temp = temp.getNextNode();
		while (temp!=null){
			if (!menorP(men, temp.getNodeInfo())){
				men = temp.getNodeInfo(); }
			temp = temp.getNextNode();
		}return men;	
	}
	
}
