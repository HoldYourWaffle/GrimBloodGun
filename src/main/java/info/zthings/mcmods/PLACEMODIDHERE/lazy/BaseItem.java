package info.zthings.mcmods.PLACEMODIDHERE.lazy;

import net.minecraft.item.Item;

public class BaseItem extends Item {
	
	public final String name;

	public BaseItem(String name) {
		this.name = name;
		setUnlocalizedName(name);
		setRegistryName(name);
	}
}
