import java.util.Scanner;

public class SistemaUtentiMain {
    public static void main(String[] args) {
        try(Scanner scannerNum = new Scanner(System.in); Scanner scannerStr = new Scanner(System.in)){// creato gli scanner all'interno di un try with resources
        int codice; //valore del comando selezionato
        String continua = new String(); // stringa per continuare
        
        do {
            System.out.println("Inserisci il codice per l'operazione desiderata:");
            System.out.println("1  Effttua la registrazione"); 
            System.out.println("2  Effettua il Login");
            System.out.println("3  ");
            //stampa menu
            codice = scannerNum.nextInt(); //input del codice selezionato
            switch (codice) {
                case 1://
                    
                    break;
            
                case 2://
                    
                    break;

                case 3://
                    
                    break;
                    
                default:
                    System.out.println("Codice dell'operazione errato"); //stampa codice non presente
                    break;
            }

            System.out.println("vuoi continuare? (si/no)"); //chiedo se vuole continuare
            continua = scannerStr.nextLine(); //input della risposta
        }while (!continua.equals("no")); //ciclo finchè continua è diverso da no
    } catch (Exception e) {
        e.printStackTrace();
    }
    }
    
}


