package models;

public class Dashboard{
    private String creditLibelle;
    private double montantDepense;
    private double reste;


    public Dashboard(String credit,double montant,double reste){
        this.creditLibelle = credit;
        this.montantDepense = montant;
        this.reste = reste;
    }

    public String getCreditLibelle(){
        return this.creditLibelle;
    }

    public double getMontantDepense(){
        return this.montantDepense;
    }

    public double getReste(){
        return this.reste;
    }

}