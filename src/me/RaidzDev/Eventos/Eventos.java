package me.RaidzDev.Eventos;

import java.util.*;
import org.bukkit.craftbukkit.v1_7_R4.entity.*;
import org.spigotmc.*;
import java.lang.reflect.*;
import org.bukkit.command.*;
import net.minecraft.server.v1_7_R4.*;
import org.bukkit.help.*;
import org.bukkit.event.*;
import org.bukkit.event.weather.*;
import me.RaidzDev.*;
import org.bukkit.plugin.*;
import org.bukkit.*;
import me.RaidzDev.Utils.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.entity.*;
import org.bukkit.event.entity.*;
import org.bukkit.event.player.*;
import org.bukkit.event.block.*;

public class Eventos implements Listener
{
    private static int VERSION;
    private Map<String, Long> timeout;
    
    static {
        Eventos.VERSION = 47;
    }
    
    public Eventos() {
        this.timeout = new HashMap<String, Long>();
    }
    
    public boolean onPlayerConnect(final PlayerJoinEvent e) {
        final Player p = e.getPlayer();
        sendTitle(p, "");
        sendSubTitle(p, "");
        return false;
    }
    
    public static void sendTitle(final Player p, final String title) {
        if (((CraftPlayer)p).getHandle().playerConnection.networkManager.getVersion() < Eventos.VERSION) {
            return;
        }
        ((CraftPlayer)p).getHandle().playerConnection.sendPacket((Packet)new ProtocolInjector.PacketTitle(ProtocolInjector.PacketTitle.Action.TITLE, ChatSerializer.a("{\"text\": \"\"}").a(title)));
    }
    
    public static void sendSubTitle(final Player p, final String subtitle) {
        if (((CraftPlayer)p).getHandle().playerConnection.networkManager.getVersion() < Eventos.VERSION) {
            return;
        }
        ((CraftPlayer)p).getHandle().playerConnection.sendPacket((Packet)new ProtocolInjector.PacketTitle(ProtocolInjector.PacketTitle.Action.SUBTITLE, ChatSerializer.a("{\"text\": \"\"}").a(subtitle)));
    }
    
    public static void sendTimings(final Player p, final int fadeIn, final int stay, final int fadeOut) {
        if (((CraftPlayer)p).getHandle().playerConnection.networkManager.getVersion() < Eventos.VERSION) {
            return;
        }
        try {
            final Object handle = getHandle(p);
            final Object connection = getField(handle.getClass(), "playerConnection").get(handle);
            final Object packet = ProtocolInjector.PacketTitle.class.getConstructor(ProtocolInjector.PacketTitle.Action.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).newInstance(ProtocolInjector.PacketTitle.Action.TIMES, fadeIn, stay, fadeOut);
            getMethod(connection.getClass(), "sendPacket", new Class[0]).invoke(connection, packet);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static boolean ClassListEqual(final Class<?>[] l1, final Class<?>[] l2) {
        boolean equal = true;
        if (l1.length != l2.length) {
            return false;
        }
        for (int i = 0; i < l1.length; ++i) {
            if (l1[i] != l2[i]) {
                equal = false;
                break;
            }
        }
        return equal;
    }
    
    private static Field getField(final Class<?> clazz, final String name) {
        try {
            final Field field = clazz.getDeclaredField(name);
            field.setAccessible(true);
            return field;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    private static Method getMethod(final Class<?> clazz, final String name, final Class<?>[] args) {
        Method[] arrayOfMethod;
        for (int j = (arrayOfMethod = clazz.getMethods()).length, i = 0; i < j; ++i) {
            final Method m = arrayOfMethod[i];
            if (m.getName().equals(name) && (args.length == 0 || ClassListEqual(args, m.getParameterTypes()))) {
                m.setAccessible(true);
                return m;
            }
        }
        return null;
    }
    
    private static Object getHandle(final Object obj) {
        try {
            return getMethod(obj.getClass(), "getHandle", new Class[0]).invoke(obj, new Object[0]);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static void reset(final Player p) {
        if (((CraftPlayer)p).getHandle().playerConnection.networkManager.getVersion() < Eventos.VERSION) {
            return;
        }
        ((CraftPlayer)p).getHandle().playerConnection.sendPacket((Packet)new ProtocolInjector.PacketTitle(ProtocolInjector.PacketTitle.Action.RESET));
    }
    
    public static void clear(final Player p) {
        if (((CraftPlayer)p).getHandle().playerConnection.networkManager.getVersion() < Eventos.VERSION) {
            return;
        }
        ((CraftPlayer)p).getHandle().playerConnection.sendPacket((Packet)new ProtocolInjector.PacketTitle(ProtocolInjector.PacketTitle.Action.CLEAR));
    }
    
    public boolean onCommand(final CommandSender arg0, final Command arg1, final String arg2, final String[] arg3) {
        return false;
    }
    
    public static void sendActionBar(final Player player, final String message) {
        final CraftPlayer p = (CraftPlayer)player;
        if (p.getHandle().playerConnection.networkManager.getVersion() != 47) {
            return;
        }
        final IChatBaseComponent cbc = ChatSerializer.a("{\"text\": \"" + message + "\"}");
        final PacketPlayOutChat ppoc = new PacketPlayOutChat(cbc, 2);
        p.getHandle().playerConnection.sendPacket((Packet)ppoc);
    }
    
    @EventHandler
    public void onChat(final AsyncPlayerChatEvent e) {
        final Player p = e.getPlayer();
        if (this.timeout.containsKey(p.getName()) && this.timeout.get(p.getName()) > System.currentTimeMillis()) {
            p.sendMessage(String.valueOf(Config.prefix) + "Por Favor Fale Mais Devagar!");
            e.setCancelled(true);
            return;
        }
        this.timeout.put(p.getName(), System.currentTimeMillis() + 1500L);
    }
    
    @EventHandler
    public void semExplosao(final EntityExplodeEvent e) {
        e.setCancelled(true);
    }
    
    @EventHandler(priority = EventPriority.NORMAL)
    public void onPlayerCommandPreprocess(final PlayerCommandPreprocessEvent event) {
        if (!event.isCancelled()) {
            final Player player = event.getPlayer();
            final String cmd = event.getMessage().split(" ")[0];
            final HelpTopic topic = Bukkit.getServer().getHelpMap().getHelpTopic(cmd);
            if (topic == null) {
                player.playSound(player.getLocation(), Sound.EXPLODE, 1.0f, 1.0f);
                player.sendMessage(String.valueOf(Config.prefix) + "Comando Digitado N\u00e3o Existe!");
                event.setCancelled(true);
            }
        }
    }
    
    @EventHandler
    public void Ceu(final WeatherChangeEvent e) {
        if (e.toWeatherState()) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    void naoColocarBlocosNoSurvival(final BlockPlaceEvent e) {
        final Player p = e.getPlayer();
        if (p.getGameMode() != GameMode.CREATIVE) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    void NaoQuebrarBlocosNoSurvival(final BlockBreakEvent e) {
        final Player p = e.getPlayer();
        if (p.getGameMode() != GameMode.CREATIVE) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    void NaoPegarItemsNoSurvival(final PlayerPickupItemEvent e) {
        final Player p = e.getPlayer();
        if (p.getGameMode() != GameMode.CREATIVE) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void onItemDrop(final ItemSpawnEvent e) {
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)Main.instance, (Runnable)new Runnable() {
            @Override
            public void run() {
                e.getEntity().remove();
                e.getLocation().getWorld().playEffect(e.getEntity().getLocation(), Effect.SMOKE, 10);
            }
        }, 10L);
    }
    
    @EventHandler
    public void aftricA(final FoodLevelChangeEvent e) {
        e.setCancelled(true);
    }
    
    @EventHandler
    public void AntiPlugin(final PlayerCommandPreprocessEvent e) {
        final Player p = e.getPlayer();
        if (e.getMessage().equalsIgnoreCase("/pl") || e.getMessage().equalsIgnoreCase("/plugins") || e.getMessage().equalsIgnoreCase("/plugin") || e.getMessage().equalsIgnoreCase("/bukkit:me") || e.getMessage().equalsIgnoreCase("/bukkit:?") || e.getMessage().equalsIgnoreCase("/ver") || e.getMessage().equalsIgnoreCase("/me") || e.getMessage().equalsIgnoreCase("/criador") || e.getMessage().equalsIgnoreCase("/me") || e.getMessage().equalsIgnoreCase("/?")) {
            e.setCancelled(true);
            p.sendMessage("§7Plugin feito por: §cRaidzdev");
            p.sendMessage("§7Plugin para Guizin especial de §c3k§7 Viadoooo!");
        }
    }
    
    @EventHandler
    public void Warps(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (p.getItemInHand().getType() == Material.PAPER) {
            p.chat("/warp");
        }
    }
    
    @EventHandler
    public void uvu(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (p.getItemInHand().getType() == Material.EMERALD) {
            p.chat("/loja");
        }
    }
    
    @EventHandler
    public void bok(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (p.getItemInHand().getType() == Material.BOOK) {
            Info.abrirguiInforma\u00e7\u00e3o(p);
        }
    }
    
    @EventHandler
    public void pvp(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (p.getItemInHand().getType() == Material.BLAZE_ROD) {
            p.chat("/1v1");
        }
    }
    
    @EventHandler
    public void Kits(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (p.getItemInHand().getType() == Material.ENDER_CHEST) {
            p.chat("/kits");
        }
    }
    
    @EventHandler
    public void Loja(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (p.getItemInHand().getType() == Material.DIAMOND) {
            p.chat("/buy");
        }
    }
    
    @EventHandler
    public void AoTomarSopa(final PlayerInteractEvent e) {
        final ItemStack pote = new ItemStack(Material.BOWL, 1);
        final ItemMeta kpote = pote.getItemMeta();
        kpote.setDisplayName(String.valueOf(Config.cor) + "Sopas");
        pote.setItemMeta(kpote);
        final Damageable hp;
        final Player p = (Player)(hp = (Damageable)e.getPlayer());
        if (hp.getHealth() != 20.0) {
            final int sopa = 7;
            if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && p.getItemInHand().getTypeId() == 282) {
                p.setHealth((hp.getHealth() + sopa > hp.getMaxHealth()) ? hp.getMaxHealth() : (hp.getHealth() + sopa));
                p.getItemInHand().setType(Material.BOWL);
                p.getItemInHand().setItemMeta(kpote);
                p.getItemInHand().setType(Material.BOWL);
                p.getPlayer().playSound(p.getPlayer().getLocation(), Sound.BURP, 5.0f, 5.0f);
            }
        }
    }
    
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerLogin(final PlayerLoginEvent e) {
        if (e.getResult() == PlayerLoginEvent.Result.KICK_FULL) {
            final String KICK_MSG = Main.getInstance().configuracoes.getString("MSG_Kick");
            e.setKickMessage(KICK_MSG.replace("&", "§").replace("<linha>", "\n"));
        }
        if (e.getResult() == PlayerLoginEvent.Result.KICK_WHITELIST) {
            final String KICK_MSG = Main.getInstance().configuracoes.getString("MSG_Manutencao");
            e.setKickMessage(KICK_MSG.replace("&", "§").replace("<linha>", "\n"));
        }
        if (e.getResult() == PlayerLoginEvent.Result.KICK_BANNED) {
            final String KICK_MSG = Main.getInstance().configuracoes.getString("MSG_Ban");
            e.setKickMessage(KICK_MSG.replace("&", "\t").replace("<linha>", "\n"));
        }
    }
    
    @EventHandler
    public void fullJoin(final PlayerLoginEvent event) {
        final Player p = event.getPlayer();
        if (event.getResult() == PlayerLoginEvent.Result.KICK_FULL && p.hasPermission("guikits.joinfull")) {
            event.setResult(PlayerLoginEvent.Result.ALLOWED);
        }
    }
    
    @EventHandler
    public void Fome(final FoodLevelChangeEvent e) {
        e.setCancelled(true);
        e.setFoodLevel(20);
    }
    
    @EventHandler
    public void BaterEntity(final EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
            final int porcentage = 50;
            e.setDamage(e.getDamage() * porcentage / 100.0);
        }
    }
    
    @EventHandler
    public void Chuva(final WeatherChangeEvent e) {
        if (e.toWeatherState()) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void CancelarDrops(final PlayerDropItemEvent e) {
        final Material t = e.getItemDrop().getItemStack().getType();
        if (t.equals((Object)Material.ENDER_CHEST) || t.equals((Object)Material.EMERALD) || t.equals((Object)Material.PAPER) || t.equals((Object)Material.STONE_SWORD) || t.equals((Object)Material.WOOD_SWORD) || t.equals((Object)Material.FIREWORK) || t.equals((Object)Material.STONE_AXE) || t.equals((Object)Material.PUMPKIN) || t.equals((Object)Material.REDSTONE_TORCH_ON) || t.equals((Object)Material.BLAZE_ROD) || t.equals((Object)Material.DIAMOND_SWORD) || t.equals((Object)Material.MILK_BUCKET) || t.equals((Object)Material.SLIME_BALL) || t.equals((Object)Material.STAINED_GLASS_PANE) || t.equals((Object)Material.WOOD_HOE) || t.equals((Object)Material.STRING) || t.equals((Object)Material.REDSTONE_BLOCK) || t.equals((Object)Material.LAPIS_BLOCK) || t.equals((Object)Material.BOOK) || t.equals((Object)Material.STONE_AXE) || t.equals((Object)Material.SADDLE) || t.equals((Object)Material.MILK_BUCKET) || t.equals((Object)Material.COMPASS) || t.equals((Object)Material.POTION) || t.equals((Object)Material.LEATHER_CHESTPLATE) || t.equals((Object)Material.LEASH) || t.equals((Object)Material.SNOW_BALL) || t.equals((Object)Material.ENCHANTED_BOOK) || t.equals((Object)Material.DIAMOND) || t.equals((Object)Material.BOOK_AND_QUILL) || t.equals((Object)Material.WRITTEN_BOOK) || t.equals((Object)Material.NETHER_STAR) || t.equals((Object)Material.ENDER_CHEST) || t.equals((Object)Material.ENCHANTMENT_TABLE) || t.equals((Object)Material.STICK) || t.equals((Object)Material.GHAST_TEAR) || t.equals((Object)Material.WATCH) || t.equals((Object)Material.IRON_FENCE) || t.equals((Object)Material.REDSTONE) || t.equals((Object)Material.MAGMA_CREAM) || t.equals((Object)Material.IRON_SWORD) || t.equals((Object)Material.NETHER_FENCE) || t.equals((Object)Material.NAME_TAG) || t.equals((Object)Material.WOOD_BUTTON) || t.equals((Object)Material.WOOL) || t.equals((Object)Material.COMPASS) || t.equals((Object)Material.IRON_INGOT) || t.equals((Object)Material.FEATHER)) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler(priority = EventPriority.HIGHEST)
    public void chatFormat(final AsyncPlayerChatEvent e) {
        final Player p = e.getPlayer();
        if (p.hasPermission("guikits.chat")) {
            final String msg = e.getMessage().replace("&", "§");
            e.setFormat("§7" + p.getDisplayName() + " §e§o»" + "§f " + msg);
        }
        else {
            e.setFormat("§7" + p.getDisplayName() + " §c§o» " + "§f " + e.getMessage());
        }
    }
    
    @EventHandler
    public void explos\u00e3o(final EntityExplodeEvent e) {
        e.setCancelled(true);
    }
    
    @EventHandler
    public void CorPlaca(final SignChangeEvent e) {
        if (e.getLine(0).contains("&")) {
            e.setLine(0, e.getLine(0).replace("&", "§"));
        }
        if (e.getLine(1).contains("&")) {
            e.setLine(1, e.getLine(1).replace("&", "§"));
        }
        if (e.getLine(2).contains("&")) {
            e.setLine(2, e.getLine(2).replace("&", "§"));
        }
        if (e.getLine(3).contains("&")) {
            e.setLine(3, e.getLine(3).replace("&", "§"));
        }
    }
    
    public void chuva(final WeatherChangeEvent e) {
        e.setCancelled(true);
    }
}
