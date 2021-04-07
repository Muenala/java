
public class ValidarCedulaEcuatoriana{
	
	public static void main(String[] arg) {
		validarCedula("0931811087");
	}
	
	public static void validarCedula(String cedula) {

	     //Preguntamos si la cedula consta de 10 digitos
	     if(cedula.length() == 10){
	        
	        //Obtenemos el digito de la region que sonlos dos primeros digitos
	        String digito_region = cedula.substring(0,2);
	        
	        //Pregunto si la region existe ecuador se divide en 24 regiones
	        if( Integer.parseInt(digito_region) >= 1 && Integer.parseInt(digito_region) <=24 ){
	          
	          // Extraigo el ultimo digito
	          String ultimo_digito   = cedula.substring(9,10);

	          //Agrupo todos los pares y los sumo
	          int pares = Integer.parseInt(cedula.substring(1,2)) + Integer.parseInt(cedula.substring(3,4)) 
	          + Integer.parseInt(cedula.substring(5,6)) + Integer.parseInt(cedula.substring(7,8));

	          //Agrupo los impares, los multiplico por un factor de 2, si la resultante es > que 9 le restamos el 9 a la resultante
	          int numero1 = Integer.parseInt(cedula.substring(0,1));
	          numero1 = (numero1 * 2);
	          if( numero1 > 9 ){ numero1 = (numero1 - 9); }

	          int numero3 = Integer.parseInt(cedula.substring(2,3));
	          numero3 = (numero3 * 2);
	          if( numero3 > 9 ){ numero3 = (numero3 - 9); }

	          int numero5 = Integer.parseInt(cedula.substring(4,5));
	          numero5 = (numero5 * 2);
	          if( numero5 > 9 ){  numero5 = (numero5 - 9); }

	          int numero7 = Integer.parseInt(cedula.substring(6,7));
	          numero7 = (numero7 * 2);
	          if( numero7 > 9 ){ numero7 = (numero7 - 9); }

	          int numero9 = Integer.parseInt(cedula.substring(8,9));
	          numero9 = (numero9 * 2);
	          if( numero9 > 9 ){ numero9 = (numero9 - 9); }

	          int impares = numero1 + numero3 + numero5 + numero7 + numero9;

	          //Suma total
	          int suma_total = (pares + impares);

	          //extraemos el primero digito
	          String primer_digito_suma = String.valueOf(suma_total).substring(0,1);

	          //Obtenemos la decena inmediata
	          int decena = (Integer.parseInt(primer_digito_suma) + 1)  * 10;

	          //Obtenemos la resta de la decena inmediata - la suma_total esto nos da el digito validador
	          int digito_validador = decena - suma_total;

	          //Si el digito validador es = a 10 toma el valor de 0
	          if(digito_validador == 10)
	             digito_validador = 0;

	          //Validamos que el digito validador sea igual al de la cedula
	          if(digito_validador == Integer.parseInt(ultimo_digito)){
	        	  JOptionPane.showMessageDialog(null, "la cedula:" + cedula + " es correcta");
	            System.out.print("la cedula:" + cedula + " es correcta");
	          }else{
	        	  JOptionPane.showMessageDialog(null, "la cedula:" + cedula + " es incorrecta");
	        	  System.out.print("la cedula:" + cedula + " es incorrecta");
	          }
	          
	        }else{
	          // imprimimos en consola si la region no pertenece
	        	JOptionPane.showMessageDialog(null, "Esta cedula no pertenece a ninguna region");
	        	 System.out.print("Esta cedula no pertenece a ninguna region");
	        }
	     }else{
	        //imprimimos en consola si la cedula tiene mas o menos de 10 digitos
	    	 JOptionPane.showMessageDialog(null, "Esta cedula tiene menos de 10 Digitos");
	    	 System.out.print("Esta cedula tiene menos de 10 Digitos");
	     }    
	  
	}
}
