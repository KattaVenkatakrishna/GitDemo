package pagefactory;

import org.testng.annotations.DataProvider;

public class Datasupply {
	@DataProvider(name="data")
	public Object supplyData() {
		Object[][] data = {{"standard","secret_sauce"},{"error_use","secret_sauce"},{"Admin","admin123"}};
		return data;
	}
}
