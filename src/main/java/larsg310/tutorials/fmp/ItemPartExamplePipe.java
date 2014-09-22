package larsg310.tutorials.fmp;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import codechicken.lib.vec.BlockCoord;
import codechicken.lib.vec.Vector3;
import codechicken.multipart.JItemMultiPart;
import codechicken.multipart.MultiPartRegistry;
import codechicken.multipart.TMultiPart;

public class ItemPartExamplePipe extends JItemMultiPart
{
    public IIcon sprite;
    
    public ItemPartExamplePipe()
    {
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setUnlocalizedName("ExamplePipe");
    }
    
    @Override
    public double getHitDepth(Vector3 vec3, int side)
    {
        return 0;
    }
    
    @Override
    public TMultiPart newPart(ItemStack itemstack, EntityPlayer player, World world, BlockCoord blockCoord, int side, Vector3 vec3)
    {
        return MultiPartRegistry.createPart("examplePipe", false);
    }
    
    public void registerIcons(IIconRegister reg)
    {
        sprite = reg.registerIcon(FMPTutorial.MODID + ":parts/examplePart");
    }
    
    public int getSpriteNumber()
    {
        return 0;
    }
}
