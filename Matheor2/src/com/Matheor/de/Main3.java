package com.Matheor.de;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import org.junit.Test;

public class Main3 {

	private static int settingsMain[] = new int[2];
	private static int distance;
	private static GameScreen screen;
	private static GameEngine engine; 
	private static String exercise;
	private static int result;
	private static int sign;
	private static boolean open;
	private static boolean ready;
	private static int score;
	
	public Main3(){
//		File file = new File("score.txt");
//		try {
//			if(file.createNewFile()) {
//				System.out.println("Score file created!");
//			}else {
//				System.out.println("Score file already exists");
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		score = 0;
	}

	public static void main(){
		
		screen = new GameScreen();
		screen.setVisible(true);
		
		screen.setTextField(getExercise());
		moveTxtField(5);
	}
	
	private static void checkResult() {
		if(screen.getInpResult() == result) {
			screen.setTextField("Richtig");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			score += 10;
			screen.setVisible(false);
			screen.dispose();
			main();
		}else {
			screen.setTextField("Verloren du Noopi!");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.exit(0);
		}
	}
	
	public static String getExercise(){
		
		int klasse = settingsMain[0];
		int level = settingsMain[1];
//		int klasse = 5;
//		int level = 1;
		
		switch(klasse){
			case 5:{
				switch(level){
					case 1:{
						createPlusMinus(0);
						break;
					}
					case 2:{
						createPlusMinus(1);
						break;
					}
					case 3:{
						Random random = new Random();
						int rand = random.nextInt(2);
						if(rand == 0) {
							createPlusMinus(1);
						}else if(rand == 1){
							createMalGeteilt();
						}
						break;
					}
				}
				break;
			}
			case 7:{
				switch(level){
					case 1:{
						
						break;
					}
					case 2:{
						
						break;
					}
					case 3:{
						
						break;
					}
				}
				break;
			}
			case 9:{
				switch(level){
					case 1:{
						
						break;
					}
					case 2:{
						
						break;
					}
					case 3:{
						
						break;
					}
				}
				break;
			}
		}
		return exercise;
	}
	
	
	public static void createPlusMinus(int level){
		//0 -> Plus und Minus 1 -> Plus 2 -> Minus
		Random rand = new Random();
		//int sign = rand.nextInt(2); 
		if(level == 1){
			int randNum1 = rand.nextInt(20);
			int randNum2 = rand.nextInt(20);
			int randNum3 = rand.nextInt(20);
			
			int signPos = rand.nextInt(4);
			if(signPos == 0){
				result = randNum1 + randNum2 - randNum3;
				exercise = randNum1 + " + " + randNum2 + " - " + randNum3;

			}else if(signPos == 1){
				result = randNum1 - randNum2 + randNum3;
				exercise = randNum1 + " - " + randNum2 + " + " + randNum3;

			}else if(signPos == 2){
				result = randNum1 + randNum2 + randNum3;
				exercise = randNum1 + " + " + randNum2 + " + " + randNum3;

			}else{
				result = randNum1 - randNum2 - randNum3;
				exercise = randNum1 + " - " + randNum2 + " - " + randNum3;

			}
		}else if(level == 0){
			int randNum1 = rand.nextInt(20);
			int randNum2 = rand.nextInt(20);
			
			int signPos = rand.nextInt(2);
			if(signPos == 0) {
				result = randNum1 + randNum2;
				exercise = randNum1 + "+" + randNum2;
			}else {
				result = randNum1 - randNum2;
				exercise = randNum1 + "-" + randNum2;
			}
		}else{
			
		}
	}

	private static void createMalGeteilt() {
		Random rand = new Random();
		int randNum1 = rand.nextInt(20);
		int randNum2 = rand.nextInt(20);
		
		int signPos = 0;
		if(signPos == 0) {
			result = randNum1 * randNum2;
			exercise = randNum1 + "*" + randNum2;
		}else {
			result = randNum1 / randNum2;
			exercise = randNum1 + "/" + randNum2;
		}
	}
	
	public static void setExcercise(String excercise) {
		Main3.exercise = excercise;
	}

	public static int getResult() {
		return result;
	}

	public static void setResult(int result) {
		Main3.result = result;
	}
	
	public static void setSetting(int[] settings) {
		settingsMain = Arrays.copyOf(settings, settings.length);
	}
	
	public static void moveTxtField(int speed) {
			
			Timer timer = new Timer();
			timer.schedule(new TimerTask() {
				@Override
				public void run(){
					screen.moveTextField(speed);
					distance = (screen.getTxt_exeY() - screen.getTxt_inpY()) * -1;
					if(distance < 4 + screen.getResult_height()){
						this.cancel();
						checkResult();
					}
				}
			}, 100, 100);
//			if(screen.getInpResult() == getResult()) {
//				screen.setTextField("Richtig");
//				screen.exerciseMoveY(0);
//			}

	//			System.out.println("Distance: " + distance);
	//			System.out.println("I: " + i);
	}	
}
 