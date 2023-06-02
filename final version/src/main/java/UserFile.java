import java.io.IOException;
import java.io.RandomAccessFile;


public class UserFile extends WorkWithFile {


    //******************************************** ----> regular user menu
    public void regular_user_menu(RandomAccessFile userFile, RandomAccessFile flightFile, RandomAccessFile ticketFile) throws IOException, InterruptedException {
        try {

            FlightFile flightFile_ins = new FlightFile();
            cls();
            System.out.println("\n\n\n\n\n\n\n\n\n\n");
            System.out.println("\t\t\t\t+ * * * * * * * * * * * * * * * * * * * * * * +");
            System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
            System.out.println("\t\t\t\t*               Passenger menu                *");
            System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
            System.out.println("\t\t\t\t*                                             *");
            System.out.println("\t\t\t\t*   1) Change password                        *");
            System.out.println("\t\t\t\t*   2) Search flight                          *");
            System.out.println("\t\t\t\t*   3) Show flights table                     *");
            System.out.println("\t\t\t\t*   4) Booking ticket                         *");
            System.out.println("\t\t\t\t*   5) Ticket cancellation                    *");
            System.out.println("\t\t\t\t*   6) Booked ticket                          *");
            System.out.println("\t\t\t\t*   7) Add charge                             *");
            System.out.println("\t\t\t\t*   0) Sign out                               *");
            System.out.println("\t\t\t\t*                                             *");
            System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
            System.out.println("\t\t\t\t+ * * * * * * * * * * * * * * * * * * * * * * +");
            int menu_mod = scanner.nextInt();
            switch (menu_mod) {
                case 1:
                    change_password(userFile, flightFile, ticketFile);
                case 2:
                    search_flight_menu(userFile, flightFile, ticketFile);
                case 3:
                    flightFile_ins.flight_table(0, userFile, flightFile, ticketFile);
                case 4:
                    booking_ticket(userFile, flightFile, ticketFile);
                case 5:
                    ticket_cancellation(userFile, flightFile, ticketFile);
                case 6:
                    booked_ticket(userFile, flightFile, ticketFile);
                case 7:
                    add_charge(userFile, flightFile, ticketFile);
                case 0:
                    Login login = new Login();
                    login.sign_menu(userFile, flightFile, ticketFile);
                default:
                    cls();
                    System.out.println("invalid input...\npress any key to return...");
                    scanner.next();
                    regular_user_menu(userFile, flightFile, ticketFile);
            }


        } catch (Exception var10) {
            error();
            regular_user_menu(userFile , flightFile ,ticketFile);
        }
    }


    //******************************************** ----> change password
    private void change_password(RandomAccessFile userFile, RandomAccessFile flightFile, RandomAccessFile ticketFile) throws IOException, InterruptedException {
        try {

            cls();
            System.out.println("\n\n\n\n\n\n\n\n\n\n");
            System.out.println("\t\t\t\t+ * * * * * * * * * * * * * * * * * * * * * * +");
            System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
            System.out.println("\t\t\t\t*               Change password               *");
            System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
            System.out.println("\t\t\t\t*                                             *");
            System.out.println("\t\t\t\t*                                             *");
            System.out.println("\t\t\t\t*      PLease enter your last password :      *");
            System.out.println("\t\t\t\t*                                             *");
            System.out.println("\t\t\t\t*                                             *");
            System.out.println("\t\t\t\t*         [ press + to turn back ]            *");
            System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
            System.out.println("\t\t\t\t+ * * * * * * * * * * * * * * * * * * * * * * +");
            String last_pass = scanner.next();
            if (last_pass.equals("+")) {
                regular_user_menu(userFile, flightFile, ticketFile);
            }

            if (!password_checker(last_pass, userFile, flightFile, ticketFile)) {
                cls();
                System.out.println("\n\n\n\n\n\n\n\n\n\n");
                System.out.println("\t\t\t\t+ * * * * * * * * * * * * * * * * * * * * * * +");
                System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
                System.out.println("\t\t\t\t*               Change password               *");
                System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
                System.out.println("\t\t\t\t*                                             *");
                System.out.println("\t\t\t\t*                                             *");
                System.out.println("\t\t\t\t*            Wrong password !                 *");
                System.out.println("\t\t\t\t*                                             *");
                System.out.println("\t\t\t\t*                                             *");
                System.out.println("\t\t\t\t*        press any key to try again ...       *");
                System.out.println("\t\t\t\t*                                             *");
                System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
                System.out.println("\t\t\t\t+ * * * * * * * * * * * * * * * * * * * * * * +");
                scanner.next();
                change_password(userFile, flightFile, ticketFile);
            }

            while (true) {
                cls();
                System.out.println("\n\n\n\n\n\n\n\n\n\n");
                System.out.println("\t\t\t\t+ * * * * * * * * * * * * * * * * * * * * * * +");
                System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
                System.out.println("\t\t\t\t*               Change password               *");
                System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
                System.out.println("\t\t\t\t*                                             *");
                System.out.println("\t\t\t\t*                                             *");
                System.out.println("\t\t\t\t*        PLease enter new password :          *");
                System.out.println("\t\t\t\t*                                             *");
                System.out.println("\t\t\t\t*                                             *");
                System.out.println("\t\t\t\t*         [ press + to turn back ]            *");
                System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
                System.out.println("\t\t\t\t+ * * * * * * * * * * * * * * * * * * * * * * +");
                String new_password = scanner.next();
                if (new_password.equals("+")) {
                    regular_user_menu(userFile, flightFile, ticketFile);
                }

                if (!new_password.equals(readString(Login.logged_in_index * USERLENGHT + FIXSTRING, userFile))) {
                    writeString((long) Login.logged_in_index * USERLENGHT + FIXSTRING, new_password, userFile);
                    print_done();
                    regular_user_menu(userFile, flightFile, ticketFile);
                    break;
                }

                cls();
                System.out.println("\n\n\n\n\n\n\n\n\n\n");
                System.out.println("\t\t\t\t+ * * * * * * * * * * * * * * * * * * * * * * +");
                System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
                System.out.println("\t\t\t\t*               Change password               *");
                System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
                System.out.println("\t\t\t\t*                                             *");
                System.out.println("\t\t\t\t*                                             *");
                System.out.println("\t\t\t\t*            password is used!                *");
                System.out.println("\t\t\t\t*             enter a new one                 *");
                System.out.println("\t\t\t\t*                                             *");
                System.out.println("\t\t\t\t*                                             *");
                System.out.println("\t\t\t\t*          Press any key to return...         *");
                System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
                System.out.println("\t\t\t\t+ * * * * * * * * * * * * * * * * * * * * * * +");
                scanner.next();
            }


        } catch (Exception var10) {
            error();
            change_password(userFile ,flightFile ,ticketFile);
        }
    }


    //******************************************** ----> search menu 1
    private void search_flight_menu(RandomAccessFile userFile, RandomAccessFile flightFile, RandomAccessFile ticketFile) throws IOException, InterruptedException {
        try {


            cls();
            System.out.println("\n\n\n\n\n\n\n\n\n\n");
            System.out.println("\t\t\t\t+ * * * * * * * * * * * * * * * * * * * * * * +");
            System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
            System.out.println("\t\t\t\t*               Search flight                 *");
            System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
            System.out.println("\t\t\t\t*                                             *");
            System.out.println("\t\t\t\t*    Filter by :                              *");
            System.out.println("\t\t\t\t*                                             *");
            System.out.println("\t\t\t\t*    1) Flight id                             *");
            System.out.println("\t\t\t\t*    2) Origin                                *");
            System.out.println("\t\t\t\t*    3) Destination                           *");
            System.out.println("\t\t\t\t*    4) Date                                  *");
            System.out.println("\t\t\t\t*    5) Time                                  *");
            System.out.println("\t\t\t\t*    6) Price                                 *");
            System.out.println("\t\t\t\t*    7) Seats                                 *");
            System.out.println("\t\t\t\t*    0) Exit                                  *");
            System.out.println("\t\t\t\t*                                             *");
            System.out.println("\t\t\t\t*                                             *");
            System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
            System.out.println("\t\t\t\t+ * * * * * * * * * * * * * * * * * * * * * * +\n\n");
            int search_mod = scanner.nextInt();
            switch (search_mod) {
                case 0:
                    regular_user_menu(userFile, flightFile, ticketFile);
                    break;
                case 1:
                    filter_by_id(userFile, flightFile, ticketFile);
                    break;
                case 2:
                    filter_by_origin(userFile, flightFile, ticketFile);
                    break;
                case 3:
                    filter_by_dest(userFile, flightFile, ticketFile);
                    break;
                case 4:
                    filter_by_date(userFile, flightFile, ticketFile);
                    break;
                case 5:
                    filter_by_time(userFile, flightFile, ticketFile);
                    break;
                case 6:
                    filter_by_price(userFile, flightFile, ticketFile);
                    break;
                case 7:
                    filter_by_seats(userFile, flightFile, ticketFile);
            }
            search_flight_menu(userFile, flightFile, ticketFile);


        } catch (Exception var10) {
            error();
            search_flight_menu(userFile , flightFile ,ticketFile);
        }
    }


    //******************************************** ----> print search box
    void print_search_box() throws IOException, InterruptedException {
        cls();
        System.out.println("\n\n\n\n\n\n\n\n\n\n");
        System.out.println("\t\t\t\t+ * * * * * * * * * * * * * * * * * * * * * * * +");
        System.out.println("\t\t\t\t* ::::::::::::::::::::::::::::::::::::::::::::: *");
        System.out.println("\t\t\t\t*               Search flight                   *");
        System.out.println("\t\t\t\t* ::::::::::::::::::::::::::::::::::::::::::::: *");
        System.out.println("\t\t\t\t*                                               *");
        System.out.println("\t\t\t\t*                                               *");
        System.out.println("\t\t\t\t*  PLease enter what you want to filter by :    *");
        System.out.println("\t\t\t\t*                                               *");
        System.out.println("\t\t\t\t*                                               *");
        System.out.println("\t\t\t\t*         [ press + to turn back ]              *");
        System.out.println("\t\t\t\t* ::::::::::::::::::::::::::::::::::::::::::::: *");
        System.out.println("\t\t\t\t+ * * * * * * * * * * * * * * * * * * * * * * * +");
    }


    //******************************************** ----> print table header
    static void table_head_printer() throws IOException, InterruptedException {
        cls();
        System.out.print("\n\n\n\n\n\n\t\t");
        System.out.print("+---------------------------------------------------------------------------------------------+");
        System.out.printf("\n\t\t| %-1s| %-1s|%-1s| %-1s| %-1s| %-1s| %-1s|", "  Flight ID  ", "   Origins   ", "  Destination  ", "    Data    ", "   Time   ", "   Price   ", " Seats ");
        System.out.print("\n\t\t");
        System.out.print("+---------------------------------------------------------------------------------------------+");
    }


    //******************************************** ----> filter by id
    void filter_by_id(RandomAccessFile userFile, RandomAccessFile flightFile, RandomAccessFile ticketFile) throws IOException, InterruptedException {
        try {


            cls();
            print_search_box();
            boolean null_flag = true;

            String filter = scanner.next().toUpperCase();

            if (filter.equals("+"))
                regular_user_menu(userFile, flightFile, ticketFile);


            table_head_printer();

            for (int i = 0; i < Login.flightCounter; ++i) {
                if (filter.equals(readString(i * USERLENGHT, flightFile))) {
                    null_flag = false;
                    System.out.print("\n\t\t");
                    System.out.printf("|    %-10s|    %-10s|    %-11s| %-12s|  %-9s|  %-10s|  %-4s  ", readString(i * FLIGHTLENGHT, flightFile), readString(i * FLIGHTLENGHT + FIXSTRING, flightFile), readString(i * FLIGHTLENGHT + 80, flightFile), readString(i * FLIGHTLENGHT + 120, flightFile), readString(i * FLIGHTLENGHT + 160, flightFile), flightFile.readLong(), flightFile.readInt());
                    System.out.printf("|");
                    System.out.print("\n\t\t");
                    System.out.print("+---------------------------------------------------------------------------------------------+");
                }
            }

            if (null_flag) {
                System.out.println("\n\t\t\t\t\t\t\t Nothing found !");
            }

            System.out.println("\n\n\n press any key to return ...");
            scanner.next();


        } catch (Exception var10) {
            error();
            search_flight_menu(userFile ,flightFile ,ticketFile);
        }
    }


    //******************************************** ----> filter by origin
    void filter_by_origin(RandomAccessFile userFile, RandomAccessFile flightFile, RandomAccessFile ticketFile) throws IOException, InterruptedException {
        try {


            cls();
            print_search_box();
            boolean null_flag = true;
            String filter = scanner.next().toUpperCase();
            if (filter.equals("+")) {
                regular_user_menu(userFile, flightFile, ticketFile);
            }

            table_head_printer();

            for (int i = 0; (long) i < Login.flightCounter; ++i) {
                if (filter.equals(readString(i * FLIGHTLENGHT + FIXSTRING, flightFile))) {
                    null_flag = false;
                    System.out.print("\n\t\t");
                    System.out.printf("|    %-10s|    %-10s|    %-11s| %-12s|  %-9s|  %-10s|  %-4s  ", readString(i * FLIGHTLENGHT, flightFile), readString(i * FLIGHTLENGHT + FIXSTRING, flightFile), readString(i * FLIGHTLENGHT + 80, flightFile), readString(i * FLIGHTLENGHT + 120, flightFile), readString(i * FLIGHTLENGHT + 160, flightFile), flightFile.readLong(), flightFile.readInt());
                    System.out.printf("|");
                    System.out.print("\n\t\t");
                    System.out.print("+---------------------------------------------------------------------------------------------+");
                }
            }

            if (null_flag) {
                System.out.println("\n\t\t\t\t\t\t\t Nothing found !");
            }

            System.out.println("\n\n\n press any key to return ...");
            scanner.next();


        } catch (Exception var10) {
            error();
            search_flight_menu(userFile ,flightFile ,ticketFile);

        }
    }


    //******************************************** ----> filter by destination
    void filter_by_dest(RandomAccessFile userFile, RandomAccessFile flightFile, RandomAccessFile ticketFile) throws IOException, InterruptedException {
        try {


            cls();
            print_search_box();
            boolean null_flag = true;
            String filter = scanner.next().toUpperCase();
            if (filter.equals("+")) {
                regular_user_menu(userFile, flightFile, ticketFile);
            }

            table_head_printer();

            for (int i = 0; (long) i < Login.flightCounter; ++i) {
                if (filter.equals(readString(i * FLIGHTLENGHT + 2 * FIXSTRING, flightFile))) {
                    null_flag = false;
                    System.out.print("\n\t\t");
                    System.out.printf("|    %-10s|    %-10s|    %-11s| %-12s|  %-9s|  %-10s|  %-4s  ", readString(i * FLIGHTLENGHT, flightFile), readString(i * FLIGHTLENGHT + FIXSTRING, flightFile), readString(i * FLIGHTLENGHT + 80, flightFile), readString(i * FLIGHTLENGHT + 120, flightFile), readString(i * FLIGHTLENGHT + 160, flightFile), flightFile.readLong(), flightFile.readInt());
                    System.out.printf("|");
                    System.out.print("\n\t\t");
                    System.out.print("+---------------------------------------------------------------------------------------------+");
                }
            }

            if (null_flag) {
                System.out.println("\n\t\t\t\t\t\t\t Nothing found !");
            }

            System.out.println("\n\n\n press any key to return ...");
            scanner.next();


        } catch (Exception var10) {
            error();
            search_flight_menu(userFile ,flightFile ,ticketFile);

        }
    }


    //******************************************** ----> filter by date
    void filter_by_date(RandomAccessFile userFile, RandomAccessFile flightFile, RandomAccessFile ticketFile) throws IOException, InterruptedException {
        try {


            cls();
            print_search_box();
            boolean null_flag = true;
            String filter = scanner.next();
            if (filter.equals("+")) {
                regular_user_menu(userFile, flightFile, ticketFile);
            }

            table_head_printer();

            for (int i = 0; (long) i < Login.flightCounter; ++i) {
                if (filter.equals(readString(i * FLIGHTLENGHT + 3 * FIXSTRING, flightFile))) {
                    null_flag = false;
                    System.out.print("\n\t\t");
                    System.out.printf("|    %-10s|    %-10s|    %-11s| %-12s|  %-9s|  %-10s|  %-4s  ", readString(i * FLIGHTLENGHT, flightFile), readString(i * FLIGHTLENGHT + FIXSTRING, flightFile), readString(i * FLIGHTLENGHT + 80, flightFile), readString(i * FLIGHTLENGHT + 120, flightFile), readString(i * FLIGHTLENGHT + 160, flightFile), flightFile.readLong(), flightFile.readInt());
                    System.out.printf("|");
                    System.out.print("\n\t\t");
                    System.out.print("+---------------------------------------------------------------------------------------------+");
                }
            }

            if (null_flag) {
                System.out.println("\n\t\t\t\t\t\t\t Nothing found !");
            }

            System.out.println("\n\n\n press any key to return ...");
            scanner.next();


        } catch (Exception var10) {
            error();
            search_flight_menu(userFile ,flightFile ,ticketFile);

        }
    }


    //******************************************** ----> filter by time
    void filter_by_time(RandomAccessFile userFile, RandomAccessFile flightFile, RandomAccessFile ticketFile) throws IOException, InterruptedException {
        try {


            cls();
            print_search_box();
            boolean null_flag = true;
            String filter = scanner.next();
            if (filter.equals("+")) {
                regular_user_menu(userFile, flightFile, ticketFile);
            }

            table_head_printer();

            for (int i = 0; (long) i < Login.flightCounter; ++i) {
                if (filter.equals(readString(i * FLIGHTLENGHT + 4 * FIXSTRING, flightFile))) {
                    null_flag = false;
                    System.out.print("\n\t\t");
                    System.out.printf("|    %-10s|    %-10s|    %-11s| %-12s|  %-9s|  %-10s|  %-4s  ", readString(i * FLIGHTLENGHT, flightFile), readString(i * FLIGHTLENGHT + FIXSTRING, flightFile), readString(i * FLIGHTLENGHT + 80, flightFile), readString(i * FLIGHTLENGHT + 120, flightFile), readString(i * FLIGHTLENGHT + 160, flightFile), flightFile.readLong(), flightFile.readInt());
                    System.out.printf("|");
                    System.out.print("\n\t\t");
                    System.out.print("+---------------------------------------------------------------------------------------------+");
                }
            }

            if (null_flag) {
                System.out.println("\n\t\t\t\t\t\t\t Nothing found !");
            }

            System.out.println("\n\n\n press any key to return ...");
            scanner.next();

        } catch (Exception var10) {
            error();
            search_flight_menu(userFile ,flightFile ,ticketFile);

        }
    }


    //******************************************** ----> filter by price
    void filter_by_price(RandomAccessFile userFile, RandomAccessFile flightFile, RandomAccessFile ticketFile) throws IOException, InterruptedException {
        try {


            cls();
            boolean null_flag = true;
            long temp;
            price_search_box(userFile, flightFile, ticketFile);

            System.out.print("\n\t\t\t\tmin ---> ");
            String min = scanner.next();

            if (min.equals("+")) {
                regular_user_menu(userFile, flightFile, ticketFile);
            }

            int min_filter = Integer.valueOf(min);
            System.out.print("\t\t\t\tmax ---> ");
            int max = scanner.nextInt();
            table_head_printer();

            for (int i = 0; i < Login.flightCounter; ++i) {
                flightFile.seek(i * FLIGHTLENGHT + 5 * FIXSTRING);
                temp = flightFile.readLong();

                if (min_filter < temp && max > temp) {
                    null_flag = false;
                    System.out.print("\n\t\t");
                    System.out.printf("|    %-10s|    %-10s|    %-11s| %-12s|  %-9s|  %-10s|  %-4s  ", readString(i * FLIGHTLENGHT, flightFile), readString(i * FLIGHTLENGHT + FIXSTRING, flightFile), readString(i * FLIGHTLENGHT + 80, flightFile), readString(i * FLIGHTLENGHT + 120, flightFile), readString(i * FLIGHTLENGHT + 160, flightFile), flightFile.readLong(), flightFile.readInt());
                    System.out.printf("|");
                    System.out.print("\n\t\t");
                    System.out.print("+---------------------------------------------------------------------------------------------+");
                }
            }

            if (null_flag) {
                System.out.println("\n\t\t\t\t\t\t\t Nothing found !");
            }

            System.out.println("\n\n\n press any key to return ...");
            scanner.next();


        } catch (Exception var10) {
            error();
            search_flight_menu(userFile ,flightFile ,ticketFile);

        }
    }


    //******************************************** ----> filter by search box
    void price_search_box(RandomAccessFile userFile, RandomAccessFile flightFile, RandomAccessFile ticketFile) throws IOException, InterruptedException {


        cls();
        System.out.println("\n\n\n\n\n\n\n\n\n\n");
        System.out.println("\t\t\t\t+ * * * * * * * * * * * * * * * * * * * * * * *  +");
        System.out.println("\t\t\t\t* :::::::::::::::::::::::::::::::::::::::::::::: *");
        System.out.println("\t\t\t\t*               Search flight                    *");
        System.out.println("\t\t\t\t* :::::::::::::::::::::::::::::::::::::::::::::: *");
        System.out.println("\t\t\t\t*                                                *");
        System.out.println("\t\t\t\t*                                                *");
        System.out.println("\t\t\t\t*  PLease enter price range want to filter by :  *");
        System.out.println("\t\t\t\t*                                                *");
        System.out.println("\t\t\t\t*                                                *");
        System.out.println("\t\t\t\t*           [ press + to turn back ]             *");
        System.out.println("\t\t\t\t* :::::::::::::::::::::::::::::::::::::::::::::: *");
        System.out.println("\t\t\t\t+ * * * * * * * * * * * * * * * * * * * * * * *  +");


    }


    //******************************************** ----> filter by seats
    void filter_by_seats(RandomAccessFile userFile, RandomAccessFile flightFile, RandomAccessFile ticketFile) throws IOException, InterruptedException {

        try {

            cls();
            boolean null_flag = true;
            print_search_box();

            String filteer = scanner.next();
            if (filteer.equals("+"))
                regular_user_menu(userFile, flightFile, ticketFile);


            int filter = Integer.valueOf(filteer);
            table_head_printer();

            for (int i = 0; i < Login.flightCounter; ++i) {
                flightFile.seek(i * FLIGHTLENGHT + 5 * FIXSTRING + 8);
                if (filter < flightFile.readInt()) {
                    null_flag = false;
                    System.out.print("\n\t\t");
                    System.out.printf("|    %-10s|    %-10s|    %-11s| %-12s|  %-9s|  %-10s|  %-4s  ", readString(i * FLIGHTLENGHT, flightFile), readString(i * FLIGHTLENGHT + FIXSTRING, flightFile), readString(i * FLIGHTLENGHT + 80, flightFile), readString(i * FLIGHTLENGHT + 120, flightFile), readString(i * FLIGHTLENGHT + 160, flightFile), flightFile.readLong(), flightFile.readInt());
                    System.out.printf("|");
                    System.out.print("\n\t\t");
                    System.out.print("+---------------------------------------------------------------------------------------------+");

                }
            }

            if (null_flag) {
                System.out.println("\n\t\t\t\t\t\t\t Nothing found !");
            }

            System.out.println("\n\n\n press any key to return ...");
            scanner.next();


        } catch (Exception var10) {
            error();
            search_flight_menu(userFile ,flightFile ,ticketFile);

        }
    }


    //******************************************** ----> booking
    private void booking_ticket(RandomAccessFile userFile, RandomAccessFile flightFile, RandomAccessFile ticketFile) throws IOException, InterruptedException {
        try {
            boolean addFlag = false;

            long index;
            FlightFile flightFile_ins = new FlightFile();
            cls();
            System.out.println("\n\n\n\n\n\n\n\n\n\n");
            System.out.println("\t\t\t\t+ * * * * * * * * * * * * * * * * * * * * * * +");
            System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
            System.out.println("\t\t\t\t*               Booking ticket                *");
            System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
            System.out.println("\t\t\t\t*                                             *");
            System.out.println("\t\t\t\t*                                             *");
            System.out.println("\t\t\t\t*           Please enter flight id :          *");
            System.out.println("\t\t\t\t*                                             *");
            System.out.println("\t\t\t\t*                                             *");
            System.out.println("\t\t\t\t*         [ press + to turn back ]            *");
            System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
            System.out.println("\t\t\t\t+ * * * * * * * * * * * * * * * * * * * * * * +");
            String flight_id = scanner.next();

            if (flight_id.equals("+"))
                regular_user_menu(userFile, flightFile, ticketFile);

            flight_id = flight_id.substring(0, 2).toUpperCase() + flight_id.substring(2, flight_id.length());
            int flight_index = flightFile_ins.if_flight_exist(flight_id, flightFile);

            // flight existence
            if (flight_index == -1) {
                cls();
                System.out.println("\n\n\n\n\n\n\n\n\n\n");
                System.out.println("\t\t\t\t+ * * * * * * * * * * * * * * * * * * * * * * +");
                System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
                System.out.println("\t\t\t\t*               Booking ticket                *");
                System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
                System.out.println("\t\t\t\t*                                             *");
                System.out.println("\t\t\t\t*                                             *");
                System.out.println("\t\t\t\t*           Flight does not exist!            *");
                System.out.println("\t\t\t\t*                                             *");
                System.out.println("\t\t\t\t*                                             *");
                System.out.println("\t\t\t\t*           press any key to return ...       *");
                System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
                System.out.println("\t\t\t\t+ * * * * * * * * * * * * * * * * * * * * * * +");
                scanner.next();
                booking_ticket(userFile, flightFile, ticketFile);
            }

            // enough seats
            flightFile.seek(flight_index * FLIGHTLENGHT + 5 * FIXSTRING + 8);
            if (flightFile.readInt() == 0) {
                cls();
                System.out.println("\n\n\n\n\n\n\n\n\n\n");
                System.out.println("\t\t\t\t+ * * * * * * * * * * * * * * * * * * * * * * +");
                System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
                System.out.println("\t\t\t\t*               Booking ticket                *");
                System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
                System.out.println("\t\t\t\t*                                             *");
                System.out.println("\t\t\t\t*                                             *");
                System.out.println("\t\t\t\t*             All seats are sold !             *");
                System.out.println("\t\t\t\t*                                             *");
                System.out.println("\t\t\t\t*                                             *");
                System.out.println("\t\t\t\t*          press any key to return ...        *");
                System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
                System.out.println("\t\t\t\t+ * * * * * * * * * * * * * * * * * * * * * * +");
                scanner.next();
                regular_user_menu(userFile, flightFile, ticketFile);
            }

            // enough wallet
            if (is_wallet_enough(flight_index, userFile, flightFile, ticketFile) == false) {
                cls();
                System.out.println("\n\n\n\n\n\n\n\n\n\n");
                System.out.println("\t\t\t\t+ * * * * * * * * * * * * * * * * * * * * * * +");
                System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
                System.out.println("\t\t\t\t*               Booking ticket                *");
                System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
                System.out.println("\t\t\t\t*                                             *");
                System.out.println("\t\t\t\t*                                             *");
                System.out.println("\t\t\t\t*          your wallet isn't enough !         *");
                System.out.println("\t\t\t\t*            charge your wallet !             *");
                System.out.println("\t\t\t\t*                                             *");
                System.out.println("\t\t\t\t*           press any key to return ...       *");
                System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
                System.out.println("\t\t\t\t+ * * * * * * * * * * * * * * * * * * * * * * +");
                scanner.next();
                regular_user_menu(userFile, flightFile, ticketFile);
            }

            //is flight  full
            if (is_flight_full(flight_index, userFile, flightFile, ticketFile)) {
                cls();
                System.out.println("\n\n\n\n\n\n\n\n\n\n");
                System.out.println("\t\t\t\t+ * * * * * * * * * * * * * * * * * * * * * * +");
                System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
                System.out.println("\t\t\t\t*               Booking ticket                *");
                System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
                System.out.println("\t\t\t\t*                                             *");
                System.out.println("\t\t\t\t*                                             *");
                System.out.println("\t\t\t\t*             flight is full !                *");
                System.out.println("\t\t\t\t*                                             *");
                System.out.println("\t\t\t\t*                                             *");
                System.out.println("\t\t\t\t*          press any key to return ...        *");
                System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
                System.out.println("\t\t\t\t+ * * * * * * * * * * * * * * * * * * * * * * +");
                scanner.next();
                regular_user_menu(userFile, flightFile, ticketFile);
            }

            if (firstEmpty(ticketFile, Login.ticketCounter, 3 * FIXSTRING) == -1) {
                index = ticketFile.length();
                addFlag = true;
            } else
                index = (long) firstEmpty(ticketFile, Login.ticketCounter, 3 * FIXSTRING) * TICKETLENGHT;


            // write ticket id
            String str = String.valueOf(159100 + Ticket.ticket_id_generator_counter);
            writeString(index, str, ticketFile);
            Ticket.ticket_id_generator_counter++;


            // write flight id
            writeString(index + FIXSTRING, flight_id, ticketFile);


            // write user id
            writeString(index + 2 * FIXSTRING, readString(Login.logged_in_index * USERLENGHT, userFile), ticketFile);


            // change seats
            changeSeats(flight_index, false, flightFile);


            // change money
            flightFile.seek(flight_index * FLIGHTLENGHT + 5 * FIXSTRING);
            changeWallet(flightFile.readLong(), false, userFile);


            if (addFlag)
                Login.ticketCounter++;

            print_done();
            regular_user_menu(userFile, flightFile, ticketFile);


        } catch (Exception var10) {
            error();
            booking_ticket(userFile , flightFile ,ticketFile);
        }
    }


    //******************************************** ----> change wallet
    private void changeWallet(long price, boolean mode, RandomAccessFile userFile) throws IOException {

        userFile.seek((long) Login.logged_in_index * USERLENGHT + 2 * FIXSTRING);
        long wallet = userFile.readLong();

        if (mode)
            wallet += price;
        else
            wallet -= price;


        userFile.seek((long) Login.logged_in_index * USERLENGHT + 2 * FIXSTRING);
        userFile.writeLong(wallet);
    }


    //******************************************** ----> change seats
    private void changeSeats(long flightIndex, boolean mode, RandomAccessFile flightFile) throws IOException {
        flightFile.seek(flightIndex * FLIGHTLENGHT + 5 * FIXSTRING + 8);
        int seats = flightFile.readInt();
        if (mode)
            seats++;
        else
            seats--;

        flightFile.seek(flightIndex * FLIGHTLENGHT + 5 * FIXSTRING + 8);
        flightFile.writeInt(seats);
    }


    //******************************************** ----> cancellation
    private void ticket_cancellation(RandomAccessFile userFile, RandomAccessFile flightFile, RandomAccessFile ticketFile) throws IOException, InterruptedException {
        try {


            cls();
            System.out.println("\n\n\n\n\n\n\n\n\n\n");
            System.out.println("\t\t\t\t+ * * * * * * * * * * * * * * * * * * * * * * +");
            System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
            System.out.println("\t\t\t\t*            Ticket cancellation              *");
            System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
            System.out.println("\t\t\t\t*                                             *");
            System.out.println("\t\t\t\t*                                             *");
            System.out.println("\t\t\t\t*        Please enter your ticket id :        *");
            System.out.println("\t\t\t\t*                                             *");
            System.out.println("\t\t\t\t*                                             *");
            System.out.println("\t\t\t\t*          [ press + to turn back ]           *");
            System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
            System.out.println("\t\t\t\t+ * * * * * * * * * * * * * * * * * * * * * * +");
            String input = scanner.next();
            if (input.equals("+"))
                regular_user_menu(userFile, flightFile, ticketFile);


            int ticket_index = is_ticket_exist(input, userFile, flightFile, ticketFile);

            if (ticket_index == -1) {
                cls();
                System.out.println("\n\n\n\n\n\n\n\n\n\n");
                System.out.println("\t\t\t\t+ * * * * * * * * * * * * * * * * * * * * * * +");
                System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
                System.out.println("\t\t\t\t*            Ticket cancellation              *");
                System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
                System.out.println("\t\t\t\t*                                             *");
                System.out.println("\t\t\t\t*                                             *");
                System.out.println("\t\t\t\t*           Ticket does not exist!            *");
                System.out.println("\t\t\t\t*                                             *");
                System.out.println("\t\t\t\t*                                             *");
                System.out.println("\t\t\t\t*          Press any key to return...         *");
                System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
                System.out.println("\t\t\t\t+ * * * * * * * * * * * * * * * * * * * * * * +");
                scanner.next();
                ticket_cancellation(userFile, flightFile, ticketFile);
            }

            FlightFile flightIns = new FlightFile();
            String flightId = readString(ticket_index * TICKETLENGHT + FIXSTRING, ticketFile);

            // delete ticket
            writeString((long) ticket_index * TICKETLENGHT, removed, ticketFile);
            writeString((long) ticket_index * TICKETLENGHT + FIXSTRING, removed, ticketFile);
            writeString((long) ticket_index * TICKETLENGHT + 2 * FIXSTRING, removed, ticketFile);

            // Change seats
            int flightIndex = flightIns.if_flight_exist(flightId, flightFile);
            changeSeats(flightIndex, true, flightFile);

            // Change wallet
            flightFile.seek(((long) flightIndex * FLIGHTLENGHT + 5 * FIXSTRING));
            changeWallet(flightFile.readLong(), true, userFile);


            print_done();
            regular_user_menu(userFile, flightFile, ticketFile);

        } catch (Exception var10) {
            error();

            scanner.next();
            ticket_cancellation(userFile, flightFile, ticketFile);
        }
    }


    //******************************************** ----> is ticket exist
    private int is_ticket_exist(String ticket_id, RandomAccessFile userFile, RandomAccessFile flightFile, RandomAccessFile ticketFile) throws IOException, InterruptedException {
        try {


            for (int i = 0; i < Login.ticketCounter; ++i) {
                if (readString(i * TICKETLENGHT, ticketFile).equals(ticket_id)) {
                    return i;
                }
            }
        } catch (Exception var6) {
            error();
            ticket_cancellation(userFile ,flightFile ,ticketFile);
        }
        return -1;
    }


    //******************************************** ----> booked ticket
    private void booked_ticket(RandomAccessFile userFile, RandomAccessFile flightFile, RandomAccessFile ticketFile) throws IOException, InterruptedException {
        try {
            boolean searchFlag = false;
            cls();


            FlightFile flightFile1 = new FlightFile();


            System.out.print("\n\t\t");
            System.out.print("\n\n\n\n\n\n\t\t");
            System.out.print("+------------------------------------------------------------------------------------------------------------+");
            System.out.printf("\n\t\t| %-1s| %-1s| %-1s|%-1s| %-1s| %-1s| %-1s| %-1s|", "  Ticket ID  ", "  Flight ID  ", "   Origins   ", "  Destination  ", "    Data    ", "   Time   ", "   Price   ", " Seats ");
            System.out.print("\n\t\t");
            System.out.print("+------------------------------------------------------------------------------------------------------------+\n");

            for (int i = 0; i < Login.ticketCounter; ++i) {

                if (!readString(i * TICKETLENGHT, ticketFile).equals(removed)) {
                    if (readString(i * TICKETLENGHT + 2 * FIXSTRING, ticketFile).equals(readString(Login.logged_in_index * USERLENGHT, userFile))) {
                        searchFlag = true;
                        int flightIndex = flightFile1.if_flight_exist(readString(i * TICKETLENGHT + FIXSTRING, ticketFile), flightFile);
                        System.out.printf("\t\t|    %-6s    |    %-10s|    %-10s|    %-11s|  %-11s|    %-7s|   %-9s|   %-3s  ", readString(i * TICKETLENGHT, ticketFile), readString(flightIndex * FLIGHTLENGHT, flightFile), readString(flightIndex * FLIGHTLENGHT + FIXSTRING, flightFile), readString(flightIndex * FLIGHTLENGHT + 2 * FIXSTRING, flightFile), readString(flightIndex * FLIGHTLENGHT + 3 * FIXSTRING, flightFile), readString(flightIndex * FLIGHTLENGHT + 4 * FIXSTRING, flightFile), flightFile.readLong(), flightFile.readInt());
                        System.out.printf("|");
                        System.out.print("\n\t\t");
                        System.out.print("+------------------------------------------------------------------------------------------------------------+\n");
                    }
                }
            }

            if (!searchFlag) {
                System.out.println("\n\t\t\t\t\t\t\t Nothing found !");
            }


            System.out.println("\n\n\t\t\tpress any key to return ...");
            scanner.next();
            regular_user_menu(userFile, flightFile, ticketFile);
        } catch (Exception var10) {
            error();
            regular_user_menu(userFile ,flightFile ,ticketFile);
        }
    }


    //******************************************** ----> add charge
    private void add_charge(RandomAccessFile userFile, RandomAccessFile flightFile, RandomAccessFile ticketFile) throws IOException, InterruptedException {

        try {

            cls();
            userFile.seek((Login.logged_in_index * USERLENGHT + 2 * FIXSTRING));
            System.out.println("\n\n\n\n\n\n\n\n\n\n");
            System.out.println("\t\t\t\t+ * * * * * * * * * * * * * * * * * * * * * * +");
            System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
            System.out.println("\t\t\t\t*                 Add charge                  *");
            System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
            System.out.println("\t\t\t\t*                                             *");
            System.out.println("\t\t\t\t*                                             *");
            System.out.printf("\t\t\t\t* current vault is : %10s               *\n", userFile.readLong());
            System.out.println("\t\t\t\t*                                             *");
            System.out.println("\t\t\t\t*                                             *");
            System.out.println("\t\t\t\t*          Press any key to return...         *");
            System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
            System.out.println("\t\t\t\t+ * * * * * * * * * * * * * * * * * * * * * * +");
            scanner.next();
            cls();
            System.out.println("\n\n\n\n\n\n\n\n\n\n");
            System.out.println("\t\t\t\t+ * * * * * * * * * * * * * * * * * * * * * * +");
            System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
            System.out.println("\t\t\t\t*                 Add charge                  *");
            System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
            System.out.println("\t\t\t\t*                                             *");
            System.out.println("\t\t\t\t*                                             *");
            System.out.println("\t\t\t\t*  PLease enter how much you want to put :    *");
            System.out.println("\t\t\t\t*                                             *");
            System.out.println("\t\t\t\t*                                             *");
            System.out.println("\t\t\t\t*          [ press + to turn back ]           *");
            System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
            System.out.println("\t\t\t\t+ * * * * * * * * * * * * * * * * * * * * * * +");
            String input = scanner.next();
            if (input.equals("+")) {
                regular_user_menu(userFile, flightFile, ticketFile);
            }

            long amount = Long.valueOf(input);
            changeWallet(amount, true, userFile);
            userFile.seek((long) (Login.logged_in_index * USERLENGHT + 80));
            cls();
            System.out.println("\n\n\n\n\n\n\n\n\n\n");
            System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
            System.out.println("\t\t\t\t*                 Add charge                  *");
            System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
            System.out.println("\t\t\t\t*                                             *");
            System.out.println("\t\t\t\t*                                             *");
            System.out.printf("\t\t\t\t*           wallet is : %-10s            *\n", userFile.readLong());
            System.out.println("\t\t\t\t*                                             *");
            System.out.println("\t\t\t\t*                                             *");
            System.out.println("\t\t\t\t*         Press any key to return...          *");
            System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
            System.out.println("\t\t\t\t+ * * * * * * * * * * * * * * * * * * * * * * +");
            scanner.next();
            regular_user_menu(userFile, flightFile, ticketFile);
        } catch (Exception var10) {
            error();
            regular_user_menu(userFile ,flightFile ,ticketFile);
        }
    }


    //******************************************** ----> is flight full
    private boolean is_flight_full(int flight_index, RandomAccessFile userFile, RandomAccessFile flightFile, RandomAccessFile ticketFile) throws IOException, InterruptedException {
        try {


            flightFile.seek((long) (flight_index * FLIGHTLENGHT + 5 * FIXSTRING + 8));
            if (flightFile.readInt() != 0)
                return false;

        } catch (Exception var6) {
            error();
            is_flight_full(flight_index, userFile, flightFile, ticketFile);


        }

        return true;
    }




    //******************************************** ----> is wallet enough
    private boolean is_wallet_enough(int flight_index, RandomAccessFile userFile, RandomAccessFile flightFile, RandomAccessFile ticketFile) throws IOException, InterruptedException {
        try {


            userFile.seek((long) Login.logged_in_index * USERLENGHT + 2 * FIXSTRING);
            flightFile.seek((long) flight_index * FLIGHTLENGHT + 5 * FIXSTRING);
            long wallet = userFile.readLong();
            long price = flightFile.readLong();

            if (wallet >= price)
                return true;

        } catch (Exception var6)
        {
            error();
            is_wallet_enough(flight_index, userFile, flightFile, ticketFile);
        }
        return false;
    }



    //******************************************** ----> is user exist
    public int user_existence_checker(String username, RandomAccessFile userFile, RandomAccessFile flightFile, RandomAccessFile ticketFile) throws IOException, InterruptedException {


        for (int i = 0; (long) i < Login.userCounter; ++i) {
            String name = readString(i * USERLENGHT, userFile);
            if (username.equals(name)) {
                return i;
            }
        }


        return -1;

    }
    /**
     * Override
     */
    public boolean user_existence_checker(String username, String password, RandomAccessFile userFile, RandomAccessFile flightFile, RandomAccessFile ticketFile) throws IOException, InterruptedException {

            int index = user_existence_checker(username, userFile, flightFile, ticketFile);
            String pass = readString(index * USERLENGHT + FIXSTRING, userFile);
            if (index != -1 && password.equals(pass))
                return true;



        return false;
    }


    //******************************************** ----> password checker
    public boolean password_checker(String last_pass, RandomAccessFile userFile, RandomAccessFile flightFile, RandomAccessFile ticketFile) throws IOException, InterruptedException {



            if (last_pass.equals(readString(Login.logged_in_index * USERLENGHT + FIXSTRING, userFile))) {
                return true;
            }


        return false;
    }

}
