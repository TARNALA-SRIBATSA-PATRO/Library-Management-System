package College;

import java.util.Scanner;

public class book {

    public int sNo;
    public String bookName;
    public String authorName;
    public int bookQty;
    public int bookQtyCopy;

    Scanner input = new Scanner(System.in);

    public book()//adding books into bank
    {
        System.out.print("\nEnter Serial No of the Book: ");
        this.sNo = input.nextInt();
        input.nextLine();

        System.out.print("\nEnter the Book Name: ");
        this.bookName = input.nextLine();

        System.out.print("\nEnter the Author's Name: ");
        this.authorName = input.nextLine();

        System.out.print("\nEnter the Quantity of Books: ");
        this.bookQty = input.nextInt();
        bookQtyCopy = this.bookQty;
    }
}