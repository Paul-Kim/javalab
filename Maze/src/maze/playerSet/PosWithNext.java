package maze.playerSet;

import maze.Position;

public class PosWithNext extends Position{
	Position nextDir;
	
	public PosWithNext (Position pos, Position direction){
		x = pos.x;
		y = pos.y;
		nextDir = direction;
	}
	public PosWithNext (PosWithNext pos){
		x = pos.x;
		y = pos.y;
		nextDir = pos.nextDir;
	}
	public PosWithNext (Position pos){
		x = pos.x;
		y = pos.y;
		nextDir = null;
	}
}
