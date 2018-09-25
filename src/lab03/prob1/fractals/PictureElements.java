package lab03.prob1.fractals;

import hr.fer.oop.lab3.pic.Picture;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PictureElements implements Drawable {

    private List<Drawable> shapes;

    public PictureElements ( List<Drawable> shapes ){
        if (shapes == null ){
            this.shapes = new ArrayList<>();
        } else {
            this.shapes = shapes;
        }
    }

    public PictureElements ( Drawable... shapes ){
        this (Arrays.asList(shapes));
    }

    public PictureElements (){
        this((List<Drawable>)null);
    }

    public void addShape ( Drawable shape ){
        shapes.add(shape);
    }

    public void clear (){
        shapes.clear();
    }

    @Override
    public void drawOnPicture(Picture picture) {
        for ( Drawable shape : shapes ) {
            shape.drawOnPicture(picture);
        }
    }
}
