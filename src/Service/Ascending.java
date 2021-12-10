package Service;

import model.PhoneBook;

import java.util.Comparator;

public class Ascending implements Comparator<PhoneBook> {
    @Override
    public int compare(PhoneBook o1, PhoneBook o2) {
        return Integer.compare(o1.getId(), o2.getId());
    }
}
