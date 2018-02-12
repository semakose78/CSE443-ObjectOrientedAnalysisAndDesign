//sema köse
//141044002
//HW02

package com.company;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FTransform extends Transform {
    @Override
    public void calculateTransform() {
        int size = realInput.length;
        double sumOfReals = 0;
        double sumOfImaginers = 0;
        double upperIndices = 0;

        for(int out=0; out<size; out++){
            sumOfReals = 0;
            sumOfImaginers = 0;
            for(int in=0; in<size; in++){
                upperIndices = 2 * Math.PI * in * out / size;
                sumOfImaginers = sumOfImaginers + (-realInput[in] * Math.sin(upperIndices) + imaginerInput[in] * Math.cos(upperIndices));
                sumOfReals = sumOfReals + (realInput[in] * Math.cos(upperIndices) + imaginerInput[in] * Math.sin(upperIndices));
            }
            realOutput[out] = sumOfReals;
            imaginerOutput[out] = sumOfImaginers;
        }
    }
    @Override
    public void setArguments(double[] realInp, double[] imaginerInp) {
        realInput = new double[realInp.length];
        imaginerInput = new double[imaginerInp.length];
        for(int i=0; i<realInp.length; i++){
            realInput[i] = realInp[i];
            imaginerInput[i] = imaginerInp[i];
        }
        realOutput = new double[realInp.length];
        imaginerOutput = new double[imaginerInp.length];
    }

    @Override
    public void print() throws IOException {
        //print to screen
        System.out.println("\nDFT:\n");
        for(int i=0; i<realOutput.length; i++){
            System.out.println(Math.rint(realOutput[i])+ " + " + Math.rint(imaginerOutput[i]) + "i");
        }

        //print to file
        File file = new File("output.txt");
        if (!file.exists()) {
            file.createNewFile();
        }

        FileWriter fileWriter = new FileWriter(file, true);
        BufferedWriter bWriter = new BufferedWriter(fileWriter);
        bWriter.write("\nDFT:\n");
        for(int i=0; i<realOutput.length; i++){
            bWriter.write(Math.rint(realOutput[i])+ " + " + Math.rint(imaginerOutput[i]) + "i\n");
        }
        bWriter.close();
    }
    private double[] realInput;
    private double[] imaginerInput;
    private double[] realOutput;
    private double[] imaginerOutput;
}
