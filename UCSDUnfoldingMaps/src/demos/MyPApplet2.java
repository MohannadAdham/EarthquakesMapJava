package demos;

import processing.core.*;

public class MyPApplet2 extends PApplet {
	private String URL = "palmTrees.jpg";
	private PImage backgroundImg;
	
	public void setup() {
		size(400, 400);
		backgroundImg = loadImage(URL, "jpg");
	}
	
	public void draw() {
		image(backgroundImg, 0, 0);
		backgroundImg.resize(0, height);
		fill(255, 209, 0);
		ellipse(width/4, height/5, width/5, height/5);
	}
}