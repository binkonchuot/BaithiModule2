package controller;

import IAO.ReadAndWrite;
import Service.Service;
import model.PhoneBook;

import javax.xml.namespace.QName;
import java.util.List;

public class Controller {
    Service service = new Service();
    ReadAndWrite readAndWrite = new ReadAndWrite();

    public List<PhoneBook> showList() {
        return service.show();
    }

    public void addPhoneBook(PhoneBook phoneBook) {
        service.add(phoneBook);
    }

    public int checkId(int id) {
        List<PhoneBook> phoneBookList = service.show();
        for (int i = 0; i < phoneBookList.size(); i++) {
            if (phoneBookList.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public void editPhoneBook(int index, PhoneBook phoneBook) {
        service.edit(index, phoneBook);
    }

    public void deletePhoneBook(int index) {
        service.delete(index);
    }

    public void sortPhoneBook(String choice) {
        switch (choice) {
            case "1":
                service.sortAscending();
                break;
            case "2":
                service.sortDescending();
                break;
            case "3":
                break;
            default:
                sortPhoneBook(choice);
        }
    }

    public void readFromFile() {
        service.getFromFile();
    }

    public void saveToFile() {
        service.saveToFile();
    }
}
