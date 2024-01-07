package gr.aueb.cf.ch1;

/**
 *  Prints the Initial capital letters of my name.
 *
 * @author D1MK4L
 */
public class InitialsApp {

    public static void main(String[] args) {
        //first attempt
        System.out.println("*" + "       " + "*" + "            "+ "*"+"\n"
                        +  "*" + "     " + "*" + "             "+ "* *"+"\n"
                        +  "*" + "   " + "*" + "              "+ "*   *"+"\n"
                        +  "*" + " " + "*" + "               "+ "*     *"+"\n"
                        +  "*" + "   " + "*" + "            "+ "*       *"+"\n"
                        +  "*" + "     " + "*" + "         "+ "*         *"+"\n"
                        +  "*" + "       "+ "*" + "      " + "* * * * * * *"+"\n");

        //second attempt
        String symbol="*";
        System.out.printf("%1$s %1$7s %1$12s"+"\n",symbol);
        System.out.printf("%1$s %1$5s %1$13s %1$1s"+"\n",symbol);
        System.out.printf("%1$s %1$3s %1$14s %1$3s"+"\n",symbol);
        System.out.printf("%1$s %1$1s %1$15s %1$5s"+"\n",symbol);
        System.out.printf("%1$s %1$3s %1$12s %1$7s"+"\n",symbol);
        System.out.printf("%1$s %1$5s %1$9s %1$9s"+"\n",symbol);
        System.out.printf("%1$s %1$7s %1$6s %1$2s %1$2s %1$2s %1$2s "+"\n",symbol);

    }

}
