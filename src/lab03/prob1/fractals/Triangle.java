package lab03.prob1.fractals;

import hr.fer.oop.lab3.pic.Picture;

import java.awt.*;

public class Triangle implements Drawable {
    private Polygon triangle;

    public Triangle(Point a, Point b, Point c) {
        triangle = new Polygon();
        triangle.addPoint((int) a.getX(), (int) a.getY());
        triangle.addPoint((int) b.getX(), (int) b.getY());
        triangle.addPoint((int) c.getX(), (int) c.getY());
    }

    @Override
    public void drawOnPicture(Picture picture) {
        for (int x = 0; x < picture.getWidth(); x++) {
            for (int y = 0; y < picture.getHeight(); ++y) {
                if (triangle.contains(x, y))
                    picture.turnPixelOn(x, y);
            }
        }
    }
}
