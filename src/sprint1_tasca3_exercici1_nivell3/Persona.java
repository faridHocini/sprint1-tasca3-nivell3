package sprint1_tasca3_exercici1_nivell3;



class Persona {
    private String nom;
    private String cognom;
    private String DNI;

    public Persona(String nom, String cognom, String DNI) {
        this.nom = nom;
        this.cognom = cognom;
        this.DNI = DNI;
    }

    public String getNom() {
        return nom;
    }

    public String getCognom() {
        return cognom;
    }

    public String getDNI() {
        return DNI;
    }

    @Override
    public String toString() {
        return String.format("%-15s %-20s %-10s", nom, cognom, DNI);
    }
}

