package ejercicioSocketClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Scanner;

public class SocketCliente {
	public static final int PUERTO = 2017;
	public static final String IP_SERVER = "localhost";
	static Scanner leer;

	public static void main(String[] args) {
		System.out.println("       APLICACIÓN CLIENTE");
		System.out.println("-----------------------------------");

		Socket socketCliente = null;
		InputStreamReader entrada = null;
		PrintStream salida = null;

		InetSocketAddress direccionServidor = new InetSocketAddress(IP_SERVER, PUERTO);
		Scanner sc = new Scanner(System.in);

		try {

			boolean continuar = true;
			System.out.println("Introduzca el primer número");
			String numero1 = sc.nextLine();
			System.out.println("Introduzca el segundo número");
			String numero2 = sc.nextLine();
			String numMenu = sacarMenu();
			do {
				socketCliente = new Socket();
				socketCliente.connect(direccionServidor);
				System.out.println("Conexion establecida... a " + IP_SERVER + " por el puerto " + PUERTO);

				entrada = new InputStreamReader(socketCliente.getInputStream());
				salida = new PrintStream(socketCliente.getOutputStream());

				String operandos = numero1 + "-" + numero2 + "-" + numMenu;
				salida.println(operandos);

				BufferedReader bf = new BufferedReader(entrada);
				String linea_recibida = bf.readLine();
				System.out.println("CLIENTE: La solucion de la " + mapaHash(numMenu) + " es: " + linea_recibida);
				System.out.println("Quiere continuar? S/N");
				String sContinuar = sc.nextLine();
				if (sContinuar.equalsIgnoreCase("n")) {
					continuar = false;
				} else if (sContinuar.equalsIgnoreCase("s")) {
					System.out.println("Quieres hacer otra operacion o cambiar los números? O/N");
					String respuesta = sc.nextLine();
					if (respuesta.equalsIgnoreCase("o")) {
						numMenu = sacarMenu();
					} else if (respuesta.equalsIgnoreCase("n")) {
						System.out.println("Introduzca el primer número");
						numero1 = sc.nextLine();
						System.out.println("Introduzca el segundo número");
						numero2 = sc.nextLine();
						numMenu = sacarMenu();
					}
				}
			} while (continuar);
		} catch (UnknownHostException excepcion) {
			System.err.println("No encuentro el servidor en la dirección" + IP_SERVER);
		} catch (IOException excepcion) {
			System.err.println("Error de entrada/salida");
		} catch (Exception e) {
			System.err.println("Error: " + e);
		} finally {
			try {
				salida.close();
				entrada.close();
				socketCliente.close();
				sc.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private static String sacarMenu() {
		System.out.println("Selecciona una opción:");
		System.out.println("1-Sumar");
		System.out.println("2-Restar");
		System.out.println("3-Multiplicar");
		System.out.println("4-Dividir");
		System.out.println("Escribe una de las opciones: ");

		leer = new Scanner(System.in);
		String num = leer.nextLine();
		return num;
	}

	private static String mapaHash(String numMenu) {
		HashMap<String, String> provincias = new HashMap<String, String>();
		String key = "";
		provincias.put("1", "Suma");
		provincias.put("2", "Resta");
		provincias.put("3", "Multiplicación");
		provincias.put("4", "División");
		if (provincias.containsKey(numMenu)) {
			key = provincias.get(numMenu);
		}
		return key;
	}
}
