package models;

public class Depense{
    private int id_depense;
    private int id_user;
    private int id_prevision;
    private double montant;

    public Depense(int id_depense,int id_prevision,int user,double montant){
        this.id_depense = id_depense;
        this.id_prevision = id_prevision;
        this.id_user = user;
        this.montant = montant;
    }

    public int getId(){
        return this.id_depense;
    }

    public int getIdPrevision(){
        return this.id_prevision;
    }

    public int getIdUser(){
        return this.id_user;
    }


    public double getMontant(){
        return this.montant;
    }

    public void setId(int id){
        this.id_depense = id;
    }

    public void setMontant(double montant){
        this.montant = montant;
    }
}