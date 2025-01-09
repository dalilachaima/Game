package Game;
import java.util.Scanner;
public class Play02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
      // Initialisation des personnages
        Personnage guerrier = new Guerrier("Thor");
        Personnage mage = new Mage("Floki");
        Personnage voleur = new Voleur("Loki");
        
        // Choix du personnage par le joueur
        System.out.println("Choisissez votre personnage :");
        System.out.println("1. Guerrier");
        System.out.println("2. Mage");
        System.out.println("3. Voleur");

        int choix = scanner.nextInt();
        Personnage joueur;

        switch (choix) {
            case 1:
                joueur = guerrier;
                break;
            case 2:
                joueur = mage;
                break;
            case 3:
                joueur = voleur;
                break;
            default:
                System.out.println("Choix invalide. Le guerrier est sélectionné par défaut.");
                joueur = guerrier;
        }

        // Boucle de combat
        while (guerrier.estVivant() || mage.estVivant() || voleur.estVivant()) {
            System.out.println("\n--- Tour de combat ---");
            System.out.println("Choisissez une action :");
            System.out.println("1. Attaquer un adversaire");
            System.out.println("2. Utiliser compétence spéciale");
            System.out.println("3. Passer son tour");

            int action = scanner.nextInt();

            // Actions du joueur
            switch (action) {
                case 1:
                    System.out.println("Choisissez un adversaire :");
                    if (mage.estVivant()) System.out.println("1. " + mage.getNom());
                    if (voleur.estVivant()) System.out.println("2. " + voleur.getNom());

                    int cible = scanner.nextInt();

                    if (cible == 1 && mage.estVivant()) {
                        joueur.attaquer(mage, mage.defensePhysique);
                    } else if (cible == 2 && voleur.estVivant()) {
                        joueur.attaquer(voleur, voleur.defensePhysique);
                    } else {
                        System.out.println("Cible invalide ou déjà vaincue.");
                    }
                    break;

                case 2:
                    System.out.println("Choisissez un adversaire :");
                    if (mage.estVivant()) System.out.println("1. " + mage.getNom());
                    if (voleur.estVivant()) System.out.println("2. " + voleur.getNom());

                    cible = scanner.nextInt();

                    if (cible == 1 && mage.estVivant()) {
                        joueur.utiliserCompetence(mage, mage.defensePhysique);
                    } else if (cible == 2 && voleur.estVivant()) {
                        joueur.utiliserCompetence(voleur, voleur.defensePhysique);
                    } else {
                        System.out.println("Cible invalide ou déjà vaincue.");
                    }
                    break;

                case 3:
                    System.out.println(joueur.getNom() + " passe son tour.");
                    break;

                default:
                    System.out.println("Action invalide.");
                    break;
            }

            // Vérification des états des adversaires
            if (mage.estVivant()) {
                mage.attaquer(joueur, joueur.defensePhysique);
                if (!joueur.estVivant()) {
                    System.out.println(joueur.getNom() + " est vaincu !");
                    break;
                }
            }

            if (voleur.estVivant()) {
                voleur.attaquer(joueur, joueur.defensePhysique);
                if (!joueur.estVivant()) {
                    System.out.println(joueur.getNom() + " est vaincu !");
                    break;
                }
            }

            if (!guerrier.estVivant() && !mage.estVivant() && !voleur.estVivant()) {
                System.out.println("Tous les adversaires ont été vaincus !");
                break;
            }
        }

        scanner.close();
        System.out.println("Le combat est terminé !");
    }
}
