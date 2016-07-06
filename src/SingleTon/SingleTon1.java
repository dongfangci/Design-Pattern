package SingleTon;

public class SingleTon1 {		//����ģʽ
	public static void main(String[] args) {
	//Singleton1 s1 = new Singleton1();
	Singleton2 s2 = Singleton2.getInstance();  
	
}

}

class Singleton1 {	//���ɹ��ĵ���ģʽ
	private  Singleton1 instance = new Singleton1();
	
	private Singleton1(){}	//˽�еĹ��캯�������ⲿ�಻�ܴ���ʵ��
	
	public   Singleton1 getInstance(){	//�����ⲿ�಻�ܴ�������ʵ�������
										//�ⲿ���޷��������ĳ�Ա�����ͷ�����
			return instance;			
	}
}

/* ����ģʽ:
 * ���ַ�ʽ�����ֺ����У�������ʳ������װ�ص�ʱ��ʹ�����
 * �������ò��ã��ȴ�������˵�����һֱû�б�ʹ�ã����˷��˿ռ䣬
 * ���͵Ŀռ任ʱ�䣬ÿ�ε��õ�ʱ�򣬾Ͳ���Ҫ���жϣ���ʡ������ʱ�䡣
 * 
 * */
class Singleton2 {	//����ģʽ
	private static Singleton2 instance = new Singleton2();
	
	private Singleton2(){}	//˽�еĹ��캯�������ⲿ�಻�ܴ���ʵ��
	
	public  static Singleton2 getInstance(){	//����Ϊ������ɱ��ⲿ�����
												
			return instance;			
	}
}


/*����ģʽ��
 * ����������ʽ�������������Ҳ�����У�һֱ�ȵ�����ʵ������ʱ��Żᴴ����
 * ȷʵ���������ñ��ӳ�Ͳ�֪�����ˣ����͵�ʱ�任�ռ䣬ÿ�λ�ȡʵ����ʱ��Ż��ж�
*  ���Ƿ���Ҫ�������˷��ж�ʱ�䣬���һֱû�б�ʹ�ã��Ͳ��ᱻ��������ʡ�ռ䡣
*  
*  ��һ�ַ�ʽ���ڶ��̷߳��ʵ�ʱ�򣬺ܿ��ܻ���ɶ��ʵ�������Ͳ����ǵ�����.
*  �ڶ��ַ�ʽ���ڶ��߳�����»�����߳��������Ѵ������߳��������棬ֻ��һ���߳�ִ����ϲŻ�ִ����һ���̡߳�
 * */

class Singleton3{			//�̲߳���ȫ
	private Singleton3(){}
	
	private static Singleton3 instance = null;
	
	public static Singleton3 getInstance(){
		if(instance == null)
			instance = new Singleton3();
		return instance;
	}
}

class Singleton4{			//�̰߳�ȫ
	private Singleton4(){}
	
	private static Singleton4 instance = null;
	
	public static synchronized Singleton4 getInstance(){
		if(instance == null)
			instance = new Singleton4();
		return instance;
	}
}


/*DCT˫������
 *  ��volatile���εı�����ֵ�������ᱻ�����̻߳��棬
 *  ���жԸñ����Ķ�д����ֱ�Ӳ��������ڴ棬�Ӷ�ȷ������߳�����ȷ�Ĵ���ñ�����
 *  
 *  �ȿ��Դﵽ�̰߳�ȫ��Ҳ����ʹ���ܲ��ܴܺ��Ӱ�죬���仰˵�ڱ�֤�̰߳�ȫ��ǰ���£�
 *  �Ƚ�ʡ�ռ�Ҳ��ʡ��ʱ�䣬�����˶���ʽ����������ʽ���ŵ㣬ȡ�侫����ȥ����ɡ�
*	��ν��˫�ؼ����������ƣ�ָ���ǣ�������ÿ�ν���getInstance��������Ҫͬ����
*	�����Ȳ�ͬ�������뷽�����ȼ��ʵ���Ƿ���ڣ���������ڲŽ��������ͬ���飬
*	���ǵ�һ�ؼ�飬����ͬ��������ٴμ��ʵ���Ƿ���ڣ���������ڣ�����ͬ��������´���һ��ʵ����
*	���ǵڶ��ؼ�顣����һ������ֻ��Ҫͬ��һ���ˣ��Ӷ������˶����ͬ������½����ж����˷ѵ�ʱ�䡣
 * */
class Singleton5{
	private Singleton5(){}
	
	private volatile static Singleton5 instance = null;	//����Ϊvolatile����
	
	public static Singleton5 getInstance(){
		if(instance == null)
			synchronized (Singleton5.class) {
				if(instance == null)
					instance = new Singleton5();
			}
		return instance;
	}
}













