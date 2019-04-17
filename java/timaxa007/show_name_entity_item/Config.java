package timaxa007.show_name_entity_item;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class Config {

	public static Configuration config;
	public static final String categoryGui = "gui";

	public static void init(File file) {
		config = new Configuration(file);
		config.load();
		syncConfig();
	}

	public static void syncConfig() {
		EventsForge.radius = config.get(categoryGui, "radius", EventsForge.radius).getDouble();
		if (config.hasChanged()) config.save();
	}

}
