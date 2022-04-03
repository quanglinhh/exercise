package part4.ex3;

public class MessageThread extends Thread{
    String message;
    int timeOut;
    String priority;
//    public void MessageThread(String message, int timeOut, String priority){
//        this.message = message;
//        this.timeOut = timeOut;
//        this.priority = priority;
//    }
    public void MessageThread(){

    }


    public void setMessage(String message) {
        this.message = message;
    }

    public int getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(int timeOut) {
        this.timeOut = timeOut;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    @Override
    public void run() {
        while (true){
            System.out.println(message);
            try{
                Thread.sleep(timeOut);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }


}
