package rush.comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import rush.configuracoes.Mensagens;

@SuppressWarnings("all")
public class ComandoInvsee implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender s, Command cmd, String lbl, String[] args) {
		if (cmd.getName().equalsIgnoreCase("invsee")) {
			
			// Verificando se o sender � um player
			if (!(s instanceof Player)) {
				s.sendMessage(Mensagens.Console_Nao_Pode);
				return true;
			}
			
			// Verificando se o player digitou o n�mero de argumentos corretos
			if (args.length != 1) {
				s.sendMessage(Mensagens.Invsee_Comando_Incorreto);
				return true;
			}
			
			// Pegando o player target e verificando se ele esta online
			Player target = Bukkit.getPlayer(args[0]);
			if (target == null) {
				s.sendMessage(Mensagens.Player_Offline);
				return true;
			}
			
			// Pegando o player sender abrindo o inventario do target
			Player p = (Player)s;
			p.openInventory(target.getInventory());
			s.sendMessage(Mensagens.Invsee_Abrindo_Inventario.replaceAll("%player%", target.getName()));
			return true;
		}
		return false;
	}
}