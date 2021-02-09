package Messenger;

import Messenger.Man.Man;
import Messenger.Wooman.Wooman;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;
import java.net.*;

public class Messenger {
    public static void main(String[] args) throws IOException,
            ClassNotFoundException {
            char choice, ignore;
            String exit = "exit";
            String UsernameM = "man";
            //  String PasswordM = "123";
            String UsernameW = "wooman";
            //  String PasswordW = "456";

            Scanner input1 = new Scanner(System.in);
            System.out.println("Enter who are you (or write exit for exit): ");
            String username = input1.next();
            // Scanner input2 = new Scanner(System.in);
            // System.out.println("Enter Password : ");
            //String password = input2.next();

            //  if (username.equals(UsernameM) && password.equals(PasswordM)) {
            if (username.equals(UsernameM)) {
                do {
                    System.out.println("Access is allowed!");
                    System.out.println("----------------------------------------");
                    System.out.println("Mister enter your details:");
                    System.out.println("1. Firstname ");
                    Scanner input = new Scanner(System.in);
                    String firstname = input.next();
                    System.out.println("2. Lastname ");
                    String lastname = input.next();
                    System.out.println("3. Date of Birth");
                    int dayBorn = Integer.parseInt(input.next());
                    int monthBorn = Integer.parseInt(input.next());
                    int yearBorn = Integer.parseInt(input.next());
                    System.out.println("4. Country");
                    String country = input.next();
                    Man.displayUser();

                    ////////////////////
               //     LinkedList<Man> mans = new LinkedList<Man>();
                 //   mans.add(new Man(firstname, lastname, dayBorn, monthBorn,
                   //         yearBorn, country, 'M'));
                    ///////////////////////
                    Man man = new Man(firstname, lastname, dayBorn, monthBorn,
                            yearBorn, country, 'M');

                    for (;;) {
                        man.showMenu();
                        do {
                            //mans.showMenu();
                            choice = (char) System.in.read();
                            do {
                                ignore = (char) System.in.read();
                            } while (ignore != '\n');
                        } while (man.isValid(choice));
                        if (choice == 'q') break;
                        System.out.println("\n");
                        man.demoCaseMenuInfo(choice);
                    }
                 ///////////////////////////////
                  // for (Man qtyperson : mans)
                    //   System.out.println(mans + "\n");
                    ///////////////////////////////
                    Scanner input2 = new Scanner(System.in);
                    System.out.println("Enter exit or creat new Account: ");
                    String ex = input2.next();
                    exit = ex;
                }while (!exit.equals("exit"));
            }
            // if (username.equals(UsernameW) && password.equals(PasswordW)) {
            if (username.equals(UsernameW)) {
                do{
                System.out.println("Access is allowed!");
                System.out.println("----------------------------------------");
                System.out.println("Missis enter your details:");
                System.out.println("1. Firstname ");
                Scanner input = new Scanner(System.in);
                String firstname = input.next();
                System.out.println("2. Lastname ");
                String lastname = input.next();
                System.out.println("3. Date of Birth");
                int dayBorn = Integer.parseInt(input.next());
                int monthBorn = Integer.parseInt(input.next());
                int yearBorn = Integer.parseInt(input.next());
                System.out.println("4. Country");
                String country = input.next();
                Wooman.displayUser();
                Wooman<String, Integer> wooman = new Wooman (firstname, lastname, dayBorn, monthBorn,
                        yearBorn, country, 'W');
                for (; ; ) {
                    do {
                        wooman.showMenu();
                        choice = (char) System.in.read();
                        do {
                            ignore = (char) System.in.read();
                        } while (ignore != '\n');
                    } while (wooman.isValid(choice));
                    if (choice == 'q') break;
                    System.out.println("\n");
                    wooman.demoCaseMenuInfo(choice);
                }
                Scanner input2 = new Scanner(System.in);
                System.out.println("Enter exit or creat new Account: ");
                String ex = input2.next();
                exit = ex;
                }while (!exit.equals("exit"));
            }
        else if (username.equals(exit)) {
            System.out.println("You exit");
        }
                 /*   else if (username.equals(UsernameM)) {
                        System.out.println("Invalid Password!");
                    } else if (password.equals(PasswordM)) {
                        System.out.println("Invalid Username!");
                    }
                    else if (username.equals(UsernameW)) {
                    System.out.println("Invalid Password!");
                    } else if (password.equals(PasswordW)) {
                    System.out.println("Invalid Username!");
                    } else {
                    System.out.println("Invalid Username & Password!");
                    }*/
    }
}