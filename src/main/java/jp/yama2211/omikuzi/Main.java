package jp.yama2211.omikuzi;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
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
                int RandInt = Rand.nextInt(15);
                String RandSt = Integer.toString(RandInt);
                int EffectTimeConf = getConfig().getInt("EffectTime");
                int EffectTime = EffectTimeConf * 20;
                int EffectLevelConf = getConfig().getInt("EffectLevel");

                player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10,1);

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
                        Bukkit.broadcastMessage(pex + EffectTimeConf +"秒間 移動速度が減少します");
                        player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW,EffectTime,EffectLevelConf));
                        break;

                    case "3": //effect 3
                        Bukkit.broadcastMessage(pex + player.getName() + "が" + RandSt + "番を当てました");
                        Bukkit.broadcastMessage(pex + EffectTimeConf +"秒間 採掘速度が上昇します");
                        player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING,EffectTime,EffectLevelConf));
                        break;

                    case "4":
                        Bukkit.broadcastMessage(pex + player.getName() + "が" + RandSt + "番を当てました");
                        Bukkit.broadcastMessage(pex + EffectTimeConf +"秒間 採掘速度が減少します");
                        player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING,EffectTime,EffectLevelConf));
                        break;

                    case "5":
                        Bukkit.broadcastMessage(pex + player.getName() + "が" + RandSt + "番を当てました");
                        Bukkit.broadcastMessage(pex + EffectTimeConf +"秒間 攻撃力が上昇します");
                        player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE,EffectTime,EffectLevelConf));
                        break;
                    case "6":
                        Bukkit.broadcastMessage(pex + player.getName() + "が" + RandSt + "番を当てました");
                        Bukkit.broadcastMessage(pex + EffectTimeConf +"秒間 跳躍力が上昇します");
                        player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP,EffectTime,EffectLevelConf));
                        break;

                    case "7":
                        Bukkit.broadcastMessage(pex + player.getName() + "が" + RandSt + "番を当てました");
                        Bukkit.broadcastMessage(pex + EffectTimeConf +"秒間 ジャンプができなくなります");
                        player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP,EffectTime,249));
                        break;

                    case "8":
                        Bukkit.broadcastMessage(pex + player.getName() + "が" + RandSt + "番を当てました");
                        Bukkit.broadcastMessage(pex + EffectTimeConf +"秒間 ジャンプの高さに制限がかかります。");
                        player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP,EffectTime,254));
                        player.sendMessage(pex + "1ブロック以上の高さを超えれなくなります。ハーフブロックをうまく活用しましょう。");
                        break;

                    case "9":
                        Bukkit.broadcastMessage(pex + player.getName() + "が" + RandSt + "番を当てました");
                        Bukkit.broadcastMessage(pex + EffectTimeConf +"秒間 再生能力が高くなります");
                        player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION,EffectTime,EffectLevelConf));
                        break;

                    case "10":
                        Bukkit.broadcastMessage(pex + player.getName() + "が" + RandSt + "番を当てました");
                        Bukkit.broadcastMessage(pex + EffectTimeConf +"秒間 耐性が高くなります");
                        player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,EffectTime,EffectLevelConf));
                        break;

                    case "11":
                        Bukkit.broadcastMessage(pex + player.getName() + "が" + RandSt + "番を当てました");
                        Bukkit.broadcastMessage(pex +"エンチャントされた金りんごを" + getConfig().getInt("EnGApp") + "手に入れました！");
                        ItemStack EnGApp = new ItemStack(Material.ENCHANTED_GOLDEN_APPLE,getConfig().getInt("EnGApp"));
                        player.getInventory().addItem(EnGApp);
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

