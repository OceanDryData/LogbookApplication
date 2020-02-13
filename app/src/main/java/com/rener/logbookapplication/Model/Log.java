package com.rener.logbookapplication.Model;

public class Log {
    private String logname;

    public Log(){}

    public Log(String logname) {
        this.logname = logname;
    }

    public String getName() {
        return logname;
    }

    public void setName(String logname) {
        this.logname = logname;
    }

}
