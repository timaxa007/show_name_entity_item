package timaxa007.show_name_entity_item;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.fml.client.config.GuiConfig;

public class ConfigGui extends GuiConfig {

	public ConfigGui(GuiScreen parent) {
		super(parent, new ConfigElement(Config.config.getCategory(Config.category)).getChildElements(),
				ShowNameEntityItemMod.MODID, false, false, GuiConfig.getAbridgedConfigPath(Config.config.toString()));
	}

}
