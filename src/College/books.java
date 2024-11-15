package College;

import java.util.Scanner;

public class books {

    book theBooks[] = new book[50];
    public static int count;

    Scanner input = new Scanner(System.in);

    public int compareBookObjects(book b1, book b2)
    {

        if (b1.bookName.equalsIgnoreCase(b2.bookName)) {

            System.out.println("Book of this Name is Already Exists.");
            return 0;
        }

        if (b1.sNo == b2.sNo) {

            System.out.println("Book of this Serial Number is Already Exists.");

            return 0;
        }
        return 1;
    }

    public void addBook(book b)
    {

        for (int i = 0; i < count; i++) {

            if (this.compareBookObjects(b, this.theBooks[i]) == 0) {

               // System.out.println("Book of this Serial Number / Author is Already Exists.");
                return;
            }
        }

        if (count < 50) {

            theBooks[count] = b;
            count++;
        }
        else {

            System.out.println("No Space to Add More Books.");
        }
    }

    public void searchBySno()
    {

        //ystem.out.print("\t\t\t\tSearch by Serial Number: \n");

        int sNo;
        System.out.print("Enter Serial No of Book:");
        sNo = input.nextInt();

        int flag = 0;
        System.out.println("Sl.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");

        for (int i = 0; i < count; i++) {
            if (sNo == theBooks[i].sNo) {
                System.out.println(theBooks[i].sNo + "\t\t" + theBooks[i].bookName + "\t\t" + theBooks[i].authorName + "\t\t" + theBooks[i].bookQtyCopy + "\t\t" + theBooks[i].bookQty);
                flag++;
                return;
            }
        }
        if (flag == 0)
            System.out.println("No Book for Serial No " + sNo + " is  Found.");
    }

    public void searchByAuthorName()
    {

        //System.out.println("\t\t\t\tSearch by Author's Name: ");

        input.nextLine();

        System.out.println("Enter the Author Name:");
        String authorName = input.nextLine();

        int flag = 0;

        System.out.println("Sl.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");

        for (int i = 0; i < count; i++) {

            if (authorName.equalsIgnoreCase(
                    theBooks[i].authorName)) {

                System.out.println(theBooks[i].sNo + "\t\t" + theBooks[i].bookName + "\t\t" + theBooks[i].authorName + "\t\t" + theBooks[i].bookQtyCopy + "\t\t" + theBooks[i].bookQty);
                flag++;
            }
        }

        if (flag == 0)
            System.out.println("No Books of " + authorName + " is Found.");
    }

    public void showAllBooks()
    {

        System.out.println("\t\t\t\tALL BOOKS\n");
        System.out.println("Sl.No\tName\t\tAuthor\t\tAvailable Qty\tTotal Qty");

        for (int i = 0; i < count; i++) {
            System.out.println(theBooks[i].sNo + "\t\t" + theBooks[i].bookName + "\t\t" + theBooks[i].authorName + "\t\t" + theBooks[i].bookQtyCopy + "\t\t" + theBooks[i].bookQty);
        }
    }

    public void upgradeBookQty()
    {

        //System.out.println("\t\t\t\tUPGRADE QUANTITY OF A BOOK\n");
        System.out.print("\nEnter Serial No of the Book");

        int sNo = input.nextInt();

        for (int i = 0; i < count; i++) {

            if (sNo == theBooks[i].sNo) {

                System.out.print("\nEnter Number of Books to add:");

                int addingQty = input.nextInt();
                theBooks[i].bookQty += addingQty;//before quantity + new quantity
                theBooks[i].bookQtyCopy += addingQty;

                return;
            }
        }
    }

    public void dispMenu()
    {

        System.out.println("+------------------------------------------+");
        System.out.println("| Press 1 to Add new Book.                 |");
        System.out.println("| Press 2 to Upgrade Quantity of a Book.   |");
        System.out.println("| Press 3 to Search a Book.                |");
        System.out.println("| Press 4 to Show All Books.               |");
        System.out.println("| Press 5 to Register Student.             |");
        System.out.println("| Press 6 to Show All Registered Students. |");
        System.out.println("| Press 7 to Check Out Book.               |");
        System.out.println("| Press 8 to Check In Book                 |");
        System.out.println("| Press 0 to Exit Application.             |");
        System.out.println("+------------------------------------------+");
    }

    public int isAvailable(int sNo)
    {

        for (int i = 0; i < count; i++) {
            if (sNo == theBooks[i].sNo) {//matches the serial number
                if (theBooks[i].bookQtyCopy > 0) {//quantity check

                    System.out.println("Book is Available.");
                    return i;
                }
                System.out.println("Book is Unavailable");
                return -1;
            }
        }


        System.out.println("No Book of Serial Number " + sNo +"is available in Library.");
        return -1;
    }

    public book checkOutBook()
    {

        System.out.print("\nEnter Serial No of the Book: ");

        int sNo = input.nextInt();
        //input.nextInt();

        int bookIndex = isAvailable(sNo);

        if (bookIndex != -1) {
            theBooks[bookIndex].bookQtyCopy--;
            return theBooks[bookIndex];
        }
        return null;
    }
    public void checkInBook(book b)
    {
        for (int i = 0; i < count; i++) {
            if (b.equals(theBooks[i])) {
                theBooks[i].bookQtyCopy++;
                return;
            }
        }
    }
}