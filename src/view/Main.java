package view;

import controller.Method;
import model.Employee;
import model.FullTimeEmployee;
import model.PartTimeEmployee;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        Employee hieu = new PartTimeEmployee("PT01", "Vu Minh Hieu", 19, "0367879658", "hieucave@gmail.com", 40);
        Employee duong = new PartTimeEmployee("PT02", "Tran Thai Duong", 21, "0367573937", "DuongGym@gmail.com", 60);
        Employee duc = new PartTimeEmployee("PT03", "Nguyen Trung Duc", 33, "0361234569", "DucGay@gmail.com", 30);

        Employee tuan = new FullTimeEmployee("FT01", "Kieu Minh Tuan", 35, "0364578989", "TuanBip@gmail.com", 3000000, 400000, 9000000);
        Employee giang = new FullTimeEmployee("FT02", "Vu Binh Giang", 20, "0364578915", "GiangKoi@gmail.com", 4000000, 200000, 17000000);
        Employee luong = new FullTimeEmployee("FT03", "Le Van Luong", 45, "0364578922", "LeLuong@gmail.com", 2000000, 600000, 15000000);
        Employee huy = new FullTimeEmployee("FT04", "Huynh Hieu Huy", 19, "0364578123", "HuyGG@gmail.com", 0, 100000, 5000000);
        Employee minh = new FullTimeEmployee("FT03", "Tran Van Minh", 21, "0364578456", "MinhMan@gmail.com", 0, 100000, 3000000);

        Method.addEmployee(employees, hieu);
        Method.addEmployee(employees, duong);
        Method.addEmployee(employees, duc);
        Method.addEmployee(employees, tuan);
        Method.addEmployee(employees, giang);
        Method.addEmployee(employees, luong);
        Method.addEmployee(employees, huy);
        Method.addEmployee(employees, minh);


        int choice = -1;
        Scanner inputChoice = new Scanner(System.in);
        while (choice != 0) {
            System.out.println("Menu");
            System.out.println("1. Hiển thị danh sách nhân viên");
            System.out.println("2. Hiển thị lương trung bình toàn bộ nhân viên");
            System.out.println("3. Hiển thụ nhân viên FullTime có lương thấp hơn trung bình toàn công ty");
            System.out.println("4. Hiển thị số lương phải trả cho nhân viên Part Time");
            System.out.println("5. Thứ tự nhân viên Full Time theo lương tăng dần");
            System.out.println("6. Thêm mới nhân viên Full Time");
            System.out.println("7. Thêm mới nhân viên Part Time");
            System.out.println("0. Exit!");
            System.out.println("Nhập lựa chọn: ");
            choice = inputChoice.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("số lượng nhân viên có trong công ty là: " + employees.size());

                    System.out.println("Danh sách nhân viên: ");
                    Method.displayElement(employees);
                    break;
                case 2:
                    System.out.println("Lương trung bình toàn bộ nhân viên là: " + Method.averageSalary(employees));
                    break;
                case 3:
                    System.out.println("Nhân viên Full Time có lương thấp hơn lương trung bình toàn công ty: ");
                    Method.displayLowerFTSalary(employees);
                    break;
                case 4:
                    System.out.println("Số lương phải trả cho nhân viên Part Time là: " + Method.salaryMustPayForPT(employees));
                    break;
                case 5:
                    System.out.println("Thứ tự nhân viên Full Time theo lương tăng dần là: ");
                    Method.sortSalaryFullTime(employees);
                    break;
                case 6:
                    Method.addEmployee(employees, Method.createNewEmployeeFullTime());
                    break;
                case 7:
                    Method.addEmployee(employees, Method.createNewEmployeePartTime());
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Chưa nhập lựa chọn!");
            }
        }
    }
}
