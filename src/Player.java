import processing.core.PApplet;
import processing.core.PImage;

public class Player {
    PApplet p;
    float x;
    float y;
    int w;
    int h;
    float speed;
    PImage ship;


    public Player(float x, float y, PApplet p) {
        this.x = x;
        this.y = y;
        this.p = p;
        w = (100);
        h = (100);
        speed = 6;

        ship = p.loadImage("ship.png");
        ship.resize(w, h);
    }

    public void move(int direction){
        //the player can go side to side but cannot go up
        x += direction * speed;
        //use system variable width from Processing window
        if (x+100 >= p.width) {
            x=400;
        }
        if (x <= 0) {
            x=0;
        }

    }

    public void display() {
        p.image(ship, x, y);
    }
    public float getX(){
        return x;
    }
}


