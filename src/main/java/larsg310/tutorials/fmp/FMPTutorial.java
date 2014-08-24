package larsg310.tutorials.fmp;

import net.minecraft.item.Item;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = FMPTutorial.MODID, name = FMPTutorial.NAME)
public class FMPTutorial
{
    public static final String MODID = "fmptutorial";
    public static final String NAME = "FMPTutorial";
    
    @Instance(MODID)
    public static FMPTutorial instance;
    
    public static Item examplePipe;
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        examplePipe = new ItemPartExamplePipe();
        PartFactory.init();
        GameRegistry.registerItem(examplePipe, "ExamplePipe");
    }
}
