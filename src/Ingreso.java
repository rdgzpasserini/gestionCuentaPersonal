
public class Ingreso extends Dinero{
	//Constructor 
	
		public Ingreso(double ingreso, String description) {
			this.dinero = ingreso;
	        this.description = description;
		}

		@Override
		public String toString() {
			java.text.DecimalFormatSymbols simbolos = new java.text.DecimalFormatSymbols(java.util.Locale.getDefault());
	        simbolos.setDecimalSeparator(',');

	        java.text.DecimalFormat formato = new java.text.DecimalFormat("#,##0.00", simbolos);
			return "Descripcion : " + description + " Cantidad : " + formato.format(dinero) + "€";
		}
}
