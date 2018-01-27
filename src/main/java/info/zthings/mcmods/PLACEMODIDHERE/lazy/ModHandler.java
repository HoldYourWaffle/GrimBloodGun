package info.zthings.mcmods.PLACEMODIDHERE.lazy;

import java.util.ArrayList;

import info.zthings.mcmods.PLACEMODIDHERE.ExampleMod;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ModHandler {
	public static class ModItems {
		private static ArrayList<ItemWrapper> items = new ArrayList<>();
		
		public static void register(BaseItem item) { items.add(new ItemWrapper(item)); }
		
		@SubscribeEvent
		public void registerItems(RegistryEvent.Register<Item> ev) {
			for (ItemWrapper bi : items) ev.getRegistry().register(bi.item);
		}
		
		@SubscribeEvent
		public void registerModels(ModelRegistryEvent ev) {
			for (ItemWrapper bi : items) ExampleMod.proxy.registerItemRenderer(bi.item, 0, bi.name);
		}
	}
	
	public static class ModBlocks {
		private static ArrayList<BaseBlock> blocks = new ArrayList<>();
		
		public static void register(BaseBlock block) {
			blocks.add(block);
			ModItems.items.add(new ItemWrapper(block));
		}
		
		@SubscribeEvent
		public void registerBlocks(RegistryEvent.Register<Block> ev) {
			for (BaseBlock bb : blocks) ev.getRegistry().register(bb);
		}
		
		
		@SubscribeEvent
		public void registerItemModels(ModelRegistryEvent ev) {
			for (BaseBlock bb : blocks) ExampleMod.proxy.registerItemRenderer(bb.item, 0, bb.name);
		}
	}
	
	private static class ItemWrapper {
		public final Item item;
		private final String name;

		public ItemWrapper(BaseItem item) {
			this.item = item;
			this.name = item.name;
		}

		public ItemWrapper(BaseBlock block) {
			this.item = block.item;
			this.name = block.name;
		}
	}
}
