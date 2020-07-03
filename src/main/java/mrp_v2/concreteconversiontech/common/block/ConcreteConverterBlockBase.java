package mrp_v2.concreteconversiontech.common.block;

import mrp_v2.concreteconversiontech.common.util.CCTConstants;
import mrp_v2.concreteconversiontech.common.util.CCTObjectHolder;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolType;

abstract public class ConcreteConverterBlockBase extends Block {

	protected static final String ID_STEM = "concrete_converter_block_";

	public static final ItemGroup CONCRETE_CONVERSION_TECH_ITEM_GROUP = new ItemGroup(2, "concreteConversionTech") {
		@OnlyIn(Dist.CLIENT)
		public ItemStack createIcon() {
			return new ItemStack(CCTObjectHolder.CONCRETE_CONVERTER_BLOCK_TIER_1);
		}
	};

	public ConcreteConverterBlockBase(Block base, String blockID) {
		super(Properties.from(base));
		this.setRegistryName(CCTConstants.MODID, blockID);
	}

	public ConcreteConverterBlockBase(Material material, MaterialColor color, ToolType harvestTool, int harvestLevel,
			float hardness, float resistance, SoundType sound, String blockID) {
		super(Properties.create(material, color).harvestTool(harvestTool).harvestLevel(harvestLevel)
				.hardnessAndResistance(hardness, resistance).sound(sound));
		this.setRegistryName(CCTConstants.MODID, blockID);
	}

	public BlockItem createBlockItem() {
		BlockState defaultState = this.getDefaultState();
		BlockItem bi = new BlockItem(this,
				new Item.Properties().addToolType(this.getHarvestTool(defaultState), this.getHarvestLevel(defaultState))
						.group(CONCRETE_CONVERSION_TECH_ITEM_GROUP));
		bi.setRegistryName(this.getRegistryName());
		return bi;
	}

	@Override
	abstract public TileEntity createTileEntity(BlockState state, IBlockReader world);

	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}
}
