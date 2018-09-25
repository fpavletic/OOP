package lab03.prob1;

import hr.fer.oop.lab3.pic.Picture;

public class EquilateralTriangle {

    private int startingX;
    private int startingY;
    private int len;

    private double height;
    private boolean[][] pixels;

    public EquilateralTriangle(int startingX, int startingY, int len) {
        this.startingX = startingX;
        this.startingY = startingY;
        this.len = len;
        height = len * Math.sqrt(3) / 2;
    }

    public EquilateralTriangle( EquilateralTriangle other ){
        this(other.startingX, other.startingY, other.len);
    }

    public void drawOnPicture(Picture picture){

        for ( int i = 0; i < picture.getWidth(); i++ ){
            for ( int j = 0; j < picture.getHeight(); j++){
                if (isInTriangle(i, j)){
                    picture.turnPixelOn(i, j);
                }
            }
        }

    }

    private boolean isInTriangle(int i, int j) {

        if ( pixels == null ){
            calculatePixels();
        }
        try {
            return pixels[i][j];
        } catch (IndexOutOfBoundsException ioobe){
            return false;
        }

    }

    private void calculatePixels() {


        pixels = new boolean[startingX + len > 0 ? startingX + len : 1 ][startingY > 0 ? startingY : 1];

        for ( int j = 0; j < height && startingY - j - 1>= 0; j++ ){

            int start = (int)(j * ( 1 - Math.tan(60)));
            for ( int i = startingX + start - 1 >= 0 ? start : -startingX +1; i < len - start; i++ ){

                pixels[startingX + i - 1][startingY - j - 1] = true;
            }
        }
    }
}
