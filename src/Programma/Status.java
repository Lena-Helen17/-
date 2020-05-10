package Programma;

public enum Status {
    READING,
    DELITED,
    RUN
     {
        private void count(Integer balanc, Integer cout) {
            balanc -= cout;
        }
    }



}
