package lab03.prob1;

import hr.fer.oop.lab3.pic.Picture;
import hr.fer.oop.lab3.pic.PictureDisplay;

public class Demonstration {

    public static void main(String[] args) {

        Picture picture = new Picture(500, 500);
        new EquilateralTriangle(100, 100, 200).drawOnPicture(picture);
        new EquilateralTriangle(450, 500, 150).drawOnPicture(picture);
        PictureDisplay.showPicture(picture);

    }

}
