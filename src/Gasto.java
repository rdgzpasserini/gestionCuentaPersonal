
public class Gasto extends Dinero {
	//Constructor 
	
		public Gasto(double gasto, String description) {
			this.dinero = gasto;
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
