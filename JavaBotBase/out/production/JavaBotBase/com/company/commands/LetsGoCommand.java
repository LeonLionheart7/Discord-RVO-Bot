package com.company.commands;

import com.company.Command;
import net.dv8tion.jda.events.message.MessageReceivedEvent;
import java.util.regex.*;
import java.util.ArrayList;

/**
 * Created by LeonLionheart on 10/22/2016.
 */
public class LetsGoCommand implements Command{
    private final String HELP = "Usage: ~!in 'player' 'raid'";

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return true;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
         if(regexCall("/(wotm|(wrath|wrath of the machine)) n/ig",args[1]))
			      WotM_NM.add(args[0]);
		      else if(regexCall("/(wotm|(wrath|wrath of the machine)) h/ig",args[1]))
			      WotM_HM.add(args[0]);
		      else if(regexCall("/(vog|(vault|vault of glass)) n/ig",args[1]))
			      VoG_NM.add(args[0]);
		      else if(regexCall("/(vog|(vault|vault of glass)) h/ig",args[1]))
			      VoG_HM.add(args[0]);
		      else if(regexCall("/(kf|(kings|kings fall)) n/ig",args[1]))
			      KF_NM.add(args[0]);
		      else if(regexCall("/(kf|(kings|kings fall)) h/ig",args[1]))
			      KF_HM.add(args[0]);
		      else if(regexCall("/(c|(crota|crota)) n/ig",args[1]))
			      C_NM.add(args[0]);
		      else if(regexCall("/(c|(crota|crota)) h/ig",args[1]))
			      C_HM.add(args[0]);
		      else
    }
    
    //regex to find if there is a match of "pattern" in "find"
	  private boolean regexCall(String pattern, String search) {
		  Pattern P = Pattern.compile(pattern);
		  Matcher M = P.matcher(search);
		  return M.find();
	  }
    
    private void letsGoPrint(ArrayList<String> list) {
		  if(list.size() > 6)
              pick(6, list);
          else if(list.size() < 6)
              print(list, "+" + (6-list.size()));
          else
              print(list);
	  }
    
    private void pick(int n, ArrayList<String> names) {
		  ArrayList<String> out = new ArrayList<String>();
		  for(int i=0; i<n; n++) { 			    //n times
			  int roll = roll(names.size());	//choose a random list element
			  out.add(names.get(roll));	     	//add to out list
			  names.remove(roll);				      //remove from select list
		  }
		print(out);
    }
    
    private void print(ArrayList<String> out) {
		  for(String s: out)
			  print(s);
	  }
    
	  private void print(String out) {
      event.getTextChannel().sendMessage(out);
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
