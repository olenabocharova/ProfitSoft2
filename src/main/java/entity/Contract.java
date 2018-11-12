package entity;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class Contract {
    private int id;
    private LocalDate conclusionDate;
    private LocalDate startDate;
    private LocalDate endDate;
    private Client client;
    private ArrayList<InsuredPerson> insuredPeople;
    public static Comparator<InsuredPerson> nameComp= new Comparator<InsuredPerson>() {
        @Override
        public int compare(InsuredPerson n1, InsuredPerson n2) {
            return n1.getName().toUpperCase().compareTo(n2.getName().toUpperCase());
        }
    };
    public static Comparator<InsuredPerson> dateComp = new Comparator<InsuredPerson>() {
        @Override
        public int compare(InsuredPerson d1, InsuredPerson d2) {
            return d1.getDateOfBirth().compareTo(d2.getDateOfBirth());
        }
    };

    //геттеры и сеттеры


    public int getId() {
        return id;
    }

    public LocalDate getConclusionDate() {
        return conclusionDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Client getClient() {
        return client;
    }

    public ArrayList<InsuredPerson> getInsuredPeople() {
        return insuredPeople;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setConclusionDate(LocalDate conclusionDate) {
        this.conclusionDate = conclusionDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setInsuredPeople(ArrayList<InsuredPerson> insuredPeople) {
        this.insuredPeople = insuredPeople;
    }




    @Override
    public String toString() {
        return  "Договор: " +System.lineSeparator()+
                "Номер договора: " + id +System.lineSeparator()+
                "Дата заключения договора: " + conclusionDate + System.lineSeparator()+
                "Дата начала действия договора: " + startDate + System.lineSeparator()+
                "Дата окончания действия договора: " + endDate + System.lineSeparator()+
                client +System.lineSeparator()+
                "Сведения о застрахованных лицах: "  +System.lineSeparator()+ (insuredPeople == null ? null : Arrays.asList(insuredPeople))+System.lineSeparator();
    }

    //конструкторы
    public Contract(int id, LocalDate conclusionDate, LocalDate startDate, LocalDate endDate, Client client, ArrayList<InsuredPerson> insuredPeople) {
        this.id = id;
        this.conclusionDate = conclusionDate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.client = client;
        this.insuredPeople = insuredPeople;

    }

    //общая стоимость страховки по договору
    public double totalInsuranceCost(){
        double cost=0;
        for(InsuredPerson i: insuredPeople){
            cost+=i.getInsuranceCost();

        }
        return cost;

    }

    //* total cost the total cost of insurance under the contract */
//    public double totalInsuranceCost(){
//        double cost=0;
//        for(Iterator<InsuredPerson> iterator=insuredPeople.iterator(); iterator.hasNext();){
//            cost+=iterator.next().getInsuranceCost();
//        }
//        return  cost;
//    }

    //*Sort by name */
//    public ArrayList <InsuredPerson> sortByName(){
//        for (InsuredPerson i:insuredPeople) {
//            System.out.println("sort:"+i.getName());
//
//        }
//        return insuredPeople;
//    }

// search by id
    public  InsuredPerson searchById (int id){
        for(InsuredPerson i:insuredPeople){
            if(i.getInsuredId()==id)
                return i;
        }
        return null;
    }

    public static void main(String[] args) {
        LocalDate conc=LocalDate.of(2002,Month.APRIL,2);
        LocalDate start=LocalDate.of(2002,Month.APRIL,3);
        LocalDate end=LocalDate.of(2007,Month.APRIL,10);
        Client client= new Client(ClientType.NATURAL_PERSON,"Ivan Ivanov","Nebakulina 20");
        InsuredPerson first = new InsuredPerson(13478987,"Иванов Николай Иванович",conc,1000);
        InsuredPerson second = new InsuredPerson(25669807,"Иванова Ольга Ивановна",start,2000);

        //ArrayList<InsuredPerson> insuredPeople={first,second};
        ArrayList<InsuredPerson>insuredPeople=new ArrayList<InsuredPerson>();

        insuredPeople.add(first);
        insuredPeople.add(second);
        for (InsuredPerson a:insuredPeople){
            System.out.println(a.getName());
        }
        //Name and date comporator
        insuredPeople.sort(nameComp);
        System.out.println("Имена, отсортированные по алфавиту: ");
        for (InsuredPerson a:insuredPeople){
            System.out.println(a.getName());
        }

insuredPeople.sort(dateComp);
        System.out.println("Сортировка по дате рождения: ");
        for (InsuredPerson a:insuredPeople){
            System.out.println(a.getDateOfBirth());
        }

        Contract contract= new Contract(1,conc,start,end,client,insuredPeople);

        System.out.println(contract);
        System.out.println("Общая стоимость страховки по договору: "+contract.totalInsuranceCost()+"грн.");

        System.out.println("Поиск по ИНН: "+ contract.searchById(13478987));



        System.out.println("Вывод имени в виде: Фамилия И.О.: ");
        for (InsuredPerson i:insuredPeople)
              {
                  i.printParseName();

        }



    }

}
