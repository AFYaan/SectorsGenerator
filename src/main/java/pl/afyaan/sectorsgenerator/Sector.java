package pl.afyaan.sectorsgenerator;

/**
 * @author AFYaan
 * @created 19.11.2021
 * @project SectorsGenerator
 */
public class Sector {
    private String name;
    private Point point1; //-+
    private Point point2; //+-

    public Sector() {
    }

    public Sector(String name, Point point1, Point point2) {
        this.name = name;
        this.point1 = point1;
        this.point2 = point2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Point getPoint1() {
        return point1;
    }

    public void setPoint1(Point point1) {
        this.point1 = point1;
    }

    public Point getPoint2() {
        return point2;
    }

    public void setPoint2(Point point2) {
        this.point2 = point2;
    }
}
