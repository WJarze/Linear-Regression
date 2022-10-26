package data;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Point {
    private  double x;
    private  double y;

    public double getXY(){
        return this.x * this.y;
    }

    @Override
    public String toString() {
        return "(" +
                "x = " + x +
                ", y = " + y +
                ")\n";
    }
}
