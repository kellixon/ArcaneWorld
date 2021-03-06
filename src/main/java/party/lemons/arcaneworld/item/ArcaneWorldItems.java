package party.lemons.arcaneworld.item;


import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;
import party.lemons.arcaneworld.ArcaneWorld;
import party.lemons.arcaneworld.crafting.ArcaneWorldTab;
import party.lemons.arcaneworld.item.impl.*;
import party.lemons.arcaneworld.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sam on 30/08/2018.
 */
@Mod.EventBusSubscriber(modid = ArcaneWorld.MODID)
@GameRegistry.ObjectHolder(ArcaneWorld.MODID)
public class ArcaneWorldItems
{
	public static List<Item> itemList = new ArrayList<>();
	private static List<Pair<Item, String[]>> oreDict = new ArrayList<>();

	public static final Item ARCANE_HOE = Items.AIR;
	public static final Item FANG_WAND = Items.AIR;
	public static final Item SAPPHIRE = Items.AIR;
	public static final Item AMETHYST = Items.AIR;
	public static final Item GLOWING_CHORUS = Items.AIR;
	public static final Item BIOME_CRYSTAL = Items.AIR;
	public static final Item RITUAL_SCROLL = Items.AIR;
    public static final Item RECALLER = Items.AIR;
    public static final Item RECALL_EYE = Items.AIR;
    public static final Item MOLTEN_CORE = Items.AIR;
    public static final Item MOLTEN_PICKAXE = Items.AIR;
    public static final Item MOLTEN_SHOVEL = Items.AIR;
    public static final Item MOLTEN_AXE = Items.AIR;
    public static final Item POTION_ORB = Items.AIR;
    public static final Item GROWTH_POWDER = Items.AIR;

	@SubscribeEvent
	public static void onRegisterItem(RegistryEvent.Register<Item> event)
	{
		IForgeRegistry<Item> r = event.getRegistry();

		registerItem(r, new ItemArcaneHoe(), "arcane_hoe");
		registerItem(r, new ItemFangWand(), "fang_wand");
		registerItem(r, new ItemModel(), "sapphire", "gemSapphire");
		registerItem(r, new ItemModel(), "amethyst", "gemAmethyst");
		registerItem(r, new ItemGlowingChorusFruit(), "glowing_chorus");
        registerItem(r, new ItemRecaller(), "recaller");

        registerItem(r, new ItemBiomeCrystal(5), "biome_crystal");
		registerItem(r, new ItemRitualScroll(), "ritual_scroll");
		registerItem(r, new ItemModel(), "molten_core");

		registerItem(r, new ItemMoltenPickaxe(Item.ToolMaterial.IRON), "molten_pickaxe");
		registerItem(r, new ItemMoltenShovel(Item.ToolMaterial.IRON), "molten_shovel");
		registerItem(r, new ItemMoltenAxe(Item.ToolMaterial.IRON), "molten_axe");

		registerItem(r, new ItemEtherealSword(Item.ToolMaterial.DIAMOND), "ethereal_sword");
		registerItem(r, new ItemPotionOrb(), "potion_orb");
		registerItem(r, new ItemGrowthPowder(), "growth_powder");


		////TODO: Do this btter
		Item internalRecallEye = new ItemModel().setRegistryName(new ResourceLocation(ArcaneWorld.MODID, "recall_eye"));
		event.getRegistry().register(internalRecallEye);
		itemList.add(internalRecallEye);
	}

	public static Item registerItem(IForgeRegistry<Item> registry, Item item, String name, String... oredict)
	{
		item.setTranslationKey(ArcaneWorld.MODID + "." + name);
		item.setRegistryName(ArcaneWorld.MODID, name);
		item.setCreativeTab(ArcaneWorldTab.INSTANCE);

		if(oredict.length > 0)
			oreDict.add(Pair.of(item, oredict));

		itemList.add(item);
		registry.register(item);

		return item;
	}

	public static List<Pair<Item, String[]>> getOreDictEntries()
	{
		return oreDict;
	}
}