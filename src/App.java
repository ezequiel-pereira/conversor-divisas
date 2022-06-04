import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author ezequiel
 *
 */
public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Object[] opciones = { "Pesos a Dólares", "Dólares a pesos" };

		String opcionElegida = (String) JOptionPane.showInputDialog(null, "Seleccione una opción", "OPCIONES",
				JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

		double valorConvertir = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor a convertir"));

		switch (opcionElegida) {
		case "Pesos a Dólares":
			valorConvertir = valorConvertir / 200;
			break;

		case "Dólares a pesos":
			valorConvertir = valorConvertir * 200;
			break;

		default:
			break;
		}

		String mensaje = "El valor convertido es: " + valorConvertir;

		JOptionPane.showMessageDialog(null, mensaje);
	}

}
