package gwm.constants;

/**
 * 
 * from: http://crunchify.com/why-and-for-what-should-i-use-enum-java-enum-examples/
 * 
 * @author gwmccort
 *
 */
public class CompanyConstantUsingEnum {

	public enum Company {
		EBAY, PAYPAL, GOOGLE, YAHOO, ATT
	}

	Company cName;

	public CompanyConstantUsingEnum(Company cName) {
		this.cName = cName;
	}

	public void companyDetails() {
		switch (cName) {
		case EBAY:
			System.out.println("Biggest Market Place in the World.");
			break;

		case PAYPAL:
			System.out.println("Simplest way to manage Money.");
			break;

		case GOOGLE:
		case YAHOO:
			System.out.println("1st Web 2.0 Company.");
			break;

		default:
			System.out.println("Google - biggest search giant.. ATT - my carrier provider..");
			break;
		}
	}

	public static void main(String[] args) {
		CompanyConstantUsingEnum ebay = new CompanyConstantUsingEnum(Company.EBAY);
		ebay.companyDetails();
		CompanyConstantUsingEnum paypal = new CompanyConstantUsingEnum(Company.PAYPAL);
		paypal.companyDetails();
		CompanyConstantUsingEnum google = new CompanyConstantUsingEnum(Company.GOOGLE);
		google.companyDetails();
		CompanyConstantUsingEnum yahoo = new CompanyConstantUsingEnum(Company.YAHOO);
		yahoo.companyDetails();
		CompanyConstantUsingEnum att = new CompanyConstantUsingEnum(Company.ATT);
		att.companyDetails();
	}

}
