package IntermediateOOP;

public class SingletonClass {

		private static SingletonClass get_Instance = null;
		
		public String s;
		
		private SingletonClass() {
			s = "Hello, This is singleton class.";
		}
		public static SingletonClass getIntance() {
			if(get_Instance == null) {
				get_Instance = new SingletonClass();
			}
			return get_Instance;
		}

}
