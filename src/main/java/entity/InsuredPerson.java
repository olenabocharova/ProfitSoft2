package entity;

import java.time.LocalDate;

public class InsuredPerson {

    private int insuredId;
    private String name;
    private LocalDate dateOfBirth;
    private double InsuranceCost;


    //геттеры и сеттеры
    public int getInsuredId() {
        return insuredId;
    }

    public void setInsuredId(int insuredId) {
        this.insuredId = insuredId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public double getInsuranceCost() {
        return InsuranceCost;
    }

    public void setInsuranceCost(double insuranceCost) {
        InsuranceCost = insuranceCost;
    }

    //конструкторы

    public InsuredPerson(int insuredId, String name, LocalDate dateOfBirth, double insuranceCost) {
        this.insuredId=insuredId;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        InsuranceCost = insuranceCost;
    }

    //toString
    @Override
    public String toString() {
        return
                "ИНН: "+insuredId+System.lineSeparator()+
                "Имя: " + name  + System.lineSeparator()+
                        "Дата рождения: " + dateOfBirth + System.lineSeparator()+
                        "Стоимость страховки: " + InsuranceCost +"грн." + System.lineSeparator();
    }

    //*Parse name*/
    public void printParseName(){
        String[]fullName = name.split(" ");

        //char surname = fullName[0].charAt(0);
        String surname = fullName[0].substring(0);
        //char firstinitial = fullName[1].charAt(0);
        String firstinitial = fullName[1].substring(0,1);
        char secondinitial = fullName[2].charAt(0);
        //String secondinitial = fullName[2].substring(0,1);
        System.out.println((surname + " " + firstinitial + ". " + secondinitial+"."));


    }
}
