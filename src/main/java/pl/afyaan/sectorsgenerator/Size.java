package pl.afyaan.sectorsgenerator;

/**
 * @author AFYaan
 * @created 19.11.2021
 * @project SectorsGenerator
 */
public class Size {
    private double width;
    private double height;

    public Size() {
    }

    public Size(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}