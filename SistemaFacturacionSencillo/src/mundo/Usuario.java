package mundo;

public class Usuario {
	private String nombre;
	private String correo;
	private String contrasenia;
	public Usuario(String nombre, String correo, String contrasenia) {
		super();
		this.nombre = nombre;
		this.correo = correo;
		this.contrasenia = contrasenia;
	}
	public String getNombre() {
		return nombre;
	}
	public String getCorreo() {
		return correo;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	
	
	
}
