
public class Planet {
	private double _size; //how many earth sizes
	private double[] _groundMaterials; //rock,water,sand,metal,minerals,carbon,radioActives
	private double[] _atmMaterials; //oxygen,nitrogen,helium,hydrogen,carbondyoxied,chlorine,radioActives
	private double _distanceFromSun; //1 = same as earth, 2 = double the distance
	private double _atm; // 1 ATM = earth atmosphere
	private int _moons; // number of moons
	private double _temprature; // average c temprature
	private boolean _isGas; 
	private boolean _life; 
	private String _name =""; 
	
	private final int DEFAULT =1;
	private final double MINIMUM_PLANET_SIZE = 0.05;
	
	
	//CONSTRUCTOR
	public Planet (){
		
		_name            = generateName();
		_size            = generateSize();
		_moons           = generateMoons();
		_distanceFromSun = generateDistanceFromSun();
		_isGas           = isGas();

		
	}
	
	
	//CONSTRUCTOR WITH A NAME
	public Planet (String givenName){
		this();
		_name = givenName;

		
		
	}
	private boolean isGas(){
		boolean isGas  = false;
		if (_size >2 && _size <4 && Math.random()>0.99){
			
			isGas = true;
			
		}
		if (_size >4 && _size <10 && Math.random()>0.95){
			
			isGas = true;
			
		}
		if (_size >10 && _size <20 && Math.random()>0.85){
			
			isGas = true;
			
		}
		if (_size >20 && _size <30 && Math.random()>0.45){
			
			isGas = true;
			
		}
		if (_size >30 && _size <40 && Math.random()>0.10){
			
			isGas = true;
			
		}
		if (_size >40 && _size <50 && Math.random()>0.01){
			
			isGas = true;
			
		}
		if (_size >50){
			
			isGas = true;
			
		}
		return isGas;
		
	}
	
	
	private double generateDistanceFromSun(){
		double tmp = Math.random();		
		
		
		if  (tmp < 0.1)
		return (Math.random()*(0.23-0.1)+0.1);
		if  (tmp < 0.35)
		return (Math.random()*(0.8-0.23)+0.23);
		if  (tmp < 0.65)
		return (Math.random()*(1.2-0.8)+0.8);
		if  (tmp < 0.85)
		return (Math.random()*(10-1.2)+1.2);
		//0.8 - 1.0
		return (Math.random()*(100-10)+10);
		
	}
	
	private int generateMoons(){
		
		int moons =0;
		
		for (float i =0; i<((float)_size);i+=0.5 ){
			
			if (Math.random()/(1+(moons*(1+(moons/2)))/(_size*3)) > 0.5){
				
				moons ++;
				
			}
				
			
			
		}
		
		
		return moons;
		
		
	}
	
	
	
	
	private double generateSize(){
		double size =-1;
		
		size += Math.random()*2;
		
		if (size<MINIMUM_PLANET_SIZE);
			size += Math.random();
		if (size<MINIMUM_PLANET_SIZE);
			size += Math.random()*10;
		if (size<MINIMUM_PLANET_SIZE);
			size += Math.random()*25;	
		if 	(Math.random()>0.5)
			size += Math.random();
		if 	(Math.random()>0.95)
			size += Math.random()*5;
		if 	(Math.random()>0.95)
			size += Math.random()*15;
		if 	(Math.random()>0.96)
			size += Math.random()*20;
		if 	(Math.random()>0.97)
			size += Math.random()*100;
		if 	(Math.random()>0.6)
			size = size/ (Math.random()*22 +1);
		if 	(Math.random()>0.3 && size>20)
			size = size/ (Math.random()*40 +1);
		
		
		size = size *1000;
		size =Math.round(size);
		size = size/1000;
		return size;
		
	}
	private String generateName(){
		String str ="";
		String planetName ="";
		char[] chars = {'a','b','c','d','e','f','g','h','A','B','X','1','2','3','4','5','6','7','8','9','/','-','i','j','k','l','m','n','o','p','A','A'};
		String tmpS = "";
		String tmpSold ="";
		
		planetName = "0123456";
		tmpS = String.valueOf(chars[(int)((Math.random()*chars.length-1))]);
		while (tmpS.equals("/") || tmpS.equals("-")){
			tmpS = String.valueOf(chars[(int)((Math.random()*chars.length-1))]);
		}
		planetName = tmpS + planetName.substring(1);
		tmpS = String.valueOf(chars[(int)((Math.random()*chars.length-1))]);
		planetName = planetName.substring(0, 1)+ tmpS + planetName.substring(2);
		tmpSold = tmpS;
		tmpS = String.valueOf(chars[(int)((Math.random()*chars.length-1))]);
		if (tmpSold.equals("/")||tmpSold.equals("-") ){
			
			while (tmpSold.equals(tmpS))
			{
				tmpS = String.valueOf(chars[(int)((Math.random()*chars.length-1))]);
				
			}
				
			
		}
			
		for (int i=2,j=3; i<6; i++,j++){
			
			
			planetName = planetName.substring(0, i)+ tmpS + planetName.substring(j);
			tmpSold = tmpS;
			tmpS = String.valueOf(chars[(int)((Math.random()*chars.length-1))]);
			if (tmpSold.equals("/")||tmpSold.equals("-") ){
				
				while (tmpSold.equals(tmpS))
				{
					tmpS = String.valueOf(chars[(int)((Math.random()*chars.length-1))]);
					
				}
					
				
			}

			
		}
		while (tmpS.equals("/") || tmpS.equals("-")){
			tmpS = String.valueOf(chars[(int)((Math.random()*chars.length-1))]);
		}
		planetName = planetName.substring(0, 6)+ tmpS;
		
		
		return planetName;
		
	}
	
	public String toString(){
		String str = "";
		str += "Planet " + _name + " : \n";
		str += "The size of the planet is "+ (_size<0.9?"only ":"") + _size + " times the size of earth"+(_size>29.99?"!!!":".")+"\n";
		str += _name + " has " +(_moons>0?_moons:"no") +" moon"+(_moons==1?".\n":"s.\n");
		double roundedDist = _distanceFromSun*100;
		roundedDist = Math.round(roundedDist);
		roundedDist = roundedDist/100;
		str += "Its distance from the sun is " +roundedDist+"AU (" + (int)((_distanceFromSun * 149600000)/1000000) + " Milion kilometers)\n" ;
		str += (_isGas==true?(_name+" is a gas giant"):"");
		
		
		return str;
		
		
	}
	
}

	