

import java.util.Date;
import java.util.Random;

import org.testng.annotations.Test;

public class JavaUtil {
	@Test
	public void createRandomnumber() {
	Random random = new Random();
	int number=random.nextInt(1002);
	System.out.println(number);
}
	
	public int createRandomnumber1() {
		Random random = new Random();
		int number=random.nextInt(1002);
		return number;
	}

	public String getDate() {
		Date date = new Date();
		return date.toString();
	}

}



