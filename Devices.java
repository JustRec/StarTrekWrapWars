public class Devices {

    private int[][] device_map = new int[50][60];
    private int device_count = 0;

    public Devices() { // Fill the array with default values
        for (int i = 0; i < device_map.length; i++) {
            for (int j = 0; j < device_map[0].length; j++) {
                device_map[i][j] = 0;
            }
        }
    }

    public void addDevice(char type, int x, int y) {
        int value = 0;
        switch (type) {
            case '=':
                value = 1; // Assign 1 if device is a trap
                Game.device[device_count] = new Device(x, y);
                device_count++;
                break;
            case '*':
                value = 2; // Assign 1 if device is a warp
                Game.device[device_count] = new Device(x, y);
                device_count++;
                break;

        }

        device_map[x][y] = value; // Assign 1 if device is a trap
        device_map[x + 1][y] = value;
        device_map[x - 1][y] = value;
        device_map[x][y - 1] = value;
        device_map[x][y + 1] = value;
        device_map[x + 1][y + 1] = value;
        device_map[x + 1][y - 1] = value;
        device_map[x - 1][y + 1] = value;
        device_map[x - 1][y - 1] = value;
    }

    public void removeDevice(int x, int y) {
        device_map[x][y] = 0;
        device_map[x + 1][y] = 0;
        device_map[x - 1][y] = 0;
        device_map[x][y - 1] = 0;
        device_map[x][y + 1] = 0;
        device_map[x + 1][y + 1] = 0;
        device_map[x + 1][y - 1] = 0;
        device_map[x - 1][y + 1] = 0;
        device_map[x - 1][y - 1] = 0;
    }

    public void removeDeviceFromMap(int x, int y) {
        char[][] map = Game.getMap();
        for (int i = x - 1; i < x + 2; i++) {
            for (int j = y - 1; j < y + 2; j++) {
                if (map[i][j] == '=' || map[i][j] == '*') {
                    map[i][j] = ' ';
                    Game.setMap(map);
                    Game.cn.getTextWindow().setCursorPosition(j, i);
                    System.out.print(" ");
                    break;
                }
            }
        }
    }

    public int isItTrapped(int x, int y) {
        return device_map[x][y];
    }
}
