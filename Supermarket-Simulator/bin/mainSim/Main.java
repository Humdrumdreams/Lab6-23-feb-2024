����   > B  mainSim/Main  java/lang/Object <init> ()V Code
  	   LineNumberTable LocalVariableTable this LmainSim/Main; main ([Ljava/lang/String;)V  generellSim/EventQueue
  	  snabbköp/SnabbköpTillstånd      �@       @      ?�      @$      
     ! (IIDJDDDDD)V # snabbköp/SnabbköpSim
 " %  & :(LgenerellSim/EventQueue;Lsnabbköp/SnabbköpTillstånd;)V ( #snabbköp/händelser/Starthändelse
 ' *  + ;(Lsnabbköp/SnabbköpTillstånd;LgenerellSim/EventQueue;D)V
  - . / addEvent (LgenerellSim/Event;)Z 1 "snabbköp/händelser/Stophändelse@y      
 0 *
 " 6 7  	runEvents args [Ljava/lang/String; eQ LgenerellSim/EventQueue; 
tillstånd Lsnabbköp/SnabbköpTillstånd; snabbköpSim Lsnabbköp/SnabbköpSim; 
SourceFile 	Main.java !               /     *� �    
       
             	       �     S� Y� L� Y     � M� "Y+,� $N+� 'Y,+� )� ,W+� 0Y,+ 2� 4� ,W-� 5�    
   F                            $  . ! = $ N & R (    *    S 8 9    K : ;  $ / < =  . % > ?   @    A