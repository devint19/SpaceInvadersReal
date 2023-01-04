import processing.core.PApplet;
import processing.core.PImage;

public class Bullet {
    //initialize vars
    PApplet p;
    float x;
    float y;
    int w;
    int h;
    float speed;
    PImage bullet;

    //bullet constructor
    public Bullet(float x, float y, PApplet p) {
        this.x = x;
        this.y = y;
        this.p = p;
        w = (128/5);
        h = (258/5);
        speed = 8;

        bullet = p.loadImage("bullet.png");
        bullet.resize(w, h);
    }

    //moves the bullet "up" the screen
    public void move(){
        y -= speed;
    }

    //displays the bullet - whenever bullet is newly displayed put it where the ship nose is and move it up
    public void display(float shipX) {
        x=shipX;
        p.image(bullet, x, y);
        move();
    }

    //return functions
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
    //resets the bullet back down
    public void reset() {
        y=498;
    }
}


