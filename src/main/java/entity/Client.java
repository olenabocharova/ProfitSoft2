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




    public Client(ClientType clientType, String name, String address) {
        this.clientType = clientType;
        this.name = name;
        this.address = address;
    }



    @Override
    public String toString() {
        return "About client: " + System.lineSeparator()+
                "Type of client: " + clientType.getOutput() +System.lineSeparator()+
                "Client's name: " + name +   System.lineSeparator()+
                "Client's address: " + address ;
    }
}
