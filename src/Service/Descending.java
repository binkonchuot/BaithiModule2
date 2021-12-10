package Service;

import model.PhoneBook;

import java.util.Comparator;

public class Descending implements Comparator<PhoneBook> {
    @Override
    public int compare(PhoneBook o1, PhoneBook o2) {
        return Integer.compare(o2.getId(), o1.getId());
    }
}
