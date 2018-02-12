//sema köse
//141044002
//HW02

package com.company;

import java.io.IOException;

abstract class Transform {
    public abstract void calculateTransform();
    public abstract void setArguments(double[] realInp, double[] imaginerInp);
    public abstract void print() throws IOException;
}
