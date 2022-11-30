//Name: Edwin Argueta
//Class: Comp 482 Algorithm Design
//Assignment: Project 3

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Project3{
    
    //Global Variables
    static int table[][], target, colLow, rowLow, colHigh, rowHigh;
    static boolean found = false;

    public static void main(String args[]) throws FileNotFoundException{
        //Input File taking the data from
        File text = new File("input.txt");
        scan(text);
        printTable();

        //Offsetting to fit coordinates for Array.
        colHigh -= 1;
        rowHigh -= 1;

        //Performing BisectionalSearch on matrix
        bisectionalSearch(colLow, rowLow, colHigh, rowHigh);

        //if the value is not found then give a not found message to the console.
        if(found == false){
            System.out.println("\nValue was not found.");
        }
    }

    //Recursive algorithm that searches for a target value in a 2d array.
    public static void bisectionalSearch(int colL, int rowL, int colH, int rowH){

        //Finds the middle value
        int colMiddle =  (colL + colH)/2;
        int rowMiddle = (rowH + rowL)/2;
        int middle = table[rowMiddle][colMiddle];

        //Only runs if the number is not found and if it is in bounds of search area.
        if(found == false && !(colL > colH || rowH < rowL)){
            //Compares the middle with the target value
            if(middle == target){
                System.out.println("\nValue was found at: (" + (colMiddle + 1) + ", " + (rowMiddle + 1) + ")");
                found = true;
            }else if(target < middle){ //bottomRight removed
                bisectionalSearch(colMiddle, rowL, colH, rowMiddle - 1); //topRight
                bisectionalSearch(colL, rowL, colMiddle - 1, rowMiddle - 1); //topLeft
                bisectionalSearch(colL, rowMiddle, colMiddle - 1, rowH); //bottomLeft
            }else if(target > middle){//topLeft removed
                bisectionalSearch(colMiddle + 1, rowL, colH, rowMiddle); //topRight
                bisectionalSearch(colMiddle + 1, rowMiddle + 1, colH, rowH); //bottomRight
                bisectionalSearch(colL, rowMiddle + 1, colMiddle, rowH); //bottomLeft
            }else{
                //Error Handling.
                System.out.println("Something went wrong.");
            }
        }
    }


    //Scans the input file and adds Data to variables
    public static void scan(File input) throws FileNotFoundException{
        Scanner in = new Scanner(input);
        //Getting Size of table
        rowHigh = in.nextInt();
        colHigh = in.nextInt();
        target = in.nextInt();
        //Printing
        System.out.println(rowHigh + " " + colHigh);
        System.out.println(target);
        table = new int[rowHigh][colHigh];

        //Adding data to table
        for(int i = 0; i < rowHigh; i++){
            for(int j = 0; j < colHigh; j++){
                table[i][j] = in.nextInt();
            }
        }
        in.close();
    }

    //Prints out the table
    public static void printTable(){
        for(int i = 0; i < rowHigh; i++){
            for(int j = 0; j < colHigh; j++){
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
    }
}