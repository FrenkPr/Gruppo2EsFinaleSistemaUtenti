import java.util.ArrayList;

class Utente
{
    //dichiarazione variabili istanza
    private String username;
    private String password;

    //metodo costruttore
    public Utente(String username, String password)
    {
        this.username = username;
        this.password = password;
    }

    //ritorna lo username
    public String getUsername()
    {
        return username;
    }

    //controlla se la password inserita è corretta o meno
    public boolean ControllaPassword(String inPassword)
    {
        return password.equals(inPassword);
    }
}

// class UtenteRegistrato extends Utente implements UtenteLoggabile
// {
//     public UtenteRegistrato(String username, String password)
//     {
//         super(username, password);
//     }

//     public void registraUtente();
// }

//factory method pattern
class UtenteFactory
{
    public static Utente creaUtente(String username, String password)
    {
        return new Utente(username, password);
    }
}

interface UtenteObservable
{
    public void notificaUtente(Utente u);
}

// interface UtenteRegistrabile
// {
//     public void registraUtente();
// }

interface UtenteLoggabile
{
    public void loginUtente();
}

class CentroGestioneUtenti
{
    private static CentroGestioneUtenti instance; //private instance of the singleton class
    ArrayList<Utente> utentiRegistrati;

    //private constructor to avoid direct instance
    private CentroGestioneUtenti()
    {
        utentiRegistrati = new ArrayList<>();
    }

    // returns the unique instance of this class
    public static CentroGestioneUtenti getInstance()
    {
        // creates a unique instance if not existing
        if (instance == null)
        {
            instance = new CentroGestioneUtenti();
        }

        // returns the unique instance
        return instance;
    }

    private boolean controlloUtenteEsistente(String username)
    {
        for (Utente utente : utentiRegistrati)
        {
            if(utente.getUsername().equals(username))
            {
                return true;
            }
        }

        return false;
    }

    public void registraUtente(String username, String password)
    {
        if(controlloUtenteEsistente(username))
        {
            System.out.println("Utente già esistente");
            return;
        }

        Utente nuovoUtente = UtenteFactory.creaUtente(username, password);
        utentiRegistrati.add(nuovoUtente);
    }
}

public class SistemaUtentiMain
{
    public static void main(String[] args)
    {
        //inits scanner inputs
        GlobalScanner.InitScannerInputs();

        //variables declaration & init
        int menuOption = 0;

        do
        {
            //menu description
            System.out.println("\nScegli quali operazioni eseguire:");
            System.out.println("1: registra un utente");
            System.out.println("2: login utente");
            System.out.println("0: esci");

            //menu input
            menuOption = GlobalScanner.readIntInput();
            System.out.print("\n");

            switch(menuOption)
            {
                //option 1
                case 1:
                    CentroGestioneUtenti gestioneUtenti = CentroGestioneUtenti.getInstance();
                    String username = GlobalScanner.readStringInput("Inserire username", "Inserire uno username valido", true);
                    String password = GlobalScanner.readStringInput("Inserire la password", "password non valida", true);

                    gestioneUtenti.registraUtente(username, password);
                    break;

                //option 2
                case 2:
                    break;

                //exit
                case 0:
                    break;

                //menu input not available
                default:
                    System.out.println("Insert a valid option");
                    break;
            }
        }
        while(menuOption != 0);

        //closes scanner inputs
        GlobalScanner.CloseScannerInputs();
    }
}
