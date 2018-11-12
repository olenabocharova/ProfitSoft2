package entity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class ContractTest {
    Contract contract;
    InsuredPerson first;
    @Before
    public void setUp() throws Exception {
        LocalDate conc=LocalDate.of(2002,Month.APRIL,2);
        LocalDate start=LocalDate.of(2002,Month.APRIL,3);
        LocalDate end=LocalDate.of(2007,Month.APRIL,10);
        Client client= new Client(ClientType.NATURAL_PERSON,"Ivan Ivanov","Nebakulina 20");
        first = new InsuredPerson(13478987,"Иванов Николай Иванович",conc,1000);
        InsuredPerson second = new InsuredPerson(25669807,"Иванова Ольга Ивановна",start,2000);


        ArrayList<InsuredPerson> insuredPeople=new ArrayList<InsuredPerson>();

        insuredPeople.add(first);
        insuredPeople.add(second);
        contract= new Contract(1,conc,start,end,client,insuredPeople);

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void totalInsuranceCost() {
        assertEquals(3000,contract.totalInsuranceCost(),0);


    }

    @Test
    public void searchById() {
        assertEquals(first,contract.searchById(13478987));

    }
   
}