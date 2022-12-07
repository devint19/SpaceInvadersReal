import processing.core.PApplet;
import processing.core.PImage;

public class game extends PApplet{
    public static void main (String[] args) {
        //pass in a string that's the same as the class name to initialize
        PApplet.main("game");
    }

    //declare any images or variables here
    Player ship;
    float playerX;
    float xSpeedPlayer;
    float enemy;

    //set up the window size
    public void settings() {
        size(500, 1000);
    }

    //initializes any vars
    public void setup () {
        playerX = 100;
        ship = new Player(500, 900, this);
    }

    //create the background and add images and make movements
    public void draw() {
        background(0, 0, 0);
        ship.display();
    }
}
