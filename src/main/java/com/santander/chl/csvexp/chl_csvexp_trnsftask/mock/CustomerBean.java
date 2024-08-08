package com.santander.chl.csvexp.chl_csvexp_trnsftask.mock;

public class CustomerBean extends PersonBean implements Customer {

	private String customerNo;
	private long loyaltyPoints;
	private String mailingAddress;

	public CustomerBean() {
	}

	public CustomerBean(final String customerNo, final String firstName, final String lastName,
			final String mailingAddress, final Boolean married, final Integer numberOfKids, final String favouriteQuote,
			final String email, final long loyaltyPoints) {
		super(firstName, lastName, married, numberOfKids, favouriteQuote, email);
		this.customerNo = customerNo;
		this.loyaltyPoints = loyaltyPoints;
		this.mailingAddress = mailingAddress;
	}

	public String getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}

	public long getLoyaltyPoints() {
		return loyaltyPoints;
	}

	public void setLoyaltyPoints(long loyaltyPoints) {
		this.loyaltyPoints = loyaltyPoints;
	}

	public String getMailingAddress() {
		return mailingAddress;
	}

	public void setMailingAddress(String mailingAddress) {
		this.mailingAddress = mailingAddress;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((customerNo == null) ? 0 : customerNo.hashCode());
		result = prime * result + (int) (loyaltyPoints ^ (loyaltyPoints >>> 32));
		result = prime * result + ((mailingAddress == null) ? 0 : mailingAddress.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof CustomerBean)) {
			return false;
		}
		CustomerBean other = (CustomerBean) obj;
		if (customerNo == null) {
			if (other.customerNo != null) {
				return false;
			}
		} else if (!customerNo.equals(other.customerNo)) {
			return false;
		}
		if (loyaltyPoints != other.loyaltyPoints) {
			return false;
		}
		if (mailingAddress == null) {
			if (other.mailingAddress != null) {
				return false;
			}
		} else if (!mailingAddress.equals(other.mailingAddress)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return String.format(
				"CustomerBean [customerNo=%s, firstName=%s, lastName=%s, mailingAddress=%s, married=%s, numberOfKids=%s, favouriteQuote=%s, email=%s, loyaltyPoints=%s]",
				customerNo, getFirstName(), getLastName(), mailingAddress, getMarried(), getNumberOfKids(),
				getFavouriteQuote(), getEmail(), loyaltyPoints);
	}

}