package me.RaidzDev;

public class Config {
	public static String svs;
	public static String dica;
	public static String dono;
	public static String Aviso;
	public static String Pro;
	public static String YT;
	public static String cor;
	public static String prefix;
	public static String site;
	public static String tempo;
	public static String jakit;
	public static String pegarkit;

	static {
		Config.svs = Main.getInstance().configuracoes.getString("Nome").replace("&", "§");
		Config.dica = Main.getInstance().configuracoes.getString("Dica").replace("&", "§");
		Config.dono = Main.getInstance().configuracoes.getString("Dono do Servidor").replace("&", "§");
		Config.Aviso = Main.getInstance().configuracoes.getString("Aviso").replace("&", "§");
		Config.Pro = Main.getInstance().configuracoes.getString("Pro").replace("&", "§");
		Config.YT = Main.getInstance().configuracoes.getString("YT").replace("&", "§");
		Config.cor = Main.getInstance().configuracoes.getString("Cor").replace("&", "§");
		Config.prefix = String.valueOf(Config.cor)
				+ Main.getInstance().configuracoes.getString("Prefix").replace("&", "§") + " §7";
		Config.site = Main.getInstance().configuracoes.getString("Site").replace("&", "§");
		Config.tempo = Main.getInstance().configuracoes.getString("Classe em Espera").replace("&", "§");
		Config.jakit = Main.getInstance().configuracoes.getString("Usar o Classe").replace("&", "§");
		Config.pegarkit = Main.getInstance().configuracoes.getString("Pegar o Classe").replace("&", "§");
	}
}
