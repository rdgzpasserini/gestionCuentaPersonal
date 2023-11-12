/** PAC DESARROLLO M03B 1S2324
 *  Sigue las especificaciones del enunciado de la pac de Desarrollo
 *  No se puede importar ninguna clase, dentro de esta clase.
 *  Obligatorio utilizar esta plantilla
 *  
 */
public class GastoException extends Exception{
	public GastoException() {
		 super("La cantidad del gasto excede el saldo de su cuenta");
	}
}
