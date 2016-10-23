package com.company.commands;

import com.company.Command;
import net.dv8tion.jda.events.message.MessageReceivedEvent;
import java.util.regex.*;
import java.util.ArrayList;

/**
 * Created by LeonLionheart on 10/22/2016.
 */
public class OutCommand implements Command{
    private final String HELP = "Usage: ~!out 'player' 'raid'";

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return true;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
         if(regexCall("/(wotm|(wrath|wrath of the machine)) n/ig",args[1]))
			      WotM_NM.remove(args[0]);
		      else if(regexCall("/(wotm|(wrath|wrath of the machine)) h/ig",args[1]))
			      WotM_HM.remove(args[0]);
		      else if(regexCall("/(vog|(vault|vault of glass)) n/ig",args[1]))
			      VoG_NM.remove(args[0]);
		      else if(regexCall("/(vog|(vault|vault of glass)) h/ig",args[1]))
			      VoG_HM.remove(args[0]);
		      else if(regexCall("/(kf|(kings|kings fall)) n/ig",args[1]))
			      KF_NM.remove(args[0]);
		      else if(regexCall("/(kf|(kings|kings fall)) h/ig",args[1]))
			      KF_HM.remove(args[0]);
		      else if(regexCall("/(c|(crota|crota)) n/ig",args[1]))
			      C_NM.remove(args[0]);
		      else if(regexCall("/(c|(crota|crota)) h/ig",args[1]))
			      C_HM.remove(args[0]);
		      else
    }
    
    //regex to find if there is a match of "pattern" in "find"
	  private boolean regexCall(String pattern, String search) {
		  Pattern P = Pattern.compile(pattern);
		  Matcher M = P.matcher(search);
		  return M.find();
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
