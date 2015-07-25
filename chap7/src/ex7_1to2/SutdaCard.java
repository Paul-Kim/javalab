package ex7_1to2;

public class SutdaCard {
	int num;
	boolean isKwang;
	
	SutdaCard(int num, boolean isKwang){
		this.num = num;
		this.isKwang = isKwang;
	}
	
	SutdaCard(){
		this(1,true);
	}
	
	public String toString(){
		return num + (isKwang ? "K" : "");
	}
}