package miskyle.realsurvival.status.task;

import java.util.LinkedList;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import com.github.miskyle.mcpt.MCPT;
import miskyle.realsurvival.Msg;
import miskyle.realsurvival.api.status.StatusType;
import miskyle.realsurvival.data.ConfigManager;
import miskyle.realsurvival.data.EffectManager;
import miskyle.realsurvival.data.ItemManager;
import miskyle.realsurvival.data.PlayerManager;
import miskyle.realsurvival.data.item.RsItemData;
import miskyle.realsurvival.data.playerdata.TemperatureStatus;
import miskyle.realsurvival.randomday.RandomDayManager;
import miskyle.realsurvival.util.RsEntry;

public class TemperatureTask implements Runnable {
  private static LinkedList<String> debugTem = new LinkedList<String>();

  @Override
  public void run() {
    PlayerManager.getActivePlayers().forEachValue(
        PlayerManager.getActivePlayers().mappingCount(), pd -> {
          Player p = MCPT.plugin.getServer().getPlayer(pd.getPlayerName());
          if (!p.isOnline()) {
            PlayerManager.removePlayer(p.getName());
            return;
          }
          TemperatureStatus oldTem = pd.getTemperature().getValue();
          RsEntry<Double, Double> toleranceEntry = 
              pd.getTemperature().getTotalTolerance(pd.getEffect());
          RsEntry<Double, Double> itemT = getItemTemperature(p);
          toleranceEntry.setLeft(toleranceEntry.getLeft() + itemT.getLeft());
          toleranceEntry.setRight(toleranceEntry.getRight() + itemT.getRight());
          double temperature = RandomDayManager.getTemperature(p.getLocation());
          if (temperature > toleranceEntry.getRight()) {
            pd.getTemperature().setValue(TemperatureStatus.HOT);
            ConfigManager.getTemperatureConfig().getMaxEffect().forEach(effect -> {
              EffectManager.effectPlayer(p, effect, StatusType.TEMPERATURE);
            });
            if (oldTem != TemperatureStatus.HOT) {
              PlayerManager.bar.sendActionBar(p, Msg.tr("messages.temperature.hot"));
            }
          } else if (temperature < toleranceEntry.getLeft()) {
            pd.getTemperature().setValue(TemperatureStatus.COLD);
            ConfigManager.getTemperatureConfig().getMinEffect().forEach(effect -> {
              EffectManager.effectPlayer(p, effect, StatusType.TEMPERATURE);
            });
            if (oldTem != TemperatureStatus.COLD) {
              PlayerManager.bar.sendActionBar(p, Msg.tr("messages.temperature.cold"));
            }
          } else {
            pd.getTemperature().setValue(TemperatureStatus.NORMAL);
          }
          if (debugTem.contains(p.getName())) {
            p.sendMessage("Temperature: " + temperature + "℃");
          }
        });

  }

  private static RsEntry<Double, Double> getItemTemperature(Player p) {
    RsEntry<Double, Double> entry = new RsEntry<Double, Double>(0D, 0D);
    for (ItemStack item : p.getInventory().getArmorContents()) {
      if (item == null) {
        continue;
      }
      RsItemData data = ItemManager.loadItemData(item.clone());
      if (data != null && data.getTemperature() != null) {
        entry.setLeft(entry.getLeft() + data.getTemperature().getLeft());
        entry.setRight(entry.getRight() + data.getTemperature().getRight());
      }
    }
    return entry;
  }

  //  public static void debug(String playerName) {
  //    if (debugTem.contains(playerName)) {
  //      debugTem.remove(playerName);
  //    } else {
  //      debugTem.add(playerName);
  //    }
  //  }
}
