package ejercicioSocketClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SocketCliente {
	public static final int PUERTO = 2017;
	public static final String IP_SERVER = "localhost";

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

			do {
				socketCliente = new Socket();
				socketCliente.connect(direccionServidor);
				System.out.println("Conexion establecida... a " + IP_SERVER + " por el puerto " + PUERTO);

				entrada = new InputStreamReader(socketCliente.getInputStream());
				salida = new PrintStream(socketCliente.getOutputStream());

				System.out.println("Introduzca el primer número a operar:");
				String num1 = sc.nextLine();

				System.out.println("Introduzca el segundo:");
				String num2 = sc.nextLine();

				System.out.println("Señale la operación a realizar:");
				System.out.println("1. Sumar");
				System.out.println("2. Restar");
				System.out.println("3. Multiplicar");
				System.out.println("4. Dividir");
				String operacion = sc.nextLine();

				String operandos = num1 + "-" + num2 + "-" + operacion;
				salida.println(operandos);

				BufferedReader bf = new BufferedReader(entrada);
				String resultado = bf.readLine();
				System.out.println("El resultado es: " + resultado);

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
}
