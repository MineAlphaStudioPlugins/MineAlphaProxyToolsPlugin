package com.minealpha.tools.commands;

import com.minealpha.tools.MineAlphaProxyTools;
import com.minealphaproxy.api.command.CommandSource;
import com.minealphaproxy.api.command.MineAlphaCommand;

public final class SendCommand extends MineAlphaCommand {

    private final MineAlphaProxyTools plugin;

    public SendCommand(MineAlphaProxyTools plugin) {
        super("send", "Send player to server", "/send <nick> <server>", null, "gsend");
        this.plugin = plugin;
    }

    @Override
    public void execute(CommandSource sender, String[] args) {
        if (args.length < 2) {
            sender.sendMessage("§cИспользование: §f/send <ник> <сервер>");
            return;
        }
        sender.sendMessage("§eСмена серверов пока в разработке.");
    }
}