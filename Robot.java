public class Robot {
    private boolean is_alive = true;
    private boolean has_a_target = false;
    private Stack route;
    private int[] current_location = new int[2];
    private int[] target = new int[2];
    private static RouteFinding rf;


    public Robot(char[][] map){
        rf = new RouteFinding(map);
        current_location[0] = Game.new_robot_location[0];
        current_location[1] = Game.new_robot_location[1];
    }

    public void move(){
        if(!route.isEmpty()){
            char[][] map = Game.getMap();
            String f_route = (String) route.pop();
            String[] trg = new String[2];
            trg = f_route.split("-");

            
            map[current_location[0]][current_location[1]] = ' ';
            map[Integer.parseInt(trg[0])][Integer.parseInt(trg[0])] = 'C';

            Game.cn.getTextWindow().setCursorPosition(current_location[1], current_location[0]);
            System.out.print(" ");
            Game.cn.getTextWindow().setCursorPosition(Integer.parseInt(trg[1]),Integer.parseInt(trg[0]));
            System.out.print("C");
            current_location[0] = Integer.parseInt(trg[0]);
            current_location[1] = Integer.parseInt(trg[1]);
            
        }
        else{
            has_a_target = false;
            pathFinding();
        }
        
    }

    public void pathFinding(){
        targetSelection();
        rf.plotMaze(current_location[0], current_location[1], target[0], target[1]);
        route = rf.getRoute();
        has_a_target = true;
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
