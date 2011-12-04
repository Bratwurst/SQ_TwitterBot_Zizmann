public class User_Obj {

	private String name;

	private String vorname;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public User_Obj(String name, String vorname) {
		super();
		this.name = name;
		this.vorname = vorname;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((vorname == null) ? 0 : vorname.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;

	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;

		if (getClass() != obj.getClass()) {
			return false;
		}

		User_Obj other = (User_Obj) obj;

		return this.vorname.equals(other.getVorname())
				&& this.name == other.getName();
	}
}
