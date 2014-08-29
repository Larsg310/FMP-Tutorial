package larsg310.tutorials.fmp;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import codechicken.lib.vec.BlockCoord;
import codechicken.lib.vec.Vector3;
import codechicken.multipart.MultiPartRegistry;
import codechicken.multipart.TItemMultiPart;
import codechicken.multipart.TMultiPart;

public class ItemPartExamplePipe extends Item implements TItemMultiPart
{
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
        System.out.println("newPart called!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        return MultiPartRegistry.createPart("examplePipe", false);
    }
    
}
