package com.santander.chl.csvexp.chl_csvexp_trnsftask.mock;

public class PersonBean {

	private String firstName;
	private String lastName;
	private Boolean married;
	private Integer numberOfKids;
	private String favouriteQuote;
	private String email;

	public PersonBean() {
	}

	public PersonBean(final String firstName, final String lastName, final Boolean married, final Integer numberOfKids,
			final String favouriteQuote, final String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.married = married;
		this.numberOfKids = numberOfKids;
		this.favouriteQuote = favouriteQuote;
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Boolean getMarried() {
		return married;
	}

	public void setMarried(Boolean married) {
		this.married = married;
	}

	public Integer getNumberOfKids() {
		return numberOfKids;
	}

	public void setNumberOfKids(Integer numberOfKids) {
		this.numberOfKids = numberOfKids;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFavouriteQuote() {
		return favouriteQuote;
	}

	public void setFavouriteQuote(String favouriteQuote) {
		this.favouriteQuote = favouriteQuote;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((favouriteQuote == null) ? 0 : favouriteQuote.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((married == null) ? 0 : married.hashCode());
		result = prime * result + ((numberOfKids == null) ? 0 : numberOfKids.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof PersonBean)) {
			return false;
		}
		PersonBean other = (PersonBean) obj;
		if (email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!email.equals(other.email)) {
			return false;
		}
		if (favouriteQuote == null) {
			if (other.favouriteQuote != null) {
				return false;
			}
		} else if (!favouriteQuote.equals(other.favouriteQuote)) {
			return false;
		}
		if (firstName == null) {
			if (other.firstName != null) {
				return false;
			}
		} else if (!firstName.equals(other.firstName)) {
			return false;
		}
		if (lastName == null) {
			if (other.lastName != null) {
				return false;
			}
		} else if (!lastName.equals(other.lastName)) {
			return false;
		}
		if (married == null) {
			if (other.married != null) {
				return false;
			}
		} else if (!married.equals(other.married)) {
			return false;
		}
		if (numberOfKids == null) {
			if (other.numberOfKids != null) {
				return false;
			}
		} else if (!numberOfKids.equals(other.numberOfKids)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return String.format(
				"PersonBean [firstName=%s, lastName=%s, married=%s, numberOfKids=%s, favouriteQuote=%s, email=%s]",
				firstName, lastName, married, numberOfKids, favouriteQuote, email);
	}
}
