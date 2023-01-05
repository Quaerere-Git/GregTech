package gregtech.loaders.recipe;

import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.material.Materials;

import static gregtech.api.GTValues.*;

public class FusionLoader {

    public static void init() {

        RecipeMaps.FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Materials.Deuterium.getFluid(125))
                .fluidInputs(Materials.Tritium.getFluid(125))
                .fluidOutputs(Materials.Helium.getPlasma(125))
                .duration(16)
                .EUt(4096)
                .EUToStart(40_000_000)
                .buildAndRegister();

        RecipeMaps.FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Materials.Carbon.getFluid(18))
                .fluidInputs(Materials.Helium3.getFluid(125))
                .fluidOutputs(Materials.Oxygen.getPlasma(125))
                .duration(32)
                .EUt(4096)
                .EUToStart(180_000_000)
                .buildAndRegister();

        RecipeMaps.FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Materials.Beryllium.getFluid(18))
                .fluidInputs(Materials.Deuterium.getFluid(375))
                .fluidOutputs(Materials.Nitrogen.getPlasma(125))
                .duration(16)
                .EUt(16384)
                .EUToStart(280_000_000)
                .buildAndRegister();

        RecipeMaps.FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Materials.Silicon.getFluid(18))
                .fluidInputs(Materials.Magnesium.getFluid(18))
                .fluidOutputs(Materials.Iron.getPlasma(18))
                .duration(32)
                .EUt(VA[IV])
                .EUToStart(360_000_000)
                .buildAndRegister();

        RecipeMaps.FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Materials.Potassium.getFluid(18))
                .fluidInputs(Materials.Fluorine.getFluid(125))
                .fluidOutputs(Materials.Nickel.getPlasma(18))
                .duration(16)
                .EUt(VA[LuV])
                .EUToStart(480_000_000)
                .buildAndRegister();

        RecipeMaps.FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Materials.Carbon.getFluid(18))
                .fluidInputs(Materials.Magnesium.getFluid(18))
                .fluidOutputs(Materials.Argon.getPlasma(125))
                .duration(32)
                .EUt(24576)
                .EUToStart(180_000_000)
                .buildAndRegister();

        RecipeMaps.FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Materials.Neodymium.getFluid(18))
                .fluidInputs(Materials.Hydrogen.getFluid(375))
                .fluidOutputs(Materials.Europium.getFluid(18))
                .duration(64)
                .EUt(24576)
                .EUToStart(150_000_000)
                .buildAndRegister();

        RecipeMaps.FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Materials.Lutetium.getFluid(36))
                .fluidInputs(Materials.Chrome.getFluid(36))
                .fluidOutputs(Materials.Americium.getFluid(36))
                .duration(64)
                .EUt(49152)
                .EUToStart(200_000_000)
                .buildAndRegister();

        RecipeMaps.FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Materials.Americium.getFluid(144))
                .fluidInputs(Materials.Naquadria.getFluid(144))
                .fluidOutputs(Materials.Neutronium.getFluid(36))
                .duration(200)
                .EUt(98304)
                .EUToStart(600_000_000)
                .buildAndRegister();

        RecipeMaps.FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Materials.Molybdenum.getFluid(18))
                .fluidInputs(Materials.Tritium.getFluid(250))
                .fluidOutputs(Materials.Ruthenium.getFluid(18))
                .duration(48)
                .EUt(24578)
                .EUToStart(150_000_000)
                .buildAndRegister();

        RecipeMaps.FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Materials.Silver.getFluid(18))
                .fluidInputs(Materials.Copper.getFluid(18))
                .fluidOutputs(Materials.Osmium.getFluid(18))
                .duration(64)
                .EUt(24578)
                .EUToStart(150_000_000)
                .buildAndRegister();

        RecipeMaps.FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Materials.Osmium.getFluid(18))
                .fluidInputs(Materials.Deuterium.getFluid(125))
                .fluidOutputs(Materials.Iridium.getFluid(18))
                .duration(48)
                .EUt(30720)
                .EUToStart(150_000_000)
                .buildAndRegister();

        RecipeMaps.FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Materials.Mercury.getFluid(125))
                .fluidInputs(Materials.Magnesium.getFluid(18))
                .fluidOutputs(Materials.Uranium235.getFluid(18))
                .duration(128)
                .EUt(24576)
                .EUToStart(140_000_000)
                .buildAndRegister();

        RecipeMaps.FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Materials.Gold.getFluid(18))
                .fluidInputs(Materials.Aluminium.getFluid(18))
                .fluidOutputs(Materials.Uranium238.getFluid(18))
                .duration(128)
                .EUt(24576)
                .EUToStart(140_000_000)
                .buildAndRegister();

        RecipeMaps.FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Materials.Xenon.getFluid(125))
                .fluidInputs(Materials.Zinc.getFluid(18))
                .fluidOutputs(Materials.Plutonium239.getFluid(18))
                .duration(128)
                .EUt(49152)
                .EUToStart(120_000_000)
                .buildAndRegister();

        RecipeMaps.FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Materials.Krypton.getFluid(125))
                .fluidInputs(Materials.Cerium.getFluid(18))
                .fluidOutputs(Materials.Plutonium241.getFluid(18))
                .duration(128)
                .EUt(49152)
                .EUToStart(240_000_000)
                .buildAndRegister();

        RecipeMaps.FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Materials.Hydrogen.getFluid(125))
                .fluidInputs(Materials.Vanadium.getFluid(18))
                .fluidOutputs(Materials.Chrome.getFluid(18))
                .duration(64)
                .EUt(24576)
                .EUToStart(140_000_000)
                .buildAndRegister();

        RecipeMaps.FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Materials.Gallium.getFluid(18))
                .fluidInputs(Materials.Radon.getFluid(125))
                .fluidOutputs(Materials.Duranium.getFluid(18))
                .duration(64)
                .EUt(16384)
                .EUToStart(140_000_000)
                .buildAndRegister();

        RecipeMaps.FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Materials.Titanium.getFluid(54))
                .fluidInputs(Materials.Duranium.getFluid(18))
                .fluidOutputs(Materials.Tritanium.getFluid(18))
                .duration(64)
                .EUt(VA[LuV])
                .EUToStart(200_000_000)
                .buildAndRegister();

        RecipeMaps.FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Materials.Gold.getFluid(18))
                .fluidInputs(Materials.Mercury.getFluid(125))
                .fluidOutputs(Materials.Radon.getFluid(125))
                .duration(64)
                .EUt(VA[LuV])
                .EUToStart(200_000_000)
                .buildAndRegister();

        RecipeMaps.FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Materials.Silver.getFluid(144))
                .fluidInputs(Materials.Lithium.getFluid(144))
                .fluidOutputs(Materials.Indium.getFluid(144))
                .duration(16)
                .EUt(24576)
                .EUToStart(280_000_000)
                .buildAndRegister();

        RecipeMaps.FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Materials.NaquadahEnriched.getFluid(36))
                .fluidInputs(Materials.Radon.getFluid(250))
                .fluidOutputs(Materials.Naquadria.getFluid(9))
                .duration(64)
                .EUt(49152)
                .EUToStart(400_000_000)
                .buildAndRegister();

        RecipeMaps.FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Materials.Lanthanum.getFluid(18))
                .fluidInputs(Materials.Silicon.getFluid(18))
                .fluidOutputs(Materials.Lutetium.getFluid(18))
                .duration(16)
                .EUt(VA[IV])
                .EUToStart(80_000_000)
                .buildAndRegister();

        RecipeMaps.FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Materials.Arsenic.getFluid(36))
                .fluidInputs(Materials.Ruthenium.getFluid(18))
                .fluidOutputs(Materials.Darmstadtium.getFluid(18))
                .duration(32)
                .EUt(VA[LuV])
                .EUToStart(200_000_000)
                .buildAndRegister();

    }
}
