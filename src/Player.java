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
        w = (50);
        h = (50);
        speed = (int)(Math.random()*10 + 2);

        ship = p.loadImage("ship.png");
        ship.resize(w, h);
    }

    public void move(){
        //the player can go side to side but cannot go up
        x += speed;
        //use system variable width from Processing window
        if (x >= p.width) {
            x = -w;
        }
        else if (x+w <= 0) {
            x = p.width;
        }

    }

    public void display() {
        p.image(ship, x, y);
    }

}
