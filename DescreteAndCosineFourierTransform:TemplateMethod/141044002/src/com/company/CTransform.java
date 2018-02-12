//sema köse
//141044002
//HW02

package com.company;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CTransform extends Transform {
    @Override
    public void calculateTransform() {
        int size = realInput.length;
        double sumOfReals = 0;
        double sumOfImaginers = 0;
        double innerOperation = 0;

        for(int out=0; out<size; ++out){
            sumOfReals = 0;
            for(int in=0; in<size; ++in){
                innerOperation = 2*realInput[in]*Math.cos((Math.PI/size)*(in + 0.5)*out);
                sumOfReals = sumOfReals + innerOperation;
            }
            realOutput[out] = sumOfReals;
        }


    }
    @Override
    public void setArguments(double[] realInp, double[] imaginerInp) {
        int index=0;
        realInput = new double[realInp.length];
        for(double i:realInp){
            realInput[index] = i;
            ++index;
        }
        realOutput = new double[realInp.length];
    }
    @Override
    public void print() throws IOException {
        //print to screen
        System.out.println("\nCFT:\n");
        for(int i=0; i<realOutput.length; i++){
            System.out.println(Math.rint(realOutput[i]));
        }

        //print to file
        File file = new File("output.txt");
        if (!file.exists()) {
            file.createNewFile();
        }

        FileWriter fileWriter = new FileWriter(file, true);
        BufferedWriter bWriter = new BufferedWriter(fileWriter);
        bWriter.write("\nCFT:\n");
        for(int i=0; i<realOutput.length; i++){
            bWriter.write(Math.rint(realOutput[i])+ "\n");
        }
        bWriter.close();
    }
    private double[] realInput;
    private double[] realOutput;
}