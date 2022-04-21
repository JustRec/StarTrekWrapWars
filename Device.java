public class Device {
    private int time = 26;
    private int x;
    private int y;
    private boolean is_alive = true;

    public Device(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void passTime() {
        if (time != 0) {
            time--;
        }
        if (time == 10) {
            time--;
        } else if (time == 0) {
            is_alive = false;
            char[][] map = Game.getMap();
            map[x][y] = ' ';
            Game.setMap(map);
            Game.cn.getTextWindow().setCursorPosition(y, x);
            System.out.print(" ");
        }
    }

    public int getTime() {
        return this.time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public boolean getIs_alive() {
        return this.is_alive;
    }

    public void setIs_alive(boolean is_alive) {
        this.is_alive = is_alive;
    }
}
