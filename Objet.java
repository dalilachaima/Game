package Game;
public class Objet {
    private String nom;
    private String type; // Types possibles : Soin, Mana, Boost
    private int effet;

    public Objet(String nom, String type, int effet) {
        this.nom = nom;
        this.type = type;
        this.effet = effet;
    }
    public void utiliser(Personnage personnage) {
        switch (type) {
            case "Soin":
                int pointsDeVieAvant = personnage.pointsDeVie;
                personnage.pointsDeVie = Math.min(personnage.pointsDeVie + effet, 100); // Limite les PV au maximum (par exemple 100)
                System.out.println(personnage.getNom() + " récupère " + (personnage.pointsDeVie - pointsDeVieAvant) + " points de vie.");
                break;
            case "Mana":
                personnage.regenererMana(effet);
                break;
            case "Boost":
                personnage.degats += effet;
                System.out.println(personnage.getNom() + " augmente ses dégâts de " + effet + ".");
                break;
            default:
                System.out.println("Type d'objet inconnu : " + type);
        }
    }

    public String getNom() {
        return nom;
    }
    public String getType() {
        return type;
    }

    public int getEffet() {
        return effet;
    }
}

