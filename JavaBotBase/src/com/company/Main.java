package com.company;

import com.company.commands.PingCommand;
import net.dv8tion.jda.JDA;
import net.dv8tion.jda.JDABuilder;

import java.util.HashMap;

public class Main {

    private static JDA jda;
    public static final CommandParser parser = new CommandParser();
	
	//used for !in/!out
	public ArrayList<String> WotM_NM = new ArrayList<String>();
	public ArrayList<String> WotM_HM = new ArrayList<String>();
	public ArrayList<String> VoG_NM = new ArrayList<String>();
	public ArrayList<String> VoG_HM = new ArrayList<String>();
	public ArrayList<String> KF_HM = new ArrayList<String>();
	public ArrayList<String> KF_NM = new ArrayList<String>();
	public ArrayList<String> C_HM = new ArrayList<String>();
	public ArrayList<String> C_NM = new ArrayList<String>();


    public static HashMap<String, Command> commands = new HashMap<String, Command>();

    public static void main(String[] args) {
	    try {
            jda = new JDABuilder().addListener(new BotListener()).setBotToken("MjM5Mzk2NjQ5MTA3OTgwMjg5.Cu0LFQ.bpPulthA0bT9pOMVqXjPbk0dGlQ").buildBlocking();
            jda.setAutoReconnect(true);
        }   catch(Exception e) {
                e.printStackTrace();
        }

        commands.put("ping", new PingCommand());
	commands.put("in", new InCommand());
	commands.put("out", new OutCommand());
	commands.put("letsGo", new LetsGoCommand());


    }

    public static void handleCommand(CommandParser.CommandContainer cmd){
        if(commands.containsKey(cmd.invoke)){
            boolean safe = commands.get(cmd.invoke).called(cmd.args, cmd.event);

            if (safe){
                commands.get(cmd.invoke).action(cmd.args, cmd.event);
                commands.get(cmd.invoke).executed(safe, cmd.event);
            } else{
                commands.get(cmd.invoke).executed(safe, cmd.event);
            }
        }

    }
}
