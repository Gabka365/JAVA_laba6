package bsu.rfe.java.group8.lab6.Potapnev.var12B;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;
@SuppressWarnings("serial")
public class Field extends JPanel {

private boolean paused= false;
public boolean paused1= false;
private ArrayList<BouncingBall> balls = new ArrayList<BouncingBall>(10);

private Timer repaintTimer = new Timer(10, new ActionListener() {
public void actionPerformed(ActionEvent ev) {

repaint();
}
});
public Field() {
setBackground(Color.WHITE);
repaintTimer.start();
}

public void paintComponent(Graphics g) {
super.paintComponent(g);
Graphics2D canvas = (Graphics2D) g;
for (BouncingBall ball: balls) {
ball.paint(canvas);
}
}

public void addBall() {

balls.add(new BouncingBall(this));
}

public synchronized void pause() {

paused = true;
}

public synchronized void resume() {

paused = false;

notifyAll();
}
public synchronized void pause1(){
	for (BouncingBall ball: balls) {
	if(((ball.getSpeedX()<0)&&(ball.getSpeedY()<0))) {
		System.out.println(ball);
	 ball.stop=false;
	}
		}
}

public synchronized void resume1() {
		for (BouncingBall ball: balls) {
			if(ball.stop==false) {
				ball.stop=true;
				System.out.println(ball);
			}
				}
	}
	
public synchronized void canMove(BouncingBall ball) throws
InterruptedException {
if (paused) {
this.wait();
}
}
}

