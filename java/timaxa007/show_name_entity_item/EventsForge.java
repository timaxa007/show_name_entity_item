package timaxa007.show_name_entity_item;

import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class EventsForge {

	private static final Minecraft mc = Minecraft.getMinecraft();
	private static List<EntityItem> list = null;
	public static double radius;

	@SubscribeEvent
	public void clientTick(TickEvent.ClientTickEvent event) {
		if (mc.world == null) return;
		list = mc.world.getEntitiesWithinAABB(EntityItem.class,  new AxisAlignedBB(mc.player.posX - 16F, mc.player.posY - 16, mc.player.posZ - 16, mc.player.posX + 16, mc.player.posY + 16, mc.player.posZ + 16));
	}

	@SubscribeEvent
	public void renderTick(RenderWorldLastEvent event) {
		if (list != null && !list.isEmpty()) {
			double x_fix = -(mc.player.lastTickPosX + (mc.player.posX - mc.player.lastTickPosX) * event.getPartialTicks());
			double y_fix = -(mc.player.lastTickPosY + (mc.player.posY - mc.player.lastTickPosY) * event.getPartialTicks());
			double z_fix = -(mc.player.lastTickPosZ + (mc.player.posZ - mc.player.lastTickPosZ) * event.getPartialTicks());
			GlStateManager.pushMatrix();
			GlStateManager.translate(x_fix, y_fix, z_fix);
			for (EntityItem ei : list) {
				if (!ei.getItem().isEmpty() && ei.getItem().getDisplayName() != null && ei.getItem().getDisplayName().length() > 0) {
					//GlStateManager.pushMatrix();
					//GlStateManager.translate(ei.posX, ei.posY + 1F, ei.posZ);
					EntityRenderer.drawNameplate(mc.fontRenderer, ei.getItem().getDisplayName(), (float)ei.posX, (float)ei.posY + 1, (float)ei.posZ, 0, mc.getRenderViewEntity().rotationYaw, mc.getRenderViewEntity().rotationPitch, false, false);
					//GlStateManager.popMatrix();
				}
			}
			GlStateManager.popMatrix();
		}
	}

	@SubscribeEvent
	public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
		if (event.getModID().equals(ShowNameEntityItemMod.MODID)) Config.syncConfig();
	}

}
