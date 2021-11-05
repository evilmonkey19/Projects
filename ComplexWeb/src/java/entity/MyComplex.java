package entity;

import static java.lang.Math.sqrt;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;

/**
 *
 * @author evilmonkey19
 */
@Getter
@Setter
@AllArgsConstructor

public class MyComplex {
    private double imag;
    private double real;
    
    public MyComplex(){
        this(0,0);
    }
    public double mod(){
        return sqrt(this.real*this.real + this.imag*this.imag);
    }
    
    @Override
    public String toString(){
        return this.real + "+j" + this.imag;
    }
}
