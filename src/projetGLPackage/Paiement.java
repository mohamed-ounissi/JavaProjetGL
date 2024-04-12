package projetGLPackage;

import java.sql.Date;


public class Paiement {

    private String id_payment;
    private Date date_payment;
    private double montant;

    public Paiement(String id_payment, Date date_payment, double montant) {
        this.id_payment = id_payment;
        this.date_payment = date_payment;
        this.montant = montant;
    }

    public String getId_payment() {
        return id_payment;
    }

    public void setId_payment(String id_payment) {
        this.id_payment = id_payment;
    }

    public Date getDate_payment() {
        return date_payment;
    }

    public void setDate_payment(Date date_payment) {
        this.date_payment = date_payment;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }
}
