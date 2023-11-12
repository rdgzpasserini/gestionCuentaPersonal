/** PAC DESARROLLO M03B 1S2324
 *  Sigue las especificaciones del enunciado de la pac de Desarrollo
 *  No se puede importar ninguna otra clase, dentro de esta clase.
 *  Obligatorio utilizar esta plantilla
 *  
 */
public class Usuario {
	//Atributos
	
		 private String nombre;
		 private int edad; 
		 private String DNI;
		 
		//Constructor 
		 
		 public Usuario() {
			 
		 }
		 
		 
		//Getters & Setters 

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public int getEdad() {
			return edad;
		}

		public void setEdad(int edad) {
			this.edad = edad;
		}

		public String getDNI() {
			return DNI;
		}

		public boolean setDNI(String dni) {
		    // Expresión regular para validar el DNI
		    String regex = "^[0-9]{8}[-]?[qwertyuiopasdfghjklzxcvbnm]{1}$";

		    // Comprobar si el DNI coincide con la expresión regular
		    if (dni.matches(regex)) {
		        this.DNI = dni;
		        return true;
		    } else {
		        return false;
		    }
		}



		@Override
		public String toString() {
			return "Nombre : \"" + nombre + "\" edad : " + edad + " DNI : " + DNI;
		}
}
