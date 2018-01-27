package info.zthings.mcmods.brg;

import com.grim3212.mc.pack.tools.items.ItemAdvRayg;
import com.grim3212.mc.pack.tools.items.ItemRayg;

import lumien.bloodmoon.server.BloodmoonHandler;
import net.minecraft.util.EnumActionResult;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = BloodMoonRaygunMod.MODID, version = BloodMoonRaygunMod.VERSION)
public class BloodMoonRaygunMod {
	public static final String MODID = "brg";
	public static final String VERSION = "1.0";
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	@SubscribeEvent
	public void cancelRaygun(PlayerInteractEvent.RightClickItem e) {
		if ((e.getItemStack().getItem() instanceof ItemRayg || e.getItemStack().getItem() instanceof ItemAdvRayg) && !BloodmoonHandler.INSTANCE.isBloodmoonActive()) {
			e.setCancellationResult(EnumActionResult.FAIL);
			e.setCanceled(true);
		}
	}
}
