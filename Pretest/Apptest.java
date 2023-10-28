package Pretest;

import java.util.*;

public class Apptest {
    int max = 10;
    int index = 0;
    Student[] ds = new Student[max];

    public void add() {
        Student s = new Student();
        s.input();
        ds[index] = s;
        index++;
    }

    public void display() {
        if (index == 0) {
            System.out.println("Danh sach trong.");
            return;
        }
        for (Object s:ds) {
            System.out.println(s);
        }
    }

    public void remove(int rId) {
        if (index == 0) {
            System.out.println("danh sach trong.");
            return;
        }
        int cnt = 0;
        for (int i = 0; i < index; i++) {
            if (ds[i].id == rId) {
                ds[i] = ds[i + 1];
                index--;
                cnt++;
                System.out.println("Xoa thanh cong.");
            }
        }
        if (cnt == 0) {
            System.out.println("Khong tim thay id: " + rId);
        }
    }

    public void searchAge(int s_year) {
        if (index == 0) {
            System.out.println("danh sach trong.");
            return;
        }
        ArrayList<Student> sameAge = new ArrayList<>();
        int cnt = 0;
        for (int i = 0; i < index; i++) {
            if (ds[i].dob.getYear() == s_year) {
                sameAge.add(ds[i]);
                cnt++;
            }

        }
        System.out.println(sameAge);
        if (cnt == 0) {
            System.out.println("khong tim thay.");
        }
    }

    public void searchEnter(int enterYear) {
        if (index == 0) {
            System.out.println("Danh sach trong.");
            return;
        }
        ArrayList<Student> sameEnter = new ArrayList<>();
        int cnt = 0;
        for (int i = 0; i < index; i++) {
            if (ds[i].Edate.getYear() == enterYear) {
                sameEnter.add(ds[i]);
                cnt++;
            }

        }
        System.out.println(sameEnter);
        if (cnt == 0) {
            System.out.println("khong tim thay.");
        }
    }


    public static void main(String[] args) {
        Apptest a = new Apptest();
        while (true){
            System.out.println("1.Them moi");
            System.out.println("2.Xem danh sach sinh vien.");
            System.out.println("3.Chinh sua thong tin");
            System.out.println("4.Xoa du lieu");
            System.out.println("5.Xem danh sach sinh vien theo nam sinh");
            System.out.println("6.Xem sanh sach sinh vien theo nam nhap hoc");
            System.out.println("7.Thoat");
            System.out.println("Nhap ma chuc nang: ");
            String op = "";
            Scanner sc= new Scanner(System.in);
            op = sc.nextLine();
            switch (op) {
                case "1":
                    a.add();
                    break;
                case "2":
                    a.display();
                    break;
                case "3":
                    break;
                case "4":
                    System.out.println("Nhap id can xoa: ");
                    int rId = sc.nextInt();
                    a.remove(rId);
                    break;
                case "5":
                    System.out.println("Nhap nam sinh: ");
                    int year = sc.nextInt();
                    a.searchAge(year);
                    break;
                case "6":
                    System.out.println("Nam nhap hoc: ");
                    int enterYear = sc.nextInt();
                    a.searchEnter(enterYear);
                    break;
                case "7":
                    return;
                default:
                    System.out.println("Nhap sai ma chuc nang.");
                    break;
            }
        }
    }
}
