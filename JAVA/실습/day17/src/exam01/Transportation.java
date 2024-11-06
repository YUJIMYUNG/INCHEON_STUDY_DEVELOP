package exam01;

public enum Transportation {
    BUS("버스"){
        @Override
        public int getTotal(int person) {
            return person * 1500;
        }
    },
    SUBWAY("지하철"){
        @Override
        public int getTotal(int person) {
            return person * 1450;
        }
    },
    TAXI("택시"){
        @Override
        public int getTotal(int person) {
            return person * 4500;
        }
    };

    private final String title;

    Transportation(String title) { //무조건 private
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public abstract  int getTotal(int person);
}
