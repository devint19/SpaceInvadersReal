import processing.core.PApplet;
import processing.core.PImage;
import processing.event.KeyEvent;

public class game extends PApplet{
    public static void main (String[] args) {
        //pass in a string that's the same as the class name to initialize
        PApplet.main("game");
    }

    //declare any images or variables here
    Player ship;
    Bullet bullet;
    Enemy enemy1n1;
    Enemy enemy1n2;
    Enemy enemy1n3;
    float playerX;
    float newX;
    float bulletY;


    //set up the window size
    public void settings() {
        size(500, 700);
    }

    //initializes any vars
    public void setup () {
        newX = 237;
        playerX = 100;
        bulletY=498;
        ship = new Player(200, 550, this);
        bullet = new Bullet(237, 498, this);

        enemy1n1 = new Enemy(50,100, this);
        enemy1n2 = new Enemy(200,100, this);
        enemy1n3 = new Enemy(350,100, this);
    }

    //create the background and add images and make movements
    public void draw() {
        background(0, 0, 0);

        fill(255, 255, 255);
        textSize(25);
        text("Score: " + score, 200, 50);

        ship.display();
        bullet.display(newX);
        enemy1n1.display();
        enemy1n2.display();
        enemy1n3.display();

        if (keyPressed && key == CODED) {
            if (keyCode == RIGHT) {
                ship.move( 1);
            }
            if (keyCode == LEFT) {
                ship.move(-1);
            }
            if (keyCode == UP) {
                newX = (float) (ship.getX()+38);
                if (bullet.getY()<-52);{
                    bullet.reset();
                }
            }
        }

        if (collision(bullet,enemy1n1)) {
            System.out.println("hit");
            //background(255,255,255);
        }
        if (collision(bullet,enemy1n2)) {
            System.out.println("hit");
            //background(255,255,255);
        }
        /*if (collision(bullet,enemy1n3)) {
            System.out.println("hit");
            //background(255,255,255);
            score+= 1/19;
        }*/



    }

    public boolean collision(Bullet b, Enemy e){
        /*if ((    (b.getY() + b.getH()) < (e.getY())) ||
                (b.getY() > (e.getY() + e.getH())) ||
                ((b.getX() + b.getW()) < e.getX()) ||
                (b.getX() > (e.getX() + e.getW()))  ) {

        }*/
        //left of one to right


        if (    (b.getX() < e.getX() + e.getW()) &&
                (b.getX() + b.getW() > e.getX()) &&
                (b.getY() < e.getY() + e.getH()) &&
                (b.getH() + b.getY() > e.getY()) ) {
            return true;
        }

        return false;
    }
}
