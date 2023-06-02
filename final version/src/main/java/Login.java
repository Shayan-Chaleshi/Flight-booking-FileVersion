import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Login extends WorkWithFile
{
    static int logged_in_index;

    static int userCounter  ;
    static int flightCounter;
    static int ticketCounter;

    UserFile file = new UserFile();

    //******************************************** ---->  welcome
     void welcome() throws IOException, InterruptedException
     {

        RandomAccessFile userFile   = new RandomAccessFile("out\\production\\main\\files\\userFile.super"    , "rw" );
        RandomAccessFile flightFile = new RandomAccessFile("out\\production\\main\\files\\flightFile.super" , "rw" );
        RandomAccessFile ticketFile = new RandomAccessFile("out\\production\\main\\files\\ticketFile.super" , "rw" );


         set_default_flights(flightFile);

         userCounter   = (int) (userFile.length()   / USERLENGHT);
         flightCounter = (int) (flightFile.length() / FLIGHTLENGHT );
         ticketCounter = (int) (ticketFile.length() / TICKETLENGHT );


        sign_menu( userFile , flightFile , ticketFile );
    }

    //******************************************** ---->  first menu

    public void sign_menu( RandomAccessFile userFile , RandomAccessFile flightFile , RandomAccessFile ticketFile ) throws IOException, InterruptedException {
        try
        {
            cls();
            int sign_mod;

            System.out.println("\n\n\n\n\n\n\n\n\n\n");
            System.out.println("\t\t\t\t+ * * * * * * * * * * * * * * * * * * * * * * +");
            System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
            System.out.println("\t\t\t\t*                 Welcome                     *");
            System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
            System.out.println("\t\t\t\t*                                             *");
            System.out.println("\t\t\t\t*  please choose a number                     *");
            System.out.println("\t\t\t\t*                                             *");
            System.out.println("\t\t\t\t*  1)sign up                                  *");
            System.out.println("\t\t\t\t*  2)sign in                                  *");
            System.out.println("\t\t\t\t*                                             *");
            System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
            System.out.println("\t\t\t\t+ * * * * * * * * * * * * * * * * * * * * * * +");

            sign_mod = scanner.nextInt();


            switch (sign_mod) {
                case 1:
                    sign_up(userFile, flightFile, ticketFile);
                    break;

                case 2:
                    sign_in(userFile, flightFile, ticketFile);
                    break;

                default:
                    cls();
                    System.out.println("invalid input...\npress any key to return...");
                    scanner.next();
                    sign_menu(userFile, flightFile, ticketFile);

            }


        }catch (Exception var6) {
            error();

            sign_menu(userFile ,flightFile ,ticketFile);
        }
    }



    //******************************************** ---->  sign in
    public void sign_in( RandomAccessFile userFile , RandomAccessFile flightFile , RandomAccessFile ticketFile ) throws IOException, InterruptedException {
        try {
            cls();
            System.out.println("\n\n\n\n\n\n\n\n\n\n");
            System.out.println("\t\t\t\t+ * * * * * * * * * * * * * * * * * * * * * * +");
            System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
            System.out.println("\t\t\t\t*                                             *");
            System.out.println("\t\t\t\t*   please enter your username and password   *");
            System.out.println("\t\t\t\t*                                             *");
            System.out.println("\t\t\t\t*  username:                                  *");
            System.out.println("\t\t\t\t*                                             *");
            System.out.println("\t\t\t\t*  password:                                  *");
            System.out.println("\t\t\t\t*                                             *");
            System.out.println("\t\t\t\t*                                             *");
            System.out.println("\t\t\t\t*         [ press + to turn back ]            *");
            System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
            System.out.println("\t\t\t\t+ * * * * * * * * * * * * * * * * * * * * * * +");
            String username;
            String password;

            username = scanner.next();
            if (username.equals("+"))
                sign_menu(userFile, flightFile, ticketFile);
            password = scanner.next();


            /**  Admin condition  **/
            if (username.toLowerCase().equals("admin") && password.toLowerCase().equals("admin")) {
                Admin admin1 = new Admin();
                admin1.admin_menu(userFile, flightFile, ticketFile);
            }

            /**invalid condition*/
            if (file.user_existence_checker(username, userFile, flightFile, ticketFile) == -1) {
                cls();
                System.out.println("\n\n\n\n\n\n\n\n\n\n");
                System.out.println("\t\t\t\t+ * * * * * * * * * * * * * * * * * * * * * * +");
                System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
                System.out.println("\t\t\t\t*                                             *");
                System.out.println("\t\t\t\t*            User does not exist              *");
                System.out.println("\t\t\t\t*                                             *");
                System.out.println("\t\t\t\t*            please try again...              *");
                System.out.println("\t\t\t\t*                                             *");
                System.out.println("\t\t\t\t*                                             *");
                System.out.println("\t\t\t\t*           press any key to return...        *");
                System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
                System.out.println("\t\t\t\t+ * * * * * * * * * * * * * * * * * * * * * * +");

                scanner.next();
                sign_in(userFile, flightFile, ticketFile);
            }

            /** Wrong password **/
            if (file.user_existence_checker(username, password, userFile, flightFile, ticketFile) == false) {
                cls();
                System.out.println("\n\n\n\n\n\n\n\n\n\n");
                System.out.println("\t\t\t\t+ * * * * * * * * * * * * * * * * * * * * * * +");
                System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
                System.out.println("\t\t\t\t*                                             *");
                System.out.println("\t\t\t\t*            incorrect password               *");
                System.out.println("\t\t\t\t*                                             *");
                System.out.println("\t\t\t\t*            please try again...              *");
                System.out.println("\t\t\t\t*                                             *");
                System.out.println("\t\t\t\t*                                             *");
                System.out.println("\t\t\t\t*         press any key to return...          *");
                System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
                System.out.println("\t\t\t\t+ * * * * * * * * * * * * * * * * * * * * * * +");
                scanner.next();
                sign_in(userFile, flightFile, ticketFile);
            }

            // save logging user index
            Login.logged_in_index = file.user_existence_checker(username, userFile, flightFile, ticketFile);


            file.regular_user_menu(userFile, flightFile, ticketFile);


        } catch (Exception var6) {
            error();
            sign_in(userFile ,flightFile , ticketFile);
        }
    }


    //******************************************** ---->  sign up
    public void sign_up( RandomAccessFile userFile , RandomAccessFile flightFile , RandomAccessFile ticketFile ) throws IOException, InterruptedException {
        try {
            long index;
            cls();
            System.out.println("\n\n\n\n\n\n\n\n\n\n");
            System.out.println("\t\t\t\t+ * * * * * * * * * * * * * * * * * * * * * * +");
            System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
            System.out.println("\t\t\t\t*                                             *");
            System.out.println("\t\t\t\t*   please choose username and password       *");
            System.out.println("\t\t\t\t*                                             *");
            System.out.println("\t\t\t\t*  username:                                  *");
            System.out.println("\t\t\t\t*                                             *");
            System.out.println("\t\t\t\t*  password:                                  *");
            System.out.println("\t\t\t\t*                                             *");
            System.out.println("\t\t\t\t*                                             *");
            System.out.println("\t\t\t\t*          [ press + to turn back ]           *");
            System.out.println("\t\t\t\t*:::::::::::::::::::::::::::::::::::::::::::: *");
            System.out.println("\t\t\t\t+ * * * * * * * * * * * * * * * * * * * * * * +");

            String username;

            String password;

            username = scanner.next();
            if (username.equals("+"))
                sign_menu(userFile, flightFile, ticketFile);
            password = scanner.next();


            if (file.user_existence_checker(username, userFile, flightFile, ticketFile) != -1 || username.toLowerCase().equals("admin") || password.toLowerCase().equals("admin")) {
                System.out.println("this username exist \n try another one...\npress any key to return...");
                scanner.next();
                sign_up(userFile, flightFile, ticketFile);
            }


            // find empty place to write
            if (firstEmpty(userFile, userCounter, USERLENGHT) == -1)
                index = userFile.length();
            else
                index = (long) firstEmpty(userFile, userCounter, USERLENGHT) * USERLENGHT;


            // creat new user
            writeString(index, username, userFile);
            writeString(index + FIXSTRING, password, userFile);
            userFile.writeLong(0);

            Login.userCounter++;

            print_done();
            sign_menu(userFile, flightFile, ticketFile);

        } catch (Exception var6) {
            error();
            sign_up(userFile ,flightFile , ticketFile);
        }
    }

    //******************************************** ---->  clear screen
    public static void cls() throws IOException, InterruptedException
    {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }



    //******************************************** ---->  default flights
     void set_default_flights(RandomAccessFile flightFile) throws IOException
     {
        writeString(0             , "WX-10"      , flightFile );
        writeString(1*FIXSTRING   , "YAZD"       , flightFile );
        writeString(2*FIXSTRING   , "TEHRAN"     , flightFile );
        writeString(3*FIXSTRING   , "1401-12-10" , flightFile );
        writeString(4*FIXSTRING   , "12:30"      , flightFile );
        flightFile.writeLong(700000);
        flightFile.writeInt(51);



        writeString(        FLIGHTLENGHT               , "WX-11"      , flightFile );
        writeString(FLIGHTLENGHT +   FIXSTRING , "YAZD"       , flightFile );
        writeString(FLIGHTLENGHT + 2*FIXSTRING , "SHIRAZ"     , flightFile );
        writeString(FLIGHTLENGHT + 3*FIXSTRING , "1401-12-8"  , flightFile );
        writeString(FLIGHTLENGHT + 4*FIXSTRING , "8:30"       , flightFile);
        flightFile.writeLong(400000);
        flightFile.writeInt(72);



        writeString(2*FLIGHTLENGHT                 , "WX-12"      , flightFile );
        writeString(2*FLIGHTLENGHT  +   FIXSTRING  , "YAZD"       , flightFile );
        writeString(2*FLIGHTLENGHT  + 2*FIXSTRING  , "MASHHAD"    , flightFile );
        writeString(2*FLIGHTLENGHT  + 3*FIXSTRING  , "1401-12-8"  , flightFile );
        writeString(2*FLIGHTLENGHT  + 4*FIXSTRING  , "17:45"      , flightFile );
        flightFile.writeLong(800000);
        flightFile.writeInt(60);

    }





    }



