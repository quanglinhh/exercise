package Lab6.ex1;


public abstract class Shape {
    private String color;
    public Shape(){

    }

    public Shape(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public abstract double getArea();

    @Override
    public String toString() {
        return "có màu"+ getColor();
    }
}
