package larsg310.tutorials.fmp;

import java.util.ArrayList;

import codechicken.lib.raytracer.IndexedCuboid6;
import codechicken.lib.vec.Cuboid6;
import codechicken.multipart.TMultiPart;
import codechicken.multipart.TNormalOcclusion;

public class ExamplePipe extends TMultiPart implements TNormalOcclusion
{
    public static final String type = "examplePipe";
    
    @Override
    public String getType()
    {
        return type;
    }
    
    public ArrayList<Cuboid6> generateBoxes()
    {
        ArrayList<Cuboid6> boxes = new ArrayList<Cuboid6>();
        boxes.add(new Cuboid6(0.375, 0.375, 0.375, 0.625, 0.625, 0.625));
        return boxes;
    }
    
    public Iterable<Cuboid6> getCollisionBoxes()
    {
        return generateBoxes();
    }
    
    public Iterable<Cuboid6> getOcclusionBoxes()
    {
        return generateBoxes();
    }
    
    public Iterable<IndexedCuboid6> getSubParts()
    {
        ArrayList<Cuboid6> cuboids = generateBoxes();
        ArrayList<IndexedCuboid6> indexed = new ArrayList<IndexedCuboid6>();
        for (Cuboid6 cuboid : cuboids)
        {
            indexed.add(new IndexedCuboid6(0, cuboids.get(0)));
        }
        return indexed;
    }
}
