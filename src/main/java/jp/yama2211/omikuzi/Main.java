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
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        String pex = "[" + ChatColor.AQUA + "Omikuzi" + ChatColor.RESET + "] ";
        if (!(sender instanceof Player)) {
            sender.sendMessage(pex + ChatColor.RED + "ゲーム内から実行してください！");
        } else {

            if (cmd.getName().equalsIgnoreCase("omikuzi")) {
                Player player = (Player)sender;
                Random Rand = new Random();
                int RandInt = Rand.nextInt(25);
                String RandSt = Integer.toString(RandInt);
                int EffectTimeConf = getConfig().getInt("EffectTime");
                int EffectTime = EffectTimeConf * 20;
                int EffectLevelConf = getConfig().getInt("EffectLevel");

                switch (RandSt) {
                    case "0":
                        player.sendMessage(pex + "おみくじを引くのに失敗したよ。あーあ。");
                        break;
                    case "1": // effect 1
                        Bukkit.broadcastMessage(pex + player.getName() + "が" + RandSt + "番を当てました");
                        Bukkit.broadcastMessage(pex + EffectTimeConf +"秒間 移動速度が上昇します");
                        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,EffectTime,EffectLevelConf));
                        player.sendMessage(pex + "サラマンダーより、ずっとはやい!!");
                        break;

                    case "2": //effect 2
                        Bukkit.broadcastMessage(pex + player.getName() + "が" + RandSt + "番を当てました");
                        Bukkit.broadcastMessage(pex + EffectTimeConf +"秒間 移動速度が上昇します");
                        player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW,EffectTime,EffectLevelConf));
                        break;

                    case "3": //effect 3
                        Bukkit.broadcastMessage(pex + player.getName() + "が" + RandSt + "番を当てました");
                        Bukkit.broadcastMessage(pex + EffectTimeConf +"秒間 移動速度が上昇します");
                        player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING,EffectTime,EffectLevelConf));
                        break;

                    case "4":
                        Bukkit.broadcastMessage(pex + player.getName() + "が" + RandSt + "番を当てました");
                        Bukkit.broadcastMessage(pex + EffectTimeConf +"秒間 移動速度が上昇します");
                        player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING,EffectTime,EffectLevelConf));
                        break;

                    case "5":
                        Bukkit.broadcastMessage(pex + player.getName() + "が" + RandSt + "番を当てました");
                        Bukkit.broadcastMessage(pex + EffectTimeConf +"秒間 移動速度が上昇します");
                        player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE,EffectTime,EffectLevelConf));
                        break;

                    default:
                        Bukkit.broadcastMessage(pex + "まだ未実装の値です");
                        break;
                }

            }


        }
        return false;
    }
}

