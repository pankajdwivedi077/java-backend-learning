package learning;

public class SpringBootCourse implements Course {

	@Override
	public boolean coursePurchase() {
		System.out.println("SpringBoot course purchased");;
		return true;
	}

}
