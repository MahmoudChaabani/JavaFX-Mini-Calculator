import javafx.application.Application;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.geometry.Insets;
public class CalculatorInterface extends Application {

    @Override
    public void start(Stage stage){

        Group root = new Group();
        Scene scene = new Scene(root,root.getBoundsInParent().getWidth(),root.getBoundsInParent().getHeight());
        Label display = new Label("0");
        GridPane grid = new GridPane();


        scene.getStylesheets().add(getClass().getResource("/CalculatorInterfaceCss/CalculatorInterface.css").toExternalForm());
        // create an instance of each button from 0 to 9 and save them in table
        Button[] buttons = new Button[19];
        String[] SpecialButtons = {"+","-","*","/","%","^","del","clear","="};
        for(int i = 0; i < buttons.length; i++){
            if(i >=10){
                buttons[i] = new Button(String.valueOf(SpecialButtons[i-10]));
            }else{
            buttons[i] = new Button(String.valueOf(i));}
        }
        //gives each button the style that provided for buttons in "CalculatorInterface.css"
        for(Button button : buttons){
            if(!(button.getText().equals("=")||button.getText().equals("clear"))) {
                button.getStyleClass().add("button");}

        }

        grid.setHgap(10);
        grid.setVgap(10);
        // set each button to right position in the gridPane
        for(int i = 1; i < 10; i++){
            int row=(i-1) / 3 + 1;
            int col=(i-1) % 3;
            grid.add(buttons[i],col,row);
        }
        grid.add(buttons[10],3,1);
        grid.add(buttons[11],3,2);
        grid.add(buttons[12],3,3);
        grid.add(buttons[13],3,4);
        grid.add(buttons[14],2,4);
        grid.add(buttons[15],1,4);
        grid.add(buttons[16],0,4);
        grid.add(buttons[17],2,5);
        grid.add(buttons[18],0,5);
        buttons[17].setStyle("-fx-pref-width:110px;");
        buttons[18].setStyle("-fx-pref-width:110px;");
        GridPane.setColumnSpan(buttons[17],2);
        GridPane.setColumnSpan(buttons[18],2);



        root.getChildren().add(grid);


        display.setBackground(
                new Background(
                        new BackgroundFill(Color.web("#D3D3D3"),null,null)
                )
        );
        display.setPadding(new Insets(0, 0, 0, 10));
        display.setPrefSize(232,50);
        grid.add(display,0,0);
        GridPane.setColumnSpan(display,4);

        StringBuilder sequenceOfNum = new StringBuilder();
        Calculation equations = new Calculation();
        for(int i = 0; i < buttons.length; i++){
            String value = buttons[i].getText();

            buttons[i].setOnAction(e -> {
                if(value.equals("clear")){
                sequenceOfNum.setLength(0);
                }
                try{
                    if(value.equals("del")){
                        sequenceOfNum.setLength(sequenceOfNum.length()-1);}

                }catch(Exception ex){
                    sequenceOfNum.setLength(0);
                }

                if(!(value.equals("clear") || value.equals("del"))){
                sequenceOfNum.append(value);
                }
                display.setText(sequenceOfNum.toString());

                if(value.equals("=")){
                    if(!Calculation.checkError(sequenceOfNum.toString())){
                    System.out.println(sequenceOfNum.toString());
                    equations.mainCalculation(sequenceOfNum.toString().substring(0,sequenceOfNum.length()-1));
                    sequenceOfNum.append(String.valueOf(equations.total));
                    display.setText(sequenceOfNum.toString());
                    sequenceOfNum.setLength(0);

                    }
                    else{
                        display.setText("Error");
                        sequenceOfNum.setLength(0);
                    }
                }
                System.out.println(sequenceOfNum.toString());
            });
        }


        stage.setTitle("Calculator");
        stage.setScene(scene);
        stage.show();

        root.setLayoutX(
                (scene.getWidth() - root.getBoundsInParent().getWidth()) / 2
        );

        root.setLayoutY(
                (scene.getHeight() - root.getBoundsInParent().getHeight()) / 2
        );
    }

    public static void main(String[] args) {
        launch(args);
    }
}

