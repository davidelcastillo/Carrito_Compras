package Tienda;

public class clsDireccion {
	String calle, numero, pais, provincia;
	
	clsDireccion () {
		this.calle = null;
		this.numero = null;
		this.pais = null;
		this.provincia = null;
	}
	
	clsDireccion (String pais, String provincia) {
		this.calle = null;
		this.numero = null;
		this.pais = pais.toLowerCase();
		this.provincia = provincia.toLowerCase();
	}
	
	int CalcularFactura (String pais_orig , String provincia_orig, int km_recorr) {
		pais_orig.toLowerCase();
		provincia_orig.toLowerCase();
		int total;
		if (this.pais.compareToIgnoreCase(pais_orig) == 0) {
			if (this.provincia.compareToIgnoreCase(provincia_orig) == 0) {
				total = 0; }
			else { total = 10 + 10 * km_recorr; }
		} else { total = 10 + 50 * km_recorr; }
		return total;
	}
	
	

}
