package Pretest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Student {
    int id;
    String name, address;
    String tel;
    Date dob;
    Date Edate;
    public void input(){
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println("Nhập thông tin sinh viên: ");
        System.out.println("Nhập id: ");
        id = sc.nextInt();
        System.out.println("Nhập tên: ");
        name = sc.nextLine().trim();
        System.out.println(" nhap dc: ");
        address = sc.nextLine().trim();
        while (true){
            System.out.println("Nhập sdt: ");
            tel = sc.nextLine().trim();
            Pattern p = Pattern.compile("^[0-9]{7}$");
            if (p.matcher(tel).find()){
                break;
            }
            System.out.println("LỖI: SDT không hợp lệ(phải có 7 chữ số.)");
        }
        while (true){
            try {
                System.out.println("Nhập ngày sinh(dd-mm-yyyy): ");
                dob = df.parse(sc.nextLine());
                break;
            }catch (ParseException e){
                System.out.println("LOI: nhập sai định dạng.");
            }
        }

        while (true){
            try {
                System.out.println("Ngày nhập học (dd-mm-yyyy): ");
                Edate = df.parse(sc.nextLine());
                break;
            }catch (ParseException e){
                System.out.println("LOI: nhập sai định dạng.");
            }
        }
    }
    public Integer getAge(){
        if (this.dob!=null){
            int age = DateTimeUtils.getAge(this.dob);
            return age<0 ? null:age;
        }
        return null;
    }
    public Integer getLevel(){
        LocalDate date = LocalDate.now();
        if (Edate!=null){
            int levelAge = DateTimeUtils.getAge(this.Edate);
            return levelAge<0?null:levelAge;
        }
        return null;
    }

    @Override
    public String toString() {
        return String.format("Mã sv: %s, Tên: %s, Địa chỉ: %s, SĐT: %s, Tuổi: %s, Học năm: %s",id,name,address,tel,getAge(),getLevel());
    }
}
