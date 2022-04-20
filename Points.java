import javax.lang.model.util.ElementScanner14;

public class Points {
    private static int player = 0;
    private static int computer = 0;

    public static  void addScore(char c, String team){
        switch (c) {
            case '=':
                computer += 300;
                break;
            case '*':
                computer += 300;
                break;
            case '1':
                if(team.equals("computer")){
                    computer += 2;
                }
                else{
                    player += 1;
                }
                break;
            case '2':
                if(team.equals("computer")){
                    computer += 10;
                }
                else{
                    player += 5;
                }
                break;
            case '3':
                if(team.equals("computer")){
                    computer += 30;
                }
                else{
                    player += 15;
                }
                break;
            case '4':
                if(team.equals("computer")){
                    computer += 100;
                }
                else{
                    player += 50;
                }
                break;
            case '5':
                if(team.equals("computer")){
                    computer += 300;
                }
                else{
                    player += 150;
                }
                break;
            case 'C':
                player += 300;
                break;
        }
    }






    public int getPlayer() {
        return player;
    }

    public int getComputer() {
        return computer;
    }

}
