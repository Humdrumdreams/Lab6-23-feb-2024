����   > .  generellSim/SimState  java/util/Observable simulationRunning Z time D <init> ()V Code
   	 
	    	     LineNumberTable LocalVariableTable this LgenerellSim/SimState; startSimulation
    
 notifyObservers stopSimulation ()Z getTime ()D setTime (D)V update (LgenerellSim/Event;)V
 # % $ generellSim/Event &  getTimeOfEvent
  ( ) 
 
setChanged e LgenerellSim/Event; 
SourceFile SimState.java!                  	 
     E     *� *� *� �             
 	                  
     <     
*� *� �              	         
       
     <     
*� *� �              	         
            /     *� �                               /     *� �           #                    >     *'� �       
    '  (                      !     Q     *+� "� *� '*� �           ,  -  .  /                * +   ,    -