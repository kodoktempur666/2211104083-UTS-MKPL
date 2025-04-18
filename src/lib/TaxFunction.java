package lib;

public class TaxFunction {

	private static final int PTKP_SINGLE = 54000000;
	private static final int PTKP_MARRIED = 4500000;
	private static final int PTKP_PER_CHILD = 1500000;
	private static final double TAX_RATE = 0.05;

	public static int calculateTax(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking,
			int deductible, boolean isMarried, int numberOfChildren) {

		if (numberOfMonthWorking > 12) {
			System.err.println("More than 12 months working per year");
		}

		if (numberOfChildren > 3) {
			numberOfChildren = 3;
		}

		int nonTaxableIncome = PTKP_SINGLE;
		if (isMarried) {
			nonTaxableIncome += PTKP_MARRIED;
		}
		nonTaxableIncome += numberOfChildren * PTKP_PER_CHILD;

		double taxableIncome = ((monthlySalary + otherMonthlyIncome) * numberOfMonthWorking)
				- deductible - nonTaxableIncome;

		int tax = (int) Math.round(TAX_RATE * taxableIncome);

		return Math.max(tax, 0);
	}
}
