import processing.core.PApplet;
import processing.core.PImage;
import processing.event.KeyEvent;

public class game extends PApplet{
    public static void main (String[] args) {
        //pass in a string that's the same as the class name to initialize
        PApplet.main("game");
    }

    //declares any images or variables
    Player ship;
    Bullet bullet;
    Enemy enemy1n1;
    Enemy enemy1n2;
    Enemy enemy1n3;
    float playerX;
    float newX;
    float bulletY;
    float score;


    //set up the window size
    public void settings() {
        size(500, 700);
    }

    //initializes any vars
    public void setup () {
        newX = 237;
        playerX = 100;
        bulletY = 498;
        ship = new Player(200, 550, this);
        bullet = new Bullet(237, 498, this);

        enemy1n1 = new Enemy(50,100, this);
        enemy1n2 = new Enemy(200,100, this);
        enemy1n3 = new Enemy(350,100, this);

        score = 0;
    }

    //creates the background and add images and make movements
    public void draw() {
        background(0, 0, 0);

        //write score at top
        fill(255, 255, 255);
        textSize(25);
        text("Score: " + (int)(score+0.5), 205, 50);

        //display all objects
        ship.display();
        bullet.display(newX);
        enemy1n1.display();
        enemy1n2.display();
        enemy1n3.display();

        //code for controlling the ship left and right and shooting via keyboard
        if (keyPressed && key == CODED) {
            if (keyCode == RIGHT) {
                ship.move( 1);
            }
            if (keyCode == LEFT) {
                ship.move(-1);
            }
            //code for shooting
            if (keyCode == UP) {
                //allow the image to be changed again after a shot is fired
                enemy1n1.updateChanged();
                enemy1n2.updateChanged();
                enemy1n3.updateChanged();
                //shoot bullet from nose off ship
                newX = (float) (ship.getX()+38);
                //bring back bullet from off-screen
                if (bullet.getY()<-52);{
                    bullet.reset();
                }
            }
        }

        //call hit for each enemy to update image and add one point
        if (collision(bullet,enemy1n1)) {
            System.out.println("hit1");
            score += enemy1n1.hit();
        }
        if (collision(bullet,enemy1n2)) {
            System.out.println("hit2");
            score += enemy1n2.hit();
        }
        if (collision(bullet,enemy1n3)) {
            System.out.println("hit3");
            score += enemy1n3.hit();
        }

    }

    public boolean collision(Bullet b, Enemy e){
        //pass in the bullet and an enemy and check if they are overlapping
        if (    (b.getX() < e.getX() + e.getW()) &&
                (b.getX() + b.getW() > e.getX()) &&
                (b.getY() < e.getY() + e.getH()) &&
                (b.getH() + b.getY() > e.getY()) ) {
            return true;
        }

        return false;
    }
}
