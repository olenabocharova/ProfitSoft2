package entity;

public enum ClientType {
    NATURAL_PERSON("Natural"), LEGAL_PERSON("Legal");
    private  String output;
    //Метода для наглядного вывода типа клиента в консоль
    public String getOutput() {
        return output;
    }

    ClientType(String a) {
        output=a;
    }
}
