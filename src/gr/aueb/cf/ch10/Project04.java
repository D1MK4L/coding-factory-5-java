package gr.aueb.cf.ch10;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Project04 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cont = 1;
        int player = 1;
        int move = 0;
        String[] mark = {"_", "_", "_", "_", "_", "_"};
        String[] mark2 = {" ", " ", " "};
        String[] row1 = {"A1", "B1", "C1"};
        String[] row2 = {"A2", "B2", "C2"};
        String[] row3 = {"A3", "B3", "C3"};
        String[] flag = {"1"};
        boolean[] numbers = {false, false, false, false, false, false, false, false, false};
        themePrint(mark, mark2, row1, row2, row3);

        while (cont == 1) {
            System.out.printf("Player %s make a move: ", player);
            try {
                move = in.nextInt();
                if (move < 1 || move > 9) {
                    throw new InputMismatchException();
                }
                if (numbers[move-1]) throw new IllegalArgumentException();
                numbers[move-1] = true;
            } catch (InputMismatchException n) {
                System.out.println("Error: Invalid token! Only numbers from 1-9 and not Strings or Characters!");
                in.nextLine();
                continue;
            } catch (IllegalArgumentException e1) {
                System.out.println("The position has already been given");
                in.nextLine();
                continue;
            }
            movement(move, player, mark, mark2, row1, row2, row3);
            gameControl(mark,mark2,row1,row2,row3,flag);
            if (player==1 && numbers[move-1]){
                player=2;
            }else if (player==2 && numbers[move-1]){
                player=1;
            }
            themePrint(mark, mark2, row1, row2, row3);
            if (flag[0]=="0"){
                System.out.println(" ");
                System.out.print("Do you want to continue a new game(0 for N0 or 1 for Yes): ");
                cont = in.nextInt();
                if (cont==1) {
                    Arrays.fill(mark,"_");
                    Arrays.fill(mark2," ");
                    row1[0] = "A1";
                    row1[1] = "B1";
                    row1[2] = "C1";
                    row2[0] = "A2";
                    row2[1] = "B2";
                    row2[2] = "C2";
                    row3[0] = "A3";
                    row3[1] = "B3";
                    row3[2] = "C3";
                    flag[0] = "1";
                    Arrays.fill(numbers,false);
                    themePrint(mark, mark2, row1, row2, row3);
                }
            }
        }
    }


    public static void gameControl(String[] mark, String[] mark2, String[] row1,
                                   String[] row2, String[] row3,String[] flag){
        if((mark[0]=="X" && mark[1]=="X" && mark[2]=="X") ||
                (mark[3]=="X" && mark[4]=="X" && mark[5]=="X") ||
                (mark2[0]=="X" && mark2[1]=="X" && mark[2]=="X") ||
                (mark[0]=="X" && mark[3]=="X" && mark2[0]=="X") ||
                (mark[1]=="X" && mark[4]=="X" && mark2[1]=="X") ||
                (mark[2]=="X" && mark[5]=="X" && mark2[2]=="X") ||
                (mark[0]=="X" && mark[4]=="X" && mark2[2]=="X") ||
                (mark2[0]=="X" && mark[4]=="X" && mark[2]=="X")) {
            System.out.println("Game over, the Winner is player 1");
            flag[0] = "0";
        }else if (row1[0]=="  " && row2[0]=="  " && row3[0]==" "
                && row1[1]=="  " && row2[1]=="  " && row3[1]=="  "
                && row1[2]=="  " && row2[2]=="  " && row3[2]=="  ") {
            System.out.println("Its a tie!");
            flag[0]= "0";
        }
        if((mark[0]=="O" && mark[1]=="O" && mark[2]=="O") ||
                (mark[3]=="O" && mark[4]=="O" && mark[5]=="O") ||
                (mark2[0]=="O" && mark2[1]=="O" && mark[2]=="O") ||
                (mark[0]=="O" && mark[3]=="O" && mark2[0]=="O") ||
                (mark[1]=="O" && mark[4]=="O" && mark2[1]=="O") ||
                (mark[2]=="O" && mark[5]=="O" && mark2[2]=="O") ||
                (mark[0]=="O" && mark[4]=="O" && mark2[2]=="O") ||
                (mark2[0]=="O" && mark[4]=="O" && mark[2]=="O")) {
            System.out.println("Game over, the Winner is player 2");
            flag[0]= "0";
        } else if (row1[0]=="  " && row2[0]=="  " && row3[0]=="  "
                && row1[1]=="  " && row2[1]=="  " && row3[1]=="  "
                && row1[2]=="  " && row2[2]=="  " && row3[2]=="  ") {
            System.out.println("Its a tie!");
            flag[0]= "0";
        }
    }

    public static void movement(int move, int player, String[] mark, String[] mark2,
                                String[] row1, String[] row2, String[] row3) {
        switch (move) {
            case 0:
                break;
            case 1:
                if (player == 1) {
                    mark[0] = "X";
                    row1[0] = "  ";
                } else {
                    mark[0] = "O";
                    row1[0] = "  ";
                }
                break;
            case 2:
                if (player == 1) {
                    mark[1] = "X";
                    row1[1] = "  ";
                } else {
                    mark[1] = "O";
                    row1[1] = "  ";
                }
                break;
            case 3:
                if (player == 1) {
                    mark[2] = "X";
                    row1[2] = "  ";
                } else {
                    mark[2] = "O";
                    row1[2] = "  ";
                }
                break;
            case 4:
                if (player == 1) {
                    mark[3] = "X";
                    row2[0] = "  ";
                } else {
                    mark[3] = "O";
                    row2[0] = "  ";
                }
                break;
            case 5:
                if (player == 1) {
                    mark[4] = "X";
                    row2[1] = "  ";
                } else {
                    mark[4] = "O";
                    row2[1] = "  ";
                }
                break;
            case 6:
                if (player == 1) {
                    mark[5] = "X";
                    row2[2] = "  ";
                } else {
                    mark[5] = "O";
                    row2[2] = "  ";
                }
                break;
            case 7:
                if (player == 1) {
                    mark2[0] = "X";
                    row3[0] = "  ";
                } else {
                    mark2[0] = "O";
                    row3[0] = "  ";
                }
                break;
            case 8:
                if (player == 1) {
                    mark2[1] = "X";
                    row3[1] = "  ";
                } else {
                    mark2[1] = "O";
                    row3[1] = "  ";
                }
                break;
            case 9:
                if (player == 1) {
                    mark2[2] = "X";
                    row3[2] = "  ";
                } else {
                    mark2[2] = "O";
                    row3[2] = "  ";
                }
                break;
        }
    }

    public static void themePrint(String[] mark, String[] mark2, String[] row1,
                                  String[] row2, String[] row3) {
        char underScore = '_';
        char space = ' ';

        System.out.println("    Player1               A     B     C                Player2");
        System.out.printf("1.%s  2.%s  3.%s   ", row1[0], row1[1], row1[2]);
        System.out.printf("%6s_%s__", underScore, mark[0]);
        System.out.print("|");
        System.out.printf("%s_%s__", underScore, mark[1]);
        System.out.print("|");
        System.out.printf("%s_%s__   ", underScore, mark[2]);
        System.out.printf("1      1.%s  2.%s  3.%s   \n", row1[0], row1[1], row1[2]);
        System.out.printf("4.%s  5.%s  6.%s   ", row2[0], row2[1], row2[2]);
        System.out.printf("%6s_%s__", underScore, mark[3]);
        System.out.print("|");
        System.out.printf("%s_%s__", underScore, mark[4]);
        System.out.print("|");
        System.out.printf("%s_%s__   ", underScore, mark[5]);
        System.out.printf("2      4.%s  5.%s  6.%s   \n", row2[0], row2[1], row2[2]);
        System.out.printf("7.%s  8.%s  9.%s   ", row3[0], row3[1], row3[2]);
        System.out.printf("%6s %s  ", space, mark2[0]);
        System.out.print("|");
        System.out.printf("%s %s  ", space, mark2[1]);
        System.out.print("|");
        System.out.printf("%s %s     ", space, mark2[2]);
        System.out.printf("3      7.%s  8.%s  9.%s   \n", row3[0], row3[1], row3[2]);
        System.out.println();
    }
}
