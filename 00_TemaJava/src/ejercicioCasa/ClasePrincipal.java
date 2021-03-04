package ejercicioCasa;

import java.util.ArrayList;

public class ClasePrincipal {
	
	public static void main(String[] args) {

		ArrayList<Habitacion> habitaciones = new ArrayList<Habitacion>();
		ArrayList<Persona> inquilinos = new ArrayList<Persona>();

		Direccion d1 = new Direccion("Calle", "Las Rosas", "28042");
		Direccion d2 = new Direccion("Avenida", "Los Almendros", "20966");
		
		Persona dueño = new Persona("Pedro", "66688777", d1);
		Persona inquilino1 = new Persona("Lola", "777888999", d2);
		Persona inquilino2 = new Persona("Mario", "999555444", d2);
		
		Habitacion hCuarto = new Habitacion(50, TipoHabitacion.CUARTO);
		Habitacion hCuarto2 = new Habitacion(60, TipoHabitacion.CUARTO);
		Habitacion hBano = new Habitacion(10, TipoHabitacion.BANO);
		Habitacion hSala = new Habitacion(70, TipoHabitacion.SALA);
		Habitacion hBano2 = new Habitacion(5, TipoHabitacion.BANO);
		Habitacion hCocina = new Habitacion(5, TipoHabitacion.COCINA);
		
		habitaciones.add(hCuarto);
		habitaciones.add(hCuarto2);
		habitaciones.add(hBano);
		habitaciones.add(hBano2);
		habitaciones.add(hSala);
		habitaciones.add(hCocina);
		
		Casa casa = new Casa(d1, habitaciones, 200, dueño, inquilinos);
		
		System.out.println(casa);
	}
}
