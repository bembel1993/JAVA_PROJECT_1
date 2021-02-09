package Messenger.Wooman;

import Messenger.Person.Person;

import java.io.*;
import java.net.Socket;
import java.util.Arrays;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;

public class Wooman<S, T> extends Person<S, T> {
    private char untensils;
    private int Id;
    private static int user;
    static{
        user = 201;
        System.out.printf("Welcomm user! Your ID: %d\n", user);
    }
    public Wooman(S firstName, S lastName, T day_born,
                  T month_born, T year_born, String country,
                  char who){
        super(firstName, lastName, day_born, month_born, year_born, country);
        this.Id = user;
        this.untensils = who;
        Id = user++;
    }
   @Override
    public void display(){
       System.out.print("Name: "+ super.getFirstName()+" "+ super.getLastName()+"\n "+"Born: "+
               super.getDay_born()+"."+ super.getMonth_born()+"."+
               super.getYear_born()+" in "+ super.getCountry() +"\n Gender: "+ untensils);
    }
    public static void displayUser(){
        System.out.printf("\nUser: %d\n", user);
    }
    //////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void demoCaseMenuInfo(int push) throws IOException, ClassNotFoundException {
        switch (push){
            case '1':
                System.out.println("1. My side ");
                System.out.println("-----------------------------");
                System.out.print("Name: "+ super.getFirstName()+" "+ super.getLastName()+"\n "+"Born: "+
                        super.getDay_born()+"."+ super.getMonth_born()+"."+
                        super.getYear_born()+" from "+ super.getCountry() +"\n Gender: "+ untensils+"\n");
                System.out.println("-----------------------------");
                break;
            case '2':
                try(Socket client=new Socket("127.0.0.1", 2525)) {
                    System.out.println("connection established....");
                    ObjectOutputStream coos = new ObjectOutputStream(client.getOutputStream());
                    ObjectInputStream cois = new ObjectInputStream(client.getInputStream());
                    String str;
                    System.out.println("2. Message ");
                    System.out.print("------------------------------");
                    System.out.print("\nWrite here pleas message ");
                    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                    BufferedWriter bw = new BufferedWriter(new FileWriter("SaveMessages.txt"));
                    System.out.println("or enter x for exit");
                    do {
                        str = br.readLine();
                        System.out.println("Message from " + getFirstName() + " " + getLastName() + "\n" +
                                "Content: " + str + " " + "\nSend: " + date());
                        coos.writeObject("Message from " + getFirstName() + " " + getLastName() + ": "
                                + "\n" + "Content: "  + str + " " + "\nSend: " + date());
                        System.out.println("~server~: " + cois.readObject());
                        String text = str;
                        bw.write("Message from " + getFirstName() + " " + getLastName() + "\n" + text +
                                "\n" + date() + "\n");
                        bw.flush();
                    }
                    while (!str.equals("x"));
                    break;
                }
            case '3':
                System.out.println("3. Send Message ");
                System.out.print("------------------------------");
                System.out.print("\n");
                try (FileReader reader = new FileReader(new File("SaveMesseges.txt"))) {
                    char[] buf = new char[500];
                    int c;
                    while ((c = reader.read(buf)) > 0) {
                        if (c < 500) {
                            buf = Arrays.copyOf(buf, c);
                        }
                        System.out.print(buf);
                        System.out.print("\n");
                    }
                } catch (IOException e) {
                    System.out.println("Файл не найден.");
                }
                break;
        }
        System.out.println();
    }

    @Override
    public void showMenu(){
        System.out.println(" Menu ");
        System.out.println(" 1. My side");
        System.out.println(" 2. Message");
        System.out.println(" 3. Send Message");
        System.out.println("Push q for exit: ");
    }

    @Override
    public boolean isValid(int ch) {
        if (ch < '1' | ch > '3' & ch != 'q') {
            return true;
        } else {
            return false;
        }
    }
}
