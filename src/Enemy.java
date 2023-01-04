import processing.core.PApplet;
import processing.core.PImage;

public class Enemy {

    //initialize vars
    PApplet p;
    float x;
    float y;
    int w;
    int h;
    PImage attacker;
    float level;
    boolean changed;

    //enemy constructor
    public Enemy(float x, float y, PApplet p) {
        this.x = x;
        this.y = y;
        this.p = p;
        w = (100);
        h = (100);
        //this variable is for the different ship image
        changed = false;

        level = 1;
        attacker = p.loadImage("enemy1.png");
        attacker.resize(w, h);
    }

    //displays the enemy
    public void display() {
        p.image(attacker, x, y);
    }

    //return functions for the enemy
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

    //called each time the bullet hits a shipped: used to change alien picture and add a point
    public float hit(){
        //update to the next image based on level, and check if already changed (because hit is called while bullet is passing through)
        //end with returning point
        if (level==1 && !changed){
            attacker = p.loadImage("enemy2.png");
            attacker.resize(w, h);
            level=2;
            changed=true;
            return 1;
        }
        else if (level==2 && !changed){
            attacker = p.loadImage("enemy3.png");
            attacker.resize(w, h);
            level=3;
            changed=true;
            return 1;
        }
        else if (level==3 && !changed){
            attacker = p.loadImage("enemy1.png");
            attacker.resize(w, h);
            level=1;
            changed=true;
            return 1;
        }
        return 0;
    }

    //called each time new shot is fired so that the ship image can be changed
    public void updateChanged(){
        changed=false;
    }


}
