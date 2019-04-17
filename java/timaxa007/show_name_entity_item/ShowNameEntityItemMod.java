package timaxa007.show_name_entity_item;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ShowNameEntityItemMod.MODID, name = ShowNameEntityItemMod.NAME, version = ShowNameEntityItemMod.VERSION, guiFactory = "timaxa007.show_name_entity_item.GuiFactory")
public class ShowNameEntityItemMod {

	public static final String
	MODID = "show_name_entity_item",
	NAME = "Show Name Entity Item Mod",
	VERSION = "0.2";

	@Mod.Instance(MODID)
	public static ShowNameEntityItemMod instance;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		Config.init(event.getSuggestedConfigurationFile());
		MinecraftForge.EVENT_BUS.register(new EventsForge());
	}

}
