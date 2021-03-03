package ejercicioCasa;

import java.util.ArrayList;

public class Casa {
	
	private double m2;
	private ArrayList<Habitacion> habitaciones;
	private Persona due�o;
	private Direccion direccion;
	private ArrayList<Persona> inquilino;
	private double precio;

	public Casa(double m2, ArrayList<Habitacion> habitaciones, Persona due�o, Direccion direccion,
			ArrayList<Persona> inquilino, double precio) {
		super();
		this.m2 = m2;
		this.habitaciones = habitaciones;
		this.due�o = due�o;
		this.direccion = direccion;
		this.inquilino = inquilino;
		this.precio = precio;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getM2() {
		return m2;
	}

	public void setM2(double m2) {
		this.m2 = m2;
	}

	public ArrayList<Habitacion> getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(ArrayList<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}

	public Persona getDue�o() {
		return due�o;
	}

	public void setDue�o(Persona due�o) {
		this.due�o = due�o;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public ArrayList<Persona> getInquilino() {
		return inquilino;
	}

	public void setInquilino(ArrayList<Persona> inquilino) {
		this.inquilino = inquilino;
	}

	@Override
	public String toString() {
		return "La casa tiene " + m2 + "m2, " + habitaciones + ".\nSu due�o es " + due�o + ".\nLa casa se encuentra en "
				+ direccion + ".\nSus inquilinos son " + inquilino + ".\nTiene un precio es de " + precio + "�";
	}
}
