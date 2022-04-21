import java.awt.Color;

public class Robot {
    private boolean is_alive = true;
    private boolean has_a_target = false;
    private boolean is_pressed_trap = false;
    private boolean is_target_dynamic = false;
    private Stack route;
    private int[] current_location = new int[2];
    private int[] target = new int[2];
    private RouteFinding rf;

    public Robot(char[][] map, char c){
    	rf = new RouteFinding(map);
        current_location[0] = Game.new_robot_location[0];
        current_location[1] = Game.new_robot_location[1];
    }

    public void move(){
        if(!is_pressed_trap){
            if(!route.isEmpty()){
                char[][] map = Game.getMap();

                String[] trg = ((String) route.peek()).split("-");
                int device_code = Game.devices.isItTrapped(Integer.parseInt(trg[0]), Integer.parseInt(trg[1]));
                switch (device_code) {
                    case 1: //Trap
                        is_pressed_trap = true;
                        Game.devices.removeDevice(Integer.parseInt(trg[0]), Integer.parseInt(trg[1]));
                        Game.cn.getTextWindow().setCursorPosition(current_location[1], current_location[0]);
                        System.out.print(" ");
                        Game.cn.getTextWindow().setCursorPosition(Integer.parseInt(trg[1]),Integer.parseInt(trg[0]));
                        Game.wrapper.printInColor(Color.orange, Color.pink, "C");
                        map[current_location[0]][current_location[1]] = ' ';
                        map[Integer.parseInt(trg[0])][Integer.parseInt(trg[1])] = 'C';
                        Game.devices.removeDeviceFromMap(Integer.parseInt(trg[0]), Integer.parseInt(trg[1]));
                        break;
                    case 2: //Warp
                        is_alive = false;
                        has_a_target = false;
                        Game.cn.getTextWindow().setCursorPosition(current_location[1], current_location[0]);
                        System.out.print(" ");
                        map[current_location[0]][current_location[1]] = ' ';
                        Game.devices.removeDeviceFromMap(Integer.parseInt(trg[0]), Integer.parseInt(trg[1]));
                        Points.addScore('C', "player");
                        break;
                    case 0:
                    if(map[Integer.parseInt(trg[0])][Integer.parseInt(trg[1])] != 'C'){ // Check the next target for moving pieces
                            Game.cn.getTextWindow().setCursorPosition(current_location[1], current_location[0]);
                            System.out.print(" ");
                            Game.cn.getTextWindow().setCursorPosition(Integer.parseInt(trg[1]),Integer.parseInt(trg[0]));
                            Game.wrapper.printInColor(Color.orange, Color.green, "C");

                            //Update map[][]
                            map[current_location[0]][current_location[1]] = ' ';
                            current_location[0] = Integer.parseInt(trg[0]);
                            current_location[1] = Integer.parseInt(trg[1]);
                            map[current_location[0]][current_location[1]] = 'C';
                            Game.setMap(map);

                            Steal();
                            route.pop();//Discard the current move
                        }
                        break;
                }
            }
            else{
                has_a_target = false;
                pathFinding();
            }
        }
        if(is_target_dynamic){
            pathFinding();
        }
    }
    public void Steal(){
        char[][] map = Game.getMap();
        int x = current_location[0];
        int y = current_location[1];

        for (int i = x - 1; i < x + 2; i++) {
            for (int j = y - 1; j < y + 2; j++) {
                if(map[i][j] == 'P'){
                    for (int k = 0; k < 2; k++) {
                        char item = (char) Backpack.removeItem();
                        if(item != 'N'){
                            Points.addScore(item, "computer");
                        }                        
                    }
                }
            }
        }
    }

    public void pathFinding(){
        targetSelection();
        if(rf.plotMaze(current_location[0], current_location[1], target[0], target[1])){
            route = rf.getRoute();
            has_a_target = true;
        }       
    }

    public void targetSelection(){
        /*
        target[0] = 2;
        target[1] = 15;
        */
        char[][] map = Game.getMap();
        char currentSelection=' ';
        int target0=0;
        int target1=0;
        double treasureValue=0;
        double travelTime=0;
        double targetValue=0;
        double bestValue=0;
        char current = ' ';

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[1].length; j++) {
                treasureValue=0;
                travelTime=0;
                currentSelection=map[i][j];

                switch(currentSelection) {

                case '1':
                    treasureValue=2;
                case '2':
                    treasureValue=10;
                case '3':
                    treasureValue=30;
                case '4':
                    treasureValue=100;
                case '5':
                    treasureValue=300;
                case 'P':
                    treasureValue=450;
                }

                //     Treasure Value / Time it takes to get there (in seconds) = Target value (Points gained per second)

                travelTime=Math.abs((current_location[0]-i))+Math.abs((current_location[1]-j));
                targetValue=treasureValue/travelTime;

                if(targetValue>bestValue) {
                    bestValue=targetValue;
                    target0=i;
                    target1=j;
                    current = currentSelection;
                }
            }
        }
        if(current == '4' || current == '5' || current == 'P'){
            is_target_dynamic=true;
        }
        target[0] = target0;
        target[1] = target1;

    }

    public boolean getIsAlive() {
        return this.is_alive;
    }

    public void setIsAlive(boolean is_alive) {
        this.is_alive = is_alive;
    }

    public boolean getHasATarget() {
        return this.has_a_target;
    }

    public void setHasATarget(boolean has_a_target) {
        this.has_a_target = has_a_target;
    }
    
}
