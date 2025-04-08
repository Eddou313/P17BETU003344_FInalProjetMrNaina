package models;

public class Prevision{
    private int id_prevision;
    private int id_user;
    private String libelle;
    private double montant;

    public Prevision(int id_prevision,int user,String libelle,double montant){
        this.id_prevision = id_prevision;
        this.id_user = user;
        this.libelle = libelle;
        this.montant = montant;
    }

    public int getId(){
        return this.id_prevision;
    }

    public int getIdUser(){
        return this.id_user;
    }

    public String getLibelle(){
        return this.libelle;
    }

    public double getMontant(){
        return this.montant;
    }

    public void setId(int id){
        this.id_prevision = id;
    }

    public void setMontant(double montant){
        this.montant = montant;
    }
}