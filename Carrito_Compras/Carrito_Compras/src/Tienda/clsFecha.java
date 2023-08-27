package Tienda;

import java.util.Calendar;

public class clsFecha {
	//Atributos
	private int anio;
	private int mes;
	private int dia;
	
	//Constructor
	public clsFecha(int anio,int mes, int dia) {
		setAnio(anio);
		setMes(mes);
		setDia(dia);
	}
	public void setAnio(int a) {
		anio=a;
	}
	public void setMes(int a) {
		mes=a;
	}
	public void setDia(int a) {
		dia=a;
	}
	public int getAnio() {
		return anio;
	}
	public int getMes() {
		return mes;
	}
	public int getDia() {
		return dia;
	}
	public void diaAnterior() {
		Calendar fecha=Calendar.getInstance();
		fecha.set(anio, mes, dia);
		fecha.add(Calendar.DATE, -1);
		System.out.println("El dia anterior es "+fecha.get(Calendar.DATE)+"/"+fecha.get(Calendar.MONTH)+"/"+fecha.get(Calendar.YEAR));
	}
	public void sumarDias(int dias) {
		Calendar fecha=Calendar.getInstance();
		fecha.set(anio,mes,dia);
		fecha.add(Calendar.DATE, dias);
		setAnio(fecha.get(Calendar.YEAR));
		setMes(fecha.get(Calendar.MONTH));
		setDia(fecha.get(Calendar.DATE));
	}
	public String getStringFecha() {
		return (dia+"/"+mes+"/"+anio);
	}
}
