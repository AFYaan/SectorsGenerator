package pl.afyaan.sectorsgenerator;

import static org.lwjgl.opengl.GL11.*;

/**
 * @author AFYaan
 * @created 19.11.2021
 * @project SectorsGenerator
 */
public class RenderSectors {
    private final World world;

    public RenderSectors(World world) {
        this.world = world;
    }

    public void renderCenterPoint(){
        glPushMatrix();

        glTranslatef(-0.5f, -0.5f, 0);

        glColor3d(1, 0, 0);
        glBegin(GL_QUADS);
        glVertex2d(0, 0);
        glVertex2d(0, 1);
        glVertex2d(1, 1);
        glVertex2d(1, 0);
        glEnd();

        glPopMatrix();
    }

    public void renderSpawn(){
        Point p1 = world.getSpawn().getPoint1();
        Point p2 = world.getSpawn().getPoint2();
        glPushMatrix();
        glColor3d(1, 1, 1);
        glBegin(GL_LINE_LOOP);
        glVertex2d(p1.getX(), p1.getZ());
        glVertex2d(p2.getX(), p1.getZ());
        glVertex2d(p2.getX(), p2.getZ());
        glVertex2d(p1.getX(), p2.getZ());
        glEnd();

        glPopMatrix();
    }

    public void renderWorldBorder(){
        glPushMatrix();
        glColor3d(1, 1, 1);
        glBegin(GL_LINE_LOOP);
        glVertex2d(-world.getWorldSize(), world.getWorldSize());
        glVertex2d(world.getWorldSize(), world.getWorldSize());
        glVertex2d(world.getWorldSize(), -world.getWorldSize());
        glVertex2d(-world.getWorldSize(), -world.getWorldSize());
        glEnd();

        glPopMatrix();
    }

    public void renderSectors(){
        for(Sector sector : world.getSectors()){
            Point p1 = sector.getPoint1();
            Point p2 = sector.getPoint2();
            glPushMatrix();
            glColor3d(1, 1, 1);
            glBegin(GL_LINE_LOOP);
            glVertex2d(p1.getX(), p1.getZ());
            glVertex2d(p2.getX(), p1.getZ());
            glVertex2d(p2.getX(), p2.getZ());
            glVertex2d(p1.getX(), p2.getZ());
            glEnd();

            glPopMatrix();
        }


    }
}
