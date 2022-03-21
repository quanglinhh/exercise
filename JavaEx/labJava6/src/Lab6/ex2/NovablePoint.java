package Lab6.ex2;



class NovablePoint implements Navable {
    private int x = 0;
    private int y = 0;
    MoveTest moveTest = new MoveTest();
    public NovablePoint() {

    }

    public NovablePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void moveDown() {
        y--;

    }

    @Override
    public void moveLeft() {
        x--;

    }

    @Override
    public void moveRight() {
       x++;

    }

    @Override
    public void moveUp() {
        y++;

    }
}


