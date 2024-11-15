package College;

import java.util.Scanner;

public class student {

    String studentName;
    String regNum;

    book borrowedBooks[] = new book[3];
    public int booksCount = 0;

    Scanner input = new Scanner(System.in);

    public student()//student registration
    {
        System.out.print("\nEnter Student Name: ");

        this.studentName = input.nextLine();

        System.out.print("\nEnter Registration Number: ");
        this.regNum = input.nextLine();
    }
}
