public class RouteFinding {
    private char[][] map;
    private boolean[][] is_crossed;
    private boolean[][] true_path; //Correct path to the target
    private int end_x;
    private int end_y;
    private Stack route;

    public RouteFinding(char[][] map){
        this.map = map;
        is_crossed = new boolean[map.length][map[0].length];
        true_path = new boolean[map.length][map[0].length];
        route = new Stack(map.length * map[0].length);

        for (int row = 0; row < true_path.length; row++) {  //Reset the values
            for (int column = 0; column < true_path[0].length; column++) {
                is_crossed[row][column] = false;
                true_path[row][column] = false;
            }
        }
    }

    public boolean plotMaze(int x, int y, int end_x, int end_y){

        this.end_x = end_x;
        this.end_y = end_y;

        for (int row = 0; row < true_path.length; row++) {  //Reset the values
            for (int column = 0; column < true_path[0].length; column++) {
                is_crossed[row][column] = false;
                true_path[row][column] = false;
            }
        }

        boolean was_route_found = recursiveRoute(x, y);

        if(!was_route_found){
            System.out.println("There is no legal path" + x + "," +  y + "to " + end_x + "," + end_y );
        }

        return was_route_found;

    }
    

    private boolean recursiveRoute(int x, int y){
        int initial_x = x;
        int initial_y = y;
        if (x == end_x && y == end_y) return true; //Reaching end
        if(map[x][y] == '#' || is_crossed[x][y]) return false; //Reaching a wall or an already crossed place
        
        is_crossed[x][y] = true;

        if(y != 0){ //Check if on the left sideee
            if(recursiveRoute(x, y - 1)){
                route.push(String.valueOf(x) + "-" + String.valueOf(y));
                return true;
            }
        }
        if (y != map[0].length - 1){ //Check if on the right side
            if(recursiveRoute(x, y + 1)){
                route.push(String.valueOf(x) + "-" + String.valueOf(y));
                return true;
            }
        }
        if (x != 0){ //Check if on the upper side
            if(recursiveRoute(x - 1, y)){
                route.push(String.valueOf(x) + "-" + String.valueOf(y));
                return true;
            }
        }
        if (x != map.length - 1){ //Check if on the bottom side
            if(recursiveRoute(x + 1, y)){
                route.push(String.valueOf(x) + "-" + String.valueOf(y));
                return true;
            }
        }


        return false;
    }

    public Stack getRoute() {
        return this.route;
    }
}