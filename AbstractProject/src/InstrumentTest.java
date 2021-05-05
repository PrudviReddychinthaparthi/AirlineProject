
public class InstrumentTest {
     public static void main(String[] args) {
    	Guitar g= new Guitar();
    	 g.use();
    	 g.play();
    	 g.tuneStrings();
    	 g.plucking();
    	 System.out.println("-------------");
    	 Violin v= new Violin();
    	 v.use();
    	 v.play();
    	 v.tuneStrings();
    	 v.bowing();
    	 System.out.println("-------------");
    	 Flute f=new Flute();
    	 f.use();
    	 f.play();
    	 f.operate();
    	 f.blow();
    	 System.out.println("-------------");
    	 Saxophone s=new Saxophone();
    	 s.use();
    	 s.play();
    	 s.operate();
    	 s.blow();
    	 System.out.println("-------------");
    	 tabala t=new tabala();
    	 t.use();
    	 t.play();
    	 t.operate();
    	 t.beat();

     }
	
}
abstract class Instrument{
	abstract void use();
}
abstract class MusicalInstrument extends Instrument{
	abstract void play();
}
abstract class StringBasedMusicalInstrument extends MusicalInstrument{
	abstract void tuneStrings();
}
abstract class AirBasedMusicalInstrument extends MusicalInstrument{
	abstract void blow();
}
abstract class MembraneBasedMusicalInstrument extends MusicalInstrument{
	abstract void beat();
}
class Guitar extends StringBasedMusicalInstrument{
	void use() {System.out.println("Using guitar...");}
	void play() {System.out.println("playing guitar...");}
    void tuneStrings() {System.out.println("tuning guitar strings...");}
    void  plucking() {System.out.println("Plucking guitar Strings...");}
}
class Violin extends StringBasedMusicalInstrument{
	void use() {System.out.println("Using violin...");}
	void play() {System.out.println("playing violin...");}
    void tuneStrings() {System.out.println("tuning violin strings...");}
    void  bowing() {System.out.println("Bowing violin Strings...");}
}
class Flute extends AirBasedMusicalInstrument{
	void use() {System.out.println("Using Flute...");}
	void play() {System.out.println("playing Flute...");}
    void operate() {System.out.println("operating Flute...");}
	void  blow() {System.out.println("Blowinging Flute...");}
		
	}
class Saxophone extends AirBasedMusicalInstrument{
	void use() {System.out.println("Using Saxophone...");}
	void play() {System.out.println("playing Saxophone...");}
    void operate() {System.out.println("operating Saxophone...");}
	void  blow() {System.out.println("Blowinging Saxophone...");}
		
	}
class tabala extends MembraneBasedMusicalInstrument{
	void use() {System.out.println("Using tabala...");}
	void play() {System.out.println("playing tabala...");}
	void operate() {System.out.println("operating tabala...");}
    void  beat() {System.out.println("Beating tabala...");}
}
