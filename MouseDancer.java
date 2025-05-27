package org.wania.noidle;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.util.concurrent.TimeUnit;

class MouseDancer {
	
	private static Direction lastDirection = Direction.LEFT;
	
	public void dance(int sleepTime) {
		try {
			TimeUnit.SECONDS.sleep(sleepTime);
			Robot robot = new Robot();
			Point newPosition = getNextPointerPosition();
			robot.mouseMove(newPosition.x, newPosition.y);
			// TODO: Replace it by loger
			System.out.printf("Moved mouse to (%s, %s)%n", newPosition.x, newPosition.y);
		} catch (AWTException | InterruptedException e) {
			// TODO: handle exception
		}
	}

	private static Point getNextPointerPosition() {
		Point position = MouseInfo.getPointerInfo().getLocation();
		switch (lastDirection) {
			case LEFT -> {
				position.y++;
				lastDirection = Direction.UP;
			}
			case RIGHT -> {
				position.y--;
				lastDirection = Direction.DOWN;
			}
			case UP -> {
				position.x++;
				lastDirection = Direction.RIGHT;
			}
			default -> {
				position.x--;
				lastDirection = Direction.LEFT;
			}
		}
		return position;
	}

	private enum Direction {
		LEFT, RIGHT, UP, DOWN
	}

}
