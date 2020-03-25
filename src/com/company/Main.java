package com.company;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //String [] s = new String[5];//Dose not do anything

        Scanner input = new Scanner(System.in);
        int num1 , index ;
        String output = "";
        System.out.println("Welcome to my program please start using the given COMANDS : ");
        Book book = new Book();
        for(; ; ) {


            System.out.print("> "); // for printing like cmd

            String comands = input.nextLine(); // for reading the Comands

            String[] tokens = comands.split(" ");
            tokens[0] = tokens[0].toLowerCase(); // to make the first command all with Small letters

            //Starting switch case to know which command to do.

            switch (tokens[0]) {
                case "add":
                    //System.out.println("Its add command");
                    if (tokens.length != 2)
                        System.out.println("Invalid inputs");
                    else {

                        book.setISBN(tokens[1]);
                        Collections.sort(book.arrISBN);
                        //System.out.println(tokens.length);
                        System.out.println("You have added a new book congratulations :)");
                        book.counter++;
                        index = book.arrISBN.indexOf(tokens[1]);
                        book.setBorrowed(false , index);
                        book.setEdition(0 , index);
                        book.setAuthor("" , 0);
                        book.setPuplishedYear(0 , index);
                        book.setTitle("" , index);
                    }

                    break;

                case "set":

                    for(int i = 3 ; i < tokens.length ;i++){
                        output += tokens[i] + " " ;
                    }
                        index = book.arrISBN.indexOf(tokens[1]);

                        switch (tokens[2]){
                            case "title":
                                book.setTitle(output , index );
                            break;

                            case "author" :
                                book.setAuthor(output , index);
                            break;

                            case "published_year" :
                                num1 = Integer.parseInt(tokens[3]);
                                book.setPuplishedYear(num1 , index);
                            break;

                            case "edition" :
                                num1 = Integer.parseInt(tokens[3]);
                                book.setEdition(num1, index);
                            break;

                    }
                    output = "";
                    break;

                case "delete":
                    //System.out.println("Its delete command");
                    index = book.arrISBN.indexOf(tokens[1]);
                    book.counter -- ;
                    book.removeArr(index);
                    break;

                case "get":
                    //System.out.println("Its get command");

                    index = book.arrISBN.indexOf(tokens[1]);

                    switch (tokens[2]){

                        case "title" :
                            System.out.println(book.getTitle(index));
                        break;

                        case "author" :
                            System.out.println(book.getAuthor(index));
                        break;

                        case "published_year" :
                            //num1 = Integer.parseInt(tokens[2]);
                            System.out.println(book.getPuplishedYear(index));
                         break;

                        case "edition" :
                            System.out.println(book.getEdition(index));
                        break;
                        }
                    break;

                case "rent":
                    //System.out.println("Its rent command");
                    index = book.arrISBN.indexOf(tokens[1]);
                    if(!book.getBorrowed(index)){
                        System.out.println("You borrow a book please come again");
                        book.setBorrowed(true , index);
                    }
                    else{
                        System.out.println("Sorry the book is already rented");
                    }
                    break;

                case "return":
                    //System.out.println("Its return command");
                    index = book.arrISBN.indexOf(tokens[1]);
                    if(!book.getBorrowed(index))
                        System.out.println("This book is already available");
                    else{
                        System.out.println("Than you for returning the book ");
                        book.setBorrowed(false,index);
                    }
                    break;

                case "search":
                    //System.out.println("Its search command");
                    tokens[2] = tokens[2].toLowerCase();
                    switch (tokens[1]){

                        case "title":
                            int b = 0;
                            for(String s : book.arrTitle){
                                if(s.toLowerCase().contains(tokens[2])){
                                    System.out.println(s);
                                    b++;
                                }
                            }
                            if(b == 0 ){
                                System.out.println("No matches found :(");
                            }
                            break;

                        case "author" :
                            int c = 0;
                            for(String s : book.arrAuthor){
                                if(s.toLowerCase().contains(tokens[2])){
                                    System.out.println(s);
                                    c++;
                                }
                            }
                            if(c == 0)
                                System.out.println("No matches found :(");
                            break;
                    }
                    break;

                case "print":
                    //System.out.println("Its print command");

                        output = "ISBN\t\t" + "Title\t\t\t\t\t" + "Edition\t\t\t\t" + "Author\t\t\t" + "Year\t\t\t" + "Available";
                        System.out.println(output);

                        for (int i = 0; i < book.counter; i++) {
                            output = book.getISBN(i) + "\t\t\t" + book.getTitle(i) + "\t\t\t" +
                                    book.getEdition(i) + "th" + "\t\t\t" + book.getAuthor(i) + "\t  " + book.getPuplishedYear(i)
                                    + "\t\t\t" + (book.getBorrowed(i) ? "Not Available" : "Available");

                            System.out.println(output);
                        }

                    break;

                case "quit" :
                    System.out.println("Thank you for using our program ");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Sorry you entered a wrong COMAND !!");
            }


        }
    }
}
