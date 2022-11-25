import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Project3{
    
    //Global Variables
    static int target, row, col;
    static int table[][];

    public static void main(String args[]) throws FileNotFoundException{
        //Input File taking the data from
        File text = new File("input.txt");
        scan(text);
        printTable();
    }

    //Recursive algorithm that searches for a target value in a 2d array.
    public static void bisectionalSearch(int table[][], int t){
        
    }


    //Scans the input file and adds Data to variables
    public static void scan(File input) throws FileNotFoundException{
        Scanner in = new Scanner(input);
        //Getting Size of table
        row = in.nextInt();
        col = in.nextInt();
        pVar(row);
        pVar(col);
        target = in.nextInt();
        table = new int[row][col];

        //adding data to table
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                table[i][j] = in.nextInt();
            }
        }
    }

    public static void printTable(){
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void pVar(int var){
        System.out.println(var);
    }
}