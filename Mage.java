package Game;
public class Mage extends Personnage {
    public Mage(String nom) {
        super(nom, 80, 15, 0.30, 50); // Points de vie : 80, dégâts : 15, défense physique : 30%, mana : 50
    }
    @Override
    public void attaquer(Personnage cible, double defensePhysique) {
        if (mana >= 5) { // Vérifie si le mage a assez de mana pour attaquer
            System.out.println(nom + " lance un sort sur " + cible.getNom() + " !");
            cible.recevoirDegats(degats);
            mana -= 5; // Réduction du mana après une attaque
            System.out.println(nom + " utilise 5 points de mana. Mana restant : " + mana);
        } else {
            System.out.println(nom + " n'a pas assez de mana pour attaquer !");
        }
    }
    @Override
    public void utiliserCompetence(Personnage cible, double defensePhysique) {
        if (mana >= 20) { // Vérifie si le mage a assez de mana pour utiliser sa compétence spéciale
            System.out.println(nom + " invoque une tempête magique sur " + cible.getNom() + " !");
            cible.recevoirDegats(degats + 20); // Dégâts accrus pour la compétence
            mana -= 20; // Réduction du mana après l'utilisation de la compétence
            System.out.println(nom + " utilise 20 points de mana. Mana restant : " + mana);
        } else {
            System.out.println(nom + " n'a pas assez de mana pour utiliser sa compétence spéciale !");
        }
    }

    // Ajout d'une méthode spécifique pour le mage
    public void regenererMana(int quantite) {
        super.regenererMana(quantite); // Appelle la méthode de la classe parente pour régénérer le mana
        System.out.println(nom + " a maintenant " + mana + " points de mana.");
    }

	@Override
	public void attaquer(Personnage cible) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void utiliserCompetence(Personnage cible) {
		// TODO Auto-generated method stub
		
	}
}

