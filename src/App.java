import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import com.conversor.modelo.Divisa;
import com.conversor.modelo.OpcionConversion;

/**
 * @author ezequiel
 *
 */
public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Divisa divisaBase = new Divisa("Peso", 1.00);

		List<Divisa> divisas = new ArrayList<Divisa>();

		divisas.add(new Divisa("Dólar", 0.00814));
		divisas.add(new Divisa("Euro", 0.007736));
		divisas.add(new Divisa("Libras Esterlinas", 0.006639));
		divisas.add(new Divisa("Yen Japonés", 1.099559));
		divisas.add(new Divisa("Won Sul-coreano", 10.503366));

		List<OpcionConversion> opciones = new ArrayList<OpcionConversion>();

		for (int i = 0; i < divisas.size(); i++) {
			opciones.add(new OpcionConversion(divisaBase, divisas.get(i)));
		}

		for (int i = 0; i < divisas.size(); i++) {
			opciones.add(new OpcionConversion(divisas.get(i), divisaBase));
		}

		OpcionConversion opcionElegida = (OpcionConversion) JOptionPane.showInputDialog(null, "Seleccione una opción ",
				"Opciones de conversi", JOptionPane.QUESTION_MESSAGE, null, opciones.toArray(), opciones.toArray()[0]);

		String entradaUsuario;
		Double valorConvertir = 0.0;

		boolean valorConvertirValido = false;

		while (!valorConvertirValido) {
			entradaUsuario = JOptionPane.showInputDialog("Ingrese el valor a convertir");

			try {
				valorConvertir = Double.parseDouble(entradaUsuario);
			} catch (NumberFormatException e) {
				continue;
			}

			if (!valorConvertir.isNaN() && valorConvertir > 0) {
				valorConvertirValido = true;
			}
		}

		Double valorConvertido = opcionElegida.getDivisaOrigen().convertir(valorConvertir, divisaBase, opcionElegida);

		String mensaje = "El valor convertido es: " + valorConvertido.toString();

		JOptionPane.showMessageDialog(null, mensaje);

		Object[] options = { "Sí", "No", "Cancelar" };
		int opcionContinuar = JOptionPane.showOptionDialog(null, "¿Desea continuar?", "Elija una opción",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

		switch (opcionContinuar) {
		case 0:
			opcionElegida = (OpcionConversion) JOptionPane.showInputDialog(null, "Seleccione una opción ",
					"Opciones de conversi", JOptionPane.QUESTION_MESSAGE, null, opciones.toArray(),
					opciones.toArray()[0]);
			break;
		case 1:
			JOptionPane.showMessageDialog(null, "Programa terminado");
			break;
		case 2:
			JOptionPane.showMessageDialog(null, "Programa terminado");
			break;
		}
	}

}
