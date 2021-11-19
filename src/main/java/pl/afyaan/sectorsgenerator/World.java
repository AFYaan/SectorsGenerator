package pl.afyaan.sectorsgenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author AFYaan
 * @created 19.11.2021
 * @project SectorsGenerator
 */
public class World {
    private int worldSize;
    private int spawnSize;
    private Sector spawn;
    public List<Sector> sectors = new ArrayList<>();
    private Size sectorSize;
    private int sectorsInRow;

    public World(int worldSize, int spawnSize, int sectorsInRow) {
        this.worldSize = worldSize;
        this.spawnSize = spawnSize;
        this.spawn = new Sector(new Point(-spawnSize, spawnSize), new Point(spawnSize, -spawnSize));
        this.sectorsInRow = sectorsInRow;
        this.sectorSize = calculateSectorSize();
        recalculateSectors();
    }

    private Size calculateSectorSize(){
        int width = (worldSize - spawnSize) / (sectorsInRow / 2);
        int height = (worldSize + spawnSize) / (sectorsInRow);
        return new Size(width, height);
    }

    private void recalculateSectors(){
        recalculateWideSectors(-worldSize, worldSize); // 1
        recalculateNarrowSectors(-spawnSize, worldSize); // 2
        recalculateWideSectors(spawnSize, spawnSize);  //3
        recalculateNarrowSectors(-worldSize, -spawnSize); //4

        System.out.println("Generated sectors: " + sectors.size());

        int i = 1;
        Thread thread = new Thread(()->{
            for(Sector sector : sectors){
                System.out.println("(s" + i + ")");
                System.out.println("    (Point1)\n  X: " + sector.point1.getX() + "\n   Z: " + sector.point1.getZ());
                System.out.println("    (Point2)\n  X: " + sector.point2.getX() + "\n   Z: " + sector.point2.getZ());
            }
        });
        //thread.start();
    }

    private void recalculateWideSectors(int xStart, int zStart){
        int x = xStart;
        int z = zStart;
        for(int j = 0; j < sectorsInRow / 2; j++) {
            for (int i = 0; i < sectorsInRow; i++) {
                Sector sector = new Sector(new Point(x, z), new Point(x + sectorSize.getWidth(), z - sectorSize.getHeight()));
                sectors.add(sector);

                z -= sectorSize.getHeight();
            }
            z = zStart;
            x += sectorSize.getWidth();
        }
    }

    private void recalculateNarrowSectors(int xStart, int zStart){
        int x = xStart;
        int z = zStart;
        for(int j = 0; j < sectorsInRow / 2; j++) {
            for (int i = 0; i < sectorsInRow; i++) {
                Sector sector = new Sector(new Point(x, z), new Point(x + sectorSize.getHeight(), z - sectorSize.getWidth()));
                sectors.add(sector);

                x += sectorSize.getHeight();
            }
            z -= sectorSize.getWidth();
            x = xStart;
        }
    }

    public int getWorldSize() {
        return worldSize;
    }

    public int getSpawnSize() {
        return spawnSize;
    }

    public Sector getSpawn() {
        return spawn;
    }

    public List<Sector> getSectors() {
        return sectors;
    }

    public Size getSectorSize() {
        return sectorSize;
    }
}
