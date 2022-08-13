package view.week1_2;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MazeDisplayer extends Canvas {
    int [][] mazeData;
    private StringProperty wallFileName;
    int cCol;
    int cRow;


    public int getcCol() {
        return cCol;
    }

    public void setcCol(int cCol) {
        this.cCol = cCol;
    }

    public int getcRow() {
        return cRow;
    }

    public void setcRow(int cRow) {
        this.cRow = cRow;
    }

    public void setCharacterPostion(int row,int col){
        this.cCol=col;
        this.cRow=row;
        readDraw();
    }

    public MazeDisplayer() {
        this.wallFileName = new SimpleStringProperty() ;
        cCol=0;
        cRow=1;
    }

    public String getWallFileName() {
        return wallFileName.get();
    }

    public StringProperty wallFileNameProperty() {
        return wallFileName;
    }

    public void setWallFileName(String wallFileName) {
        this.wallFileName.set(wallFileName);
    }


    public int[][] getMazeData() {
        return mazeData;
    }

    public void setMazeData(int[][] mazeData) {
        this.mazeData = mazeData;
        readDraw();
    }

    public void readDraw(){
        if(mazeData!=null){
            double H=getHeight();
            double W=getWidth();
            double w=W/mazeData[0].length;
            double h=H/mazeData.length;

            GraphicsContext gc=getGraphicsContext2D();
            Image wall= null;
            try {
                wall = new Image(new FileInputStream(wallFileName.get()));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            gc.clearRect(0,0,W,H);//למחוק הכל

            for(int i=0;i<mazeData.length;i++){
                for(int j=0;j<mazeData[i].length;j++){
                    if(mazeData[i][j]!=0)
                        if(wall==null)
                        gc.fillRect(j*w,i*h,w,h);//צביעת מלבן
                       else
                        gc.drawImage(wall,j*w,i*h,w,h);//תמונה
                }
            }

            gc.setFill(Color.RED);//דמות
            gc.fillOval(cCol*w,cRow*h,w,h);



        }
}
}
