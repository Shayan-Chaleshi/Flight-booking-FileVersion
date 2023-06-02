import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class WorkWithFile
{

    Scanner scanner = new Scanner(System.in) ;
    final int FIXSTRING =    40   ;
    final int USERLENGHT =   88   ;
    final int FLIGHTLENGHT = 212  ;
    final int TICKETLENGHT = 120  ;
    String removed = "Removed!";

//******************************************** ----> Read String

    public String readString( int startPoint , RandomAccessFile rFile ) throws IOException
    {

        String str = "";
        rFile.seek(startPoint);

        for (int i = 0 ; i < 20 ; i++)
        {
            str+=rFile.readChar();
        }

        return str.trim();

    }

//******************************************** ----> Write String

    public void writeString(long startPoint , String str , RandomAccessFile rFile ) throws IOException
    {

        str= fixString(str) ;

        rFile.seek(startPoint);

        rFile.writeChars(str);

    }
//******************************************** ----> Fix String

    public String fixString(String str)
    {
        while (str.length() <= 21 )
        {
            str+=" ";
        }
        return str.substring( 0 , 20 );

    }


    //******************************************** ---->  clear screen
    public static void cls() throws IOException, InterruptedException
    {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }

    //******************************************** ---->  first empty

    public int firstEmpty(RandomAccessFile rFile , long size , int length) throws IOException
    {
        for (int i = 0; i < size; i++)
        {
            if (readString( (i*length) , rFile).equals(removed))
            {
                return i;
            }
        }
        return -1 ;
    }

    //******************************************** ---->  Print done

    void print_done() throws IOException, InterruptedException
    {
        cls();
        System.out.println("\n\n\n\n\n\n\n\n\n\n");
        System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
        System.out.println("\t\t\t\t*                                             *");
        System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
        System.out.println("\t\t\t\t*                                             *");
        System.out.println("\t\t\t\t*                                             *");
        System.out.println("\t\t\t\t*                   Done!                     *");
        System.out.println("\t\t\t\t*                                             *");
        System.out.println("\t\t\t\t*          Press any key to return...         *");
        System.out.println("\t\t\t\t*                                             *");
        System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
        System.out.println("\t\t\t\t+ * * * * * * * * * * * * * * * * * * * * * * +");

        scanner.next();
    }


    //******************************************** ---->  invalid print
     public void error() throws IOException, InterruptedException
     {
         cls();
         System.out.println("\n\n\n\n\n\n\n\n\n\n");
         System.out.println("\t\t\t\t+ * * * * * * * * * * * * * * * * * * * * * * +");
         System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
         System.out.println("\t\t\t\t*:::::::::::::::::   Error  ::::::::::::::::: *");
         System.out.println("\t\t\t\t*                                             *");
         System.out.println("\t\t\t\t*                                             *");
         System.out.println("\t\t\t\t*              Invalid input !                *");
         System.out.println("\t\t\t\t*                                             *");
         System.out.println("\t\t\t\t*                                             *");
         System.out.println("\t\t\t\t*           press any key to return...        *");
         System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
         System.out.println("\t\t\t\t+ * * * * * * * * * * * * * * * * * * * * * * +");
            scanner.nextLine();
            scanner.nextLine();
     }
    //******************************************** ---->  test print
//    public void test(RandomAccessFile userFile , RandomAccessFile flightFile , RandomAccessFile ticketFile) throws IOException
//    {
//        System.out.println("****".repeat(20));
//        System.out.println("Users :");
//
//
//
//
//        // print users
//        for (int i = 0; i < Login.userCounter; i++)
//        {
//            if (!readString(i*USERLENGHT , userFile).equals(removed))
//                System.out.print(readString(i*USERLENGHT , userFile) + "\t"+ readString(i*USERLENGHT + FIXSTRING, userFile) +"\t" + userFile.readLong() +"\n");
//        }
//
//
//        System.out.println("****".repeat(20));
//        System.out.println("Flights :");
//
//
//
//
//        // print flights
//        for (int i = 0; i < Login.flightCounter; i++)
//        {
//            if (!readString(i*FLIGHTLENGHT , flightFile).equals(removed))
//                System.out.print(readString(i*FLIGHTLENGHT , flightFile) + "\t"+ readString(i*FLIGHTLENGHT + FIXSTRING, flightFile) + "\t"+ readString(i*FLIGHTLENGHT + 2*FIXSTRING, flightFile) + "\t"+ readString(i*FLIGHTLENGHT + 3*FIXSTRING, flightFile) + "\t"+ readString(i*FLIGHTLENGHT + 4*FIXSTRING, flightFile) +"\t" + flightFile.readLong() + "\t" + flightFile.readInt() +"\n");
//        }
//        System.out.println(Login.flightCounter);
//        System.out.println("****".repeat(20));
//        System.out.println("Tickets :");
//
//
//
//
//        //print tickets
//
//        for (int i = 0; i < Login.ticketCounter; i++)
//        {
//            if (!readString(i*TICKETLENGHT , ticketFile).equals(removed))
//                System.out.print(readString(i*TICKETLENGHT , ticketFile) + "\t"+ readString(i*TICKETLENGHT + FIXSTRING, ticketFile) + "\t"+ readString(i*TICKETLENGHT + 2*FIXSTRING, ticketFile)  +"\n");
//        }
//        System.out.println(Login.ticketCounter);
//        System.out.println("****".repeat(20));
//
//    }


}
