package com.javacro.benchmarks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.joda.time.DateTime;

import com.javacro.dslplatform.model.Accounting.Account;
import com.javacro.dslplatform.model.Accounting.Customer;
import com.javacro.dslplatform.model.Accounting.Profile;
import com.javacro.dslplatform.model.Accounting.Transaction;

public class TestCases {

    public static final long NUMBER_OF_RUNS = 1000;

    public static String[] getProfileUseCasesArray() {
        return new String[] {
                "{}",
                "{\"email\":\"markož@element.hr\"}",
                "{\"phoneNumber\":\"+385 1 234 5678\"}",
                "{\"email\":\"markož@element.hr\",\"phoneNumber\":\"+385 1 234 5678\"}" };

    }

    public static List<String> getProfileUseCases() {
        return new ArrayList<String>(Arrays.asList(getProfileUseCasesArray()));
    }

    public static String[] getTransactionUseCasesArray() {
       final String[] useCases = new String[] {
                "{}"
                ,"{\"inflow\":1}"
                ,"{\"outflow\":2}"
                ,"{\"description\":\"A description\"}"
                ,"{\"paymentOn\":\"01-01-01T02:02\"}"

                ,"{\"inflow\":1,\"outflow\":2}"
                ,"{\"inflow\":1,\"description\":\"A description\"}"
                ,"{\"inflow\":1,\"paymentOn\":\"01-01-01T02:02\"}"

                ,"{\"outflow\":1,\"description\":\"A description\"}"
                ,"{\"outflow\":1,\"paymentOn\":\"01-01-01T02:02\"}"

                ,"{\"description\":\"A description\",\"paymentOn\":\"01-01-01T02:02\"}"

                ,"{\"inflow\":1,\"outflow\":2,\"description\":\"A description\"}"
                ,"{\"inflow\":1,\"outflow\":2,\"paymentOn\":\"01-01-01T02:02\"}"

                ,"{\"inflow\":1,\"description\":\"A description\",\"paymentOn\":\"01-01-01T02:02\"}"
                ,"{\"outflow\":1,\"description\":\"A description\",\"paymentOn\":\"01-01-01T02:02\"}"
        };

        final String[] transactions = new String[1000];
        for(int i = 0; i<transactions.length ; i++){
           transactions[i]=useCases[i % useCases.length];
        }


//        transactions = new String[] {
//                "{\"inflow\":1, \"outflow\":1, \"description\":\"Another description\",\"paymentOn\":\"01-01-01T02:02\"}"
//                , "{\"inflow\":1, \"outflow\":1, \"description\":\"A description blabla\",\"paymentOn\":\"01-01-01T02:02\"}"
//                , "{\"inflow\":1, \"outflow\":2, \"description\":\"something something\",\"paymentOn\":\"01-01-01T02:02\"}"
//                , "{\"inflow\":1, \"outflow\":3, \"description\":\"dtjk\",\"paymentOn\":\"01-01-01T02:02\"}"
//                , "{\"inflow\":4, \"outflow\":1, \"description\":\"A description\",\"paymentOn\":\"01-01-01T02:02\"}"
//                , "{\"inflow\":5, \"outflow\":1, \"description\":\"A description\",\"paymentOn\":\"01-01-01T02:02\"}"
//                , "{\"inflow\":1, \"outflow\":6, \"description\":\"A description\",\"paymentOn\":\"01-01-01T02:02\"}"
//                , "{\"inflow\":1, \"outflow\":7, \"description\":\"A description\",\"paymentOn\":\"01-01-01T02:02\"}"
//                , "{\"inflow\":1, \"outflow\":8, \"description\":\"A description\",\"paymentOn\":\"01-01-01T02:02\"}"
//                , "{\"inflow\":9, \"outflow\":1, \"description\":\"A description\",\"paymentOn\":\"01-01-01T02:02\"}"
//        };



        return transactions;
    }

    public static List<String> getTransactionUseCases() {
        return Arrays.asList(getTransactionUseCasesArray());
    }

    public static String[] getAccountUseCasesArray(){
        return new String[]{
                "{}"
                ,"{\"IBAN\":\"12312123\"}"
                ,"{\"currency\":\"HRK\"}"
                ,"{\"IBAN\":\"12312123\",\"transactions\":"+getTransactionUseCases().toString().replace(", ",",")+"}"
                ,"{\"currency\":\"HRK\",\"transactions\":"+getTransactionUseCases().toString().replace(", ",",")+"}"
                ,"{\"IBAN\":\"12312123\",\"currency\":\"HRK\",\"transactions\":"+getTransactionUseCases().toString().replace(", ",",")+"}"
        };
    }

    public static List<String> getAccountUseCases(){

        return new ArrayList<String>(Arrays.asList(getAccountUseCasesArray()));
    }

    public static String[] getCustomerUseCasesArray(){
        return getCustomerUseCases().toArray(new String[getCustomerUseCases().size()]);
    }

    public static List<String> getCustomerUseCases(){

        final List<String> custs = new ArrayList<String>(Arrays.asList(new String[]{
                "{}"
                ,"{\"id\":12312123}"
                ,"{\"name\":\"Jadranko\"}"}));

        custs.add("{\"accounts\":"+getAccountUseCases().toString().replace(", ",",")+"}");
        custs.add("{\"id\":12312123,\"accounts\":"+getAccountUseCases().toString().replace(", ",",")+"}");
        custs.add("{\"name\":\"Jadranko\",\"accounts\":"+getAccountUseCases().toString().replace(", ",",")+"}");
        custs.add("{\"id\":12312123,\"name\":\"Jadranko\",\"accounts\":"+getAccountUseCases().toString().replace(", ",",")+"}");

        for(final String profileUseCase : getProfileUseCases()){
            custs.add("{\"profile\":"+profileUseCase+"}");
            custs.add("{\"id\":12312123,\"profile\":"+profileUseCase+"}");
            custs.add("{\"name\":\"Jadranko\",\"profile\":"+profileUseCase+"}");
            custs.add("{\"id\":12312123,\"name\":\"Jadranko\",\"profile\":"+profileUseCase+"}");
            custs.add("{\"profile\":"+profileUseCase+",\"accounts\":"+getAccountUseCases().toString().replace(", ",",")+"}");
            custs.add("{\"profile\":"+profileUseCase+",\"id\":12312123,\"accounts\":"+getAccountUseCases().toString().replace(", ",",")+"}");
            custs.add("{\"profile\":"+profileUseCase+",\"name\":\"Jadranko\",\"accounts\":"+getAccountUseCases().toString().replace(", ",",")+"}");
            custs.add("{\"profile\":"+profileUseCase+",\"id\":12312123,\"name\":\"Jadranko\",\"accounts\":"+getAccountUseCases().toString().replace(", ",",")+"}");
        }

        return custs;
    }

    public static List<Profile> getProfileStubs(){
        return new ArrayList<Profile>(
            Arrays.asList(
                    new Profile[]{
                        new Profile(),
                        new Profile("email@email.mail", null),
                        new Profile(null, "+12345678"),
                        new Profile("email@email.mail", "+12345678")
                    }));

    }

    public static List<Transaction> getTransactionStubs(){
        return new ArrayList<Transaction>(
            Arrays.asList(
                    new Transaction[]{
                        new Transaction(),
                        new Transaction(1, 0, "", DateTime.now()),
                        new Transaction(1, 1, "abcde", DateTime.now()),
                        new Transaction(0, 1, "abcde", DateTime.now()),
                    }));
    }

    public static List<Account> getAccountStubs(){
        final List<Account> stubs = new ArrayList<Account>();

        stubs.add(new Account());
        stubs.add(new Account("HR123123124", "HRK", getTransactionStubs().subList(0, 1)));
        stubs.add(new Account("HR123123124", "HRK", getTransactionStubs()));

        return stubs;
    }

    public static List<Customer> getCustomerStubs(){
        final List<Customer> stubs = new ArrayList<Customer>();

        stubs.add(new Customer());
        stubs.add(new Customer(5, "Mirko", getProfileStubs().get(0), getAccountStubs().subList(0, 1)));
        stubs.add(new Customer(5, "Mirko", getProfileStubs().get(1), getAccountStubs()));

        return stubs;
    }
}
