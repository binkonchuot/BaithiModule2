package Service;

import IAO.ReadAndWrite;
import model.PhoneBook;

import java.util.ArrayList;
import java.util.List;

public class Service {
    List<PhoneBook> phoneBookList = new ArrayList<>();
    Ascending ascending = new Ascending();
    Descending descending = new Descending();
    ReadAndWrite readAndWrite = new ReadAndWrite();

    public List<PhoneBook> show(){
        return phoneBookList;
    }

    public void add(PhoneBook phoneBook){
        phoneBookList.add(phoneBook);
    }

    public void edit(int index,PhoneBook phoneBook){
        phoneBookList.set(index,phoneBook);
    }

    public void delete(int index){
        phoneBookList.remove(index);
    }

    public  void sortAscending(){
        phoneBookList.sort(ascending);
    }

    public  void sortDescending(){
        phoneBookList.sort(descending);
    }

    public void getFromFile(){
      phoneBookList = readAndWrite.readFromFile();
    }

    public void saveToFile(){
        readAndWrite.writeToFile(phoneBookList);
    }
}
