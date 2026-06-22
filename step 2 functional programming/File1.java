@FunctionalInterface
interface BookAction {
    void perform();
}

public class File1 {
    public static void main(String[] args){

    BookAction action = new BookAction(){
        @Override
        public void perform(){
            System.out.println("over");
        }
    };

    action.perform();

    BookAction bkk = () -> {
        // System.out.println("smoke");
    };

    bkk.perform();

    BookAction bk = () -> System.out.println("lamba");

    bk.perform();

    }
}  
// only one abstract method in functional interface
// lamba expressions provide implemenention for functional interface