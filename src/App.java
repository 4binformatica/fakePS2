public class App {
    public static void main(String[] args) throws Exception {
        //System.out.println("Hello, World!");
        Debugger.log("Sample debug log!");
        Debugger.warn("Sample debug warn!");
        Debugger.err("Sample debug err!");
        new MainWindow();
         
    }
}
