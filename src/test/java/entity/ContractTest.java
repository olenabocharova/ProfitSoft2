package entity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class ContractTest {
    Contract contract;
    InsuredPerson first;
    InsuredPerson second;
    @Before
    public void setUp() throws Exception {
        LocalDate conc=LocalDate.of(2015,Month.OCTOBER,12);
        LocalDate start=LocalDate.of(2015,Month.OCTOBER,13);
        LocalDate end=LocalDate.of(2018,Month.DECEMBER,17);
        LocalDate date1=LocalDate.of(2002,Month.OCTOBER,12);
        LocalDate date2=LocalDate.of(2005,Month.SEPTEMBER,18);
        Client client= new Client(ClientType.NATURAL_PERSON,"Ivanov Ivan Ivanovich","Mira 21");
        first = new InsuredPerson(17896785,"Ivanova Vera Ivanovna",date1,1000);
        second = new InsuredPerson(27898751,"Ivanov Vladimir Ivanovich",date2,3000);


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
        assertEquals(4000,contract.totalInsuranceCost(),0);


    }

     @Test
     public void readFromFile() {
         List<Contract> contracts = Contract.readFromFile("ContractTest.csv");
         assertEquals(contract,contracts.get(0));
     }

}