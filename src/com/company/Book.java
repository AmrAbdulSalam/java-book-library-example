package com.company;

import java.time.chrono.IsoChronology;
import java.util.ArrayList;

public class Book {

    private String ISBN ;
    private String Title;
    private String Author;
    private int Edition ;
    private int puplishedYear ;
    private boolean Borrowed;
    public int counter = 0 ;
    private int countSet = 0;
    //public int index;


    //There should be an arrayList for each data type with a counter
    public ArrayList<String> arrISBN = new ArrayList<String>();
    private ArrayList<String> arrTitle = new ArrayList<String>();
    private ArrayList<String> arrAuthor = new ArrayList<String>();
    private ArrayList<Integer> arrEdition = new ArrayList<Integer>();
    private ArrayList<Integer> arrPuplish = new ArrayList<Integer>();
    private ArrayList<Boolean> arrBorrowed = new ArrayList<Boolean>();


    public int sizeR(){
        return arrISBN.size();
    }

    public void setCountSet(){
        countSet ++;
    }
    public void setZero(){
        countSet = 0;
    }

    // Set method for all primitve types :
    public void setISBN(String ISBN ){

        arrISBN.add(ISBN);
    }
    public void setTitle(String Title ,int index){
        arrTitle.add(index ,Title);
    }
    public void setAuthor(String Aurthor ,int index){
        arrAuthor.add(index ,Aurthor);
    }
    public void setEdition(int Edition ,int index){
        arrEdition.add(index ,Edition);
    }
    public void setPuplishedYear(int puplishedYear ,int index){
        arrPuplish.add(index ,puplishedYear);
    }
    public void setBorrowed(boolean Borrowed ,int index){
        arrBorrowed.add(index ,Borrowed);
    }

    //---------------
    //Get methods using arrayLists

    public String getISBN(int i){

        return arrISBN.get(i);
    }

    public String getTitle(int i){
        return arrTitle.get(i);
    }

    public String getAuthor(int i){
        return arrAuthor.get(i);
    }

    public int getPuplishedYear(int i){
        return arrPuplish.get(i);
    }

    public int getEdition(int i){
        return arrEdition.get(i);
    }

    public boolean getBorrowed(int i){
        return arrBorrowed.get(i);
    }

    public int getCountSet(){
        return countSet;
    }
}
