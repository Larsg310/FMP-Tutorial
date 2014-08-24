package larsg310.tutorials.fmp;

import java.util.ArrayList;

import codechicken.lib.raytracer.IndexedCuboid6;
import codechicken.lib.vec.Cuboid6;
import codechicken.multipart.TMultiPart;

public class ExamplePipe extends TMultiPart
{
    @Override
    public String getType()
    {
        return "examplePipe";
    }
    
    public ArrayList<Cuboid6> generateBoxes()
    {
        int w = 2;
        ArrayList<Cuboid6> boxes = new ArrayList<Cuboid6>();
        boxes.add(new Cuboid6(0.5 - (w / 16), 0.5 - (w / 16), 0.5 - (w / 16), 0.5 + (w / 16), 0.5 + (w / 16), 0.5 + (w / 16)));
        return boxes;
    }
    
    public Iterable<Cuboid6> getCollisionBoxes()
    {
        return generateBoxes();
    }
    
    public Cuboid6[] getOcclusionBoxes()
    {
        return generateBoxes().toArray(new Cuboid6[0]);
    }
    
    public Iterable<IndexedCuboid6> getSubParts()
    {
        ArrayList<Cuboid6> cuboids = generateBoxes();
        ArrayList<IndexedCuboid6> indexed = new ArrayList<IndexedCuboid6>();
        indexed.add(new IndexedCuboid6(null, cuboids.get(0)));
        return indexed;
    }
}
