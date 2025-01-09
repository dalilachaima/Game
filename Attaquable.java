package Game;
public interface Attaquable {
	void attaquer(Personnage cible);
	 void utiliserCompetence(Personnage cible);
	void attaquer(Personnage cible, double defensePhysique);
	void utiliserCompetence(Personnage cible, double defensePhysique);
} 