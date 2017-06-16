package model;

public class BWall extends Tile implements Breakable {

    public BWall(int x, int y) {
        super(x, y);
        setRef(3);

    }

    @Override
    public void isBreak() {

        setRef(2);

    }
}
