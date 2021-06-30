package gregtech.common;

import gregtech.api.GTValues;
import gregtech.api.unification.material.IMaterial;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.material.type.FluidMaterial;
import gregtech.api.unification.material.type.FluidMaterial.MatFlags;
import gregtech.api.unification.material.type.Material;
import gregtech.api.unification.material.type.SimpleFluidMaterial;
import gregtech.api.util.FluidTooltipUtil;
import gregtech.api.util.GTUtility;
import gregtech.common.blocks.MetaBlocks;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.*;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.commons.lang3.tuple.Pair;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

import static gregtech.api.unification.material.type.FluidMaterial.MatFlags.GENERATE_PLASMA;

public class MetaFluids {

    private static final Set<ResourceLocation> fluidSprites = new HashSet<>();
    private static final Map<String, IMaterial<?>> fluidToMaterialMappings = new HashMap<>();
    private static final Map<String, String> alternativeFluidNames = new HashMap<>();

    public static final ResourceLocation AUTO_GENERATED_FLUID_TEXTURE = new ResourceLocation(
        GTValues.MODID, "blocks/fluids/fluid.molten.autogenerated");
    public static final ResourceLocation AUTO_GENERATED_PLASMA_TEXTURE = new ResourceLocation(
            GTValues.MODID, "blocks/fluids/fluid.plasma.autogenerated");

    private static final Map<Pair<IMaterial<?>, FluidType>, ResourceLocation> fluidTextureMap = new HashMap<>();

    public static final Fluid DISTILLED_WATER = new Fluid("distilled_water",
        new ResourceLocation("blocks/water_still"),
        new ResourceLocation("blocks/water_flow"));

    public enum FluidType {
        NORMAL("", material -> material.hasFlag(MatFlags.STATE_GAS) ? FluidState.GAS : FluidState.LIQUID),
        PLASMA("plasma.", material -> FluidState.PLASMA);

        private final String prefix;
        private final Function<IMaterial<?>, FluidState> stateFunction;

        FluidType(String prefix, Function<IMaterial<?>, FluidState> stateFunction) {
            this.prefix = prefix;
            this.stateFunction = stateFunction;
        }

        public String getFluidName(IMaterial<?> fluidMaterial) {
            return prefix + fluidMaterial.toString();
        }

        public FluidState getFluidState(IMaterial<?> fluidMaterial) {
            return stateFunction.apply(fluidMaterial);
        }
    }

    public enum FluidState {
        LIQUID(null), GAS(null), PLASMA("gregtech.fluid.plasma");

        private final String prefixLocale;

        FluidState(String prefixLocale) {
            this.prefixLocale = prefixLocale;
        }
    }

    public static void registerSprites(TextureMap textureMap) {
        for (ResourceLocation spriteLocation : fluidSprites) {
            textureMap.registerSprite(spriteLocation);
        }
    }

    public static void init() {
        Materials.Water.setMaterialFluid(FluidRegistry.WATER);
        Materials.Lava.setMaterialFluid(FluidRegistry.LAVA);

        FluidRegistry.registerFluid(DISTILLED_WATER);
        Materials.DistilledWater.setMaterialFluid(DISTILLED_WATER);
        fluidSprites.add(AUTO_GENERATED_FLUID_TEXTURE);
        fluidSprites.add(AUTO_GENERATED_PLASMA_TEXTURE);

        FluidTooltipUtil.registerTooltip(FluidRegistry.WATER, FluidTooltipUtil.getWaterTooltip());
        FluidTooltipUtil.registerTooltip(DISTILLED_WATER, FluidTooltipUtil.getWaterTooltip());

        //alternative names for forestry fluids
        setAlternativeFluidName(Materials.Ethanol, FluidType.NORMAL, "bio.ethanol");
        setAlternativeFluidName(Materials.Honey, FluidType.NORMAL, "for.honey");
        setAlternativeFluidName(Materials.SeedOil, FluidType.NORMAL, "seed.oil");
        setAlternativeFluidName(Materials.Ice, FluidType.NORMAL, "fluid.ice");

        setDefaultTexture(Materials.Air, FluidType.NORMAL);
        setDefaultTexture(Materials.Oxygen, FluidType.NORMAL);
        setDefaultTexture(Materials.Hydrogen, FluidType.NORMAL);
        setDefaultTexture(Materials.Deuterium, FluidType.NORMAL);
        setDefaultTexture(Materials.Tritium, FluidType.NORMAL);
        setDefaultTexture(Materials.Helium, FluidType.NORMAL);
        setDefaultTexture(Materials.Helium, FluidType.PLASMA);
        setDefaultTexture(Materials.Helium3, FluidType.NORMAL);
        setDefaultTexture(Materials.Argon, FluidType.NORMAL);
        setDefaultTexture(Materials.Radon, FluidType.NORMAL);
        setDefaultTexture(Materials.Fluorine, FluidType.NORMAL);
        setDefaultTexture(Materials.TitaniumTetrachloride, FluidType.NORMAL);
        setDefaultTexture(Materials.Methane, FluidType.NORMAL);
        setDefaultTexture(Materials.Nitrogen, FluidType.NORMAL);
        setDefaultTexture(Materials.Nitrogen, FluidType.PLASMA);
        setDefaultTexture(Materials.NitrogenDioxide, FluidType.NORMAL);
        setDefaultTexture(Materials.Steam, FluidType.NORMAL);
        setDefaultTexture(Materials.OilHeavy, FluidType.NORMAL);
        setDefaultTexture(Materials.OilMedium, FluidType.NORMAL);
        setDefaultTexture(Materials.OilLight, FluidType.NORMAL);
        setDefaultTexture(Materials.HydrogenSulfide, FluidType.NORMAL);
        setDefaultTexture(Materials.SulfuricGas, FluidType.NORMAL);
        setDefaultTexture(Materials.RefineryGas, FluidType.NORMAL);
        setDefaultTexture(Materials.SulfuricNaphtha, FluidType.NORMAL);
        setDefaultTexture(Materials.SulfuricLightFuel, FluidType.NORMAL);
        setDefaultTexture(Materials.SulfuricHeavyFuel, FluidType.NORMAL);
        setDefaultTexture(Materials.Naphtha, FluidType.NORMAL);
        setDefaultTexture(Materials.LightFuel, FluidType.NORMAL);
        setDefaultTexture(Materials.HeavyFuel, FluidType.NORMAL);
        setDefaultTexture(Materials.LPG, FluidType.NORMAL);
        setDefaultTexture(Materials.SteamCrackedLightFuel, FluidType.NORMAL);
        setDefaultTexture(Materials.SteamCrackedHeavyFuel, FluidType.NORMAL);
        setDefaultTexture(Materials.UUAmplifier, FluidType.NORMAL);
        setDefaultTexture(Materials.Chlorine, FluidType.NORMAL);
        setDefaultTexture(Materials.Mercury, FluidType.NORMAL);
        setDefaultTexture(Materials.NitroDiesel, FluidType.NORMAL);
        setDefaultTexture(Materials.SodiumPersulfate, FluidType.NORMAL);
        setDefaultTexture(Materials.Glyceryl, FluidType.NORMAL);
        setDefaultTexture(Materials.Lubricant, FluidType.NORMAL);
        setDefaultTexture(Materials.Creosote, FluidType.NORMAL);
        setDefaultTexture(Materials.SeedOil, FluidType.NORMAL);
        setDefaultTexture(Materials.Oil, FluidType.NORMAL);
        setDefaultTexture(Materials.Diesel, FluidType.NORMAL);
        setDefaultTexture(Materials.Honey, FluidType.NORMAL);
        setDefaultTexture(Materials.Biomass, FluidType.NORMAL);
        setDefaultTexture(Materials.Ethanol, FluidType.NORMAL);
        setDefaultTexture(Materials.SulfuricAcid, FluidType.NORMAL);
        setDefaultTexture(Materials.Milk, FluidType.NORMAL);
        setDefaultTexture(Materials.McGuffium239, FluidType.NORMAL);
        setDefaultTexture(Materials.Glue, FluidType.NORMAL);
        setDefaultTexture(Materials.HydrochloricAcid, FluidType.NORMAL);
        setDefaultTexture(Materials.LeadZincSolution, FluidType.NORMAL);
        setDefaultTexture(Materials.Epichlorohydrin, FluidType.NORMAL);
        setDefaultTexture(Materials.NaturalGas, FluidType.NORMAL);
        setDefaultTexture(Materials.Blaze, FluidType.NORMAL);
        setDefaultTexture(Materials.Glass, FluidType.NORMAL);
        setDefaultTexture(Materials.Toluene, FluidType.NORMAL);
        setDefaultTexture(Materials.Redstone, FluidType.NORMAL);

        for (Material material : Material.MATERIAL_REGISTRY) {
            if (!(material instanceof FluidMaterial)) continue;
            FluidMaterial fluidMaterial = (FluidMaterial) material;
            if (fluidMaterial.shouldGenerateFluid() && fluidMaterial.getMaterialFluid() == null) {
                int temperature = fluidMaterial.getFluidTemperature();
                Fluid fluid = registerFluid(fluidMaterial, FluidType.NORMAL, temperature);
                fluidMaterial.setMaterialFluid(fluid);
                FluidTooltipUtil.registerTooltip(fluid, fluidMaterial.getChemicalFormula());
            }
            if (fluidMaterial.shouldGeneratePlasma() && fluidMaterial.getMaterialPlasma() == null) {
                Fluid fluid = registerFluid(fluidMaterial, FluidType.PLASMA, 30000);
                fluidMaterial.setMaterialPlasma(fluid);
                FluidTooltipUtil.registerTooltip(fluid, fluidMaterial.getChemicalFormula());
            }
        }
        for (SimpleFluidMaterial material : SimpleFluidMaterial.MATERIAL_REGISTRY) {
            if (material.getMaterialFluid() == null) {
                Fluid fluid = registerFluid(material, FluidType.NORMAL, material.getFluidTemperature());
                material.setMaterialFluid(fluid);
                FluidTooltipUtil.registerTooltip(fluid, material.getChemicalFormula());
            }
            if (material.hasFlag(GENERATE_PLASMA) && material.getMaterialPlasma() == null) {
                Fluid plasma = registerFluid(material, FluidType.PLASMA, 30000);
                material.setMaterialPlasma(plasma);
                FluidTooltipUtil.registerTooltip(plasma, material.getChemicalFormula());
            }
        }
    }

    /**
     * Changes the texture of specified material's fluid.
     * The material color is overlayed on top of the texture, set the materialRGB to 0xFFFFFF to remove the overlay.
     *
     * @param material the material whose texture to change
     * @param fluidType the type of the fluid
     */
    public static void setDefaultTexture(IMaterial<?> material, FluidType fluidType) {
        ResourceLocation resourceLocation = new ResourceLocation(GTValues.MODID, "blocks/fluids/fluid." + material.toString());
        setMaterialFluidTexture(material, fluidType, resourceLocation);
    }

    public static void setMaterialFluidTexture(IMaterial<?> material, FluidType fluidType, ResourceLocation textureLocation) {
        fluidTextureMap.put(Pair.of(material, fluidType), textureLocation);
        fluidSprites.add(textureLocation);
    }

    public static void setAlternativeFluidName(IMaterial<?> material, FluidType fluidType, String alternativeName) {
        alternativeFluidNames.put(fluidType.getFluidName(material), alternativeName);
    }

    public static Fluid registerFluid(IMaterial<?> material, FluidType fluidType, int temperature) {
        String materialName = material.toString();
        String fluidName = fluidType.getFluidName(material);
        Fluid fluid = FluidRegistry.getFluid(fluidName);
        if (fluid == null && alternativeFluidNames.containsKey(fluidName)) {
            String altName = alternativeFluidNames.get(fluidName);
            fluid = FluidRegistry.getFluid(altName);
        }

        if (fluid == null) {
            FluidState fluidState = fluidType.getFluidState(material);
            ResourceLocation textureLocation;
//            if (fluidType.equals(FluidType.PLASMA))
//                textureLocation = fluidTextureMap.getOrDefault(Pair.of(material, fluidType), AUTO_GENERATED_PLASMA_TEXTURE); //todo make plasma and regular texture locations different
//            else
                textureLocation = fluidTextureMap.getOrDefault(Pair.of(material, fluidType), AUTO_GENERATED_FLUID_TEXTURE);
            fluid = new MaterialFluid(fluidName, material, fluidState, textureLocation);
            fluid.setTemperature(temperature);
            if (textureLocation.equals(AUTO_GENERATED_FLUID_TEXTURE) || textureLocation.equals(AUTO_GENERATED_PLASMA_TEXTURE)) {
                fluid.setColor(GTUtility.convertRGBtoOpaqueRGBA_MC(material.getMaterialRGB()));
            }
            setStateProperties(fluid, fluidState);
            FluidRegistry.registerFluid(fluid);
        }

        FluidRegistry.addBucketForFluid(fluid);

        if (material.hasFlag(MatFlags.GENERATE_FLUID_BLOCK) && fluid.getBlock() == null && fluidType != FluidType.PLASMA) {
            BlockFluidBase fluidBlock = new BlockFluidClassic(fluid, net.minecraft.block.material.Material.WATER);
            fluidBlock.setRegistryName("fluid." + materialName);
            MetaBlocks.FLUID_BLOCKS.add(fluidBlock);
        }

        fluidToMaterialMappings.put(fluid.getName(), material);
        return fluid;
    }

    public static IMaterial<?> getIMaterialFromFluid(Fluid fluid) {
        return fluidToMaterialMappings.get(fluid.getName());
    }

    public static FluidMaterial getMaterialFromFluid(Fluid fluid) {
        IMaterial<?> material = fluidToMaterialMappings.get(fluid.getName());
        if (material instanceof FluidMaterial)
            return (FluidMaterial) material;
        return null;
    }

    public static void setStateProperties(Fluid fluid, FluidState fluidState) {
        switch (fluidState) {
            case LIQUID:
                fluid.setGaseous(false);
                fluid.setViscosity(1000);
                break;
            case GAS:
                fluid.setGaseous(true);
                fluid.setDensity(-100);
                fluid.setViscosity(200);
                break;
            case PLASMA:
                fluid.setGaseous(true);
                fluid.setDensity(55536);
                fluid.setViscosity(10);
                fluid.setLuminosity(15);
                break;
        }
    }

    private static class MaterialFluid extends Fluid {

        private final IMaterial<?> material;
        private final FluidState state;

        public MaterialFluid(String fluidName, IMaterial<?> material, FluidState fluidState, ResourceLocation texture) {
            super(fluidName, texture, texture, GTUtility.convertRGBtoOpaqueRGBA_MC(material.getMaterialRGB()));
            this.material = material;
            this.state = fluidState;
        }

        @Override
        public String getUnlocalizedName() {
            return material.getUnlocalizedName();
        }

        @Override
        @SideOnly(Side.CLIENT)
        public String getLocalizedName(FluidStack stack) {
            String localizedName = I18n.format(getUnlocalizedName());
            if (state.prefixLocale != null) {
                return I18n.format(state.prefixLocale, localizedName);
            }
            return localizedName;
        }
    }

}
