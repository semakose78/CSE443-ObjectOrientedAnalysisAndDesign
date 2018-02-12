//sema köse
//141044002
//HW02
package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        String[] input = new String[2];
        String[] parsedReal = new String[4];
        String[] parsedImag = new String[4];
        double[] arr1 = {3.0, 4.0, 5.0, 6.0} ;
        double[] arr2 = {1.0, 2.0, 3.0, 4.0} ;
        double[] arr3 = new double[4];
        double[] arr4 = new double[4];

        //Read the file and parse into double coefficient arrays

        input = readFile();

        parsedReal = input[0].split(", ");
        parsedImag = input[1].split(", ");

        for(int i=0; i<2; i++){
            try {
                if(i==0){
                    for(int k=0; k<input[i].length(); k++){
                        if(k<4){
                            arr3[k] = Double.parseDouble(parsedReal[k]);
                            //System.out.println(arr3[k]);
                        }

                    }
                }else if(i==1){
                    for(int k=0; k<input[i].length(); k++){
                        if(k<4){
                            arr4[k] = Double.parseDouble(parsedImag[k]);
                            //System.out.println(arr3[k]);
                        }
                    }
                }

            }catch (NullPointerException e){
                e.printStackTrace();
            }
        }

        Transform test = new FTransform();
        test.setArguments(arr3, arr4);
        test.calculateTransform();
        test.print();

        test = new CTransform();
        test.setArguments(arr3, arr4);
        test.calculateTransform();
        test.print();


    }

    public static String[] readFile() throws IOException {
        String[] line = new String[3];
        int i=0;
        System.out.println("Coefficients : \n");
        try {
            FileReader readFile = new FileReader("coeffs.txt");
            BufferedReader readToBuff = new BufferedReader(readFile);
            while ((line[i] = readToBuff.readLine()) != null) {
                System.out.println(line[i]);
                if(i<1)
                    ++i;
                else if(i==1)
                    break;
            }
            readToBuff.close();
            readFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return line;
    }

    public static void printToFile(FTransform DFT, CTransform DCT) throws IOException {

        DFT.print();
        DCT.print();

    }
}
