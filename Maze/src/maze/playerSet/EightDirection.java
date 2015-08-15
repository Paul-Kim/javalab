package maze.playerSet;

import maze.Position;

public class EightDirection implements DirectionSet{
	private static final Position EAST 	= new Position (0,1);
	private static final Position WEST	= new Position (0,-1);;
	private static final Position NORTH	= new Position (-1,0);;
	private static final Position SOUTH	= new Position (1,0);;
	private static final Position EN 	= new Position (-1,1);
	private static final Position WN	= new Position (-1,-1);;
	private static final Position ES	= new Position (1,1);;
	private static final Position WS	= new Position (1,-1);;

	private final Position directionSet[] = {
			ES,
			EAST,
			SOUTH,
			EN,
			WS,
			NORTH,
			WEST,
			WN
	};
	
	
	@Override
	public Position firstDirection() {
		return directionSet[0];
	}

	@Override
	public Position nextDirection(Position curDir) {
		for(int i =0 ; i< directionSet.length-1; i++){ 
			//If final direction, can't reach here. 
			if(curDir.equals( directionSet[i] ))
				return directionSet[i+1];
		}
		return null;
	}

	@Override
	public boolean isFinalDirection(Position curDir) {
		if(WN == curDir) return true;
		else return false;
	}

}