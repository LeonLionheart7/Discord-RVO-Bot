package com.company.commands;

import com.company.Command;
import net.dv8tion.jda.events.message.MessageReceivedEvent;

/**
 * Created by w_r_a on 10/22/2016.
 */
public class PingCommand implements Command{
    private final String HELP = "Usage: ~!ping";

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return true;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        event.getTextChannel().sendMessage("PONG!");
    }

    @Override
    public String help() {
        return HELP;
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {
        return;
    }
}
