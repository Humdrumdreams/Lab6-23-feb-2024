����   > V  #snabbköp/händelser/Starthändelse  generellSim/Event 
tillstånd Lsnabbköp/SnabbköpTillstånd; <init> ;(Lsnabbköp/SnabbköpTillstånd;LgenerellSim/EventQueue;D)V Code
     2(LgenerellSim/SimState;LgenerellSim/EventQueue;D)V	     LineNumberTable LocalVariableTable this %Lsnabbköp/händelser/Starthändelse; eQ LgenerellSim/EventQueue; timeOfEvent D executeEvent ()V
    snabbköp/SnabbköpTillstånd   öppnaSnabbköp	  !   java/lang/System " # out Ljava/io/PrintStream; % 6Snabbköpet är nu öppet och redo att ta emot kunder.
 ' ) ( java/io/PrintStream * + println (Ljava/lang/String;)V - !snabbköp/händelser/övrigt/Kund
 , /  0 "(Lsnabbköp/SnabbköpTillstånd;)V
  2 3 4 getTimeOfEvent ()D
  6 7 8 getNästaAnkomstTid (D)D	  :   < %snabbköp/händelser/Ankomsthändelse
 ; >  ? ^(Lsnabbköp/SnabbköpTillstånd;LgenerellSim/EventQueue;DLsnabbköp/händelser/övrigt/Kund;)V
 A C B generellSim/EventQueue D E addEvent (LgenerellSim/Event;)Z G )snabbköp/händelser/Stängningshändelse
  I J 4 getTidentSnabbköpetStänger
 F L   nyKund #Lsnabbköp/händelser/övrigt/Kund; nästaAnkomstTid getName ()Ljava/lang/String; S Start 
SourceFile Starthändelse.java !                	   ]     *+,)� 
*+� �                   *                               	   �     _*� � � $� &� ,Y*� � .L*� *� 1� 5I*� 9� ;Y*� *� 9(+� =� @W*� 9� FY*� *� 9*� � H� K� @W�                  '  @   ^ "         _      D M N  ' 8 O    P Q  	   -     R�           '              T    U