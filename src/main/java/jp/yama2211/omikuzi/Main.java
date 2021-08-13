package jp.yama2211.omikuzi;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        String pex = ChatColor.AQUA + "Omikuzi" + ChatColor.RESET;
        if (!(sender instanceof Player)) {
            sender.sendMessage(pex + ChatColor.RED + "ゲーム内から実行してください！");
        } else {

            if (cmd.getName().equalsIgnoreCase("omikuzi")) {
                Player player = (Player)sender;
                Random Rand = new Random();
                int RandInt = Rand.nextInt(3);
                String RandSt = Integer.toString(RandInt);

                switch (RandSt) {
                    case "0": // effect 1
                        Bukkit.broadcastMessage(pex + player.getName() + "が" + RandSt + "番を当てました");
                        Bukkit.broadcastMessage(pex + "90秒間 移動速度が上昇します");
                        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,1800,2));
                        player.sendMessage(pex + "サラマンダーより、ずっとはやい!!");
                        break;

                    case "1": //effect 2
                        Bukkit.broadcastMessage(pex + player.getName() + "が" + RandSt + "番を当てました");
                        Bukkit.broadcastMessage(pex + "90秒間 移動速度が減少します");
                        player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW,1800,2));
                        break;

                    case "2": //effect 3
                        Bukkit.broadcastMessage(pex + player.getName() + "が" + RandSt + "番を当てました");
                        Bukkit.broadcastMessage(pex + "90秒間 採掘速度が上昇します");
                        player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING,1800,2));
                        break;

                    default:
                        break;
                }

            }


        }
        return false;
    }
}

