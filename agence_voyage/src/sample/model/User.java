package sample.model;

public class User {

	private int id_user;
	private String email_user;
	private String password_user;
	public static int us;
	private double rat;

	public static String getEm() {
		return em;
	}

	public static void setEm(String em) {
		User.em = em;
	}

	public static String em;

	public User(int id_user, String email_user, String password_user) {
		super();
		this.id_user = id_user;
		this.email_user = email_user;
		this.password_user = password_user;
	}
	public User(int id_user, String email_user, String password_user,double rat) {
		super();
		this.id_user = id_user;
		this.email_user = email_user;
		this.password_user = password_user;
		this.rat=rat;
	}

	public User() {
		super();
	}

	public int getId_user() {
		return id_user;
	}

	public void setRating(double rat) {
		this.rat = rat;
	}
	public double getRating() {
		return rat;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public String getEmail_user() {
		return email_user;
	}

	public void setEmail_user(String email_user) {
		this.email_user = email_user;
	}

	public String getPassword_user() {
		return this.password_user;
	}

	public void setPassword_user(String password_user) {
		this.password_user = password_user;
	}

}
