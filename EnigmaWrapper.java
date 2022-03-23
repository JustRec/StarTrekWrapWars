import enigma.event.TextMouseEvent;
import enigma.event.TextMouseListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import enigma.console.Console;
import enigma.console.TextAttributes;

import java.awt.Color;


public class EnigmaWrapper {
    private TextMouseListener tmlistener;
    private KeyListener klistener;

    private int mousepr;
    private int mousex;
    private int mousey;
    private int keypr;
    private int rkey;

    private Console cn;

    public EnigmaWrapper(Console cn){ //Constructer
        this.cn = cn;

        tmlistener=new TextMouseListener() { //Mouse event listener
            public void mouseClicked(TextMouseEvent arg0) {}
            public void mousePressed(TextMouseEvent arg0) {
                if(mousepr==0) {
                    mousepr=1;
                    mousex=arg0.getX();
                    mousey=arg0.getY();
                }
            }
            public void mouseReleased(TextMouseEvent arg0) {}
        };
        cn.getTextWindow().addTextMouseListener(tmlistener);

        klistener=new KeyListener() { //Keyboard event listener
            public void keyTyped(KeyEvent e) {}
            public void keyPressed(KeyEvent e) {
                if(keypr==0) {
                    keypr=1;
                    rkey=e.getKeyCode();
                }
            }
            public void keyReleased(KeyEvent e) {}
        };
        cn.getTextWindow().addKeyListener(klistener);
    }

    public void clearConsole(){ //print empty lines and reset the cursor locations
        for (int i = 0; i < 100; i++) {
            System.out.println(" ");
        }
        cn.getTextWindow().setCursorPosition(0,0);
    }

    public void consoleColor(int r, int g, int b){ //color the text to rgb values
        Color color = new Color(r,g,b);
        TextAttributes ta = new TextAttributes(color);
        cn.setTextAttributes(ta);
    }

    public void consoleColor(Color color1, Color color2){ //color the console using Color.color
        TextAttributes ta = new TextAttributes(color1, color2);
        cn.setTextAttributes(ta);
    }
    public static int compress(double value){ //reset the formatting of the rgb values
        if(value < 0){
            return 0;
        }
        else if(value > 255){
            return 255;
        }
        value += 0.5;
        return (int)value;

    }

    
    public Color hueCube(double degree, int r, int g, int b){ //create new rgb values by turning an imaginary color cube
        int[] arr = new int[3];
        double[][] cube_matrix = new double[3][3];
        double cosA = Math.cos(degree);
        double sinA = Math.sin(degree);

        cube_matrix[0][0] = cosA + (1.0 - cosA) / 3.0;
        cube_matrix[0][1] = 1./3. * (1.0 - cosA) - Math.sqrt(1./3.) * sinA;
        cube_matrix[0][2] = 1./3. * (1.0 - cosA) + Math.sqrt(1./3.) * sinA;
        cube_matrix[1][0] = 1./3. * (1.0 - cosA) + Math.sqrt(1./3.) * sinA;
        cube_matrix[1][1] = cosA + 1./3.*(1.0 - cosA);
        cube_matrix[1][2] = 1./3. * (1.0 - cosA) - Math.sqrt(1./3.) * sinA;
        cube_matrix[2][0] = 1./3. * (1.0 - cosA) - Math.sqrt(1./3.) * sinA;
        cube_matrix[2][1] = 1./3. * (1.0 - cosA) + Math.sqrt(1./3.) * sinA;
        cube_matrix[2][2] = cosA + 1./3. * (1.0 - cosA);

        double new_r = r * cube_matrix[0][0] + g * cube_matrix[0][1] + b * cube_matrix[0][2];
        double new_b = r * cube_matrix[1][0] + g * cube_matrix[1][1] + b * cube_matrix[1][2];
        double new_g = r * cube_matrix[2][0] + g * cube_matrix[2][1] + b * cube_matrix[2][2];

        arr[0] = compress(new_r);
        arr[1] = compress(new_g);
        arr[2] = compress(new_b);

        Color fcolor = new Color(arr[0], arr[1], arr[2]);
        return fcolor;
    }


    public int getMousepr() {
        return this.mousepr;
    }

    public void setMousepr(int mousepr) {
        this.mousepr = mousepr;
    }

    public int getMousex() {
        return this.mousex;
    }

    public void setMousex(int mousex) {
        this.mousex = mousex;
    }

    public int getMousey() {
        return this.mousey;
    }

    public void setMousey(int mousey) {
        this.mousey = mousey;
    }

    public int getKeypr() {
        return this.keypr;
    }

    public void setKeypr(int keypr) {
        this.keypr = keypr;
    }

    public int getRkey() {
        return this.rkey;
    }

    public void setRkey(int rkey) {
        this.rkey = rkey;
    }

}
