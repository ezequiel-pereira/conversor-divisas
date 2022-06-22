import java.util.ArrayList;
import java.util.List;

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
		
		List<Divisa> divisas = new ArrayList<Divisa>();
		
		divisas.add(new Divisa("Peso", 1.00));
		divisas.add(new Divisa("Dólar", 0.00814));
		divisas.add(new Divisa("Euro", 0.007736));
		divisas.add(new Divisa("Libras Esterlinas", 0.006639));
		divisas.add(new Divisa("Yen Japonés", 1.099559));
		divisas.add(new Divisa("Won Sul-coreano", 10.503366));
		
		List<OpcionConversion> opciones = new ArrayList<OpcionConversion>();
		
		for (int i = 1; i < divisas.size(); i++) {
			opciones.add(new OpcionConversion(divisas.get(0), divisas.get(i)));
		}
		
		for (int i = 1; i < divisas.size(); i++) {
			opciones.add(new OpcionConversion(divisas.get(i), divisas.get(0)));
		}

		OpcionConversion opcionElegida =  (OpcionConversion) JOptionPane.showInputDialog(null, "Seleccione una opción ", "Opciones de conversi",
				JOptionPane.QUESTION_MESSAGE, null, opciones.toArray(), opciones.toArray()[0]);
		
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
		
		Divisa divisaOrigen = opcionElegida.getDivisaOrigen();
		Divisa divisaDestino = opcionElegida.getDivisaDestino();
		
		Double valorConvertido = divisaOrigen.convertir(valorConvertir, divisaDestino);
		
		String mensaje = "El valor convertido es: " + valorConvertido.toString();

		JOptionPane.showMessageDialog(null, mensaje);
	}

}
