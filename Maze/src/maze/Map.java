package maze;

import maze.constant.Geo;
import maze.playerSet.PosStack;
import maze.playerSet.PosWithNext;

public class Map {
	private int [][] mapInfo; 
	int mapWidth;
	int mapHeight;
	int [][] map;
	Position start;
	Position goal;

	public Map (int w, int h){
		if( w<1 || h<1 ) return;
		setMapInfo(new int[h][w]);
		for(int i =0; i< h; i++){
			for(int j=0; j<w; j++){
				mapInfo[i][j] = Geo.EMPTY;
			}
		}
		map = makeMap(mapInfo);
	}
	
	public Map ( int [][]info){
		this(info, new Position(1,1), new Position(info.length, info[0].length));
	}
	
	public Map (int [][]info, Position start, Position goal){
		if(info== null || info.length < 1 || info[0].length < 1 ) return;
		this.start 	= new Position(start.y, start.x);
		this.goal 	= new Position(goal.y, goal.x);
		map = makeMap(info);
	}
	
	public int[][] makeMap(int [][] info){
		setMapInfo(info);
		mapHeight	= info.length+2;
		mapWidth 	= info[0].length+2; 
		int[][] map = new int[mapHeight][mapWidth];
		
		//converting info's boundary is WALL 
		for (int i=0; i<map.length; i++){
			for(int j=0; j<map[0].length; j++){
				if(i==0 || j==0 || i==(mapHeight-1) || j==(mapWidth-1)) 
					map[i][j] = Geo.WALL;
				else
					map[i][j] = info[i-1][j-1];
			}
		}
		
		return map;
	}
	
	public void printMap(){
		if(map == null || mapHeight < 1 || mapWidth < 1) {
			System.out.println("Ivaild Map");
			return;
		}
		System.out.println("Start : "+this.start);
		System.out.println("Goal : "+this.goal);
		
		for (int i=0; i<mapHeight; i++){
			for(int j=0; j<mapWidth; j++){
				if(map[i][j] == Geo.WALL)
					System.out.print("WW");
				else if(goal.x == j && goal.y ==i)
					System.out.print("g ");
				else if(start.x == j && i == start.y)
					System.out.print("s ");
				else if (map[i][j] == Geo.EMPTY)
					System.out.print("  ");
			}
			System.out.print("\n");
		}
		
	}
	public void printMap(PosStack stack){
		if(stack ==null || map == null || mapHeight < 1 || mapWidth < 1) {
			System.out.println("Ivaild Map or stack");
			return;
		}
		
		System.out.println("Histroy");
		
		PosWithNext pos;
		while((pos = stack.pop()) != null){
			map[pos.y][pos.x]= Geo.PATH;
		}
		for (int i=0; i<mapHeight; i++){
			for(int j=0; j<mapWidth; j++){
				if(map[i][j] == Geo.WALL)
					System.out.print("WW");
				else if(goal.x == j && goal.y ==i)
					System.out.print("g ");
				else if(start.x == j && i == start.y)
					System.out.print("s ");
				else if(map[i][j] == Geo.PATH)
					System.out.print("* ");
				else if (map[i][j] == Geo.EMPTY)
					System.out.print("  ");
			}
			System.out.print("\n");
		}
		
	}	

	public int [][] getMapInfo() {
		return mapInfo;
	}
	
	public int getMapWidth() {
		return mapWidth;
	}

	public int getMapHeight() {
		return mapHeight;
	}

	public int[][] getMap() {
		return map;
	}


	public Position getStart() {
		return start;
	}

	public Position getGoal() {
		return goal;
	}

	public void setMapInfo(int [][] mapInfo) {
		this.mapInfo = mapInfo;
	}
}
