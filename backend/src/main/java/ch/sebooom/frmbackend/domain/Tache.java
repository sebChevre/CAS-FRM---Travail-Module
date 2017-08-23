package ch.sebooom.frmbackend.domain;

/**
 * Created by seb on .
 * <p>
 * ${VERSION}
 */
public class Tache {

    private String description;
    private String assigneA;
    private Etat etat;
    private Integer id;
    private Integer duree;

    public Tache(Integer id, String description, String assigneA, Integer duree){
        this(id,description,duree);
        this.assigneA = assigneA;
    }

    public Tache(Integer id, String description, Integer duree){
        this.id = id;
        this.description = description;
        this.duree = duree;
        this.etat = Etat.A_FAIRE;
    }

    public Tache(Integer id, String description, Etat etat, Integer duree){
        this(id,description,duree);
        this.etat = etat;

    }



    public void termineTache () {
        this.etat = Etat.TERMINE;
    }

    public void assignUser(String user){
        assigneA = user;
    }

    public String assignUser(){
        return assigneA;
    }

    public String description() {
        return this.description;
    }

    public void id(Integer id){
        this.id = id;
    }
    public Integer id() {
        return id;
    }

    public void etat(Etat termine) {
        this.etat = termine;
    }
}
