package larsg310.tutorials.fmp;

import codechicken.multipart.MultiPartRegistry;
import codechicken.multipart.MultiPartRegistry.IPartFactory;
import codechicken.multipart.TMultiPart;

public class PartFactory implements IPartFactory
{
    public static void init()
    {
        MultiPartRegistry.registerParts(new PartFactory(), new String[] {"examplePipe"});
    }
    
    @Override
    public TMultiPart createPart(String name, boolean client)
    {
        if(name.equals("examplePipe")) return new ExamplePipe();
        return null;
    }
}
