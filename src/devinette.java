import java.util.Random;
import java.util.Scanner;


public class devinette {
	
	// Variable jeu devinette 
	static int numeroSecret = (int) (Math.random() * 1000 + 1);
    static Scanner sc = new Scanner(System.in);
    static char rejouer = 'O';
    
    // Variable jeu allumette 
	
    static int NumAllumette = 3;
    static int nbAllumette = 20;
    static Random randomAllu = new Random() ;
    static int choixPC;
    static int choixJ1;
    
    // Variable Chifoumi 
    
    static String[] sign = {"caillou","ciseau","papier"};
    static String user;
    static String computer;
    static int userScore = 0;
    static int computerScore = 0;
    static int score=0;
    static int gameDone=5;
    
    // Variable pendu 
    
    static String mot;
    static char [] tabMot;
    static int tMot;
    static char [] tabMystere;
    static char choix;
    static int n = tMot;
    
    
    

	
	
	public static void jeuDevinette() { 
	
	boolean win = false;
	
	do {
	
	for (int i =0; i<10; i++) {
	System.out.println("Devinez un numéro entre 1 et 1000");
	int reponse = sc.nextInt();
	
	if (reponse>1000) {
		System.out.println("Vous avez saisi un nombre superieur à 1000 !");
	}
	else if (reponse > numeroSecret) {
		System.out.println("Trop grand");
	}
	
	else if (reponse <1) {
		System.out.println("vous avez saisi un nombre inferieur à 1000");
	}
	else if ( reponse< numeroSecret) {
		System.out.println("Trop petit");
	}
	
	else {
		System.out.println("c'est gagné");
		win = true;
		break;
		
	}
	
	
	}
	
	if (win == false) {
	System.out.println("Tu as utilisé tes 10 essais tu as perdu ! La reponse était " + numeroSecret);
	
	}
	System.out.println("Veux tu rejouer ? O/N ");
	sc.nextLine();
	rejouer = sc.nextLine().charAt(0);
	
	
	}while(rejouer =='O' );
	
	System.out.println("Au revoir");
	} 
	
	public static int userPlay() {
		do {
	    	
	    	 System.out.println("Choisissez un chiffre entre 1 et 3");
	    	 choixJ1 = sc.nextInt();
	    	 if(choixJ1<1 || choixJ1>3) {
	    	    	System.out.println("Vous devez choisir une valeur comprise entre 1 et 3");  
	    	      }
	      	
	      } while(choixJ1<1 || choixJ1>3);
	      
	     return choixJ1;
	}
	
	public static int computerPlay() {

	    choixPC = randomAllu.nextInt(NumAllumette)+1 ;
	    System.out.println("choix pc : " + choixPC);
		System.out.println("-----------------------------------");	
		return choixPC;
		}
	
	public static int CounterUser(){
	    nbAllumette = nbAllumette - choixJ1;
	    return nbAllumette;
	}
	
	public static int CounterComputer() {
	    nbAllumette = nbAllumette - choixPC;
	    return nbAllumette;
	}
	
	public static void jeuAllumette() {
	do {
			System.out.println("Il y reste " + nbAllumette + " allumettes");
			System.out.println("-----------------------------------");	
			choixJ1 = userPlay();
			System.out.println("-----------------------------------");	
			nbAllumette=CounterUser();
				if (nbAllumette <=1) {
					System.out.println("Tu as gagné");
				}
			choixPC = computerPlay();
			nbAllumette = CounterComputer();

				if (nbAllumette <=1) {
					System.out.println("L'ordinateur a gagné");
				}
       
	 }while(nbAllumette>0);
}
	
	
public static String userChifoumi() {
	
	user = sc.nextLine();
	return user;
}

public static String computerChifoumi() {
	int i = (int) (Math.random() * 3);
	computer = sign[i];
	System.out.println("Ordinateur a joué : " + computer);
	System.out.println("--------------------------------");

	return computer;
}

public static int counterPointUser() {
	if (user.equals(computer)) {
		userScore = userScore + 0;
		System.out.println("égalité");
	}
	else if ((user.equals("caillou")) && (computer.equals("ciseau"))){
		userScore = userScore + 1;
	}
	else if ((user.equals("papier")) && (computer.equals("caillou"))) {
		userScore = userScore + 1;
	}
	else if  ((user.equals("ciseau"))&& (computer.equals("papier"))){
		userScore = userScore + 1;
	}
	else {
		userScore = userScore + 0;
	}
	return userScore;
}

public static int counterPointComputer() {
	if(computer.equals(user)) {
		computerScore = computerScore + 0;
	}
	else if  ((computer.equals("caillou")) && (user.equals("ciseau"))) {
		computerScore = computerScore + 1;
	}
	else if ((computer.equals("papier")) && (user.equals("caillou"))){
		computerScore = computerScore + 1;
	}
	else if  ((computer.equals("ciseau")) && (user.equals("papier"))){
		computerScore = computerScore + 1;
	}
	else {
		computerScore = computerScore + 0;
	}
	return computerScore;
}


public static void winnerParty() {
	if (userScore == gameDone) {
		System.out.println("User a gagné la partie avec un score de " + userScore+" et le score de computer : " + computerScore);
	}
	else if (computerScore == gameDone) {
		System.out.println("computer a gagné la partie avec un score de " + computerScore+" et le score de user : " + userScore);
	}
	
	
}

public static void jeuChifoumi() {
	
	do{	
		
		System.out.println("Choisissez entre caillou, ciseaux ou papier");
		user = userChifoumi();
		computer = computerChifoumi();
		userScore = counterPointUser();
		computerScore = counterPointComputer();
		System.out.println("Le Score est : ");
		System.out.println("User : " + userScore + " ordinateur : " + computerScore);
		System.out.println("--------------------------");
		winnerParty();
	}while( (gameDone>=userScore) || (gameDone>=computerScore));
	System.out.println("merci d'avoir participé");
}

// pendu 

public static String choixMot() {
	System.out.println("Entrez un mot à deviner");
	mot = sc.nextLine();
	return mot;
}

public static int tailleMot() {
	tMot= mot.length();
	return tMot;
}

public static char [] tabMot() {

    tabMot = new char [tMot];
    
    for (int i=0; i<tMot ; i++) {     
    	tabMot[i]= mot.charAt(i);    
    }
    return tabMot;
	
}

public static char [] tabMystere() {
tabMystere= new char [tMot];
for(int i =0; i<tMot;i++) {
	tabMystere[i] = '*';
}

return tabMystere;
}

public static char choixUtilisateur() {
	System.out.println("Choisissez une lettre");
	choix = sc.nextLine().charAt(0);
	return choix;
}

public static int resteAtrouver(){
	return n;
}

public static void jeuPendu() {


	mot = choixMot();
	for (int i =0; i<10; i++) {
		System.out.println("-----------------------------------");
	}
tMot= tailleMot();
tabMot = tabMot();
tabMystere = tabMystere();
	for(int i = 0;i<tMot;i++) {
		System.out.print(tabMystere[i]);
	}
do {
	choix = choixUtilisateur();
 		for(int i = 0;i<tMot;i++) {
			if (choix == tabMot[i]) {
				tabMystere[i] = choix;
				n = resteAtrouver();
				n = n-i;
					
		}
	System.out.print(tabMystere[i]);

 		}
	}while(n!=0);


}
	
	
	
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int choixJeu;
		do {
		System.out.println("Pour jouer au devinette tapes 1, pour jouer aux allumettes tapes 2 et pour jouer à chifoumi tapes 3");
		choixJeu = sc.nextInt();
		} while(choixJeu !=1 && choixJeu !=2 && choixJeu !=3);
		
		if (choixJeu==1){
			jeuDevinette();
		}
		 
		else if (choixJeu==2) {
		
		jeuAllumette();
		}
		else {
		sc.nextLine();
		jeuChifoumi();
		}
		
		//jeuPendu();
		
	}
		

}
