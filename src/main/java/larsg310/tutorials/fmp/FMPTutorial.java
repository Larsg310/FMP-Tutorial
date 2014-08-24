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
    @SidedProxy(clientSide = "larsg310.tutorials.fmp.ClientProxy", serverSide = "larsg310.tutorials.fmp.CommonProxy")
    public static CommonProxy proxy;
    
    public static Item examplePipe;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        examplePipe = new ItemPartExamplePipe();
        GameRegistry.registerItem(examplePipe, "ExamplePipe");
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.registerRenderers();
        PartFactory.init();
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        
    }
}
