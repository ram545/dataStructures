
class Singleton implements Serializable, Cloneable{

	private static Singleton instance;

	private Singleton(){
	}

	public static Singleton getInstance(){
		if(instance == null){
			instance = new Singleton();
		}
		return instance;
	}

	@Override
	protected object clone(){
		return instance;
	}

	@Override
	protected object readResolve(){
		return instance;
	}

}


/* protect against reflection since we cannot access enum constructors outside unlike a class
public enum Singleton{
	private instance;

}
*/


public class SingletonPattern {

    public static void main(String... args){
        Singleton s = Singleton.getInstance();
        Singleton s1 = Singleton.getInstance();

        System.out.println(s.hashCode() + " " + s1.hashCode());
    }
}
