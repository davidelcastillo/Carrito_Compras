package Tienda;
import java.util.Scanner;

public class clsUsuario extends Persona {
	// Para simplificar se supone que cuenta es la billetera del cliente
	private String user, contraseña;
	private int cuenta;
	private clsCarrito carro;
	private clsDireccion direccion;
	
	clsUsuario () {
		this.user = "";
		this.cuenta = 0;
		this.contraseña = "";
		this.carro = new clsCarrito();
		this.direccion = new clsDireccion ();
	}

	clsUsuario (String user, String contr, int cuenta, String pais, String provincia) {
		this.user = user;
		this.cuenta = cuenta;
		this.contraseña = contr;
		this.carro = new clsCarrito();
		this.direccion = new clsDireccion (pais,provincia);
	}
	
	void setuser (String user) {
		this.user = user;
	}
	
	void setcontraseña (String Contra) {
		this.contraseña = Contra;
	}
	
	void setcuenta (int cta) {
		this.cuenta = cta;
	}
	
	 String getuser() {
		return this.user;
	}
	
	void cambiaruser() {
		Scanner sca = new Scanner(System.in);
		System.out.println("Desea cambiar su user? Si o No:");
		String x = sca.next();
		x.toLowerCase();
		if(x.equals("si")) {
			System.out.println("Ingrese su contraseña para continuar");
			x=sca.next();
			if (x == this.contraseña) {
				System.out.println("Ingrese su nuevo nombre de usuario");
				x=sca.next();
				this.user = x;
				sca.close();
			}else {
				System.out.println("contraseña incorrecta");
			}
		}
	}
	
	void cambiarcontraseña () {
		Scanner sca = new Scanner(System.in);
		System.out.println("Desea cambiar su contraseña? Si o No:");
		String x = sca.next();
		x.toLowerCase();
		if(x.equals("si")) {
			System.out.println("Ingrese su contraseña actual para continuar");
			x=sca.next();
			if (x == this.contraseña) {
				System.out.println("Ingrese su nueva contraseña");
				x=sca.next();
				this.contraseña = x;
				sca.close();
			}else {
				System.out.println("contraseña incorrecta");
			}
		}
	}

	void agregar_art (clsArticulo articulo) {
		this.carro.agregar_articulo(articulo);
	}
	
	void quitar_art () {
		this.carro.quitar_articulo();
	}
	
	void precio_art (int posicion) {
		int x = this.carro.precio_art(posicion);
		System.out.println("el precio es: " + x);
	}
	
	void menor_art () {
		int x = this.carro.getMenor();
		System.out.println("el menor es: " + x);
	}
	
	void getTotal () {
		int x = this.carro.getTotal();
		System.out.println("el toatl es: " + x);
	}
	
	int calqTotal (int km) {
		int total = carro.getTotal();
		total = total + this.direccion.CalcularFactura("Aregrntina", "Buenos Aires", km);
		return total;
	}

	void comprar (int km) {
		Scanner sca = new Scanner(System.in);
		System.out.println("Desea finalizar la compra? Si o No:");
		String x = sca.next();
		x.toLowerCase();
		if(x.equals("si")) {
			carro.muestra();
			int tl = carro.getTotal();
			System.out.println("El Total de productos es: " + tl);
			tl = this.direccion.CalcularFactura("Aregrntina", "Buenos Aires", km);
			System.out.println("El Total de envio es: " + tl);
			int total = this.calqTotal(km);
			System.out.println("El Total es: " + total);
			System.out.println("Desea pagar la compra? Si o No:");
			x = sca.next();
			sca.close();
			x.toLowerCase();
			if(x.equals("si")) {
				if (pagar(total)) {
					carro.comprar();
					System.out.println("Pago exitoso");	
				}else {
					System.out.println("El pago fallo, dinero insuficiente.");
					}
			}
		}
	}

	private boolean pagar(int cant_pagar) {
		if (cuenta > cant_pagar) {
			cuenta = cuenta - cant_pagar;
			return true;
		}else {
			return false;
		}
	}
	
}
