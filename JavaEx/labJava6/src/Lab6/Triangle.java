package Lab6;

public class Triangle extends Shape {
    public double base;
    public double height;

    public double getBase() {
        return base;
    }

    public double getHeight() {
        return height;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double getArea() {
        return (getHeight() * getHeight())/2;
    }
}
