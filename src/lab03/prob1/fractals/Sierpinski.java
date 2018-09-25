package lab03.prob1.fractals;

import hr.fer.oop.lab3.pic.Picture;
import hr.fer.oop.lab3.pic.PictureDisplay;

import java.awt.Point;

public class Sierpinski extends PictureElements {

    public Sierpinski(int iterations, Point a, Point b, Point c){
        super();
        calculateTriangles(iterations, a, b, c);
    }

    private void calculateTriangles(int iterations, Point a, Point b, Point c) {
        if ( iterations <= 1 ){
            addShape(new Triangle(a, b, c));
            return;
        }
        Point ab = midpoint(a, b);
        Point bc = midpoint(b, c);
        Point ca = midpoint(c, a);
        calculateTriangles(iterations -1, a, ab, ca);
        calculateTriangles(iterations -1, ab, b, bc);
        calculateTriangles(iterations -1, ca, bc, c);
    }

    private Point midpoint(Point a, Point b) {
        return new Point((int)(a.getX() + b.getX())/2, (int)(a.getY() + b.getY())/2);
    }

    public static void main(String[] args) {

        Sierpinski sierpinski = new Sierpinski(11,
                new Point(0, 500),
                new Point(1000, 500),
                new Point(500, 0));

        Picture picture = new Picture(1000, 1000 );
        sierpinski.drawOnPicture(picture);
        PictureDisplay.showPicture(picture);

    }

}
