package Game;
import java.util.ArrayList;
public abstract class Personnage implements Attaquable {
    protected String nom;
    protected int pointsDeVie;
    protected int degats;
    protected int niveau;
    protected int experience;
    protected double defensePhysique;
    protected int mana;
    protected ArrayList<Objet> inventaire;

    public Personnage(String nom, int pointsDeVie, int degats, double defensePhysique, int mana) {
        this.nom = nom;
        this.pointsDeVie = pointsDeVie;
        this.degats = degats;
        this.niveau = 1;
        this.experience = 0;
        this.defensePhysique = defensePhysique;
        this.mana = mana;
        this.inventaire = new ArrayList<>();
    }

    public void recevoirDegats(int degats) {
        int degatsEffectifs = (int) (degats * (1 - this.defensePhysique));
        pointsDeVie -= degatsEffectifs;
        pointsDeVie = Math.max(pointsDeVie, 0);
        System.out.println(nom + " a reçu " + degatsEffectifs + " points de dégâts. Points de vie restants : " + pointsDeVie);
    }

    public boolean estVivant() {
        return pointsDeVie > 0;
    }

    public void gagnerExperience(int xp) {
        experience += xp;
        if (experience >= 100) {
            niveau++;
            experience = 0;
            degats += 5;
            pointsDeVie += 20;
            mana += 10; 
            System.out.println(nom + " a atteint le niveau " + niveau + " !");
        }
    }

    public void utiliserObjet(Objet objet) {
        if (inventaire.contains(objet)) {
            objet.utiliser(this);
            inventaire.remove(objet);
        } else {
            System.out.println("Objet non disponible !");
        }
    }

    public void ajouterObjet(Objet objet) {
        if (objet != null) {
            inventaire.add(objet);
            System.out.println(nom + " a ajouté " + objet.getNom() + " à son inventaire.");
        } else {
            System.out.println("Objet invalide.");
        }
    }

    public void afficherInventaire() {
        if (inventaire.isEmpty()) {
            System.out.println("L'inventaire de " + nom + " est vide.");
        } else {
            System.out.println("Inventaire de " + nom + ":");
            for (Objet objet : inventaire) {
                System.out.println("- " + objet.getNom());
            }
        }
    }

    public String getNom() {
        return nom;
    }

    public int getMana() {
        return mana;
    }

    public void regenererMana(int quantite) {
        mana += quantite;
        System.out.println(nom + " récupère " + quantite + " points de mana.");
    }

    @Override
    public abstract void attaquer(Personnage cible, double defensePhysique);

    @Override
    public abstract void utiliserCompetence(Personnage cible, double defensePhysique);
}
