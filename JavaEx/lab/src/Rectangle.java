public class Rectangle{
    private int width;
    private int height;

    public Rectangle(){
        this.width = 7;
        this.height = 3;
    }
    public Rectangle(int width, int height){
        this.width = width;
        this.height = height;
    }
    public void display(){
        for (int i = 0; i < height;i++){
            for (int j = 0; j < width; j++){
                System.out.printf("# ");
            }
            System.out.println("");
        }
    }

    public int getArea(){
        System.out.println("Dien tich cua hinh chu nhat la: "+this.height*this.width);
        return this.height*this.width;
    }
    public int getPerimeter(){
        System.out.println("Chu vi cua hinh chu nhat la: "+(this.height+this.width)*2);
        return (this.height+this.width)/2;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public int getHeight(){
        return this.height;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int getWidth(){
        return this.width;
    }
}
