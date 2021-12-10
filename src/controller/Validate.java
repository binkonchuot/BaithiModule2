package controller;

import View.GetAndAlert;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    GetAndAlert getAndAlert = new GetAndAlert();
    Scanner scanner =new Scanner(System.in);

    public int validateInteger() {
        try {
            String word = scanner.nextLine();
            if(word.equals("")){
                return -1;
            }
            int number = Integer.parseInt(word);
            if (number < 0) {
                getAndAlert.alertNumber();
                return validateInteger();
            }
            return number;
        } catch (Exception e) {
            getAndAlert.alertNumber();
            return validateInteger();
        }
    }
    public String validateName() {
        String regex = scanner.nextLine();

        final String ACCOUNT_REGEX = ("^[a-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶ\"+\n" +
                "\"ẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợ\"+\n" +
                "\"ụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s]+$");
        Pattern pattern = Pattern.compile(ACCOUNT_REGEX);
        Matcher matcher = pattern.matcher(regex);
        if (matcher.matches()) {
            return regex;
        } else {
            System.err.println("VUI LONG NHAP LAI!");
            regex = validateName();
        }
        return regex;
    }

    public String validateGender() {
        while (true) {
            String gender = scanner.nextLine();
            if (gender.equalsIgnoreCase("nam")) return "Nam";
            if (gender.equalsIgnoreCase("nu")) return "Nu";
            System.err.println("VUI LONG NHAP NAM HOAC NU!");
        }
    }

    public String validatePhoneNumber() {
        String regex = scanner.nextLine();
        Pattern pattern = Pattern.compile("[0]\\d{8,9}");
        Matcher matcher = pattern.matcher(regex);
        if(!matcher.matches()){
            System.err.println("VUI LONG NHAP LAI SO DIEN THOAI!");
            return validatePhoneNumber();
        }else return regex;
    }

    public String validateDate(){
        String regex = scanner.nextLine();
        Pattern pattern = Pattern.compile("[0-3]\\d-[012]\\d-\\d{4}");
        Matcher matcher = pattern.matcher(regex);
        if(!matcher.matches()){
            System.err.println("VUI LONG NHAP LAI NGAY!");
            return validateDate();
        }else return regex;
    }

    public String validateEmail(){
        String regex = scanner.nextLine();
        Pattern pattern = Pattern.compile("^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$");
        Matcher matcher = pattern.matcher(regex);
        if(!matcher.matches()){
            System.err.println("VUI LONG NHAP LAI SO DIEN THOAI!");
            return validateEmail();
        }else return regex;
    }
}
