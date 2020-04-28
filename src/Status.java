public enum Status {
    READING,
    RUN,
    DELITED {
        private void count(Integer balanc, Integer cout) {
            balanc += cout;
        }
    }



}
