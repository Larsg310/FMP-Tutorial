package larsg310.tutorials.fmp;

import java.util.ArrayList;

import codechicken.lib.raytracer.IndexedCuboid6;
import codechicken.lib.render.CCRenderState;
import codechicken.lib.render.TextureUtils;
import codechicken.lib.vec.Cuboid6;
import codechicken.lib.vec.Rotation;
import codechicken.lib.vec.Vector3;
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
        float width = 2F / 8F;
        for (int index = 0; index < 6; index++)
        {
            boxes.add(new Cuboid6(0.5 - width, 0, 0.5 - width, 0.5 + width, 0.5 - width, 0.5 + width).apply(Rotation.sideRotations[index].at(Vector3.center)));
        }
        boxes.add(new Cuboid6(0.5F - width, 0.5F - width, 0.5F - width, 0.5F + width, 0.5F + width, 0.5F + width));
        return boxes;
    }
    
    public Iterable<Cuboid6> getCollisionBoxes()
    {
        return generateBoxes();
    }
    
    public Iterable<Cuboid6> getOcclusionBoxes()
    {
        ArrayList<Cuboid6> boxes = new ArrayList<Cuboid6>();
        boxes.add(generateBoxes().get(6));
        return boxes;
    }
    
    public Iterable<IndexedCuboid6> getSubParts()
    {
        ArrayList<Cuboid6> cuboids = generateBoxes();
        ArrayList<IndexedCuboid6> indexed = new ArrayList<IndexedCuboid6>();
        for (Cuboid6 cuboid : cuboids)
        {
            indexed.add(new IndexedCuboid6(0, cuboid));
        }
        return indexed;
    }
    
    public boolean renderStatic(Vector3 pos, int pass)
    {
        TextureUtils.bindAtlas(0);
        float uMin = FMPTutorial.examplePipe.sprite.getMinU();
        float uMax = FMPTutorial.examplePipe.sprite.getMaxU();
        float vMin = FMPTutorial.examplePipe.sprite.getMinV();
        float vMax = FMPTutorial.examplePipe.sprite.getMaxV();
        // RENDER STUFF
        return true;
    }
    
    public void renderDynamic(Vector3 pos, float frame, int pass)
    {
        TextureUtils.bindAtlas(0);
        CCRenderState.startDrawing();
        // RENDER STUFF
        CCRenderState.draw();
    }
}
