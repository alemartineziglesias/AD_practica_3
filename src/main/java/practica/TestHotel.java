package practica;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TestHotel
{
	public static void main(String[] args) 
	{
		int seleccion;
		int seleccion_extra;
		Scanner teclado = new Scanner(System.in);
		HotelManager operacion = new HotelManager();
		int id;
		String nombre;
		String apellidos;
		String email;
		String dni;
		String clave;
		try
		{
			do 
			{
				System.out.println("¿Que quieres hacer?");
				System.out.println("1. Crear cliente");
				System.out.println("2. Leer clientes");
				System.out.println("3. Actualizar cliente");
				System.out.println("4. Eliminar cliente");
				System.out.println("5. Salir");
				seleccion = teclado.nextInt();
				teclado.nextLine();

				switch(seleccion)
				{
				case 1:
					System.out.println("Escriba su nombre: ");
					nombre = teclado.nextLine();
					System.out.println("Escriba sus apellidos: ");
					apellidos = teclado.nextLine();
					System.out.println("Escriba su email: ");
					email = teclado.nextLine();
					System.out.println("Escriba su dni: ");
					dni = teclado.nextLine();
					System.out.println("Escriba su clave: ");
					clave = teclado.nextLine();
					Cliente cliente = new Cliente(nombre.trim(), apellidos.trim(), email.trim(), dni.trim(), clave.trim());
					operacion.crearCliente(cliente);
					System.out.println("Cliente creado");
					break;

				case 2:
					operacion.leerCliente();
					break;

				case 3:
					System.out.println("Introduzca su id de cliente: ");
					id = teclado.nextInt();
					teclado.nextLine();
					Cliente clienteEncontrado = operacion.encontrarCliente(id);
					if(clienteEncontrado == null)
					{
						System.out.println("No existe ningún cliente con ese id");
					}
					else
					{
						System.out.println("¿Qué campo quieres editar?");
						System.out.println("1. Nombre");
						System.out.println("2. Apellidos");
						System.out.println("3. Email");
						System.out.println("4. Dni");
						System.out.println("5. Clave");
						seleccion_extra = teclado.nextInt();
						teclado.nextLine();
						if(seleccion_extra == 1)
						{
							System.out.println("Escriba el nuevo nombre: ");
							nombre = teclado.nextLine();
							Cliente clienteActualizado = new Cliente(clienteEncontrado.getIdCliente(), nombre, clienteEncontrado.getApellidos(), clienteEncontrado.getEmail(), clienteEncontrado.getDni(), clienteEncontrado.getClave());
							operacion.actualizarCliente(clienteActualizado);
						}
						else if(seleccion_extra == 2)
						{
							System.out.println("Escriba los nuevos apellidos: ");
							apellidos = teclado.nextLine();
							Cliente clienteActualizado = new Cliente(clienteEncontrado.getIdCliente(), clienteEncontrado.getNombre(), apellidos, clienteEncontrado.getEmail(), clienteEncontrado.getDni(), clienteEncontrado.getClave());
							operacion.actualizarCliente(clienteActualizado);
						}
						else if(seleccion_extra == 3)
						{
							System.out.println("Escriba el nuevo email: ");
							email = teclado.nextLine();
							Cliente clienteActualizado = new Cliente(clienteEncontrado.getIdCliente(), clienteEncontrado.getNombre(), clienteEncontrado.getApellidos(), email, clienteEncontrado.getDni(), clienteEncontrado.getClave());
							operacion.actualizarCliente(clienteActualizado);
						}
						else if(seleccion_extra == 4)
						{
							System.out.println("Escriba el nuevo dni: ");
							dni = teclado.nextLine();
							Cliente clienteActualizado = new Cliente(clienteEncontrado.getIdCliente(), clienteEncontrado.getNombre(), clienteEncontrado.getApellidos(), clienteEncontrado.getEmail(), dni, clienteEncontrado.getClave());
							operacion.actualizarCliente(clienteActualizado);
						}
						else if(seleccion_extra == 5)
						{
							System.out.println("Escriba la nueva clave: ");
							clave = teclado.nextLine();
							Cliente clienteActualizado = new Cliente(clienteEncontrado.getIdCliente(), clienteEncontrado.getNombre(), clienteEncontrado.getApellidos(), clienteEncontrado.getEmail(), clienteEncontrado.getDni(), clave);
							operacion.actualizarCliente(clienteActualizado);
						}
						else
						{
							System.out.println("Error: el número " + seleccion_extra + " no es una opción valida");
						}
						System.out.println("Cliente actualizado");
					}
					break;

				case 4:
					System.out.println("Escriba el id del cliente a eliminar: ");
					id = teclado.nextInt();
					teclado.nextLine();
					clienteEncontrado = operacion.encontrarCliente(id);
					if(clienteEncontrado == null)
					{
						System.out.println("No existe un cliente con ese id");
					}
					else
					{
						Cliente clienteAEliminar = new Cliente(id);
						System.out.println("¿Esta seguro de querer eliminar el cliente?");
						System.out.println("1. Sí");
						System.out.println("2. No");
						seleccion_extra = teclado.nextInt();
						teclado.nextLine();
						if(seleccion_extra == 1)
						{
							System.out.println("Eliminando cliente...");
							operacion.eliminarCliente(clienteAEliminar);
							System.out.println("Cliente eliminado");
						}
						else if(seleccion_extra == 2)
						{
							System.out.println("Eliminación cancelada");
						}
						else
						{
							System.out.println("Error: el número " + seleccion_extra + " no es una opción valida");
						}
					}
					break;

				case 5:
					System.out.println("Saliendo del programa.");
					break;

				default:
					System.out.println("El número " + seleccion + " no corresponde a ninguna opción");
				}
			} while (seleccion != 5);
		}
		catch (InputMismatchException ime)
		{
			System.out.println("Error: solo se aceptan números");
		}
		teclado.close();
	}
}