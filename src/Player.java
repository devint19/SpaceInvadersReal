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


    //player object constructor
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

    //method for the ship's movement, the player can go side to side but cannot go up
    public void move(int direction){
        x += direction * speed;

        //make sure the ship stays in bounds
        if (x+100 >= p.width) {
            x=400;
        }
        if (x <= 0) {
            x=0;
        }

    }

    //displays the player
    public void display() {
        p.image(ship, x, y);
    }
    public float getX(){
        return x;
    }
}


