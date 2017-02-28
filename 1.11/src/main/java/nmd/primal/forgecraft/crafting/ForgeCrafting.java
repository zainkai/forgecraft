package nmd.primal.forgecraft.crafting;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;

/**
 * Created by mminaie on 2/11/17.
 */
public class ForgeCrafting {

        // ***************************************************************************** //
        //  Recipe Handler ForgeCrafting
        // ***************************************************************************** //
        private static ArrayList<ForgeCrafting> forgeRecipes = new ArrayList<>();

        private Block input;
        private IBlockState start_state;
        private IBlockState end_state;
        private ItemStack output_failed;
        private IBlockState cool_state;

        private int heat_threshold;
        private int ideal_time;
        private int cooldown;


        public ForgeCrafting(Block input, IBlockState startState, IBlockState endState, ItemStack output_failed, IBlockState coolState, int heat_threshold, int ideal_time, int cooldown, float heat_variance, float time_variance)
        {
            this.input = input;
            this.start_state = startState;
            this.end_state = endState;
            this.output_failed = output_failed;
            this.cool_state = coolState;
            this.heat_threshold = heat_threshold;
            this.ideal_time = ideal_time;
            this.cooldown = cooldown;

        }

        // ***************************************************************************** //
        //  Recipe Methods
        // ***************************************************************************** //
        public static void addRecipe(Block input, IBlockState startState, IBlockState endState, ItemStack output_failed, IBlockState coolState, int heat_threshold, int ideal_time, int cooldown, float heat_variance, float time_variance)
        {
            forgeRecipes.add(new ForgeCrafting(input, startState, endState, output_failed, coolState, heat_threshold, ideal_time, cooldown, heat_variance, time_variance));
        }

        public static boolean isRecipeItem(Block block)
        {
            for(ForgeCrafting recipe : forgeRecipes) {
                if (block.equals(recipe.input))
                    return true;
            }
            return false;
        }

        public static boolean isOutputState(IBlockState state)
        {
            for(ForgeCrafting recipe : forgeRecipes) {
                if (state.equals(recipe.end_state))
                    return true;
            }
            return false;
        }

        public static boolean isCoolState(IBlockState coolState)
        {
            for(ForgeCrafting recipe : forgeRecipes) {
                if (coolState.equals(recipe.cool_state))
                    return true;
            }
            return false;
        }

        public static ForgeCrafting getRecipe(Block block)
        {
            for(ForgeCrafting recipe : forgeRecipes) {
                if (block.equals(recipe.input))
                    return recipe;
            }
            return null;
        }

        public static ForgeCrafting getRecipeFromOutput(Block block, IBlockState state)
        {
            for(ForgeCrafting recipe : forgeRecipes) {
                if (block.equals(recipe.input) && state.equals(recipe.end_state))
                    return recipe;
            }
            return null;
        }

        public Block getInput()
        {
            return this.input;
        }

        public IBlockState getStartState() {return this.start_state;}

        public IBlockState getOutput()
        {
            return this.end_state;
        }

        public ItemStack getOutputFailed()
        {
            return this.output_failed;
        }

        public IBlockState getCoolOutput()
        {
            return this.cool_state;
        }

        public int getHeatThreshold()
        {
            return this.heat_threshold;
        }

        public int getIdealTime()
        {
            return this.ideal_time;
        }

        public int getCooldown(){ return this.cooldown;}

        ///
        //  end
        ///




}
