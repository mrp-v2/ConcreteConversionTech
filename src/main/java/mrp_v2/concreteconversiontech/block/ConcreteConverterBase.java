package mrp_v2.concreteconversiontech.block;

import mrp_v2.concreteconversiontech.util.CCTConstants;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolType;

abstract public class ConcreteConverterBase extends Block {

	public static final String ID_STEM = "concrete_converter_";

	public ConcreteConverterBase(Material material, MaterialColor color, ToolType harvestTool, int harvestLevel,
			float hardness, float resistance, SoundType sound, String blockID) {
		super(Properties.create(material, color).harvestTool(harvestTool).harvestLevel(harvestLevel)
				.hardnessAndResistance(hardness, resistance).sound(sound));
		this.setRegistryName(CCTConstants.MODID, blockID);
	}

	public ConcreteConverterBase(Block base, String blockID) {
		super(Properties.from(base));
		this.setRegistryName(CCTConstants.MODID, blockID);
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
