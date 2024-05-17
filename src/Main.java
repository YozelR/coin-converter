import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {


        Request requests = new Request();


            String salir = "1";

            while (true) {

                System.out.println("\n*************************************" +
                                    "\n CONVERSOR DE MONEDAS" +
                                    "\n*************************************" +
                                    "\n");

                Scanner lectura = new Scanner(System.in);
                System.out.println("Escriba la moneda a convertir: \n" +
                                    "\nUSD - Dolar Estadounidense " +
                                    "\nARS - Peso Argentino " +
                                    "\nBOB - Peso Boliviano" +
                                    "\nBRL - Real Brasileno " +
                                    "\nCLP - Peso Chileno " +
                                    "\nMXN - Peso Mexicano" +
                                    "\nCOP - Peso Colombiano" +
                                    "\n1 - Salir");

                var baseCoin = lectura.nextLine();

                if (baseCoin.equals("1")) {
                    System.out.println("Gracias por usar nuestro conversor!");
                    break;
                }


                Scanner lectura2 = new Scanner(System.in);
                System.out.println("Escriba la moneda a convertir: \n" +
                                    "\nUSD - Dolar Estadounidense " +
                                    "\nARS - Peso Argentino " +
                                    "\nBOB - Peso Boliviano" +
                                    "\nBRL - Real Brasileno " +
                                    "\nCLP - Peso Chileno " +
                                    "\nMXN - Peso Mexicano" +
                                    "\nCOP - Peso Colombiano" +
                                    "\n1 - Salir");

                var targetCoin = lectura2.nextLine();

                if (targetCoin.equals("1")) {
                    System.out.println("Gracias por usar nuestro conversor!");
                    break;
                }

                System.out.println("Que cantidad desea convertir?");

                Scanner lectura3 = new Scanner(System.in);
                double baseQuantity = lectura3.nextDouble();

                RecordRequest recordRequest = requests.request(baseCoin, targetCoin, baseQuantity);

            }

        System.out.println("Se finalizo el programa!");
    }

}