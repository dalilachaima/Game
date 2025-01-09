package Game;
public class Guerrier extends Personnage {
    public Guerrier(String nom) {
        super(nom, 100, 10, 0.45, 20); // Points de vie : 100, dégâts : 10, défense physique : 45%, mana : 20
    }

    @Override
    public void attaquer(Personnage cible, double defensePhysique) {
        System.out.println(nom + " attaque " + cible.getNom() + " avec son arme !");
        cible.recevoirDegats(degats);
    }
    @Override
    public void utiliserCompetence(Personnage cible, double defensePhysique) {
        if (mana >= 10) { // Vérifie si le guerrier a suffisamment de mana
            System.out.println(nom + " utilise sa compétence spéciale : Coup de rage !");
            cible.recevoirDegats(degats * 2); // Dégâts doublés pour la compétence
            mana -= 10; // Réduction du mana après utilisation
            System.out.println(nom + " utilise 10 points de mana. Mana restant : " + mana);
        } else {
            System.out.println(nom + " n'a pas assez de mana pour utiliser sa compétence spéciale !");
        }
    }

    // Ajout d'une méthode spécifique pour régénérer le mana
    public void regenererMana(int quantite) {
        super.regenererMana(quantite); // Utilisation de la méthode de la classe parente
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

