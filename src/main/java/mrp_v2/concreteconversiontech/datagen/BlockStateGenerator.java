package mrp_v2.concreteconversiontech.datagen;

import mrp_v2.concreteconversiontech.block.ConcreteConverterBlock;
import mrp_v2.concreteconversiontech.util.ObjectHolder;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelBuilder;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.apache.commons.lang3.tuple.Pair;

public class BlockStateGenerator extends BlockStateProvider
{
    public static final String BASE_CONVERTER_NAME = "concrete_converter";

    public BlockStateGenerator(DataGenerator gen, String modid, ExistingFileHelper exFileHelper)
    {
        super(gen, modid, exFileHelper);
    }

    @Override protected void registerStatesAndModels()
    {
        ModelFile converterBaseModel = makeConverterBaseModel();
        makeConcreteConverterModel(ObjectHolder.CONCRETE_CONVERTER_TIER_1_BLOCK, converterBaseModel);
        makeConcreteConverterModel(ObjectHolder.CONCRETE_CONVERTER_TIER_2_BLOCK, converterBaseModel);
        makeConcreteConverterModel(ObjectHolder.CONCRETE_CONVERTER_TIER_3_BLOCK, converterBaseModel);
        makeConcreteConverterModel(ObjectHolder.CONCRETE_CONVERTER_TIER_4_BLOCK, converterBaseModel);
        makeConcreteConverterModel(ObjectHolder.CONCRETE_CONVERTER_TIER_5_BLOCK, converterBaseModel);
        makeConcreteConverterModel(ObjectHolder.CONCRETE_CONVERTER_TIER_6_BLOCK, converterBaseModel);
        makeConcreteConverterModel(ObjectHolder.CONCRETE_CONVERTER_TIER_7_BLOCK, converterBaseModel,
                mcLoc("block/quartz_block_side"));
        makeConcreteConverterModel(ObjectHolder.CONCRETE_CONVERTER_TIER_8_BLOCK, converterBaseModel);
    }

    private ModelFile makeConverterBaseModel()
    {
        ModelBuilder<BlockModelBuilder> builder = this.models()
                .withExistingParent(BASE_CONVERTER_NAME, mcLoc("block/block"))
                .texture("glass", "block/glass_small")
                .texture("water", mcLoc("block/water_still"))
                .texture("particle", "#base");
        makeElement(builder, 0, 0, 0, 16, 2, 2,
                new Direction[]{Direction.DOWN, Direction.NORTH, Direction.EAST, Direction.WEST}, "#base",
                Pair.of(Direction.UP, Direction.NORTH), Pair.of(Direction.SOUTH, Direction.DOWN));
        makeElement(builder, 0, 0, 14, 16, 2, 16,
                new Direction[]{Direction.DOWN, Direction.EAST, Direction.SOUTH, Direction.WEST}, "#base",
                Pair.of(Direction.UP, Direction.SOUTH), Pair.of(Direction.NORTH, Direction.DOWN));
        makeElement(builder, 0, 14, 0, 16, 16, 2,
                new Direction[]{Direction.UP, Direction.NORTH, Direction.EAST, Direction.WEST}, "#base",
                Pair.of(Direction.DOWN, Direction.NORTH), Pair.of(Direction.SOUTH, Direction.UP));
        makeElement(builder, 0, 14, 14, 16, 16, 16,
                new Direction[]{Direction.UP, Direction.EAST, Direction.SOUTH, Direction.WEST}, "#base",
                Pair.of(Direction.DOWN, Direction.SOUTH), Pair.of(Direction.NORTH, Direction.UP));
        makeElement(builder, 0, 0, 2, 2, 2, 14, new Direction[]{Direction.DOWN, Direction.WEST}, "#base",
                Pair.of(Direction.UP, Direction.WEST), Pair.of(Direction.EAST, Direction.DOWN));
        makeElement(builder, 0, 14, 2, 2, 16, 14, new Direction[]{Direction.UP, Direction.WEST}, "#base",
                Pair.of(Direction.DOWN, Direction.WEST), Pair.of(Direction.EAST, Direction.UP));
        makeElement(builder, 14, 0, 2, 16, 2, 14, new Direction[]{Direction.DOWN, Direction.EAST}, "#base",
                Pair.of(Direction.UP, Direction.EAST), Pair.of(Direction.WEST, Direction.DOWN));
        makeElement(builder, 14, 14, 2, 16, 16, 14, new Direction[]{Direction.UP, Direction.EAST}, "#base",
                Pair.of(Direction.DOWN, Direction.EAST), Pair.of(Direction.WEST, Direction.UP));
        makeElement(builder, 14, 2, 0, 16, 14, 2, new Direction[]{Direction.NORTH, Direction.EAST}, "#base",
                Pair.of(Direction.SOUTH, Direction.EAST), Pair.of(Direction.WEST, Direction.NORTH));
        makeElement(builder, 0, 2, 0, 2, 14, 2, new Direction[]{Direction.NORTH, Direction.WEST}, "#base",
                Pair.of(Direction.EAST, Direction.NORTH), Pair.of(Direction.SOUTH, Direction.WEST));
        makeElement(builder, 14, 2, 14, 16, 14, 16, new Direction[]{Direction.EAST, Direction.SOUTH}, "#base",
                Pair.of(Direction.NORTH, Direction.EAST), Pair.of(Direction.WEST, Direction.SOUTH));
        makeElement(builder, 0, 2, 14, 2, 14, 16, new Direction[]{Direction.SOUTH, Direction.WEST}, "#base",
                Pair.of(Direction.NORTH, Direction.WEST), Pair.of(Direction.EAST, Direction.SOUTH));
        makeElement(builder, 0, 0, 0, 16, 16, 16, new Direction[]{Direction.NORTH,
                Direction.EAST,
                Direction.SOUTH,
                Direction.WEST,
                Direction.UP,
                Direction.DOWN}, "#glass");
        makeElement(builder, 2, 2, 2, 14, 14, 14, new Direction[]{Direction.NORTH,
                Direction.EAST,
                Direction.SOUTH,
                Direction.WEST,
                Direction.UP,
                Direction.DOWN}, "#water").faces((face, elementBuilder) -> elementBuilder.tintindex(0));
        return builder;
    }

    @SafeVarargs
    private final ModelBuilder<BlockModelBuilder>.ElementBuilder makeElement(ModelBuilder<BlockModelBuilder> builder,
            int x1, int y1, int z1, int x2, int y2, int z2, Direction[] normalFaces, String texture,
            Pair<Direction, Direction>... abnormalFaces)
    {
        ModelBuilder<BlockModelBuilder>.ElementBuilder elementBuilder =
                builder.element().from(x1, y1, z1).to(x2, y2, z2);
        for (Direction face : normalFaces)
        {
            makeFace(elementBuilder, face, texture);
        }
        for (Pair<Direction, Direction> face : abnormalFaces)
        {
            makeFace(elementBuilder, face.getLeft(), face.getRight(), texture);
        }
        return elementBuilder;
    }

    private void makeFace(ModelBuilder<BlockModelBuilder>.ElementBuilder builder, Direction face, String texture)
    {
        makeFace(builder, face, face, texture);
    }

    private void makeFace(ModelBuilder<BlockModelBuilder>.ElementBuilder builder, Direction face, Direction cullFace,
            String texture)
    {
        builder.face(face).cullface(cullFace).texture(texture);
    }

    private void makeConcreteConverterModel(ConcreteConverterBlock block, ModelFile model)
    {
        makeConcreteConverterModel(block, model, mcLoc("block/" + block.base.getRegistryName().getPath()));
    }

    private void makeConcreteConverterModel(ConcreteConverterBlock block, ModelFile model, ResourceLocation texture)
    {
        ModelFile newModel = this.models()
                .withExistingParent(block.getRegistryName().getPath(), model.getLocation())
                .texture("base", texture);
        this.simpleBlock(block, newModel);
        this.simpleBlockItem(block, newModel);
    }
}
