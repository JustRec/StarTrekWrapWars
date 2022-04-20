import java.awt.Color;

public class Robot {
    private boolean is_alive = true;
    private boolean has_a_target = false;
    private boolean is_pressed_trap = false;
    private Stack route;
    private int[] current_location = new int[2];
    private int[] target = new int[2];
    private static RouteFinding rf;
    private char type;

    public Robot(char[][] map, char c){
        type = c;
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
                        break;
                    case 2: //Warp
                        is_alive = false;
                        Game.cn.getTextWindow().setCursorPosition(current_location[1], current_location[0]);
                        System.out.print(" ");
                        map[current_location[0]][current_location[1]] = ' ';
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
        
        
    }

    public void pathFinding(){
        targetSelection();
        if(rf.plotMaze(current_location[0], current_location[1], target[0], target[1])){
            route = rf.getRoute();
            has_a_target = true;
        }       
    }

    public void targetSelection(){
        target[0] = 2;
        target[1] = 15;
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
