package entity;

public enum ClientType {
    NATURAL_PERSON("Физическое лицо"), LEGAL_PERSON("Юридическое лицо");
    private  String output;
    //Метода для наглядного вывода типа клиента в консоль
    public String getOutput() {
        return output;
    }

    ClientType(String a) {
        output=a;
    }
}
