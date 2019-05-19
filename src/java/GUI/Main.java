package GUI;

import businesstier.EJBFacadeRemote;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.ejb.EJB;


public class Main extends Application {

    @EJB
    private static EJBFacadeRemote facade;
//    static Facade facade = new Facade();
//
//    public static Facade getFacade() {
//        return facade;
//    }
//
//    public static void setFacade(Facade facade) {
//        Main.facade = facade;
//    }

    public static EJBFacadeRemote getFacade() {
        return facade;
    }

    public static void setFacade(EJBFacadeRemote facade) {
        Main.facade = facade;
    }
    
    
    
    static Stage stg;
    @Override
    public void start(Stage primaryStage) throws Exception{
        this.stg = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
        primaryStage.setTitle("Rental");
        primaryStage.setResizable(false);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
