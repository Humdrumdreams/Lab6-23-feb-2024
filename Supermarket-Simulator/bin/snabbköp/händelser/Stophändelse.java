����   > A  "snabbköp/händelser/Stophändelse  generellSim/Event 
tillstånd Lsnabbköp/SnabbköpTillstånd; <init> ;(Lsnabbköp/SnabbköpTillstånd;LgenerellSim/EventQueue;D)V Code
     2(LgenerellSim/SimState;LgenerellSim/EventQueue;D)V	     LineNumberTable LocalVariableTable this $Lsnabbköp/händelser/Stophändelse; eQ LgenerellSim/EventQueue; timeOfEvent D executeEvent ()V
    snabbköp/SnabbköpTillstånd   stopSimulation	  !   java/lang/System " # out Ljava/io/PrintStream; % java/lang/StringBuilder ' Simuleringen stoppas vid tid 
 $ )  * (Ljava/lang/String;)V
  , - . getTimeOfEvent ()D
 $ 0 1 2 append (D)Ljava/lang/StringBuilder;
 $ 4 5 6 toString ()Ljava/lang/String;
 8 : 9 java/io/PrintStream ; * println getName > Stopp 
SourceFile Stophändelse.java !                	   ]     *+,)� 
*+� �                   *                               	   S     !*� � � � $Y&� (*� +� /� 3� 7�                        !      < 6  	   -     =�                         ?    @