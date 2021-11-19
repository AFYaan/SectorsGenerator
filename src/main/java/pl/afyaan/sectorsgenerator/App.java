package pl.afyaan.sectorsgenerator;

/**
 * @author AFYaan
 * @created 19.11.2021
 * @project SectorsGenerator
 */
public class App {
    public static SectorsGenerator sectorsGenerator;

    public static void main(String[] args) {
        World world = new World(6000, 300, 4);
        sectorsGenerator = new SectorsGenerator(1366, 900, world);
        sectorsGenerator.run();
    }
}
