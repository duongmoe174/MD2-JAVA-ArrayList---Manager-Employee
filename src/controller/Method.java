package controller;

import model.Employee;
import model.FullTimeEmployee;
import model.PartTimeEmployee;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Method {
    public static void displayElement(ArrayList<Employee> arr) {
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }
    }

    public static void addEmployee(ArrayList<Employee> arr, Employee employee) {
        arr.add(employee);
    }

    public static Employee createNewEmployeeFullTime () {
        Scanner inputIDFullTime = new Scanner(System.in);
        System.out.println("Nhập ID nhân viên Full Time: ");
        String id = inputIDFullTime.nextLine();

        Scanner inputnameFullTime = new Scanner(System.in);
        System.out.println("Nhập tên nhân viên Full Time: ");
        String name = inputnameFullTime.nextLine();

        Scanner inputAgeFullTime = new Scanner(System.in);
        System.out.println("Nhập tuổi nhân viên Full Time: ");
        int age = inputAgeFullTime.nextInt();

        Scanner inputPhoneFullTime = new Scanner(System.in);
        System.out.println("Nhập số điện thoại nhân viên Full Time: ");
        String phone = inputPhoneFullTime.nextLine();

        Scanner inputEmailFullTime = new Scanner(System.in);
        System.out.println("Nhập email nhân viên Full Time: ");
        String email = inputEmailFullTime.nextLine();

        Scanner inputBonus = new Scanner(System.in);
        System.out.println("Nhập số tiền thưởng: ");
        double bonus = inputBonus.nextDouble();

        Scanner inputFineMoney = new Scanner(System.in);
        System.out.println("Nhập số tiền phạt: ");
        double fineMoney = inputFineMoney.nextDouble();

        Scanner inputBasicSalary = new Scanner(System.in);
        System.out.println("Nhập lương cơ bản: ");
        double basicSalary = inputBasicSalary.nextDouble();

        Employee newEmployee = new FullTimeEmployee(id, name, age, phone, email, bonus, fineMoney, basicSalary);
        return newEmployee;
    }
    public static Employee createNewEmployeePartTime () {
        Scanner inputIDPartTime = new Scanner(System.in);
        System.out.println("Nhập ID nhân viên Part Time: ");
        String id = inputIDPartTime.nextLine();

        Scanner inputNamePartTime = new Scanner(System.in);
        System.out.println("Nhập tên nhân viên Part Time: ");
        String name = inputNamePartTime.nextLine();

        Scanner inputAgePartTime = new Scanner(System.in);
        System.out.println("Nhập tuổi nhân viên Part Time: ");
        int age = inputAgePartTime.nextInt();

        Scanner inputPhoneFullTime = new Scanner(System.in);
        System.out.println("Nhập số điện thoại nhân viên Part Time: ");
        String phone = inputPhoneFullTime.nextLine();

        Scanner inputEmailPartTime = new Scanner(System.in);
        System.out.println("Nhập email nhân viên Part Time: ");
        String email = inputEmailPartTime.nextLine();

        Scanner inputWorkHour = new Scanner(System.in);
        System.out.println("Nhập số giờ làm việc của nhân viên: ");
        double hour = inputWorkHour.nextDouble();

        Employee newEmployee = new PartTimeEmployee(id, name, age, phone, email, hour);
        return newEmployee;
    }

    public static double averageSalary(ArrayList<Employee> arr) {
        double sum = 0;
        double count = 0;
        for (int i = 0; i < arr.size(); i++) {
            sum += arr.get(i).getNetSalary();
            count++;
        }
        double avg = sum / count;
        return avg;
    }

    public static void displayLowerFTSalary(ArrayList<Employee> arr) {
        int serial = 1;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) instanceof FullTimeEmployee) {
                if (arr.get(i).getNetSalary() < Method.averageSalary(arr)) {
                    System.out.println(serial + ". " + arr.get(i).getFullName());
                    serial ++;
                }
            }
        }
    }

    public static double salaryMustPayForPT(ArrayList<Employee> arr) {
        double sum = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) instanceof PartTimeEmployee) {
                sum += arr.get(i).getNetSalary();
            }
        }
        return sum;
    }

    public static void sortSalaryFullTime(ArrayList<Employee> arr) {
        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arr.size() - 1; j++) {
                if (arr.get(j) instanceof FullTimeEmployee) {
                    if (arr.get(j).getNetSalary() > arr.get(j + 1).getNetSalary()) {
                        FullTimeEmployee temp = (FullTimeEmployee) arr.get(j);
                        arr.set(j, arr.get(j+1));
                        arr.set(j+1, temp);
                    }
                }
            }
        }
        int serial = 1;
        for (int i = 0; i < arr.size(); i++) {
            if(arr.get(i) instanceof FullTimeEmployee) {
                System.out.println(serial + ". " + arr.get(i).getFullName());
                serial++;
            }
        }
    }
}
