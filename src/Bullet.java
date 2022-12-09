import processing.core.PApplet;
import processing.core.PImage;

public class Bullet {
    PApplet p;
    float x;
    float y;
    int w;
    int h;
    float speed;
    PImage bullet;


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

    public void move(){
        y -= speed;
    }

    public void display(float shipX) {
        p.image(bullet, shipX, y);
        move();
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
    public void reset() {
        y=498;
    }
}


