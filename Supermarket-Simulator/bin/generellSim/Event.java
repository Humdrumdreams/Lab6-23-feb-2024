����   > 6  generellSim/Event  java/lang/Object state LgenerellSim/SimState; eQ LgenerellSim/EventQueue; timeOfEvent D eventHappened Z <init> 2(LgenerellSim/SimState;LgenerellSim/EventQueue;D)V Code
     ()V  "java/lang/IllegalArgumentException  #State and EventQueue cannot be null
     (Ljava/lang/String;)V	    	    	   	 
 LineNumberTable LocalVariableTable this LgenerellSim/Event; StackMapTable & generellSim/SimState ( generellSim/EventQueue executeEvent getName ()Ljava/lang/String; getTimeOfEvent ()D hasEventHappened ()Z	  1   setEventHappened (Z)V 
SourceFile 
Event.java!                 	 
                �     &*� +� ,� � Y� �*+� *,� *)� �                         % ! !   *    & " #     &      &      & 	 
  $    �    % '  	 )    * +    , -     /     *� �            5 !        " #    . /     /     *� 0�            > !        " #    2 3     >     *� 0�        
    G  H !        " #          4    5