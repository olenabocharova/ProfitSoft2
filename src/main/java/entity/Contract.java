package entity;
import java.io.*;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
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
        return  "Contract: " +System.lineSeparator()+
                "Contract's number: " + id +System.lineSeparator()+
                "Conclusion date: " + conclusionDate + System.lineSeparator()+
                "Start date: " + startDate + System.lineSeparator()+
                "End date: " + endDate + System.lineSeparator()+
                client +System.lineSeparator()+
                "Insured people: "  +System.lineSeparator()+ (insuredPeople == null ? null : Arrays.asList(insuredPeople))+System.lineSeparator();
    }


    public Contract(int id, LocalDate conclusionDate, LocalDate startDate, LocalDate endDate, Client client, ArrayList<InsuredPerson> insuredPeople) {
        this.id = id;
        this.conclusionDate = conclusionDate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.client = client;
        this.insuredPeople = insuredPeople;

    }

    //* total cost the total cost of insurance under the contract */
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
    public ArrayList <InsuredPerson> sortByName(){
        for (InsuredPerson i:insuredPeople) {
            System.out.println("sort:"+i.getName());

        }
        return insuredPeople;
    }

//* search by id*/
    public  InsuredPerson searchById (int id){
        for(InsuredPerson i:insuredPeople){
            if(i.getInsuredId()==id)
                return i;
        }
        return null;
    }

//*read information from file and put values into
// necessary entities*/
    public static   List<Contract> readFromFile(String filename)  {
        List<Contract> contracts = new ArrayList<>();

        InputStreamReader inputStreamReader = null;
        try {
            inputStreamReader = new InputStreamReader(new FileInputStream(new File(filename)),"cp1251");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
         BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String [] lines = null;
        String line = null;
        try{
        while ((line = bufferedReader.readLine()) != null) {

            lines= line.split(",");


            LocalDate conc = LocalDate.parse(lines[1], DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            LocalDate start = LocalDate.parse(lines[2], DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            LocalDate end = LocalDate.parse(lines[3], DateTimeFormatter.ofPattern("dd.MM.yyyy"));

            Client client=new Client(ClientType.valueOf(lines[4]),lines[5],lines[6]);

            ArrayList<InsuredPerson>insuredPeople=new ArrayList<>();
            for(int i=7; i<lines.length; i+=4 ){
                LocalDate d=LocalDate.parse(lines[i+2],DateTimeFormatter.ofPattern("dd.MM.yyyy"));
                InsuredPerson person = new InsuredPerson(Integer.valueOf(lines[i]),lines[i+1],d,Double.valueOf(lines[i+3]));
                insuredPeople.add(person);


            }
            Contract contract=new Contract(Integer.valueOf(lines[0]),conc,start,end,client,insuredPeople);
           contracts.add(contract);
        }
        bufferedReader.close();}
        catch (IOException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return contracts;

    }
    public static void main(String[] args) throws IOException {
        LocalDate conc=LocalDate.of(2002,Month.APRIL,2);
        LocalDate start=LocalDate.of(2002,Month.APRIL,3);
        LocalDate end=LocalDate.of(2007,Month.APRIL,10);
        Client client= new Client(ClientType.NATURAL_PERSON,"Vaculenko Nikolay Ivanovich","Nebakulina 20");
        InsuredPerson first = new InsuredPerson(13478987,"Vaculenko Stepan Nikolaevich",conc,1000);
        InsuredPerson second = new InsuredPerson(25669807,"Vaculenko Alina Nikolaevna",start,2000);


        ArrayList<InsuredPerson>insuredPeople=new ArrayList<InsuredPerson>();

        insuredPeople.add(first);
        insuredPeople.add(second);
        for (InsuredPerson a:insuredPeople){
            System.out.println(a.getName());
        }
        //*Name and date comporator*/
        insuredPeople.sort(nameComp);
        System.out.println("Names, sorted by ABC: ");
        for (InsuredPerson a:insuredPeople){
            System.out.println(a.getName());
        }

insuredPeople.sort(dateComp);
        System.out.println("Sorted by date of birth: ");
        for (InsuredPerson a:insuredPeople){
            System.out.println(a.getDateOfBirth());
        }

        Contract contract= new Contract(1,conc,start,end,client,insuredPeople);

        System.out.println(contract);
        System.out.println("Total insurance cost under the contract: "+contract.totalInsuranceCost()+"y.e");

        System.out.println("Search by id: "+ contract.searchById(13478987));



        System.out.println("Print name as: Familiya I.О.: ");
        for (InsuredPerson i:insuredPeople)
              {
                  i.printParseName();

        }

        System.out.println();
        System.out.println("Read from file: ");

        for(Contract c:readFromFile("Contracts.csv")){
            System.out.println(c);
        }





    }

}
