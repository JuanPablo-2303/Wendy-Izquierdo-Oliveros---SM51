package banquito;

import java.util.Random;
import java.util.Scanner;

public class Principal {

	public static void main(String []args) {
		Scanner lector = new Scanner (System.in);        //Esta parte es declaracion de variables, la parte del Scanner para poder insertar desde la consola
		Usuario user = new Usuario();
		RegistroUs con = new RegistroUs();
		Cuenta cuen;                         
		int eleccion = 0;
		int ele = 0;
		int randomInt = 0;
		int randomnum = 0;
		float fondo = 0, res=0;                     
	    int estatus=0;
		int tarjeta;
		float dinero = 0;                         // Aqui termina la declaracion de variables
		
		Random rand = new Random();               //Esta parte es para que nos genere un numero Random de 9 Digitos
		
		randomInt = rand.nextInt(6553);          //Este es un numero Random que uso genera para un NIP
		randomnum = rand.nextInt(1234567890);    //Este partes nos genera el numero de tarjeta 
		System.out.println("==========¿Que desea realizar? =========== \n1.°°°° Crear Usuario°°°° \n2.°°°° Cajero °°°°");   //Este es un mensaje de decision que es lo que desea el usuario realizar o llevar acabo
		eleccion = lector.nextInt();
		
			switch(eleccion) {
			case 1: 
				
				System.out.println("**** Bienvenido al Banco ****");     //Es un mensaje de bienvenida para el usuario
				user.setId(randomInt);
				user.setTarjeta(randomnum);
			
				System.out.println(" °Ingrese su nombre °: ");           //Esta parte es un mesaje que nos indica rellenar ciertos datos solicitados
				user.setNombre(lector.next());
				
				System.out.println(" °Ingrese su apellido° ");
				user.setApellP(lector.next());
				System.out.println(" °Ingrese su apellido materno° ");
				user.setApellM(lector.next());
				con.calculo(user);
				System.out.println(" °Ingrese su fondo inicial° ");
				user.setFondos(lector.nextFloat());
				user.setTarjeta(randomnum);
				user.setNIP(randomInt);
				
				System.out.println("°°°° Usuario creado con Exito :D °°°° ");                //Est parte es un mesnaje del usuario creado
				con.insertarRegistro(user);                          //Es la funcion que nso permite guardar los datos anteriores
				
				user = con.seleccionarPersona(user);                 //Esta funcion nos permite realizar una consulta
				
				System.out.println("Tarjeta\n"+user.getTarjeta());   //Aqui es para que nos imprima el numero de tarjeta generado
				
				System.out.println(user);                            //Esta parte es para que nos imprima los datos ingresados
				break;
				
			case 2:                                                    
					try{                                           //Es una condiconal de validacion, que  valida si coninciden el NIP con el numero de tarjeta
						System.out.println("Ingrese su tarjeta");
						tarjeta = lector.nextInt();
						System.out.println("Ingrese su NIP  ");
						user.setNIP(lector.nextInt());
						//user.setTarjeta(tarjeta);
						user = con.seleccionarPersona(user);      //El TRY CATCH lo utilizamos porque es propenso a que no coincidan el numero de NIP con el numero de tarejta ingresado
						
						
						
					do {estatus++;
					    System.out.println("°|°|°|°|° MENÚ DEL BANCO °|°|°|°|°");
						System.out.println("°°°° ¿Qué desea realizar? °°°° \n1.°°°° Visualizacion fondo °°°° \n2.°°°° Retirar °°°° \n3.°°°° Depositar °°°° \n4.°°°° Salir °°°°");  //Opciones que desea realizar el usuario
						System.out.println("NOTA: Primero tienes que depositar o retirar, despues darle la opcion de visualizacion de fondo, despues darle el numero 1 y ya puedes retirar o depositar");
						ele = lector.nextInt();
						fondo = user.fondo();
						cuen = new Cuenta(tarjeta,fondo);
						switch(ele) {
						case 1:  
							
							System.out.println(cuen.fondos());
								
							break;
						case 2:
							
							System.out.println("°°°° Cuanto desea retirar °°°°");      //Este es un mensaje de retirar dinero
							dinero = lector.nextFloat();
							cuen.retirar(dinero);
							System.out.println(cuen.saldo());
							
							
							break;
						case 3:
							
							
							System.out.println("°°°° Cuanto desea depositar °°°°");    //Este es un mensaje de so desea el usuario depositar
							dinero = lector.nextFloat();
							cuen.depositar(dinero);
							System.out.println(cuen.saldo());
							break;
						case 4:
							estatus = lector.nextInt();
							break;
						
						}
						
						
					
					}while(estatus==1);
					System.out.println("Adios Gusto tenerte ");     //Mensaje de Adios es cuando le damos la opcion de salir
					}catch(Exception e) {
						System.out.println("Error :( ");      //Muestra este mensaje cuando se ingresa un dato erroneo
					}
					
					System.out.println("°°°° ¿Desea realizar otro movimiento? °°°°° \n °°Si°°: Presione 1 \n °°No°°: Presione 0");   //Este es un mensaje que si el usuario de desea realizar otro movimiento
					estatus = lector.nextInt();
				break;
			
			}	
		
		
			Principal.main(null);      //En esta partes nos regresa al menu pincipal
		
	}
	
}

