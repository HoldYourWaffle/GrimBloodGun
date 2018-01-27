package info.zthings.mcmods.PLACEMODIDHERE;

import info.zthings.mcmods.PLACEMODIDHERE.lazy.ModHandler;
import info.zthings.mcmods.PLACEMODIDHERE.proxy.CommonProxy;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = ExampleMod.MODID, version = ExampleMod.VERSION)
public class ExampleMod {
	@Instance
	public static ExampleMod instance;
	@SidedProxy(serverSide = "info.zthings.mcmods.PLACEMODIDHERE.proxy.CommonProxy", clientSide = "info.zthings.mcmods.PLACEMODIDHERE.proxy.ClientProxy")
	public static CommonProxy proxy;
	
	public static final String MODID = "examplemod";
	public static final String VERSION = "1.0";
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(this);
		MinecraftForge.EVENT_BUS.register(new ModHandler());
		
		//STUB register items using ModItems.register(...)
		//STUB register blocks using ModBlocks.register(...)
	}
}
