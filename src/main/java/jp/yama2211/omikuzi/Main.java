package jp.yama2211.omikuzi;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.CommandBlock;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;

public final class Main extends JavaPlugin {

    public String pex = "[" + ChatColor.AQUA + "Omikuzi" + ChatColor.RESET + "] ";
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
        if (!(sender instanceof Player)) {
            sender.sendMessage(pex + ChatColor.RED + "ゲーム内から実行してください！");
        } else {

            if (cmd.getName().equalsIgnoreCase("omikuzi")) {
                if (args.length == 0) {
                    sender.sendMessage(pex + "/omikuzi effect : エフェクトが付与されるおみくじが引けます。");
                    sender.sendMessage(pex + "/omikuzi food : 食料がもらえるおみくじを引けます。");
                    sender.sendMessage(pex + "/omikuzi tool : ツールがもらえるおみくじが引けます。");
                    sender.sendMessage(pex + "おみくじの結果はサーバにいる全てのプレイヤーに通知されます。");
                }

                /* omikuziに必要な宣言類 */
                Player player = (Player)sender;
                Random Rand = new Random();
                int RandInt = Rand.nextInt(11); //初期
                String RandSt = Integer.toString(RandInt);
                int EffectTimeConf = getConfig().getInt("EffectTime");
                int EffectTime = EffectTimeConf * 20;
                int EffectLevelConf = getConfig().getInt("EffectLevel");
                //int WooS = randReturn(4);

                //おみくじを引いたプレイヤーに音を鳴らす
                player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10,1);

                if (args.length == 1) {
                    if(args[0].equalsIgnoreCase("effect")){
                        if(player.hasPermission("omikuzi.effect")){

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

                        default:
                            Bukkit.broadcastMessage(pex + "まだ未実装の値です");

                            break;
                    }
                } //pex omikuzi.effect
                    }//args[0] effect

                }//args.length == 1


            }

        }
        return false;
    }

    /*
    * ランダムな数字を返す
    * 引数(int) +1
    */
    public int randReturn(int i){
        Random random = new Random();
        int intrand = random.nextInt(i) + 1;
        return intrand;
    }
}

