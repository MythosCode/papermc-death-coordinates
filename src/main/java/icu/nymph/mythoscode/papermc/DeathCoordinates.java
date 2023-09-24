package icu.nymph.mythoscode.papermc;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class DeathCoordinates extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.getPlayer().sendMessage(Component.text("Plugin DeathCoordinate is enabled"));
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        // 获取玩家死亡的位置
        Location location = event.getEntity().getLocation();
        // 在游戏聊天框内输出坐标
        String coordinates = String.format("Your death coordinates: X:%S, Y:%s Z:%s", location.getX(), location.getY(), location.getZ());
        event.getEntity().sendMessage(coordinates);
    }
}