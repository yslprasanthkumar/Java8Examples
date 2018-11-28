class Movie{
		private String name;
		private Integer nameId;
		
		public Movie(int nameId, String name) {
			this.nameId=nameId;
			this.name=name;
		}
		
		public Movie(String name) {
			this.name=name;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Integer getNameId() {
			return nameId;
		}
		public void setNameId(Integer nameId) {
			this.nameId = nameId;
		}
	}