����   > U  generellSim/Sim  java/lang/Object eQ LgenerellSim/EventQueue; state LgenerellSim/SimState; view LgenerellSim/SimView; <init> 1(LgenerellSim/EventQueue;LgenerellSim/SimState;)V Code
     ()V	    	    
     
createView ()LgenerellSim/SimView;	   	 
 LineNumberTable LocalVariableTable this LgenerellSim/Sim; 	runEvents
 ! # " generellSim/EventQueue $ % getNextEvent ()LgenerellSim/Event;
 ' ) ( generellSim/Event *  executeEvent
 ' , - . getTimeOfEvent ()D
 0 2 1 generellSim/SimState 3 4 setTime (D)V
 6 8 7 generellSim/SimView 9 : update +(Ljava/util/Observable;Ljava/lang/Object;)V
 0 < = > simulationRunning ()Z	 @ B A java/lang/System C D out Ljava/io/PrintStream; F Rad 54 i Sim, stopp
 H J I java/io/PrintStream K L print (Ljava/lang/String;)V
 ! N O > isEmpty 	nextEvent LgenerellSim/Event; StackMapTable 
SourceFile Sim.java!                 	 
           e     *� *+� *,� **� � �              	      !                                     �     F� ;*� �  L+� &*� +� +� /*� *� � 5*� � ;� � ?E� G� *� � M����       * 
   /  0  1  2  3 & 4 0 5 8 6 ; / E 9        F      0 P Q  R    7	  S    T