package com.moshkova.elena.models;

public enum Status {
    READING,
    DELITED,
    RUN
     {
        private void count(Integer balanc, Integer count) {
            balanc -= count;
        }
    }



}
