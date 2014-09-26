SnowFlake [] snowFalling;
void setup()
{
  size(500, 500);
  background(0);
  snowFalling = new SnowFlake[500];
  for (int i = 0; i < snowFalling.length; i++) 
  {
    snowFalling[i] = new SnowFlake();
  }
}
void draw()
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
void mouseDragged()
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
  void show()
  {
    fill(255, ((int)(Math.random()*125+125)));
    noStroke();
    //snowSize = (int)(Math.random()*3+3);
    ellipse(snowX, snowY, snowSize, snowSize);
  }
  void lookDown()
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
  void erase()
  {
    fill(0);
    stroke(0);
    ellipse(snowX, snowY, 7, 7);
  }
  void move()
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
  void wrap()
  {
    if(snowY > 500)
    {
      snowX = (int)(Math.random()*500);
      snowY = 0;
    }
  }
}