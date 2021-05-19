package org.project.co.Timing;

public class Timer {
    private long elapsed=0;
    private long stored=0;
    private int state=0;//we use the int for the state,0 is stopped, 1 is paused, 2 is running
    public void start()
    {
        stored=0;
        resume();
    }
    public long stop(){
        if(state==2) {
            elapsed = System.nanoTime() - elapsed;
            state = 0;
            stored += elapsed;
            return stored;
        }
        else
            return stored;
    }
    public long pause(){
        elapsed=System.nanoTime()-elapsed;
        state=1;
        stored+=elapsed;
        return stored;
    }
    public void resume(){
        state=2;
        elapsed=System.nanoTime();
    }
    public long checkTime(){
        return stored;
    }
}
