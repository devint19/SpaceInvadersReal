    import processing.core.PApplet;
import processing.core.PImage;

public class Enemy {
    PApplet p;
    float x;
    float y;
    int w;
    int h;
    float speed;
    PImage attacker;


    public Enemy(float x, float y, PApplet p) {
        this.x = x;
        this.y = y;
        this.p = p;
        w = (100);
        h = (100);
        speed = (int)(Math.random()*10 + 2);

        attacker = p.loadImage("enemy1.png");
        attacker.resize(w, h);
    }

    /*public void move(){
        //enemies can go to the side or they can go down
        //the enemies are individual objects but move together as a group
        x += speed;
        //use system variable width from Processing window
        if (x >= p.width) {
            x = -w;
        }
        else if (x+w <= 0) {
            x = p.width;
        }
    }*/

    public void display() {
        p.image(attacker, x, y);
    }
    public float getX() {
        return x;
    }
    public float getY() {
        return y;
    }
    public float getW() {
        return w;
    }
    public float getH() {
        return h;
    }


}
