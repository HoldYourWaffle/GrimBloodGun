package info.zthings.mcmods.PLACEMODIDHERE.lazy;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;

public class BaseBlock extends Block {
	
	public final String name;
	public final ItemBlock item;

	public BaseBlock(Material material, String name) {
		super(material);
		
		this.name = name;
		this.item = new ItemBlock(this);
		this.item.setRegistryName(name);
		
		setUnlocalizedName(name);
		setRegistryName(name);
	}
	
}
