����   > -  !randomNum/ExponentialRandomStream  java/lang/Object rand Ljava/util/Random; arrivalRate D <init> (DJ)V Code
   	  ()V  java/util/Random
   	  (J)V	    	     LineNumberTable LocalVariableTable this #LrandomNum/ExponentialRandomStream; seed J (D)V
   next ()D
  # $ ! 
nextDouble
 & ( ' java/lang/Math ) * log (D)D 
SourceFile ExponentialRandomStream.java !                  	 
     `     *� *� Y!� � *'� �                                            	      U     *� *� Y� � *'� �           $  %  &  '                      !     ;     *� � "� %w*� o�           /              +    ,