package maze.playerSet;

import java.util.ArrayList;
import maze.Position;

public class PosStack {
	private ArrayList<PosWithNext> stack = null;
	
	public PosStack (){
		stack = new ArrayList<PosWithNext>();
	}
	
	public PosWithNext top(){
		if(this.isEmpty() == true) return null;
		else return stack.get(stack.size()-1);
	}
	
	public void push(Position pos, Position next){
		stack.add(new PosWithNext(pos, next));
		return;
	}
	
	public void push(PosWithNext pos){
		stack.add(new PosWithNext(pos, pos.nextDir));
		return;
	}
	
	public PosWithNext pop(){
		if(isEmpty())
			return null;
		PosWithNext tmp = this.top();
		stack.remove(stack.size()-1);
		return tmp;
	}
	
	public boolean isEmpty(){
		if(stack.size() < 1) return true;
		else return false;
	}

}
