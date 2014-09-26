import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class SnowflakeCatcher extends PApplet {

SnowFlake [] snowFalling;
public void setup()
{
  size(500, 500);
  background(0);
  snowFalling = new SnowFlake[500];
  for (int i = 0; i < snowFalling.length; i++) 
  {
    snowFalling[i] = new SnowFlake();
  }
}
public void draw()
{
  for (int i = 0; i < snowFalling.length; i++) 
  {
    snowFalling[i].erase();
    snowFalling[i].lookDown();
    snowFalling[i].move();
    snowFalling[i].wrap();
    snowFalling[i].show();
  }
}
public void mouseDragged()
{
  if(mouseButton == LEFT)
  {
    fill(0, 100, 200, 150);
    ellipse(mouseX, mouseY, 10, 10);
  }
  if(mouseButton == RIGHT)
  {
    fill(0);
    ellipse(mouseX, mouseY, 50, 50);
  }
}

class SnowFlake
{
  int snowX, snowY, snowSize;
  boolean isMoving;
  SnowFlake()
  {
    snowX = (int)(Math.random()*500);
    snowY = (int)(Math.random()*495+3);
    snowSize = 5;
    isMoving = true;
  }
  public void show()
  {
    fill(255, ((int)(Math.random()*125+125)));
    noStroke();
    //snowSize = (int)(Math.random()*3+3);
    ellipse(snowX, snowY, snowSize, snowSize);
  }
  public void lookDown()
  {
    if((snowY >= 0 && snowY <= 490) && get(snowX,snowY+4) != color(0))
    {
      isMoving = false;
    }
    else 
    {
      isMoving = true;
    }
  }
  public void erase()
  {
    fill(0);
    stroke(0);
    ellipse(snowX, snowY, 7, 7);
  }
  public void move()
  {
    if(isMoving == true)
    {
      snowY += (int)(Math.random()*3+1);
    }
    else 
    {
      snowY += 0;  
    }
  }
  public void wrap()
  {
    if(snowY > 500)
    {
      snowX = (int)(Math.random()*500);
      snowY = 0;
    }
  }
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "SnowflakeCatcher" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
