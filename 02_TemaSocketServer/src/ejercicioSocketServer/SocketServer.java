package ejercicioSocketServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
	public static final int PUERTO = 2017;
	public static final String IP_SERVER = "localhost";
	public final static int SUMAR = 1;
	public final static int RESTAR = 2;
	public final static int MULTIPLICAR = 3;
	public final static int DIVIDIR = 4;
	static int num1;
	static int num2;

	public static void main(String[] args) throws InterruptedException {
		System.out.println("      APLICACIÓN DE SERVIDOR      ");
		System.out.println("----------------------------------");

		ServerSocket servidorSocket = null;
		Socket socketConexion = null;
		PrintStream salida = null;
		InputStreamReader entrada = null;

		try {
			servidorSocket = new ServerSocket();
			InetSocketAddress direccion = new InetSocketAddress(IP_SERVER, PUERTO);
			servidorSocket.bind(direccion);

			while (true) {
				System.out.println("SERVIDOR: Esperando peticion...");

				socketConexion = servidorSocket.accept();
				entrada = new InputStreamReader(socketConexion.getInputStream());
				BufferedReader bf = new BufferedReader(entrada);

				String stringRecibido = bf.readLine();
				System.out.println("SERVIDOR: Me ha llegado del cliente: " + stringRecibido);
				String[] operadores = stringRecibido.split("-");
				num1 = Integer.parseInt(operadores[0]);
				num2 = Integer.parseInt(operadores[1]);
				int numMenu = Integer.parseInt(operadores[2]);
				double resultado = hacerOperacion(numMenu);
				salida = new PrintStream(socketConexion.getOutputStream());
				salida.println(resultado);

			}
		} catch (IOException excepcion) {
			System.out.println(excepcion);
		} finally {
			try {
				if (salida != null && entrada != null) {
					salida.close();
					entrada.close();
					socketConexion.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private static double hacerOperacion(int numMenu) {
		double resultado = 0;
		switch (numMenu) {
		case SUMAR:
			resultado = num1 + num2;
			break;
		case RESTAR:
			if (num2 > num1) {
				resultado = num2 - num1;
			} else {
				resultado = num1 - num2;
			}
			break;
		case MULTIPLICAR:
			resultado = num1 * num2;
			break;
		case DIVIDIR:
			if (num2 > num1) {
				resultado = num2 / num1;
			} else {
				resultado = num1 / num2;
			}
			break;
		}
		return resultado;
	}
}
