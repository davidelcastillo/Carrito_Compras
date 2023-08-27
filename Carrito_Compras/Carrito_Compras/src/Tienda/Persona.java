package Tienda;

public class Persona {
	String nya;
	clsFecha nacimiento;
	String direccion;
	String email;
	
	public Persona(String nombre, clsFecha nacimiento, String direccion, String mail) {
		setNya(nombre);
		setNacimiento(nacimiento);
		setDireccion(direccion);
		setCorreo(mail);
	}
	protected Persona() {
		setNya(" - ");
	}
	protected void setNya(String nombreyA) {
		this.nya=nombreyA;
	}
	protected void setNacimiento(clsFecha fecha) {
		this.nacimiento=fecha;
	}
	protected void setDireccion(String direccion) {
		this.direccion=direccion;
	}
	private boolean verificarCorreo(String correo) {
		boolean resultado=false;
		//obvio hay mas empresas, pero por poner algo xd
		String[] empresas_legales= {"yahoo","gmail","outlook","hotmail"};
		int i=0;
		while(i<empresas_legales.length && resultado==false) {
			//hay correos que terminan en la terminacion de un pais, pero weno ;V
			if(correo.endsWith("@"+empresas_legales[i]+".com")) {
				resultado=true;
			}
			i++;
		}
		return resultado;
	}
	protected void setCorreo(String correo) {
		if(verificarCorreo(correo)) {
			this.email=correo;
		}else {
			System.out.println("Error, email inv�lido.");
		}
	}
	protected String getNya() {
		return this.nya;
	}
	//si quieren mostrar la fecha, la clase fecha tiene un metodo para eso
	protected clsFecha getNacimiento() {
		return this.nacimiento;
	}
	protected String getdireccion() {
		return this.direccion;
	}
	protected String getEmail() {
		return this.email;
	}
	protected void mostrarDatosPersona() {
		System.out.println("Nombre y Apellido: "+nya);
		System.out.println("Fecha de nacimiento: "+nacimiento.getStringFecha());
		System.out.println("Direccion: "+direccion);
		System.out.println("Correo electr�nico: "+email);
	}
}
