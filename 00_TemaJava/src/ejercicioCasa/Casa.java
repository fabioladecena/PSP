package ejercicioCasa;

import java.util.ArrayList;

public class Casa {

	private Direccion direccion;
	private ArrayList<Habitacion> habitaciones;
	private float metros;
	private Persona due�o;
	private ArrayList<Persona> inquilino;
	
	public Casa(Direccion direccion, ArrayList<Habitacion> habitaciones, float metros, Persona due�o,
			ArrayList<Persona> inquilino) {
		this.direccion = direccion;
		this.habitaciones = habitaciones;
		this.metros = metros;
		this.due�o = due�o;
		this.inquilino = inquilino;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public ArrayList<Habitacion> getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(ArrayList<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}

	public float getMetros() {
		return metros;
	}

	public void setMetros(float metros) {
		this.metros = metros;
	}

	public Persona getDue�o() {
		return due�o;
	}

	public void setDue�o(Persona due�o) {
		this.due�o = due�o;
	}

	public ArrayList<Persona> getInquilino() {
		return inquilino;
	}

	public void setInquilino(ArrayList<Persona> inquilino) {
		this.inquilino = inquilino;
	}

	@Override
	public String toString() {
		return "Casa [direccion=" + direccion + ", habitaciones=" + habitaciones + ", metros=" + metros + ", due�o="
				+ due�o + ", inquilino=" + inquilino + "]";
	}

}
