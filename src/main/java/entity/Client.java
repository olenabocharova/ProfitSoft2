package entity;

public class Client {
    private ClientType clientType;
    private String name;
    private String address;

    //геттеры и сеттеры
    public ClientType getClientType() {
        return clientType;
    }

    public void setClientType(ClientType clientType) {
        this.clientType = clientType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    //конструкторы


    public Client(ClientType clientType, String name, String address) {
        this.clientType = clientType;
        this.name = name;
        this.address = address;
    }

    //toString

    @Override
    public String toString() {
        return "Сведения о клиете: " + System.lineSeparator()+
                "Тип клиента: " + clientType.getOutput() +System.lineSeparator()+
                "Имя клиента: " + name +   System.lineSeparator()+
                "Адрес клиента: " + address ;
    }
}
