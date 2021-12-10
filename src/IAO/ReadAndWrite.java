package IAO;

import model.PhoneBook;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadAndWrite {
    public List<PhoneBook> readFromFile() {
        List<PhoneBook> phoneBooks = new ArrayList<>();
        try {
            File inFile = new File("C:\\Users\\ADMIN\\IdeaProjects\\ThiModule2\\src\\Data\\phoneBooks.csv");
            Scanner inputFile = new Scanner(inFile);
            while (inputFile.hasNext()) {
                String str = inputFile.nextLine();
                String[] tokens = str.split(",");
                phoneBooks.add(new PhoneBook(Integer.parseInt(tokens[0]),tokens[1],tokens[2],tokens[3],tokens[4],tokens[5],tokens[6],tokens[7]));
            }
//            return phoneBooks;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return phoneBooks;
    }
    public void writeToFile(List<PhoneBook> phoneBooks) {
        try{
            FileWriter writer = new FileWriter("C:\\Users\\ADMIN\\IdeaProjects\\ThiModule2\\src\\Data\\phoneBooks.csv");
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            for (PhoneBook phoneBook : phoneBooks) {
                bufferedWriter.write(phoneBook.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
