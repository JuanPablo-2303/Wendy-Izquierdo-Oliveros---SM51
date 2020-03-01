package banquito;

public class Usuario {
	private int id;                  //Iniciamos la declaracion de variables para al momento de registrar un nuevo usuario que se alamacenaran en estas variables
	private String nombre;
	private String apellP;
	private String apellM;
	private int NIP;
	private int tarjeta;
	private float fondos;
	private int edad;
	private String tutor;           //Aqui termina la declaracion
	
	public int getId() {           // Esta parte se crea los SETTER and GETTER para poder acceder a los datos que nosotros tenemos en privado
		return id;                 //las cuales no vana  permitir accder y modificar eesto datos desde otra clase
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellP() {
		return apellP;
	}
	public void setApellP(String apellP) {
		this.apellP = apellP;
	}
	public String getApellM() {
		return apellM;
	}
	public void setApellM(String apellM) {
		this.apellM = apellM;
	}
	public int getNIP() {
		return NIP;
	}
	public void setNIP(int nIP) {
		NIP = nIP;
	}
	public int getTarjeta() {
		return tarjeta;
	}
	public void setTarjeta(int tarjeta) {
		this.tarjeta = tarjeta;
	}
	public float getFondos() {
		return fondos;
	}
	public void setFondos(float fondos) {
		this.fondos = fondos;
	}
	@Override
	public String toString() {               //El toString lo usamos para convertir los datos que tenemos como ENTEROS a SRTING
		return "Usuario Tarjeta=" + tarjeta +"\nNIP= "+ NIP +"\nFondos= " + fondos+"\nEdad= "+edad+ "\n Tutor: "+tutor;
	}
	
	public float fondo() {
		return fondos;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getTutor() {
		return tutor;
	}
	public void setTutor(String tutor) {
		this.tutor = tutor;
	}
	
	
}
