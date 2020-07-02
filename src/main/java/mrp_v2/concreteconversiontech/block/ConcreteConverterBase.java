package mrp_v2.concreteconversiontech.block;

import mrp_v2.concreteconversiontech.ConcreteConversionTech;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

abstract public class ConcreteConverterBase extends Block {

	public ConcreteConverterBase(Properties properties, String blockID) {
		super(properties);
		this.setRegistryName(ConcreteConversionTech.MODID, blockID);
	}

	public static final ItemGroup CONCRETE_CONVERSION_TECH_ITEM_GROUP = new ItemGroup(2, "concreteConversionTech") {
		@OnlyIn(Dist.CLIENT)
		public ItemStack createIcon() {
			return new ItemStack(Items.REDSTONE);// TODO Update item reference
		}
	};

	public Item createBlockItem() {
		BlockState defaultState = this.getDefaultState();
		return new BlockItem(this,
				new Item.Properties().addToolType(this.getHarvestTool(defaultState), this.getHarvestLevel(defaultState))
						.group(CONCRETE_CONVERSION_TECH_ITEM_GROUP)).setRegistryName(this.getRegistryName());
	}
}
