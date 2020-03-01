package banquito;

public class Cuenta {
	private int tarjeta;      //Delcaraciones de variables que se van a utilizar
	private float saldo;

	RegistroUs con = new RegistroUs();          
	public Cuenta(int cuenta, float fondo) {  //Es una funcion para que nos valide el numero de NIP Con el numero de tarjeta ingresada
		tarjeta = cuenta;
		saldo = fondo;
	}
	public void depositar(float dinero) {    //Esta es una funcion que nos permite depositar dinero
		saldo = saldo + dinero;
		con.actualizarFondo(saldo, tarjeta);
		}
	public void retirar(float dinero) {       //Esta parte nos permite poder realizar un retiro
		if(dinero>saldo) {                    //Esta parte es una condiconal que nos permitira verificar si tenemos saldo suficiente
			saldo = Integer.parseInt("Errorrrr");
			
		}else {
			saldo = saldo - dinero;
			con.actualizarFondo(saldo, tarjeta);
		}
		
	}
	public Usuario fondos() {               //Esta es una consulta de los fondos de la tarjeta del usuario
		Usuario user = new Usuario();
		user.setTarjeta(tarjeta);
		user = con.seleccionarPersona(user);
		
		return user;
	}
	public float saldo() {
		return saldo;
	}
	
	
	
}
