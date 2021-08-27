package me.RaidzDev;

import org.bukkit.plugin.java.*;
import java.util.*;
import org.bukkit.configuration.file.*;
import org.bukkit.*;
import java.util.logging.*;
import org.bukkit.event.*;
import me.RaidzDev.Habilidades.*;
import me.RaidzDev.Eventos.*;
import org.bukkit.command.*;
import me.RaidzDev.Comandos.*;
import me.RaidzDev.Utils.*;
import org.bukkit.plugin.*;
import com.sk89q.worldguard.bukkit.*;
import java.io.*;
import org.bukkit.entity.*;
import com.sk89q.worldguard.protection.flags.*;
import com.sk89q.worldguard.protection.*;

public class Main extends JavaPlugin
{
    public static String JogadorOff;
    public static String Permiss\u00e3o;
    public static Plugin plugin;
    public static ArrayList<String> Watch;
    public File status1;
    public YamlConfiguration status;
    public File arenas1;
    public YamlConfiguration arenas;
    public File warps1;
    public YamlConfiguration warps;
    public static Main instance;
    public File configuracoes1;
    public YamlConfiguration configuracoes;
    public File zFeastConfig;
    public YamlConfiguration FeastConfig;
    
    static {
        Main.JogadorOff = "§7Jogador n\u00e3o localizado, ou se encontra off!";
        Main.Permiss\u00e3o = "§7Voc\u00ea n\u00e3o tem permiss\u00e3o!";
        Main.Watch = new ArrayList<String>();
    }
    
    public static Main getInstance() {
        return Main.instance;
    }
    
    public void onEnable() {
        Main.plugin = (Plugin)this;
        getWorldGuard();
        final PluginManager e = Bukkit.getPluginManager();
        Main.instance = this;
        Bukkit.getConsoleSender().sendMessage("§aKitPvP - Carregado!");
        final PluginManager pm = this.getServer().getPluginManager();
        if (pm.getPlugin("NametagEdit") == null) {
            this.getLogger().log(Level.WARNING, "/ Esta faltando o NametagEdit");
            this.getLogger().log(Level.WARNING, "/ KitPvP desativado...");
            Bukkit.shutdown();
            pm.disablePlugin((Plugin)this);
            return;
        }
        Bukkit.getPluginManager().registerEvents((Listener)new Join(), (Plugin)this);
        Bukkit.getPluginManager().registerEvents((Listener)new ScoreBoard(), (Plugin)this);
        Bukkit.getPluginManager().registerEvents((Listener)new Eventos(), (Plugin)this);
        Bukkit.getPluginManager().registerEvents((Listener)new Arena(), (Plugin)this);
        Bukkit.getPluginManager().registerEvents((Listener)new Tag(), (Plugin)this);
        Bukkit.getPluginManager().registerEvents((Listener)new Fly(), (Plugin)this);
        Bukkit.getPluginManager().registerEvents((Listener)new Warp(), (Plugin)this);
        Bukkit.getPluginManager().registerEvents((Listener)new CombatLog(), (Plugin)this);
        Bukkit.getPluginManager().registerEvents((Listener)new Admin(), (Plugin)this);
        Bukkit.getPluginManager().registerEvents((Listener)new Chat(), (Plugin)this);
        Bukkit.getPluginManager().registerEvents((Listener)new Jumps(), (Plugin)this);
        Bukkit.getPluginManager().registerEvents((Listener)new PlacaSopa(), (Plugin)this);
        Bukkit.getPluginManager().registerEvents((Listener)new PlacaRecraft(), (Plugin)this);
        Bukkit.getPluginManager().registerEvents((Listener)new StaffChat(), (Plugin)this);
        Bukkit.getPluginManager().registerEvents((Listener)new AntiMoveAPI(), (Plugin)this);
        e.registerEvents((Listener)new Admin(), (Plugin)this);
        e.registerEvents((Listener)new AntiMoveAPI(), (Plugin)this);
        e.registerEvents((Listener)new Anchor(), (Plugin)this);
        e.registerEvents((Listener)new Ryu(), (Plugin)this);
        e.registerEvents((Listener)new Endermage(this), (Plugin)this);
        e.registerEvents((Listener)new Stomper(), (Plugin)this);
        e.registerEvents((Listener)new Thor(), (Plugin)this);
        e.registerEvents((Listener)new Deshfire(), (Plugin)this);
        e.registerEvents((Listener)new Snail(), (Plugin)this);
        e.registerEvents((Listener)new Switcher(), (Plugin)this);
        e.registerEvents((Listener)new Fisherman(), (Plugin)this);
        e.registerEvents((Listener)new Poseidon(), (Plugin)this);
        e.registerEvents((Listener)new Firer(), (Plugin)this);
        e.registerEvents((Listener)new KillStreak(), (Plugin)this);
        e.registerEvents((Listener)new AntiCommands(), (Plugin)this);
        e.registerEvents((Listener)new Gladiator(), (Plugin)this);
        e.registerEvents((Listener)new Viking(), (Plugin)this);
        e.registerEvents((Listener)new Info(), (Plugin)this);
        e.registerEvents((Listener)new C4L(this), (Plugin)this);
        e.registerEvents((Listener)new JoinTag(), (Plugin)this);
        e.registerEvents((Listener)new ItemQuebrar(), (Plugin)this);
        e.registerEvents((Listener)new Strong(), (Plugin)this);
        e.registerEvents((Listener)new Sumo(), (Plugin)this);
        e.registerEvents((Listener)new Lavaman(), (Plugin)this);
        e.registerEvents((Listener)new Bomber(), (Plugin)this);
        e.registerEvents((Listener)new Reaper(), (Plugin)this);
        e.registerEvents((Listener)new Barbarian(), (Plugin)this);
        e.registerEvents((Listener)new Nofall(), (Plugin)this);
        e.registerEvents((Listener)new Specialist(), (Plugin)this);
        e.registerEvents((Listener)new Ajnin(), (Plugin)this);
        e.registerEvents((Listener)new Avatar(), (Plugin)this);
        e.registerEvents((Listener)new Motd(), (Plugin)this);
        e.registerEvents((Listener)new Hulk(), (Plugin)this);
        e.registerEvents((Listener)new Youtuber(), (Plugin)this);
        e.registerEvents((Listener)new Swords(), (Plugin)this);
        e.registerEvents((Listener)new Achilles(), (Plugin)this);
        e.registerEvents((Listener)new Blink(), (Plugin)this);
        e.registerEvents((Listener)new Camel(), (Plugin)this);
        e.registerEvents((Listener)new Viper(), (Plugin)this);
        e.registerEvents((Listener)new Berserker(), (Plugin)this);
        e.registerEvents((Listener)new Crack(), (Plugin)this);
        e.registerEvents((Listener)new Critical(), (Plugin)this);
        e.registerEvents((Listener)new Darkmage(), (Plugin)this);
        e.registerEvents((Listener)new Demoman(), (Plugin)this);
        e.registerEvents((Listener)new Timelord(), (Plugin)this);
        e.registerEvents((Listener)new Phantom(), (Plugin)this);
        e.registerEvents((Listener)new Flash(), (Plugin)this);
        e.registerEvents((Listener)new Hulk(), (Plugin)this);
        e.registerEvents((Listener)new Magma(), (Plugin)this);
        e.registerEvents((Listener)new Selector_Loja(), (Plugin)this);
        e.registerEvents((Listener)new Selector_Caixa(), (Plugin)this);
        e.registerEvents((Listener)new Selector_LojaClasses(), (Plugin)this);
        e.registerEvents((Listener)new KitSelector2(), (Plugin)this);
        e.registerEvents((Listener)new Ninja(), (Plugin)this);
        e.registerEvents((Listener)new Bussula(), (Plugin)this);
        e.registerEvents((Listener)new Turtle(), (Plugin)this);
        e.registerEvents((Listener)new Backpacker(), (Plugin)this);
        e.registerEvents((Listener)new Negresco(), (Plugin)this);
        e.registerEvents((Listener)new Report(), (Plugin)this);
        e.registerEvents((Listener)new Kangaroo(), (Plugin)this);
        e.registerEvents((Listener)new Sonic(), (Plugin)this);
        e.registerEvents((Listener)new KitAPI(), (Plugin)this);
        e.registerEvents((Listener)new Grappler(), (Plugin)this);
        e.registerEvents((Listener)new ForceField(), (Plugin)this);
        e.registerEvents((Listener)new KitSelector(), (Plugin)this);
        e.registerEvents((Listener)new PlacaFacil(), (Plugin)this);
        e.registerEvents((Listener)new Placamedio(), (Plugin)this);
        e.registerEvents((Listener)new PlacaDificil(), (Plugin)this);
        e.registerEvents((Listener)new Skit(), (Plugin)this);
        e.registerEvents((Listener)new PlacaExtreme(), (Plugin)this);
        this.getCommand("challenge").setExecutor((CommandExecutor)new APIWarp());
        this.getCommand("spawn").setExecutor((CommandExecutor)new APIWarp());
        this.getCommand("setspawn").setExecutor((CommandExecutor)new APIWarp());
        this.getCommand("setchallenge").setExecutor((CommandExecutor)new APIWarp());
        this.getCommand("setmdr").setExecutor((CommandExecutor)new APIWarp());
        this.getCommand("setfps").setExecutor((CommandExecutor)new APIWarp());
        this.getCommand("setrdm").setExecutor((CommandExecutor)new APIWarp());
        this.getCommand("fps").setExecutor((CommandExecutor)new APIWarp());
        this.getCommand("challenge").setExecutor((CommandExecutor)new APIWarp());
        this.getCommand("rdm").setExecutor((CommandExecutor)new APIWarp());
        this.getCommand("mdr").setExecutor((CommandExecutor)new APIWarp());
        this.getCommand("setknock").setExecutor((CommandExecutor)new APIWarp());
        this.getCommand("knock").setExecutor((CommandExecutor)new APIWarp());
        this.getCommand("arena").setExecutor((CommandExecutor)new Arena());
        this.getCommand("bc").setExecutor((CommandExecutor)new Bc());
        this.getCommand("warp").setExecutor((CommandExecutor)new Warp());
        this.getCommand("att").setExecutor((CommandExecutor)new Atualiza\u00e7\u00e3o());
        this.getCommand("skit").setExecutor((CommandExecutor)new Skit());
        this.getCommand("atualizacao").setExecutor((CommandExecutor)new Atualiza\u00e7\u00e3o());
        this.getCommand("say").setExecutor((CommandExecutor)new Bc());
        this.getCommand("kit").setExecutor((CommandExecutor)new Kit());
        this.getCommand("aplicar").setExecutor((CommandExecutor)new Aplicar());
        this.getCommand("report").setExecutor((CommandExecutor)new Report());
        this.getCommand("sc").setExecutor((CommandExecutor)new StaffChat());
        this.getCommand("setarena").setExecutor((CommandExecutor)new SetArena(this));
        this.getCommand("nofall").setExecutor((CommandExecutor)new Nofall());
        this.getCommand("tag").setExecutor((CommandExecutor)new Tag());
        this.getCommand("fly").setExecutor((CommandExecutor)new Fly());
        this.getCommand("kits").setExecutor((CommandExecutor)new KitSelector());
        this.getCommand("gm").setExecutor((CommandExecutor)new Gamemode(this));
        this.getCommand("tags").setExecutor((CommandExecutor)new Tag());
        this.getCommand("kits2").setExecutor((CommandExecutor)new KitSelector2());
        this.getCommand("youtuber").setExecutor((CommandExecutor)new Youtuber());
        this.getCommand("morrer").setExecutor((CommandExecutor)new Morrer());
        this.getCommand("kill").setExecutor((CommandExecutor)new Morrer());
        this.getCommand("coins").setExecutor((CommandExecutor)new Coins());
        this.getCommand("suicide").setExecutor((CommandExecutor)new Morrer());
        this.getCommand("ping").setExecutor((CommandExecutor)new Ping());
        this.getCommand("lclasses").setExecutor((CommandExecutor)new Selector_LojaClasses());
        this.getCommand("caixa").setExecutor((CommandExecutor)new Selector_Caixa());
        this.getCommand("loja").setExecutor((CommandExecutor)new Selector_Loja());
        this.getCommand("admin").setExecutor((CommandExecutor)new Admin());
        this.getCommand("chat").setExecutor((CommandExecutor)new Chat());
        final File status = new File(this.getDataFolder(), "status.yml");
        if (!status.exists()) {
            this.saveResource("status.yml", false);
        }
        this.status1 = new File(this.getDataFolder(), "status.yml");
        this.status = YamlConfiguration.loadConfiguration(this.status1);
        this.save();
        final File warps = new File(this.getDataFolder(), "warps.yml");
        if (!warps.exists()) {
            this.saveResource("warps.yml", false);
        }
        this.warps1 = new File(this.getDataFolder(), "warps.yml");
        this.warps = YamlConfiguration.loadConfiguration(this.warps1);
        this.save();
        final File FeastConfig = new File(this.getDataFolder(), "feast.yml");
        if (!FeastConfig.exists()) {
            this.saveResource("feast.yml", true);
        }
        this.zFeastConfig = new File(this.getDataFolder(), "feast.yml");
        this.FeastConfig = YamlConfiguration.loadConfiguration(this.zFeastConfig);
        this.save();
        final File arenas = new File(this.getDataFolder(), "arenas.yml");
        if (!arenas.exists()) {
            this.saveResource("arenas.yml", false);
        }
        this.arenas1 = new File(this.getDataFolder(), "arenas.yml");
        this.arenas = YamlConfiguration.loadConfiguration(this.arenas1);
        this.save();
        final File configuracoes = new File(this.getDataFolder(), "configuracoes.yml");
        if (!configuracoes.exists()) {
            this.saveResource("configuracoes.yml", false);
        }
        this.configuracoes1 = new File(this.getDataFolder(), "configuracoes.yml");
        this.configuracoes = YamlConfiguration.loadConfiguration(this.configuracoes1);
        this.save();
        this.getCommand("ffeast").setExecutor((CommandExecutor)new FeastHandler());
        final File file = new File(this.getDataFolder(), String.valueOf(File.separator) + "feast.yml");
        if (!file.exists()) {
            this.FeastConfig.addDefault("Settings.FeastWorld", (Object)"world");
            this.FeastConfig.options().copyDefaults(true);
            this.saveConfig();
        }
        FeastHandler.start(this.FeastConfig.getString("Settings.FeastWorld"));
    }
    
    public static WorldGuardPlugin getWorldGuard() {
        final Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("WorldGuard");
        if (plugin == null || !(plugin instanceof WorldGuardPlugin)) {
            return null;
        }
        return (WorldGuardPlugin)plugin;
    }
    
    public void save() {
        try {
            this.status.save(this.status1);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void save2() {
        try {
            this.warps.save(this.warps1);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void save1() {
        try {
            this.arenas.save(this.arenas1);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void save3() {
        try {
            this.configuracoes.save(this.configuracoes1);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("§cKitPvP - Desativado!");
    }
    
    public static boolean areaPvP(final Player p) {
        final ApplicableRegionSet region = getWorldGuard().getRegionManager(p.getWorld()).getApplicableRegions(p.getLocation());
        return region.allows(DefaultFlag.PVP);
    }
}
