import java.util.Scanner;
/** PAC DESARROLLO M03B 1S2324
 *  Sigue las especificaciones del enunciado de la pac de Desarrollo
 *  No se puede importar ninguna otra clase, dentro de esta clase.
 *  Obligatorio utilizar esta plantilla
 *  
 */
public class Main {

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        boolean salir = false;
        Cuenta cuenta = null;

        while (!salir) {
            mostrarMenu();
            int opcion = sc.nextInt();
            sc.nextLine(); 

            switch (opcion) {
                case 1:
                    Usuario usuario = LeerUsuario(sc);
                    cuenta = new Cuenta(usuario);
                    break;
                case 2:
                    if (cuenta != null) {
                        addGastos(cuenta, sc);
                    } else {
                        System.out.println("Debe crear un usuario primero.");
                    }
                    break;
                case 3:
                    if (cuenta != null) {
                        addIngresos(cuenta, sc);
                    } else {
                        System.out.println("Debe crear un usuario primero.");
                    }
                    break;
                case 4:
                    if (cuenta != null) {
                        imprimirGastos(cuenta);
                    } else {
                        System.out.println("Debe crear un usuario primero.");
                    }
                    break;
                case 5:
                    if (cuenta != null) {
                        imprimirIngresos(cuenta);
                    } else {
                        System.out.println("Debe crear un usuario primero.");
                    }
                    break;
                case 6:
                    if (cuenta != null) {
                        mostrarSaldo(cuenta);
                    } else {
                        System.out.println("Debe crear un usuario primero.");
                    }
                    break;
                case 0:
                    System.out.println("Fin del programa.\r\nGracias por utilizar la aplicación de M03B en el curso 1s2324.");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elija una opción válida.");
                    break;
            }
        }

        sc.close();
    }


/**** Mostrar las distintas opciones validas del Menu de Opciones ****/
    public static void mostrarMenu(){
    	System.out.println("\n  Realizar una nueva accion: ");
        System.out.println("   (1) Crear usuario");
        System.out.println("   (2) Introducir un nuevo gasto");
        System.out.println("   (3) Introducir un nuevo ingreso");
        System.out.println("   (4) Mostrar gastos");
        System.out.println("   (5) Mostrar ingresos");
        System.out.println("   (6) Mostrar saldo");
        System.out.println("   (0) Salir");
        System.out.print("#:");
    }

    
/**** Función que lee por teclado los datos del usuario y los devuelve como un objeto de tipo Usuario. ****/
    private static Usuario LeerUsuario(Scanner sc){
    	
    	Usuario usuario = new Usuario();
    	
    	System.out.print("Introduzca un nombre : ");
        usuario.setNombre(sc.nextLine());

        System.out.print("Introduzca la edad : ");
        usuario.setEdad(sc.nextInt());
        sc.nextLine();

        boolean dniValido = false;
        while (!dniValido) {
            System.out.print("Introduzca su DNI : ");
            String dni = sc.nextLine();
            dniValido = usuario.setDNI(dni);

            if (!dniValido) {
                System.out.println("El DNI introducido es incorrecto. Por favor, introduzca su DNI correctamente.");
            }
        }

        System.out.println("Usuario creado correctamente");
        System.out.println(usuario.toString());

        return usuario;
    }

    
/**** Funcion que lee por teclado un ingreso, lo agrega a la lista de ingresos y muestra mensaje ****/
    private static void addIngresos(Cuenta cuenta, Scanner sc) {
    	System.out.print("Introduzca la descripción del ingreso: ");
        String descripcionIngreso = sc.nextLine();

        System.out.print("Introduzca la cantidad del ingreso: ");
        double montoIngreso;
        try {
            montoIngreso = Double.parseDouble(sc.nextLine().replace(',', '.')); // Reemplaza comas con puntos
        } catch (NumberFormatException e) {
            System.out.println("Error al convertir la cantidad. Asegúrese de ingresar un número válido.");
            return;
        }

        cuenta.addIngresos(descripcionIngreso, montoIngreso);
        // Formatear el saldo restante con dos decimales y coma
        double saldoRestante = cuenta.getSaldo();
        String saldoRestanteFormateado = String.format("%.2f", saldoRestante).replace('.', ',');
        System.out.println("\nSaldo restante : " + saldoRestanteFormateado + " €");
    }

    
/**** Muestra por pantalla el listado de ingresos ****/
    private static void imprimirIngresos(Cuenta cuenta){
    	System.out.println("Lista de Ingresos:");
        java.util.ArrayList<Ingreso> ingresos = cuenta.getIngresos();
        for (Ingreso ingreso : ingresos) {
            System.out.println(ingreso.toString());
        }
        // Formatear el saldo restante con dos decimales y coma
        double saldoRestante = cuenta.getSaldo();
        String saldoRestanteFormateado = String.format("%.2f", saldoRestante).replace('.', ',');
        
        System.out.println("\nSaldo restante : " + saldoRestanteFormateado + " €");
    }

/**** Funcion que lee por teclado un Gasto y lo agrega a la lista de gastos  y muestra mensaje ****/
    private static void addGastos(Cuenta cuenta, Scanner sc) {
    	
    	double montoGasto = 0;
        try {
            System.out.print("Introduzca la descripción del gasto: ");
            String descripcionGasto = sc.nextLine();

            System.out.print("Introduzca la cantidad del gasto: ");
            montoGasto = Double.parseDouble(sc.nextLine().replace(',', '.')); 
            cuenta.addGastos(descripcionGasto, montoGasto);
            
            // Formatear el saldo restante con dos decimales y coma
            double saldoRestante = cuenta.getSaldo();
            String saldoRestanteFormateado = String.format("%.2f", saldoRestante).replace('.', ',');
            System.out.println("\nSaldo restante : " + saldoRestanteFormateado + " €");
        } catch (GastoException e) {
            System.out.println(e.getMessage());
            
            // Formatear el saldo restante con dos decimales y coma
            double saldoRestante = cuenta.getSaldo();
            String saldoRestanteFormateado = String.format("%.2f", saldoRestante).replace('.', ',');
            System.out.println("\nSaldo restante : " + saldoRestanteFormateado + " €");
        }
    }

/**** Muestra por pantalla el listado de gastos ****/
    private static void imprimirGastos(Cuenta cuenta){
    	System.out.println("Lista de Gastos:");
        java.util.ArrayList<Gasto> gastos = cuenta.getGastos();
        for (Gasto gasto : gastos) {
            System.out.println(gasto.toString());
        }
        
        // Formatear el saldo restante con dos decimales y coma
        double saldoRestante = cuenta.getSaldo();
        String saldoRestanteFormateado = String.format("%.2f", saldoRestante).replace('.', ',');
        System.out.println("\nSaldo restante : " + saldoRestanteFormateado + " €");
    }
    
/**** Muestra por pantalla mostrar saldo ****/
    private static void mostrarSaldo(Cuenta cuenta) {
        double saldo = cuenta.getSaldo();
        
        String saldoFormateado = String.format("%.2f", saldo).replace('.', ',');
        
        System.out.println("Usuario= " + cuenta.getUsuario().getNombre() + "\tSaldo= " + saldoFormateado + " €");
    }
}
