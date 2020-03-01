package banquito;
import java.util.Scanner;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class RegistroUs {
	Scanner teclado = new Scanner(System.in);              //Declaramos el teclado para poder escribir en consola
	private ObjectContainer db = null;                     //Estamos declarando el db4oObject para que podamos guardar los datos
	
	private void abrirRegistro() {                        //Abre el registro
		db = Db4oEmbedded.openFile("°°°° Registro usuario °°°°");   
	}
	private void cerrarRegistro() {
		db.close();
	}                                                    //Cierra la funcion de registro
	public void insertarRegistro(Usuario u) {            //Esta es la funcion que vamos a llamar para insertar datos
		abrirRegistro();
		db.store(u);
		cerrarRegistro();
	}
	public Usuario seleccionarPersona(Usuario u) {      //Esta parte es para poder hacer una consulta de un dato o un usuario registrado
		abrirRegistro();
		ObjectSet resultado = db.queryByExample(u);
		Usuario usuario = (Usuario) resultado.next();
		cerrarRegistro();
		return usuario;
	}
	public void actualizarFondo(float fondo, int id) {   //Esta parte es para actualizar los datos de un usario que se desee 
		abrirRegistro();
		Usuario u = new Usuario();
		u.setTarjeta(id);
		
		ObjectSet resultado = db.queryByExample(u);
		Usuario preresultado = (Usuario) resultado.next();
		preresultado.setFondos(fondo);
		db.store(preresultado);
		cerrarRegistro();
		
	}
	public void  calculo(Usuario u) {                    //Esta funcion es para calcular la edad del usuario que se va registra en el sistema 
		System.out.println("Ingresa su año de nacimiento: ");
		int a_n = teclado.nextInt();
		System.out.println("Ingresa el año actual: ");
		int a_a = teclado.nextInt();
		int cal = a_a - a_n;         //Esta parte se declaro la variable calculo la cual el año actual se le va restar a su año de nacimiento del usuario
		System.out.println("Su edad es de: "+cal);
		if(cal < 18) {                                   // Esta parte es una condiconal que nos va servir para verificar si es mayor de edad o NO
			System.out.println("Ingresa el nombre del tutor: ");   //Si es menor de edad nos pedira el nombre del tutor para registrarse al sistema
			u.setTutor(teclado.next());
		}else {
			System.out.println("Eres mayor de edad :D"); //Este es un mesnaje donde te dice que eres mayor de edad
			u.setEdad(cal);
			
		}
	}
	
}
