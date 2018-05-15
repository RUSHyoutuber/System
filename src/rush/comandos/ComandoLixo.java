package rush.comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;

import rush.utils.ConfigManager;

public class ComandoLixo implements Listener, CommandExecutor {

	public boolean onCommand(CommandSender s, Command cmd, String lbl, String[] args) {
		if (cmd.getName().equalsIgnoreCase("lixo")) {
			
			if (!(s instanceof Player)) {
				s.sendMessage(ConfigManager.getConfig("mensagens").getString("Console-Nao-Pode").replace("&", "�")); 
				return false;
            }
			
			Player p = (Player) s;
			Inventory inv = Bukkit.getServer().createInventory(p, 36, ConfigManager.getConfig("mensagens").getString("Titulo-Da-Lixeira").replace("&", "�"));
            p.openInventory(inv);
		}
		return false;
	}
}