package com.minealpha.tools.commands;

import com.minealpha.tools.MineAlphaProxyTools;
import com.minealphaproxy.api.MineAlphaPlayer;
import com.minealphaproxy.api.command.CommandSource;
import com.minealphaproxy.api.command.MineAlphaCommand;

import java.util.Optional;

public final class ServerCommand extends MineAlphaCommand {
    private final MineAlphaProxyTools plugin;

    public ServerCommand(MineAlphaProxyTools plugin) {
        super("server", "Switch server", "/server <name>", null, "srv");
        this.plugin = plugin;
    }

    @Override
    public void execute(CommandSource sender, String[] args) {
        if (args.length == 0) {
            sender.sendMessage("§7Сервера:");
            plugin.getProxy().getServers().forEach(s -> sender.sendMessage("§7- §f" + s.getName()));
            return;
        }
        Optional<MineAlphaPlayer> playerOpt = sender.asPlayer();
        if (playerOpt.isEmpty()) {
            sender.sendMessage("§cТолько игрок может использовать /server");
            return;
        }
        String target = args[0];
        sender.sendMessage("§7Переключение на §f" + target + "§7...");
        playerOpt.get().connectToServer(target);
    }
}