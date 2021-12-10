package View;

import controller.Controller;
import controller.Validate;
import model.PhoneBook;

import java.util.Collections;
import java.util.Scanner;

public class FunctionView {
    static Controller controller = new Controller();
    static Validate validate = new Validate();
    static GetAndAlert getAndAlert = new GetAndAlert();
    Scanner scanner = new Scanner(System.in);

    public void showdMenu() {
        int count = 0;
        if(controller.showList().size()==0) {
            getAndAlert.noPhoneBook();
            // cho nay co the nham
            return;
        }
        for (PhoneBook phoneBook : controller.showList()) {
            System.out.println(phoneBook.toString());
            if (++count % 5 == 0) {
                System.out.println("An enter de quay lai");
            }
        }
    }

    public void addMenu() {
        controller.addPhoneBook(createPhoneBook());

    }

    private PhoneBook createPhoneBook() {
        System.out.println("Nhap ma ");
        int id = validate.validateInteger();
        System.out.println("Nhap ten User");
        String name = validate.validateName();
        System.out.println("Nhap so dien thoai");
        String phone = validate.validatePhoneNumber();
        System.out.println("Nhap group");
        String group = scanner.nextLine();
        System.out.println("Nhap gioi tinh ");
        String gender = validate.validateGender();
        System.out.println("Nhap dia chi ");
        String address = scanner.nextLine();
        System.out.println("Nhap email ");
        String email = validate.validateEmail();
        System.out.println("Nhap facebook ");
        String facebook = scanner.nextLine();

        return new PhoneBook(id, name, phone,group, gender, address,email,facebook );
    }

    public void editMenu() {
        System.out.println("Nhap ma user can sua");
        int id = validate.validateInteger();
        int index = controller.checkId(id);
        if (index == -1) {
            getAndAlert.noPhoneBook();
            //co the nham
            editMenu();
        }
        controller.editPhoneBook(index, createPhoneBook());
    }

    public void deleteMenu() {
        System.out.println("Nhap ma User can sua");
        int id = validate.validateInteger();
        if (id == -1) {
            return;
        }
        int index = controller.checkId(id);
        if (index == -1) {
            getAndAlert.noPhoneBook();
            deleteMenu();
        }
        getAndAlert.confirmToDelete();
        getAndAlert.confirm();
        String confirm = scanner.nextLine();
        if (confirm.equalsIgnoreCase("Y"))
            controller.deletePhoneBook(index);
    }

    public void sortMenu() {
        System.out.println("---Sap xep User theo Id ---");
        System.out.println("Chon chuc nang theo so (de tiep tuc)");
        System.out.println("1.Sap xep ID  tang dan");
        System.out.println("2.Sap xep ID  giam dan");
        System.out.println("3.Thoat");
        System.out.println("Chon chuc nang:");
        controller.sortPhoneBook(scanner.nextLine());
    }

    public void getMenu() {
        getAndAlert.confirmToSave();
        getAndAlert.confirm();
        String confirm = scanner.nextLine();
        if (confirm.equalsIgnoreCase("Y")) {
            controller.readFromFile();
            getAndAlert.finish();
        }
    }

    public void saveMenu() {
        getAndAlert.confirmToSave();
        getAndAlert.confirm();
        String confirm = scanner.nextLine();
        if (confirm.equalsIgnoreCase("Y")) {
            controller.saveToFile();
            getAndAlert.finish();
        }
    }
}
