package com.example.quese.models;

public class Question {
     String image;
     String btn1;
     String btn2;
     String btn3;
     String btn4;
     String right;



     public Question(String image, String btn1, String btn2, String btn3, String btn4, String right) {
          this.image = image;
          this.btn1 = btn1;
          this.btn2 = btn2;
          this.btn3 = btn3;
          this.btn4 = btn4;
          this.right = right;

     }

     public String getImage() {
          return image;
     }

     public void setImage(String image) {
          this.image = image;
     }

     public String getBtn1() {
          return btn1;
     }

     public void setBtn1(String btn1) {
          this.btn1 = btn1;
     }

     public String getBtn2() {
          return btn2;
     }

     public void setBtn2(String btn2) {
          this.btn2 = btn2;
     }

     public String getBtn3() {
          return btn3;
     }

     public void setBtn3(String btn3) {
          this.btn3 = btn3;
     }

     public String getBtn4() {
          return btn4;
     }

     public void setBtn4(String btn4) {
          this.btn4 = btn4;
     }

     public String getAnswer() {
          return right;
     }

     public void setRight(String right) {
          this.right = right;
     }

}