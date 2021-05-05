
public class MedicalInstrument {
     public static void main(String [] args) {
           Cutter c=new Cutter();
           c.cut();
           System.out.println("----------");
           Needle n=new Needle();
           n.Stitch();
     }
}
abstract class SurgicalInstrument{
	  
}
class Cutter extends SurgicalInstrument{
	void cut() {System.out.println("cutting the skin.....");}
	
}
class Needle extends SurgicalInstrument{
	void Stitch() {System.out.println("Stitching the skin.....");}
}