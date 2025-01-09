package Game;
public class Voleur extends Personnage {
    public Voleur(String nom) {
        super(nom, 70, 12, 0.10, 30); // Points de vie : 70, dégâts : 12, défense physique : 10%, mana : 30
    }

    @Override
    public void attaquer(Personnage cible, double defensePhysique) {
        System.out.println(nom + " attaque furtivement " + cible.getNom() + " !");
        cible.recevoirDegats(degats);

        // Ajout d'une chance d'attaque critique
        if (Math.random() < 0.2) { // 20% de chance de coup critique
            System.out.println(nom + " inflige un coup critique !");
            cible.recevoirDegats(degats * 2); // Dégâts doublés pour le critique
        }
    }

    @Override
    public void utiliserCompetence(Personnage cible, double defensePhysique) {
        if (mana >= 15) { // Vérifie si le voleur a suffisamment de mana
            System.out.println(nom + " utilise sa compétence spéciale : Attaque rapide !");
            cible.recevoirDegats(degats * 3); // Inflige des dégâts triplés
            mana -= 15; // Consomme 15 points de mana
            System.out.println(nom + " utilise 15 points de mana. Mana restant : " + mana);
        } else {
            System.out.println(nom + " n'a pas assez de mana pour utiliser sa compétence spéciale !");
        }
    }

    // Ajout d'une méthode spécifique pour augmenter les chances d'esquive
    public void esquiver() {
        System.out.println(nom + " tente d'esquiver l'attaque !");
        if (Math.random() < 0.3) { // 30% de chance de réussite
            System.out.println(nom + " a esquivé avec succès !");
        } else {
            System.out.println(nom + " n'a pas réussi à esquiver l'attaque.");
        }
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
