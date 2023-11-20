
import java.util.ArrayList;
import java.util.List;

public class Cuenta {

	//Atributos
	
		private double saldo=0;
		private Usuario usuario;
		private ArrayList<Gasto> gastos;
		private ArrayList<Ingreso> ingresos;

		//Constructor 
		
		public Cuenta(Usuario usuario) {
			this.usuario=usuario;
			this.ingresos = new ArrayList<>();
		    this.gastos = new ArrayList<>();
		}

		//Getters & Setters 
		
		public double getSaldo() {
			return saldo;
		}

		public void setSaldo(double saldo) {
			this.saldo = saldo;
		}

		public Usuario getUsuario() {
			return usuario;
		}

		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}
		
		
		public ArrayList<Gasto> getGastos() {
			return gastos;
		}

		public ArrayList<Ingreso> getIngresos() {
			return ingresos;
		}
		
		//Metodos 

		public double addIngresos(String description, double cantidad) {
			Ingreso ingreso = new Ingreso(cantidad, description);
		    ingresos.add(ingreso);
		    saldo += cantidad;
			return cantidad;
			
		}
		
		public double addGastos(String description, double cantidad) throws GastoException {
			
			if (saldo < cantidad) {
		        throw new GastoException();
		    }
			
			Gasto gasto = new Gasto(cantidad, description);
		    gastos.add(gasto);
		    saldo -= cantidad;
			return cantidad;
			
		}

		@Override
		public String toString() {
			String saldoFormateado = String.format("%.2f", saldo).replace('.', ',');

	        return "Cuenta [saldo=" + saldoFormateado + "€, usuario=" + usuario + ", gastos=" + gastos + ", ingresos=" + ingresos + "]";
		}
}
