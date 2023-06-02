/**
 * @author Shayan Chaleshi
 */

import java.io.IOException;
import java.io.RandomAccessFile;


public class Admin extends WorkWithFile {
    FlightFile flight = new FlightFile();

    //******************************************** ----> admin menu

    public void admin_menu(RandomAccessFile userFile, RandomAccessFile flightFile, RandomAccessFile ticketFile) throws IOException, InterruptedException {
        try {

            cls();
            System.out.println("\n\n\n\n\n\n\n\n\n\n");
            System.out.println("\t\t\t\t+ * * * * * * * * * * * * * * * * * * * * * * +");
            System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
            System.out.println("\t\t\t\t*               Admin menu                    *");
            System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
            System.out.println("\t\t\t\t*                                             *");
            System.out.println("\t\t\t\t*  1)Add                                      *");
            System.out.println("\t\t\t\t*  2)Update                                   *");
            System.out.println("\t\t\t\t*  3)Remove                                   *");
            System.out.println("\t\t\t\t*  4)Flight schedules                         *");
            System.out.println("\t\t\t\t*  0)Sign out                                 *");
            System.out.println("\t\t\t\t*                                             *");
            System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
            System.out.println("\t\t\t\t+ * * * * * * * * * * * * * * * * * * * * * * +");

            int admin_mod;

            admin_mod = scanner.nextInt();


            switch (admin_mod) {
                case 1 -> add_flight(userFile, flightFile, ticketFile);
                case 2 -> edit_flight_menu1(userFile, flightFile, ticketFile);
                case 3 -> delete_flight(userFile, flightFile, ticketFile);
                case 4 -> flight.flight_table(1, userFile, flightFile, ticketFile);
                case 0 -> {
                    Login login1 = new Login();
                    login1.sign_menu(userFile, flightFile, ticketFile);
                }
                default -> {
                    System.out.println("invalid input.\nplease tyr again\npress any key to return ....");
                    scanner.next();
                    admin_menu(userFile, flightFile, ticketFile);
                }
            }
        } catch (Exception var10) {
            error();
            admin_menu(userFile, flightFile, ticketFile);
        }
    }

    //******************************************** ---->  add flight

    /**
     *
     * @param userFile
     * @param flightFile
     * @param ticketFile
     * @throws IOException
     * @throws InterruptedException
     */
    void add_flight(RandomAccessFile userFile, RandomAccessFile flightFile, RandomAccessFile ticketFile) throws IOException, InterruptedException {
        try {

            long index;
            boolean addFlag = false;

            //        cls();
            System.out.println("\n\n\n\n\n\n\n\n\n\n");
            System.out.println("\t\t\t\t+ * * * * * * * * * * * * * * * * * * * * * * +");
            System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
            System.out.println("\t\t\t\t*               add flight                    *");
            System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
            System.out.println("\t\t\t\t*                                             *");
            System.out.println("\t\t\t\t*                                             *");
            System.out.println("\t\t\t\t*  please enter the following info to add :   *");
            System.out.println("\t\t\t\t*                                             *");
            System.out.println("\t\t\t\t*   1---> Origin                              *");
            System.out.println("\t\t\t\t*   2---> Destination                         *");
            System.out.println("\t\t\t\t*   3---> Time                                *");
            System.out.println("\t\t\t\t*   4---> Date                                *");
            System.out.println("\t\t\t\t*   5---> Price                               *");
            System.out.println("\t\t\t\t*   6---> Seats                               *");
            System.out.println("\t\t\t\t*   7---> Exit                                *");
            System.out.println("\t\t\t\t*                                             *");
            System.out.println("\t\t\t\t*                                             *");
            System.out.println("\t\t\t\t*          [ press + to turn back ]           *");
            System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
            System.out.println("\t\t\t\t+ * * * * * * * * * * * * * * * * * * * * * * +\n");

            if (firstEmpty(flightFile, Login.flightCounter, FLIGHTLENGHT) != -1)
                index = (long) firstEmpty(flightFile, Login.flightCounter, FLIGHTLENGHT) * FLIGHTLENGHT;

            else {
                index = flightFile.length();
                addFlag = true;
            }

            // add flight id
            String id_generator;
            id_generator = "WX-";
            id_generator += String.valueOf(FLight.flight_id_generator_counter);


            // add origin
            System.out.print("\t\t\t\t\t#  Origin --->  ");
            String origin = scanner.next();
            if (origin.equals("+")) {
                admin_menu(userFile, flightFile, ticketFile);
            }


            // add destination
            System.out.print("\t\t\t\t\t#  Destination --->  ");
            String destination = scanner.next();
            if (destination.equals("+")) {
                admin_menu(userFile, flightFile, ticketFile);
            }


            // add date
            System.out.print("\t\t\t\t\t#  Date --->  ");
            String date = scanner.next();
            if (date.equals("+")) {
                admin_menu(userFile, flightFile, ticketFile);
            }


            // add time
            System.out.print("\t\t\t\t\t#  Time --->  ");
            String time = scanner.next();
            if (time.equals("+")) {
                admin_menu(userFile, flightFile, ticketFile);
            }


            // add price
            System.out.print("\t\t\t\t\t#  Price --->  ");
            String price = scanner.next();
            if (price.equals("+")) {
                admin_menu(userFile, flightFile, ticketFile);
            }
            long pricee = Long.parseLong(price);


            // add seats
            System.out.print("\t\t\t\t\t#  Seats --->  ");
            String seats = scanner.next();
            if (seats.equals("+")) {
                admin_menu(userFile, flightFile, ticketFile);
            }
            int seatss = Integer.parseInt(seats);


            if (addFlag)
                Login.flightCounter++;

            // write them all

            //flight id
            writeString(index, id_generator, flightFile);
            FLight.flight_id_generator_counter++;

            //origin
            writeString(index + FIXSTRING, origin, flightFile);

            //destination
            writeString(index + 2 * FIXSTRING, destination, flightFile);

            //date
            writeString(index + 3 * FIXSTRING, date, flightFile);

            //time
            writeString(index + 4 * FIXSTRING, time, flightFile);

            //price
            flightFile.writeLong(pricee);

            //seats
            flightFile.writeInt(seatss);


            print_done();
            admin_menu(userFile, flightFile, ticketFile);
        } catch (Exception var10) {
            error();
            admin_menu(userFile, flightFile, ticketFile);
        }
    }

    //******************************************** ---->  edit menu 1
    void edit_flight_menu1(RandomAccessFile userFile, RandomAccessFile flightFile, RandomAccessFile ticketFile) throws IOException, InterruptedException {
        try {
            int flight_index;
//        cls();
            System.out.println("\n\n\n\n\n\n\n\n\n\n");
            System.out.println("\t\t\t\t+ * * * * * * * * * * * * * * * * * * * * * * +");
            System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
            System.out.println("\t\t\t\t*               edit flight                   *");
            System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
            System.out.println("\t\t\t\t*                                             *");
            System.out.println("\t\t\t\t*                                             *");
            System.out.println("\t\t\t\t*  please enter a flight id to edit details:  *");
            System.out.println("\t\t\t\t*                                             *");
            System.out.println("\t\t\t\t*                                             *");
            System.out.println("\t\t\t\t*                                             *");
            System.out.println("\t\t\t\t*          [ press + to turn back ]           *");
            System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
            System.out.println("\t\t\t\t+ * * * * * * * * * * * * * * * * * * * * * * +");

            String id;
            id = scanner.next();
            if (id.equals("+"))
                admin_menu(userFile, flightFile, ticketFile);


            flight_index = flight.if_flight_exist(id.toUpperCase(), flightFile);
            if (flight_index == -1) {
//            cls();
                System.out.println("\n\n\n\n\n\n\n\n\n\n");
                System.out.println("\t\t\t\t+ * * * * * * * * * * * * * * * * * * * * * * +");
                System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
                System.out.println("\t\t\t\t*               edit flight                    *");
                System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
                System.out.println("\t\t\t\t*                                             *");
                System.out.println("\t\t\t\t*                                             *");
                System.out.println("\t\t\t\t*          flight does not exist !             *");
                System.out.println("\t\t\t\t*                                             *");
                System.out.println("\t\t\t\t*                                             *");
                System.out.println("\t\t\t\t*       press any key to try again...         *");
                System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
                System.out.println("\t\t\t\t+ * * * * * * * * * * * * * * * * * * * * * * +");
                scanner.next();
                edit_flight_menu1(userFile, flightFile, ticketFile);
            } else {
                edit_flight_menu2(flight_index, userFile, flightFile, ticketFile);
            }

        } catch (Exception var10) {
            error();
            admin_menu(userFile, flightFile, ticketFile);
        }
    }

    //******************************************** ---->  edit menu 2
    void edit_flight_menu2(int flight_index, RandomAccessFile userFile, RandomAccessFile flightFile, RandomAccessFile ticketFile) throws IOException, InterruptedException {
        try {

            while (true) {

                cls();
                System.out.println("\n\n\n\n\n\n\n\n\n\n");
                System.out.println("\t\t\t\t+ * * * * * * * * * * * * * * * * * * * * * * +");
                System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
                System.out.println("\t\t\t\t*               edit flight                   *");
                System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
                System.out.println("\t\t\t\t*      which one do you want to change        *");
                System.out.println("\t\t\t\t*                                             *");
                System.out.println("\t\t\t\t*    1) flight id                             *");
                System.out.println("\t\t\t\t*    2) origin                                *");
                System.out.println("\t\t\t\t*    3) destination                           *");
                System.out.println("\t\t\t\t*    4) date                                  *");
                System.out.println("\t\t\t\t*    5) time                                  *");
                System.out.println("\t\t\t\t*    6) price                                 *");
                System.out.println("\t\t\t\t*    7) seats                                 *");
                System.out.println("\t\t\t\t*    0) exit                                  *");
                System.out.println("\t\t\t\t*                                             *");
                System.out.println("\t\t\t\t+ * * * * * * * * * * * * * * * * * * * * * * +");

                int edit_mod;
                edit_mod = scanner.nextInt();

                if (edit_mod == 0)
                    admin_menu(userFile, flightFile, ticketFile);


//            cls();
                System.out.println("\n\n\n\n\n\n\n\n\n\n");
                System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
                System.out.println("\t\t\t\t*               edit flight                    *");
                System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
                System.out.println("\t\t\t\t*                                             *");
                System.out.println("\t\t\t\t*                                             *");
                System.out.println("\t\t\t\t*   enter the new value and press enter :     *");
                System.out.println("\t\t\t\t*                                             *");
                System.out.println("\t\t\t\t*                                             *");
                System.out.println("\t\t\t\t*          [ press + to turn back ]           *");
                System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
                System.out.println("\t\t\t\t+ * * * * * * * * * * * * * * * * * * * * * * +");


                edit_flight(flight_index, edit_mod, userFile, flightFile, ticketFile);

                print_done();

            }


        } catch (Exception var10) {
            error();
            admin_menu(userFile, flightFile, ticketFile);
        }
    }

    //******************************************** ---->  edit flight logic

    /**
     *
     * @param flight_index
     * @param mod
     * @param userFile
     * @param flightFile
     * @param ticketFile
     * @throws IOException
     * @throws InterruptedException
     */
    void edit_flight(int flight_index, int mod, RandomAccessFile userFile, RandomAccessFile flightFile, RandomAccessFile ticketFile) throws IOException, InterruptedException {
        try {
            String flight_info;
            flight_info = scanner.next();

            if (flight_info.equals("+"))
                edit_flight_menu2(flight_index, userFile, flightFile, ticketFile);

            flight_info = flight_info.toUpperCase();

            switch (mod) {
                case 1 -> writeString((long) flight_index * FLIGHTLENGHT, flight_info, flightFile);
                case 2 -> writeString((long) flight_index * FLIGHTLENGHT + FIXSTRING, flight_info, flightFile);
                case 3 -> writeString((long) flight_index * FLIGHTLENGHT + 2 * FIXSTRING, flight_info, flightFile);
                case 4 -> writeString((long) flight_index * FLIGHTLENGHT + 3 * FIXSTRING, flight_info, flightFile);
                case 5 -> writeString((long) flight_index * FLIGHTLENGHT + 4 * FIXSTRING, flight_info, flightFile);
                case 6 -> {
                    flightFile.seek((long) flight_index * FLIGHTLENGHT + 5 * FIXSTRING);
                    flightFile.writeLong(Long.parseLong(flight_info));
                }
                case 7 -> {
                    flightFile.seek((long) flight_index * FLIGHTLENGHT + 5 * FIXSTRING + 8);
                    flightFile.writeInt(Integer.parseInt(flight_info));
                }
            }
        } catch (Exception var10) {
            error();
            admin_menu(userFile, flightFile, ticketFile);
        }
    }


    //******************************************** ---->  delete flight

    /**
     *
     * @param userFile
     * @param flightFile
     * @param ticketFile
     * @throws IOException
     * @throws InterruptedException
     */
    void delete_flight(RandomAccessFile userFile, RandomAccessFile flightFile, RandomAccessFile ticketFile) throws IOException, InterruptedException {
        try {
            cls();
            System.out.println("\n\n\n\n\n\n\n\n\n\n");
            System.out.println("\t\t\t\t+ * * * * * * * * * * * * * * * * * * * * * * +");
            System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
            System.out.println("\t\t\t\t*               Delete menu                   *");
            System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
            System.out.println("\t\t\t\t*                                             *");
            System.out.println("\t\t\t\t*                                             *");
            System.out.println("\t\t\t\t*        Enter flight id to delete :          *");
            System.out.println("\t\t\t\t*                                             *");
            System.out.println("\t\t\t\t*                                             *");
            System.out.println("\t\t\t\t*          [ press + to turn back ]           *");
            System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
            System.out.println("\t\t\t\t+ * * * * * * * * * * * * * * * * * * * * * * +");


            String delete_id;
            delete_id = scanner.next().toUpperCase();
            if (delete_id.equals("+"))
                admin_menu(userFile, flightFile, ticketFile);

            int flight_index;
            flight_index = flight.if_flight_exist(delete_id, flightFile);

            if (flight_index == -1) {
//            cls();
                System.out.println("\n\n\n\n\n\n\n\n\n\n");
                System.out.println("\t\t\t\t+ * * * * * * * * * * * * * * * * * * * * * * +");
                System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
                System.out.println("\t\t\t\t*               Delete menu                   *");
                System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
                System.out.println("\t\t\t\t*                                             *");
                System.out.println("\t\t\t\t*                                             *");
                System.out.println("\t\t\t\t*           Flight does not exist !           *");
                System.out.println("\t\t\t\t*                                             *");
                System.out.println("\t\t\t\t*                                             *");
                System.out.println("\t\t\t\t*          Press any key to return...         *");
                System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
                System.out.println("\t\t\t\t+ * * * * * * * * * * * * * * * * * * * * * * +");
                scanner.next();
                delete_flight(userFile, flightFile, ticketFile);

            } else if (is_flight_bought(delete_id, ticketFile)) {
                cls();
                System.out.println("\n\n\n\n\n\n\n\n\n\n");
                System.out.println("\t\t\t\t+ * * * * * * * * * * * * * * * * * * * * * * +");
                System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
                System.out.println("\t\t\t\t*               Delete menu                   *");
                System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
                System.out.println("\t\t\t\t*                                             *");
                System.out.println("\t\t\t\t*                                             *");
                System.out.println("\t\t\t\t*               Access Denied !               *");
                System.out.println("\t\t\t\t*        The fLight cannot be deleted.         *");
                System.out.println("\t\t\t\t*                                             *");
                System.out.println("\t\t\t\t*                                             *");
                System.out.println("\t\t\t\t*           Press any key to return...        *");
                System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
                System.out.println("\t\t\t\t+ * * * * * * * * * * * * * * * * * * * * * * +");
                scanner.next();
                admin_menu(userFile, flightFile, ticketFile);
            }

            // delete flight
            writeString((long) flight_index * FLIGHTLENGHT, removed, flightFile);
            writeString((long) flight_index * FLIGHTLENGHT + FIXSTRING, removed, flightFile);
            writeString((long) flight_index * FLIGHTLENGHT + 2 * FIXSTRING, removed, flightFile);
            writeString((long) flight_index * FLIGHTLENGHT + 3 * FIXSTRING, removed, flightFile);
            writeString((long) flight_index * FLIGHTLENGHT + 4 * FIXSTRING, removed, flightFile);
            flightFile.writeLong(0);
            flightFile.writeInt(0);


            cls();
            System.out.println("\n\n\n\n\n\n\n\n\n\n");
            System.out.println("\t\t\t\t+ * * * * * * * * * * * * * * * * * * * * * * +");
            System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
            System.out.println("\t\t\t\t*               Delete menu                   *");
            System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
            System.out.println("\t\t\t\t*                                             *");
            System.out.println("\t\t\t\t*                                             *");
            System.out.println("\t\t\t\t*         Flight successfully deleted :)      *");
            System.out.println("\t\t\t\t*                                             *");
            System.out.println("\t\t\t\t*                                             *");
            System.out.println("\t\t\t\t*           Press any key to return...        *");
            System.out.println("\t\t\t\t*                                             *");
            System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
            System.out.println("\t\t\t\t+ * * * * * * * * * * * * * * * * * * * * * * +");

            scanner.next();
            admin_menu(userFile, flightFile, ticketFile);

        } catch (Exception var10) {
            error();
            admin_menu(userFile, flightFile, ticketFile);
        }
    }


    //******************************************** ----> is flight bought

    /**
     *
     * @param flight_id
     * @param ticketFile
     * @return
     * @throws IOException
     */
    private boolean is_flight_bought(String flight_id, RandomAccessFile ticketFile) throws IOException {
        for (int i = 0; i < Login.ticketCounter; i++) {
            if (!readString(i * TICKETLENGHT, ticketFile).equals(removed)) {
                if (readString(i * TICKETLENGHT + FIXSTRING, ticketFile).equals(flight_id))
                    return true;
            }
        }
        return false;
    }


}




