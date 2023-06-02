/**
 * @author Shayan Chaleshi
 */

import java.io.IOException;
import java.io.RandomAccessFile;


public class FlightFile extends WorkWithFile {


    //******************************************** ----> FLight table

    /**
     *
     * @param return_mod
     * @param userFile
     * @param flightFile
     * @param ticketFile
     * @throws IOException
     * @throws InterruptedException
     */
    public void flight_table(int return_mod, RandomAccessFile userFile, RandomAccessFile flightFile, RandomAccessFile ticketFile) throws IOException, InterruptedException {

        try {


            UserFile user_ins = new UserFile();
            cls();
            UserFile.table_head_printer();

            for (int i = 0; i < Login.flightCounter; ++i) {
                if (!readString(i * FLIGHTLENGHT, flightFile).equals(removed)) {
                    System.out.print("\n\t\t");
                    System.out.printf("|    %-10s|    %-10s|    %-11s| %-12s|  %-9s|  %-10s|  %-4s  ", readString(i * FLIGHTLENGHT, flightFile), readString(i * FLIGHTLENGHT + FIXSTRING, flightFile), readString(i * FLIGHTLENGHT + 80, flightFile), readString(i * FLIGHTLENGHT + 120, flightFile), readString(i * FLIGHTLENGHT + 160, flightFile), flightFile.readLong(), flightFile.readInt());
                    System.out.print("|");
                    System.out.print("\n\t\t");
                    System.out.print("+---------------------------------------------------------------------------------------------+");
                }
            }

            System.out.print("\n\n\n\t\t\t\t\t");
            System.out.println("press any key to return...");
            scanner.next();
            Admin admin1 = new Admin();
            if (return_mod == 1) {
                admin1.admin_menu(userFile, flightFile, ticketFile);
            } else {
                user_ins.regular_user_menu(userFile, flightFile, ticketFile);
            }


        } catch (Exception var10) {
            Admin admin2 = new Admin();
            UserFile userFile1 = new UserFile();

            error();
            if (return_mod == 1) {
                admin2.admin_menu(userFile, flightFile, ticketFile);
            } else {
                userFile1.regular_user_menu(userFile, flightFile, ticketFile);
            }
        }
    }

    //******************************************** ----> is flight exist

    /**
     *
     * @param id
     * @param flightFile
     * @return
     * @throws IOException
     */
    public int if_flight_exist(String id, RandomAccessFile flightFile) throws IOException {
        for (int i = 0; (long) i < Login.flightCounter; ++i) {
            if (readString(i * FLIGHTLENGHT, flightFile).equals(id)) {
                return i;
            }
        }

        return -1;
    }

}
