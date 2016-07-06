package SingleTon;

public class SingleTon1 {		//饿汉模式
	public static void main(String[] args) {
	//Singleton1 s1 = new Singleton1();
	Singleton2 s2 = Singleton2.getInstance();  
	
}

}

class Singleton1 {	//不成功的单例模式
	private  Singleton1 instance = new Singleton1();
	
	private Singleton1(){}	//私有的构造函数导致外部类不能创建实例
	
	public   Singleton1 getInstance(){	//由于外部类不能创建它的实例，因此
										//外部类无法访问他的成员变量和方法，
			return instance;			
	}
}

/* 饿汉模式:
 * 这种方式和名字很贴切，饥不择食，在类装载的时候就创建，
 * 不管你用不用，先创建了再说，如果一直没有被使用，便浪费了空间，
 * 典型的空间换时间，每次调用的时候，就不需要再判断，节省了运行时间。
 * 
 * */
class Singleton2 {	//饿汉模式
	private static Singleton2 instance = new Singleton2();
	
	private Singleton2(){}	//私有的构造函数导致外部类不能创建实例
	
	public  static Singleton2 getInstance(){	//声明为类变量可被外部类访问
												
			return instance;			
	}
}


/*懒汉模式：
 * 这两种懒汉式单例，名字起的也很贴切，一直等到对象实例化的时候才会创建，
 * 确实够懒，不用鞭子抽就不知道走了，典型的时间换空间，每次获取实例的时候才会判断
*  看是否需要创建，浪费判断时间，如果一直没有被使用，就不会被创建，节省空间。
*  
*  第一种方式，在多线程访问的时候，很可能会造成多次实例化，就不再是单例了.
*  第二种方式，在多线程情况下会造成线程阻塞，把大量的线程锁在外面，只有一个线程执行完毕才会执行下一个线程。
 * */

class Singleton3{			//线程不安全
	private Singleton3(){}
	
	private static Singleton3 instance = null;
	
	public static Singleton3 getInstance(){
		if(instance == null)
			instance = new Singleton3();
		return instance;
	}
}

class Singleton4{			//线程安全
	private Singleton4(){}
	
	private static Singleton4 instance = null;
	
	public static synchronized Singleton4 getInstance(){
		if(instance == null)
			instance = new Singleton4();
		return instance;
	}
}


/*DCT双检锁：
 *  被volatile修饰的变量的值，将不会被本地线程缓存，
 *  所有对该变量的读写都是直接操作共享内存，从而确保多个线程能正确的处理该变量。
 *  
 *  既可以达到线程安全，也可以使性能不受很大的影响，换句话说在保证线程安全的前提下，
 *  既节省空间也节省了时间，集合了饿汉式和两种懒汉式的优点，取其精华，去其槽粕。
*	所谓“双重检查加锁”机制，指的是：并不是每次进入getInstance方法都需要同步，
*	而是先不同步，进入方法后，先检查实例是否存在，如果不存在才进行下面的同步块，
*	这是第一重检查，进入同步块过后，再次检查实例是否存在，如果不存在，就在同步的情况下创建一个实例，
*	这是第二重检查。这样一来，就只需要同步一次了，从而减少了多次在同步情况下进行判断所浪费的时间。
 * */
class Singleton5{
	private Singleton5(){}
	
	private volatile static Singleton5 instance = null;	//声明为volatile变量
	
	public static Singleton5 getInstance(){
		if(instance == null)
			synchronized (Singleton5.class) {
				if(instance == null)
					instance = new Singleton5();
			}
		return instance;
	}
}













